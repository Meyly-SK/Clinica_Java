package beans;

public class InformeR {
	
	public int id_info;
	public String causa_info;
	public String sintoma_info;
	public String fec_sintoma;
	public String diag_info;
	public String fec_diag;
	public String obs_informe;
	
	public int id_cliente;
	public String nom_cliente;
	
	public int id_espe;
	public String nom_espe;
	
	
	
	public InformeR(int id_info, String causa_info, String sintoma_info, String fec_sintoma, String diag_info,
			String fec_diag, String obs_informe, String nom_cliente, String nom_espe) {
		this.id_info = id_info;
		this.causa_info = causa_info;
		this.sintoma_info = sintoma_info;
		this.fec_sintoma = fec_sintoma;
		this.diag_info = diag_info;
		this.fec_diag = fec_diag;
		this.obs_informe = obs_informe;
		this.nom_cliente = nom_cliente;
		this.nom_espe = nom_espe;
	}
	
	public int getId_info() {
		return id_info;
	}
	public void setId_info(int id_info) {
		this.id_info = id_info;
	}
	public String getCausa_info() {
		return causa_info;
	}
	public void setCausa_info(String causa_info) {
		this.causa_info = causa_info;
	}
	public String getSintoma_info() {
		return sintoma_info;
	}
	public void setSintoma_info(String sintoma_info) {
		this.sintoma_info = sintoma_info;
	}
	public String getFec_sintoma() {
		return fec_sintoma;
	}
	public void setFec_sintoma(String fec_sintoma) {
		this.fec_sintoma = fec_sintoma;
	}
	public String getDiag_info() {
		return diag_info;
	}
	public void setDiag_info(String diag_info) {
		this.diag_info = diag_info;
	}
	public String getFec_diag() {
		return fec_diag;
	}
	public void setFec_diag(String fec_diag) {
		this.fec_diag = fec_diag;
	}
	public String getObs_informe() {
		return obs_informe;
	}
	public void setObs_informe(String obs_informe) {
		this.obs_informe = obs_informe;
	}
	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getNom_cliente() {
		return nom_cliente;
	}
	public void setNom_cliente(String nom_cliente) {
		this.nom_cliente = nom_cliente;
	}
	public int getId_espe() {
		return id_espe;
	}
	public void setId_espe(int id_espe) {
		this.id_espe = id_espe;
	}
	public String getNom_espe() {
		return nom_espe;
	}
	public void setNom_espe(String nom_espe) {
		this.nom_espe = nom_espe;
	}
	
}
