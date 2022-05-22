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

