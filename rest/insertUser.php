<?php

if ($_SERVER['REQUEST_METHOD'] == 'POST') {


	$name = $_POST['name'];
	$username = $_POST['username'];
	$password = $_POST['password'];

	if (empty($name) || empty($username) || empty($password)) {
		echo "Fields Required!";
	}else{
		require_once("connection.php");
		$sql = "SELECT * FROM user_table WHERE username = '$username'";
		$check = mysqli_fetch_array(mysqli_query($con,$sql));

		if (isset($check)) {
			 echo "Username Already Exists!";
		}else{
			$sql  = "INSERT INTO user_table(name, username, password) VALUES('$name', '$username', '$password')";
			if (mysqli_query($con,$sql)) {
				echo "Successful!";
			}else{
				echo "Try Again!";
			}
		}

//close connection
	mysqli_close($con);
	}
}else{
	echo "Error 404!";
}

?>