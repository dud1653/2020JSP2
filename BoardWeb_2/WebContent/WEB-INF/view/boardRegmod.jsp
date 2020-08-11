<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<style>
	.err {
		color : #e74c3c;
	}
</style>
</head>
<body>
	<div class="err">${msg}</div>
	<form id="frm" action="/boardWrite" method="post" onsubmit="return chk()">
		<div><label>제목 : <input type="text" name="title" id="title"></label></div>
		<div><label>내용 : <textarea name="ctnt" id="ctnt"></textarea> </label></div>
		<div><label>작성자 : <input type="text" name="i_student" id="i_student"></label></div>
		<div><input type="submit" value="글등록"></div>
	</form>
	
	<script>
		function eleValid(ele, nm) {
			if(ele.value.length == 0) {
				alert(nm + "을(를) 입력해 주세요.");
				ele.focus();
				return true
			} 
		}
		function chk() {
			if(eleValid(frm.title, '제목')){
				return false
			} else if(eleValid(frm.ctnt, '내용')) {
				return false
			} else if(eleValid(frm.i_student, '작성자')) {
				return false
			}
		}
	</script>
</body>
</html>