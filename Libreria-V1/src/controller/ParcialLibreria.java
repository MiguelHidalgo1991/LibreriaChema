package controller;

import java.awt.EventQueue;
import view.Libreria;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import model.Libro;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ParcialLibreria extends Libreria {
	private final Estanteria libreria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParcialLibreria frame = new ParcialLibreria();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ParcialLibreria() {

		libreria = new Estanteria();
		bindEvents();
	}

	private void bindEvents() {
		iniciarVentana();
		/* Botones */
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String estado;
				if (rdbtnNovedad.isSelected())
					estado = "Novedad";
				else
					estado = "Reedicion";

				boolean[] formato = { false, false, false };

				if (chckbxCartone.isSelected())
					formato[0] = true;
				if (chckbxRustica.isSelected())
					formato[1] = true;
				if (chckbxTapaDura.isSelected())
					formato[2] = true;

				Libro libro = new Libro(txtTitulo.getText(), txtAutor.getText(), comboTemas.getSelectedIndex(), estado,
						Integer.valueOf(txtNumPaginas.getText()), formato);
				/* agrego al array */
				if (libreria.agregarLibro(libro)) {
					JOptionPane.showMessageDialog(new ParcialLibreria(), "Libro Agregado");
					iniciarVentana();

					/* Agrego a la lista */
					DefaultListModel<Libro> model = (DefaultListModel<Libro>) listBooks.getModel();

					model.addElement(libro);

					/* queda que pida que todos los campos estén rellenos */

				} else {
					JOptionPane.showMessageDialog(new ParcialLibreria(), "Ya existe ese libro", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iniciarVentana();
			}
		});
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Libro selectedValue = listBooks.getSelectedValue();

				int buscarLibro = libreria.buscarLibro(selectedValue.getTitulo());

				if (buscarLibro != -1) {
					libreria.borrarLibro(buscarLibro);
					DefaultListModel<Libro> model = (DefaultListModel<Libro>) listBooks.getModel();
					model.removeElementAt(buscarLibro);
					listBooks.setModel(model);
				}

			}
		});
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmed = JOptionPane.showConfirmDialog(new ParcialLibreria(),
						"Desea realmente salir de la aplicacion?");
				if (confirmed == JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			}
		});

		listBooks.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Libro libro = listBooks.getSelectedValue();
				txtTitulo.setText(libro.getTitulo());
				txtAutor.setText(libro.getAutor());
				txtNumPaginas.setText(String.valueOf(libro.getNumPaginas()));

				boolean[] formato = libro.getFormato();
				chckbxCartone.setSelected(formato[0]);
				chckbxRustica.setSelected(formato[1]);
				chckbxTapaDura.setSelected(formato[2]);

				if (libro.getEstado().equals("Novedad")) {
					rdbtnNovedad.setSelected(true);
					rdbtnReedicion.setSelected(false);
				} else {
					rdbtnNovedad.setSelected(false);
					rdbtnReedicion.setSelected(true);
				}

				comboTemas.setSelectedIndex(libro.getTema());

				JOptionPane.showMessageDialog(new ParcialLibreria(), "Mostrando");
			}
		});
	}

	private void iniciarVentana() {
		txtTitulo.setText("");
		txtAutor.setText("");
		txtNumPaginas.setText("");
		comboTemas.setSelectedIndex(0);
		chckbxCartone.setSelected(true);
		chckbxRustica.setSelected(false);
		chckbxTapaDura.setSelected(false);
		rdbtnNovedad.setSelected(true);
		rdbtnReedicion.setSelected(false);
	}
}
