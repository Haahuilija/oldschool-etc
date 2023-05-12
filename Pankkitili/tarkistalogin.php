<?php
require_once "db/yhteys.php";
session_start();
?>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Untitled Document</title>
</head>

<body>
<?php
if(isset($_POST['submit'])){
	$kayttajatunnus = $_POST['kayttajatunnus'];
	$salasana = sha1($_POST['salasana']);

$sql = "SELECT * FROM pankkitili WHERE kayttajatunnus=? AND salasana=? ";

$stmt = $yhteys->prepare($sql);
$stmt->bind_param("ss", $kayttajatunnus, $salasana);
$stmt->execute();
$stmt->store_result();
$row = $stmt->num_rows;

if($row > 0){
	echo "Kysely onnistui";	
	$_SESSION['kayttajatunnus'] = $kayttajatunnus;
	$_SESSION['kirjautunut'] = true;
	header("location: tili.php");
}else{
	header("location: kirjautuminen.php");
}


}
?>
</body>
</html>