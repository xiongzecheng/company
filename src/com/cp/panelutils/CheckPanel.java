package com.cp.panelutils;

import com.cp.DAO.CheckDAO;
import com.cp.factory.CheckDAOFactory;
import com.cp.factory.ServiceFactory;
import com.cp.model.Check;
import com.cp.service.AdminService;
import com.cp.utils.RounderPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Iterator;

import static java.awt.BorderLayout.*;

/**
 * Created by 熊康 on 2017/12/20.
 * 主管查看全部考勤信息
 */
public class CheckPanel extends JPanel {
    private JScrollPane scrollPane;
    private JTable table;
    private DefaultTableModel dtm;
    private DefaultTableCellRenderer renderer,renderer1;
    private java.util.List<Check> checks;
    Iterator<Check> iterater = null;
    private AdminService adminService = ServiceFactory.getAdminServiceInstance();


    public CheckPanel(){
        super();
        setBackground(Color.LIGHT_GRAY);
        setLayout(new BorderLayout());


        table = new JTable();
        scrollPane = new JScrollPane();
        renderer = new DefaultTableCellRenderer();
        renderer1 = new DefaultTableCellRenderer();
        scrollPane.setViewportView(table);

        init();
        add(scrollPane, CENTER);
    }

    private void init(){
        checkTable();
//       scrollPane.add(table);
    }

    private void checkTable() {
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
            checks = adminService.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        iterater = checks.iterator();
        while (iterater.hasNext()){
            Check check = iterater.next();
            content[0] = String.valueOf(check.getId());
            content[1] = check.getStaffNumber();
            content[2] = check.getCheckType();
            content[3] = check.getCheckDate().toString();
            dtm.addRow(content);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("测试");
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
        frame.add(new CheckPanel());
        frame.setVisible(true);
    }
}
