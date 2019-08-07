myApp.controller('chatController', function($scope,$http,$location,$rootScope,chatService)
{
	console.log('Starting Chat Controller');
	$scope.messages=[];
	$scope.message="";
	$scope.max=140;
	
	$scope.addMessage=function()
	{
		console.log('Adding Message Method');
		chatService.send($rootScope.currentUser.username+":" +$scope.message);
	};

	chatService.receive().then(null,null,function(message)
	{
		console.log('Recieve Method');
		$scope.messages.push(message);
	});	

});
