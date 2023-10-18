package interfaces;

import java.util.List;

import beans.PruebaDTO;


public interface PruebaDAO {
	
	public int registrarPrueba(PruebaDTO obj);
	public List<PruebaDTO> listarPrueba();
	public List<PruebaDTO> listarPruebaxCliente(int id_cliente);
	public PruebaDTO buscarPrueba(int id_prueba);
	public int actualizarPrueba(PruebaDTO obj);
	public int eliminarPrueba(int obj);
}
