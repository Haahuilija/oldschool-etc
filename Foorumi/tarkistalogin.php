<?php
include "yhteys.php";
session_start();

if(isset($_POST['submit'])){
	$kt = $_POST['kt'];
	$sala = sha1($_POST['sala']);

$sql = "SELECT * FROM kayttajat WHERE kt=? AND sala=?";

$stmt = $yhteys->prepare($sql);
$stmt->bind_param("ss", $kt, $sala);
$stmt->execute();
$stmt->store_result();
$row = $stmt->num_rows;

if($row > 0){
	echo "Kysely onnistui";
	
	$_SESSION['kt_id'] = $kt_id;
	$_SESSION['kt'] = $kt;
	$_SESSION['kirjautunut'] = true;
	
	header("location: etusivu.php");
}else{
	header("location: kirjautuminen.php");
	echo "<script type='text/javascript'>alert('Väärä käyttäjätunnus tai salasana!')</script>";
 }
}
?>