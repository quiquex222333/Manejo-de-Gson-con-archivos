

public class Estudiante {
	
	String nombre,apellido,codigo;
	nota [] notas = new nota[10];
	
	
	/*
	Map notas = new HashMap();

	public void setNotas(Map notas) {
		this.notas = notas;
	}
	*/
	
	

	public nota[] getNotas() {
		return notas;
	}

	public void setNotas(nota[] notas) {
		this.notas = notas;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	



}
