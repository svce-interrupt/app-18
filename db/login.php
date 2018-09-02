<?php
require_once 'DB_Functions.php';
$db = new DB_Functions();
 
// json response array
$response = array("error" => FALSE);
 
 $_POST["mobileNo"] = "9876543210";
 $_POST["password"] = "dfijnviw";
 
if (isset($_POST['mobileNo']) && isset($_POST['password'])) {
 
    $mobileNo = $_POST['mobileNo'];
    $password = $_POST['password'];
 
    // get the user by email and password
    $user = $db->getUserBymobileNoAndPassword($mobileNo, $password);
    //echo $user;
    if ($user) {
        // user is found
        $response["error"] = FALSE;
		
		//$eventslist = $db->getUserEvents($email);
		//if($eventslist != false){
		        //$response["eid"] = $eventslist["id"];												// tried my events as per last year events.
				/*$response["eventslist"]["Battle Code"] = $eventslist["e1"];
				$response["eventslist"]["Flip a Table!"] = $eventslist["e2"];
				$response["eventslist"]["First Strike"] = $eventslist["e3"];
				$response["eventslist"]["Breaking the Logician's Code"] = $eventslist["e4"];
				$response["eventslist"]["Presentation Park"] = $eventslist["e5"];
				$response["eventslist"]["Quiz Wiz"] = $eventslist["e6"];
				$response["eventslist"]["Surprise Event"] = $eventslist["e7"];
				$response["eventslist"]["Mind your Business v4.0"] = $eventslist["e8"];
				$response["eventslist"]["Coder's Bay"] = $eventslist["e9"];
				$response["eventslist"]["Connect 4"] = $eventslist["e10"];
				$response["eventslist"]["Picturesque"] = $eventslist["e11"];
				*/
				//$response["uid"] = $user["id"];
				$response["user"]["name"] = $user["name"];
				$response["user"]["email"] = $user["email"];
				$response["user"]["password"] = $user["password"];
				$response["user"]["mobileNo"] = $user["mobileNo"];
				$response["user"]["college"] = $user["college"];
		
        
		
        echo json_encode($response);
		//}
    } 
    else {
        // user is not found with the credentials
        $response["error"] = TRUE;
        $response["error_msg"] = "Please enter valid login credentials.";
        echo json_encode($response);
    }
} 
else {
    // required post params is missing
    $response["error"] = TRUE;
    $response["error_msg"] = "Required parameters email or password is missing!";
    echo json_encode($response);
}
?>