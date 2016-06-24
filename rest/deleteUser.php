<?php

$id = '';
if (isset($_GET['id'])) {
	$id = $_GET['id'];
}
	//if ($_SERVER['REQUEST_METHOD'] == 'POST') {
		 require_once('connection.php');

		 //	$sql = "SELECT * FROM user_table WHERE id = '$id'";
		 	//$check = mysqli_fetch_array(mysqli_query($con,$sql));
		 	//if (isset($check)) {
		 	//		echo "User Doesnt Exists!";
		// 	}//else{
		 		$sql = "DELETE FROM user_table WHERE id='$id'";
		 		 //Deleting record in database 
 				if(mysqli_query($con,$sql)){
 					echo 'User Deleted Successfully';
 				}else{
 					echo 'Could Not Delete User Try Again!';
 				}
		// 	}
		 mysqli_close($con);
	//}//

?>