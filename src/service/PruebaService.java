package service;

import java.util.List;

import beans.PruebaDTO;
import dao.DAOFactory;
import interfaces.PruebaDAO;
import utils.Constantes;

public class PruebaService {
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGEN_DE_DATOS_MYSQL);
	PruebaDAO objPrueba = fabrica.getPrueba(); 
	
	public int registrarPrueba(PruebaDTO obj) {
		return objPrueba.registrarPrueba(obj);
	}
	public List<PruebaDTO> listaPrueba(){
		return objPrueba.listarPrueba();
		}
	public List<PruebaDTO> listaPruebaxCliente(int id_cliente){
		return objPrueba.listarPruebaxCliente(id_cliente);
		}
		public PruebaDTO buscarPrueba(int cod) {
			return objPrueba.buscarPrueba(cod);
		}
		public int actualizarPrueba(PruebaDTO obj) {
			return objPrueba.actualizarPrueba(obj);
		}
		public int eliminarPrueba(int cod) {
			return objPrueba.eliminarPrueba(cod);
		}

}
