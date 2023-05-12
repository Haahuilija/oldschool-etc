<!DOCTYPE html>
<html>
<head>
<title>Page Title</title>
</head>
<body>

<?php

$tiedosto = 'arvosanat.txt';
$array = explode("\n", file_get_contents($tiedosto));

foreach($array as & $numero){
	if($numero < 5){
		$numero = $numero + 1;
	}else{
		$numero = $numero;
}
}
unset($numero);

$fp = fopen('tulokset.txt', 'w');
fwrite($fp, print_r($array, TRUE));
fclose($fp);

echo "Uudet tulokset ovat:" . "<br>";

foreach($array as $key => $value)
{ 
  echo $value . "<br>";
}

?>
</body>
</html>