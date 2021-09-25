<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>고객지원 insert</title>
      <link href="./resources/css/navi.css" rel="stylesheet" type="text/css" />
      <link href="./resources/css/notice/notice.css" rel="stylesheet" type="text/css" />
      <link href="./resources/css/notice/notice_insert.css" rel="stylesheet" type="text/css" />
      <link href="./resources/css/footer.css" rel="stylesheet" type="text/css" />
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
      <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
      <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
      <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>
      <script src="//cdn.ckeditor.com/4.16.2/standard/ckeditor.js"></script>
      <script src="./resources/js/notice/notice_insert.js" type="text/javascript"></script>
   </head>
   <body>
      <div class="wrapper">
         <jsp:include page="../include/header.jsp"></jsp:include>
         <main class="main item">
               <!-- 타이틀, 내용, -->
               <div class="notice">
                   <p class="not_title">고객지원</p>
                   <div class="not_inner">회원님들께서 가장 자주하시는 질문들을 모았습니다.<br>
                       궁금하신 내용에 대해 검색해보세요.</div>
               </div>
               
               <br><br>
               <h4>게시글 작성</h4>
   
               <!-- 내용 -->
               <form class="not_write_form">
                   <br>
   
                   <!-- 구분, 제목 입력란 -->
                   <table>
                       <colgroup>
                           <col width="100px">
                           <col width="500px">
                       </colgroup>
                       <tr>
                           <th>제목</th>
                           <td>
                               <input type="text" name="title" id="title" class="form-control">
                           </td>
                       </tr>
                       <tr>
                           <th>구분</th>
                           <td>
                               <select class="form-control" id="kat">
                                  <option value="1">관광정보</option>
                                   <option value="2">추천일정</option>
                                   <option value="3">나만의 일정</option>
                                   <option value="4">제주상황</option>
                               </select>
                           </td>
                       </tr>
                       <tr>
                           <th>내용</th>
                           <td>
                               <textarea rows="10" cols="60" class="form_textarea form-control content" id="editor" name="content" placeholder="내용을 입력해주세요"></textarea>
                           </td>
                       </tr>
                   </table>
   
                   <br><br>
   
                   <hr>
                   
                   <div class="form_button">
                   <button type="button" class="btn btn-primary" onclick="insert();">등록</button>
                   &nbsp;&nbsp;&nbsp;
                   <button type="button" onclick="location.href='notice_main.do'" class="btn btn-secondary">취소</button>
                   </div>
               </form>
   
               <br><br><br>
           </main>
         <jsp:include page="../include/footer.jsp"></jsp:include>
      </div>
   </body>
</html>