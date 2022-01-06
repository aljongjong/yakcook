<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 수정 실패 페이지</title>
<script src="https://kit.fontawesome.com/77be500183.js" crossorigin="anonymous"></script>
<style>
	*
	{
		color: gainsboro;
	}
	div
	{
		width: 1200px; 
		height: 600px; 
		margin: auto;  
		position: relative;
		overflow: hidden;
	}
	h1
	{
		font-size: 6em; 
		padding: 50px; 
		margin: 0; 
		position: absolute; 
		top: 10%; 
		left: 4%;
	}
	a
	{
		position: absolute; 
		bottom: 30%; 
		left: 38%; 
		font-size: 5em;
		text-decoration: none;
	}
	a:hover
	{
		color: gray;
	}
	i
	{
		font-size: 4em;
		position: absolute;
		z-index: 1000;
	}
	.fa-snowboarding
	{
		position: absolute;
		bottom: 0%;
		transform: translateX(-60px);
		animation: animate4 infinite linear 6s;
	}
	#wind1
	{
		transform: translate(200px, -100px);
		animation: animate1 infinite linear 4s;
	}
	#wind2
	{
		transform: translate(500px, -100px);
		animation: animate2 infinite linear 7s;
	}
	#wind3
	{
		transform: translate(900px, -100px);
		animation: animate3 infinite linear 6s;
		transform: rotateY(180deg);
	}
	@keyframes animate1
	{
		0%
		{
			transform: translate(200px, -100px);
		}	
		100%
		{
			transform: translate(200px, 1000px);
		}	
	}
	@keyframes animate2
	{
		0%
		{
			transform: translate(500px, -100px);
		}	
		100%
		{
			transform: translate(500px, 1000px);
		}	
	}
	@keyframes animate3
	{
		0%
		{
			transform: translate(900px, -100px);
		}	
		100%
		{
			transform: translate(900px, 1000px);
		}	
	}
	@keyframes animate4
	{
		0%
		{
			transform: translateX(-60px);
		}	
		100%
		{
			transform: translateX(1260px);
		}	
	}

</style>
</head>
<body>
	<div>
		<h1>${msg}</h1>
		<a href="manageProduct">돌아가기</a>

		<i class="far fa-snowflake" id="wind1"></i>
		<i class="far fa-snowflake" id="wind2"></i>
		<i class="far fa-snowflake" id="wind3"></i>
		<i class="fas fa-snowboarding"></i>
	</div>
</body>
</html>