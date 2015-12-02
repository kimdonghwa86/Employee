/**
 * @author Administrator
 */

app.config(function($routeProvider) {
		console.log("/modify config...");
		
		$routeProvider.when("/modify", {
			templateUrl: "modify.html",
			controller: "modifyController"
		});
		
	});

app.controller('modifyController', function($scope, $http,URL) {
	console.log("modifyController....");
	console.log("URL.POU_ITEM_MODIFY_BASE = " + URL.POU_ITEM_MODIFY_BASE);
	
	$scope.$parent.title = "MODIFY City View";
	
});