<?php
include "yhteys.php";
include "header.php";

echo "<h2>Luo aihe</h2>";
if($_SESSION['kirjautunut'] == true){
    
    
        
        $sql = "SELECT
                    kat_id,
                    kat_nimi,
                    kat_kuvaus
                FROM
                    kategoriat";
         
        $result = mysqli_query($yhteys, $sql);
         
        if(!$result)
        {
            echo 'Error while selecting from database. Please try again later.';
        }
        else
        {
            if(mysqli_num_rows($result) == 0)
            {
				
                if($_SESSION['kt_lvl'] == 1)
                {
                    echo 'You have not created categories yet.';
                }
                else
                {
                    echo 'Before you can post a topic, you must wait for an admin to create some categories.';
                }
            }
            else
            {
         
                echo '<form method="post" action="">
                    Aihe: <input type="text" name="aihe_sisalto" />
                    Kategoria:'; 
                 
                echo '<select name="aihe_kat">';
                    while($row = mysqli_fetch_assoc($result))
                    {
                        echo '<option value="' . $row['kat_id'] . '">' . $row['kat_nimi'] . '</option>';
                    }
                echo '</select>'; 
                echo '<input type="submit" value="Luo Aihe" />
                 </form>';    
            }
        }
    
			$aihe_kat = $_POST['aihe_kat'];
			$aihe_kat = $yhteys->real_escape_string($aihe_kat);
			$aihe_sisalto = $_POST['aihe_sisalto'];
			$aihe_sisalto = $yhteys->real_escape_string($aihe_sisalto);
			$aihe_by = $_SESSION['kt_id'];
			$aihe_by = $yhteys->real_escape_string($aihe_by);
			
            $sql = "INSERT INTO aiheet (aihe_sisalto, aihe_aika, aihe_kat, aihe_by) VALUES ('$aihe_sisalto', NOW(), '$aihe_kat', '$aihe_by')";
        
            $result = mysqli_query($yhteys, $sql);
     if(!$result){
        echo "Virhe!";
		die(mysqli_error($yhteys));
			}else{
				echo "New topic successfully added.";
				}

    
 

}else{
	header("location: kirjautuminen.php");
}
include "footer.php";
?>