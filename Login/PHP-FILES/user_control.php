<?php

include_once 'connection.php';

	$user = new User();
	if(isset($_POST['email'],$_POST['senha'])) {
		$email = $_POST['email'];
		$password = $_POST['senha'];
		
		if(!empty($email) && !empty($password)){
			
			//$encrypted_password = md5($password);
			$user-> does_user_exist($email,$password);
			
		}else{
			echo json_encode("you must type both inputs");
		}
		
	}
	
	class User {
		
		private $db;
		private $connection;
		
		function __construct() {
			$this -> db = new DB_Connection();
			$this -> connection = $this->db->getConnection();
		}
		
		public function does_user_exist($email,$password)
		{
			$query = "Select * from cfxbase where email='$email' and senha = '$password' ";
			$result = mysqli_query($this->connection, $query);
			if(mysqli_num_rows($result)>0){
				$json['ok'] = 'Welcome';
				//$json['ok'] = ' Welcome '.$email;
                                echo json_encode($json);
				mysqli_close($this -> connection);
			}else{
                        $json['erro'] = 'Wrong password';
				//$query = "insert into USERS (email, password) values ( '$email','$password')";
				//$inserted = mysqli_query($this -> connection, $query);
				//if($inserted == 1 ){
				//	$json['success'] = 'Acount created';
				//}else{
				//	$json['error'] = 'Wrong password';
				//}
				echo json_encode($json);
				mysqli_close($this->connection);
			}
			
		}
		
	}
	

?>
