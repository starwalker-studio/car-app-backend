"use strict";
app.controller('userCtrl', ['$scope', function($scope){	
	
	$scope.dashBoard = true;	
	$scope.userProfile = false;	
		
	$scope.dashboardLink = function() {
		$scope.dashBoard = true;
		$scope.userProfile = false;
	}
	
	$scope.profileLink = function() {
		$scope.dashBoard = false;
		$scope.userProfile = true;
	}
		
}]);