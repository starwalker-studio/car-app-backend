"use strict";
app.controller('dashboardCtrl', ['$scope', 
									'UserAccountService', 
									'UserLocalService', 
									function($scope, 
											UserAccountService,
											UserLocalService){		
	
	$scope.user = UserLocalService.getUserLocal();
		
	UserAccountService.searchAccount( $scope.user.id_user )
		.then(function(response){
			$scope.account = response;
			console.log($scope.account);
		});	
		
}]);