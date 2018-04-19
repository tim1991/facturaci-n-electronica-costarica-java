<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Dashboard extends CI_Controller {

	/**
	 * Index Page for this controller.
	 *
	 * Maps to the following URL
	 * 		http://example.com/index.php/welcome
	 *	- or -
	 * 		http://example.com/index.php/welcome/index
	 *	- or -
	 * Since this controller is set as the default controller in
	 * config/routes.php, it's displayed at http://example.com/
	 *
	 * So any other public methods not prefixed with an underscore will
	 * map to /index.php/welcome/<method_name>
	 * @see https://codeigniter.com/user_guide/general/urls.html
	 */
	 public function __construct()
	 {
			 parent::__construct();

       $this->load->model('usuarios_model');
       $this->load->model('auth_model');

	 }

	public function index()
	{

    if(isset($this->session->userdata['logged_in'])){
    // $empresa_id = $permisos[0]->empresa;

		$id =  $this->session->userdata['logged_in']['id'];
		$data['usuario_info'] = $this->usuarios_model->datos_user_id($id);
		$data['facturas'] = $this->auth_model->ultimas_facturas($id);
		$data['titulo'] = 'Dashboard';

		$this->load->view('dashboard/header',$data);
		$this->load->view('dashboard/menu',$data);
		$this->load->view('dashboard/sidebar',$data);
		$this->load->view('dashboard/aside',$data);
		$this->load->view('dashboard/index',$data);
		$this->load->view('dashboard/footer',$data);

}else{
    echo '<script>window.location.href = "'.base_url().'index.php/dashboard/login";</script>';
}

	}
	public function login()
	{

	$this->load->view('dashboard/sign-in');

	}
	public function do_login()
	{


                if(isset($this->session->userdata['logged_in'])){

                    echo '<script>window.location.href = "'.base_url().'index.php/dashboard";</script>';
                }

                $data = array(
                    'username' => $this->input->post('email'),
                    'password' => md5($this->input->post('contrasena'))
                );


                $result = $this->usuarios_model->login($data);
                if ($result == TRUE) {

                    $username = $this->input->post('email');
                    $result = $this->usuarios_model->read_user_information($username);
                        if ($result != false) {
                            $session_data = array(
                                'username' => $result[0]->usuario,
                                'id' => $result[0]->id,
                                'rol' => $result[0]->rol,
                                'email' => $result[0]->email,
                            );
                            // Add user data in session
                            $this->session->set_userdata('logged_in', $session_data);
                            echo '<script>window.location.href = "'.base_url().'index.php/dashboard";</script>';
                        }
                } else {
                     echo '<script>window.location.href = "'.base_url().'index.php/dashboard/login?e=2";</script>';
            }

	}



	public function tokens(){

		if(isset($this->session->userdata['logged_in'])){
		// $empresa_id = $permisos[0]->empresa;

		$id =  $this->session->userdata['logged_in']['id'];
		$data['usuario_info'] = $this->usuarios_model->datos_user_id($id);
		$data['tokens'] = $this->auth_model->tokens($id);

		$data['titulo'] = 'Tokens';

		$this->load->view('dashboard/header',$data);
		$this->load->view('dashboard/menu',$data);
		$this->load->view('dashboard/sidebar',$data);
		$this->load->view('dashboard/aside',$data);
		$this->load->view('dashboard/tokens',$data);
		$this->load->view('dashboard/footer',$data);

}else{
		echo '<script>window.location.href = "'.base_url().'index.php/dashboard/login";</script>';
}

	}


	public function logout() {

			$sess_array = array(
					'username' => '',
					'id'=> '',
					'rol'=> '',
					'email'=> ''
			);
			$this->session->unset_userdata('logged_in', $sess_array);
					echo '<script>window.location.href = "'.base_url().'index.php/dashboard/login";</script>';
	}






}
