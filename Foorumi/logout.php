<?php
include "yhteys.php";
include "header.php";

if($_SESSION['kirjautunut'] == true){
	session_destroy();
	header("location: kirjautuminen.php");
}

include "footer.php";
?>