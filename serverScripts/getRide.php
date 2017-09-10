<?php
# $json = array('response'=>'Hello this is a test');

if($_SERVER['REQUEST_METHOD']==='GET'){
	$json = array('response' => 'response from get');
	echo json_encode($json);
}
if($_SERVER['REQUEST_METHOD'] === 'POST'){
	$json = array('response' =>'Hi '.  $_POST["name"]); 
	echo json_encode($json);
}

?>
