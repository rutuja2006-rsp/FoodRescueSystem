package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import dao.NotificationDAO;

public class ViewNotification extends JFrame 
        implements ActionListener {


    JTable table;

    DefaultTableModel model;


    JButton markReadBtn, backBtn;


    String userType;

    int userId;


    public ViewNotification(
            String userType,
            int userId) {


        this.userType = userType;

        this.userId = userId;


        setTitle("Notifications");


        setSize(700, 450);


        setLayout(new BorderLayout());


        setLocationRelativeTo(null);


        setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );


        model = new DefaultTableModel();


        model.addColumn("ID");

        model.addColumn("Message");

        model.addColumn("Status");

        model.addColumn("Date");


        loadNotifications();


        table = new JTable(model);


        add(
            new JScrollPane(table),
            BorderLayout.CENTER
        );


        JPanel panel = new JPanel();


        markReadBtn = new JButton(
                "Mark as Read"
        );


        backBtn = new JButton(
                "Back"
        );


        panel.add(markReadBtn);

        panel.add(backBtn);


        add(panel, BorderLayout.SOUTH);


        markReadBtn.addActionListener(this);

        backBtn.addActionListener(this);


        setVisible(true);

    }


    public void loadNotifications() {


        model.setRowCount(0);

        NotificationDAO dao =
                new NotificationDAO();

        ResultSet rs;

        if(userType.equals("ADMIN")) {

            rs = dao.getAllNotifications();

        }
        else {

            rs = dao.getNotifications(
                    userType,
                    userId
            );

        }

        try {


            while(rs.next()) {


                model.addRow(
                    new Object[] {


                    rs.getInt(
                    "notification_id"),


                    rs.getString(
                    "message"),


                    rs.getString(
                    "status"),


                    rs.getTimestamp(
                    "created_at")


                    }

                );

            }


        }
        catch(Exception e) {


            e.printStackTrace();


        }

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {


        // Mark Notification as Read
        if (e.getSource() == markReadBtn) {


            int row = table.getSelectedRow();


            if (row == -1) {


                JOptionPane.showMessageDialog(
                        this,
                        "Please select a notification!"
                );


                return;

            }


            int notificationId =
                    (int) model.getValueAt(row, 0);


            NotificationDAO dao =
                    new NotificationDAO();


            boolean result =
                    dao.markAsRead(notificationId);


            if (result) {


                JOptionPane.showMessageDialog(
                        this,
                        "Notification marked as READ!"
                );


                // Refresh table
                loadNotifications();


            }
            else {


                JOptionPane.showMessageDialog(
                        this,
                        "Failed to update notification!"
                );

            }

        }


        // Back Button
        else if (e.getSource() == backBtn) {


            dispose();

        }

    }
}
   