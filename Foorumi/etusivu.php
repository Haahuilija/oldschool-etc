<?php
include "yhteys.php";
include "header.php";

if($_SESSION['kirjautunut'] == true){
	
$sql = "SELECT * FROM kategoriat";
			
$result = mysqli_query($yhteys, $sql);
 
	
        echo '<table border="1">
              <tr>
                <th></th>
                <th>Viimeaikainen toiminta</th>
              </tr>'; 
             
        while($row = mysqli_fetch_assoc($result))
        {               
            echo '<tr>';
                echo '<td class="leftpart">';
                    echo '<h3><a href="kategoriat.php?id=' . $row['kat_id'] . ' ">' . $row['kat_nimi'] . '</a></h3>' . $row['kat_kuvaus'];
                echo '</td>';
                echo '<td class="rightpart">';
                            echo '<a href="aihe.php?id=">Aihe</a>';
                echo '</td>';
            echo '</tr>';
        }
    

     	
}else{
	header("location: kirjautuminen.php");
}
include "footer.php";
?>