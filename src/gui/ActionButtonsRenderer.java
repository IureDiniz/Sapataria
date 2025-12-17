package gui;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class ActionButtonsRenderer extends JPanel implements TableCellRenderer {
    private JButton btnVer;
    private JButton btnEditar;
    private JButton btnExcluir;
    
    public ActionButtonsRenderer() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 2, 0));
        
        btnVer = new JButton(new ImageIcon(getClass().getResource("/gui/icons/exibir.png")));
        btnVer.setPreferredSize(new Dimension(35, 25));
        btnVer.setToolTipText("Ver");
        
        btnEditar = new JButton(new ImageIcon(getClass().getResource("/gui/icons/editar.png")));
        btnEditar.setPreferredSize(new Dimension(35, 25));
        btnEditar.setToolTipText("Editar");
        
        btnExcluir = new JButton(new ImageIcon(getClass().getResource("/gui/icons/delete.png")));
        btnExcluir.setPreferredSize(new Dimension(35, 25));
        btnExcluir.setToolTipText("Excluir");
        
        add(btnVer);
        add(btnEditar);
        add(btnExcluir);
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return this;
    }
}
