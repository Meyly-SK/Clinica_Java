package interfaces;

import java.util.List;

import beans.CitaDTO;

public interface CitaDAO {
	//METODOS DEL CRUD
	
	public List<CitaDTO> listarCita();
	public List<CitaDTO> listarCitaxCliente(int id_cliente);
	public CitaDTO buscarCita(int id_cita);
	public int registrarCita(CitaDTO obj);
	public int actualizarCita(CitaDTO obj);
	public int eliminarCita(int obj);

}
