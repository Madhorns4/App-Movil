<?php
include 'conexion.php';

$sql="SELECT p.id_provincia, p.nombre,p.url, pa.nombre as pais  from provincia p , pais pa WHERE pa.id_pais=p.id_pais";
$provincias=getArraySql($sql);



$myArray = array($provincias);
echo json_encode($myArray, JSON_NUMERIC_CHECK | JSON_UNESCAPED_UNICODE | JSON_PRESERVE_ZERO_FRACTION | JSON_PRETTY_PRINT);


?>