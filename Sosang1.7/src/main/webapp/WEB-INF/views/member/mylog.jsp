<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String id = (String) session.getAttribute("id");
	if(id == null) {
		response.sendRedirect("../home.jsp");
	} else {
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>나의 검색 기록 보기</title>
    <link rel="stylesheet" href="../resources/css/mylogList.css">
    <script>
		function deleteLog(idx) {
			var delete_confirm = confirm("삭제하시겠습니까?");
			if(delete_confirm == true) {
				window.location.href = 'deleteLog.do?idx=' + idx;
			} else {
				window.location.href = 'showList.do';
			}
		}
    </script>
	<style>
		#homeBtn,
		#mypageBtn,
		#deleteLog {
			cursor: pointer;
		}
	</style> 
</head>
<body>
	<div class="wrapper-set">
		<div class="wrapper">
			<h2>${id}님의 검색이력 </h2>
			<hr>
			
			<br>
			<span style="float: right;">* 최근 10개 항목만 표시됩니다.</span>
			<table class="table" align="center" >
				<thead class="thead">
					<tr class="table_col">
						<th class="num">번호</th>
						<th class="search_date">검색 날짜</th>
						<th class="area">지역/동 이름</th>
						<th class="food">외식업종</th>
						<th class="show">기록보기</th>
						<th class="delete">삭제</th>
					</tr>
				</thead>
				<tbody class="list_data">
					<c:forEach items="${list}" var="list" varStatus="status" begin="0" end="9">
						<tr>
							<td>${status.count}</td>
							<td>${list.search_date}</td>
							<td>${list.area}</td>
							<td>${list.food}</td>
							<td>
								<a href="../analysis/myLogData.do?area=${list.area}&food=${list.food}&id=<%=id %>"> 보기</a>
							</td>
							<td>
								<input type="button" id="deleteLog" value="삭제" onclick="deleteLog(${list.idx})">
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br>
			<div class="btns">
				<input type="button" id="homeBtn" value="Home" onclick="location.href='../home.jsp'">
				<input type="button" id="mypageBtn" value="My Page" onclick="location.href='mypage.do'">
			</div>
		</div>
	</div>
</body>
</html>

<% } %>