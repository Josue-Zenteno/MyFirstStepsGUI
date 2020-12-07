package presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogoSeleccionIdioma extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JRadioButton rdbtnIngles;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoSeleccionIdioma dialog = new DialogoSeleccionIdioma();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoSeleccionIdioma() {
		setBounds(100, 100, 450, 130);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel lblIdioma = new JLabel("Seleccione el idioma:");
			contentPanel.add(lblIdioma);
		}
		{
			rdbtnIngles = new JRadioButton("Inglés");
			rdbtnIngles.setIcon(new ImageIcon(DialogoSeleccionIdioma.class.getResource("/presentacion/banderaIng.gif")));
			contentPanel.add(rdbtnIngles);
		}
		{
			JRadioButton rdbtnEspanol = new JRadioButton("Español");
			rdbtnEspanol.setIcon(new ImageIcon(DialogoSeleccionIdioma.class.getResource("/presentacion/banderaEsp.gif")));
			contentPanel.add(rdbtnEspanol);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new OkButtonActionListener());
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

	private class OkButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			
			if (rdbtnIngles.isSelected())
				MensajesVentanaPrincipalInter.setIdioma("inglés");
			
			VentanaPrincipal ventana = new VentanaPrincipal();
			ventana.getFrame().setVisible(true);
			dispose();
		}
	}
}
