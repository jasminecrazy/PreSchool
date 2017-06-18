app.controller('phanlopCtrl', function($scope, $http, $resource) {
	$scope.list_phanlop = [];
	function getAllPhanLop() {
		$http({
			url : 'http://localhost:8080/admin/api/phanlop',
			method : "GET"
		}).then(function(response) {
			$scope.list_phanlop = response.data;
		}, function(error) {
			console.log(error);
		});
	}
	getAllPhanLop();
	function getAllPLStudent() {
		 $scope.list_student = [];
	        var Intake = $resource('http://localhost:8080/admin/api/phanlopHS');
	        Intake.query().$promise.then(function(liststudent) {

	            $scope.list_student = liststudent;
	        });
	}
	function getAllPLClass() {
		 $scope.list_class = [];
	        var Intake = $resource('http://localhost:8080/admin/api/phanlopcl');
	        Intake.query().$promise.then(function(listclass) {

	            $scope.list_class= listclass;
	        });
	}
	getAllPLStudent();
	
	getAllPLClass();
	 //add Student trang phân lớp
    $scope.themphanlop = function(close) {
       
           $http({
            method:"POST",
            url :"http://localhost:8080/admin/api/phanlop",
            data:{
                class1 : $scope.add_class,
                hocsinh : $scope.add_student,
                namhoc:$scope.add_namhoc



            },
            dataType:"json"
           }).then(function(result){
            if(result.status==201)
            {
                if(close==true){
                    $("#myModal_them").modal('hide');
                }
                getAllPhanLop();
                addAlert();
            }
           });
        
        

    }
    //Load dữ liệu lên form sửa trang phân lớp
    $scope.edit = function(data)
    {
        $http.get("http://localhost:8080/admin/api/phanlop/"+data.id)
        .then(function(response){
        	 $scope.list_edit = [];
        	 $scope.list_edit = response.data;
           studentID=data.id;
           $scope.list_edit.namhoc = response.data.namhoc;
            for (var i = 0; i < $scope.list_class.length; i++) {
                    if (response.data.class1.className == $scope.list_class[i].className) {
                        $scope.list_edit.class1 = $scope.list_class[i];
                        break;
                    }
                }
            for (var i = 0; i < $scope.list_student.length; i++) {
                if (response.data.hocsinh.studentName == $scope.list_student[i].studentName) {
                    $scope.list_edit.student = $scope.list_student[i];
                    break;
                }
            }
           
        });

    }
    $scope.capnhat = function()
    {
    	var phanlop= {
    			id: $scope.list_edit.id,
    			class1: $scope.list_edit.class1,
    			hocsinh:$scope.list_edit.student,
    			namhoc:$scope.list_edit.namhoc
    	};
    
        $http({
            method:"PUT",
            url :"http://localhost:8080/admin/api/phanlop",
            data:phanlop,
           contentType: "application/json; charset=utf-8",
               dataType: "json"
        }).then(function(result){
            $("#myModal_sua").modal("hide");
           
            getAllPhanLop();
            editAlert();

        },function(response){
            alert("Fail");
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