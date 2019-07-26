myApp.controller("UserController", function($scope,$http,$location,$rootScope)
{
	 $scope.job={"jobId":0,"designation":"","description":"","companyName":"","ctc":0,"lastdateforApply":"","skills":""};
	 
	 $scope.jobs;
	 
	 $scope.publishJob=function()
	 {
		 console.log('I am in publishJob Function');
		 console.log($scope.job);
		 
		 
		  
   	  $http.post('http://localhost:',$scope.job)
   	  .then(function(response)
   	  {
   		alert("Job Posted");
	   },function(errresponse)
	   {
		   alert("Error Occured while Posting Job");
   	  }};
	 }
		
}};