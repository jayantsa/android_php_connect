<?php
	$response=array();
	require_once __DIR__.'/db_connect.php';
	$bd=new DB_CONNECT;
	$db=$bd->connect();
	$sql="SELECT * FROM products";
	$results=mysqli_query($db,$sql);
	if(!empty($results))
	{
		$response['products']=array();
		//$results=mysqli_fetch_array($results);
		while($result=mysqli_fetch_array($results))
		{
			$product=array();
			$product["pid"]=$result["pid"];
			$product["name"]=$result["name"];
			$product["price"]=$result["price"];
			$product["created_at"]=$result["created_at"];
			$product["updated_at"]=$result["updated_at"];
			array_push($response['products'], $product);
		}
		$response['success']=1;
		echo json_encode($response);

	}
	else
	{
		$response['success']=0;
		$response['message']="No products found";
		echo json_encode($response);
	}
	$db->close();
?>
