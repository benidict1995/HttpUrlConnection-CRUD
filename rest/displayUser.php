 
<?php

//if ($_SERVER['REQUEST_METHOD'] == 'POST') {
//	include 'connection.php';

//		showUser();
//}

//function showUser(){
//	global $con;
require_once("connection.php");
	$sql = "SELECT * FROM user_table";
	$result = mysqli_query($con,$sql);
	$temp = array();
	while ($row = mysqli_fetch_array($result)) {
		array_push($temp, array('id' => $row['id'],
			'name' => $row['name'],
			'username' => $row['username'],
			'password' => $row['password']));
	}

header('Content-Type: application/json');
echo json_encode(array("result" => $temp));
mysqli_close($con);

//}

?>