/**
 * @author Administrator
 */

app.config(function($routeProvider) {
		console.log("/append config...");
		
		$routeProvider.when("/append", {
			templateUrl: "append.html",
			controller: "appendController"
		});
		
	});

app.controller('appendController', function($scope, $http,URL) {
	console.log("appendController....");
	console.log("URL.POST_ITEM_APPEND_BASE = " + URL.POST_ITEM_APPEND_BASE);
	
	$scope.$parent.title = "append City View";
	
});