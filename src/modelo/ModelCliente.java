package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.CitaDTO;
import beans.ClienteDTO;
import utils.MysqlDBConexion;

public class ModelCliente {

	public ClienteDTO iniciarSesion(String log, String pas) {
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
	
	public List<ClienteDTO> listarCliente() {
		ClienteDTO cli = null;
	      List<ClienteDTO> data = new ArrayList<ClienteDTO>();
	      Connection cn = null;
	      PreparedStatement pstm = null;
	      ResultSet rs = null;
	      try {
	         cn = MysqlDBConexion.getConexion();
	         String sql = "select id_cliente , nom_cliente , ape_cliente , tel_cliente  from cliente ;";
	         pstm = cn.prepareStatement(sql);
	         rs = pstm.executeQuery();
	         while (rs.next()) {
	            cli = new ClienteDTO();
	            cli.setId_cliente(rs.getInt(1));
	            cli.setNom_cliente(rs.getString(2));
	            cli.setApe_cliente(rs.getString(3));
	            cli.setTel_cliente(rs.getString(4));
	            data.add(cli);
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
	      return data; 
	}
	public int registrarCliente(ClienteDTO obj) {
		int estado = -1;
		ClienteDTO cli = null;
	      Connection cn = null;
	      PreparedStatement pstm = null;
	      try {
	         cn = MysqlDBConexion.getConexion();
	         String sql = "insert into cliente values(null,?,?,?,?,?,null,null)";
	         pstm = cn.prepareStatement(sql);
	         pstm.setString(1, obj.getEmail_cliente());
	         pstm.setString(2, obj.getContra_cliente());
	         pstm.setString(3, obj.getNom_cliente());
	         pstm.setString(4, obj.getApe_cliente());
	         pstm.setString(5, obj.getTel_cliente());
	         estado  = pstm.executeUpdate();
	      }
	      catch (Exception e) {
	         e.printStackTrace();
	      }
	      return estado;  

	      }
	public ClienteDTO buscarCliente(int id_cliente) {
		ClienteDTO cit = null;
	      Connection cn = null;
	      PreparedStatement pstm = null;
	      ResultSet rs = null;
	      try {
	         cn = MysqlDBConexion.getConexion();
	         String sql = "select * from cliente where id_cliente=?";
	         pstm = cn.prepareStatement(sql);
	         pstm.setInt(1, id_cliente);
	         rs = pstm.executeQuery();
	         if (rs.next()) {
	            cit = new ClienteDTO();
	            cit.setId_cliente(rs.getInt(1));
	            cit.setEmail_cliente(rs.getString(2));
	            cit.setContra_cliente(rs.getString(3));
	            cit.setNom_cliente(rs.getString(4));
	            cit.setApe_cliente(rs.getString(5));
	            cit.setTel_cliente(rs.getString(6));
	            cit.setFec_nacimiento(rs.getString(7));
	            cit.setSexo_cliente(rs.getInt(8));
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
	public int actualizarCliente(ClienteDTO obj) {
		int estado = -1;
		ClienteDTO cit = null;
	      Connection cn = null;
	      PreparedStatement pstm = null;
	      try {
	         cn = MysqlDBConexion.getConexion();
	         String sql = "update cliente set email_cliente=?, contra_cliente=?, nom_cliente=?,ape_cliente=?,tel_cliente=? where id_cliente=?";
	         pstm = cn.prepareStatement(sql);
	         pstm.setString(1, obj.getEmail_cliente());
	         pstm.setString(2, obj.getContra_cliente());
	         pstm.setString(3, obj.getNom_cliente());
	         pstm.setString(4, obj.getApe_cliente());
	         pstm.setString(5, obj.getTel_cliente());
	         pstm.setInt(6, obj.getId_cliente());
	         estado  = pstm.executeUpdate();
	      }
	      catch (Exception e) {
	         e.printStackTrace();
	      }
	      return estado;  
	}
	public int eliminarCliente(int cod) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "delete from cliente where id_cliente=?";
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
