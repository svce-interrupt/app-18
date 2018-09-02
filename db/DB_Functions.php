<?php
 
class DB_Functions {
 
    private $conn;
 
    function __construct() {
        require_once 'DB_Connect.php';
        $db = new Db_Connect();
        $this->conn = $db->connect();
    }
 
    function __destruct() {
         
    }
 
    /**
     * Storing new user
     * returns user details
     */
    public function storeUser($name, $email, $mobileNo, $collegename, $password, $unhashed_pass) {
		$singleevent = 0;
       
        $stmt = $this->conn->prepare("INSERT INTO users VALUES(?,?,?,?,?)");
        $stmt->bind_param("sssss", $mobileNo,$password,$collegename,$name,$email);
        $result = $stmt->execute();
        $stmt->close();
		
		$user = $this->getUserBymobileNoAndPassword($mobileNo, $unhashed_pass);
		//$uid = $user['mobileNo'];
        $uid=$mobileNo;
		
		$stmt1 = $this->conn->prepare("INSERT INTO events VALUES(?,?,?,?,?,?,?,?,?,?,?)");
        $stmt1->bind_param("siiiiiiiiii", $uid, $singleevent, $singleevent, $singleevent, $singleevent, $singleevent, $singleevent, $singleevent, $singleevent, $singleevent, $singleevent);
        $result1 = $stmt1->execute();
        $stmt1->close();
 
        // check for successful store
        if ($result && $result1) {
            $stmt = $this->conn->prepare("SELECT * FROM users WHERE mobileNo = ?");
            $stmt->bind_param("s", $mobileNo);
            $stmt->execute();
            $user = $stmt->get_result()->fetch_assoc();
            $stmt->close();
 
            return $user;
        } else {
            return false;
        }
    }
	
 	public function getUserBymobileNoAndPassword($mobileNo, $password) {
		
		$stmt = $this->conn->prepare("SELECT * FROM users WHERE mobileNo = ?");
		$stmt->bind_param("s", $mobileNo);
		
        if ($stmt->execute()) {
            $user = $stmt->get_result()->fetch_assoc();
            $stmt->close();
			
            // verifying user password
			$dbPass = $user['password'];
			
            // check for password equality
	
            if(password_verify($password,$dbPass)) {
                // user authentication details are correct
                return $user;
            }
        } else {
            return NULL;
        }
    }
	
	public function getUserEvents($mobileNo) {
		
		$user = $this->getUserBymobileNo($mobileNo);
		$uid = $user['mobileNo'];
 
        $stmt = $this->conn->prepare("SELECT * FROM events WHERE mobileNo = ?");
 
        $stmt->bind_param("s", $uid);
 
        if ($stmt->execute()) {
            $eventslist = $stmt->get_result()->fetch_assoc();
            $stmt->close();
 
			return $eventslist;
            }
		else {
            return NULL;
        }
    }
 
    /**
     * Check user exists or not
     */
    public function isUserExisted($mobileNo) {
        $stmt = $this->conn->prepare("SELECT mobileNo from users WHERE mobileNo = ?");
 
        $stmt->bind_param("s", $mobileNo);
 
        $stmt->execute();
 
        $stmt->store_result();
 
        if ($stmt->num_rows > 0) {
            $stmt->close();
            return true;
        } else {
            $stmt->close();
            return false;
        }
    }
		
	 public function getUserBymobileNo($mobileNo) {
 
        $stmt = $this->conn->prepare("SELECT * FROM users WHERE mobileNo = ?");
 
        $stmt->bind_param("s", $mobileNo);
 
        if ($stmt->execute()) {
            $user = $stmt->get_result()->fetch_assoc();
            $stmt->close();
			
			$phone = $user['mobileNo'];
			
            // check for e-mail equality
            if ($phone == $mobileNo) {
                // user authentication details are correct
                return $user;
            }
        } else {
            return NULL;
        }
    }
 
}
 