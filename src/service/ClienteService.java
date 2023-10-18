package service;

import java.util.List;

import beans.ClienteDTO;
import dao.DAOFactory;
import interfaces.ClienteDAO;
import utils.Constantes;

public class ClienteService {
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGEN_DE_DATOS_MYSQL);
	ClienteDAO objCliente = fabrica.getCliente(); 
	
	public ClienteDTO iniciarSesion(String login, String contra) {
		return objCliente.iniciarSesion(login, contra);
	}
	
	public List<ClienteDTO> listaCliente(){
	return objCliente.listarCliente();
	} 
	public ClienteDTO buscarCliente(int cod) {
		return objCliente.buscarCliente(cod);
	}

	public int registrarCliente(ClienteDTO obj) {
		return objCliente.registrarCliente(obj);
	}
	public int actualizarCliente(ClienteDTO obj) {
		return objCliente.actualizarCliente(obj);
	}
	public int eliminarCliente(int cod) {
		return objCliente.eliminarCliente(cod);
	} 
}
