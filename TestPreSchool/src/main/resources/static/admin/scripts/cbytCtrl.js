app.controller('cbytCtrl', function($scope, $http) {
	$scope.list = [];
	function getAllEmployee() {
		$http({
			url : 'http://localhost:8080/admin/api/cbyt',
			method : "GET"
		}).then(function(response) {
			$scope.list = response.data;
		}, function(error) {
			console.log(error);
		});
	}
	getAllEmployee();
	$scope.sortType = 'hoTencbyt';
	$scope.filterTable = ' ';

	// add Student
	$scope.them = function(close) {

		if (id_duplicate_Add(document.getElementById("maCbyt").value)) {
			$http({
				method : "POST",
				url : "http://localhost:8080/admin/api/cbyt",
				data : {
					macbyt : $scope.add_maCbyt,
					hoTencbyt : $scope.add_cbytName,
					trinhDo : $scope.add_degree,
					chuyenMon : $scope.add_chuyenmon,

					diaChi : $scope.add_address,
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
		$scope.list.forEach(function(item, index) {
			if (id != employeeID) {
				if (item.maCbyt === id) {
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
		$http.get("http://localhost:8080/admin/api/cbyt/" + data.id).then(
				function(response) {
					employeeID = data.id;
					$scope.edit_cbytName = response.data.hoTencbyt;
					$scope.edit_degree = response.data.trinhDo;
					
					$scope.edit_chuyenmon = response.data.chuyenMon;
					$scope.edit_address = response.data.diaChi;
					$scope.edit_phone = response.data.phone;
					$scope.edit_id = data.id;
					$scope.edit_maCbyt = data.macbyt;
					$scope.active = response.data.status;
				});

	}

	$scope.update = function() {
		var studentObj = {
			id : $scope.edit_id,
			macbyt : $scope.edit_maCbyt,
			hoTencbyt : $scope.edit_cbytName,
			trinhDo : $scope.edit_degree,
			chuyenMon : $scope.edit_chuyenmon,
			diaChi : $scope.edit_address,
			phone : $scope.edit_phone,
			 status: ($scope.active == null ? false : ($scope.active == false ? false : true))
		}
		$http({
			method : "PUT",
			url : "http://localhost:8080/admin/api/cbyt",
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

	// get data for delete
	$scope.xoa = function(data) {
		$scope.parent_delete = data;
	}
	// Xóa Student
	$scope.parent_delete = [];
	$scope.deleteParent = function() {
		$http(
				{
					method : "DELETE",
					url : "http://localhost:8080/admin/api/cbyt/"
							+ $scope.parent_delete.id
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
	$scope.loadthem = function() {
		
		$scope.add_maCbyt = "";
		$scope.add_cbytName = "";
		$scope.add_degree = "";
		$scope.add_chuyenmon = "";
		
		$scope.add_address = "";
		$scope.add_phone = "";

	}
	function getRandomInt(min, max) {
		return Math.floor(Math.random() * (max - min + 1)) + min;
	}
	// Hàm điền tự động
	$scope.autoAdd = function(keyEvent) {
		if (keyEvent.keyCode == 81 && keyEvent.altKey) {
			var random = getRandomInt(1, 10000);
			$scope.add_maCbyt = "Mai" + random;
			$scope.add_cbytName = "Mai";
			$scope.add_degree = "Đại Học";
			$scope.add_chuyenmon = "Nông";
			
			$scope.add_address = "177 Cống Lỡ";
			$scope.add_phone = "09999";

		}
	}

});
