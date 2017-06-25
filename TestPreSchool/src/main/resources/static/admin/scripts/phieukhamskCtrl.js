app.controller('phieukhamskCtrl', function($scope, $http) {
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
					$scope.edit_ngaykham = new Date(response.data.ngaykham);
					
			console.log(response.data);
				});

	}
	// sua du lieu
	$scope.editHeath = function() {

		var classObj = {
			id : $scope.edit_id,
			sophieukham : $scope.edit_classId,
			tenlop : $scope.edit_className,
			quantity : $scope.edit_quantity,
			namhoc : $scope.edit_namhoc,
			giaovien : $scope.edit_teacher
		}

		$http({
			method : "PUT",
			url : "http://localhost:8080/admin/api/class",
			data : classObj,
			contentType : "application/json; charset=utf-8",
			dataType : "json"
		})
				.then(
						function(result) {
							if (result.status == 202) {
								$("#myModal_sua").modal("hide");
								getAllClass();
								editAlert();
							}
						},
						function(response) {
							alertFailMessage("Oops! Something went wrong, please check your input again.");
						});

	}
	

});
