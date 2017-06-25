app
		.controller(
				'instructorCtrl',
				function($scope, $http) {
					$scope.list = [];
					function getAllTeacher() {
						$http({
							url : 'http://localhost:8080/admin/api/teacher',
							method : "GET"
						}).then(function(response) {
							$scope.list = response.data;
						}, function(error) {
							console.log(error);
						});
					}
					getAllTeacher();
					 $scope.sortType = 'teacherName';
					 $scope.filterTable =' ';
					
					// Thông tin chi tiết
						var teacherID = ""
						$scope.chitiet = function(data) {
							$http
									.get(
											"http://localhost:8080/admin/api/teacher/"
													+ data.id)
									.then(
											function(response) {
												teacherID = data.id;
												$scope.chitiet.teacherId = response.data.teacherId;
												$scope.chitiet.teacherName = response.data.teacherName;
												$scope.chitiet.birthday = response.data.birthday;
												$scope.chitiet.trinhdo = response.data.trinhdo;
												$scope.chitiet.chuyenmon = response.data.chuyenmon;
											
												$scope.chitiet.address = response.data.address;
												$scope.chitiet.phone = response.data.phone;
												
											});
						}
						//
						// add Giao viên
						$scope.them = function(close) {
							
							if (id_duplicate_Add(document.getElementById("teacherId").value)) {
								$http(
										{
											method : "POST",
											url : "http://localhost:8080/admin/api/teacher",
											data : {
												teacherId : $scope.add_teacherId,
												teacherName : $scope.add_teacherName,
												birthday : $scope.birthday,
												trinhdo : $scope.add_degree,
												chuyenmon :$scope.add_chuyenmon,
												
												address : $scope.add_address,
												phone :$scope.add_phone

											},
											dataType : "json"
										}).then(function(result) {	
									if (result.status == 201) {
										getAllTeacher();
										addAlert();
										if (close == true) {
											$("#myModal_them").modal('hide');
										}
										
										
										
									}
								});
							}

						}
						function id_duplicate_Add(id) {
							var flag = true;
							$scope.list
									.forEach(function(item, index) {
										if (id != teacherID) {
											if (item.teacherId === id) {
												$scope.duplicateAlert = "Bạn nhập trùng mã";
												flag = false;
											}
										}
									});
							return flag;
						}
						//load dữ liệu cho form sửa
						$scope.sua = function(data) {
							$http
									.get(
											"http://localhost:8080/admin/api/teacher/"
													+ data.id)
									.then(
											function(response) {
												teacherID = data.id;
												$scope.edit_teacherName = response.data.teacherName;
												$scope.edit_birthday = new Date(
														response.data.birthday);
												$scope.edit_degree = response.data.trinhdo;
		
												$scope.edit_chuyenmon = response.data.chuyenmon;
												
												$scope.edit_address = response.data.address;
												$scope.edit_phone = response.data.phone;
												$scope.edit_id = data.id;
												$scope.edit_teacherId=data.teacherId;
											});

						}
						//sửa
						$scope.update = function() {
							var studentObj = {
								id : $scope.edit_id,
								teacherId : $scope.edit_teacherId,
								teacherName : $scope.edit_teacherName,
								birthday : $scope.edit_birthday,
								trinhdo : $scope.edit_degree,
								chuyenmon : $scope.edit_chuyenmon,
								
								address:$scope.edit_address,
								phone:$scope.edit_phone
							}
							$http({
								method : "PUT",
								url : "http://localhost:8080/admin/api/teacher/",
								data : studentObj,
								contentType : "application/json; charset=utf-8",
								dataType : "json"
							}).then(function(result) {
								$("#myModal_sua").modal("hide");
								getAllTeacher();
								editAlert();

							}, function(response) {
								alertFailMessage("Vui lòng kiểm tra lại");
							});
						}
						//get data for delete
						$scope.xoa = function(data)
						{
							$scope.teacher_delete = data;
						}
						// Xóa Student
						$scope.teacher_delete = [];
						$scope.deleteTeacher = function()
						{
							$http(
									{
										method : "DELETE",
										url : "http://localhost:8080/admin/api/teacher/"
												+ $scope.teacher_delete.id
									}).then(function(result) {
								if (result.status == 202) {
									$('#myModal_xoa').modal('hide');
									getAllTeacher();
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
							
							$scope.add_teacherId = "";
							$scope.add_teacherName = "";
							$scope.birthday = "";
							$scope.add_chuyenmon = "";
							$scope.add_degree = "";
							
							$scope.add_phone = "";
							$scope.add_address = "";
			
							
							
						}
						  function getRandomInt (min, max) {
							    return Math.floor(Math.random() * (max - min + 1)) + min;
							}
						//Hàm điền tự động
						 $scope.autoAdd = function(keyEvent) {    		  
						        if (keyEvent.keyCode == 81 && keyEvent.altKey) {
						        	var random = getRandomInt(1, 10000);
						        	$scope.add_teacherId ="Mai" + random;
						        	$scope.add_teacherName = "Mai";
						        	$scope.add_chuyenmon = "Giao dục thể chất";
									$scope.add_degree = "Cao Đẳng";
									$scope.add_address =random;
									
									$scope.birthday = new Date("3/25/1997");
									$scope.add_phone ="01121";
									
						        }
						        }
				});
