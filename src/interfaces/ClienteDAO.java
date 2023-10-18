package interfaces;

import java.util.List;

import beans.ClienteDTO;

public interface ClienteDAO {

	public ClienteDTO iniciarSesion(String login, String contra);
	public List<ClienteDTO> listarCliente();
	public ClienteDTO buscarCliente(int id_cliente);
	public int registrarCliente(ClienteDTO obj);
	public int actualizarCliente(ClienteDTO obj);
	public int eliminarCliente(int obj);
}
