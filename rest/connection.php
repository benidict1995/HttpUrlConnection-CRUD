<?php

define('hostname', 'localhost');
define('user', 'root');
define('password', '');
define('databaseName', 'retrofit');


$con = mysqli_connect(hostname,user,password,databaseName) or die("Unable connect to the server!");


?>