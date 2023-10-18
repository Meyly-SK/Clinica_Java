package dao;

import interfaces.CitaDAO;
import interfaces.ClienteDAO;
import interfaces.EspecialistaDAO;
import interfaces.InformeDAO;
import interfaces.PruebaDAO;

public class MySqlDAOFactory extends DAOFactory {

	@Override
	public CitaDAO getCita() {
		return new MySqlCitaDAO();
	}
	public ClienteDAO getCliente() {
		return new MySqlClienteDAO();
	}
	public EspecialistaDAO getEspecialista() {
		return new MySqlEspecialistaDAO();
	}
	public PruebaDAO getPrueba() {
		return new MySqlPruebaDAO();
	}
	public InformeDAO getInforme() {
		return new MySqlInformeDAO();
	}

}
