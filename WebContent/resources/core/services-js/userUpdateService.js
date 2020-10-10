var app = angular.module('userUpdate.service', []);

app.service('UserUpdateService', ['$http', 'environment', function ($http, environment) {
    	
	return {
		
		update: function ( userProfile ) {			
			return $http.post( environment.URL_BACKEND + environment.user.updateUser, userProfile)
			.then(function(response){			 			
				return response.data;				 			
			}).catch(function (response) {			
				return response;			
			});    
		}
		
	};
	

}])