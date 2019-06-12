myApp.controller("userController",function($scope,$location,$http,$rootScope,$cookieStore)
{
		$scope.user={'username':'','password':'','emailId':'','memberName':'','role':'','status':'','isOonline':''};
		$scope.loginCheck=function()
		{
			console.log('I am in login function');
			console.log($scope.user.username);
			console.log($scope.user.password);
			$http.post('http://localhost:8080/MiddleWare/checkUser',$scope.user)
			.then(function(response){
				console.log("logged in");
				$scope.user=response.data;
				$rootScope.currentUser=response.data;
				console.log($rootScope.currentUser);
				$cookieStore.put('userdetails',response.data);
				console.log(response.data);
				$location.path("/userHome");
			});
		}
		$scope.logout=function()
		{
			console.log('I am in logout function');
			delete $rootScope.currentUser;
			$cookieStore.remove('userdetails');
			$location.path("/login");
		}
		$scope.register=function()
		{
			console.log('I am in register function');
			$scope.user.Role="ROLE_USER";
			$scope.user.status="A";
			$scope.user.isOnline="Y";
			console.log($scope.user.memberName);
			console.log($scope.user.emailId);
			
			$http.post('http://localhost:8080/MiddleWare/registerUser',$scope.user).then(function(){
				console.log("Registered");
				$location.path("/login");});
			}
});
	
