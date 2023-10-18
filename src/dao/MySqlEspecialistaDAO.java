package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.ClienteDTO;
import beans.EspecialistaDTO;
import interfaces.EspecialistaDAO;
import utils.MysqlDBConexion;

public class MySqlEspecialistaDAO implements EspecialistaDAO {

	@Override
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
				obj.setNom_esp(rs.getString(4));
				obj.setApe_espe(rs.getString(5));
				obj.setTel_espe(rs.getString(6));
				obj.setId_esp(rs.getInt(7));
				obj.setFec_na(rs.getString(8));
				obj.setFec_ini(rs.getString(9));
				obj.setFec_fin(rs.getString(9));
				obj.setDni_espe(rs.getString(10));
						
			}
					
		}
		catch(Exception e) {
			System.out.println("Error en validar " + e.getMessage());
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

	@Override
	public List<EspecialistaDTO> listarEspecialista() {
		EspecialistaDTO cli = null;
	      List<EspecialistaDTO> data = new ArrayList<EspecialistaDTO>();
	      Connection cn = null;
	      PreparedStatement pstm = null;
	      ResultSet rs = null;
	      try {
	         cn = MysqlDBConexion.getConexion();
	         String sql = "select id_espe , nom_espe , ape_espe , tel_espe  from especialista ;";
	         pstm = cn.prepareStatement(sql);
	         rs = pstm.executeQuery();
	         while (rs.next()) {
	            cli = new EspecialistaDTO();
	            cli.setId_espe(rs.getInt(1));
	            cli.setNom_espe(rs.getString(2));
	            cli.setApe_espe(rs.getString(3));
	            cli.setTel_espe(rs.getString(4));
	            data.add(cli);
	         }
	      }
	      catch (Exception e) {
	         System.out.println("Error en Validar" + e.getMessage());
	      }
	      finally {
	         try {
	            if (rs != null)
	               rs.close();
	            if (pstm != null)
	               pstm.close();
	            if (cn != null)
	               cn.close();
	         }
	         catch (Exception e2) {
	            e2.printStackTrace();
	         }
	      }
	      return data; 
	}

	@Override
	public EspecialistaDTO buscarEspecialista(int id_espe) {
		EspecialistaDTO cit = null;
	      Connection cn = null;
	      PreparedStatement pstm = null;
	      ResultSet rs = null;
	      try {
	         cn = MysqlDBConexion.getConexion();
	         String sql = "select * from especialista where id_espe=?";
	         pstm = cn.prepareStatement(sql);
	         pstm.setInt(1, id_espe);
	         rs = pstm.executeQuery();
	         if (rs.next()) {
	            cit = new EspecialistaDTO();
	            cit.setId_espe(rs.getInt(1));
	            cit.setEmail_espe(rs.getString(2));
	            cit.setContra_espe(rs.getString(3));
	            cit.setNom_espe(rs.getString(4));
	            cit.setApe_espe(rs.getString(5));
	            cit.setTel_espe(rs.getString(6));
	            cit.setId_esp(rs.getInt(7));
	            cit.setFec_na(rs.getString(8));
	            cit.setFec_ini(rs.getString(9));
	            cit.setFec_fin(rs.getString(10));
	            cit.setDni_espe(rs.getString(11));
	            cit.setSexo_espe(rs.getInt(12));
	         }
	      }
	      catch (Exception e) {
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
	         }
	         catch (Exception e2) {
	            e2.printStackTrace();
	         }
	      }
	      return cit;
	}

	@Override
	public int registrarEspecialista(EspecialistaDTO obj) {
		int estado = -1;
		EspecialistaDTO cli = null;
	      Connection cn = null;
	      PreparedStatement pstm = null;
	      try {
	         cn = MysqlDBConexion.getConexion();
	         String sql = "insert into especialista values(null,?,?,?,?,?,?,?,?,?,?,?)";
	         pstm = cn.prepareStatement(sql);
	         pstm.setString(1,obj.getEmail_espe());
	         pstm.setString(2, obj.getContra_espe());
	         pstm.setString(3, obj.getNom_espe());
	         pstm.setString(4, obj.getApe_espe());
	         pstm.setString(5, obj.getTel_espe());
	         pstm.setInt(6, obj.getId_esp());
	         pstm.setString(7, obj.getFec_na());
	         pstm.setString(8, obj.getFec_ini());
	         pstm.setString(9, obj.getFec_fin());
	         pstm.setString(10, obj.getDni_espe());
	         pstm.setInt(11, obj.getSexo_espe());
	         estado  = pstm.executeUpdate();
	                 
	      }
	      catch (Exception e) {
	         e.printStackTrace();
	      }
	      return estado;  
	}

	@Override
	public int actualizarEspecialista(EspecialistaDTO obj) {
		int estado = -1;
		EspecialistaDTO cit = null;
	      Connection cn = null;
	      PreparedStatement pstm = null;
	      try {
	         cn = MysqlDBConexion.getConexion();
	         String sql = "update especialista set email_espe=?, contra_espe=?, nom_espe=?,ape_espe=?,tel_espe=? ,id_esp=?,fec_nacimiento=?,fec_ini=?,fec_fin=?,dni_espe=?,sexo_espe=? where id_cliente=?";
	         pstm.setString(1,obj.getEmail_espe());
	         pstm.setString(2, obj.getContra_espe());
	         pstm.setString(3, obj.getNom_espe());
	         pstm.setString(4, obj.getApe_espe());
	         pstm.setString(5, obj.getTel_espe());
	         pstm.setInt(6, obj.getId_esp());
	         pstm.setString(7, obj.getFec_na());
	         pstm.setString(8, obj.getFec_ini());
	         pstm.setString(9, obj.getFec_fin());
	         pstm.setString(10, obj.getDni_espe());
	         pstm.setInt(11, obj.getSexo_espe());
	         pstm.setInt(12, obj.getId_espe());
	         estado  = pstm.executeUpdate();
	      }
	      catch (Exception e) {
	         e.printStackTrace();
	      }
	      return estado;  
	}

	@Override
	public int eliminarEspecialista(int cod) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "delete from especialista where id_espe=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			estado = pstm.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			}
			catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;	
	}

}
