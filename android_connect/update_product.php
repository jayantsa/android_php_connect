<?php
	$response=array();
	if(isset($_POST['pid'])&&isset($_POST['name'])&&isset($_POST['price'])&&isset($_POST['description']))
	{
		$pid=$_POST['pid'];
		$name=$_POST['name'];
		$price=$_POST['price'];
		$description=$_POST['description'];
		require_once __DIR__.'/db_connect.php';
		$bd=new DB_CONNECT;
		$db=$bd->connect();
		$sql="UPDATE products SET name='$name', price='$price',description='$description' WHERE pid='$pid'";
		$result=mysqli_query($db,$sql);
		if($result)
		{
			$response["response"]=1;
			$response["message"]="product successfully updated";
			echo json_encode($response);
		}
		else
		{	$response["response"]=0;
			$response["message"]="please add the product";
			echo json_encode($response);
		}
		$db->close();
	}
	else
	{
		$response["success"]=0;
		$response["message"]="Required field(s) is missing";
		echo json_encode($response);
	}
	
?>
