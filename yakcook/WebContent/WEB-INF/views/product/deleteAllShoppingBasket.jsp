<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>빈 장바구니 페이지</title>
<script src="https://kit.fontawesome.com/77be500183.js" crossorigin="anonymous"></script>
</head>
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
		font-size: 7em; 
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
	.fa-skating
	{
		position: absolute;
		bottom: 0%;
		transform: translateX(-60px);
		animation: animate4 infinite linear 6s;
	}
	#wind1
	{
		transform: translate(-100px, -100px);
		animation: animate1 infinite linear 2s;
	}
	#wind2
	{
		transform: translate(-100px, 50px);
		animation: animate2 infinite linear 4s;
	}
	#wind3
	{
		transform: translate(1300px, -100px);
		animation: animate3 infinite linear 3.5s;
		transform: rotateY(180deg);
	}
	@keyframes animate1
	{
		0%
		{
			transform: translate(-100px, -100px);
		}	
		100%
		{
			transform: translate(500px, 500px);
		}	
	}
	@keyframes animate2
	{
		0%
		{
			transform: translate(-100px, 50px);
		}	
		100%
		{
			transform: translate(1300px, 400px);
		}	
	}
	@keyframes animate3
	{
		0%
		{
			transform: translate(1300px, -100px) rotateY(180deg);
		}	
		100%
		{
			transform: translate(-100px, 600px) scale(2) rotateY(180deg);
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
<body>
	<div>
		<h1>${msg}</h1>
		<a href="searchProduct">돌아가기</a>

		<i class="fas fa-wind" id="wind1"></i>
		<i class="fas fa-wind" id="wind2"></i>
		<i class="fas fa-wind" id="wind3"></i>
		<i class="fas fa-skating"></i>
	</div>
</body>
</html>