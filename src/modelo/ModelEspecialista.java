package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.EspecialistaDTO;
import utils.MysqlDBConexion;

public class ModelEspecialista {
	
	public EspecialistaDTO iniciarSesion(String login,String pas) {
		EspecialistaDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from especialista where email_espe=? and contra_espe =? ";
			cn = MysqlDBConexion.getConexion();
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, login);
			pstm.setString(2, pas);
			rs = pstm.executeQuery();
			if(rs.next()) {
				obj = new EspecialistaDTO();
				obj.setId_espe(rs.getInt(1));
				obj.setEmail_espe(rs.getString(2));
				obj.setContra_espe(rs.getString(3));
				obj.setNom_espe(rs.getString(4));
				obj.setApe_espe(rs.getString(5));
				obj.setTel_espe(rs.getString(6));
				obj.setId_esp(rs.getInt(7));
				obj.setFec_na(rs.getString(8));
				obj.setFec_ini(rs.getString(9));
				obj.setFec_fin(rs.getString(10));
				obj.setDni_espe(rs.getString(11));
						
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
