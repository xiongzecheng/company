package com.cp.panelutils;

import com.cp.DAO.CheckDAO;
import com.cp.factory.CheckDAOFactory;
import com.cp.model.Check;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Iterator;

import static java.awt.BorderLayout.CENTER;

/**
 * Created by 熊康 on 2017/12/21.
 * 个人查看考勤信息
 */
public class OwnCheckPanel extends JPanel implements ActionListener {
    private JScrollPane scrollPane;
    private JPanel buttonPanel;
    private JButton refreshButton;
    private JTable table;
    private DefaultTableModel dtm;
    private DefaultTableCellRenderer renderer,renderer1;
    private java.util.List<Check> ownchecks;
    Iterator<Check> iterater = null;
    private CheckDAO checkDAO = CheckDAOFactory.getCheckDAOInstance();

    public OwnCheckPanel(){
        setBackground(Color.LIGHT_GRAY);
        setLayout(new BorderLayout());

        table = new JTable();
        scrollPane = new JScrollPane();
        renderer = new DefaultTableCellRenderer();
        renderer1 = new DefaultTableCellRenderer();
        scrollPane.setViewportView(table);
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        refreshButton = new JButton("刷新");
        refreshButton.addActionListener(this);
        buttonPanel.add(refreshButton);
        add(buttonPanel,BorderLayout.SOUTH);
        init();
        add(scrollPane, CENTER);


    }

    private void init(){
        owncheckTable();

    }

    private void owncheckTable() {
        dtm = new DefaultTableModel();
        String[] titles = {"编号","工号","状态","日期"};
        dtm.setColumnIdentifiers(titles);
        table.setModel(dtm);
        renderer.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class,renderer);
        renderer1.setHorizontalAlignment(JLabel.CENTER);
        renderer.setBackground(Color.LIGHT_GRAY);
        table.getTableHeader().setDefaultRenderer(renderer1);
        String[] content = new String[4];
        try {
            ownchecks = checkDAO.getCheck("20012");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        iterater = ownchecks.iterator();
        while (iterater.hasNext()){
            Check check = iterater.next();
            content[0] = String.valueOf(check.getId());
            content[1] = check.getStaffNumber();
            content[2] = check.getCheckType();
            content[3] = check.getCheckDate().toString();
            dtm.addRow(content);
        }
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==refreshButton){
            owncheckTable();
            table.revalidate();
            scrollPane.revalidate();
        }
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("测试");
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
        frame.add(new OwnCheckPanel());
        frame.setVisible(true);
    }
}
