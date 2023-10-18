package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.CitaDTO;
import utils.MysqlDBConexion;

public class ModelCita {
	public List<CitaDTO> listar() {
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

	public void eliminarCita(int codigo) {
		// TODO Auto-generated method stub
		
	}

	public CitaDTO buscarCita(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	public int registrarCita(CitaDTO obj) {
		// TODO Auto-generated method stub
		return 0;
	}

}
