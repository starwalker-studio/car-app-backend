"use strict";
var app = angular.module('fordApp', ['ngRoute',
									'ui.bootstrap',
									'login.service',
									'userAccount.service',
									'userLocal.service',
									'userUpdate.service',
									'userRegister.service',
									'userAccountRegister.service',
									'constants']);

app.controller('mainCtrl', ['$scope', 'LoginService', 'UserLocalService', function ($scope, LoginService, UserLocalService) {
		
	
	$scope.user = UserLocalService.getUserLocal();

	$scope.submitTest = function ( datosLogin ) {
		LoginService.login( datosLogin ).then(function(response){			
			console.log(response);
			if (response.status === 500) {
				Swal.fire({
					  icon: 'error',
					  title: 'Bad Connection',
					  text: 'Try again later'
					})
			} else if (response.id_user === 0) {
				Swal.fire({
					  title: 'Invalid User or Password!',
					  icon: 'warning'
					})
				
			} else if (response.id_user !== 0) {
				UserLocalService.setUserLocal(response);
				Swal.fire({
					  icon: 'success',
					  title: 'You have log in'
					}).then(() => {
						window.location = '/fordApp/';
					})
			}
		});
	}
		
	$scope.logout = ($scope.user === null) ? true : false;
	
	$scope.userExists = ($scope.user !== null) ? true : false;
	
	$scope.logOut = function () {
		UserLocalService.deleteUserLocal();
		window.location = '/fordApp/';
	}

}]);