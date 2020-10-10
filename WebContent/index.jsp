<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html ng-app="fordApp" ng-controller="mainCtrl">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ford App</title>

<spring:url value="/resources/css/style.css" var="STYLE_CSS" />

<!-- Bootstrap 4.5 -->
<link rel="stylesheet"
	href="resources/components/boostrap/css/bootstrap.min.css">

<!-- JQuery 3 -->
<script src="resources/components/JQuery/jquery-3.3.1.min.js"></script>

<!-- Popper -->
<script src="resources/components/boostrap/js/popper.min.js"></script>

<!-- Bootstrap.js -->
<script src="resources/components/boostrap/js/bootstrap.min.js"></script>

<!-- Data Tables -->
<link rel="stylesheet" type="text/css" href="resources/components/data-table/datatables.css">
<link rel="stylesheet" type="text/css" href="resources/components/data-table/datatables.min.css">

<script type="text/javascript" charset="utf8" src="resources/components/data-table/js/datatables.js"></script>
<script type="text/javascript" charset="utf8" src="resources/components/data-table/js/datatables.min.js"></script>

<script type="text/javascript" charset="utf8" src="resources/components/JQuery/dataTables.bootstrap4.min.js"></script>
<script type="text/javascript" charset="utf8" src="resources/components/JQuery/dataTables.responsive.js"></script>

<!-- Animate css -->
<link rel="stylesheet" href="resources/components/animate-css/animate.css">

<!-- Font Awesome -->
<link rel="stylesheet" href="resources/components/font-awesome/css/font-awesome.min.css">

<!-- Nice Select -->
<link rel="stylesheet" href="resources/components/nice-select/nice-select.css">

<!-- Style css -->
<link rel="stylesheet" href="${STYLE_CSS}">

<!-- AngularJs 1.8 -->
<script src="resources/components/angularjs/angular.min.js"></script>
<script src="resources/components/angularjs/angular-route.min.js"></script>
<script src="resources/components/angularjs/ui-utils.min.js"></script>
<script src="resources/components/angularjs/ui-bootstrap-tpls-2.5.0.min.js"></script>

<!-- Sweet Alert -->
<script src="resources/components/sweet-alert/sweetalert2.all.min.js"></script>
<link rel="stylesheet" type="text/css" href="resources/components/sweet-alert/sweetalert2.min.css">

<!-- jQuery Mask -->
<script src="resources/components/JQuery/mask/jquery.mask.min.js"></script>

<!-- Core -->
<script src="resources/core/app.js"></script>
<script src="resources/core/config-route/config.js"></script>
<script src="resources/core/home/homeCtrl.js"></script>
<script src="resources/core/user-profile/userCtrl.js"></script>
<script src="resources/core/user-profile/dashboard/dashboardCtrl.js"></script>
<script src="resources/core/user-profile/edit-profile/profileCtrl.js"></script>
<script src="resources/core/user-profile/register-user/registerUserCtrl.js"></script>

<!-- Services Js -->
<script src="resources/core/services-js/loginService.js"></script>
<script src="resources/core/services-js/userAccountService.js"></script>
<script src="resources/core/services-js/userLocalService.js"></script>
<script src="resources/core/services-js/userUpdateService.js"></script>
<script src="resources/core/services-js/userRegister.js"></script>
<script src="resources/core/services-js/userAccountRegister.js"></script>

<!-- Utils -->
<script src="resources/core/utils/environment.js"></script>


</head>

<body>

	<nav class="navbar navbar-expand-lg sticky-top navbar-dark bg-dark" style="height: 50px;">
		<a class="navbar-brand" href="#"> <img
			src="resources/img/logo_nav_bar.png"
			class="img-responsive avatar-nav-logo">
		</a>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link" href="#">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Features</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#">Pricing</a></li>
				<li class="nav-item"><a class="nav-link disabled" href="#"
					tabindex="-1" aria-disabled="true">Disabled</a></li>
			</ul>

			<ul class="navbar-nav nav-log-in" ng-show="logout">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#/" id="navbarDropdown"
					role="button" data-toggle="dropdown"> <span class="fa fa-user"
						aria-hidden="true"></span> Sign in
				</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" type="button" data-toggle="modal" data-target="#loginModal">Log in</a> <a
							class="dropdown-item" href="#/register">Register</a>
						<!-- <div class="dropdown-divider"></div> -->
						<!-- <a class="dropdown-item" href="#">Something else here</a> -->
					</div></li>
			</ul>

			<ul class="navbar-nav nav-log-in" ng-show="userExists">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#/" id="navbarDropdown"
					role="button" data-toggle="dropdown"> <span class="fa fa-user"
						aria-hidden="true"></span> {{user.name}} </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="#/account">My Account</a> <a
							class="dropdown-item" href="#">My car(s)</a> <a
							class="dropdown-item" href="#">Mail</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" type="button" ng-click="logOut()">Log Out</a>
					</div></li>
			</ul>

		</div>
	</nav>
<!-- Log in Modal -->
	<div class="modal fade" tabindex="-1" role="dialog" id="loginModal"
		data-toggle="modal" data-backdrop="static" data-keyboard="false">
		<div class="modal-dialog" role="document">

			<div class="modal-content">

				<div class="modal-header">
					<h4 class="modal-title">
						Member Login <i class="fa fa-key" aria-hidden="true"></i>
					</h4>
				</div>

				<div class="modal-body">

					<form name="login">

						<div class="login-box">
							<!-- Email -->
							<div class="input-group input-group-lg">
								<div class="input-group-prepend">
									<span class="input-group-text" id="basic-addon1"><i
										class="fa fa-user" aria-hidden="true"></i></span>
								</div>
								<input
									ng-class="{'form-control is-valid' : login.mail.$valid, 
                                            'form-control' : true}"
									type="text" name="mail" ng-model="datosLogin.mail"
									placeholder="Enter your mail"
									ng-pattern="/^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$/"
									required> <a class="nav-link" ng-click="forgotLink()">
									Not a Member?</a>
							</div>
							<br>
							<!-- Password -->
							<div class="input-group input-group-lg">
								<div class="input-group-prepend">
									<span class="input-group-text"><i
										class="fa fa-unlock-alt" aria-hidden="true"></i></span>
								</div>
								<input
									ng-class="{'form-control is-valid' : login.password.$valid, 
                                            'form-control' : true}"
									type="password" name="password" ng-model="datosLogin.password"
									placeholder="Enter your password"
									ng-pattern="/^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/" required>
								<a class="nav-link" ng-click="forgotLink()"> Forgot
									Password?</a>
							</div>

						</div>

					</form>
				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-primary" type="submit"
						ng-click="submitTest( datosLogin )"
						ng-disabled="!login.mail.$valid || !login.password.$valid">Enter</button>
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</div>

			</div>
		</div>
	</div>

	<!-- Contenido de la página -->

	<div class="main-content" ng-view></div>

	<!-- Contenido de la página -->

	<!-- <footer>
    <nav class="footer">
      <a>Copyright 2020</a>
    </nav>
  </footer> -->

</body>

</html>