package presentacion;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class MiPanelReutilizable extends JPanel {
	private JLabel txtAutor;
	private JTextField textField;
	private JButton btnDetalles;
	private JButton btnLimpiar;
	private Color colorSalir = getBackground();
	private Color colorEntrar = new Color(255,255,190); 
	/**
	 * Create the panel.
	 */
	public MiPanelReutilizable() {
		addMouseListener(new ThisMouseListener());
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{70, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{27, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		txtAutor = new JLabel("Autor:");
		GridBagConstraints gbc_txtAutor = new GridBagConstraints();
		gbc_txtAutor.anchor = GridBagConstraints.EAST;
		gbc_txtAutor.insets = new Insets(0, 0, 5, 5);
		gbc_txtAutor.gridx = 0;
		gbc_txtAutor.gridy = 0;
		add(txtAutor, gbc_txtAutor);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		btnDetalles = new JButton("Detalles");
		GridBagConstraints gbc_btnDetalles = new GridBagConstraints();
		gbc_btnDetalles.insets = new Insets(0, 0, 5, 0);
		gbc_btnDetalles.gridx = 2;
		gbc_btnDetalles.gridy = 0;
		add(btnDetalles, gbc_btnDetalles);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new BtnLimpiarActionListener());
		GridBagConstraints gbc_btnLimpiar = new GridBagConstraints();
		gbc_btnLimpiar.gridx = 2;
		gbc_btnLimpiar.gridy = 1;
		add(btnLimpiar, gbc_btnLimpiar);

	}

	private class BtnLimpiarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			textField.setText("");
		}
	}
	
	private class ThisMouseListener extends MouseAdapter {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setBackground(colorEntrar);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				setBackground(colorSalir);
			}
		}
}
