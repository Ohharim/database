# 커뮤니티 관리
### 요구사항 명세서
1. 커뮤니티에 __회원__ 으로 가입하려면 _회원 아이디_, _비밀번호_, _이름_, _생년월일_, _성별_ 을 입력해야 한다.
2. 가입한 회원에게 _등급_ 이 부여된다.
3. 회원은 회원 아이디로 식별한다.
4. __게시글__ 은 _게시글의 번호_, _회원 아이디_, _제목_, _내용_, _작성일자_, _조회수_ 정보 를 유지해야 한다.
5. 게시글은 게시글의 번호로 식별한다.
6. 회원은 게시글을 여러 개 작성할 수 있다.
7. __게시글 반응__ 은 _게시글의 번호_, _좋아요 수, _싫어요 수_ 를 유지해야 한다.
8. 회원은 한 게시글 당 하나의 반응을 한 번만 할 수 있다.
9. __쪽지__ 는 _쪽지 번호_, _발신 아이디_, _수신 아이디_, _내용_, _날짜_ 정보 를 유지해야 한다.
10. 쪽지는 쪽지 번호로 식별한다.

### E-R 다이어그램
![Untitled Diagram drawio (1)](https://user-images.githubusercontent.com/81346296/169706047-492bd5c1-52ff-4192-ae27-c22928cd50e6.png)
### 물리적 스키마
![Untitled Diagram drawio (2)](https://user-images.githubusercontent.com/81346296/169706072-faf5e309-33ba-45f3-807b-4417a6287e9c.png)

### DB 설계
1. __회원 정보 테이블__
+ id
+ password
+ name
+ birth
+ gender
+ grade
2. __게시판 정보 테이블__
+ postNum
+ postId
+ postTitle
+ postContent
+ postDate
+ postView
3. __반응 정보 테이블__
+ postNum
+ reactionLike
+ reactionDislike
5. __쪽지 정보 테이블__
+ dmNum
+ senderId
+ recevierId
+ dmContent
+ dmDate

### DB 테이블 생성 스크립트
```
CREATE DATABASE whiteBoard;
USE whiteBoard;

CREATE TABLE member(
  id varchar(50) primary key,
  password varchar(50) not null,
  name varchar(20) not null,
  birth varchar(20) not null,
	gender varchar(10) not null,
	grade varchar(20) not null
);

CREATE TABLE post(
  postNum int(10) primary key auto_increment,
  postId varchar(50) not null,
  postTitle varchar(100) not null,
  postContent varchar(1000) not null,
  postDate date,
  postView varchar(20) not null,
   FOREIGN KEY (postId) REFERENCES member(id) on delete cascade
);

CREATE TABLE postReaction(
	postNum int(10)
	reactionLike int(20) not null,
	reactionDislike int(20) not null,
	FOREIGN KEY (postNum) REFERENCES post(postNum) on delete cascade
);
CREATE TABLE directMessage(
   dmNum int(10) primary key auto_increment,
   senderId varchar(50),
   receiverId varchar(50) not null,
   dmContent varchar(100) not null,
   dmDate date,
   FOREIGN KEY (receiverID) REFERENCES member(id) on delete cascade
);
```
### 릴레이션 스키마
