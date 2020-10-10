"use strict";
app.controller('registerCtrl', ['$scope', 
								'UserRegisterService',
								'UserRegisterAccountService',
								'UserLocalService',
								function($scope, 
										UserRegisterService,
										UserRegisterAccountService,
										UserLocalService){
	
	$scope.register = {
			userCategory: {
				id_user_category: 2
			}
	};
	
	$scope.account = {
			iduser: 0,
			card_register: "true",
			car_selection: "false",
			card_number: 0
	};
	
	$scope.checkActivate = false;
	
	$scope.registerUser = function ( register ) {
		
		if (register.name === undefined || register.last_name === undefined) {
			console.log('No hay nomabre y apellidos');
			Swal.fire({
				  title: 'Fill name and last name!',
				  icon: 'info'
				})
		} else if ($scope.checkActivate) {
			Swal.fire({
				  title: 'Do you want to save?',
				  showDenyButton: true,
				  showCancelButton: true,
				  confirmButtonText: `Save`,
				  denyButtonText: `Don't save`,
				}).then((result) => {
				  if (result.isConfirmed) {
					  if ($scope.register.phone !== undefined) {
						  unmaskNumber();						  
					  } else {
						  $scope.register.phone = '0'; 
					  }
					  unmaskCard();
					  UserRegisterService.registerUser( register ).then(function(responseRegister){
							console.log(responseRegister);
							if (responseRegister.status === 500) {
								Swal.fire({
									  icon: 'error',
									  title: 'Bad Connection',
									  text: 'Try again later'
									})
							} else {	
								console.log(responseRegister.id_user);
								$scope.account.iduser = responseRegister.id_user;
								$scope.account.card_number = register.cardnumber;
								UserRegisterAccountService.registerAccount( $scope.account ).then(function(responseAccount){
									if (responseAccount.status === 500) {
										Swal.fire({
											  icon: 'error',
											  title: 'Bad Connection',
											  text: 'Try again later'
											})
									} else {
										Swal.fire({
											  icon: 'success',
											  title: 'Register Success!'
											}).then(() => {
												UserLocalService.setUserLocal(responseRegister);
												window.location = '/fordApp/';
											})
									}
								});
							}
						
						});
				  } else if (result.isDenied) {
					  document.getElementById('reset').click();
				  }
				})
			
		} else {
			Swal.fire({
				  title: 'Do you want to save?',
				  showDenyButton: true,
				  showCancelButton: true,
				  confirmButtonText: `Save`,
				  denyButtonText: `Don't save`,
				}).then((result) => {
				  if (result.isConfirmed) {
					  if ($scope.register.phone !== undefined) {
						  unmaskNumber();						  
					  } else {
						  $scope.register.phone = '0'; 
					  }
					  UserRegisterService.registerUser( register ).then(function(response){
							console.log(response);
							if (response.status === 500) {
								Swal.fire({
									  icon: 'error',
									  title: 'Bad Connection',
									  text: 'Try again later'
									})
							} else if (response.id_user === 0) {
								Swal.fire({
									  title: 'Invalid Mail or Password!',
									  text: 'Your mail or password exists!. Try again',
									  icon: 'warning'
									})
							} else {
								Swal.fire({
									  icon: 'success',
									  title: 'Register Success!'
									}).then(() => {
										UserLocalService.setUserLocal(response);
										window.location = '/fordApp/';
									})
							}						
						});
				  } else if (result.isDenied) {
					  document.getElementById('reset').click();
				  }
				})
		}
	}
	
	$scope.resetValues = function() {
		reset();
	}
	
	function unmaskNumber() {
		var unmaskNumber = $scope.register.phone;
		var setNumber = unmaskNumber.toString().replace(/[^\d]/g, "");
		$scope.register.phone = parseInt(setNumber);
	}
	
	function unmaskCard() {
		var unmaskNumber = $scope.register.cardnumber;
		var setNumber = unmaskNumber.toString().replace(/[^\d]/g, "");
		$scope.register.cardnumber = parseInt(setNumber);
	}
	
	function reset() {
		$scope.register.name = '';
		$scope.register.direction = '';
		$scope.register.profesion = '';
		$scope.register.newPassword = '';
		$scope.register.last_name = '';
		$scope.register.phone = '';
		$scope.register.mail = '';
		$scope.register.password = '';
		$scope.register.cardnumber = '';
		$scope.checkActivate = false;
	}
	
}]);