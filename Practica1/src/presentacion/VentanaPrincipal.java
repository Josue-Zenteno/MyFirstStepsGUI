package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal {
	private JLabel lblBarraEstado;
	private JLabel lblMensaje;
	private JFrame frmMiPrimeraAplicacin;
	private JTextField txtOrigen;
	private JButton btnCopiar;
	private JLabel lblDestino;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frmMiPrimeraAplicacin.setVisible(true);
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
	private void initialize() {
		frmMiPrimeraAplicacin = new JFrame();
		frmMiPrimeraAplicacin.setTitle("Mi primera aplicaci\u00F3n");
		frmMiPrimeraAplicacin.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/presentacion/logoFrame.png")));
		frmMiPrimeraAplicacin.setBounds(100, 100, 579, 396);
		frmMiPrimeraAplicacin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMiPrimeraAplicacin.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JToolBar tbBarraHerramientas = new JToolBar();
		frmMiPrimeraAplicacin.getContentPane().add(tbBarraHerramientas, BorderLayout.NORTH);
		
		JButton btnGuardar = new JButton("");
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblBarraEstado.setText("Guardado");
			}
		});
		btnGuardar.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/presentacion/guardar.png")));
		tbBarraHerramientas.add(btnGuardar);
		
		lblBarraEstado = new JLabel("Barra de estado...");
		lblBarraEstado.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frmMiPrimeraAplicacin.getContentPane().add(lblBarraEstado, BorderLayout.SOUTH);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmMiPrimeraAplicacin.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel pnlPestaña1 = new JPanel();
		tabbedPane.addTab("Pesta\u00F1a1", new ImageIcon(VentanaPrincipal.class.getResource("/presentacion/pestana1.png")), pnlPestaña1, null);
		pnlPestaña1.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlBotones = new JPanel();
		pnlPestaña1.add(pnlBotones, BorderLayout.SOUTH);
		
		JButton btnHola = new JButton("Hola");
		btnHola.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblMensaje.setText("Hola");
				lblMensaje.setBackground(Color.green);
			}
		});
		pnlBotones.add(btnHola);
		
		JButton btnAdios = new JButton("Adi\u00F3s");
		btnAdios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblMensaje.setText("Adiós");
				lblMensaje.setBackground(Color.red);
			}
		});
		pnlBotones.add(btnAdios);
		
		lblMensaje = new JLabel("");
		lblMensaje.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMensaje.setOpaque(true);
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		pnlPestaña1.add(lblMensaje, BorderLayout.CENTER);
		
		JPanel pnlPestaña2 = new JPanel();
		tabbedPane.addTab("Pesta\u00F1a2", new ImageIcon(VentanaPrincipal.class.getResource("/presentacion/pestana2.png")), pnlPestaña2, null);
		pnlPestaña2.setLayout(null);
		
		txtOrigen = new JTextField();
		txtOrigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblDestino.setText(txtOrigen.getText());
			}
		});
		
		txtOrigen.setBounds(150, 11, 244, 20);
		pnlPestaña2.add(txtOrigen);
		txtOrigen.setColumns(10);
		
		btnCopiar = new JButton("Copiar");
		btnCopiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblDestino.setText(txtOrigen.getText());
			}
		});
		btnCopiar.setBounds(150, 42, 89, 23);
		pnlPestaña2.add(btnCopiar);
		
		lblDestino = new JLabel("");
		lblDestino.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblDestino.setBounds(150, 87, 244, 20);
		pnlPestaña2.add(lblDestino);
	}
}
