<?php
$response=array();

if(isset($_POST['name'])&&isset($_POST['price'])&&isset($_POST['description']))
{
	$name=$_POST['name'];
	$price=$_POST['price'];
	$description=$_POST['description'];

	require_once __DIR__.'/db_connect.php';
	$bd=new DB_CONNECT;
	$db=$bd->connect();
	$sql= "INSERT INTO products (name,price,description) VALUES('$name','$price','$description')";
	if(mysqli_query($db,$sql))
	{
		$response["success"]=1;
		$response["message"]="Product added";
		echo json_encode($response);
	}
	else
	{
		$response["success"]=0;
		$response["message"]="error error error!!!";
		echo json_encode($response);

	}
	$db->close();
}
else
{
		$response["success"]=0;
		$response["message"]="required fields are missing";
		echo json_encode($response);
}
		
?>