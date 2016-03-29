<?php
	$response=array();
	require_once __DIR__.'/db_connect.php';
	$bd=new DB_CONNECT();
	//$db=$bd->close();
	$db=$bd->connect();
	if(isset($_GET['pid']))
	{
		$pid=$_GET['pid'];
		$sql="SELECT * FROM products WHERE pid = $pid";
		$result=mysqli_query($db,$sql);
		if (!empty($result)) {
			$result=mysqli_fetch_assoc($result);
			$product=array();
			$product["pid"]=$result["pid"];
			$product["name"]=$result["name"];
			$product["price"]=$result["price"];
			$product["description"]=$result["description"];
			$product["created_at"]=$result["created_at"];
			$product["updated_at"]=$result["updated_at"];
			$response["success"]=1;
			$response["product"]=array();
			array_push($response["product"], $product);
			echo json_encode($response);

		}
		else
		{
			$response["success"]=0;
			$response["message"]="no product found";
			echo json_encode($response);
		}
	}
	else
	{
			$response["success"]=0;
			$response["message"]="no product found";
			echo json_encode($response);
	}
	
	$bd->close();
?>