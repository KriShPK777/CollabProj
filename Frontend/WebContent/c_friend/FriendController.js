myApp.controller("FriendController",function($scope,$http,$location,$rootScope)
{
	$scope.friend={"friendId":0,"username":"","friendusername":"","status":""};
	
	$scope.friendList;
	
	$scope.pendingFriendList;
	
	$scope.suggestedFriendList;
	
	function showFriendList()
	{
		console.log('I am in FriendList');
		

 	   $http.get('http://localhost:8080/Frontend/c_friend/FriendController.js',$rootScope.currentUser.username)
 	   .then(function(response){
 		  $scope.friendList=response.data;
 	   },function(errresponse){
 	      alert("Problem Occured");
	   });
	}

   function showpendingFriendList()
   {
	   console.log('I am in FriendList');
		

 	   $http.get('http://localhost:8080/Frontend/c_friend/FriendController.js',$rootScope.currentUser.username)
 	   .then(function(response){
 		  $scope.pendingFriendList=response.data;
 	   },function(errresponse){
 	      alert("Problem Occured");
	   });
	}
	
	$scope.sendFriendRequest=function(friendname)
	{
		console.log('I am in Sending Friend Request');
		
		$scope.friend.username=$rootScope.currentUser.username;
		$scope.friend.friendusername=friendname;
		
		   
 	   $http.post('http://localhost:8080/Frontend/c_friend/FriendController.js',$scope.friend)
 	   .then(function(response){
 		   alert("Friend Request Sent");
 		  showpendingFriendList();
 		 showSuggestedFriendList();
 		 showFriendList();
 	   },function(errresponse){
 	      alert("Error Occured");
 	   });
	}
	$scope.accept=function(friendId)
	{
		console.log('I am Accepting Friend Request');
		
		   $http.get('http://localhost:8080/Frontend/c_friend/FriendController.js',+friendId)
	 	   .then(function(response){
	 		   alert("Friend Request is Accepted");
	 		  showpendingFriendList();
	 		 showSuggestedFriendList();
	 		 showFriendList();
	 	   },function(errresponse){
	 	      alert("Error Occured");
	 	   });
	 }
	 
	 $scope.unfriend=function(friendId)
		{
			console.log('I am  UnFriend Request');
			
			   $http.get('http://localhost:8080/Frontend/c_friend/FriendController.js',+friendId)
		 	   .then(function(response){
		 		   alert("Friend Request is Deleted");
		 		  showpendingFriendList();
		 		 showSuggestedFriendList();
		 		 showFriendList();
		 	   },function(errresponse){
		 	      alert("Error Occured");
		 	   });
		 }
		 
		 showpendingFriendList();
		 showSuggestedFriendList();
		 showFriendList();
		 
	 
		

  
});

	
	
	