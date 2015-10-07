package model;

public class Libro {
	private String titulo, autor, estado;
	private int numPaginas, tema;
	private boolean[] formato = { false, false, false };

	/* Constructors */
	public Libro(String titulo, String autor, int tema, String estado, int numPaginas, boolean[] formato) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.tema = tema;
		this.estado = estado;
		this.numPaginas = numPaginas;
		this.formato = formato;
	}

	/* Getters & Setters */

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getTema() {
		return tema;
	}

	public void setTema(int tema) {
		this.tema = tema;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}

	public boolean[] getFormato() {
		return formato;
	}

	public void setFormato(boolean[] formato) {
		this.formato = formato;
	}

	@Override
	public String toString() {
		return titulo;
	}
}
