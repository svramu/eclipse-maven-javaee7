(function() {
//------------------------------------------------------------------------------

'use strict';

//------------------------------------------------------------------------------

var app = angular.module('farmerApp', ["ngResource", "ngRoute"]);


// Clear browser cache (in development mode)
// http://stackoverflow.com/questions/14718826/angularjs-disable-partial-caching-on-dev-machine
app.run(function ($rootScope, $templateCache) {
  $rootScope.$on('$viewContentLoaded', function () {
    $templateCache.removeAll();
  });
});


app.config(function ($routeProvider, $httpProvider, $locationProvider) {
  //$locationProvider.html5Mode(true);

  $routeProvider.when('/404', {templateUrl: 'app/views/404.html'});
  $routeProvider.when('/', 
      {templateUrl: 'app/views/list.html', controller: 'FarmerController'});
  $routeProvider.when('/list', 
      {templateUrl: 'app/views/list.html', controller: 'FarmerController'});
  $routeProvider.when('/new', 
      {templateUrl: 'app/views/edit.html', controller: 'FarmerController'});
  $routeProvider.when('/edit/:id', 
      {templateUrl: 'app/views/edit.html', controller: 'FarmerController'});
  $routeProvider.otherwise({redirectTo: '/404'});

  /* CORS... */
  /* http://stackoverflow.com/questions/17289195/angularjs-post-data-to-external-rest-api */
  $httpProvider.defaults.useXDomain = true;
  delete $httpProvider.defaults.headers.common['X-Requested-With'];
});


/*
 http://docs.angularjs.org/api/ngResource.$resource

 Default ngResources are defined as

 'get':    {method:'GET'},
 'save':   {method:'POST'},
 'query':  {method:'GET', isArray:true},
 'remove': {method:'DELETE'},
 'delete': {method:'DELETE'}

*/

app.factory('DataSource', ['$resource', function($resource) {
  var data = $resource('http://localhost:8080/unified-web-maven/rest/farmer/:id', null, {
    update:{
      method:'PUT'
    }
  });
  return data;    
}])


//------------------------------------------------------------------------------

app.controller('FarmerController', ['DataSource', '$location', '$routeParams', '$log',
    function(DataSource, $location, $routeParams, $log) {

  var self = this;
//  if($routeParams.id>0) {
    this.newFarmer = DataSource.get({id: $routeParams.id});  
//  }
  
  var refresh = function() {
    self.farmers = DataSource.query();
    $log.info("Refresh called...");
  }
  refresh();

  this.create = function () {
    $location.path('/new');
    ////self.newFarmer.$save();
    //DataSource.create(self.newFarmer);
    //$location.path('/list');
  }
  
  this.edit = function (farmerId) {
    $log.info("edit called..." + farmerId);
    $location.path('/edit/' + farmerId);
  };

  this.cancel = function () {
    $log.info("cancelled...");
    $location.path('/list');
  };

  this.remove = function (farmerId) {
    $log.info("remove called...");
    DataSource.remove({ id: farmerId });
    refresh();
  };
  
  this.save = function () {
    $log.info("saving...");
    //DataSource.update({id: self.newFarmer.id}, self.newFarmer);
    DataSource.update(self.newFarmer);
    $location.path('/list');
  };

/*  
  
  this.show = function (id) {
    $location.path('/info/' + id);
  };

*/
}]);

//------------------------------------------------------------------------------
})();

