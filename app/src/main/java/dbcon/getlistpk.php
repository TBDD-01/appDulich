<?php
    require "dbcon.php";

    $query = "SELECT id,tenpk,sdt,diachi,moto FROM phongkham";

    $data = mysqli_query($con,$query);

    class phongkham{
    function phongkham($id,$tenpk,$sdt,$diachi,$moto){
            $this->id= $id;
            $this->tenpk= $tenpk;     
            $this->sdt= $sdt;
            $this->diachi= $diachi;  
            $this->moto= $moto;
            
        }
    }

    $mang = array();

    while($row = mysqli_fetch_assoc($data)){
         array_push($mang,new phongkham($row['id'],$row['tenpk'],$row['sdt'],$row['diachi'],$row['moto']));
    }

    echo json_encode($mang);

    ?>

    <!-- ,$row['sdt'],$row['diachi'],$row['moto'] -->

    <!-- ,$sdt,$diachi,$moto -->