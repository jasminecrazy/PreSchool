app.controller('nhaphocCtrl', function($scope, $http, $resource) {
	$scope.list = [];
	
	function getAllDonNhapHoc() {
		$http({
			url : 'http://localhost:8080/admin/api/dknh',
			method : "GET"
		}).then(function(response) {
			$scope.list = response.data;
		}, function(error) {
			console.log(error);
		});
	}
	getAllDonNhapHoc();
	function getAllParent() {
		 $scope.list_parent = [];
	        var Intake = $resource('http://localhost:8080/admin/api/dknhPH');
	        Intake.query().$promise.then(function(listparent) {

	            $scope.list_parent = listparent;
	        });
	}
	function getAllEmployee() {
		 $scope.list_employee = [];
	        var Intake = $resource('http://localhost:8080/admin/api/getEmployee');
	        Intake.query().$promise.then(function(listemployee) {

	            $scope.list_employee = listemployee;
	        });
	}
	function getAllStudent() {
		 $scope.list_student = [];
	        var Intake = $resource('http://localhost:8080/admin/api/getStudent');
	        Intake.query().$promise.then(function(liststudent) {

	            $scope.list_student = liststudent;
	        });
	}
	
	
	getAllParent();
	getAllEmployee();
	getAllStudent();
	//add Student trang đăng kí nhập học
    $scope.them = function(close) {
        if(id_duplicate_Add($scope.sodon))
        {
           $http({
            method:"POST",
            url :"http://localhost:8080/admin/api/dknh",
            data:{
                sodon : $scope.add_sodon,
                loptuoi : $scope.add_loptuoi,
                ngaydangki:$scope.add_ngaydangki,
              employee:$scope.add_employee,
              phuhuynh:$scope.add_parent,
              hocsinh:$scope.add_student



            },
            dataType:"json"
           }).then(function(result){
            if(result.status==201)
            {
                if(close==true){
                    $("#myModal_them").modal('hide');
                }
                getAllDonNhapHoc();
                addAlert();
            }
           });
        }
        

    }
 
    var studentID ="";
   
    function id_duplicate_Add(id)
    {
        var flag = true;
        $scope.list.forEach(function(item,index){
            if(id !=studentID ){
                if(item.sodon===id)
                {
                    $scope.duplicateAlert="Bạn nhập trùng mã";
                    flag =false;
                }
            }
        });
        return flag;
    }
	 //Load dữ liệu lên form sửa trang đăng kí nhập học
    $scope.sua = function(data)
    {
        $http.get("http://localhost:8080/admin/api/dknh/"+data.id)
        .then(function(response){
        	 $scope.edit = [];
        	 $scope.edit = response.data;
           studentID=data.id;
            $scope.edit_loptuoi=response.data.loptuoi;
            $scope.edit_ngaydangki= new Date(response.data.ngaydangki);
            for (var i = 0; i < $scope.list_parent.length; i++) {
                    if (response.data.phuhuynh.parentName == $scope.list_parent[i].parentName) {
                        $scope.edit_parentName = $scope.list_parent[i];
                        break;
                    }
                }
            for (var i = 0; i < $scope.list_employee.length; i++) {
                if (response.data.employee.employeeName == $scope.list_employee[i].employeeName) {
                    $scope.edit_employeeName = $scope.list_employee[i];
                    break;
                }
            }
            for (var i = 0; i < $scope.list_student.length; i++) {
                if (response.data.hocsinh.studentName == $scope.list_student[i].studentName) {
                    $scope.edit_studentName = $scope.list_student[i];
                    break;
                }
            }
        });

    }
   
    $scope.update = function()
    {
    
        $http({
            method:"PUT",
            url :"http://localhost:8080/admin/api/dknh",
            data:$scope.edit,
           contentType: "application/json; charset=utf-8",
               dataType: "json"
        }).then(function(result){
            $("#myModal_sua").modal("hide");
           
            getAllDonNhapHoc();
            editAlert();

        },function(response){
            alert("Fail");
        });
    }
  //get data for delete
	$scope.xoa = function (data)
	{
		$scope.dondk_delete = data;
	}
	// Xóa class
	$scope.dondk_delete = [];
	$scope.deleteClass = function() {
		$http(
				{
					method : "DELETE",
					url : "http://localhost:8080/admin/api/dknh/"
							+ $scope.dondk_delete.id
				}).then(function(result) {
			if (result.status == 202) {
				$('#myModal_xoa').modal('hide');
				getAllDonNhapHoc();
				deleteAlert();

			}
		});
	}
    function deleteAlert() {
        swal({
            title: "",
            text: "Delete successfully.",
            type: "success",
            timer: 2000,
            showConfirmButton: false
        });
    }

    function editAlert() {
        swal({
            title: "",
            text: "Edit successfully.",
            type: "success",
            timer: 2000,
            showConfirmButton: false
        });
    }

    function resetAlert() {
        swal({
            title: "",
            text: "Reset password successfully.",
            type: "success",
            timer: 2000,
            showConfirmButton: false
        });
    }

    function addAlert(ID) {
        swal({
            title: "",
            text: "Adding student successfully with ID: " + ID,
            type: "success",
            showConfirmButton: true
        });
    }

    function alertFailMessage(message) {
        swal({
            title: "",
            text: message,
            type: "error",
            timer: alertDuration,
            showConfirmButton: false
        })
    }
});