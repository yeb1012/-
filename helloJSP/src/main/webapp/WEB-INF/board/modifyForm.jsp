<%@page import="co.yedam.board.service.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../layout/menu.jsp" %>
<%@include file="../layout/header.jsp" %>
<%
 BoardVO vo = (BoardVO) request.getAttribute("vo");
%>
	<h3>게시글 수정화면</h3>
	<form action="modifyBoard.do" method="post">
	<input type="hidden" name="bno" value="<%=vo.getBoardNo() %>">
		<table class="table">
			<tr>
				<th>제목</th>
				<td><input type="text" class="form-control" name="title" value="<%=vo.getTitle() %>"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" class="form-control" name="writer" value="<%=vo.getWriter() %>"></td>
			</tr>
			<tr>
			<th>내용</th>
				<td colspan="2"><textarea cols="40" rows="5" class="form-control" name="content"><%=vo.getContent() %></textarea>
				</td>
			</tr>
			<tr>
				<th>파일명</th>
				<td><input type="file" name="image" value="<%=vo.getImage() %>" width="100px"></td>
			</tr>
			<tr>
				<td colspan="4" align="center">
					<input type="submit" value="수정">
					<input type="reset" value="초기화">
				</td>
			</tr>
		</table>
	</form>
<%@include file="../layout/footer.jsp" %>