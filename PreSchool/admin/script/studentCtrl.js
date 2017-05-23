
app.controller('studentCtrl', function($scope, $http) {
   $scope.list=[];
function getAllStudent()
{
    $http({
        url: 'http://localhost:8080/admin/api/Student',
        method: "GET"
    })
      .then(function(response){
        $scope.list = response.data;
    }, function(error) {
        console.log(error);
    });
}
getAllStudent();
// lấy danh sách lớp học
    function GetListClass() {
        $scope.list_class = [];
        var School = $resource('http://localhost:8080/admin/api/StudentClass');
        School.query().$promise.then(function(listclass) {

            $scope.list_class = listclass;

        });

    }
    //add Student
    $scope.them = function(close) {
        if(id_duplicate_Add($scope.studentId))
        {
           $http({
            method:"POST",
            url :"http://localhost:8080/admin/api/Student",
            data:{
                studentId : $scope.student.studentId,
                studentName : $scope.student.studentName,
                birthday:$scope.birthday,
                gender :$scope.gender,
                result:$scope.student.result,
                tenphuhuynh:$scope.student.parentName,
                address:$scope.student.address,
                phone:$scope.student.phone,



            },
            dataType:"json"
           }).then(function(result){
            if(result.status==201)
            {
                if(close==true){
                    $("#myModal_them").modal('hide');
                }
                getAllStudent();
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
                if(item.studentId===id)
                {
                    $scope.duplicateAlert="Bạn nhập trùng mã";
                    flag =false;
                }
            }
        });
        return flag;
    }
     var studentID="";
    //Load dữ liệu lên form sửa
    $scope.sua = function(data)
    {
        $http.get("http://localhost:8080/admin/api/Student/"+data.id)
        .then(function(response){
           studentID=data.id;
            $scope.edit_studentName=response.data.studentName;
            $scope.edit_birthday= new Date(response.data.birthday);
            $scope.edit_parentName=response.data.tenphuhuynh;
            $scope.edit_address=response.data.address;
            $scope.edit_phone=response.data.phone;
            $scope.edit_result=response.data.result;
            $scope.edit.gender =response.data.gender == 0 ? '0' : '1';
            for (var i = 0; i < $scope.list_class.length; i++) {
                    if (response.data.class_id == $scope.list_class[i].class) {
                        $scope.edit.class_id = $scope.list_class[i];
                        break;
                    }
                }
        });

    }
   
    $scope.update = function()
    {
        var studentObj = {id:studentID,studentName:$scope.edit_studentName,birthday:$scope.edit_birthday,gender:$scope.edit_gender,result:$scope.edit_result,tenphuhuynh:$scope.edit_parentName,address:$scope.edit_address,phone:$scope.edit_phone
        };
        $http({
            method:"PUT",
            url :"http://localhost:8080/admin/api/Student",
            data:studentObj,
           contentType: "application/json; charset=utf-8",
               dataType: "json"
        }).then(function(result){
            $("#myModal_sua").modal("hide");
            getAllStudent();

        },function(response){
            alert("Fail");
        });
    }

      
});

