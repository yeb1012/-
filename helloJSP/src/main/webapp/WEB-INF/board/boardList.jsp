
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fm" %>	
<jsp:include page="../layout/menu.jsp"></jsp:include>
<jsp:include page="../layout/header.jsp"></jsp:include>
	

<h3>게시판 목록</h3>
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
			<c:forEach items="${list }" var="board">
			<tr>
				<td>${board.boardNo}</td>
				<td><a href="getBoard.do?bno=${board.boardNo}">${board.title}</a></td>
				<td>${board.writer}</td>
				<td><fm:formatDate value="${board.lastUpdate}" pattern="yyyy-MM-dd HH:mm:ss"></fm:formatDate></td>
			</tr>
			</c:forEach>
			
			
		</tbody>
	</table>
	<p><a href="boardForm.do">등록하기</a></p>
<jsp:include page="../layout/footer.jsp"></jsp:include>