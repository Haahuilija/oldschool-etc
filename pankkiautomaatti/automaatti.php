<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Untitled Document</title>
</head>

<body>
<?php
$bankCard = true;
$pin = true;
	
	if($bankCard = true){
		echo "Tervetuloa! Syötä PIN numero.";
	}
	else {
		echo "Tämä kortti ei kelpaa! Syötä oikea pankkikortti.";
	}

	if($pin = true){
		echo "PIN numero oikein! Valitse haluamasi määrä nostoa varten.";
	}
	else{
		echo "PIN numero väärin! Syötä oikea numero.";
	}
	


?>
	

<form action="" method="post">
Haluamasi määrä: <input type="text" name="haluamasimaara"><br>
<input type="submit">
</form>
<?php


	
$tilinsaldo = 3600;
	
	if ($haluamasimaara < $tilinsaldo){
		echo "Tilillä ei ole katetta!";
	}else{
		echo "Rahat ovat tulossa!";
	}

?>	

		
</body>
</html>