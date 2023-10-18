package dao;

import interfaces.CitaDAO;
import interfaces.ClienteDAO;
import interfaces.EspecialistaDAO;
import interfaces.InformeDAO;
import interfaces.PruebaDAO;


public abstract class DAOFactory {
	//Posibles origenes de Datos
	public static final int MYSQL = 1;
	public static final int ORACLE = 2;
	public static final int ACCESS = 3;
	public static final int DB2 = 4;
	public static final int SQLSERVER = 5;
	
	//Referencia a nuestra interfaces
	
	public abstract CitaDAO getCita();
	public abstract ClienteDAO getCliente();
	public abstract EspecialistaDAO getEspecialista();
	public abstract PruebaDAO getPrueba();
	public abstract InformeDAO getInforme();
	
	public static DAOFactory getDAOFactory(int whichFactory) {
		switch(whichFactory) {
		case MYSQL :
			return new MySqlDAOFactory();
		case ORACLE :
			//return new OracleDAOFactory();
		case SQLSERVER:
			//return new SQLServerDAOFactory();
		}
		return null;
	}

}
