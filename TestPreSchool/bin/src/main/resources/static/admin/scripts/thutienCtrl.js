app
		.controller(
				'thutienCtrl',
				function($scope, $http, $resource) {
					
					$scope.list = [];
					function getAllTien() {
						$http({
							url : 'http://localhost:8080/admin/api/thutien',
							method : "GET"
						}).then(function(response) {
							$scope.list = response.data;
						}, function(error) {
							console.log(error);
						});
					}
					getAllTien();
					

				});