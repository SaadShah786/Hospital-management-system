package Hospital_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveDoctor extends JFrame implements ActionListener
{
    JTextField textFieldId;
    JButton removeButton, backButton;

    RemoveDoctor()
    {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 840, 540);
        panel.setBackground(new Color(90, 156, 163));  // Same color as other panels
        panel.setLayout(null);
        add(panel);

        JLabel labelTitle = new JLabel("Remove Doctor");
        labelTitle.setBounds(280, 50, 300, 50);
        labelTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
        labelTitle.setForeground(Color.white);
        panel.add(labelTitle);

        JLabel labelId = new JLabel("Enter Doctor ID:");
        labelId.setBounds(150, 150, 200, 30);
        labelId.setFont(new Font("Tahoma", Font.BOLD, 16));
        labelId.setForeground(Color.white);
        panel.add(labelId);

        textFieldId = new JTextField();
        textFieldId.setBounds(350, 150, 200, 30);
        panel.add(textFieldId);

        removeButton = new JButton("Remove");
        removeButton.setBounds(200, 250, 120, 30);
        removeButton.setBackground(Color.BLACK);
        removeButton.setForeground(Color.white);
        panel.add(removeButton);
        removeButton.addActionListener(this);

        backButton = new JButton("Back");
        backButton.setBounds(360, 250, 120, 30);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.white);
        panel.add(backButton);
        backButton.addActionListener(this);

        setSize(850, 550);
        setLayout(null);
        setLocation(300, 250);
        setVisible(true);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == removeButton)
        {
            String id = textFieldId.getText();

            if(id.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please enter Doctor ID");
                return;
            }

            try
            {
                SQLConnection c = new SQLConnection();
                String query = "DELETE FROM Doctor_info WHERE Id='" + id + "'";
                int result = c.statement.executeUpdate(query);

                if(result > 0)
                {
                    JOptionPane.showMessageDialog(null, "Doctor removed successfully");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "No doctor found with this ID");
                }

                setVisible(false);
            }
            catch(Exception ex)
            {
                System.out.println("Something went wrong");
            }
        }
        else if(e.getSource() == backButton)
        {
            setVisible(false);
        }
    }

    public static void main(String[] args)
    {
        new RemoveDoctor();
    }
}
