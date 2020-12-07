package presentacion;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class MiPanelReutilizable extends JPanel {
	private JLabel txtAutor;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public MiPanelReutilizable() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{65, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		txtAutor = new JLabel("Autor:");
		GridBagConstraints gbc_txtAutor = new GridBagConstraints();
		gbc_txtAutor.anchor = GridBagConstraints.EAST;
		gbc_txtAutor.insets = new Insets(0, 0, 0, 5);
		gbc_txtAutor.gridx = 0;
		gbc_txtAutor.gridy = 0;
		add(txtAutor, gbc_txtAutor);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		add(textField, gbc_textField);
		textField.setColumns(10);

	}

}
