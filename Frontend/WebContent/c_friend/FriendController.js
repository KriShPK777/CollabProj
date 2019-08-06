myApp.controller("FriendController",function($scope,$http,$location,$rootScope)
{
	$scope.friend={"friendId":0,"username":"","friendusername":"","status":""};
	
	$scope.friendList;
	
	$scope.pendingFriendList;
	
	$scope.suggestedFriendList;
	
	function showFriendList()
	{
		console.log('I am in FriendList');
		

 	   $http.get('http://localhost:8080/MiddleWare/showFriendList/',$rootScope.currentUser.username)
 	   .then(function(response){
 		  $scope.friendList=response.data;
 	   },function(errresponse){
 	      alert("Problem Occured");
	   });
	}

   function showpendingFriendList()
   {
	   console.log('I am in FriendList');
		

 	   $http.get('http://localhost:8080/MiddleWare/showPendingFriendList/',$rootScope.currentUser.username)
 	   .then(function(response){
 		  $scope.pendingFriendList=response.data;
 	   },function(errresponse){
 	      alert("Error Occured");
	   });
	}
   function showsuggestedFriendList()
   {
	   console.log('I am in Suggested FriendList');
		

 	   $http.get('http://localhost:8080/MiddleWare/showSuggestedFriendList/',$rootScope.currentUser.username)
 	   .then(function(response){
 		  $scope.pendingFriendList=response.data;
 	   },function(errresponse){
 	      alert("Error Occured");
	   });
	}
	
	$scope.sendFriendRequest=function(friendname)
	{
		console.log('I am in Sending Friend Request');
		
		$scope.friend.username=$rootScope.currentUser.username;
		$scope.friend.friendusername=friendname;
		
		   
 	   $http.post('http://localhost:8080/MiddleWare/sendFriendRequest/',$scope.friend)
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
		
		   $http.get('http://localhost:8080/MiddleWare/acceptFriendRequest/',+friendId)
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
			
			   $http.get('http://localhost:8080/MiddleWare/deleteFriendRequest/',+friendId)
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

	
	
	