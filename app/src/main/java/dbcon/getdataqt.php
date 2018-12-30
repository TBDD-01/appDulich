<?php
	require "dbcon.php";

	$query = "SELECT Mabn,Tenbn FROM benhnhan";

	$data = mysqli_query($con,$query);

	class benhnhan{
    function benhnhan($Mabn,$Tenbn){
            $this->Mabn= $Mabn;
            $this->Tenbn= $Tenbn;     
        }
    }

    $mangsv = array();

    while($row = mysqli_fetch_assoc($data)){
		 array_push($mangsv,new benhnhan($row['Mabn'],$row['Tenbn']));
	}

    echo json_encode($mangsv);
?>