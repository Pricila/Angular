var app = angular.module("UserManagement", []);
var url = "http://localhost:8080/Backend/api/user/";
         
    //Controller Part
    app.controller("UserController", function($scope, $http) {


    	//Fill combo box
    	$scope.country = '';
	    $scope.city = '';
	    $scope.types = ['Ecuador', 'Alemania'];
	    $scope.things = [];
	    
	    $scope.fillCombo = function() {
	      if($scope.country === 'Ecuador') {
	        $scope.things = ['Quito', 'Loja'];
	      } else {
	        $scope.things = ['Stuttgart', 'Munich'];
	      }
	    }

	    //Add User
        $scope.addUser = function() {
        	var user = angular.toJson({
        		"identification":$scope.id,
        		"first_name":$scope.firstName,
        		"last_name":$scope.lastName,
        		"gender":$scope.gender,
        		"date_of_birth":$scope.dateOfBirth,
        		"address":$scope.country,
        		"address_city":$scope.city,
        		"postal_code":$scope.postalCode
        	})

        	console.log(user);
        	var config = {
    			
           	}
        	$http({
                        method : "POST",
                        url : url + "createUser",
                        data : user,
                        headers : {
                            'Content-Type' : 'application/json',
                            'Accept' :'application/json'

                        }

            }).
            	success(function(response) {
					console.log("OK!!!");
					$scope.formResult = "User saved!";
				}).
				error(function(response, status, headers, config) {
					console.log("Failed to get data, status=" + status);
					console.log(response);
					console.log(headers);
					console.log(config);
					$scope.formResult = "User not saved!";
				});
        };


        $scope.addEmail = function() {
        	var email = angular.toJson({
        		"identification":$scope.id,
        		"email":$scope.email,
        		"email_type":$scope.emailType
        	})

        	console.log(email);
        	var config = {
    			
           	}
        	$http({
                        method : "POST",
                        url : url + "createEmail",
                        data : email,
                        headers : {
                            'Content-Type' : 'application/json',
                            'Accept' :'application/json'

                        }

            }).
            	success(function(response) {
					console.log("OK!!!");					
				}).
				error(function(response, status, headers, config) {
					console.log("Failed to get data, status=" + status);
					console.log(response);
					console.log(headers);
					console.log(config);
				});
        };
                
    	//Search User
    	$scope.searchUser = function(id) {
    		//USER
			var response = $http.get(url + "basic/" + id);
			response.success(function(data) {
				$scope.users = data;
				console.log($scope.users);
				
				if(Object.keys($scope.users).length > 0){
					$scope.message = "";
					$scope.showTable = true;
				}else{
					$scope.message = "User not found!";
					$scope.showTable = false;
				}
			});
			response.error(function(data, status, headers, config) {
				console.log("Failed to get data, status=" + status);
				$scope.message = "User not found!";
				$scope.showTable = false;
			})

			//EMAIL
			var responseEmail = $http.get(url + "email/"  + id);
			responseEmail.success(function(data) {
				$scope.email = data;
				console.log($scope.email);
			});
			responseEmail.error(function(data, status, headers, config) {
				console.log("Failed to get data, status=" + status);
			})

		};
		$scope.reset = " ";
	})