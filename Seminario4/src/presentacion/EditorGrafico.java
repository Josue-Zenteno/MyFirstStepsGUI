package presentacion;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;


public class EditorGrafico {

	private JFrame frame;
	private JToolBar tbBarraHerramientas;
	private JButton btnCargarMapa;
	private JButton btnSoleado;
	private JButton btnNublado;
	private JButton btnRectangulo;
	private JButton btnAnotacion;
	private JScrollPane scrollPane;
	
	private MiAreaDibujo miAreaDibujo;
	private ImageIcon imagen;
	
	//Variable que almacena el modo de dibujado seleccionado por el usuario
	int modo = -1;
	private final int SOLEADO = 1;
	private final int NUBLADO = 2;
	private final int RECTANGULO = 3;
	private final int TEXTO = 4;
	//Cursores e imagenes
	private Toolkit toolkit;
	private Image imagSoleado;
	private Image imagNublado;
	private Image imagRectangulo;
	private Image imagTexto;
	private Image imagCursorSoleado;
	private Image imagCursorNublado;
	private Cursor cursorSoleado;
	private Cursor cursorNublado;
	private Cursor cursorRectangulo;
	private Cursor cursorTexto;
	
	private int x,y;
	private JTextField txtTexto = new JTextField();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditorGrafico window = new EditorGrafico();
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
	public EditorGrafico() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//Creación de imágenes y cursores
		toolkit = Toolkit.getDefaultToolkit();
		imagSoleado = toolkit.getImage(getClass().getClassLoader().getResource("presentacion/soleado.png"));
		imagNublado = toolkit.getImage(getClass().getClassLoader().getResource("presentacion/nubesYClaros.png"));
		imagRectangulo = toolkit.getImage(getClass().getClassLoader().getResource("presentacion/rectangulo.png"));
		imagTexto = toolkit.getImage(getClass().getClassLoader().getResource("presentacion/aniadirAnotacion.png"));
		imagCursorSoleado = toolkit.getImage(getClass().getClassLoader().getResource("presentacion/cursorSoleado.png"));
		imagCursorNublado = toolkit.getImage(getClass().getClassLoader().getResource("presentacion/cursorNubesYClaros.png"));
		
		//Creación de los cursores
		cursorRectangulo = toolkit.createCustomCursor(imagRectangulo,new Point(0,0),"CURSOR_RECTANGULO");
		cursorTexto= toolkit.createCustomCursor(imagTexto,new Point(0,0),"CURSOR_TEXTO");
		cursorSoleado = toolkit.createCustomCursor(imagCursorSoleado,new Point(0,0),"CURSOR_SOL");
		cursorNublado = toolkit.createCustomCursor(imagCursorNublado,new Point(0,0),"CURSOR_NUBLADO");
		
		//Creación de elementos del programa
		frame = new JFrame();
		frame.setBounds(0, 0, 700, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tbBarraHerramientas = new JToolBar();
		frame.getContentPane().add(tbBarraHerramientas, BorderLayout.NORTH);
		
		btnCargarMapa = new JButton("");
		btnCargarMapa.addActionListener(new BtnCargarMapaActionListener());
		btnCargarMapa.setIcon(new ImageIcon(EditorGrafico.class.getResource("/presentacion/cargarMapa.png")));
		tbBarraHerramientas.add(btnCargarMapa);
		
		btnSoleado = new JButton("");
		btnSoleado.addActionListener(new BtnSoleadoActionListener());
		btnSoleado.setIcon(new ImageIcon(EditorGrafico.class.getResource("/presentacion/soleado.png")));
		tbBarraHerramientas.add(btnSoleado);
		
		btnNublado = new JButton("");
		btnNublado.addActionListener(new BtnNubladoActionListener());
		btnNublado.setIcon(new ImageIcon(EditorGrafico.class.getResource("/presentacion/nubesYClaros.png")));
		tbBarraHerramientas.add(btnNublado);
		
		btnRectangulo = new JButton("");
		btnRectangulo.addActionListener(new BtnRectanguloActionListener());
		btnRectangulo.setIcon(new ImageIcon(EditorGrafico.class.getResource("/presentacion/rectangulo.png")));
		tbBarraHerramientas.add(btnRectangulo);
		
		btnAnotacion = new JButton("");
		btnAnotacion.addActionListener(new BtnAnotacionActionListener());
		btnAnotacion.setIcon(new ImageIcon(EditorGrafico.class.getResource("/presentacion/aniadirAnotacion.png")));
		tbBarraHerramientas.add(btnAnotacion);
		
		scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		miAreaDibujo = new MiAreaDibujo();
		miAreaDibujo.addMouseMotionListener(new MiAreaDibujoMouseMotionListener());
		miAreaDibujo.addMouseListener(new MiAreaDibujoMouseListener());
		scrollPane.setViewportView(miAreaDibujo);
		
		
	}

	private class BtnCargarMapaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			JFileChooser fcAbrir = new JFileChooser();
			int valorDevuelto = fcAbrir.showOpenDialog(frame);
			if (valorDevuelto == JFileChooser.APPROVE_OPTION) {
				File file = fcAbrir.getSelectedFile();
				imagen = new ImageIcon(file.getAbsolutePath());
				miAreaDibujo.setIcon(imagen);
			}
		}
	}
	private class BtnSoleadoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			modo = SOLEADO;
			frame.setCursor(cursorSoleado);
		}
	}
	private class BtnNubladoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			modo = NUBLADO;
			frame.setCursor(cursorNublado);
		}
	}
	private class BtnRectanguloActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			modo = RECTANGULO;
			frame.setCursor(cursorRectangulo);
		}
	}
	private class BtnAnotacionActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			modo = TEXTO;
			frame.setCursor(cursorTexto);
		}
	}
	private class MiAreaDibujoMouseListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			x = e.getX();
			y = e.getY();
			if (imagen != null){
				switch (modo){
					case SOLEADO:
						miAreaDibujo.addObjetoGrafico(new ImagenGrafico(x,y,imagSoleado));
						miAreaDibujo.repaint();
						break;
					case NUBLADO:
						miAreaDibujo.addObjetoGrafico(new ImagenGrafico(x,y,imagNublado));
						miAreaDibujo.repaint();
						break;
					case RECTANGULO:
						miAreaDibujo.addObjetoGrafico(new RectanguloGrafico(x,y,x,y, Color.RED));
						break;
					case TEXTO:
						txtTexto.setBounds(x, y, 200,30);
						txtTexto.setVisible(true);
						txtTexto.requestFocus();
						txtTexto.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg) {
								if(!txtTexto.getText().equals(""))
								miAreaDibujo.addObjetoGrafico(new TextoGrafico(x, y+15, txtTexto.getText(),Color.BLUE));
								
								txtTexto.setText("");
								txtTexto.setVisible(false);
								miAreaDibujo.repaint();
							}
						});
						miAreaDibujo.add(txtTexto);
				}
			}
		}
	}
	private class MiAreaDibujoMouseMotionListener extends MouseMotionAdapter {
		@Override
		public void mouseDragged(MouseEvent e) {
			if (modo == RECTANGULO && imagen!=null) {
				((RectanguloGrafico)miAreaDibujo.getUltimoObjetoGrafico()).setX1(e.getX());
				((RectanguloGrafico)miAreaDibujo.getUltimoObjetoGrafico()).setY1(e.getY());
				miAreaDibujo.repaint();
			}

		}
	}
}
