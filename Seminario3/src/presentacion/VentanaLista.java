package presentacion;


import javax.swing.JInternalFrame;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings({ "serial","rawtypes", "unchecked" })
public class VentanaLista extends JInternalFrame {
	private JButton btnAnadirElemento;
	private JLabel lblFilaSeleccionada;
	private JScrollPane scrollPane;
	
	private JList lstIdiomas;
	/**
	 * Create the frame.
	 */
	
	public VentanaLista() {
		setResizable(true);
		setFrameIcon(new ImageIcon(VentanaLista.class.getResource("/presentacion/idioma.png")));
		setMaximizable(true);
		setIconifiable(true);
		setBounds(new Rectangle(50, 50, 200, 400));
		
		btnAnadirElemento = new JButton("Añadir Elemento");
		btnAnadirElemento.addActionListener(new BtnAnadirElementoActionListener());
		getContentPane().add(btnAnadirElemento, BorderLayout.NORTH);
		
		lblFilaSeleccionada = new JLabel("Fila seleccionada:");
		getContentPane().add(lblFilaSeleccionada, BorderLayout.SOUTH);
		
		scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		lstIdiomas = new JList();
		lstIdiomas.addListSelectionListener(new LstIdiomasListSelectionListener());
		
		/*lstIdiomas.setModel(new AbstractListModel() {
			String[] values = new String[] {"Español", "Inglés", "Idioma"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});*/
		
		lstIdiomas = new JList();
		DefaultListModel modeloLista = new DefaultListModel();
		lstIdiomas.setModel(modeloLista);
		//Añadimos dos elementos de prueba a la lista
		modeloLista.addElement("Español");
		modeloLista.addElement("Inglés");
		
		scrollPane.setViewportView(lstIdiomas);
		//setBounds(100, 100, 450, 300);
		
		//Con los renders o uno u otro :(
		
		//lstIdiomas.setCellRenderer(new MiListCellRenderer()); 
		lstIdiomas.setCellRenderer(new OtroListCellRenderer());

	}

	private class LstIdiomasListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent arg0) {
			lblFilaSeleccionada.setText("Fila seleccionada: "+lstIdiomas.getSelectedValue());
		}
	}
	private class BtnAnadirElementoActionListener implements ActionListener {
		
		public void actionPerformed(ActionEvent arg0) {
			
			DefaultListModel modeloLista= (DefaultListModel) lstIdiomas.getModel();
			int indice = modeloLista.getSize();
			modeloLista.addElement("Idioma " + (indice+1));
			lstIdiomas.setSelectedIndex(indice);
			lstIdiomas.ensureIndexIsVisible(indice);
		}
	}
}
