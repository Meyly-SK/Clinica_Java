package service;

import java.util.List;

import beans.CitaDTO;
import dao.DAOFactory;
import interfaces.CitaDAO;
import utils.Constantes;

public class CitaService {
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGEN_DE_DATOS_MYSQL);
	CitaDAO objCita = fabrica.getCita(); 
	
	public List<CitaDTO> listaCita(){
	return objCita.listarCita();
	}
	public List<CitaDTO> listaCitaxCliente(int id_cliente){
		return objCita.listarCitaxCliente(id_cliente);
	}
	public CitaDTO buscarCita(int cod) {
		return objCita.buscarCita(cod);
	}
	public int registrarCita(CitaDTO obj) {
		return objCita.registrarCita(obj);
	}
	public int actualizarCita(CitaDTO obj) {
		return objCita.actualizarCita(obj);
	}
	public int eliminarCita(int cod) {
		return objCita.eliminarCita(cod);
	}
}
