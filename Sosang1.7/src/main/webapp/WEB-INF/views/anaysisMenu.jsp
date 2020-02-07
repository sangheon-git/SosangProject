<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>소상공인 상권분석 시스템에 오신것을 환영합니다.</title>
</head>
<style>
.container {
	margin: 0 auto; 
	width: 1700px;
}

.middle-container {
	height: 50px;
}

ul.middle-ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #785655;
}

ul.middle-ul li {
	float: left;
}

ul.middle-ul li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

ul.middle-ul li a:hover:not(.active) {
	background-color: #f1c40f; 
	font-weight: bold; 
}

ul.middle-ul li a.active {
	background-color: #4CAF50;
}

iframe {
	width: 100%; /*iframe에 불러오는 페이지의 width는 약간 더 작아야 끝이 잘리지 않음*/
	/* overflow: visible; */
	margin: auto;
	/*height: 4600px;*/
	overflow-x:hidden;
	overflow:auto;
	min-height:1500px;
}

/* top 버튼 */
#top-btn {
    position: fixed;
    right: 30px;
    bottom: 25px;
    width: 50px;
    height: 30px;
    line-height: 30px;
    border: 1px solid #f1c40f;
    border-radius: 10px;
    text-align: center;
    background-color: #f1c40f;
    text-decoration: none;
    color: rgb(47, 33, 33);
    display: none;
    z-index: 9999;
}
#top-btn:visited {
    text-decoration: none;
    color: rgb(47, 33, 33);
}
</style>
<script type="text/javascript">

	function scrollMove() {
		document.body.scrollTop = 0;
		document.documentElement.scrollTop = 0;
	}
	
  	function resizeIframe(obj) {
	    obj.style.height = obj.contentWindow.document.documentElement.scrollHeight + 'px';
	}
	
	$(document).ready(function() {
		$(function() {
            $(window).scroll(function() {
                // 스크롤 위치에 따라서 나타나는 top 버튼
                if ($(this).scrollTop() > 500) {
                    $('#top-btn').fadeIn();
                } else {
                    $('#top-btn').fadeOut();
                }
            });
            
            // top으로 올라가는 속도 조절
            $("#top-btn").click(function() {
                $('html, body').animate({
                    scrollTop : 0
                }, 400);
                return false;
            });
        });

        // top-nav 스크롤 내리면 고정
        $(function() {
            var topOffset = $('#top-menu').offset();
           $(window).scroll(function() {
                if ($(this).scrollTop() > topOffset.top) {
                    $('#top-menu').addClass('fixed-topMenu');
                } else {
                    $('#top-menu').removeClass('fixed-topMenu');
                }
           });
        });

		
		$(".middle-li1").click(function() {
			$("#market").toggle();
		});

		$(".middle-li2").click(function() {
			$("#work").toggle();
		});

		$(".middle-li3").click(function() {
			$("#sell").toggle();
		});

		$(".middle-li4").click(function() {
			$("#person").toggle();
		});

		$(".middle-li5").click(function() {
			$("#local").toggle();
		});
	});
	
	function calcHeight(){
	 //find the height of the internal page
	
	 var the_height = document.getElementById('i_frame').contentWindow.document.body.scrollHeight;
	 console.dir("iframe의 contentWindow.scrollheight "+the_height);

	 //change the height of the iframe
	 document.getElementById('i_frame').height=the_height;
	 console.dir(document.getElementById('i_frame').height);
	 //document.getElementById('the_iframe').scrolling = "no";
	 document.getElementById('i_frame').style.overflow = "hidden";
	}
	</script>

<body>
	<div class="container">
		<img src="../resources/imgIcon/Logo.png"
			style="width: 200px; height: 100px;">
		<div class="middle-container">
			<ul class="middle-ul" role="tablist">
				<li class="middle-li1"><a href="overallAnalysis.do" target="iframe">상권평가</a></li>
				<li class="middle-li2"><a href="getStoreData.do" target="iframe">업종분석</a></li>
				<li class="middle-li3"><a href="getSalesData.do" target="iframe">매출분석</a></li>
				<li class="middle-li4"><a href="getPopData.do" target="iframe">인구분석</a></li>
				<li class="middle-li5"><a href="getIpjiData.do" target="iframe">지역분석</a></li>
				<li class="middle-li1"><a href="../home.jsp">홈으로</a></li>
			</ul>
		</div>
		<iframe src="overallAnalysis.do" name="iframe" id="i_frame" frameborder="0" scrolling="no" onload=calcHeight()></iframe>
	</div>
	
	<a href="" id="top-btn">TOP</a>
</body>
</html>