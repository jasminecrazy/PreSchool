var app = angular.module('myApp', [ 'ngRoute', 'ui.bootstrap', 'ngResource',
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
	
	
})

	});