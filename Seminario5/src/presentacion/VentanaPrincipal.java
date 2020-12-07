package presentacion;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import java.util.Scanner;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.ParseException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VentanaPrincipal {

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	private JFrame frame;
	private JPanel pnlFichaUsuario;
	private JLabel lblExpediente;
	private JTextField txtExpediente;
	private JLabel lblCheck;
	private JButton btnCargarFoto;
	private JScrollPane scrollPaneFoto;
	private JLabel lblFoto;
	private JButton btnCargarComentario;
	private JScrollPane scrollPaneComentarios;
	private JTextArea taComentarios;
	private JButton btnGuardar;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JLabel lblDNI;
	private JLabel lblTelefono;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JFormattedTextField ftxtDNI;
	private JFormattedTextField ftxtTelefono;
	private Border bordeRojo = BorderFactory.createLineBorder(Color.RED);
	private Border bordeVerde = BorderFactory.createLineBorder(Color.GREEN);
	private ImageIcon imagTick = new ImageIcon(VentanaPrincipal.class.getResource("/presentacion/tick.png")); //$NON-NLS-1$
	private ImageIcon imagCross = new ImageIcon(VentanaPrincipal.class.getResource("/presentacion/cross.png")); //$NON-NLS-1$
	private Color colorResaltado = new Color (255,255,210);
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenu mnNewMenu_2;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JSeparator separator;
	private JMenuItem mntmNewMenuItem_3;
	private JMenu mnNewMenu_3;
	private JRadioButtonMenuItem rdbtnmntmNewRadioItem;
	private JRadioButtonMenuItem rdbtnmntmNewRadioItem_1;
	private JRadioButtonMenuItem rdbtnmntmNewRadioItem_2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JMenuItem mntmNewMenuItem_4;
	private JMenuItem mntmNewMenuItem_5;

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
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new FrameWindowListener());
		frame.setBounds(100, 100, 632, 518);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pnlFichaUsuario = new JPanel();
		pnlFichaUsuario.setBorder(new TitledBorder(null, MensajesVentanaPrincipalInter.getString("VentanaPrincipal.pnlFichaUsuario.borderTitle"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		frame.getContentPane().add(pnlFichaUsuario, BorderLayout.CENTER);
		GridBagLayout gbl_pnlFichaUsuario = new GridBagLayout();
		gbl_pnlFichaUsuario.columnWidths = new int[]{0, 183, 73, 139, 0, 0, 0, 0};
		gbl_pnlFichaUsuario.rowHeights = new int[]{0, 0, 43, 43, 44, 48, 0, 0, 0, 0};
		gbl_pnlFichaUsuario.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_pnlFichaUsuario.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		pnlFichaUsuario.setLayout(gbl_pnlFichaUsuario);
		
		lblExpediente = new JLabel(MensajesVentanaPrincipalInter.getString("VentanaPrincipal.lblExpediente.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblExpediente = new GridBagConstraints();
		gbc_lblExpediente.anchor = GridBagConstraints.EAST;
		gbc_lblExpediente.insets = new Insets(0, 0, 5, 5);
		gbc_lblExpediente.gridx = 0;
		gbc_lblExpediente.gridy = 0;
		pnlFichaUsuario.add(lblExpediente, gbc_lblExpediente);
		
		txtExpediente = new JTextField();
		txtExpediente.addKeyListener(new TxtExpedienteKeyListener());
		
		GridBagConstraints gbc_txtExpediente = new GridBagConstraints();
		gbc_txtExpediente.insets = new Insets(0, 0, 5, 5);
		gbc_txtExpediente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtExpediente.gridx = 1;
		gbc_txtExpediente.gridy = 0;
		pnlFichaUsuario.add(txtExpediente, gbc_txtExpediente);
		txtExpediente.setColumns(10);
		
		lblCheck = new JLabel(""); //$NON-NLS-1$
		GridBagConstraints gbc_lblCheck = new GridBagConstraints();
		gbc_lblCheck.insets = new Insets(0, 0, 5, 5);
		gbc_lblCheck.gridx = 2;
		gbc_lblCheck.gridy = 0;
		pnlFichaUsuario.add(lblCheck, gbc_lblCheck);
		
		btnCargarFoto = new JButton(MensajesVentanaPrincipalInter.getString("VentanaPrincipal.btnCargarFoto.text")); //$NON-NLS-1$
		btnCargarFoto.addActionListener(new BtnCargarFotoActionListener());
		btnCargarFoto.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/presentacion/cargarFoto.png"))); //$NON-NLS-1$
		GridBagConstraints gbc_btnCargarFoto = new GridBagConstraints();
		gbc_btnCargarFoto.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCargarFoto.gridwidth = 2;
		gbc_btnCargarFoto.insets = new Insets(0, 0, 5, 5);
		gbc_btnCargarFoto.gridx = 0;
		gbc_btnCargarFoto.gridy = 1;
		pnlFichaUsuario.add(btnCargarFoto, gbc_btnCargarFoto);
		
		scrollPaneFoto = new JScrollPane();
		scrollPaneFoto.setBorder(new TitledBorder(null, MensajesVentanaPrincipalInter.getString("VentanaPrincipal.scrollPaneFoto.borderTitle"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		GridBagConstraints gbc_scrollPaneFoto = new GridBagConstraints();
		gbc_scrollPaneFoto.gridheight = 4;
		gbc_scrollPaneFoto.gridwidth = 2;
		gbc_scrollPaneFoto.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPaneFoto.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneFoto.gridx = 0;
		gbc_scrollPaneFoto.gridy = 2;
		pnlFichaUsuario.add(scrollPaneFoto, gbc_scrollPaneFoto);
		
		lblFoto = new JLabel(""); //$NON-NLS-1$
		lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPaneFoto.setViewportView(lblFoto);
		
		lblNombre = new JLabel(MensajesVentanaPrincipalInter.getString("VentanaPrincipal.lblNombre.text")); //$NON-NLS-1$
		lblNombre.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 2;
		gbc_lblNombre.gridy = 2;
		pnlFichaUsuario.add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.addFocusListener(new MiFocusListener());
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.gridwidth = 2;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 3;
		gbc_txtNombre.gridy = 2;
		pnlFichaUsuario.add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		lblApellidos = new JLabel(MensajesVentanaPrincipalInter.getString("VentanaPrincipal.lblApellidos.text")); //$NON-NLS-1$
		lblApellidos.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
		gbc_lblApellidos.anchor = GridBagConstraints.EAST;
		gbc_lblApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellidos.gridx = 2;
		gbc_lblApellidos.gridy = 3;
		pnlFichaUsuario.add(lblApellidos, gbc_lblApellidos);
		
		txtApellidos = new JTextField();
		GridBagConstraints gbc_txtApellidos = new GridBagConstraints();
		gbc_txtApellidos.gridwidth = 2;
		gbc_txtApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_txtApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtApellidos.gridx = 3;
		gbc_txtApellidos.gridy = 3;
		pnlFichaUsuario.add(txtApellidos, gbc_txtApellidos);
		txtApellidos.setColumns(10);
		
		lblDNI = new JLabel(MensajesVentanaPrincipalInter.getString("VentanaPrincipal.lblDNI.text")); //$NON-NLS-1$
		lblDNI.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblDNI = new GridBagConstraints();
		gbc_lblDNI.anchor = GridBagConstraints.EAST;
		gbc_lblDNI.insets = new Insets(0, 0, 5, 5);
		gbc_lblDNI.gridx = 2;
		gbc_lblDNI.gridy = 4;
		pnlFichaUsuario.add(lblDNI, gbc_lblDNI);
		
		//ftxtDNI = new JFormattedTextField();
		MaskFormatter formatoDNI;
		try {
		formatoDNI = new MaskFormatter("########'-U"); //$NON-NLS-1$
		formatoDNI.setPlaceholderCharacter('X');
		ftxtDNI = new JFormattedTextField(formatoDNI);
		} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}

		GridBagConstraints gbc_ftxtDNI = new GridBagConstraints();
		gbc_ftxtDNI.insets = new Insets(0, 0, 5, 5);
		gbc_ftxtDNI.fill = GridBagConstraints.HORIZONTAL;
		gbc_ftxtDNI.gridx = 3;
		gbc_ftxtDNI.gridy = 4;
		pnlFichaUsuario.add(ftxtDNI, gbc_ftxtDNI);
		
		lblTelefono = new JLabel(MensajesVentanaPrincipalInter.getString("VentanaPrincipal.lblTelefono.text")); //$NON-NLS-1$
		lblTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.anchor = GridBagConstraints.EAST;
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.gridx = 2;
		gbc_lblTelefono.gridy = 5;
		pnlFichaUsuario.add(lblTelefono, gbc_lblTelefono);
		
		//ftxtTelefono = new JFormattedTextField();
		MaskFormatter formatoTlfno;
		try {
		formatoTlfno = new MaskFormatter("'(###')' ###' ###' ###"); //$NON-NLS-1$
		formatoTlfno.setPlaceholderCharacter('*');
		ftxtTelefono = new JFormattedTextField(formatoTlfno);
		} catch (ParseException e) {
		// Auto-generated catch block
		e.printStackTrace();
		}
		GridBagConstraints gbc_ftxtTelefono = new GridBagConstraints();
		gbc_ftxtTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_ftxtTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_ftxtTelefono.gridx = 3;
		gbc_ftxtTelefono.gridy = 5;
		pnlFichaUsuario.add(ftxtTelefono, gbc_ftxtTelefono);
		
		btnCargarComentario = new JButton(MensajesVentanaPrincipalInter.getString("VentanaPrincipal.btnCargarComentario.text")); //$NON-NLS-1$
		btnCargarComentario.addActionListener(new BtnCargarComentarioActionListener());
		btnCargarComentario.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/presentacion/cargarComentarios.png"))); //$NON-NLS-1$
		GridBagConstraints gbc_btnCargarComentario = new GridBagConstraints();
		gbc_btnCargarComentario.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCargarComentario.gridwidth = 3;
		gbc_btnCargarComentario.insets = new Insets(0, 0, 5, 5);
		gbc_btnCargarComentario.gridx = 0;
		gbc_btnCargarComentario.gridy = 6;
		pnlFichaUsuario.add(btnCargarComentario, gbc_btnCargarComentario);
		
		scrollPaneComentarios = new JScrollPane();
		scrollPaneComentarios.setBorder(new TitledBorder(null, MensajesVentanaPrincipalInter.getString("VentanaPrincipal.scrollPaneComentarios.borderTitle"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		GridBagConstraints gbc_scrollPaneComentarios = new GridBagConstraints();
		gbc_scrollPaneComentarios.gridwidth = 7;
		gbc_scrollPaneComentarios.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPaneComentarios.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneComentarios.gridx = 0;
		gbc_scrollPaneComentarios.gridy = 7;
		pnlFichaUsuario.add(scrollPaneComentarios, gbc_scrollPaneComentarios);
		
		taComentarios = new JTextArea();
		taComentarios.setText(MensajesVentanaPrincipalInter.getString("VentanaPrincipal.taComentarios.text")); //$NON-NLS-1$
		scrollPaneComentarios.setViewportView(taComentarios);
		
		btnGuardar = new JButton(MensajesVentanaPrincipalInter.getString("VentanaPrincipal.btnGuardar.text")); //$NON-NLS-1$
		btnGuardar.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/presentacion/guardar.png"))); //$NON-NLS-1$
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.gridx = 6;
		gbc_btnGuardar.gridy = 8;
		pnlFichaUsuario.add(btnGuardar, gbc_btnGuardar);
		
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu(MensajesVentanaPrincipalInter.getString("VentanaPrincipal.mnNewMenu.text")); //$NON-NLS-1$
		mnNewMenu.setMnemonic('a');
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem(MensajesVentanaPrincipalInter.getString("VentanaPrincipal.mntmNewMenuItem.text")); //$NON-NLS-1$
		mntmNewMenuItem.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/presentacion/abrir.png"))); //$NON-NLS-1$
		mnNewMenu.add(mntmNewMenuItem);
		
		mntmNewMenuItem_1 = new JMenuItem(MensajesVentanaPrincipalInter.getString("VentanaPrincipal.mntmNewMenuItem_1.text")); //$NON-NLS-1$
		mntmNewMenuItem_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/presentacion/cargarFoto.png"))); //$NON-NLS-1$
		mnNewMenu.add(mntmNewMenuItem_1);
		
		mntmNewMenuItem_2 = new JMenuItem(MensajesVentanaPrincipalInter.getString("VentanaPrincipal.mntmNewMenuItem_2.text")); //$NON-NLS-1$
		mntmNewMenuItem_2.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/presentacion/cargarComentarios.png"))); //$NON-NLS-1$
		mnNewMenu.add(mntmNewMenuItem_2);
		
		separator = new JSeparator();
		mnNewMenu.add(separator);
		
		mntmNewMenuItem_3 = new JMenuItem(MensajesVentanaPrincipalInter.getString("VentanaPrincipal.mntmNewMenuItem_3.text")); //$NON-NLS-1$
		mntmNewMenuItem_3.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/presentacion/guardar.png"))); //$NON-NLS-1$
		mntmNewMenuItem_3.setSelectedIcon(null);
		mnNewMenu.add(mntmNewMenuItem_3);
		
		mnNewMenu_1 = new JMenu(MensajesVentanaPrincipalInter.getString("VentanaPrincipal.mnNewMenu_1.text")); //$NON-NLS-1$
		mnNewMenu_1.setMnemonic('e');
		menuBar.add(mnNewMenu_1);
		
		mnNewMenu_3 = new JMenu(MensajesVentanaPrincipalInter.getString("VentanaPrincipal.mnNewMenu_3.text")); //$NON-NLS-1$
		mnNewMenu_1.add(mnNewMenu_3);
		
		rdbtnmntmNewRadioItem = new JRadioButtonMenuItem(MensajesVentanaPrincipalInter.getString("VentanaPrincipal.rdbtnmntmNewRadioItem.text")); //$NON-NLS-1$
		rdbtnmntmNewRadioItem.addActionListener(new RdbtnmntmNewRadioItemActionListener());
		buttonGroup.add(rdbtnmntmNewRadioItem);
		mnNewMenu_3.add(rdbtnmntmNewRadioItem);
		
		rdbtnmntmNewRadioItem_1 = new JRadioButtonMenuItem(MensajesVentanaPrincipalInter.getString("VentanaPrincipal.rdbtnmntmNewRadioItem_1.text")); //$NON-NLS-1$
		rdbtnmntmNewRadioItem_1.addActionListener(new RdbtnmntmNewRadioItem_1ActionListener());
		buttonGroup.add(rdbtnmntmNewRadioItem_1);
		mnNewMenu_3.add(rdbtnmntmNewRadioItem_1);
		
		rdbtnmntmNewRadioItem_2 = new JRadioButtonMenuItem(MensajesVentanaPrincipalInter.getString("VentanaPrincipal.rdbtnmntmNewRadioItem_2.text")); //$NON-NLS-1$
		rdbtnmntmNewRadioItem_2.addActionListener(new RdbtnmntmNewRadioItem_2ActionListener());
		buttonGroup.add(rdbtnmntmNewRadioItem_2);
		mnNewMenu_3.add(rdbtnmntmNewRadioItem_2);
		
		mnNewMenu_2 = new JMenu(MensajesVentanaPrincipalInter.getString("VentanaPrincipal.mnNewMenu_2.text")); //$NON-NLS-1$
		mnNewMenu_2.setMnemonic('y');
		menuBar.add(mnNewMenu_2);
		
		mntmNewMenuItem_4 = new JMenuItem(MensajesVentanaPrincipalInter.getString("VentanaPrincipal.mntmNewMenuItem_4.text")); //$NON-NLS-1$
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		mntmNewMenuItem_5 = new JMenuItem(MensajesVentanaPrincipalInter.getString("VentanaPrincipal.mntmNewMenuItem_5.text")); //$NON-NLS-1$
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		txtExpediente.addFocusListener(new MiFocusListener());
		txtApellidos.addFocusListener(new MiFocusListener());
		ftxtDNI.addFocusListener(new MiFocusListener());
		ftxtTelefono.addFocusListener(new MiFocusListener());
		taComentarios.addFocusListener(new MiFocusListener());
	}	
	
	private class TxtExpedienteKeyListener extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			if (txtExpediente.getText().equals("Exp345")) //$NON-NLS-1$
			{
			txtExpediente.setBorder(bordeVerde);
			lblCheck.setIcon(imagTick);
			} else
			{
			txtExpediente.setBorder(bordeRojo);
			lblCheck.setIcon(imagCross);
			}
		}
	}
	private class MiFocusListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent arg0) {
			//txtNombre.setBackground(Color.YELLOW);
			arg0.getComponent().setBackground(colorResaltado);
		}
		@Override
		public void focusLost(FocusEvent arg0) {
			//txtNombre.setBackground(Color.WHITE);
			arg0.getComponent().setBackground(Color.WHITE);
		}
	}
	private class BtnCargarFotoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			JFileChooser fcAbrir = new JFileChooser();
			fcAbrir.setFileFilter(new ImageFilter());
			int valorDevuelto = fcAbrir.showOpenDialog(frame);
			//Recoger el nombre del fichero seleccionado por el usuario
			if (valorDevuelto == JFileChooser.APPROVE_OPTION) {
			File file = fcAbrir.getSelectedFile();
			//En este punto la aplicación se debería encargar de realizar la operación sobre el fichero
			//System.out.println("Fichero seleccionado: " + file.getName());
			lblFoto.setIcon(new ImageIcon(file.getAbsolutePath()));
			}
		}
	}
	private class BtnCargarComentarioActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			JFileChooser fcAbrir = new JFileChooser();
			int valorDevuelto = fcAbrir.showOpenDialog(frame);
			//Recoger el nombre del fichero seleccionado por el usuario
			if (valorDevuelto == JFileChooser.APPROVE_OPTION) {
			File file = fcAbrir.getSelectedFile();
			System.out.println("Fichero seleccionado: " + file.getName()); //$NON-NLS-1$
			try{
			taComentarios.setText(""); //$NON-NLS-1$
			// Lectura del fichero (Scanner)
			Scanner sc = new Scanner(file);
			// Lectura del fichero linea a linea
			while (sc.hasNextLine()) {
			String linea = sc.nextLine();
			System.out.println(linea);
			taComentarios.append(linea+"\n"); //$NON-NLS-1$
			}
			sc.close(); // Cerrar el fichero
			System.out.println("Fichero leído : " + file.getName() + "."); //$NON-NLS-1$ //$NON-NLS-2$
			}
			catch (IOException ioe){
			System.out.println("Problemas mientras se leía el archivo"); //$NON-NLS-1$
			}
			}else
			System.out.println("El usuario ha cancelado el proceso de lectura."); //$NON-NLS-1$
		}
	}
	private class RdbtnmntmNewRadioItemActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			taComentarios.setFont(new
					Font(taComentarios.getFont().getFontName(),
					taComentarios.getFont().getStyle(), 8));
		}
	}
	private class RdbtnmntmNewRadioItem_1ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			taComentarios.setFont(new
					Font(taComentarios.getFont().getFontName(),
					taComentarios.getFont().getStyle(), 12));
		}
	}
	private class RdbtnmntmNewRadioItem_2ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			taComentarios.setFont(new
					Font(taComentarios.getFont().getFontName(),
					taComentarios.getFont().getStyle(), 16));
		}
	}
	private class FrameWindowListener extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			JOptionPane.showMessageDialog(frame, MensajesVentanaPrincipalInter.getString("VentanaPrincipal.MensajeOptionPaneCerrar"), MensajesVentanaPrincipalInter.getString("VentanaPrincipal.TituloOptionPaneCerrar"),JOptionPane.PLAIN_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}
}
