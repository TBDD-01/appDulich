<?php
	require "dbcon.php";



	$tenbn = $_POST['tenbn'];
 	$tuoi = $_POST['tuoi'];
	$gioitinh = $_POST['gioitinh'];
	$diachi = $_POST['diachi'];
	$sdt = $_POST['sdt'];
	$mail = $_POST['mail'];
	$ngay = $_POST['ngayhen'];
	$gio = $_POST['giohen'];
	$ngaymoi = date("y-m-d",strtotime($ngay));
	

	$query = "INSERT INTO benhnhan VALUES(null,'$tenbn','$tuoi','$gioitinh','$diachi','$sdt','$mail','$ngaymoi','gio')";

	if(mysqli_query($con,$query))
	{
		echo "connect success!";
	}
	else
	{
		echo "error"; 
	}
?>