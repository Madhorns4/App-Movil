<?php
$conn = new mysqli("localhost", "root", "root1234", "bd_sviajes") or die(mysqli_error());

$id_usuario=$_POST['id_usuario'];
$numero_viaje=$_POST['numero_viaje'];
$id_pais=$_POST['id_pais'];
$id_provincia=$_POST['id_provincia'];
$id_ciudad=$_POST['id_ciudad'];
$id_lugar_turistico=$_POST['id_lugar_turistico'];

$fecha=$_POST['fecha'];
$hora=$_POST['hora'];
$costo_total=$_POST['costo_total'];

$i_u=(int)$id_usuario;
$n_viaje=(int) $numero_viaje;
$i_pa=(int)$id_pais;
$id_pr=(int)$id_provincia;
$id_ci=(int)$id_ciudad;
$id_lt =(int)$id_lugar_turistico;





$sql="INSERT INTO plan_viaje(num_viaje, id_usuario, id_pais, id_provincia, id_ciudad, id_lugar_turistico, fecha, hora, costo_total) VALUES($n_viaje,$i_u,$i_pa,$id_pr,$id_ci,$id_lt,'$fecha','$hora','$costo_total')";
$result = $conn->query($sql);
if($conn->query($sql))
{
 $posts['response'] = array("success" => "1", "msg" => "Inserted Successfully");
}else{
    $posts['response'] = array("success" => "1", "msg" =>  mysqli_error($conn)); 
    
}
header('content-type: application/json');

echo json_encode($posts);
@mysqli_close($conn);

?>