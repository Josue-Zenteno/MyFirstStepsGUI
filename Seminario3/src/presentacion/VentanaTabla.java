package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

@SuppressWarnings({ "serial","rawtypes", "unchecked" })
public class VentanaTabla extends JInternalFrame {
	private JToolBar toolBar;
	private JButton btnAnadirFila;
	private JButton btnEliminarFila;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JLabel lblFoto;
	private JTextArea taFilaSeleccionada;
	private JScrollPane scrollPane_1;
	private JTable miTabla;
	private JPopupMenu popupMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;

	/**
	 * Create the frame.
	 */
	
	public VentanaTabla() {
		setFrameIcon(new ImageIcon(VentanaTabla.class.getResource("/presentacion/iconoFrame.jpg")));
		setResizable(true);
		setMaximizable(true);
		setIconifiable(true);
		setTitle("Ejemplo Tabla");
		setBounds(200, 200, 400, 400);
		
		toolBar = new JToolBar();
		getContentPane().add(toolBar, BorderLayout.NORTH);
		
		btnAnadirFila = new JButton("Añadir");
		btnAnadirFila.addActionListener(new BtnAnadirFilaActionListener());
		btnAnadirFila.setIcon(new ImageIcon(VentanaTabla.class.getResource("/presentacion/ic_menu_btn_add.png")));
		toolBar.add(btnAnadirFila);
		
		btnEliminarFila = new JButton("Eliminar");
		btnEliminarFila.addActionListener(new BtnEliminarFilaActionListener());
		btnEliminarFila.setIcon(new ImageIcon(VentanaTabla.class.getResource("/presentacion/ic_menu_delete.png")));
		toolBar.add(btnEliminarFila);
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(50, 120));
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		lblFoto = new JLabel("");
		lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setViewportView(lblFoto);
		
		taFilaSeleccionada = new JTextArea();
		panel.add(taFilaSeleccionada);
		
		scrollPane_1 = new JScrollPane();
		getContentPane().add(scrollPane_1, BorderLayout.CENTER);
		
		miTabla = new JTable();
		miTabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		MiModeloTabla modeloTabla = new MiModeloTabla();
		miTabla.setModel(modeloTabla);
		/*miTabla.setModel(new DefaultTableModel(
			new Object[][] {
				{"Sombra", "Chiwawa", null, null},
				{"Bruma", "Pastor Aleman", null, Boolean.TRUE},
			},
			new String[] {
				"Nombre", "Raza", "Foto", "Vacunado"
			}
		) {
			
			Class[] columnTypes = new Class[] {
				String.class, String.class, Object.class, Boolean.class
			};
			
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});*/
		
		Object[] fila1= {"Sombra", "Border Collie", new
		ImageIcon(getClass().getClassLoader().getResource
		("presentacion/perros/borderCollie.jpg")), true};
		modeloTabla.aniadeFila(fila1);
		
		Object[] fila2= {"Bruma", "Pastor Alemán", new
		ImageIcon(getClass().getClassLoader().getResource
		("presentacion/perros/pastorAleman.jpg")),
		false};
		modeloTabla.aniadeFila(fila2);
		
		Object[] fila3= {"Ulises", "Labrador", new
		ImageIcon(getClass().getClassLoader().getResource
		("presentacion/perros/labrador.jpg")), true};
		modeloTabla.aniadeFila(fila3);
		
		popupMenu = new JPopupMenu();
		addPopup(scrollPane_1, popupMenu); //Aquí ha añadido el pop up menu y lo ha situado en el scroll pane 
		addPopup(miTabla, popupMenu);
		
		mntmNewMenuItem = new JMenuItem("Añadir");
		mntmNewMenuItem.addActionListener(new BtnAnadirFilaActionListener());
		mntmNewMenuItem.setIcon(new ImageIcon(VentanaTabla.class.getResource("/presentacion/ic_menu_btn_add.png")));
		popupMenu.add(mntmNewMenuItem);
		
		mntmNewMenuItem_1 = new JMenuItem("Eliminar");
		mntmNewMenuItem_1.addActionListener(new BtnEliminarFilaActionListener());
		mntmNewMenuItem_1.setIcon(new ImageIcon(VentanaTabla.class.getResource("/presentacion/ic_menu_delete.png")));
		popupMenu.add(mntmNewMenuItem_1);
		
		scrollPane_1.setViewportView(miTabla);
		
		ListSelectionModel rowSM = miTabla.getSelectionModel();
		rowSM.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				ListSelectionModel lsm = (ListSelectionModel) e.getSource();
				if (!lsm.isSelectionEmpty()) {
					//int filaSeleccionada = lsm.getMinSelectionIndex() + 1;
					//taFilaSeleccionada.setText("Fila "+filaSeleccionada+" seleccionada");
					MiModeloTabla modeloTabla = (MiModeloTabla) miTabla.getModel();
					int n= miTabla.getSelectedRow();
					if (n != -1)
					{
						String contenido = "Nombre :"+ modeloTabla.getValueAt(n, 0)+":\n"+
						"Raza: "+ modeloTabla.getValueAt(n, 1)+"\n";
						contenido += (Boolean) modeloTabla.getValueAt(n, 3)?"Vacunado": "No Vacunado\n";
						taFilaSeleccionada.setText(contenido);
						lblFoto.setIcon((ImageIcon)modeloTabla.getValueAt(n, 2));
					}
				}
			}
		});

		TableColumn columnaRazas = miTabla.getColumnModel().getColumn(1);
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Border Collie");
		comboBox.addItem("Galgo");
		comboBox.addItem("Labrador");
		comboBox.addItem("Mestizo");
		comboBox.addItem("Pastor Alemán");
		columnaRazas.setCellEditor(new DefaultCellEditor(comboBox));
		
		TableColumn columnaFoto = miTabla.getColumnModel().getColumn(2);
		columnaFoto.setCellEditor(new ColumnaFotoEditor());
	}

	private class BtnAnadirFilaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			MiModeloTabla modeloTabla = (MiModeloTabla) miTabla.getModel();
			Object[] nuevaFila = {"...", "...", new
			ImageIcon(getClass().getClassLoader().getResource("presentacion/iconoPerro.jpg")),false};
			modeloTabla.aniadeFila(nuevaFila);
			modeloTabla.fireTableDataChanged();
		}
	}
	private class BtnEliminarFilaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			MiModeloTabla modeloTabla = (MiModeloTabla) miTabla.getModel();
			int n= miTabla.getSelectedRow();
			if (n != -1) modeloTabla.eliminaFila(miTabla.getSelectedRow());
			modeloTabla.fireTableDataChanged();
			taFilaSeleccionada.setText("");
			lblFoto.setIcon(null);
		}
	}

	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	
}
