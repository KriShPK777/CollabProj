myApp.controller("BlogCommentController",function($scope,$http,$location,$rootScope))
{
	$scope.friend={"blogId":0,"blogname":"","username":"","status":"","blogContent":"","createDate":"","likes":0,"dislikes":0};
	
	$scope.blogDetail;
	
	$rootScope.blog1;
	
	$rootScope.blogId;
	
	  $scope.addBlog=function()
	  {
		  console.log('I am in Add Blog');
			
		  $scope.blogComment.username=$rootScope.currentUser.username;
		  
	 	   $http.get('http://localhost:',$rootScope.blog)
	 	   .then(function(response)
	 	   {
		     alert("Blog Added");
		     showAllBlogs();
	 	  },function(errresponse){
    	      alert("Error Occured While Adding Blog");
    	   }};
	  }
 $scope.showComments=function()
{
	  console.log('I am in BlogComments');	  
	  $rootScope.blogId=blogId;
	  $location.path("/blogComments");

	  }

$scope.updateBlog=function()
{
	  console.log('I am in Update Blog');
	  $rootScope.blog1.username=$rootScope.currentUser.username;
	  
	  $http.get('http://localhost:',$rootScope.blog1)
	   .then(function(response)
	   {
		   alert("Blog Added");
		   $location.path("/showBlog");
	   },function(errresponse){
 	      alert("Error Occured While Updating Blog");
 	   }};
	  }
	  $scope.incrementLikes=function(blogId)
	  {
		  console.log('I am in Increment Likes');
		  
		  $http.get('http://localhost:'+blogId)
		   .then(function(response)
		   {
			   alert("--Thank You for Liking the Blog");
			   showAllBlogs();
		   },function(errresponse){
		 	      alert("Error Occured While Incrementing Likes of the Blog");
		 	   }};
			  }
			  $scope.incrementDisLikes=function(blogId)
			  {
				  console.log('I am in Increment DisLikes');
				  
				  $http.get('http://localhost:'+blogId)
				   .then(function(response)
				   {
					   alert("--OOPs We will try to Improve.Thanks for the Feedback!!!");
					   showAllBlogs();
				   },function(errresponse){
				 	      alert("Error Occured While Incrementing DisLikes of the Blog");
				 	   }};
					  }
			  $scope.deleteBlog=function(blogId)
			  {
			  	  console.log('I am in Deleting Blog');
						  	  
			  	  $http.get('http://localhost:',$rootScope.blog1)
			  	   .then(function(response)
			  	   {
			  		   alert("!!!Blog is Successfully Deleted!!!");
			  		  showAllBlogs();
			  		 
			  	   },function(errresponse){
			   	      alert("Error Occured While Updating Blog");
			   	   showAllBlogs();
			   	   }};
			  	  }
			  	 $scope.editBlog=function(blogId)
				  {
					  console.log('I am in Editing Blog');
					  
					  $http.get('http://localhost:'+blogId)
					   .then(function(response)
					   {
						   $rootScope.blog1=response.data;
						   console.log(response.data);
						   console.log('-----------');
						   console.log($rootScope.blog1);
						   $location.path("/editBlog");
					   },function(errresponse){
					   	      alert("Error Occured While Editing the Blog");
					   	   showAllBlogs();
					   }};
				  	  }
				  	  $scope.accept=function(blogId)
				  	  {
				  		 console.log('I am in Accept Method');
				  	   $http.get('http://localhost:',$rootScope.blog)
				 	   .then(function(response)
				 	   {
					     alert("Blog Approved");
				  	  }};
				  	  }
				  	  
				  	 $scope.reject=function(blogId)
				  	  {
				  		 console.log('I am in Reject Method');
				  	   $http.get('http://localhost:',$rootScope.blog)
				 	   .then(function(response)
				 	   {
					     alert("Blog Rejected");
				  	  }};
				  	  }
				  	  function showAllBlogs()
				  	  {
				  		 console.log('I am in Show All Blogs');
					  	   $http.get('http://localhost:')
					  	   .then(function(response)
				 	       {
					  		 $scope.blogDetail=response.data;
				 	      },function(errresponse){
					   	      alert("Error Occured While Retrieving the Blog");
					  		
				  	    }};
				 
				  	    }
				  	  showAllBlogs();
			  	  
	  }

		   
	   }
}