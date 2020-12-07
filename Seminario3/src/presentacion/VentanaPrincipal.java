package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Rectangle;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;

public class VentanaPrincipal {

	private JFrame frame;
	private JDesktopPane desktopPane;

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
		frame.setBounds(new Rectangle(0, 0, 700, 700));
		//frame.setBounds(100, 100, 450, 300); Pone el bound por defecto debajo sobreescribiendo el que le pongas luego
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		desktopPane = new JDesktopPane();
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		VentanaLista ventanalista = new VentanaLista();
		desktopPane.add(ventanalista);
		ventanalista.setVisible(true);
		
		VentanaTabla ventanatabla = new VentanaTabla();
		desktopPane.add(ventanatabla);
		ventanatabla.setVisible(true);
		
	}

}
