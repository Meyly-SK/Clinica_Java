package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.InformeDTO;
import beans.PruebaDTO;
import interfaces.InformeDAO;
import utils.MysqlDBConexion;

public class MySqlInformeDAO implements InformeDAO {

	@Override
	public int registrarInforme(InformeDTO obj) {
		int estado = -1;
		InformeDTO cli = null;
	      Connection cn = null;
	      PreparedStatement pstm = null;
	      try {
	         cn = MysqlDBConexion.getConexion();
	         String sql = "insert into informe values(null,?,?,?,?,?,?,?,?)";
	         pstm = cn.prepareStatement(sql);
	         pstm.setString(1, obj.getCausa_info());
	         pstm.setString(2, obj.getSintoma_info());
	         pstm.setString(3, obj.getFec_sintoma());       
	         pstm.setString(4, obj.getDiag_info());   
	         pstm.setString(5, obj.getFec_diag());   
	         pstm.setString(6, obj.getObs_informe());   
	         pstm.setInt(7, obj.getId_cliente());
	         pstm.setInt(8, obj.getId_espe());
	         estado  = pstm.executeUpdate();
	      }
	      catch (Exception e) {
	         e.printStackTrace();
	      }
	      return estado; 
	}

	@Override
	public List<InformeDTO> listarInforme() {
		InformeDTO cit = null;
	      List<InformeDTO> data = new ArrayList<InformeDTO>();
	      Connection cn = null;
	      PreparedStatement pstm = null;
	      ResultSet rs = null;
	      try {
	         cn = MysqlDBConexion.getConexion();
	         String sql = "SELECT id_informe i, causa_informe i, sintoma_informe i, fec_sintoma i, diag_informe i, fec_diag i,obser_informe i, nom_cliente c, nom_espe e from Informe i\r\n" + 
	         		"JOIN cliente c on c.id_cliente = i.id_cliente \r\n" + 
	         		"JOIN especialista e on e.id_espe = i.id_especialista;";
	         pstm = cn.prepareStatement(sql);
	         rs = pstm.executeQuery();
	         while (rs.next()) {
	            cit = new InformeDTO();
	            cit.setId_info(rs.getInt(1));
	            cit.setCausa_info(rs.getString(2));
	            cit.setSintoma_info(rs.getString(3));
	            cit.setFec_sintoma(rs.getString(4));
	            cit.setDiag_info(rs.getString(5));
	            cit.setFec_diag(rs.getString(6));
	            cit.setObs_informe(rs.getString(7));
	            cit.setNom_cliente(rs.getString(8));
	            cit.setNom_espe(rs.getString(9));
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
	
	public List<InformeDTO> listarInformexCliente(int id_cliente) {
		InformeDTO cit = null;
	      List<InformeDTO> data = new ArrayList<InformeDTO>();
	      Connection cn = null;
	      PreparedStatement pstm = null;
	      ResultSet rs = null;
	      try {
	         cn = MysqlDBConexion.getConexion();
	         String sql = "SELECT id_informe i, causa_informe i, sintoma_informe i, fec_sintoma i, diag_informe i, fec_diag i,obser_informe i, nom_espe e from Informe i\r\n" + 
	         		"JOIN especialista e on e.id_espe = i.id_especialista where id_cliente = ?";
	         pstm = cn.prepareStatement(sql);
	         pstm.setInt(1, id_cliente);
	         rs = pstm.executeQuery();
	         while (rs.next()) {
	            cit = new InformeDTO();
	            cit.setId_info(rs.getInt(1));
	            cit.setCausa_info(rs.getString(2));
	            cit.setSintoma_info(rs.getString(3));
	            cit.setFec_sintoma(rs.getString(4));
	            cit.setDiag_info(rs.getString(5));
	            cit.setFec_diag(rs.getString(6));
	            cit.setObs_informe(rs.getString(7));
	            cit.setNom_espe(rs.getString(8));
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
	public InformeDTO buscarInforme(int id_informe) {
		InformeDTO cit = null;
	      Connection cn = null;
	      PreparedStatement pstm = null;
	      ResultSet rs = null;
	      try {
	         cn = MysqlDBConexion.getConexion();
	         String sql = "select * from informe where id_informe=?";
	         pstm = cn.prepareStatement(sql);
	         pstm.setInt(1, id_informe);
	         rs = pstm.executeQuery();
	         if (rs.next()) {
	            cit = new InformeDTO();
	            cit.setId_info(rs.getInt(1));
	            cit.setCausa_info(rs.getString(2));
	            cit.setSintoma_info(rs.getString(3));
	            cit.setFec_sintoma(rs.getString(4));
	            cit.setDiag_info(rs.getString(5));
	            cit.setFec_diag(rs.getString(6));
	            cit.setObs_informe(rs.getString(7));
	            cit.setNom_cliente(rs.getString(8));
	            cit.setNom_espe(rs.getString(9));
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
	public int actualizarInforme(InformeDTO obj) {
		int estado = -1;
		PruebaDTO cit = null;
	      Connection cn = null;
	      PreparedStatement pstm = null;
	      try {
	         cn = MysqlDBConexion.getConexion();
	         String sql = "update informe set causa_informe=?, sintoma_informe=?, fec_sintoma=? ,diag_informe=?,fec_diag=?,obser_informe=?,id_cliente=?,id_especialista=? where id_informe=?";
	         pstm = cn.prepareStatement(sql);
	         pstm.setString(1, obj.getCausa_info());
	         pstm.setString(2, obj.getSintoma_info());
	         pstm.setString(3, obj.getFec_sintoma());       
	         pstm.setString(4, obj.getDiag_info());   
	         pstm.setString(5, obj.getFec_diag());   
	         pstm.setString(6, obj.getObs_informe());   
	         pstm.setInt(7, obj.getId_cliente());
	         pstm.setInt(8, obj.getId_espe());
	         pstm.setInt(9, obj.getId_info());
	         estado  = pstm.executeUpdate();
	      }
	      catch (Exception e) {
	         e.printStackTrace();
	      }
	      return estado;  
	}

	@Override
	public int eliminarInforme(int obj) {
		int estado = -1;
		PruebaDTO cit = null;
	      Connection cn = null;
	      PreparedStatement pstm = null;
	      try {
	         cn = MysqlDBConexion.getConexion();
	         String sql = "delete from informe where id_informe=?";
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
