# 커뮤니티 게시판 프로젝트 
---
목적 : Spring MVC 패턴과 MyBatis를 이용한 사용자들이 소통할 수 있는 게시판 생성


https://user-images.githubusercontent.com/64449625/178439018-928716d1-87d0-464c-b1b4-22b50d779ccb.mp4



## 기간
22.06.30 ~ 22.07.12

## 인원
1명

## 기술 스택
FrontEnd
- JSP, HTML, CSS, JQUERY

BackEnd
- Java, Spring Framework, MyBatis, MySql

## IDE
IntelliJ, MySql WorkBench 8.0 CE

## 구현 기능
### 로그인

  아이디 기억 여부를 선택할 수 있습니다.
  
  로그인을 하면 글쓰기 버튼이 나타나며, 사용자가 작성한 글과 댓글에 대해서 수정, 삭제 버튼이 나타납니다.

### 회원가입

  아이디 중복확인, 회원가입 조건 검사를 수행합니다.
  
  아이디 중복확인은 ajax통신으로 데이터베이스와 값을 비교하여 처리하였습니다.

### 검색

  조건을 선택하여 검색할 수 있습니다.

### 페이징

  글을 읽고 목록으로 돌아올 때에도 이전의 페이지로 돌아가도록 설계했습니다.

### 게시글 및 댓글 조회, 쓰기, 수정, 삭제 기능
 
<br>

## 기술 로그

# Test
개발과 동시에 기본적인 오류를 잡기 위해 JUnit4를 이용해 Dao와 Service 테스트를 진행하였습니다.

# ajax
Restful한 설계를 위해 게시글 수정, 삭제와 댓글 및 대댓글 조회, 쓰기, 수정, 삭제를 ajax를 사용하여 처리하였습니다.

<br>

---

## Comment
  
  게시글 수정 및 삭제를 ajax통신을 하지 않고 Restful하게 처리하려다 매핑이 안되는 상황을 마주하였고, 
  
  jsp에서는 Get과 Post방식만 지원한다는 사실을 알게되었으며 Restful한 uri를 살리고 싶어 ajax통신을 사용하기로 하였다.
  
  
  
