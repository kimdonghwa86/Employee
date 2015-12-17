/**
 * @author Administrator
 */

app.config(function($routeProvider) {
		console.log("/modify config...");
		
		$routeProvider.when("/modify/:id", {
			templateUrl: "modify.html",
			controller: "modifyController"
		});
		
	});

app.controller('modifyController', function($scope, $http, URL, $routeParams) {
	console.log("modifyController....");
	console.log("URL.PUT_ITEM_MODIFY_BASE = " + URL.PUT_ITEM_MODIFY_BASE);
	console.log("URL.PUT_ITEM_BASE = " + URL.PUT_ITEM_BASE);

	console.log("id = " + $routeParams.id);
	
	$scope.$parent.title = "MODIFY City View";
	
	var ajax = $http.get(URL.GET_ITEM_BASE + $routeParams.id);
	ajax.then(function(value){
		console.dir(value);
		$scope.cityForm = value.data;
	}, function(reason){
		console.dir(reason);
		alert("error...");
		
	});
});