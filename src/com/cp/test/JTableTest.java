package com.cp.test;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

/**
 * Created by 熊康 on 2017/12/20.
 */
public class JTableTest extends JPanel implements TableCellRenderer {
    JButton sButton;
    JTextField typeField;

    public JTableTest(){
        super();
        setLayout(new BorderLayout());
        sButton = new JButton("...");
        typeField = new JTextField();
        add(sButton);
        add(typeField);
        sButton.setPreferredSize(new Dimension(20,getHeight()));
    }
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if(isSelected){
            setForeground(table.getForeground());
            super.setBackground(table.getBackground());
        }else {
            setForeground(table.getForeground());
            setBackground(table.getBackground());
        }
        if (value != null){
            typeField.setText(value.toString());
            return this;
        }
        return null;
    }
}
