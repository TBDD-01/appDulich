<?php
    require "dbcontour.php";

    $query = "SELECT idTour,tenTour,GiaKH,thoigian,GiaHDV,idCTy,MieuTaTour FROM tour";

    $data = mysqli_query($con,$query);

    class tour{
    function tour($idTour,$tenTour,$GiaKH,$thoigian,$GiaHDV,$idCTy,$MieuTaTour){
            $this->idTour= $idTour;
            $this->tenTour= $tenTour;     
            $this->GiaKH= $GiaKH;
            $this->thoigian= $thoigian;  
            $this->GiaHDV= $GiaHDV;
            $this->idCTy= $idCTy;
            $this->MieuTaTour= $MieuTaTour;
        }
    }

    $mang = array();

    while($row = mysqli_fetch_assoc($data)){
         array_push($mang,new tour($row['idTour'],$row['tenTour'],$row['GiaKH'],$row['thoigian'],$row['GiaHDV'],$row['idCTy'],$row['MieuTaTour']));
    }

    echo json_encode($mang);

    ?>

    <!-- ,$row['sdt'],$row['diachi'],$row['moto'] -->

    <!-- ,$sdt,$diachi,$moto -->