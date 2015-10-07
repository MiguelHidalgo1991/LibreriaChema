package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;

import java.awt.Font;


import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.border.LineBorder;

import model.Libro;

import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JList;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {

	protected JPanel contentPane;
	protected JTextField txtTitulo;
	protected JTextField txtAutor;
	protected JTextField txtNumPaginas;
	protected JCheckBox chckbxCartone;
	protected JCheckBox chckbxRustica;
	protected JCheckBox chckbxTapaDura;
	protected JRadioButton rdbtnNovedad;
	protected JRadioButton rdbtnReedicion;
	protected JList<Libro> listBooks;
	protected JButton btnSalir;
	protected JButton btnBorrar;
	protected JButton btnAlta;
	protected JButton btnNuevo;
	protected JComboBox<String> comboTemas;

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLibreria = new JLabel("LIBRERIA");
		lblLibreria.setHorizontalAlignment(SwingConstants.CENTER);
		lblLibreria.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblLibreria.setBounds(10, 8, 577, 50);
		contentPane.add(lblLibreria);

		JLabel lblTitulo = new JLabel("TITULO");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(10, 90, 67, 20);
		contentPane.add(lblTitulo);

		JLabel lblAutor = new JLabel("AUTOR");
		lblAutor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutor.setBounds(10, 121, 67, 20);
		contentPane.add(lblAutor);

		JLabel lblTemas = new JLabel("TEMAS");
		lblTemas.setHorizontalAlignment(SwingConstants.CENTER);
		lblTemas.setBounds(10, 152, 67, 20);
		contentPane.add(lblTemas);

		JLabel lblNPaginas = new JLabel("N\u00BA PAGINAS");
		lblNPaginas.setHorizontalAlignment(SwingConstants.CENTER);
		lblNPaginas.setBounds(10, 183, 74, 20);
		contentPane.add(lblNPaginas);

		txtTitulo = new JTextField();
		txtTitulo.setBounds(90, 90, 155, 20);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);

		txtAutor = new JTextField();
		txtAutor.setBounds(90, 121, 155, 20);
		contentPane.add(txtAutor);
		txtAutor.setColumns(10);

		comboTemas = new JComboBox<String>();
		comboTemas
				.setModel(new DefaultComboBoxModel<String>(new String[] { "Accion", "Aventura", "Ficcion", "Terror" }));
		comboTemas.setBounds(90, 152, 155, 20);
		contentPane.add(comboTemas);

		txtNumPaginas = new JTextField();
		txtNumPaginas.setBounds(90, 183, 67, 20);
		contentPane.add(txtNumPaginas);
		txtNumPaginas.setColumns(10);

		btnNuevo = new JButton("NUEVO");
		btnNuevo.setBounds(57, 254, 89, 23);
		contentPane.add(btnNuevo);

		btnAlta = new JButton("ALTA");
		btnAlta.setBounds(156, 254, 89, 23);
		contentPane.add(btnAlta);

		btnBorrar = new JButton("BORRAR");
		btnBorrar.setBounds(57, 288, 89, 23);
		contentPane.add(btnBorrar);

		btnSalir = new JButton("SALIR");
		btnSalir.setBounds(156, 288, 89, 23);
		contentPane.add(btnSalir);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(287, 90, 120, 113);
		contentPane.add(panel);
		panel.setLayout(null);

		chckbxCartone = new JCheckBox("Carton\u00E9");
		chckbxCartone.setBounds(21, 17, 97, 23);
		panel.add(chckbxCartone);

		chckbxRustica = new JCheckBox("R\u00FAstica");
		chckbxRustica.setBounds(21, 43, 97, 23);
		panel.add(chckbxRustica);

		chckbxTapaDura = new JCheckBox("Tapa Dura");
		chckbxTapaDura.setBounds(21, 69, 97, 23);
		panel.add(chckbxTapaDura);

		JLabel lblFormato = new JLabel("Formato");
		lblFormato.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFormato.setBounds(287, 69, 67, 20);
		contentPane.add(lblFormato);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(287, 245, 120, 61);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		rdbtnNovedad = new JRadioButton("Novedad");
		rdbtnNovedad.setBounds(6, 7, 109, 23);
		panel_1.add(rdbtnNovedad);

		rdbtnReedicion = new JRadioButton("Reedici\u00F3n");
		rdbtnReedicion.setBounds(6, 33, 109, 23);
		panel_1.add(rdbtnReedicion);

		JLabel lblNewLabel = new JLabel("Estado");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(287, 224, 67, 20);
		contentPane.add(lblNewLabel);

		listBooks = new JList<Libro>();
		listBooks.setBounds(444, 92, 129, 221);
		contentPane.add(listBooks);

		DefaultListModel<Libro> model = new DefaultListModel<Libro>();
		listBooks.setModel(model);

		JLabel lblLista = new JLabel("Lista");
		lblLista.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLista.setBounds(444, 69, 67, 20);
		contentPane.add(lblLista);
	}
}
