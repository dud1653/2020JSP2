<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 페이지</title>
</head>
<body>
	<div><button onclick="doDel(${data.i_board})">삭제</button></div>
	<a href="/boardMod?i_board=${data.i_board}"><button>수정</button></a>
	<div>상세 페이지</div>
	<div>글번호 : ${data.i_board}</div> <!-- EL 표현식 -->
	<div>제목 : ${data.title}</div> <!-- data : 키 값 -->
	<div>내용 : ${data.ctnt}</div> <!-- data.뒤에 : BoardVO에만든 게터를 가져옴 -->
	<div>작성자 : ${data.i_student}</div>
	<script>
		function doDel(i_board) {
			if(confirm("삭제 하시겠습니까?")) {
				location.href="/boardDel?i_board=" + i_board
			}			
				
		}
	</script>
</body>
</html>