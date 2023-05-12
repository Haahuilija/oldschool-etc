<?php
include "yhteys.php";
include "header.php";

	if($_SESSION['kirjautunut'] == true){
		echo "Tervetuloa {$_SESSION['kt']}";
?>
<!DOCTYPE html>
	<body>
		<form action="lataa.php" method="post" enctype="multipart/form-data">
			Valitse kuva jonka haluat ladata:
				<input type="file" name="image"/>
				<input type="submit" name="submit" value="Lataa Kuva"/>
		</form>
	</body>
</html>
<?php
$kuva;
	}else{
		header("location: kirjautuminen.php");
	}
include "footer.php";
?>