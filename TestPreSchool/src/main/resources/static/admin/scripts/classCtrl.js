app
		.controller(
				'classCtrl',
				function($scope, $http, $resource) {
					$scope.list = [];
					function getAllClass() {
						$http({
							url : 'http://localhost:8080/admin/api/class',
							method : "GET"
						}).then(function(response) {
							$scope.list = response.data;
						}, function(error) {
							console.log(error);
						});
					}
					getAllClass();
					function getAllTeacher() {
						 $scope.list_teacher = [];
					        var Intake = $resource('http://localhost:8080/admin/api/classte');
					        Intake.query().$promise.then(function(listteacher) {

					            $scope.list_teacher = listteacher;
					        });
					}
					getAllTeacher();
					// Kiểm tra trùng ID
					function id_duplicate_Add(id) {
						var flag = true;
						$scope.list.forEach(function(item, index) {
							if (item.malop === id) {
								$scope.duplicateAlert = "Bạn nhập trùng mã lớp";

								flag = false;
							}
						});
						return flag;
					}
					// THÊM LỚP
					$scope.them = function(close) {
						if (id_duplicate_Add(document.getElementById("classId").value)) {
							var school_id = document.getElementById("classId").value;
							var school_name = document
									.getElementById("className").value;
							var quantity = document
									.getElementById("quantity").value;
							$http({
								method : "POST",
								url : "http://localhost:8080/admin/api/class",
								data : {
									malop : $scope.add_classId,
									tenlop : $scope.add_className,
									namhoc : $scope.add_namhoc,
									quantity : $scope.add_quantity,
									giaovien :$scope.add_teacherName
								},

								dataType : "json"
							})
									.then(
											function(result) {
												if (result.status == 201) {

													getAllClass();
													addAlert();
													if (close == true) {
														$("#myModal_them")
																.modal("hide");
													}
												}

											},
											function(response) {
												alertFailMessage("Oops! Something went wrong, please check your input again.");
												console.log('Fail');
											});
						}

					}
					// Lấy dữ liệu cho form sửa
					
					var classID = ""
					$scope.sua = function(data) {
						$http
								.get(
										"http://localhost:8080/admin/api/class/"
												+ data.id)
								.then(
										function(response) {
										
											classID = data.id;
											$scope.edit_classId = response.data.malop;
											$scope.edit_className = response.data.tenlop;
											$scope.edit_quantity = response.data.quantity;
											$scope.edit_id = data.id;
											$scope.edit_namhoc = response.data.namhoc;
											  for (var i = 0; i < $scope.list_teacher.length; i++) {
									                if (response.data.giaovien.teacherName == $scope.list_teacher[i].teacherName) {
									                    $scope.edit_teacher = $scope.list_teacher[i];
									                    break;
									                }
									            }

										});
					}
					// Xóa class
					$scope.class_delete = [];
					$scope.deleteClass = function() {
						$http(
								{
									method : "DELETE",
									url : "http://localhost:8080/admin/api/class/"
											+ $scope.class_delete.id
								}).then(function(result) {
							if (result.status == 202) {
								$('#myModal_xoa').modal('hide');
								getAllClass();
								deleteAlert();

							}
						});
					}
					// sua du lieu
					$scope.update =function ()
					{
						
							var classObj ={id:$scope.edit_id,malop:$scope.edit_classId,tenlop:$scope.edit_className,quantity:$scope.edit_quantity,namhoc:$scope.edit_namhoc,giaovien:$scope.edit_teacher}	
						
						$http({
							method:"PUT",
							url :"http://localhost:8080/admin/api/class",
							data:classObj,
							contentType:"application/json; charset=utf-8",
							dataType:"json"
						})
						.then(function(result){
							if(result.status ==202)
								{
								$("#myModal_sua").modal("hide");
								getAllClass();
								editAlert();
								}
						},function(response){
							alertFailMessage("Oops! Something went wrong, please check your input again.");
						});
						
					}
					var classID="";
					function id_duplicate_edit(id)
					{
						var flag = true;
						$scope.list.forEach(function(item,index){
							if(id!=classID)
								{
								if(item.classId===id)
									{
									$scope.duplicateAlert="Trùng ID";
									flad =false;
									}
								}
						});
						return flag;
					}
					$scope.hideDuplicateAlert = function(){
					  	$scope.duplicateAlert =" ";
					  }
					//get data for delete
					$scope.xoa = function (data)
					{
						$scope.class_delete = data;
					}
					//
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
					function deleteAlert() {
						swal({
							title : "",
							text : "Xóa thành công.",
							type : "success",
							timer : 2000,
							showConfirmButton : false
						});
					}
					function editAlert(){
			    		  swal({
			    		  	  title:"",
			    		  	  text: "Sửa thành công.",
			    		  	  type: "success",
			    		  	  timer: 2000,
			    		  	  showConfirmButton: false
			    		  	});
			      	  }
					function getRandomInt(min, max) {
						return Math.floor(Math.random() * (max - min + 1)) + min;
					}
					//Hàm điền tự động
					 $scope.autoAdd = function(keyEvent) {    		  
					        if (keyEvent.keyCode == 81 && keyEvent.altKey) {
					        	var random = getRandomInt(1, 10000);
					        	$scope.add_classId ="CL" + random;
					        	$scope.add_className = "Mai";
								$scope.add_namhoc = "2014";
								$scope.add_quantity = 30;
								$scope.add_teacherName ="Mai";
							
							
					        }
					        }

				});