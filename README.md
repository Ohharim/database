# 게시판 관리
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
+ reactionLike
+ reactionDislike
4. __쪽지 정보 테이블__
+ noteNUm
+ senderId
+ RecieverId
+ noteContent
+ noteDate

커뮤니티에 <mark>회원</mark>으로 가입하려면 _회원 아이디_, <u>비밀번호</u>, <u>이름</u>, <u>생년월일</u>, <u>성별</u>을 입력해야 한다.   
가입한 회원에게 <u>등급</u>이 부여된다.   
회원은 회원 아이디로 식별한다.   
회원은 게시글을 여러 개 작성할 수 있다.   
<mark>게시글</mark>은 <u>게시글의 번호</u>, <u>회원 아이디</u>, <u>제목</u>, <u>내용</u>, <u>작성일자</u>, <u>조회수</u> 정보를 유지해야 한다.   
게시글은 게시글의 번호로 식별한다.   
게시글의 <mark>반응</mark>은 <u>게시글의 번호</u>, <u>좋아요 수</u>와 <u>싫어요 수</u>를 유지해야 한다.   
회원은 한 게시글 당 한 번의 반응을 할 수 있다.   
<mark>쪽지</mark>는 <u>쪽지 번호</u>, <u>발신 아이디</u>, <u>수신 아이디</u>, <u>내용</u>, <u>날짜</u> 정보를 유지해야 한다.   
쪽지는 쪽지 번호로 식별한다.   
