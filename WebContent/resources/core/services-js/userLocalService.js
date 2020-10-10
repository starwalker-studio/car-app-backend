var app = angular.module('userLocal.service', []);

app.service('UserLocalService', [function () {
    	
	const USER = 'user';
	
	var context = this;
	
	context.setUserLocal = function ( logResponse ) {
		return localStorage.setItem(USER, JSON.stringify(logResponse));
	}
	
	context.getUserLocal = function () {
		return JSON.parse(localStorage.getItem(USER));
	}
	
	context.deleteUserLocal = function () {
		return localStorage.clear();
	}
	
	return context;
	

}])