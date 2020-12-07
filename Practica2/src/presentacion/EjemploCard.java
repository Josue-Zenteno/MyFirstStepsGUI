package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class EjemploCard extends JFrame {

	private JPanel contentPane;
	private JPanel pnlBotones;
	private JButton btnPanel1;
	private JButton btnPanel2;
	private JButton btnPanel3;
	private JPanel pnlContenido;
	private JPanel Panel1;
	private JPanel Panel2;
	private JPanel Panel3;
	private JButton btnEjemplo;
	private JRadioButton rbEjemplo;
	@SuppressWarnings("rawtypes")
	private JComboBox cbEjemplo;
	private JButton btnPanel4;
	private JPanel Panel4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjemploCard frame = new EjemploCard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public EjemploCard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		pnlBotones = new JPanel();
		contentPane.add(pnlBotones, BorderLayout.SOUTH);
		
		btnPanel1 = new JButton("Panel1");
		btnPanel1.addActionListener(new BtnPanelActionListener()); //Añadimos el listener a todos lo botones que queramos que lo tengan
		pnlBotones.add(btnPanel1);
		
		btnPanel2 = new JButton("Panel2");
		btnPanel2.addActionListener(new BtnPanelActionListener());
		pnlBotones.add(btnPanel2);
		
		btnPanel3 = new JButton("Panel3");
		btnPanel3.addActionListener(new BtnPanelActionListener());
		pnlBotones.add(btnPanel3);
		
		btnPanel4 = new JButton("Panel4");
		btnPanel4.addActionListener(new BtnPanelActionListener());
		pnlBotones.add(btnPanel4);
		
		pnlContenido = new JPanel();
		contentPane.add(pnlContenido, BorderLayout.CENTER);
		pnlContenido.setLayout(new CardLayout(0, 0));
		
		Panel1 = new JPanel();
		pnlContenido.add(Panel1, "Panel1"); //El nombre tiene que ser exactamente el mismo que le pongamos en lso botones pk haremos un oyente que busqeu por la etiqueta del boton
		
		btnEjemplo = new JButton("Ejemplo");
		Panel1.add(btnEjemplo);
		
		Panel2 = new JPanel();
		pnlContenido.add(Panel2, "Panel2");
		
		cbEjemplo = new JComboBox();
		cbEjemplo.setModel(new DefaultComboBoxModel(new String[] {"Model"}));
		Panel2.add(cbEjemplo);
		
		Panel3 = new JPanel();
		pnlContenido.add(Panel3, "Panel3");
		
		rbEjemplo = new JRadioButton("Ejemplo");
		Panel3.add(rbEjemplo);
		
		Panel4 = new MiPanelReutilizable();
		pnlContenido.add(Panel4, "Panel4");
	}
	private class BtnPanelActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			((CardLayout)pnlContenido.getLayout()).show(pnlContenido, e.getActionCommand()); //Esto nos da la etiqueta del boton y en caso de los menus nos da el texto del menu
		}
	}
}
