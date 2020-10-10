app.config(['$routeProvider', '$locationProvider', function($routeProvider, $locationProvider){
	
	$locationProvider.hashPrefix('');

	$routeProvider
		.when('/',{
			templateUrl: 'resources/core/home/home.html',
			controller: 'homeCtrl'
		})
		.when('/account',{
			templateUrl: 'resources/core/user-profile/user.html',
			controller: 'userCtrl'
		})
		.when('/register',{
			templateUrl: 'resources/core/user-profile/register-user/register-user.html',
			controller: 'registerCtrl'
		})
		.otherwise({
			redirectTo: '/'
		});
	
}]);