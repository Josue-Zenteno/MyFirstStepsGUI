package presentacion;



import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.UIManager;

public class VentanaGuardado {

	JFrame frmGuardado;
	private JLabel lblMensajeGuardado;
	/**
	 * Create the application.
	 */
	public VentanaGuardado() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGuardado = new JFrame();
		frmGuardado.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaGuardado.class.getResource("/presentacion/images2.jpeg")));
		frmGuardado.setTitle("Guardado");
		frmGuardado.setBounds(100, 100, 194, 133);
		frmGuardado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lblMensajeGuardado = new JLabel("Guardadisimo");
		lblMensajeGuardado.setOpaque(true);
		lblMensajeGuardado.setBackground(UIManager.getColor("activeCaption"));
		lblMensajeGuardado.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMensajeGuardado.setHorizontalAlignment(SwingConstants.CENTER);
		frmGuardado.getContentPane().add(lblMensajeGuardado, BorderLayout.CENTER);
	}

}
