<?php
include "yhteys.php";
include "header.php";

if($_SESSION['kirjautunut'] == true){

if(isset($_POST["submit"])){
    $tarkista = getimagesize($_FILES["image"]["tmp_name"]);
    if($tarkista !== false){
        $kuva = $_FILES['image']['tmp_name'];
        $kuva = addslashes(file_get_contents($kuva));
		$kuva = $yhteys->real_escape_string($kuva);
		
$lisaa = $yhteys->query("UPDATE kayttajat SET avatar = '$kuva' WHERE kt = '{$_SESSION['kt']}'");

        if($lisaa){
            echo "Kuva lisätty onnistuneesti.";
        }else{
            echo "Kuvan lisäyksessä ongelma.";
        } 
    }else{
        echo "Valitse kuva jonka lisäät.";
    }
}

}else{
	header("location: kirjautuminen.php");
}
include "footer.php";
?>