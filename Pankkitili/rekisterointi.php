<?php
require_once "db/yhteys.php";
?>

<!doctype html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="rekisterCSS.css"/>
<meta charset="utf-8">
<title>Untitled Document</title>
</head>
<body>
<h1>Syötä tiedot kirjautumista varten</h1><br><br>

<form action="" method="post">

<fieldset><legend>Rekisteröidy</legend>

<div>
	<label for="etunimi">Etunimi</label>
	<input type="text" id="etunimi" name="etunimi" placeholder="Etunimi" required>
</div>	
<div>
	<label for="sukunimi">Sukunimi</label>
	<input type="text" id="sukunimi" name="sukunimi" placeholder="Sukunimi" required>
</div>	
<div>
	<label for="kayttajatunnus">Käyttäjätunnus</label>
	<input type="text" id="kayttajatunnus" name="kayttajatunnus" placeholder="Käyttäjätunnus" required>
</div>	
<div>
	<label for="salasana">Salasana</label>
	<input type="password" id="salasana" name="salasana" placeholder="Salasana" required>
</div>	
<div>
	<label for="salasana2"></label>
	<input type="password" id="salasana2" name="salasana2" placeholder="Syötä salasana uudestaan" required>
</div>	
<div>
	<label for="puhnro">Puhelinnumero</label>
	<input type="tel" id="puhnro" name="puhnro" placeholder="Puhelinnumero" required>
</div>	
<div>
	<label for="sposti">Sähköposti</label>
	<input type="text" id="sposti" name="sposti" placeholder="Sähköposti" required><br><br>
</div>	
	<input type="submit" name="submit" value="Tallenna tiedot"><br><br>

</fieldset>
</form>
<?php

if(isset($_POST['submit'])){
	$etunimi = $_POST['etunimi'];
	$sukunimi = $_POST['sukunimi'];
	$kayttajatunnus = $_POST['kayttajatunnus'];
	$salasana = sha1($_POST['salasana']);
	$salasana2 = sha1($_POST['salasana2']);
	$puhnro = $_POST['puhnro'];
	$sposti = $_POST['sposti'];

if(!empty($salasana == $salasana2)){	
	
$sql = "SELECT * FROM pankkitili WHERE kayttajatunnus = ? ";

$stmt = $yhteys->prepare($sql);
$stmt->bind_param("s", $kayttajatunnus);
$stmt->execute();
$stmt->store_result();
$row = $stmt->num_rows;

if($row == 0){
	echo "<script type='text/javascript'>alert('Käyttäjä luotu onnistuneesti.')</script>";
	$sql = "INSERT INTO pankkitili (etunimi, sukunimi, kayttajatunnus, salasana, puhnro, sposti) VALUES ('$etunimi', '$sukunimi', '$kayttajatunnus', '$salasana', '$puhnro', '$sposti')";
	
$result = $stmt->store_result();

if($result == true){
	echo "<script type='text/javascript'>alert('Käyttäjä luotu onnistuneesti.')</script>";
}
$tk_kysely = mysqli_query($yhteys, $sql);
}else{
	echo "<script type='text/javascript'>alert('Käyttäjätunnus on varattu!')</script>";
}
}else{
	echo "<script type='text/javascript'>alert('Salasanat eivät täsmää!')</script>";
}
}
?>

<br><br>

<a href="kirjautuminen.php" class="button">Kirjaudu sisään</a>

</body>
</html>