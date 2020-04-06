<?php
include 'conexion.php';

$usuario=$_POST['usuario'];
$clave=$_POST['clave'];
$conexion=connectDB();

//$usuario="cristof";
//$clave="verde21000";

$consulta=$conexion->prepare("SELECT * FROM usuario WHERE usuario=? AND clave=?");
$consulta->bind_param('ss',$usuario,$clave);
$consulta->execute();

$resultado = $consulta->get_result();
if ($fila = $resultado->fetch_assoc()) {
		echo json_encode($fila,JSON_UNESCAPED_UNICODE);
}
$consulta->close();
$conexion->close();

?>