package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.CitaDTO;
import interfaces.CitaDAO;
import utils.MysqlDBConexion;

public class MySqlCitaDAO implements CitaDAO {

	@Override
	public List<CitaDTO> listarCita() {
		CitaDTO cit = null;
	      List<CitaDTO> data = new ArrayList<CitaDTO>();
	      Connection cn = null;
	      PreparedStatement pstm = null;
	      ResultSet rs = null;
	      try {
	         cn = MysqlDBConexion.getConexion();
	         String sql = "select id_cita c, nom_cliente e, nom_esp s, fec_cita from cita c \r\n" + 
	         		"join cliente e on e.id_cliente = c.id_cliente\r\n" + 
	         		"join especialidad s on s.id_esp = c.id_esp;\r\n" + 
	         		"";
	         pstm = cn.prepareStatement(sql);
	         rs = pstm.executeQuery();
	         while (rs.next()) {
	            cit = new CitaDTO();
	            cit.setId_cita(rs.getInt(1));
	            cit.setNom_cita(rs.getString(2));
	            cit.setEsp_cita(rs.getString(3));
	            cit.setFec_cita(rs.getString(4));
	            data.add(cit);
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
	public List<CitaDTO> listarCitaxCliente(int id_cliente) {
		CitaDTO cit = null;
	      List<CitaDTO> data = new ArrayList<CitaDTO>();
	      Connection cn = null;
	      PreparedStatement pstm = null;
	      ResultSet rs = null;
	      try {
	         cn = MysqlDBConexion.getConexion();
	         String sql = "select id_cita c, nom_esp e , fec_cita c from cita c\r\n" + 
	         		"join especialidad e on e.id_esp = c.id_esp where id_cliente=?;";
	         pstm = cn.prepareStatement(sql);
	         pstm.setInt(1, id_cliente);
	         rs = pstm.executeQuery();
	         while (rs.next()) {
	            cit = new CitaDTO();
	            cit.setId_cita(rs.getInt(1));
	            cit.setEsp_cita(rs.getString(2));
	            cit.setFec_cita(rs.getString(3));
	            data.add(cit);
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

	@Override
	public CitaDTO buscarCita(int id_cita) {
		CitaDTO cit = null;
	      Connection cn = null;
	      PreparedStatement pstm = null;
	      ResultSet rs = null;
	      try {
	         cn = MysqlDBConexion.getConexion();
	         String sql = "select * from cita where id_cita=?";
	         pstm = cn.prepareStatement(sql);
	         pstm.setInt(1, id_cita);
	         rs = pstm.executeQuery();
	         if (rs.next()) {
	            cit = new CitaDTO();
	            cit.setId_cita(rs.getInt(1));
	            cit.setNom_cita(rs.getString(2));
	            cit.setEsp_cita(rs.getString(3));
	            cit.setFec_cita(rs.getString(4));
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
	public int registrarCita(CitaDTO obj) {
		int estado = -1;
		CitaDTO cit = null;
	      Connection cn = null;
	      PreparedStatement pstm = null;
	      try {
	         cn = MysqlDBConexion.getConexion();
	         String sql = "insert into cita values(null,?,?,?)";
	         pstm = cn.prepareStatement(sql);
	         pstm.setInt(1, obj.getId_cli());
	         pstm.setInt(2, obj.getId_esp());
	         pstm.setString(3, obj.getFec_cita());
	         estado  = pstm.executeUpdate();
	      }
	      catch (Exception e) {
	         e.printStackTrace();
	      }
	      return estado;  

	      }
	   	

	@Override
	public int actualizarCita(CitaDTO obj) {
		int estado = -1;
		CitaDTO cit = null;
	      Connection cn = null;
	      PreparedStatement pstm = null;
	      try {
	         cn = MysqlDBConexion.getConexion();
	         String sql = "update cita set id_cliente=?, id_esp=?, fec_cita=? where id_cita=?";
	         pstm = cn.prepareStatement(sql);
	         pstm.setInt(1, obj.getId_cli());
	         pstm.setInt(2, obj.getId_esp());
	         pstm.setString(3, obj.getFec_cita());
	         pstm.setInt(4, obj.getId_cita());
	         estado  = pstm.executeUpdate();
	      }
	      catch (Exception e) {
	         e.printStackTrace();
	      }
	      return estado;  
	}

	@Override
	public int eliminarCita(int obj) {
		int estado = -1;
		CitaDTO cit = null;
	      Connection cn = null;
	      PreparedStatement pstm = null;
	      try {
	         cn = MysqlDBConexion.getConexion();
	         String sql = "delete from cita where id_cita=?";
	         pstm = cn.prepareStatement(sql);
	         pstm.setInt(1, obj);
	         estado  = pstm.executeUpdate();
	      }
	      catch (Exception e) {
	         e.printStackTrace();
	      }
	      return estado; 
	}

}
