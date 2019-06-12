myApp1.controller("BlogController", function($scope, $location, $http,
		$rootScope) {
	$scope.blog = {
		"blogId" : 0,
		"blogName" : "",
		"blogContent" : "",
		"username" : "",
		"status" : "",
		"createDate" : "",
		"likes" : "",
		"dislikes" : ""
	};
	$scope.blogData;
	$scope.addBlog = function() {
		console.log('Adding Blog Information');
		$http.post('http://localhost:8080/MiddleWare/addBlog',
				$scope.blog).then(function(response) {
			alert("Added a Blog Info");
			$location.path("/addBlog");
		});

	}
	$scope.approve = function(blogId) {
		console.log('I am in approving blog');
		$http
				.get(
						'http://localhost:8080/MiddleWare/approveBlog'
								+ blogId).then(function(response) {
					alert("Blog is approved with blogId" + blogId);
				});
	}
	$scope.reject = function(blogId) {
		console.log('I am in rejecting blog');
		$http.get('http://localhost:8080/MiddleWare/rejectBlog' + blogId)
				.then(function(response) {
					alert("Blog is rejected with blogId" + blogId);
				});
	}
	function loadBlogs() {
		console.log('Blog List');
		$http.get('http://localhost:8080/MiddleWare/showAllBlogs').then(
				function(response) {
					console.log(response.data);
					$scope.blogData = response.data;
				});
	}
	loadBlogs();

});