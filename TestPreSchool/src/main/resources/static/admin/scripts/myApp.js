var app = angular.module('myApp', ['ngRoute', 'ui.bootstrap', 'ngResource',
		'ngMessages' ]);
app.config(function($routeProvider, $locationProvider) {
	$locationProvider.hashPrefix('');
	$routeProvider.when("/class", {
		templateUrl : "class.html",
		controller : "classCtrl"
	}).when("/hssk", {
		templateUrl : "hssk.html",
		controller : "hsskCtrl"
	}).when("/student", {
		templateUrl : " student.html",
		controller : "studentCtrl"
	}).when("/giaovien", {
		templateUrl : " giaovien.html",
		controller : "instructorCtrl"
	}).when("/cbyt", {
		templateUrl : " cbyt.html",
		controller : "cbytCtrl"
	}).when("/follow", {
		templateUrl : " theodoi.html",
		controller : "followCtrl"
	}).when("/thutien", {
		templateUrl : " thutien.html",
		controller : "thutienCtrl"	
	}).when("/phieusk", {
		templateUrl : " phieukhamsk.html",
		controller : "phieukhamskCtrl"	
	}).when("/diemdanh", {
		templateUrl : " diemdanh.html",
		controller : "classCtrl"	
	}).when("/khamsk", {
		templateUrl : " khamsk.html",
		controller : "classCtrl"	
	}).when("/studentList", {
		templateUrl : " studentList.html",
		controller : "studentListCtrl"	
	
	}).when("/", {
		templateUrl : " dashboard.html",
		controller : "dashboardCtrl"	
	
	})

	});