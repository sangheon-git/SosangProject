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
<title>마이페이지</title>
<link rel="stylesheet" href="../resources/css/mypageStyle.css">
<script type="text/javascript" src="../resources/js/jquery-3.4.1.js"></script>
<script type="text/javascript">
	window.onload=function(){
		
		var id = "<%=(String)session.getAttribute("id")%>"
		var cancelBtn=document.getElementById('cancel');
		
		cancelBtn.onclick=function(){
			var res_confirm = confirm("탈퇴하시겠습니까? 탈퇴 시 데이터가 영구 삭제됩니다.");
				if(res_confirm == true) {
					window.location.href = 'deleteMember.do';
				} else {
					window.location.href = 'mypage.do';
				}
			}
		}
   	</script>

</head>
<style>
#homebtn {
	position: absolute;
	bottom: 2%;
	right: 2%;
	background-color: rgb(47, 33, 33);
	color: #fff;
	width: 70px;
	height: 30px;
	line-height: 30px;
	text-align: center;
	border-radius: 10px;
}

#homebtn:link {
	color: #fff;
}

#homebtn:visited {
	color: #fff;
}
</style>
<body>


	<div id="wrapper">
		<h2>마이페이지</h2>

		<table>
			<tr>
				<th>
					<button id="myInfo" onClick="location.href='myinfo.do'">
						<img src="../resources/images/myinfo.png"><br>나의 정보 보기
					</button>
				</th>
				<th>
					<button id="changeInfo" onClick="location.href='checkPassword.do'">
						<img src="../resources/images/change.png"><br>정보 수정 하기
					</button>
				</th>
				<th rowspan="2">
					<button id="history" onClick="location.href='showList.do'">
						<img src="../resources/images/search.png" style="width: 200px; height: 200px;"><br>검색 기록보기
					</button>
				</th>
			</tr>
			<tr>
				<th>
					<button type="button" id="cancel">
							<img src="../resources/images/cancel.png" style="width: 100px; height: 100px;"><br> 탈퇴하기
					</button>
				</th>
				<th>
					<button id="logout" onClick="location.href='logout.do'">
						<img src="../resources/images/logout.png"><br>로그아웃
					</button>
				</th>
			</tr>
		</table>
	</div>
	<a href="../home.jsp" id="homebtn">HOME</a>

</body>
</html>

<% } %>