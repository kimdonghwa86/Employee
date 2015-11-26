<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="ko" data-ng-app="employeeApp">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<title>angular.jsp</title>

<%@ include file="/WEB-INF/view/common.jspf"%>

<style type="text/css">
.dh{
	font-family: Swis721 BdOul BT;
	color : ;
}

.red {
	background-color: red;
	color: blue;
	
}

.blue {
	background-color: blue;
	color: red;
}

</style>



<script type="text/javascript">
	var app = angular.module("employeeApp", []);
	app.controller("examController", function($scope, $http) {
		$scope.title = "Angular 기본구조 연습";
		$scope.titleClick = function() {
			$scope.title += "....겁나어려움";
		};

		 		$scope.name = "한글로 검색하세요.";

		$scope.depts = [ {
			deptno : 10,
			dname : '총무부1총무부1총무부1총무부1총무부1총무부1총무부1총무부1',
			loc : 'seoul1'
		}, {
			deptno : 20,
			dname : '총무부2',
			loc : 'seoul2'
		}, {
			deptno : 30,
			dname : '총무부3',
			loc : 'seoul3'
		}, {
			deptno : 40,
			dname : '총무부4',
			loc : 'seoul4'
		}, {
			deptno : 50,
			dname : '총무부5',
			loc : 'seoul5'
		} ];

		$scope.deleteDept = function(index) {
			var id = $scope.depts[index].deptno;
			alert("id = " + id);

			$scope.depts.splice(index, 1);

		};

		$scope.imgs = [ 
		    {alt : '100', src : 'http://www.placehold.it/100x100/ff0000/0ff000?text=cat'},
		 
			{alt : '200', src : 'http://www.placehold.it/200x200/ff0000/0000ff?text=멍청'},
		 
			{alt : '300', src : 'http://www.placehold.it/300x300/ff0000/0000ff?text=zl;ko'},
			
		
			{alt : '400', src : 'http://www.placehold.it/400x400/ff0000/0000ff?text=songLucky'},
			
		 
			{alt : '500', src : 'http://www.placehold.it/500x500/ff0000/0000ff?text=DoriGom'}
			
		 ];

	});
</script>

</head>
<body class="dh" data-ng-controller="examController">
	<h1 data-ng-click="titleClick()">{{title}}</h1>
	<p>1 + 1= {{1+1}}</p>
	<hr>
	<input type="text" data-ng-model="name" />
	<h3>{{name}}</h3>
	<hr>

	<div class="table-responsive">
		<table class="table table-condensed">
			<thead>
				<tr>
					<th>No</th>
					<th>deptno</th>
					<th>dname</th>
					<th>loc</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr data-ng-repeat="dept in depts">
					<td>{{$index}}</td>
					<td>{{dept.deptno}}</td>
					<td>{{dept.dname}}</td>
					<td>{{dept.loc}}</td>
					<td><a href="#" class="btn btn-primary"
						data-ng-click="deleteDept($index)">삭제</a></td>
				</tr>
			</tbody>
		</table>
	</div>

	<hr>
	<div class="table-responsive">
		<table class="table table-condensed">
			<thead>
				<tr>
					<th>deptno</th>
					<th>dname</th>
					<th>loc</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="red">{{depts[0].deptno}}</td>
					<td class="blue">{{depts[0].dname}}</td>
					<td>{{depts[0].loc}}</td>
				</tr>
				<tr>
					<td>{{depts[1].deptno}}</td>
					<td>{{depts[1].dname}}</td>
					<td>{{depts[1].loc}}</td>
				</tr>
				<tr>
					<td class="red">{{depts[2].deptno}}</td>
					<td>{{depts[2].dname}}</td>
					<td>{{depts[2].loc}}</td>
				</tr>
				<tr>
					<td>{{depts[3].deptno}}</td>
					<td>{{depts[3].dname}}</td>
					<td>{{depts[3].loc}}</td>
				</tr>
				<tr>
					<td>{{depts[4].deptno}}</td>
					<td>{{depts[4].dname}}</td>
					<td>{{depts[4].loc}}</td>
				</tr>

			</tbody>
		</table>
	</div>

	<ul class="list-group">
		<li class="list-group-item" data-ng-repeat="img in imgs">
		<h4>{{img.src}}</h4>
		<img class="img-circle img-responsive" alt="{{img.alt}}" src="{{img.src}}">
		</li>
	</ul>






</body>
</html>




