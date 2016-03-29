<?php
	$response=array();
	if(isset($_POST['pid']))
	{
		require_once __DIR__.'/db_connect.php';
		$pid=$_POST['pid'];
		$bd=new DB_CONNECT;
		$db=$bd->connect();
		$sql="DELETE FROM products WHERE pid = $pid";
		$result=mysqli_query($db,$sql);
		if($result)
		{
			$response["success"]=1;
			$response["message"]="PRODUCT successfully deleted";
			echo json_encode($response);
		}
		else
		{
			$response["success"]=0;
			$response["message"]="No product found";
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