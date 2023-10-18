package service;

import java.util.List;

import beans.EspecialistaDTO;
import dao.DAOFactory;
import interfaces.EspecialistaDAO;
import utils.Constantes;

public class EspecialistaService {
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGEN_DE_DATOS_MYSQL);
	EspecialistaDAO objEspecialista = fabrica.getEspecialista();
	
	public EspecialistaDTO iniciarSesion(String login,String pas) {
		return objEspecialista.iniciarSesion(login,pas);
	}
	
	public List<EspecialistaDTO> listaEspecialista(){
		return objEspecialista.listarEspecialista();
	} 
	public EspecialistaDTO buscarEspecialista(int cod) {
		return objEspecialista.buscarEspecialista(cod);
	}
	public int registrarEspecialista(EspecialistaDTO obj) {
		return objEspecialista.registrarEspecialista(obj);
	}
	public int actualizarEspecialista(EspecialistaDTO obj) {
		return objEspecialista.actualizarEspecialista(obj);
	}
	public int eliminarEspecialista(int cod) {
		return objEspecialista.eliminarEspecialista(cod);
	} 
}
