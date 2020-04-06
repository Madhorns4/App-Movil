<?php
include 'conexion.php';

$nombre=$_POST['nombre'];
$apellido=$_POST['apellido'];
$usuario=$_POST['usuario'];
$clave=$_POST['clave'];

//$nombre="Erika";
//$apellido="Peralta";
//$usuario="erika01";
//$clave="123456";

$consulta=$conexion->prepare("INSERT INTO usuario(nombre, apellido, usuario, clave)VALUES(?,?,?,?)");
$consulta->bind_param('ssss',$nombre,$apellido,$usuario,$clave);
$consulta->execute();

		echo json_encode($nombre, $apellido, $usuario, $clave, JSON_UNESCAPED_UNICODE);

$consulta->close();
$conexion->close();

?>