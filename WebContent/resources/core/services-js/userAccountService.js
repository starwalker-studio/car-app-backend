var app = angular.module('userAccount.service', []);

app.service('UserAccountService', ['$http', 'environment', function ($http, environment) {
    	
	return {
		
		searchAccount: function ( id ) {			
			return $http.get(environment.URL_BACKEND + environment.user.searchAccount + id)
			.then(function(response){			 			
				return response.data;				 			
			}).catch(function (response) {			
				return response;			
			});    
		}
	
	};
	

}])