<%@page import="co.yedam.board.service.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../layout/menu.jsp" %>
<%@include file="../layout/header.jsp" %>

	<h3>게시판 목록</h3>
	<%
	List<BoardVO> list = (List<BoardVO>) request.getAttribute("list");
	%>
	<table class="table">
		<thead>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일시</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (BoardVO vo : list) {
			%>
			<tr>
				<td><%=vo.getBoardNo()%></td>
				<td><a href="getBoard.do?bno=<%=vo.getBoardNo()%>"><%=vo.getTitle()%></a></td>
				<%if(vo.getWriter().equals("M001")){%>
				<td style="color:red">관리자</td>
				<%}else{ %>
				<td><%=vo.getWriter()%></td>
				<%} %>
				<td><%=vo.getLastUpdate()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<p><a href="boardForm.do">등록하기</a></p>
<%@include file="../layout/footer.jsp" %>