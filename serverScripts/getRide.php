<?php
# $json = array('response'=>'Hello this is a test');
$servername = "localhost";
$username = "alexaqj1_admin";
$pw = "Al3xL4oz!!";
$dbname = "alexaqj1_quickRide";

$connection = new mysqli($servername, $username, $pw, $dbname);
if($connection->connect_error){
	die("Connection failed: " . $connection->connect_error);
}

if($_SERVER['REQUEST_METHOD']==='GET'){
	$json = array('response' => 'response from get');
	echo json_encode($json);
}
if($_SERVER['REQUEST_METHOD'] === 'POST'){
	# $sql = "INSERT INTO Rides(name, address, group) VALUES ($_POST["name"], $_POST["address"], $_POST["group"])";
	if(!($stmt = $connection->prepare("INSERT INTO Rides (name, address, userGroup) VALUES (?, ?, ?)"))){
		error_log("Prepare Failed: " . $connection->errno . ") " . $connection->error);
	}
	$stmt->bind_param("sss", $name, $address, $group);
	$name = $_POST["name"];
	$address = $_POST["address"];
	$group = $_POST["userGroup"];
	if($stmt->execute()){
		$json = array('response' => 'success');	
	} else{
		$json = array('response' => 'failed');	
	}
	/*
	if($connection->query($sql) === TRUE){
		echo "new record was submitted";
	}
	else{
		echo "Error: " . $connection->error;
	}*/
	$stmt->close();
	echo json_encode($json);
}

$connection->close();

?>
