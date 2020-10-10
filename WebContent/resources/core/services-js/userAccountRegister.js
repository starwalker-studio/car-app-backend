var app = angular.module('userAccountRegister.service', []);

app.service('UserRegisterAccountService', ['$http', 'environment', function ($http, environment) {
	
	return {
		
		registerAccount: function ( accountRegister ) {			
			return $http.post( environment.URL_BACKEND + environment.user.registerAccount, accountRegister)
			.then(function(response){			 			
				return response.data;				 			
			}).catch(function (response) {			
				return response;			
			});    
		}
	
	};
	
	
}])