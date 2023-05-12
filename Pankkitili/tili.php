<?php
include "db/yhteys.php";
session_start();
if($_SESSION['kirjautunut'] == true){
?>
<!doctype html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="rekisterCSS.css"/>
<meta charset="utf-8">
<title>Untitled Document</title>
</head>
<body>

<?php

echo "Tervetuloa {$_SESSION['kayttajatunnus']}";













}else{
	header("location: kirjautuminen.php");
}
?>
</body>
</html>
