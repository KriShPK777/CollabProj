myApp.controller("UserController",function($scope,$http,$location,$rootScope,$cookieStore) 
{	
 $scope.userDetail={"username":"","password":"","name":"","emailId":"","mobileNo":"","address":"","role":"ROLE_USER"};
 $rootScope.userDetail={"username":"","password":"","name":"","emailId":"","mobileNo":"","address":"","role":"ROLE_USER"};
 $rootScope.currentUser;
       		
	  $scope.register=function()
	  {
    	   console.log('I am in Register Function');
    	   
    	   $http.post('http://localhost:8080/MiddleWare/addUser/',$scope.userDetail)
    	   .then(function(response){
    		   alert("User Added");
    	   },function(errresponse){
    	      alert("Problem Occured");
    	   });
	  }

      $scope.checkUser=function()
      {
    	  console.log('I am in checkUser Function');
    	  console.log($scope.userDetail);
    	  
    	  $http.post('http://localhost:8080/MiddleWare/checkUser',$scope.userDetail)
    	  .then(function(response)
    	  {
    		  $rootScope.currentUser=response.data;
    		  console.log($rootScope.currentUser);
    		  $location.path("/userHome");    		  
        },function(errresponse)
        {
        	alert("User Name and Password does not Match");
        });
      }
      $scope.editUser=function()
      {
    	  console.log('I am in editUser Function');
       	  
    	  $http.post('http://localhost:8080/MiddleWare/getUser/',$rootScope.currentUser.username)
    	  .then(function(response)
    	  {
    		  $rootScope.userDetail=response.data;
    		  console.log($rootScope.userDetail);
    		  $location.path("/updateProfile");    		  
        },function(errresponse)
        {
        	alert("Problem Occured");
        });
      }
      
      $scope.updateProfile=function()
      {
    	  console.log('I am in Update Profile Function');
       	  
    	  $http.post('http://localhost:8080/MiddleWare/updateUser/',$rootScope.userDetail)
    	  .then(function(response)
    	  {
    		  alert(response.data); 		  
        },function(errresponse)
        {
        	 alert(errorresponse.data); 		
        	 alert(errorresponse.statusText); 		
        });
      }
      $scope.logout=function()
      {
    	  console.log('I am in Logout Function');
       	  $cookieStore.remove('userDetail');
       	  delete $rootScope.currentUser;
    	
    		  alert("User has Logged Out"); 
    		  $location.path("/login");        
      }

	
});