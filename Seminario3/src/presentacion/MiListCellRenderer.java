package presentacion;
import javax.swing.*;
import java.awt.*;

@SuppressWarnings({ "serial","rawtypes" })
public class MiListCellRenderer extends DefaultListCellRenderer {
	protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();
	ImageIcon iconoEspanol = new ImageIcon(MiListCellRenderer.class.getResource("banderaEsp.gif"));
	ImageIcon iconoIngles = new ImageIcon(MiListCellRenderer.class.getResource("banderaIng.gif"));
	ImageIcon iconoIdioma = new ImageIcon(MiListCellRenderer.class.getResource("idioma.gif"));
	public MiListCellRenderer () {
	}
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean hasFocus)
	{
		JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index, isSelected, hasFocus);
		String elemento = (String) list.getModel().getElementAt(index);
		switch (elemento)
		{
			case "Español": renderer.setIcon(iconoEspanol); break;
			case "Inglés": renderer.setIcon(iconoIngles); break;
			default: renderer.setIcon(iconoIdioma);
		}
		return renderer;
	}
}
