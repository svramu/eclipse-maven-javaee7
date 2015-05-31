(function() {
//------------------------------------------------------------------------------

  var app = angular.module('farmerApp', ["ngResource", "angularGrid"]);
  
  app.factory('DataSource', ['$resource', function($resource) {
    var data = $resource('http://localhost:8080/unified-web-maven/rest/farmer/:id', null, {
      update:{
        method:'PUT'
      }
    });
    return data;    
  }])

  app.controller('FarmerController', ['DataSource', function(DataSource) {

    this.newFarmer = {};
    this.isNew = false;
    var self = this;

    var columnDefs = [
        {displayName: "Id", field: "id"},
        {displayName: "Name", field: "name"}
    ];
    
    this.gridOptions = {
        columnDefs: columnDefs,
        rowSelection: 'single',
        rowSelected: rowSelectedHandler
    };
    
    function rowSelectedHandler(row) {
        self.newFarmer = row;
        self.isNew = false;
    }

    function refresh() {
      DataSource.query().$promise.then(function(data){
      	self.gridOptions.rowData = data;
        self.gridOptions.api.onNewRows();
      });
    }
    refresh();

    this.reset = function() {
      self.newFarmer.id = 0;
      self.newFarmer.name = "";
      self.isNew = true;
    };
    
    this.save = function() {
      if(self.isNew===true) {
        self.newFarmer.$save();
      } else {
        DataSource.update({id: self.newFarmer.id}, self.newFarmer);
      } 
    };
    
    this.remove = function() {
      DataSource.remove({id: self.newFarmer.id});
      self.gridOptions.api.onNewRows();
    };
    
  }]);

//------------------------------------------------------------------------------
})();

