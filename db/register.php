<?php
 
require_once 'DB_Functions.php';
$db = new DB_Functions();
 
// json response array
$response = array("error" => FALSE);

//if(isset($_POST['register']))
if (isset($_POST['name']) && isset($_POST['email']) && isset($_POST['password']) && isset($_POST['mobileNo']) && isset($_POST['college']))
 {
	$name = $_POST['name'];
    $email = $_POST['email'];
	
	$pass = $_POST['password']; 								//unhashed password
	$password = password_hash($pass,PASSWORD_DEFAULT);		 	// encrypted password
	$mobileNo = $_POST['mobileNo'];
	$collegename = $_POST['college'];
 
    // check if user is already existed with the same email
    if ($db->isUserExisted($mobileNo)) 
    {
        $response["error"] = TRUE;
        $response["error_msg"] = "Username already exists with " . $mobileNo;
        echo json_encode($response);
    } 
    else 
    {
        // create a new user
        $user = $db->storeUser($name, $email, $phone, $collegename, $password, $pass);
        if ($user) 
        {
            // user stored successfully
            $response["error"] = FALSE;
            //$response["uid"] = $user["id"];
            $response["user"]["name"] = $user["name"];
            $response["user"]["email"] = $user["email"];
			$response["user"]["password"] = $user["password"];
			$response["user"]["mobileNo"] = $user["mobileNo"];
            $response["user"]["college"] = $user["college"];

            echo json_encode($response);
        }
        else 
        {
            // user failed to store
            $response["error"] = TRUE;
            $response["error_msg"] = "Unknown error occurred in registration!";
            echo json_encode($response);
        }
    }
} 
else 
{
    $response["error"] = TRUE;
    $response["error_msg"] = "Required parameters (name, email, password, collegename or phonenumber) is missing!";
    echo json_encode($response);
}
?>