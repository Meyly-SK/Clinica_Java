package service;

import java.util.List;

import beans.InformeDTO;
import dao.DAOFactory;
import interfaces.InformeDAO;
import utils.Constantes;

public class InformeService {
	
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGEN_DE_DATOS_MYSQL);
	InformeDAO objInforme = fabrica.getInforme(); 
	
	public List<InformeDTO> listaInforme(){
	return objInforme.listarInforme();
	}
	public List<InformeDTO> listaInformexCliente(int cod){
		return objInforme.listarInformexCliente( cod);
		}
	public InformeDTO buscarInforme(int cod) {
		return objInforme.buscarInforme(cod);
	}
	public int registrarInforme(InformeDTO obj) {
		return objInforme.registrarInforme(obj);
	}
	public int actualizarInforme(InformeDTO obj) {
		return objInforme.actualizarInforme(obj);
	}
	public int eliminarInforme(int cod) {
		return objInforme.eliminarInforme(cod);
	}
}
