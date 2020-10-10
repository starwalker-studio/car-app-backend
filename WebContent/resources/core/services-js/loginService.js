var app = angular.module('login.service', []);

app.service('LoginService', ['$http', 'environment', function ($http, environment) {
    	
	return {
		
		login: function ( datosLogin ) {			
			return $http.post( environment.URL_BACKEND + environment.user.userLogin, datosLogin)
			.then(function(response){			 			
				return response.data;				 			
			}).catch(function (response) {			
				return response;			
			});    
		}
		
	};
	

}])