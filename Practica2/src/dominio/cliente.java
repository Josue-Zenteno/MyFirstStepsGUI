package dominio;

public class cliente {
	private String Nombre;
	private String Apellidos;
	private String NivelDeEstudios;
	private Boolean EstadoCivil;
	private int NumeroDeHijos;
	public cliente(String nombre, String apellidos, String nivelDeEstudios, Boolean estadoCivil, int numeroDeHijos) {
		this.Nombre = nombre;
		this.Apellidos = apellidos;
		this.NivelDeEstudios = nivelDeEstudios;
		this.EstadoCivil = estadoCivil;
		this.NumeroDeHijos = numeroDeHijos;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		this.Nombre = nombre;
	}
	public String getApellidos() {
		return Apellidos;
	}
	public void setApellidos(String apellidos) {
		this.Apellidos = apellidos;
	}
	public String getNivelDeEstudios() {
		return NivelDeEstudios;
	}
	public void setNivelDeEstudios(String nivelDeEstudios) {
		this.NivelDeEstudios = nivelDeEstudios;
	}
	public Boolean getEstadoCivil() {
		return EstadoCivil;
	}
	public void setEstadoCivil(Boolean estadoCivil) {
		this.EstadoCivil = estadoCivil;
	}
	public int getNumeroDeHijos() {
		return NumeroDeHijos;
	}
	public void setNumeroDeHijos(int numeroDeHijos) {
		this.NumeroDeHijos = numeroDeHijos;
	}
	
	
}
