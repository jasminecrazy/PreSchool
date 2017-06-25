/*app.controller('studentCtrl', function($scope, $http, $filter, $resource,uiGridConstants) {
    $scope.rowdata = {
        availableOptions: [{
            id: '15',
            name: '15'
        }, {
            id: '30',
            name: '30'
        }, {
            id: '50',
            name: '50'
        }, {
            id: '100',
            name: '100'
        }],
        selectedOption: {
            id: '15',
            name: '15'
        }
    };
    $scope.ChangeRow = function(index) {
        $scope.itemsPerPage = index;
        $scope.updatePageIndexes();
    }
    var alertDuration = 1800;
    $scope.list =[];
    // Lấy danh sách Student
    function GetListStudent() {
        var Student = $resource('http://localhost:8080/admin/api/Student');
        Student.query().$promise.then(function(listStudent) {
            $scope.list = listStudent;
            $scope.gridOptions.data = listStudent;
            listAllStudent = listStudent;
            console.log($scope.list);

        });

    }  
    
   

    GetListStudent();
    GetListIntake();
    GetListspecialization();
    GetListschool();
    GetListentrance_Exam();
    
    //Tạo dữ liệu cho table
    $scope.gridOptions = {
    		noUnselect : true,
    		multiSelect: false,
    		enableRowSelection: true,
    		enableRowHeaderSelection: false,
    	    enableSelectAll: false,
    	    enableGridMenu: true,
    		enableFiltering: true,
    		enableColumnResize: true,
    		enableColumnMenus: false,
    	    paginationPageSizes: [15, 30, 50, 100],
    	    paginationPageSize: 15,
    	    columnDefs: [
    		      { name: 'studentId', displayName : 'Student ID'},
    		      { name: 'username' },
    		      { name: 'lastname', displayName : 'Last Name' },
    		      { name: 'firstname', displayName : 'First Name'},
    		      { name: 'birthday', visible : false, cellFilter: 'date:"MM/dd/yyyy"' },
    		      { name: 'email', visible : false },
    		      { name: 'phone', visible : false },
    		      { name: 'address', visible : false },
    		      { name: 'school.schoolName', displayName : 'School', visible : false },
    		      { name: 'intake.intakeName', displayName : 'Intake', visible : false },
    		      { name: 'entranceExam.entranceExamName',displayName : 'Extrance exam', visible : false },
    		      { name: 'specialization.specializationName',displayName : 'Specialization', visible : false },
    		      { name: 'status', filter: {
    		          type: uiGridConstants.filter.SELECT,
    		          selectOptions: [
    		              { value: 'Studying', label: 'Studying' },
    		              { value: 'Dropped', label: 'Dropped' },
    		              { value: 'Graduated',label: 'Graduated'}
    		          ]
    		      }},
    		      { name: 'Action',enableSorting: false,enableFiltering: false,
    		             cellTemplate:'<button ng-click="grid.appScope.chitiet1(row.entity)" data-toggle="modal" class="btn btn-success btn-sm" data-tooltip ="tooltip" title="View detail informations" data-target="#myModal_detail"><span class="glyphicon glyphicon-eye-open"></span></button>' 
    		            	 			+'<button class="btn btn-primary btn-sm" ng-click="grid.appScope.sua(row.entity)" data-tooltip ="tooltip" title="Edit"	data-toggle="modal" data-target="#myModal_sua"><span class="glyphicon glyphicon-edit"></span></button>'
    		            	 			+'<button ng-click="grid.appScope.xoa(row.entity)" data-toggle="modal" class="btn btn-danger btn-sm" data-tooltip ="tooltip" title="Delete" data-target="#myModal_xoa"><span class="glyphicon glyphicon-remove"></span></button>'
    		      }
    		    ]
    	  };
   
});

*/