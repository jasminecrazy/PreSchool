app
		.controller(
				'dashboardCtrl',
				function($scope, $http, $resource) {
					
					function getAmounStudent() {
						$http({
							url : 'http://localhost:8080/admin/api/countStudent',
							method : "GET"
						}).then(function(response) {
							
							$scope.number = response.data;
						}, function(error) {
							console.log(error);
						});
					}
					getAmounStudent();

					function getAmountClass() {
						$http({
							url : 'http://localhost:8080/admin/api/countClass',
							method : "GET"
						}).then(function(response) {
							
							$scope.numberClass = response.data;
						}, function(error) {
							console.log(error);
						});
					}
					getAmountClass();
					
				});