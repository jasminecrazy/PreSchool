app
		.controller(
				'studentListCtrl',
				function($scope, $http, $filter, $resource,uiGridConstants) {
					var alertDuration = 1800;

					// get list rooms
					function getListRooms() {
						$scope.list = [];
						$http.get("http://localhost:8080/admin/api/healthCheck")
								.then(function(response) {
											$scope.list = response.data;
											$scope.gridOptions.data = response.data;

										})
					}
					getListRooms();
					// tạo dữ liệu cho table
					$scope.gridOptions = {
						noUnselect : true,
						multiSelect : false,
						enableRowSelection : true,
						enableRowHeaderSelection : false,
						enableSelectAll : false,
						enableGridMenu : false,
						enableFiltering : true,
						enableColumnResize : true,
						enableColumnMenus : false,
						paginationPageSizes : [ 15, 30, 50, 100 ],
						paginationPageSize : 15,
						columnDefs : [
								{
									name : 'sophieukham',
									displayName : 'Name'
								},
								{
									name : 'Action',
									enableSorting : false,
									enableFiltering : false,
									cellTemplate :'<button class="btn btn-primary btn-sm" ng-click="grid.appScope.callEditRoom(row.entity)" data-tooltip ="tooltip" title="Edit"data-toggle="modal" data-target="#myModal_sua"><span class="glyphicon glyphicon-edit"></span></button>'
											+ '<button ng-click="grid.appScope.callDeleteRoom(row.entity)" data-toggle="modal" class="btn btn-danger btn-sm" data-tooltip ="tooltip" title="Delete" data-target="#myModal_xoa"><span class="glyphicon glyphicon-remove"></span></button>'
								} ]
					};
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