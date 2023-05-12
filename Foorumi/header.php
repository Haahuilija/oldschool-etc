<?php
include "yhteys.php";
session_start();
?>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Puffington Host</title>
    <link rel="stylesheet" type="text/css" href="tyylit.css"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body data-spy="scroll" data-target=".navbar" data-offset="50">

<div class="jumbotron" style="background-image: url(https://png.pngtree.com/thumb_back/fw800/back_pic/03/62/30/9157aa94e693d90.jpg); background-size: 100% 100%;">
    <h1 style="color:#F0FFFF;"><b>Puffington Host</b></h1>
    <h3 style="color:#F0FFFF;"><i>"Life is hard. After all, it kills you."</i></h3>
  </div>
<nav class="navbar navbar-inverse" data-spy="affix" data-offset-top="197">
  <div class="container-fluid">
    <div class="navbar-header">
     	<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>                      
      </button>
    </div>
    <div>
    <div class="collapse navbar-collapse" id="myNavbar">
    <ul class="nav navbar-nav">
      <li class="active"><a href="etusivu.php"><span class="glyphicon glyphicon-home"></span>Koti</a></li>
      <li><a href="luoAihe.php">Luo Aihe</a></li>
      <li><a href="luoKategoria.php">Luo Kategoria</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
    <?php
     if($_SESSION['kirjautunut'] != true){
		 ?>
     <li><a href="kirjautuminen.php"><span class="glyphicon glyphicon-log-in"></span> Kirjaudu</a></li>
     <li><a href="rekisterointi.php"><span class="glyphicon glyphicon-user"></span> Rekisteröidy</a></li>
		<?php }else{ ?>
     <li><a href="profiili.php"><span class="glyphicon glyphicon-user"></span>Käyttäjän<?php echo" {$_SESSION['kt']} "?> Profiili</a></li>
     <li><a href="logout.php"><span class="glyphicon glyphicon-log-in"></span> Kirjaudu Ulos</a></li>
    <?php } ?>
    </ul>
  </div>  
  </div>
</nav>
</nav>