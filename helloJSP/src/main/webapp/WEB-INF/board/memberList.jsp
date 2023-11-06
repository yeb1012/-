<%@page import="co.yedam.board.service.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../layout/menu.jsp" %>
<%@include file="../layout/header.jsp" %>

<h3>회원 목록</h3>
	<%
	List<MemberVO> list = (List<MemberVO>) request.getAttribute("list");
	%>
	<table class="table">
		<thead>
			<tr>
				<th>회원 아이디</th>
				<th>회원 비밀번호</th>
				<th>회원 이름</th>
				<th>회원 전화번호</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (MemberVO vo : list) {
			%>
			<tr>
				<td><%=vo.getMid()%></td>
				<td><%=vo.getPass()%></td>
				<td><%=vo.getName()%></td>
				<td><%=vo.getPhone()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>

<%@include file="../layout/footer.jsp" %>