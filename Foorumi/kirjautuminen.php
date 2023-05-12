<?php
include "yhteys.php";
include "header.php";
?>
<br><br>

<form action="tarkistalogin.php" method="post">
	<fieldset><legend>Kirjaudu</legend>
<div>
	<label for="kt">Käyttäjätunnus</label>
		<input type="text" name="kt" placeholder="Käyttäjätunnus">
</div>
<div>
	<label for="sala">Salasana</label>
		<input type="password" name="sala" placeholder="Salasana"><br><br>
</div>
	<input type="submit" value="Kirjaudu" name="submit">
</fieldset>
</form>

<?php
	if(empty($_POST['kt']) || empty($_POST['sala'])){
			//echo '<p style="color: red; text-align: center">Syötä käyttäjätunnus sekä salasana!</p>';
	}
include "footer.php";
?>