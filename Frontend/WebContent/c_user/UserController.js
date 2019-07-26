myApp.controller("UserController", function($scope,$http,$location,$rootScope,$cookieStore) {	
       $scope.userDetail=("username":"","password":"","name":"","emailId":"","mobileNo":"","address":"","role":"ROLE_USER");
       
       $rootScope.currentUser;
       		
	  $scope.register=function()
	  {
    	   console.log('I am in Register Function');
    	   
    	   $http.post('http://localhost:',$scope.userDetail)
    	   .then(function(response){
    		   alert("User Added");
    	   },function(errresponse){
    	      alert("Problem Occured");
    	   }};
	  }

      $scope.checkuser=function()
      {
    	  console.log('I am in checkUser Function');
    	  console.log($scope.userDetail);
    	  
    	  $http.post('http://localhost:',$scope.userDetail)
    	  .then(function(response)
    	  {
    		  $rootScope.currentUser=response.data;
    		  console.log($rootScope.currentUser);
    		  $location.path("/userHome");    		  
        },function(errresponse)
        {
        	alert("User Name and Password does not Match");
        }};
      }
      
      


	
}};