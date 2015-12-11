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
<title>main.jsp</title>

<!-- URL Resolve -->
<c:url var="URL_GET_LIST" 					value="/city/"/>
<c:url var="URL_GET_PAGE_BASE"  			value="/city/page/"/>	<!-- /city/page/{gageName} -->
<c:url var="URL_GET_ITEM_BASE"  			value="/city/"/>		<!-- /city/{id} -->

<c:url var="URL_POST_LIST_APPEND" 			value="/city/"/>
<c:url var="URL_POST_ITEM_APPEND" 			value="/city/"/>

<c:url var="URL_PUT_LIST_MODIFY" 			value="/city/"/>
<c:url var="URL_PUT_ITEM_MODIFY_BASE" 		value="/city/"/>

<c:url var="URL_DELETE_ITEM_DELETE_BASE" 	value="/city/"/>

<script type="text/javascript">
	
	var urls = {
			GET_LIST :					 "${URL_GET_LIST}",
			GET_PAGE_BASE :	 			 "${URL_GET_PAGE_BASE}",
			GET_ITEM_BASE : 			 "${URL_GET_ITEM_BASE}",
			
			POST_LIST_APPEND : 			 "${URL_POST_LIST_APPEND}",
			POST_ITEM_APPEND : 			 "${URL_POST_ITEM_APPEND}",
			
			PUT_LIST_MODIFY :			 "${URL_PUT_LIST_MODIFY}",
			PUT_ITEM_MODIFY_BASE :		 "${URL_PUT_ITEM_MODIFY_BASE}",
				
			DELETE_ITEM_DELETE_BASE :	 "${URL_DELETE_ITEM_DELETE_BASE}"			
	};	
	
	var deps = ['ngRoute',
	            'ngAnimate',
	            'ngTouch',
	            'angular-loading-bar'            
	];
	
	var app = angular.module("employeeApp", deps );
	
	app.config(function($routeProvider) {
		$routeProvider.otherwise({
			redirectTo: "/list"
		});
	});
	
	app.constant("URL", urls);
	
	app.controller("mainController", function($scope,$http,$location) {
		console.log("mainController....");
// 		$location.path("/list");
		
		$scope.staticOrFixed = "navbar-fixed-top";
		
		$scope.setMenuStyle = function(str) {
			$scope.staticOrFixed = str;
		};
			});
	
</script>
<c:url var="listController" value="/js/city/listController.js"/>
<c:url var="detailController" value="/js/city/detailController.js"/>
<c:url var="appendController" value="/js/city/appendController.js"/>
<c:url var="modifyController" value="/js/city/modifyController.js"/>
<c:url var="deleteController" value="/js/city/deleteController.js"/>

<script type="text/javascript" src="${listController}"></script>
<script type="text/javascript" src="${detailController}"></script>
<script type="text/javascript" src="${appendController}"></script>
<script type="text/javascript" src="${modifyController}"></script>
<script type="text/javascript" src="${deleteController}"></script>

</head>
<body data-ng-controller="mainController" class="conteiner">
  <!-- Static navbar -->
      <nav class="navbar navbar-default {{staticOrFixed}}">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Project name</a>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li class="active"><a href="#">Home</a></li>
              <li><a href="#">About</a></li>
              <li><a href="#">Contact</a></li>
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                <ul class="dropdown-menu">
                  <li><a href="#">Action</a></li>
                  <li><a href="#">Another action</a></li>
                  <li><a href="#">Something else here</a></li>
                  <li role="separator" class="divider"></li>
                  <li class="dropdown-header">Nav header</li>
                  <li><a href="#">Separated link</a></li>
                  <li><a href="#">One more separated link</a></li>
                </ul>
              </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
              <li class="active"><a href="" data-ng-click="setMenuStyle('navbar-static-top')">Default</a></li>
              <li><a href="" data-ng-click="setMenuStyle('navbar-static-top')">Static top</a></li>
              <li><a href="" data-ng-click="setMenuStyle('navbar-fixed-top')">Fixed top</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </nav>
<h1>{{title}}</h1>
<div data-ng-view>
	
</div>
</body>
</html>