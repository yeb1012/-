<%@page import="co.yedam.board.service.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fm" %>	
<jsp:include page="../layout/menu.jsp"></jsp:include>
<jsp:include page="../layout/header.jsp"></jsp:include>
	<h3>게시글 삭제화면</h3>
	<form action="removeBoard.do" method="post">
		<input type="hidden" name="bno" value="${vo.boardNo }">
		<table border="1">
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" value="${vo.title}"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer"
					value="${vo.writer }"></td>
			</tr>
			<tr>
				<td colspan="2"><textarea cols="40" rows="5" name="content">${vo.content}</textarea>
				</td>
			</tr>
			<tr>
				<th>파일명</th>
				<td><img src="images/${vo.image}" width="100px"></td>
			</tr>
			<tr>
				<td colspan="4" align="center">
					<input type="submit" value="삭제">
					<input type="reset" value="초기화">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>