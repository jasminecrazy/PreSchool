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
	}).when("/employee", {
		templateUrl : " employee.html",
		controller : "employeeCtrl"
	}).when("/cbyt", {
		templateUrl : " cbyt.html",
		controller : "cbytCtrl"
	}).when("/parent", {
			templateUrl : " phuhuynh.html",
			controller : "parentCtrl"
		
	}).when("/phanlop", {
		templateUrl : " phieuphanlop.html",
		controller : "phanlopCtrl"
	
}).when("/dangkihoc", {
	templateUrl : " dangkihoc.html",
	controller : "nhaphocCtrl"

})
	});