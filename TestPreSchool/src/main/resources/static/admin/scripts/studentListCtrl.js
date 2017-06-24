app
		.controller(
				'studentListCtrl',
				function($scope, $http, $resource) {
					
					$scope.getStudents = function getStudent(id)
					{
					 
					$http({
							method : "GET",
							url : "http://localhost:8080/admin/api/class/get-students/"+$scope.id
						}).then(function mySucess(response){
							
							$scope.listStudent = response.data;
						},
						function(error) { alert('fail');}
						);
					}
				
				});