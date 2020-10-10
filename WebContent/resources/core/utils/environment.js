angular.module('constants', []).constant('environment', {
    URL_BACKEND: 'http://localhost:8080/fordApp/auth',
    user: {
    	userLogin: '/api/logIn',
    	searchAccount: '/api/searchUserAccount/',
    	updateUser: '/api/updateUser',
    	registerUser: '/api/registerUser',
    	registerAccount: '/api/registerAccountUser'
    }
});