<?php
include "db/yhteys.php";
?>
<!doctype html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="rekisterCSS.css"/>
<meta charset="utf-8">
<title>Untitled Document</title>
</head>

<body>


<form  action="tarkistalogin.php" method="post">
<fieldset><legend>Kirjaudu</legend>
<label for="kayttajatunnus">Käyttäjätunnus</label>
<input type="text" name="kayttajatunnus" placeholder="Käyttäjätunnus">
<label for="salasana">Salasana</label>
<input type="password" name="salasana" placeholder="Salasana"><br><br>
<input type="submit" value="Kirjaudu" name="submit">

</fieldset>
</form>

<?php
if(empty($_POST['kayttajatunnus']) || empty($_POST['salasana'])){
	
		//echo '<p style="color: red; text-align: center">Syötä käyttäjätunnus sekä salasana!</p>';
}


?>

<br><br>
<a href="rekisterointi.php" class="button">Rekisteröidy</a>

</body>
</html>