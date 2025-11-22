package Hospital_Management_System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Doctor_Info extends JFrame
{
    JTable table = new JTable();

    Doctor_Info()
    {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 900, 590);
        panel.setBackground(new Color(90, 156, 163));  // Same color as other panels
        panel.setLayout(null);
        add(panel);

        table.setBounds(10, 40, 880, 450);
        table.setBackground(new Color(90, 156, 163));
        table.setFont(new Font("Tahoma", Font.BOLD, 12));
        panel.add(table);

        try
        {
            SQLConnection c = new SQLConnection();
            String query = "SELECT * FROM Doctor_info";
            ResultSet resultSet = c.statement.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        // Column Labels
        JLabel label1 = new JLabel("ID");
        label1.setBounds(31, 11, 80, 14);
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label1);

        JLabel label2 = new JLabel("Number");
        label2.setBounds(130, 11, 80, 14);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label2);

        JLabel label3 = new JLabel("Name");
        label3.setBounds(240, 11, 80, 14);
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label3);

        JLabel label4 = new JLabel("Gender");
        label4.setBounds(360, 11, 80, 14);
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label4);

        JLabel label5 = new JLabel("Speciality");
        label5.setBounds(480, 11, 100, 14);
        label5.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label5);

        JLabel label6 = new JLabel("Salary");
        label6.setBounds(610, 11, 100, 14);
        label6.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label6);

        JButton button = new JButton("BACK");
        button.setBounds(450, 510, 120, 30);
        button.setBackground(Color.black);
        button.setForeground(Color.white);
        panel.add(button);
        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(900, 600);
        setLayout(null);
        setLocation(300, 200);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new Doctor_Info();
    }
}
