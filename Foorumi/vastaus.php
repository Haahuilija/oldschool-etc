<?php
include 'yhteys.php';
include 'header.php';
 
if($_SERVER['REQUEST_METHOD'] != 'POST'){
    echo 'This file cannot be called directly.';
}else{
	
    if(!$_SESSION['kirjautunut'] == true){
        echo 'You must be signed in to post a reply.';
    }else{
		
		$viesti_aihe = ($_GET['id']);
		$viesti_aihe = $yhteys->real_escape_string($viesti_aihe);
		$vastaus_sisalto = ($_POST['vastaus_sisalto']);
		$vastaus_sisalto = $yhteys->real_escape_string($vastaus_sisalto);
		$kt_id = ($_SESSION['kt_id']);
		$kt_id = $yhteys->real_escape_string($kt_id);
		
		$sql = "INSERT INTO `viestit`(`viesti_id`, `viesti_sisalto`, `viesti_aika`, `viesti_aihe`, `viesti_by`) VALUES ('$vastaus_sisalto', NOW(), '$viesti_aihe', '$kt_id')";
		
		$result = mysqli_query($yhteys, $sql);
                                                 
        if(!$result){
            echo "Viestiäsi ei tallennettu, jokin meni vikaan. Kokeile myöhemmin uudestaan.";
        }else{
            echo 'Viestisi tallennettiin, katsele <a href="aihe.php?id=' . htmlentities($_GET['id']) . '">aihetta.</a>.';
        }
    }
}
 
include 'footer.php';
?>