<?php
	require "dbcon.php";
    
    mysqli_set_charset($con,'utf8');
    /** Array for JSON response*/

        $Tendn = $_POST['Tendn'];
        $Matkhau = $_POST['Matkhau'];

            // $Tendn ="bacsi1";
            // $Matkhau ="11222";
            $sql = "SELECT * FROM bacsi WHERE Tendn = '$Tendn' AND Matkhau = '$Matkhau'";

        $result = mysqli_query($con,$sql);
        if(mysqli_num_rows($result) != 0){
            echo "suc";
        }
        else{
            echo "error";
        }

        /**Return json*/

    
?>