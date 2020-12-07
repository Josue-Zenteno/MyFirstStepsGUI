package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.MouseMotionAdapter;

public class VentanaPrincipal {
	private VentanaGuardado guardado = new VentanaGuardado();
	private JFrame frmAplicacionDeCorreo;
	private JPanel pnlPanelPrincipal;
	private JLabel lblEstado;
	private JLabel lblLogo;
	private JLabel lblUsuario;
	private JLabel lblContraseña;
	private JTextField txtUsuario;
	private JPasswordField pwdContraseña;
	private JCheckBox cbMostrarLogo;
	private JButton btnEntrar;
	private JLabel lblAviso;
	private final String password = "ipo1";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					
					window.frmAplicacionDeCorreo.setVisible(true);
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
		frmAplicacionDeCorreo = new JFrame();
		frmAplicacionDeCorreo.setResizable(false);
		frmAplicacionDeCorreo.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/presentacion/correo1.jpg")));
		frmAplicacionDeCorreo.setTitle("Aplicacion de Correo");
		frmAplicacionDeCorreo.setBounds(100, 100, 552, 354);
		frmAplicacionDeCorreo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pnlPanelPrincipal = new JPanel();
		pnlPanelPrincipal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblEstado.setText("Has hecho click en ["+e.getX()+", "+e.getY()+"]");
			}
		});
		frmAplicacionDeCorreo.getContentPane().add(pnlPanelPrincipal, BorderLayout.CENTER);
		pnlPanelPrincipal.setLayout(null);
		
		lblLogo = new JLabel("");
		lblLogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblLogo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/presentacion/112.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblLogo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/presentacion/012.png")));
			}
		});
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/presentacion/012.png")));
		lblLogo.setBounds(71, 55, 116, 132);
		pnlPanelPrincipal.add(lblLogo);
		
		lblUsuario = new JLabel("Usuario :");
		lblUsuario.setBounds(244, 76, 89, 14);
		pnlPanelPrincipal.add(lblUsuario);
		
		lblContraseña = new JLabel("Contraseña :");
		lblContraseña.setEnabled(false);
		lblContraseña.setBounds(244, 101, 89, 14);
		pnlPanelPrincipal.add(lblContraseña);
		
		txtUsuario = new JTextField();
		txtUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblContraseña.setEnabled(true);
				pwdContraseña.setEnabled(true);
				btnEntrar.setEnabled(true);
			}
		});
		txtUsuario.setBounds(321, 73, 192, 20);
		pnlPanelPrincipal.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		pwdContraseña = new JPasswordField();
		pwdContraseña.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				lblEstado.setText("Tecla Pulsada: ["+e.getKeyChar()+"]");
			}
		});
		pwdContraseña.setEnabled(false);
		pwdContraseña.setBounds(321, 101, 192, 20);
		pnlPanelPrincipal.add(pwdContraseña);
		
		cbMostrarLogo = new JCheckBox("Mostrar Logo");
		cbMostrarLogo.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				lblLogo.setVisible(cbMostrarLogo.isSelected());
			}
		});
		cbMostrarLogo.setSelected(true);
		cbMostrarLogo.setBounds(71, 194, 126, 23);
		pnlPanelPrincipal.add(cbMostrarLogo);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (String.valueOf(pwdContraseña.getPassword()).equals(password)){
					lblAviso.setVisible(true);
				}
				guardado.frmGuardado.setVisible(true);
			}
		});
		btnEntrar.setEnabled(false);
		btnEntrar.setBounds(424, 194, 89, 23);
		pnlPanelPrincipal.add(btnEntrar);
		
		lblAviso = new JLabel("ESTAS EN IPO CRACK");
		lblAviso.setVisible(false);
		lblAviso.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		lblAviso.setOpaque(true);
		lblAviso.setHorizontalAlignment(SwingConstants.CENTER);
		lblAviso.setBounds(244, 145, 269, 35);
		pnlPanelPrincipal.add(lblAviso);
		
		lblEstado = new JLabel("Aquí se mostrarán los eventos capturados");
		lblEstado.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblEstado.setText("Coordenadas dentro de barra de estado: ["+e.getX()+", "+e.getY() +"]");
			}
		});
		lblEstado.setPreferredSize(new Dimension(208, 50));
		lblEstado.setOpaque(true);
		lblEstado.setBackground(UIManager.getColor("info"));
		lblEstado.setHorizontalAlignment(SwingConstants.CENTER);
		frmAplicacionDeCorreo.getContentPane().add(lblEstado, BorderLayout.SOUTH);
	}
}
