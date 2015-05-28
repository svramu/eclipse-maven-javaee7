(function() {
  var app = angular.module('myapp', []);
  
  app.controller('FarmerController', ['$http', function($http){
	var server = this;
    server.farmers = [];
    
    $http.get('http://localhost:8080/unified-web-maven/rest/farmer').success(function(data){
    	server.farmers = data;
    });
    
  }]);

})();

