package presentacion;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings({ "serial"})
public class MiPanelTeclado extends JPanel {
	private JButton[] botones = new JButton[9];
	Font fuente = new Font("Verdana", Font.BOLD, 40);
	BotonesActionListener oyente = new BotonesActionListener();
	
	public MiPanelTeclado() {
		setBorder(new TitledBorder(null, "Teclado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(3, 3, 0, 0));
		/*for(int i=0; i < 9; i++) {
			JButton button = new JButton(String.valueOf(i+1));
			this.add(button); // añadir cada componente al contenedor (JPanel)
		}*/
		for(int i=0; i < 9; i++) {
			botones[i] = new JButton(String.valueOf(i+1));
			this.add(botones[i]); // añadir cada componente al contenedor
			botones[i].setFont(fuente);
			botones[i].setForeground(Color.WHITE);
			botones[i].setBackground(Color.DARK_GRAY);
			botones[i].addActionListener(oyente);
		}
	}
	
	class BotonesActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		System.out.println("Pulsó el botón "+e.getActionCommand());
		}
	}

}
