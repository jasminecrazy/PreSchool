app
		.controller(
				'employeeCtrl',
				function($scope, $http) {
					$scope.list = [];
					function getAllEmployee() {
						$http({
							url : 'http://localhost:8080/admin/api/employee',
							method : "GET"
						}).then(function(response) {
							$scope.list = response.data;
						}, function(error) {
							console.log(error);
						});
					}
					getAllEmployee();
					 $scope.sortType = 'employeeName';
					 $scope.filterTable =' ';
					
					
					// add Student
					$scope.them = function(close) {
						
						if (id_duplicate_Add(document.getElementById("employeeId").value)) {
							$http(
									{
										method : "POST",
										url : "http://localhost:8080/admin/api/employee",
										data : {
											employeeId : $scope.add_employeeId,
											employeeName : $scope.add_employeeName,
											chucVu : $scope.add_chucvu,
											trinhdo : $scope.add_trinhdo,
											chuyenmon :$scope.add_chuyenmon,
											address : $scope.add_address,
											phone : $scope.add_phone

										},
										dataType : "json"
									}).then(function(result) {	
								if (result.status == 201) {
									getAllEmployee();
									addAlert();
									if (close == true) {
										$("#myModal_them").modal('hide');
									}
									
									
									
								}
							});
						}

					}
					var employeeID = "";
					function id_duplicate_Add(id) {
						var flag = true;
						$scope.list
								.forEach(function(item, index) {
									if (id != employeeID) {
										if (item.employeeId === id) {
											$scope.duplicateAlert = "Bạn nhập trùng mã";
											flag = false;
										}
									}
								});
						return flag;
					}
					var employeeID = "";
					// Load dữ liệu lên form sửa
					$scope.sua = function(data) {
						$http
								.get(
										"http://localhost:8080/admin/api/employee/"
												+ data.id)
								.then(
										function(response) {
											employeeID = data.id;
											$scope.edit_employeeName = response.data.employeeName;
											$scope.edit_chucvu = 
													response.data.chucVu;
											$scope.edit_address = response.data.address;
											$scope.edit_degree = response.data.trinhdo;
											$scope.edit_chuyenmon = response.data.chuyenmon;
											$scope.edit_phone = response.data.phone;
											$scope.edit_id = data.id;
											$scope.edit_employeeId=data.employeeId;
										});

					}

					$scope.update = function() {
						var studentObj = {
							id : $scope.edit_id,
							employeeId : $scope.edit_employeeId,
							employeeName : $scope.edit_employeeName,
							chucVu : $scope.edit_chucvu,
							trinhdo : $scope.edit_degree,
							chuyenmon : $scope.edit_chuyenmon,
							address : $scope.edit_address,
							phone:$scope.edit_phone
						}
						$http({
							method : "PUT",
							url : "http://localhost:8080/admin/api/employee",
							data : studentObj,
							contentType : "application/json; charset=utf-8",
							dataType : "json"
						}).then(function(result) {
							$("#myModal_sua").modal("hide");
							getAllEmployee();
							editAlert();

						}, function(response) {
							alertFailMessage("Vui lòng kiểm tra lại");
						});
					}
					
					//get data for delete
					$scope.xoa = function(data)
					{
						$scope.employee_delete = data;
					}
					// Xóa Student
					$scope.employee_delete = [];
					$scope.deleteEmployee = function()
					{
						$http(
								{
									method : "DELETE",
									url : "http://localhost:8080/admin/api/employee/"
											+ $scope.employee_delete.id
								}).then(function(result) {
							if (result.status == 202) {
								$('#myModal_xoa').modal('hide');
								getAllEmployee();
								deleteAlert();

							}
						});
					}
					// Các alert
					function addAlert() {
						swal({
							title : "",
							text : "Add successfully.",
							type : "success",
							timer : 2000,
							showConfirmButton : false
						});
					}
					 var alertDuration = 1800;
					function alertFailMessage(message) {
						swal({
							title : "",
							text : message,
							type : "error",
							timer : alertDuration,
							showConfirmButton : false
						});
					}
					$scope.hideDuplicateAlert = function() {
						$scope.duplicateAlert = " ";
					}
					function deleteAlert() {
						swal({
							title : "",
							text : "Xóa thành công.",
							type : "success",
							timer : 2000,
							showConfirmButton : false
						});
					}
					function editAlert() {
						swal({
							title : "",
							text : "Sửa thành công.",
							type : "success",
							timer : 2000,
							showConfirmButton : false
						});
					}
					// Reset form Add
					$scope.loadthem = function()
					{
						$scope.add_employeeId = "";
						$scope.add_employeeName = "";
						$scope.add_chucvu = "";
						$scope.add_trinhdo = "";
						$scope.add_chuyenmon = "";
						$scope.add_address = "";
						$scope.add_phone = "";
		
						
						
					}
					  function getRandomInt (min, max) {
						    return Math.floor(Math.random() * (max - min + 1)) + min;
						}
					//Hàm điền tự động
					 $scope.autoAdd = function(keyEvent) {    		  
					        if (keyEvent.keyCode == 81 && keyEvent.altKey) {
					        	var random = getRandomInt(1, 10000);
					        	$scope.add_employeeId ="Mai" + random;
					        	$scope.add_employeeName = "Mai";
								$scope.add_chucvu = "Giasm đốc";
								$scope.add_trinhdo = "Đại Học";
								$scope.add_chuyenmon ="Giao dục";
								$scope.add_address ="177 Cống Lỡ";
								$scope.add_phone = "09999";
								
					        }
					        }

				});
