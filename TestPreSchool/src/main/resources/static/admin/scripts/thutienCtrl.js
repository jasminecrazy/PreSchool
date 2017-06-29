app.controller('thutienCtrl', function($scope, $http, $resource) {

	$scope.list = [];
	function getAllTien() {
		$http({
			url : 'http://localhost:8080/admin/api/Student',
			method : "GET"
		}).then(function(response) {
			$scope.list = response.data;
		}, function(error) {
			console.log(error);
		});
	}
	getAllTien();
	$scope.rowdata = {
		     availableOptions: [
		    	 {id: '15', name: '15'},
			       {id: '30', name: '30'},
			       {id: '50', name: '50'},
			       {id: '100', name: '100'}
		     ],
		     selectedOption: {id: '15', name: '15 rows'}
		    };
	$scope.ChangeRow=function(index){
		$scope.itemsPerPage = index;
		$scope.updatePageIndexes();
	}
	 $scope.sortType = 'studentName';
	 $scope.filterTable =' ';
	// Phân trang
	$scope.currentPage = 1;
	// max size of the pagination bar
	$scope.maxPaginationSize = 10;
	  $scope.itemsPerPage = 15;
	$scope.updatePageIndexes = function () {
		var totalPages = Math.ceil($scope.list.length / $scope.maxPaginationSize);
		if (totalPages <= 10) {
           // less than 10 total pages so show all
			$scope.firstIndex = 1;
			$scope.lastIndex = totalPages;
       } else {
           // more than 10 total pages so calculate start and end pages
           if ($scope.currentPage <= 6) {
           	$scope.firstIndex = 1;
           	$scope.lastIndex = 10;
           } else if ($scope.currentPage + 4 >= totalPages) {
           	$scope.firstIndex = totalPages - 9;
           	$scope.lastIndex = totalPages;
           } else {
           	$scope.firstIndex = $scope.currentPage - 5;
           	$scope.lastIndex = $scope.currentPage + 4;
           }
       }
		$scope.firstIndex = ($scope.currentPage - 1) * $scope.itemsPerPage;
		$scope.lastIndex = $scope.currentPage * $scope.itemsPerPage;
	};
	$scope.updatePageIndexes();
	
	$scope.showList=function(school,index){
		return ((index >= $scope.firstIndex) && (index < $scope.lastIndex));
	}
	function getAllClass() {
		 $scope.list_class = [];
	        var Intake = $resource('http://localhost:8080/admin/api/studentcl');
	        Intake.query().$promise.then(function(listclass) {

	            $scope.list_class= listclass;
	            console.log($scope.list_class);
	        });
	}
	// Get list class
	function getAllClass() {
		$scope.list_class = [];
		var Intake = $resource('http://localhost:8080/admin/api/studentcl');
		Intake.query().$promise.then(function(listclass) {
			angular.forEach(listclass, function(value, key) {
				if (value.quantity <= 20) {
					$scope.list_class = listclass;

				} else {
					$scope.list_class = "";
				}
			});

		});
	}
	function getAllFollowStudent() {
		$scope.list_student = [];
		var Intake = $resource('http://localhost:8080/admin/api/Student');
		Intake.query().$promise.then(function(liststudent) {

			$scope.list_student = liststudent;
		});
	}

	getAllFollowStudent();
	getAllClass();
	$scope.loadthem = function() {

		$scope.add_tienhocphi = "2000000";
		$scope.add_tienan = "1500000";
		$scope.add_mabienlai = "BL1";

	}
	function getRandomInt (min, max) {
	    return Math.floor(Math.random() * (max - min + 1)) + min;
	}
	$scope.them = function(close)
	{
		 var Student = $resource('http://localhost:8080/admin/api/Student');
         Student.query().$promise
             .then(function(listStudent) {
                
                   var random = getRandomInt(1, 10000);
		var mabienlai ="BL"+ "-" +random;
		$scope.add_mabienlai = mabienlai;
		console.log(mabienlai);
		$http({
				method : "POST",
				url :"http://localhost:8080/admin/api/Student",
				data :
				{
										studentId : $scope.add_studentId,
				mabienlai : $scope.add_mabienlai,
											studentName : $scope.add_studentName,
											ngaysinh : $scope.birthday,
											gioitinh : $scope.gender,
											diachi :$scope.add_address,
											ngayvaotruong : $scope.add_ngayvaotruong,
											tinhtrangsuckhoe : $scope.add_healthStatus,
											iclass:$scope.add_className,
											hotenph:$scope.parentName,
											phone:$scope.add_phone,
											tienphuthu : $scope.add_tienphuthu,
											tienan : $scope.add_tienan,
											tienhocphi : $scope.add_tienhocphi,
											tongtien : parseInt($scope.add_tienhocphi)
													+ parseInt($scope.add_tienan)
													+ parseInt($scope.add_tienphuthu),
											namhoc : $scope.add_namhoc,
											tiendadong : $scope.add_tiendadong,
											tienchuadong : $scope.add_tienchuadong
				},
				dataType : "json"
				}).then( function (response) {
					getAllTien();
					addAlert();
					if (close == true) {
						$("#myModal_them").modal('hide');
					}
				});
				
		
	})
	}

	/*// add Student and học phí
	$scope.them = function(close) {

		$http(
				{
					method : "POST",
					url : "http://localhost:8080/admin/api/thutien",
					data : {

						hocsinh : {

							"studentId" : $scope.add_studentId,
							"studentName" : $scope.add_studentName,
							"ngaysinh" : $scope.birthday,
							"gioitinh" : $scope.gender,
							"diachi" : $scope.add_address,
							"ngayvaotruong" : $scope.add_ngayvaotruong,
							"tinhtrangsuckhoe" : $scope.add_healthStatus,
							"iclass" : $scope.add_className,
							"hotenph" : $scope.add_parentName,
							"phone" : $scope.add_phone
						},
						tienphuthu : $scope.add_tienphuthu,
						tienan : $scope.add_tienan,
						tienhocphi : $scope.add_tienhocphi,
						tongtien : parseInt($scope.add_tienhocphi)
								+ parseInt($scope.add_tienan)
								+ parseInt($scope.add_tienphuthu),
						namhoc : $scope.add_namhoc,
						tiendadong : $scope.add_tiendadong,
						tienchuadong : $scope.add_tienchuadong

					},
					dataType : "json"
				}).then(function(result) {
			if (result.status == 201) {
				getAllTien();
				addAlert();
				if (close == true) {
					$("#myModal_them").modal('hide');
				}

			}
		});
	}*/
	
	/*$scope.them = function (close)
	{
		var mabienlai ="BL"+$scope.hocsinh.id+"-"+$scope.hocsinh.gioitinh;
		$scope.add_studentName = mabienlai
		$http({
			method : "POST",
			url : "http://localhost:8080/admin/api/thutien",
			data : {
				
				mabienlai : mabienlai,
				hocsinh : $scope.add_studentName,
				
				tienphuthu : $scope.add_tienphuthu,
				tienan : $scope.add_tienan,
				tienhocphi : $scope.add_tienhocphi,
				tongtien : parseInt($scope.add_tienhocphi)
						+ parseInt($scope.add_tienan)
						+ parseInt($scope.add_tienphuthu),
				namhoc : $scope.add_namhoc,
				tiendadong : $scope.add_tiendadong,
				tienchuadong : $scope.add_tienchuadong

			},
			dataType : "json"
		}).then(function(result) {
			if (result.status == 201) {
				if (close == true) {
					$("#myModal_them").modal('hide');
				}
				getAllTien();
				addAlert();
			}
		});

	}*/
	var studentID = "";
		$scope.sua = function(data) {
			$http
					.get(
							"http://localhost:8080/admin/api/Student/"
									+ data.id)
					.then(
							function(response) {

								studentID = data.id;
								$scope.edit_studentName = response.data.studentName;
								
								$scope.edit_maphieuthu = response.data.mabienlai;
								$scope.edit_matre = response.data.studentId;
								
								$scope.edit_tienhocphi = response.data.tienhocphi;
								$scope.edit_tienan = response.data.tienan;
								$scope.edit_phuthu = response.data.tienphuthu;
								$scope.edit_tiendadong=response.data.tiendadong;
								$scope.edit_tienchuadong = response.data.tienchuadong;
								$scope.edit_id = data.id;
								$scope.edit_namhoc = response.data.namhoc;
						$scope.class_id = response.data.iclass.id;
								

							});
		}
	// sua du lieu
	$scope.update = function() {

		var classObj = {
				id : $scope.edit_id,
				studentId : $scope.edit_matre,
				studentName : $scope.edit_studentName,
			mabienlai : $scope.edit_maphieuthu,
			iclass : {
				"id":$scope.class_id
			},
			tienhocphi : $scope.edit_tienhocphi,
			tienan : $scope.edit_tienan,
			tienphuthu : $scope.edit_phuthu,
			tiendadong:$scope.edit_tiendadong,
			tienchuadong:$scope.edit_tienchuadong
		}

		$http({
			method : "PUT",
			url : "http://localhost:8080/admin/api/Student",
			data : classObj,
			contentType : "application/json; charset=utf-8",
			dataType : "json"
		})
				.then(
						function(result) {
							if (result.status == 202) {
								$("#myModal_sua").modal("hide");
								getAllTien();
								editAlert();
							}
						},
						function(response) {
							alertFailMessage("Oops! Something went wrong, please check your input again.");
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
	 
	//Hàm điền tự động
	 $scope.autoAdd = function(keyEvent) {    		  
	        if (keyEvent.keyCode == 81 && keyEvent.altKey) {
	        	var random = getRandomInt(1, 10000);
	        	$scope.add_studentId ="Mai" + random;
	        	$scope.add_studentName = "Mai";
				$scope.birthday = new Date("3/25/1997");
				$scope.gender = "0";
				$scope.add_address =random;
				$scope.add_healthStatus ="Tot";
				$scope.add_ngayvaotruong = new Date("3/25/1997");
				
	        }
	        }
});