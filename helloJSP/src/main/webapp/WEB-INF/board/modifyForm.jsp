<%@page import="co.yedam.board.service.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fm" %>	
<jsp:include page="../layout/menu.jsp"></jsp:include>
<jsp:include page="../layout/header.jsp"></jsp:include>
${vo}
	<h3>게시글 수정화면</h3>
	<form action="modifyBoard.do" method="post">
	<input type="hidden" name="bno" value="${bno.boardNo }">
		<table class="table">
			<tr>
				<th>제목</th>
				<td><input type="text" class="form-control" name="title" value="${bno.title}"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" class="form-control" name="writer" value="${bno.writer}"></td>
			</tr>
			<tr>
			<th>내용</th>
				<td colspan="2"><textarea cols="40" rows="5" class="form-control" name="content">${bno.content}</textarea>
				</td>
			</tr>
			<tr>
				<th>파일명</th>
				<td><input type="file" name="image" value="${bno.image }" width="100px"></td>
			</tr>
			<tr>
				<td colspan="4" align="center">
					<input type="submit" value="수정">
					<input type="reset" value="초기화">
				</td>
			</tr>
		</table>
	</form>
<jsp:include page="../layout/footer.jsp"></jsp:include>