package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.PruebaDTO;
import interfaces.PruebaDAO;
import utils.MysqlDBConexion;

public class MySqlPruebaDAO implements PruebaDAO {

	public List<PruebaDTO> listarPrueba() {
		PruebaDTO cit = null;
	      List<PruebaDTO> data = new ArrayList<PruebaDTO>();
	      Connection cn = null;
	      PreparedStatement pstm = null;
	      ResultSet rs = null;
	      try {
	         cn = MysqlDBConexion.getConexion();
	         String sql = "select id_prueba p, cau_prueba p,fec_prueba p ,obs_prueba p, nom_cliente c,  nom_espe e, nom_esp s from prueba p\r\n" + 
	         		"join cliente c on c.id_cliente = p.id_cliente\r\n" + 
	         		"join especialista e on e.id_espe = p.id_espe\r\n" + 
	         		"inner join especialidad s on s.id_esp = p.id_esp\r\n" + 
	         		";";
	         pstm = cn.prepareStatement(sql);
	         rs = pstm.executeQuery();
	         while (rs.next()) {
	            cit = new PruebaDTO();
	            cit.setId_prueba(rs.getInt(1));
	            cit.setCau_prueba(rs.getString(2));
	            cit.setFec_prueba(rs.getString(3));
	            cit.setObs_prueba(rs.getString(4));
	            cit.setNom_cliente(rs.getString(5));
	            cit.setNom_espe(rs.getString(6));
	            cit.setNom_esp(rs.getString(7));
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
	public List<PruebaDTO> listarPruebaxCliente(int id_cliente) {
		PruebaDTO cit = null;
	      List<PruebaDTO> data = new ArrayList<PruebaDTO>();
	      Connection cn = null;
	      PreparedStatement pstm = null;
	      ResultSet rs = null;
	      try {
	         cn = MysqlDBConexion.getConexion();
	         String sql = "select id_prueba p, cau_prueba p,fec_prueba p ,obs_prueba p,   nom_espe e, nom_esp s from prueba p\r\n" + 
	         		"join especialista e on e.id_espe = p.id_espe\r\n" + 
	         		"join especialidad s on s.id_esp = p.id_esp where id_cliente = ?;";
	         pstm = cn.prepareStatement(sql);
	         pstm.setInt(1, id_cliente);
	         rs = pstm.executeQuery();
	         while (rs.next()) {
	            cit = new PruebaDTO();
	            cit.setId_prueba(rs.getInt(1));
	            cit.setCau_prueba(rs.getString(2));
	            cit.setFec_prueba(rs.getString(3));
	            cit.setObs_prueba(rs.getString(4));
	            cit.setNom_espe(rs.getString(5));
	            cit.setNom_esp(rs.getString(6));
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
	public PruebaDTO buscarPrueba(int id_cita) {
		PruebaDTO cit = null;
	      Connection cn = null;
	      PreparedStatement pstm = null;
	      ResultSet rs = null;
	      try {
	         cn = MysqlDBConexion.getConexion();
	         String sql = "select * from prueba where id_prueba=?";
	         pstm = cn.prepareStatement(sql);
	         pstm.setInt(1, id_cita);
	         rs = pstm.executeQuery();
	         if (rs.next()) {
	            cit = new PruebaDTO();
	            cit.setId_prueba(rs.getInt(1));
	            cit.setCau_prueba(rs.getString(2));
	            cit.setFec_prueba(rs.getString(3));
	            cit.setObs_prueba(rs.getString(4));
	            cit.setNom_cliente(rs.getString(5));
	            cit.setNom_espe(rs.getString(6));
	            cit.setNom_esp(rs.getString(7));
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
	public int registrarPrueba(PruebaDTO obj) {
		int estado = -1;
		PruebaDTO cli = null;
	      Connection cn = null;
	      PreparedStatement pstm = null;
	      try {
	         cn = MysqlDBConexion.getConexion();
	         String sql = "insert into prueba values(null,?,?,?,?,?,?)";
	         pstm = cn.prepareStatement(sql);
	         pstm.setString(1, obj.getCau_prueba());
	         pstm.setString(2, obj.getFec_prueba());
	         pstm.setString(3, obj.getObs_prueba());       
	         pstm.setInt(4, obj.getId_cliente());
	         pstm.setInt(5, obj.getId_espe());
	         pstm.setInt(6, obj.getId_esp());
	         estado  = pstm.executeUpdate();
	      }
	      catch (Exception e) {
	         e.printStackTrace();
	      }
	      return estado; 
	}
	public int actualizarPrueba(PruebaDTO obj) {
		int estado = -1;
		PruebaDTO cit = null;
	      Connection cn = null;
	      PreparedStatement pstm = null;
	      try {
	         cn = MysqlDBConexion.getConexion();
	         String sql = "update prueba set cau_prueba=?, fec_prueba=?, obs_prueba=? ,id_cliente=?,id_espe=?,id_esp=? where id_prueba=?";
	         pstm = cn.prepareStatement(sql);
	         pstm.setString(1, obj.getCau_prueba());
	         pstm.setString(2, obj.getFec_prueba());
	         pstm.setString(3, obj.getObs_prueba());       
	         pstm.setInt(4, obj.getId_cliente());
	         pstm.setInt(5, obj.getId_espe());
	         pstm.setInt(6, obj.getId_esp());
	         pstm.setInt(7, obj.getId_prueba());
	         estado  = pstm.executeUpdate();
	      }
	      catch (Exception e) {
	         e.printStackTrace();
	      }
	      return estado;  
	}
	public int eliminarPrueba(int obj) {
		int estado = -1;
		PruebaDTO cit = null;
	      Connection cn = null;
	      PreparedStatement pstm = null;
	      try {
	         cn = MysqlDBConexion.getConexion();
	         String sql = "delete from prueba where id_prueba=?";
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
