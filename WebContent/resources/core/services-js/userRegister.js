var app = angular.module('userRegister.service', []);

app.service('UserRegisterService', ['$http', 'environment', function ($http, environment) {
    	
	return {
		
		registerUser: function ( userRegister ) {			
			return $http.post( environment.URL_BACKEND + environment.user.registerUser, userRegister)
			.then(function(response){			 			
				return response.data;				 			
			}).catch(function (response) {			
				return response;			
			});    
		}
		
	};
	

}])