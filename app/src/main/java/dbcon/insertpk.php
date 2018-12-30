<?php
	require "dbcon.php";



	$ngaykham = $_POST['ngaykham'];
	$trieutrung = $_POST['trieutrung'];
	$chuandoan = $_POST['chuandoan'];
	$mabn = $_POST['mabn'];
	$tenbn = $_POST['tenbn'];

	

	$query = "INSERT INTO phieukham VALUES(null,'$ngaykham','$trieutrung','$chuandoan','$mabn','$tenbn')";

	if(mysqli_query($con,$query))
	{
		echo "connect success!";
	}
	else
	{
		echo "error"; 
	}
?>