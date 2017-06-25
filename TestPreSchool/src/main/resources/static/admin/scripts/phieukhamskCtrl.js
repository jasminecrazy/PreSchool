app.controller('phieukhamskCtrl', function($scope, $http, $resource) {
	$scope.list = [];
	function getAllEmployee() {
		$http({
			url : 'http://localhost:8080/admin/api/healthCheck',
			method : "GET"
		}).then(function(response) {
			$scope.list = response.data;
		}, function(error) {
			console.log(error);
		});
	}
	getAllEmployee();
	function getAllCBYT() {
		$scope.list_cbyt = [];
		var Intake = $resource('http://localhost:8080/admin/api/cbyt');
		Intake.query().$promise.then(function(listcbyt) {

			$scope.list_cbyt = listcbyt;
		});
	}
	getAllCBYT();
	$scope.sortType = 'sophieukham';
	$scope.filterTable = ' ';
	var employeeID = "";
	// Load dữ liệu lên form sửa
	$scope.sua = function(data) {
		$http.get("http://localhost:8080/admin/api/healthCheck/" + data.id).then(
				function(response) {
					employeeID = data.id;
					$scope.edit_sophieukham = response.data.sophieukham;
					$scope.edit_studentId= response.data["hocsinh"].studentId;
					$scope.edit_studentName = response.data["hocsinh"].studentName;
					$scope.edit_lankham = response.data.lankham;
					$scope.edit_namhoc = response.data.namhoc;
					$scope.edit_chieucao = response.data.chieucao;
					$scope.edit_cannang = response.data.cannang;
					$scope.edit_benh = response.data.benh;
					$scope.edit_ketluan = response.data.ketluan;
					$scope.edit_id = data.id;
					$scope.add_id = response.data["hocsinh"].id;
					$scope.edit_ngaykham = new Date(response.data.ngaykham);
					
					for (var i = 0; i < $scope.list_cbyt.length; i++) {
						if (response.data.cbyt.hoTencbyt == $scope.list_cbyt[i].hoTencbyt) {
							$scope.edit_cbytName = $scope.list_cbyt[i];
							break;
						}
					}
				});

	}
	// sua du lieu
	$scope.editHeath = function() {

		var classObj = {
			id : $scope.edit_id,
			sophieukham : $scope.edit_sophieukham,
			lankham : $scope.edit_lankham,
			namhoc : $scope.edit_namhoc,
			ngaykham : $scope.edit_ngaykham,
			chieucao : $scope.edit_chieucao,
			cannang : $scope.edit_cannang,
			benh :$scope.edit_benh,
			ketluan : $scope.edit_ketluan,
			cbyt : $scope.edit_cbytName,
			hocsinh : {
				"id" : $scope.add_id
			}
		}

		$http({
			method : "PUT",
			url : "http://localhost:8080/admin/api/healthCheck",
			data : classObj,
			contentType : "application/json; charset=utf-8",
			dataType : "json"
		})
				.then(
						function(result) {
							if (result.status == 202) {
								$("#myModal_sua").modal("hide");
								getAllEmployee();
								editAlert();
							}
						},
						function(response) {
							alertFailMessage("Oops! Something went wrong, please check your input again.");
						});

	}
	function addAlert() {
		swal({
			title : "",
			text : "Thêm thành công.",
			type : "success",
			timer : 2000,
			showConfirmButton : false
		});
	}
	function diemdanhAlert() {
		swal({
			title : "",
			text : "Đã điểm danh.",
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
	function editAlert() {
		swal({
			title : "",
			text : "Sửa thành công.",
			type : "success",
			timer : 2000,
			showConfirmButton : false
		});
	}
	function getRandomInt(min, max) {
		return Math.floor(Math.random() * (max - min + 1))
				+ min;
	}
	// Hàm điền tự động
	$scope.autoAdd = function(keyEvent) {
		if (keyEvent.keyCode == 81 && keyEvent.altKey) {
			var random = getRandomInt(1, 10000);
			$scope.add_classId = "CL" + random;
			$scope.add_className = "Mai";
			$scope.add_namhoc = "2014";
			$scope.add_quantity = 30;
			$scope.add_teacherName = "Mai";

		}
	}
	

});
