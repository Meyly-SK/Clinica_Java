package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.AdministradorDTO;
import beans.ClienteDTO;
import utils.MysqlDBConexion;

public class ModelAdministrador {

	public AdministradorDTO iniciarSesionAdmin(String log, String pas) {
		AdministradorDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from administrador where email_admin=? and contra_admin =? ";
			cn = MysqlDBConexion.getConexion();
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, log);
			pstm.setString(2, pas);
			rs = pstm.executeQuery();
			if(rs.next()) {
				obj = new AdministradorDTO();
				obj.setId_admin(rs.getInt(1));
				obj.setEmail(rs.getString(2));
				obj.setContra(rs.getString(3));
						
			}
					
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
			    if (rs != null)

		               rs.close();

		            if (pstm != null)

		               pstm.close();

		            if (cn != null)

		               cn.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return obj;
	}
	
	public ClienteDTO iniciarSesionCliente(String log, String pas) {
		ClienteDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from cliente where email_cliente=? and contra_cliente =? ";
			cn = MysqlDBConexion.getConexion();
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, log);
			pstm.setString(2, pas);
			rs = pstm.executeQuery();
			if(rs.next()) {
				obj = new ClienteDTO();
				obj.setId_cliente(rs.getInt(1));
				obj.setEmail_cliente(rs.getString(2));
				obj.setContra_cliente(rs.getString(3));
				obj.setNom_cliente(rs.getString(4));
				obj.setApe_cliente(rs.getString(5));
				obj.setTel_cliente(rs.getString(6));
				obj.setFec_nacimiento(rs.getString(7));
				obj.setSexo_cliente(rs.getInt(8));
						
			}
					
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
			    if (rs != null)

		               rs.close();

		            if (pstm != null)

		               pstm.close();

		            if (cn != null)

		               cn.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return obj;
	}
}
