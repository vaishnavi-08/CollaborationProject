myApp.controller("chatController", function($scope,$rootScope,$chatService)
{
	console.log('starting chat controller');
	$scope.messages=[];
	$scope.message;
	$scope.max=140;
	$scope.addMessage=function()
	{
		console.log('Adding Message Method')
		chatService.send($rootScope.currentUser.username+":"+$scope.message);
		$scope.message="";
	}
	chatService.receive().then(null,null,function(message){ console.log('Receive Mmethod');
	$scope.messages.push(message);
	});
	});