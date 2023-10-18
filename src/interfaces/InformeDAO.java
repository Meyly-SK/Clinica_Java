package interfaces;

import java.util.List;

import beans.InformeDTO;
import beans.PruebaDTO;

public interface InformeDAO {
	
	public int registrarInforme(InformeDTO obj);
	public List<InformeDTO> listarInforme();
	public List<InformeDTO> listarInformexCliente(int id_cliente);
	public InformeDTO buscarInforme(int id_informe);
	public int actualizarInforme(InformeDTO obj);
	public int eliminarInforme(int obj);
}
