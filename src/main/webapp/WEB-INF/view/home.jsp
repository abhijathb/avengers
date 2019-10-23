<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!doctype html>
<html lang="en">

<head>

<title>S.H.I.E.L.D.</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- 

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>
<script>
	function getCountryDetails(code) {
		document.getElementById('countryDetails').innerHTML = code;
		$.ajax($('#contextPath').val()+'/api/user/'+code,   // request url
			    {
			        success: function (data, status, xhr) {// success callback function
			            $('#countryDetails').val(data);
			            document.getElementById('countryDetails').innerHTML = JSON.stringify(data);
			    }
			});
	}
</script>
<style>
.slider {
	height: 400px;
	width: 100%;
}
/* 
#logo {
  img: #ccc;
  width: 150px;
  height: 70px;
} */
.navbar-toggler {
	margin-top: 5px;
}

@media screen and (min-width: 992px) {
	.navbar {
		height: 130px;
		background: #123; /*#6080af;*/
	}
	#logo {
		/*   width: 260px;
    height: 120px; */
		position: relative;
		bottom: -20px;
	}
	.navbar-light .navbar-nav .nav-link {
		padding-right: 75px;
	}
	#nav-left {
		padding-left: 30px;
	}
}

th, td {
	padding: 0 5px;
}

#contentContainer{
padding: 30px 50px;
}
</style>
</head>

<body>

	<nav class="navbar navbar-toggleable-md navbar-light bg-faded">
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navbarMobile"
			aria-controls="navbarMobile" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<!-- <div class="collapse navbar-collapse" id="nav-left">
      <ul class="nav navbar-nav">
          <li class="nav-item">
              <a class="nav-link" href="#">Link</a>
          </li>
          <li class="nav-item">
              <a class="nav-link" href="#">Link</a>
          </li>
          <li class="nav-item">
              <a class="nav-link" href="#">Link</a>
          </li>
      </ul>
    </div> -->

		<a class="navbar-brand mx-auto" href="#"> <!-- <div id="logo"></div> -->
			<img id="logo" src="${pageContext.request.contextPath}/img/logo.png"
			alt="" width="72" height="72">
		</a>

		<!--  <div class="collapse navbar-collapse">
      <ul class="nav navbar-nav ml-auto">
          <li class="nav-item">
              <a class="nav-link" href="#">Link</a>
          </li>
        <li class="nav-item">
              <a class="nav-link" href="#">Link</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">Link</a>
        </li>
      </ul>
    </div> -->

		<!-- Mobile -->
		<!--  <div class="collapse" id="navbarMobile">
        <ul class="nav navbar-nav">
          <li class="nav-item">
              <a class="nav-link" href="#">Mobile Link</a>
          </li>
          <li class="nav-item">
                <a class="nav-link" href="#">Mobile Link</a>
          </li>
          <li class="nav-item">
              <a class="nav-link" href="#">Mobile Link</a>
          </li>
          <li class="nav-item">
              <a class="nav-link" href="#">Mobile Link</a>
          </li>
          <li class="nav-item">
                <a class="nav-link" href="#">Mobile Link</a>
          </li>
          <li class="nav-item">
              <a class="nav-link" href="#">Mobile Link</a>
          </li>
        </ul>
    </div> -->
	</nav>
	<!-- <div class="slider">
</div> -->

<div id="contentContainer">
	<h3>Hello,
		${fn:toUpperCase(username)} ! Know more about the country before
		saving them...</h3>
	<hr>
	<c:forEach items="${countryList}" var="cty">
		<button type="button" class="btn"
			style="background: #123; color: white"
			onclick="getCountryDetails('${cty.code}')">${cty.name}</button>
	</c:forEach>

	<div id="countryDetails" style="width:900px;height:200px;overflow:auto;"></div>
	<hr>
	<div id="chatMessages">
		<table>
			<tr>
				<th>Time</th>
				<th>From</th>
				<th>Message</th>
			</tr>
			<c:forEach items="${messageList}" var="msg">
				<tr>
					<td>${msg.loggedtime}</td>
					<td>${fn:toUpperCase(msg.from_user.username)}</td>
					<td>${msg.message}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<input id="contextPath" type="hidden" value="${pageContext.request.contextPath}"/>
</div>
</body>
</html>