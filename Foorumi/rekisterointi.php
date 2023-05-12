<?php
include "yhteys.php";
include "header.php";
?>

<br><br>

	<form action="" method="post">

	<fieldset><legend>Rekisteröidy</legend>

<div>
	<label for="etun">Etunimi</label>
	<input type="text" id="etun" name="etun" placeholder="Etunimi" required>
</div>	
<div>
	<label for="sukun">Sukunimi</label>
	<input type="text" id="sukun" name="sukun" placeholder="Sukunimi" required>
</div>	
<div>
	<label for="kt">Käyttäjätunnus</label>
	<input type="text" id="kt" name="kt" placeholder="Käyttäjätunnus" required>
</div>	
<div>
	<label for="sala">Salasana</label>
	<input type="password" id="sala" name="sala" placeholder="Salasana" required>
</div>	
<div>
	<label for="sala2"></label>
	<input type="password" id="sala2" name="sala2" placeholder="Syötä salasana uudestaan" required>
</div>
<div>
	<label for="email">Sähköposti</label>
	<input type="text" id="email" name="email" placeholder="Sähköposti" required><br><br>
</div>	
	<input type="submit" name="submit" value="Tallenna tiedot"><br><br>

</fieldset>
</form>

<?php

if(isset($_POST['submit'])){
	$etun = $_POST['etun'];
	$sukun = $_POST['sukun'];
	$kt = $_POST['kt'];
	$sala = sha1($_POST['sala']);
	$sala2 = sha1($_POST['sala2']);
	$email = $_POST['email'];

if(!empty($sala == $sala2)){	
	
$sql = "SELECT * FROM kayttajat WHERE kt = ? ";

$stmt = $yhteys->prepare($sql);
$stmt->bind_param("s", $kt);
$stmt->execute();
$stmt->store_result();
$row = $stmt->num_rows;

if($row == 0){
	echo "<script type='text/javascript'>alert('Käyttäjä luotu onnistuneesti.')</script>";
	$sql = "INSERT INTO kayttajat (etun, sukun, kt, sala, email, ktpvm) VALUES ('$etun', '$sukun', '$kt', '$sala', '$email', NOW())";
	
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

include "footer.php";	
?>