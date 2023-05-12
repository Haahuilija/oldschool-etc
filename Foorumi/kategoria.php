<?php
include "yhteys.php";
include "header.php";

if($_SESSION['kirjautunut'] == true){

$kat_id = ($_GET['id']);
	
$sql = "SELECT
            kat_id,
            kat_nimi,
            kat_kuvaus
        FROM
            kategoriat";/*
        WHERE
            kat_id = " . "$kat_id";*/
 
$result = mysqli_query($yhteys, $sql);
 
if(!$result)
{
    echo 'The category could not be displayed, please try again later.';
}
else
{
    if(mysqli_num_rows($result) == 0)
    {
        echo 'This category does not exist.';
    }
    else
    {
    
        while($row = mysqli_fetch_assoc($result))
        {
            echo '<h2>Topics in ′' . $row['kat_nimi'] . '′ category</h2>';
        }
     
        $sql = "SELECT  
                    aihe_id,
                    aihe_sisalto,
                    aihe_aika,
                    aihe_kat
                FROM
                    aiheet";/*
                WHERE
                    aihe_kat = " . mysqli_real_escape_string($_GET['id']);*/
         
        $result = mysqli_query($yhteys, $sql);
         
        if(!$result)
        {
            echo 'The topics could not be displayed, please try again later.';
        }
        else
        {
            if(mysqli_num_rows($result) == 0)
            {
                echo 'There are no topics in this category yet.';
            }
            else
            {
                //prepare the table
                echo '<table border="1">
                      <tr>
                        <th>Aihe</th>
                        <th>Luotu</th>
                      </tr>'; 
                     
                while($row = mysqli_fetch_assoc($result))
                {               
                    echo '<tr>';
                        echo '<td class="leftpart">';
                            echo '<h3><a href="aihe.php?id=' . $row['aihe_id'] . '">' . $row['aihe_sisalto'] . '</a><h3>';
                        echo '</td>';
                        echo '<td class="rightpart">';
                            echo date('d-m-Y', strtotime($row['aihe_aika']));
                        echo '</td>';
                    echo '</tr>';
                }
            }
        }
    }
}
 
	
}else{
	header("location: kirjautuminen.php");
}
include "footer.php";
?>