package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.JPanel;
import java.awt.CardLayout;
@SuppressWarnings({ "serial"})
public class EjemploArbol {

	private JFrame frame;
	private JSplitPane splitPane;
	private JScrollPane scrollPane;
	private JTree tree;
	private JPanel panelCard;
	private JPanel pnlTeclado;
	private JPanel pnlComponentesDinamicos;
	private JPanel pnlLayoutDinamico;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjemploArbol window = new EjemploArbol();
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
	public EjemploArbol() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 900, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		splitPane = new JSplitPane();
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		scrollPane = new JScrollPane();
		scrollPane.setMinimumSize(new Dimension(200, 23));
		splitPane.setLeftComponent(scrollPane);
		
		tree = new JTree();
		tree.addTreeSelectionListener(new TreeTreeSelectionListener());
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Inicio") {
				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("Ejemplo Teclado");
						node_1.add(new DefaultMutableTreeNode("Ayuda"));
						node_1.add(new DefaultMutableTreeNode("Adjunto"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Ejemplo Componentes Dinámicos");
						node_1.add(new DefaultMutableTreeNode("Ayuda"));
						node_1.add(new DefaultMutableTreeNode("Adjunto"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Ejemplo Layout Dinámico");
						node_1.add(new DefaultMutableTreeNode("Ayuda"));
						node_1.add(new DefaultMutableTreeNode("Adjunto"));
					add(node_1);
				}
			}
		));
		scrollPane.setViewportView(tree);
		tree.getSelectionModel().setSelectionMode
		(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.setCellRenderer(new MiRenderizadoArbol());
		
		panelCard = new JPanel();
		splitPane.setRightComponent(panelCard);
		panelCard.setLayout(new CardLayout(0, 0));
		
		pnlTeclado = new MiPanelTeclado();
		panelCard.add(pnlTeclado, "Ejemplo Teclado");
		
		pnlComponentesDinamicos = new MiPanelAutores();
		panelCard.add(pnlComponentesDinamicos, "Ejemplo Componentes Dinámicos");
		
		pnlLayoutDinamico = new MiPanelGridConfigurable();
		panelCard.add(pnlLayoutDinamico, "Ejemplo Layout Dinámico");
	}

	private class TreeTreeSelectionListener implements TreeSelectionListener {
		public void valueChanged(TreeSelectionEvent arg0) {
			System.out.println("Nodo seleccionado: "+arg0.getPath().getLastPathComponent());
			String nodo = (arg0.getPath().getLastPathComponent()).toString();
			switch (nodo)
			{
				case "Ejemplo Teclado":
				case "Ejemplo Componentes Dinámicos":
				case "Ejemplo Layout Dinámico":
					((CardLayout) panelCard.getLayout()).show(panelCard, nodo);
			}
		}
	}
}
