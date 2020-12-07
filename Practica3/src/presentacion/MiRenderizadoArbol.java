package presentacion;

import java.awt.Component;
import javax.swing.*;
import javax.swing.tree.*;

@SuppressWarnings({ "serial"})
public class MiRenderizadoArbol  extends DefaultTreeCellRenderer{
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
			super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
			DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) value;
			String c = (String)(nodo.getUserObject());
			switch (c){
				case "Inicio":
					setIcon(new ImageIcon(MiRenderizadoArbol.class.getResource("inicio.png")));
					break;
				case "Ayuda":
					setIcon(new ImageIcon(MiRenderizadoArbol.class.getResource("ayuda.png")));
					break;
				case "Adjunto":
					setIcon(new ImageIcon(MiRenderizadoArbol.class.getResource("adjunto.png")));
					break;
				default:
					setIcon(new ImageIcon(MiRenderizadoArbol.class.getResource("pantalla.png")));
					break;
			}
			return this;
			} 
}
