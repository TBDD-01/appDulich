<?php
    require "dbcon.php";
    
    mysqli_set_charset($con,'utf8');
    /** Array for JSON response*/
    $response = array();
    if($_SERVER['REQUEST_METHOD']=='POST'){
        $username = $_POST['Tendn'];
        $password = $_POST['Matkhau'];

        // $username = "bacsi1";
        // $password  = "111222";
        $sql = "SELECT Tendn,Matkhau FROM bacsi WHERE Tendn = '$username' AND Matkhau='$password'";
        

                $result= mysqli_query($con,$sql);
                $row = mysqli_fetch_array($result);
                $username = $row["Tendn"];
                $password = $row["Matkhau"];
                

        /**Return json*/
        echo json_encode($response);
    } 
?>