<?php
	require "dbcon.php";

	$Mabn = $_POST['Mabn'];

	$sql = "DELETE FROM benhnhan WHERE Mabn= '$Mabn' ";
	if(mysqli_query($con,$sql))
		{
			echo "success";
		}
		else{
			echo "error";
		}
?>