# HW5(week11)
## Welcome to POST CRUD Application 👑

> **Post CRUD** This is a simple CRUD application for managing Post.

<hr>

### 🚀 기능 소개(with Swagger)


### 1. LoginForm

- **설명:** Security 설정을 해주고 LoginForm을 통해 구글 로그인에 들어갑니다..<br>
- **결과 화면:<br>**
<p>
<img src="https://github.com/4th-PARD-SERVER-PART/LeeSuin/blob/main/hw5/src/main/java/com/example/hw5/img/loginForm.png" width = 80%><br>
</p>
<hr>


### 2. Google Cloud => OAuth 2.0 LOgin 구현

- **설명:** Google Cloud에서 새로운 프로젝트를 생성하고 OAuth 클라이언트 ID를 생성합니다.<br>
- **결과 화면:<br>**
<p>
<img src="https://github.com/4th-PARD-SERVER-PART/LeeSuin/blob/main/hw5/src/main/java/com/example/hw5/img/googleCloud.png" width = 80%><br>
</p>
<hr>

### 3. 로그인 user 정보 디비에 저장

- **설명:** 이미 User정보가 존재하는지 findByEmail을 통해 찾아보고 없을 경우 새로 디비에 저장합니다.<br>
- **사용법:** 로그인을 하면 사용자의 정보가 저장됩니다. <br>
- **결과 화면:<br>**
<p>
로그인 화면<br>
<img src="https://github.com/4th-PARD-SERVER-PART/LeeSuin/blob/main/hw5/src/main/java/com/example/hw5/img/GoogleLogin.png" width = 80%><br>
INFO 화면<br>
<img src="https://github.com/4th-PARD-SERVER-PART/LeeSuin/blob/main/hw5/src/main/java/com/example/hw5/img/Info.png" width = 80%><br>
database 화면<br>
<img src="https://github.com/4th-PARD-SERVER-PART/LeeSuin/blob/main/hw5/src/main/java/com/example/hw5/img/Database.png" width = 80%><br>

</p>
<hr>

### 4. Add User

- **설명:** 게시판을 추가하기 앞서 User 사용자의 이름을 등록합니다.<br>
- **사용법:** 사용자의 이름 입력합니다. <br>
- **결과 화면:<br>**
<p>
<img src="https://github.com/4th-PARD-SERVER-PART/LeeSuin/blob/main/hw4/src/main/java/com/example/hw4/img/add_user.png" width = 80%><br>
</p>
<hr>

### 5. Create Post By UserId

- **설명:** 생성한 UserId 중 특정 ID를 선택하여 게시판을 생성합니다.<br>
- **사용법:** 사용자의 Id를 선택한 후 게시판의 title과 content를 입력합니다.<br>
- **결과 화면:<br>**
<p>
<img src="https://github.com/4th-PARD-SERVER-PART/LeeSuin/blob/main/hw4/src/main/java/com/example/hw4/img/create_post_userId.png" width = 80%><br>
</p>
<hr>

### 6. Read By User Id

- **설명:** 저장된 게시판을 User ID 정보에 구분하여 조회합니다.<br>
- **사용법:** UserId를 입력하여 해당 User가 작성한 게시판의 정보를 조회합니다.<br>
- **결과 화면:**<br>
  <img src="https://github.com/4th-PARD-SERVER-PART/LeeSuin/blob/main/hw4/src/main/java/com/example/hw4/img/read_by_userId.png" width = 80%><br>
<hr>

### 7. Update By Id (UPDATE)

- **설명:** Post Id를 사용하여 특정 게시판의 정보를 수정합니다. <br>
- **사용법:** 수정할 게시판의 ID와 새로운 정보를 입력하여 업데이트합니다.<br>
- **결과 화면:**<br>
  <p>
  <img src="https://github.com/4th-PARD-SERVER-PART/LeeSuin/blob/main/hw4/src/main/java/com/example/hw4/img/update_post.png" width = 80%>
<hr>

### 8. Delete By Post Id (DELETE POST)

- **설명:** 특정 ID를 가진 게시판을 삭제합니다.
- **사용법:** 삭제할 게시판의 postId를 입력하여 해당 게시판을 삭제합니다.
    - **결과 화면:**<br>
      <img src="https://github.com/4th-PARD-SERVER-PART/LeeSuin/blob/main/hw4/src/main/java/com/example/hw4/img/delete_post.png" width = 80%>
<hr>

### 9. Get User
- **설명:** userId를 사용하여 해당 User을 읽어옵니다.
- **결과 화면:**<br>
  <img src="https://github.com/4th-PARD-SERVER-PART/LeeSuin/blob/main/hw4/src/main/java/com/example/hw4/img/get_user.png" width = 80%>
  <br><hr>
- 
### 10. Delete User (DELETE USER)
- **설명:** userId를 사용하여 User을 삭제합니다.
- **결과 화면:**<br>
      <img src="https://github.com/4th-PARD-SERVER-PART/LeeSuin/blob/main/hw4/src/main/java/com/example/hw4/img/delete_user.png" width = 80%>
<br><hr>
### 11. 좋아요 기능
- **설명:** 게시판은 좋아요의 개수 정보, User는 좋아요를 누른 게시판에 대한 정보를 알고 있어야합니다. 
- **사용법:** 좋아요를 누를 게시판과 나 자신이 누구인지 User정보를 선택한 후 like toggle 함수를 실행시킵니다. 한번 더 실행할 경우 개수가 늘어나지 않고 좋아요가 취소됩니다.
- **결과 화면:**<br>
  <img src="https://github.com/4th-PARD-SERVER-PART/LeeSuin/blob/main/hw4/src/main/java/com/example/hw4/img/like_post.png" width = 80%>
  <img src="https://github.com/4th-PARD-SERVER-PART/LeeSuin/blob/main/hw4/src/main/java/com/example/hw4/img/like_status.png" width = 80%><br>
<br><hr>
