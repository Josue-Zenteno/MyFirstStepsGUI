package presentacion;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;

@SuppressWarnings({ "serial"})
public class MiPanelAutores extends JPanel {
	private JPanel panel;
	private JButton btnAnadirAutor;
	private JButton btnBorrarAutor;
	private JScrollPane scrollPane;
	private JPanel pnlListado;

	/**
	 * Create the panel.
	 */
	public MiPanelAutores() {
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		
		btnAnadirAutor = new JButton("Añadir Autor");
		btnAnadirAutor.addActionListener(new BtnAnadirAutorActionListener());
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel.add(btnAnadirAutor);
		
		btnBorrarAutor = new JButton("Borrar Autor");
		btnBorrarAutor.addActionListener(new BtnBorrarAutorActionListener());
		panel.add(btnBorrarAutor);
		
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		pnlListado = new JPanel();
		scrollPane.setViewportView(pnlListado);
		FlowLayout fl_pnlListado = new FlowLayout(FlowLayout.CENTER, 5, 5);
		pnlListado.setLayout(fl_pnlListado);

	}

	private class BtnAnadirAutorActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			pnlListado.add(new MiPanelReutilizable());
			pnlListado.repaint();
			pnlListado.revalidate();
		}
	}
	private class BtnBorrarAutorActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if (pnlListado.getComponentCount()>=1){
				pnlListado.remove(pnlListado.getComponentCount()-1);
				pnlListado.repaint();
				pnlListado.revalidate();
			}

		}
	}
}
