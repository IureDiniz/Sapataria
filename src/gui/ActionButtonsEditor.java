package gui;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionButtonsEditor extends AbstractCellEditor implements TableCellEditor {
    private JPanel panel;
    private JButton btnVer;
    private JButton btnEditar;
    private JButton btnExcluir;
    private JTable table;
    private int currentRow;
    private ActionListener verListener;
    private ActionListener editarListener;
    private ActionListener excluirListener;
    
    public ActionButtonsEditor(JTable table, ActionListener verListener, ActionListener editarListener, ActionListener excluirListener) {
        this.table = table;
        this.verListener = verListener;
        this.editarListener = editarListener;
        this.excluirListener = excluirListener;
        
        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 2, 0));
        
        btnVer = new JButton(new ImageIcon(getClass().getResource("/gui/icons/exibir.png")));
        btnVer.setPreferredSize(new Dimension(35, 25));
        btnVer.setToolTipText("Ver");
        
        btnEditar = new JButton(new ImageIcon(getClass().getResource("/gui/icons/editar.png")));
        btnEditar.setPreferredSize(new Dimension(35, 25));
        btnEditar.setToolTipText("Editar");
        
        btnExcluir = new JButton(new ImageIcon(getClass().getResource("/gui/icons/delete.png")));
        btnExcluir.setPreferredSize(new Dimension(35, 25));
        btnExcluir.setToolTipText("Excluir");
        
        btnVer.addActionListener(e -> {
            fireEditingStopped();
            if (verListener != null) {
                ActionEvent event = new ActionEvent(table, ActionEvent.ACTION_PERFORMED, String.valueOf(currentRow));
                verListener.actionPerformed(event);
            }
        });
        
        btnEditar.addActionListener(e -> {
            fireEditingStopped();
            if (editarListener != null) {
                ActionEvent event = new ActionEvent(table, ActionEvent.ACTION_PERFORMED, String.valueOf(currentRow));
                editarListener.actionPerformed(event);
            }
        });
        
        btnExcluir.addActionListener(e -> {
            fireEditingStopped();
            if (excluirListener != null) {
                ActionEvent event = new ActionEvent(table, ActionEvent.ACTION_PERFORMED, String.valueOf(currentRow));
                excluirListener.actionPerformed(event);
            }
        });
        
        panel.add(btnVer);
        panel.add(btnEditar);
        panel.add(btnExcluir);
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.currentRow = row;
        return panel;
    }
    
    @Override
    public Object getCellEditorValue() {
        return "";
    }
}
