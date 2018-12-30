<?php

	require "dbcon.php";

	$query = "SELECT * FROM bacsi";
	$data = mysqli_query($connect,$query);

	
    class SinhVien{
        function SinhVien($mabs,$tenbs,$tuoi,$gioitinh,$sdt,$mail,$tendn,$matkhau){
            $this->Mabs= $mabs;
            $this->Tenbs= $tenbs;
            $this->Tuoi= $tuoi;
            $this->Gioitinh= $gioitinh;
            $this->SDT= $sdt;
            $this->Mail= $mail;
            $this->Tendn= $tendn;
            $this->Matkhau= $matkhau;
        }
    }

    $mangsv = array();

    while($row = mysqli_fetch_assoc($data)){
    	array_push($mangsv,new SinhVien($row['Mabs'],$row['Tenbs'],$row['Tuoi'],$row['Gioitinh'],$row['SDT'],$row['Mail'],$row['Tendn'],$row['Matkhau']));
	}

    echo json_encode($mangsv);


?>