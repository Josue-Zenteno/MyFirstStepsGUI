package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import javax.swing.border.TitledBorder;

import dominio.cliente;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal {

	private JFrame frame;
	private JPanel pnlBotones;
	private JButton btnLimpiar;
	private JButton btnGuardar;
	private JPanel pnlFormulario;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JLabel lblNivelDeEstudios;
	private JLabel lblEstadoCivil;
	private JLabel lblNumeroDeHijos;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	@SuppressWarnings("rawtypes")
	private JComboBox cbNivelDeEstudios;
	private JRadioButton rbSoltero;
	private JRadioButton rbCasado;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JSpinner spinNumHijos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 440, 311);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pnlBotones = new JPanel();
		frame.getContentPane().add(pnlBotones, BorderLayout.SOUTH);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new BtnLimpiarActionListener());
		pnlBotones.add(btnLimpiar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new BtnGuardarActionListener());
		pnlBotones.add(btnGuardar);
		
		pnlFormulario = new JPanel();
		pnlFormulario.setBorder(new TitledBorder(null, "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		frame.getContentPane().add(pnlFormulario, BorderLayout.CENTER);
		GridBagLayout gbl_pnlFormulario = new GridBagLayout();
		gbl_pnlFormulario.columnWidths = new int[]{0, 115, 89, 82, 0};
		gbl_pnlFormulario.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_pnlFormulario.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlFormulario.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlFormulario.setLayout(gbl_pnlFormulario);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 0;
		pnlFormulario.add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.gridwidth = 2;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 1;
		gbc_txtNombre.gridy = 0;
		pnlFormulario.add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
		gbc_lblApellidos.anchor = GridBagConstraints.EAST;
		gbc_lblApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellidos.gridx = 0;
		gbc_lblApellidos.gridy = 1;
		pnlFormulario.add(lblApellidos, gbc_lblApellidos);
		
		txtApellidos = new JTextField();
		GridBagConstraints gbc_txtApellidos = new GridBagConstraints();
		gbc_txtApellidos.gridwidth = 3;
		gbc_txtApellidos.insets = new Insets(0, 0, 5, 0);
		gbc_txtApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtApellidos.gridx = 1;
		gbc_txtApellidos.gridy = 1;
		pnlFormulario.add(txtApellidos, gbc_txtApellidos);
		txtApellidos.setColumns(10);
		
		lblNivelDeEstudios = new JLabel("Nivel de estudios:");
		lblNivelDeEstudios.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNivelDeEstudios = new GridBagConstraints();
		gbc_lblNivelDeEstudios.anchor = GridBagConstraints.EAST;
		gbc_lblNivelDeEstudios.insets = new Insets(0, 0, 5, 5);
		gbc_lblNivelDeEstudios.gridx = 0;
		gbc_lblNivelDeEstudios.gridy = 2;
		pnlFormulario.add(lblNivelDeEstudios, gbc_lblNivelDeEstudios);
		
		cbNivelDeEstudios = new JComboBox();
		cbNivelDeEstudios.setModel(new DefaultComboBoxModel(new String[] {"Sin Estudios", "E.S.O.", "Bachillerato", "Universitario", "Master"}));
		GridBagConstraints gbc_cbNivelDeEstudios = new GridBagConstraints();
		gbc_cbNivelDeEstudios.insets = new Insets(0, 0, 5, 5);
		gbc_cbNivelDeEstudios.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbNivelDeEstudios.gridx = 1;
		gbc_cbNivelDeEstudios.gridy = 2;
		pnlFormulario.add(cbNivelDeEstudios, gbc_cbNivelDeEstudios);
		
		lblEstadoCivil = new JLabel("Estado civil:");
		lblEstadoCivil.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblEstadoCivil = new GridBagConstraints();
		gbc_lblEstadoCivil.anchor = GridBagConstraints.EAST;
		gbc_lblEstadoCivil.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstadoCivil.gridx = 0;
		gbc_lblEstadoCivil.gridy = 3;
		pnlFormulario.add(lblEstadoCivil, gbc_lblEstadoCivil);
		
		rbSoltero = new JRadioButton("Soltero");
		buttonGroup.add(rbSoltero);
		GridBagConstraints gbc_rbSoltero = new GridBagConstraints();
		gbc_rbSoltero.insets = new Insets(0, 0, 5, 5);
		gbc_rbSoltero.gridx = 1;
		gbc_rbSoltero.gridy = 3;
		pnlFormulario.add(rbSoltero, gbc_rbSoltero);
		
		rbCasado = new JRadioButton("Casado");
		buttonGroup.add(rbCasado);
		GridBagConstraints gbc_rbCasado = new GridBagConstraints();
		gbc_rbCasado.insets = new Insets(0, 0, 5, 5);
		gbc_rbCasado.gridx = 2;
		gbc_rbCasado.gridy = 3;
		pnlFormulario.add(rbCasado, gbc_rbCasado);
		
		lblNumeroDeHijos = new JLabel("Numero de hijos:");
		lblNumeroDeHijos.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNumeroDeHijos = new GridBagConstraints();
		gbc_lblNumeroDeHijos.anchor = GridBagConstraints.EAST;
		gbc_lblNumeroDeHijos.insets = new Insets(0, 0, 0, 5);
		gbc_lblNumeroDeHijos.gridx = 0;
		gbc_lblNumeroDeHijos.gridy = 4;
		pnlFormulario.add(lblNumeroDeHijos, gbc_lblNumeroDeHijos);
		
		spinNumHijos = new JSpinner();
		spinNumHijos.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		GridBagConstraints gbc_spinNumHijos = new GridBagConstraints();
		gbc_spinNumHijos.anchor = GridBagConstraints.WEST;
		gbc_spinNumHijos.insets = new Insets(0, 0, 0, 5);
		gbc_spinNumHijos.gridx = 1;
		gbc_spinNumHijos.gridy = 4;
		pnlFormulario.add(spinNumHijos, gbc_spinNumHijos);
	}

	private class BtnLimpiarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			txtNombre.setText("");
			txtApellidos.setText("");
			cbNivelDeEstudios.setSelectedItem("Sin estudios");
			//cbNivelEstudios.setSelectedIndex(0);
			buttonGroup.clearSelection();
			spinNumHijos.setValue(0);
		}
	}
	private class BtnGuardarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			cliente cliente2 = new cliente
					(txtNombre.getText(),txtApellidos.getText(),(String)cbNivelDeEstudios.getSelectedItem(),rbCasado.isSelected(),(Integer)spinNumHijos.getValue());
					Dialogo2 segundaVentana = new Dialogo2(cliente2);
					segundaVentana.setVisible(true);
		}
	}
}
