<?php
include 'conexion.php';



$conexion=connectDB();
//$id_provincia="10";
$id_provincia=$_POST['id_ciudad'];

$int = 1;

$consulta=$conexion->prepare("SELECT * FROM lugar_turistico WHERE id_ciudad=?");
$consulta->bind_param('i',$int);
$consulta->execute();

$rawdata=array();
$resultado = $consulta->get_result();
if ($fila = $resultado) {
    $i=0;
    
    while($row = mysqli_fetch_assoc($resultado))
    {
       

        $rawdata[$i] = $row;
        $i++;
    }
}
disconnectDB($conexion); //desconectamos la base de datos

    
$myArray = $rawdata;
echo json_encode($myArray, JSON_NUMERIC_CHECK | JSON_UNESCAPED_UNICODE | JSON_PRESERVE_ZERO_FRACTION | JSON_PRETTY_PRINT);


?>