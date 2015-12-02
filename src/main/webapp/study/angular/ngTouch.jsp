<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html lang="ko" data-ng-app="employeeApp">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">

<%@ include file="/WEB-INF/view/common.jspf" %>

<title>ngTouch.jsp</title>
<style type="text/css">
	.swipe-box{
		height: 200px;
		background-color: red;
		border: 1px solid black;
	
	}

</style>
<script type="text/javascript">
	var deps = ['ngRoute',
	            'ngAnimate',
	            'ngTouch',
	            'angular-loading-bar'            
	];
	
	var app = angular.module("employeeApp",deps );
	
	app.controller("mainController", function($scope,$http) {
		console.log("mainController....");
		
		$scope.swipeLeft= function(e){
			console.log("ng-swipe-left....")
			console.dir(e);
			
			$(e.target).css('border-radius', '0px');
			
			$scope.msg = "ng-swipe-left fired..."
		};
		
		
		$scope.swipeRight= function(e){
			console.log("swipe-right()....")
			console.dir(e);
			
			$(e.target).css('border-radius', '50px');
			
			$scope.msg = "ng-swipe-right fired..."
			
		};
		
		/*
		*img test
		*/
		
		$scope.imgURL = "http://www.placehold.it/400x400";
		
		$scope.imgSwipeLeft= function(e){
			console.log("imgSwipe-left....")
			console.dir(e);

			$scope.msg = "ng-swipe-left fired..."
			$scope.imgURL = "http://www.placehold.it/400x400/ff0000/0000ff?text=SwipeLeft";
		};
		
		$scope.imgSwipeRight= function(e) {
			console.log("imgSwipe-right()....")
			console.dir(e);
			
			$scope.msg = "ng-swipe-right fired..."
		
			$scope.imgURL = "http://www.placehold.it/400x400/0000ff/ff0000?text=SwipeRight";
		};
		
		/*
		* kimSwipe----------------------------------------------------------
		*/
		
		
		var list = new Array();
		
		list[0] = 'http://www.placehold.it/500x500/0000ff/ff0000?text=0';
		list[1] = 'http://www.placehold.it/500x500/0000ff/ff0000?text=1';
		list[2] = 'http://www.placehold.it/500x500/0000ff/ff0000?text=2';
		list[3] = 'http://www.placehold.it/500x500/0000ff/ff0000?text=3';
		list[4] = 'http://www.placehold.it/500x500/0000ff/ff0000?text=4';
		list[5] = 'http://www.placehold.it/500x500/0000ff/ff0000?text=5';
		list[6] = 'http://www.placehold.it/500x500/0000ff/ff0000?text=6';
		list[7] = 'http://www.placehold.it/500x500/0000ff/ff0000?text=7';
		list[8] = 'http://www.placehold.it/500x500/0000ff/ff0000?text=8';
		list[9] = 'http://www.placehold.it/500x500/0000ff/ff0000?text=9';
		list[10] = 'http://www.placehold.it/500x500/0000ff/ff0000?text=10';
		list[11] = 'http://www.placehold.it/500x500/0000ff/ff0000?text=11';
		list[12] = 'http://www.placehold.it/500x500/0000ff/ff0000?text=12';

		
		i=1;
		$scope.kimURL = list[i];	
		
		$scope.kimSwipeRight= function(e) {		
			$scope.kimURL = list[i++];
			if(list[i]==list[12] ){
				i=1;
				$scope.kimURL = list[1];
			}
		};
		$scope.kimSwipeLeft= function(e){
			$scope.kimURL = list[i--];
			if(list[i]==list[0] ){
			i=10;
				$scope.kimURL = list[10];
			}
		};
		
				
	});
</script>
</head>
<body data-ng-controller="mainController" class="conteiner">
	<div ng-swipe-left="swipeLeft($event)"
		 ng-swipe-right="swipeRight($event)" 
		
		 class="swipe-box">
	</div>	 
	<hr>
	<p>{{msg}}</p>
	<hr>
	<img ng-swipe-left="imgSwipeLeft($event)"
		 ng-swipe-right="imgSwipeRight($event)"
		  ondragstart="return false" 
		 draggable="false" class="img-responsive" alt="{{imgURL}}" data-ng-src="{{imgURL}}" >
	
	<p>{{imgmsg}}</p> 
	<hr>
	
	<img ng-swipe-left="kimSwipeLeft($event)"
	     ng-swipe-right="kimSwipeRight($event)"
	     ondragstart="return false" 
		 draggable="false" class="img-responsive"alt="{{kimURL}}" data-ng-src="{{kimURL}}">	
	 <p>{{imgmsg}}</p>
</body>
</html>