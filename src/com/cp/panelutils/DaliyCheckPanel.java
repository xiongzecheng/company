package com.cp.panelutils;

import com.cp.DAO.StaffDAO;
import com.cp.factory.StaffDAOFactory;
import com.cp.model.Check;
import com.cp.model.Staff;
import com.cp.utils.DialogDatePicker;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.JAXBPermission;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.SplittableRandom;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;

/**
 * Created by 熊康 on 2017/12/21.
 * 每日考勤面板
 */
public class DaliyCheckPanel extends JPanel implements ActionListener {
    private JScrollPane scrollPane;
    private JTable table;
    private DefaultTableModel dtm;
    private DefaultTableCellRenderer renderer,renderer1;
    private java.util.List<Staff> daliychecks;
    private Iterator<Staff> iterater = null;
    private JPanel datePanel;
    private JPanel checkPanel;
    private JComboBox jComboBox;
    private JButton dateButton;
    private JLabel dateLabel;
    private JButton checkButton;
    private JTextField txtDate;
    private String dateString;
    private StaffDAO staffDAO = StaffDAOFactory.getCheckDAOInstance();

    public DaliyCheckPanel(){
        setBackground(Color.LIGHT_GRAY);
        setLayout(new BorderLayout());

        scrollPane = new JScrollPane();
        table = new JTable();
        dtm = new DefaultTableModel();
        txtDate = new JTextField();
        jComboBox = new JComboBox();
        renderer = new DefaultTableCellRenderer();
        renderer1 = new DefaultTableCellRenderer();
        dateLabel = new JLabel();
        checkButton = new JButton("确认考勤");
        checkButton.addActionListener(this);
        datePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        checkPanel= new JPanel(new FlowLayout(FlowLayout.RIGHT));
        dateButton = new JButton("选择日期");
        dateButton.addActionListener(this);

        datePanel.add(dateButton);
        datePanel.add(dateLabel);
        scrollPane.add(table);
        checkPanel.add(checkButton);
        add(scrollPane,CENTER);
        add(datePanel,BorderLayout.NORTH);
        add(checkPanel,BorderLayout.SOUTH);
        scrollPane.setViewportView(table);

        init();
    }
    private void init(){
        daliycheckPanel();
        //状态下拉框
        jComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                 JComboBox jb=new JComboBox();
                jb.addItem("正常");
                jb.addItem("迟到");
                jb.addItem("早退");
                jb.addItem("请假");
                jb.addItemListener(this);
                if(e.getStateChange()== ItemEvent.DESELECTED){
                    String type = (String) jb.getSelectedItem();
                }
            }
        });

        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void daliycheckPanel() {
        dtm = new DefaultTableModel();
        String[] titles ={"工号","姓名","状态"};
        dtm.setColumnIdentifiers(titles);
        table.setModel(dtm);
        renderer.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class,renderer);
        renderer1.setHorizontalAlignment(JLabel.CENTER);
        renderer.setBackground(Color.LIGHT_GRAY);
        table.getTableHeader().setDefaultRenderer(renderer1);
        String[] content = new String[3];
        try {
            daliychecks = staffDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        iterater = daliychecks.iterator();
//        while (iterater.hasNext()){
//            Staff staff = iterater.next();
//            content[0] = staff.getStaffNumber();
//            content[1] = staff.getStaffName();
//            dtm.addRow(content);
//        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dateButton){
            new DialogDatePicker(true, txtDate, 500, 100);
            //获得日期
            dateString = txtDate.getText();
            dateLabel.setText(dateString);
        }
        if (e.getSource() == checkButton){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;
            try {
                date = sdf.parse(dateString);
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
            java.sql.Date checkDate = new java.sql.Date(date.getTime());
        }
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("测试");
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
        frame.add(new DaliyCheckPanel());
        frame.setVisible(true);
    }
}
