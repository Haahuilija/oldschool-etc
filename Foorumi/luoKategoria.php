<?php
include "yhteys.php";
include "header.php";

	if($_SESSION['kirjautunut'] == true){
		if($_SERVER['REQUEST_METHOD'] != 'POST'){
    
    echo "<form method='post' action=''>
        Kategorian nimi: <input type='text' name='kat_nimi' />
        Kuvaus: <textarea name='kat_kuvaus' /></textarea>
        <input type='submit' value='Lisää kategoria' />
     </form>";
}else{
	$kat_nimi = ($_POST['kat_nimi']);
	$kat_kuvaus =($_POST['kat_kuvaus']);
	
    $sql = "INSERT INTO kategoriat(kat_nimi, kat_kuvaus) VALUES ('$kat_nimi' , '$kat_kuvaus')";
    $result = mysqli_query($yhteys, $sql);
    if(!$result){
        echo 'Error';
			}else{
				echo 'New category successfully added.';
    }
}

	}else{
		header("location: kirjautuminen.php");
}
include "footer.php";
?>