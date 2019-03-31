<?php
    /**
    *Database config variables,
    */
    define("DB_HOST","YOUR HOST NAME"); 
    define("DB_USER","YOUR USERNAME");
    define("DB_PASSWORD","YOUR PASSWORD");
    define("DB_DATABASE","DATABASE NAME");
 
    $connection = mysqli_connect(DB_HOST, DB_USER, DB_PASSWORD, DB_DATABASE);
 
    if(mysqli_connect_errno()){
        die("Database connnection failed " . "(" .
            mysqli_connect_error() . " - " . mysqli_connect_errno() . ")"
                );
    }
?>