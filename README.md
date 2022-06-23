# 영화 예매
- - -
> ## 요구사항 명세서

1. __회원__ 으로 가입하려면 ___회원 아이디___, _비밀번호, 이름, 전화번호_ 를 입력해야 한다.
2. 회원은 회원 아이디로 식별한다.
3. __영화__ 는 ___영화 번호___, _영화 제목, 장르_ 정보 를 유지해야 한다.
4. 영화는 영화 번호로 식별한다.
5. __상영관__ 은 ___지역, 상영관 번호, 좌석 번호, 상영 시간___ 정보를 유지해야 한다.
6. 회원은 상영관을 >예약< 할 수 있다.
7. 영화는 상영관에서 여러 번 >상영<되고 상영관에서 여러 영화가 >상영<된다.
8. __리뷰__ 는 ___리뷰 번호___, _리뷰 내용_ 정보를 유지해야 한다. 
9. 리뷰는 리뷰 번호로 식별한다.
10. 영화는 여러 개의 리뷰로 >평가<된다.
11. 회원은 여러 개의 리뷰를 >작성<할 수 있다.
12. 리뷰의 __리액션__ 은 ___리액션 번호___, _좋아요, 싫어요_ 정보를 유지해야 한다.
13. 리뷰는 리액션의 좋아요와 싫어요로 >반응<할 수 있다.

- - - 

> ## E-R 다이어그램
![erd](https://user-images.githubusercontent.com/81346296/175243766-35583f14-d037-4cc0-9a96-8f54f80c10c9.png)

- - -

> ## 물리적 스키마

![image](https://user-images.githubusercontent.com/81346296/175243970-eaacbb28-2346-4998-a556-06b3cc395d26.png)

- - -

> ## DB 설계
1. __회원 정보 테이블__
+ memberID
+ password
+ name
+ phoneNum
2. __영화 정보 테이블__
+ movieNum
+ Title
+ genre
3. __상영관 정보 테이블__
+ theaterNum	
+ seatNum
+ Location
+ time
+ memberID
5. __상영 정보 테이블__
+ theaterNum	
+ seatNum
+ Location
+ time
+ movieNum
6. __리뷰 정보 테이블__
+ reviewNum
+ rvContent
+ movieNum
+ memberID
7. __반응 정보 테이블__
+ reactNum
+ like
+ dislike
+ reviewNum

- - -

> ## DB 테이블 생성 스크립트
```
create table member
( member_id varchar(5),
  pw varchar(7),
  name nvarchar(15),
  phone_num varchar(11),

  primary key(member_id)
)

create table cinema
( Theater_num varchar(5),
  seat_num varchar(5),
  location nvarchar(5),
  Time varchar(10),
  member_id varchar(5),

  primary key(Theater_num,seat_num,location,Time),
  foreign key (member_id) REFERENCES member(member_id) on delete cascade
)

create table movie
( movie_num varchar(5),
  title nvarchar(20),
  genre nvarchar(10),

  primary key (movie_num)
)



create table review
( review_num varchar(5),

  movie_num varchar(5),
  member_id varchar(5),

  Rv_content nvarchar(30) not null,

  primary key (review_num),
  FOREIGN key (movie_num) REFERENCES movie(movie_num) on delete cascade,
  FOREIGN key (member_id) REFERENCES member(member_id) on delete cascade
)


create table show
( Theater_num varchar(5),
  seat_num varchar(5),
  location nvarchar(5),

  movie_num varchar(5),
  Time varchar(10),

  primary key(Theater_num,seat_num,location,movie_num,Time),
  foreign key(Theater_num,seat_num,location,Time) references cinema(Theater_num,seat_num,location,Time) on delete cascade,
  foreign key(movie_num) references movie(movie_num) on delete cascade
)

create table reaction
( reaction_num varchar(5),
  review_num varchar(5),
  Like_ NUMERIC(1,0) not null,
  DisLike_ NUMERIC(1,0) not null,

  PRIMARY key(reaction_num),
  FOREIGN key (review_num) REFERENCES review(review_num) on delete cascade

)
```

