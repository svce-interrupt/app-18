<?php
class DB_Connect {
    private $conn;
 
    public function connect() {
        //require_once 'Config.php';
        define("DB_HOST", "localhost:3307");
		define("DB_USER", "myuser");
		define("DB_PASSWORD", "myuser");
		define("DB_DATABASE", "register");        // db name. also used by web team

         
        $this->conn = new mysqli(DB_HOST, DB_USER, DB_PASSWORD, DB_DATABASE);
         
        return $this->conn;
    }
}
 
?>