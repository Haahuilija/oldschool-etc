<?php
include "yhteys.php";
include "header.php";

if($_SESSION['kirjautunut'] == true){
	
//$result = $yhteys->query("SELECT avatar FROM kayttajat WHERE kt = {$_SESSION['kt']}");
    
$sql = "SELECT avatar FROM kayttajat WHERE kt = '{$_SESSION['kt']}'";
$result = $yhteys->query($sql);

        if ($result->num_rows > 0) {
            while($row = $result->fetch_assoc()) {
			echo '<div class="caption"><h3><img src="data:image/jpeg;base64,'.base64_encode($row['avatar']).'"/></h3></div>';
            }
        } else {
            echo "Ei kuvaa näytettävänä";
        }
	
}else{
	header("location: kirjautuminen.php");
}
include "footer.php";
?>