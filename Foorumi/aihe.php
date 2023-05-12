<?php
include "yhteys.php";
include "header.php";

if($_SESSION['kirjautunut'] == true){

$viesti_aihe = $_GET['id'];
$viesti_aihe = $yhteys->real_escape_string($viesti_aihe);

	$result = mysqli_query($yhteys, 
	"SELECT 
		viestit.viesti_id,
		viestit.viesti_sisalto,
		viestit.viesti_aika,
		viestit.viesti_aihe,
		viestit.viesti_by,
		kayttajat.kt_id,
		kayttajat.kt,
		kayttajat.avatar
	FROM 
		viestit 
	LEFT JOIN
		kayttajat
	ON
		viestit.viesti_by = kayttajat.kt_id
	WHERE 
		viesti_aihe = '$viesti_aihe'
	ORDER BY 
		viestit.viesti_aika DESC");

	
	echo '<table border="2">
              <tr>
                <th></th>
                <th></th>
              </tr>'; 
	
	while($row = mysqli_fetch_assoc($result)){
		
		 echo '<tr>';
                echo '<td class="leftpart">';
                    echo '<h4><a' . $row['viesti_id'] . ' ">' . $row['viesti_sisalto'] . '</a></h4>';
                echo '</td>';
                echo '<td class="rightpart">';
                            echo '<a>' . $row['viesti_by'] . ' , ' . $row['viesti_aika'] . ' , ' . '<img src="data:image/jpeg;base64,'.base64_encode($row['avatar']). '"</a>';
                echo '</td>';
            echo '</tr>';
		
	}
?>
<form method="post" action="">
    <textarea name="vastaus_sisalto"></textarea>
    <input type="submit" name="vastaus_sisalto" value="Lähetä viesti" />
</form>
<?php
	
		$viesti_aihe = $_GET['id'];
		$viesti_aihe = $yhteys->real_escape_string($viesti_aihe);
		$vastaus_sisalto = $_POST['vastaus_sisalto'];
		$vastaus_sisalto = $yhteys->real_escape_string($vastaus_sisalto);
		$kt_id = $_SESSION['kt_id'];
		$kt_id = $yhteys->real_escape_string($kt_id);
		
		$sql = "INSERT INTO viestit (viesti_sisalto, viesti_aika, viesti_aihe, viesti_by) VALUES ('$vastaus_sisalto', NOW(), '$viesti_aihe', '$kt_id')";
		$kysely = mysqli_query($yhteys, $sql);
                                                 
        if(!$kysely){
            echo "Viestiäsi ei tallennettu, jokin meni vikaan. Kokeile myöhemmin uudestaan.";
			die(mysqli_error($yhteys));
        }else{
            echo 'Viestisi tallennettiin, katsele <a href="aihe.php?id=' . htmlentities($_GET['id']) . '">aihetta.</a>.';
        }
	
	
}else{
	header("location: kirjautuminen.php");
}
include "footer.php";
?>