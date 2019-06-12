var myApp=angular.module("myApp1",('ngRoute','ngCookies'));
myApp.config(function($routeProvider)
		{
		alert("I am in route config with the route provider");
		$routeProvider.when("/userHome",{templateUrl:"index.html"})
		.when("/login",{templateUrl:"c_user/login.html"})
		.when("/register",{templateUrl:"c_user/register.html"})
		.when("/userHome",{templateUrl:"c_user/UserHome.html"})
		.when("/addBlog",{templateUrl:"c_user/Addblog.html"})
		.when("/showBlog",{templateUrl:"c_user/ShowBlogs.html"})
		});
	myApp.run(function($routeScope,$cookieStore)
			{
			console.log("I am in run function");
			console.log($routeScope.currentUser);
			if($rootScope.currentUser==undefined){
				console.log($cookieStore.get('userdetails'));
				$rootScope.currentUser=$cookieStore.get('userdetails');
			}
			});