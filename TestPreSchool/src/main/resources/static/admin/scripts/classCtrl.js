app
		.controller(
				'classCtrl',
				function($scope, $http) {
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
					// Kiểm tra trùng ID
					function id_duplicate_Add(id) {
						var flag = true;
						$scope.list.forEach(function(item, index) {
							if (item.classId === id) {
								$scope.duplicateAlert = "Duplicate ID";

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
									classId : school_id,
									className : school_name,
									quantity : quantity
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
					$scope.class_edit = [];
					var classID = ""
					$scope.sua = function(data) {
						$http
								.get(
										"http://localhost:8080/admin/api/class/"
												+ data.id)
								.then(
										function(response) {
											classID = data.id;
											$scope.class_edit.classId = response.data.classId;
											$scope.class_edit.className = response.data.className;
											$scope.class_edit.quantity = response.data.quantity;
											$scope.class_edit.id = data.id;

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
						
							var classObj ={id:$scope.class_edit.id,classId:$scope.class_edit.classId,className:$scope.class_edit.className,quantity:$scope.class_edit.quantity}	
						
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

				});