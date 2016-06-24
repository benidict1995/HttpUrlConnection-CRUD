<?php

$id = '';
if (isset($_GET['id'])) {
	$id = $_GET['id'];
}


	if($_SERVER['REQUEST_METHOD'] == 'POST'){
			$id = $_POST['id'];
			$name = $_POST['name'];
			$username = $_POST['username'];
			$password = $_POST['password'];

			if (empty($name) || empty($username) || empty($password)) {
				echo "Fields Required!";
			}else{
			require_once('connection.php');

			$sql = "SELECT * FROM user_table WHERE username = '$username'";
			$check = mysqli_fetch_array(mysqli_query($con,$sql));

			if (isset($check)) {
				echo "Username Already Exists!";
			}else{
			$sql = "UPDATE user_table SET name = '$name' , username = '$username' , password = '$password' 
			WHERE id = '$id'";

			if (mysqli_query($con,$sql)) {
				echo "User Updated!";
			}else{
				echo "User Not Updated!";
			}
		}
			mysqli_close($con);
		}
	}else{
	echo "Error 404!";
}

?>
