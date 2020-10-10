app.controller('homeCtrl', ['$scope', 
							'$http',
							'$q', '$rootScope',
							function($scope, $http,
									$q, $rootScope){
	
	   
	 $scope.slides = [
	    {
	      image: 'resources/img/ford-mustang.png',
	      info : 'The time to run is now',
	      link : 1
	    },
	    {
	      image: 'resources/img/ford-raptor.png',
	      info : 'Travel the world to the wild places',
	      link : 2
	    },
	    {
	      image: 'resources/img/ford-ecosport.png',
	      info : 'Rule the streets on this safe motor',
	      link : 3
	    }
	  ];
	 
	 $scope.listPerformance = []; 
	 $scope.listSpecs = [];
	
	
	
}]);