package interfaces;

import java.util.List;

import beans.EspecialistaDTO;

public interface EspecialistaDAO {

	public EspecialistaDTO iniciarSesion(String login,String pas);
	public List<EspecialistaDTO> listarEspecialista();
	public EspecialistaDTO buscarEspecialista(int id_cliente);
	public int registrarEspecialista(EspecialistaDTO obj);
	public int actualizarEspecialista(EspecialistaDTO obj);
	public int eliminarEspecialista(int obj);
}
