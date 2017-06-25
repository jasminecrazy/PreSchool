app
		.controller(
				'followCtrl',
				function($scope, $http, $resource) {
					$scope.list = [];
					function getAllFollow() {
						$http({
							url : 'http://localhost:8080/admin/api/follow',
							method : "GET"
						}).then(function(response) {
							$scope.list = response.data;
						}, function(error) {
							console.log(error);
						});
					}
					getAllFollow();
					function getAllFollowStudent() {
						$scope.list_student = [];
						var Intake = $resource('http://localhost:8080/admin/api/theodoihs');
						Intake.query().$promise.then(function(liststudent) {

							$scope.list_student = liststudent;
						});
					}

					getAllFollowStudent();

					// add Student trang phân lớp
					$scope.them = function(close) {

						$http({
							method : "POST",
							url : "http://localhost:8080/admin/api/follow",
							data : {
								
								
								hocsinh : $scope.add_studentName,
								ngaytheodoi:$scope.add_ngaytheodoi,
								tinhtrang:$scope.add_tinhtrang,
								bieuhiencuatre:$scope.add_bieuhien

							},
							dataType : "json"
						}).then(function(result) {
							if (result.status == 201) {
								if (close == true) {
									$("#myModal_them").modal('hide');
								}
								getAllFollow();
								addAlert();
							}
						});

					}
					// Load dữ liệu lên form sửa trang phân lớp
					$scope.sua = function(data) {
						$http
								.get(
										"http://localhost:8080/admin/api/follow/"
												+ data.id)
								.then(
										function(response) {
											$scope.edit = [];
											$scope.edit = response.data;
											studentID = data.id;
											$scope.edit_ngaytheodoi = new Date(
													response.data.ngaytheodoi);
											
											$scope.edit_studentName = response.data.hocsinh.studentName;
											$scope.edit_tinhtrang = response.data.tinhtrang == 0 ? '1'
													: '0';
											$scope.edit_tinhtrang = response.data.tinhtrang;
											$scope.edit_id = data.id;
											$scope.edit_bieuhiencuatre = response.data.bieuhiencuatre;

										});

					}
					$scope.update = function() {
						var phanlop = {
							id : $scope.edit_id,
							
							hocsinh : $scope.edit_studentName,
							ngaytheodoi : $scope.edit_ngaytheodoi,
							tinhtrang:$scope.edit_tinhtrang,
							bieuhiencuatre:$scope.edit_bieuhiencuatre
						};

						$http({
							method : "PUT",
							url : "http://localhost:8080/admin/api/follow",
							data : phanlop,
							contentType : "application/json; charset=utf-8",
							dataType : "json"
						}).then(function(result) {
							$("#myModal_sua").modal("hide");

							getAllFollow();
							editAlert();

						}, function(response) {
							alert("Fail");
						});
					}
					function deleteAlert() {
						swal({
							title : "",
							text : "Delete successfully.",
							type : "success",
							timer : 2000,
							showConfirmButton : false
						});
					}

					function editAlert() {
						swal({
							title : "",
							text : "Edit successfully.",
							type : "success",
							timer : 2000,
							showConfirmButton : false
						});
					}

			

					function addAlert(ID) {
						swal({
							title : "",
							text : "Adding successfully",
							type : "success",
							showConfirmButton : true
						});
					}

					function alertFailMessage(message) {
						swal({
							title : "",
							text : message,
							type : "error",
							timer : alertDuration,
							showConfirmButton : false
						})
					}
				});