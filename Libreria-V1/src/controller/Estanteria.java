package controller;

import model.Libro;

public class Estanteria {
	private static int MAX_REG = 3;
	private int reg = 0;
	private Libro[] libros;

	/* Constructors */
	public Estanteria() {
		libros = new Libro[MAX_REG];
	}

	/* Getters & Setters */
	public static int getMAX_REG() {
		return MAX_REG;
	}

	public Libro[] getLibros() {
		return libros;
	}

	public void setLibros(Libro[] libros) {
		this.libros = libros;
	}

	public int getReg() {
		return reg;
	}

	public void setReg(int reg) {
		this.reg = reg;
	}

	public boolean agregarLibro(Libro libro) {
		if (this.reg < this.MAX_REG) {
			if (buscarLibro(libro.getTitulo()) == -1) {
				this.libros[reg] = libro;
				this.reg++;
				return true;
			}
		}
		return false;
	}

	public int buscarLibro(String titulo) {
		int pos = -1, i = 0;
		boolean enc = false;
		if (reg > 0) {
			while (!enc && i < reg) {
				if (libros[i].getTitulo().equals(titulo)) {
					enc = true;
					pos = i;
				}
				i++;
			}
		}
		return pos;
	}

	public boolean borrarLibro(int pos) {
		if (reg > 0) {
			reg--;
			libros[pos] = libros[reg];
			return true;
		} else {
			return false;
		}
	}
}
