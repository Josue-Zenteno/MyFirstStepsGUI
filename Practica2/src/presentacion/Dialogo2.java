package presentacion;

import java.awt.BorderLayout;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dominio.cliente;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Dialogo2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnAceptar;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Create the frame.
	 * @param c 
	 */
	public Dialogo2(cliente c) {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 352, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		btnAceptar = new JButton("Aceptar");
		contentPane.add(btnAceptar, BorderLayout.SOUTH);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		String contenido = "Datos de "+ c.getNombre()+" "+c.getApellidos()+":\n"+
					" -- Nivel de estudios: "+ c.getNivelDeEstudios()+"\n"+
					" -- Estado Civil: ";
					contenido += c.getEstadoCivil()?" Casado\n": "Soltero\n";
					contenido += " -- Número de hijos : "+ c.getNumeroDeHijos()+"\n\n"+
					"Los datos se han guardado";
					textArea.setText(contenido);
	}

}
