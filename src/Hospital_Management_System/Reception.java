package Hospital_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame
{
    JPanel panel = new JPanel();
    JPanel panel1 = new JPanel();

    Reception()
    {
        panel.setLayout(null);
        panel.setBounds(5, 160 , 1525 ,670);
        panel.setBackground(new Color(109 , 164 , 170));
        add(panel);

        panel1.setLayout(null);
        panel1.setBounds(5, 5,1525 ,150);
        panel1.setBackground(new Color(109 , 164 , 170));
        add(panel1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/dr.png"));
        Image image = i1.getImage().getScaledInstance(250 , 250 ,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(image);
        JLabel label = new JLabel(i2);
        label.setBounds(1300 , 0 ,250 ,250);
        panel1.add(label);

        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icon/amb.png"));
        Image image1 = i3.getImage().getScaledInstance(300 , 100 ,Image.SCALE_DEFAULT);
        ImageIcon i4 = new ImageIcon(image1);
        JLabel label1 = new JLabel(i4);
        label1.setBounds(1000 , 50 ,300 ,100);
        panel1.add(label1);

        JButton button1 = new JButton("Add New Patient");
        button1.setBounds(30 ,15 , 200 ,30);
        button1.setBackground(new Color(246 , 215 , 118));
        panel1.add(button1);
        button1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new Patient();
            }
        });

        JButton button2 = new JButton("Add New Doctor");
        button2.setBounds(30 ,58 , 200 ,30);
        button2.setBackground(new Color(246 , 215 , 118));
        panel1.add(button2);
        button2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new Doctor();
            }
        });

        JButton button3 = new JButton("Department");
        button3.setBounds(30 ,100 , 200 ,30);
        button3.setBackground(new Color(246 , 215 , 118));
        panel1.add(button3);
        button3.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });

        JButton button4 = new JButton("Doctor info");
        button4.setBounds(270 ,15 , 200 ,30);
        button4.setBackground(new Color(246 , 215 , 118));
        panel1.add(button4);
        button4.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new Doctor_Info();
            }
        });

        JButton button5 = new JButton("Patient info");
        button5.setBounds(270 ,58 , 200 ,30);
        button5.setBackground(new Color(246 , 215 , 118));
        panel1.add(button5);
        button5.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new Patient_Info();
            }
        });

        JButton button6 = new JButton("Patient Discharge");
        button6.setBounds(270 ,100 , 200 ,30);
        button6.setBackground(new Color(246 , 215 , 118));
        panel1.add(button6);
        button6.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });

        JButton button7 = new JButton("Update patient detail");
        button7.setBounds(510 ,15 , 200 ,30);
        button7.setBackground(new Color(246 , 215 , 118));
        panel1.add(button7);
        button7.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });

        JButton button8 = new JButton("Remove Doctor");
        button8.setBounds(510 ,58 , 200 ,30);
        button8.setBackground(new Color(246 , 215 , 118));
        panel1.add(button8);
        button8.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new RemoveDoctor();
            }
        });

        JButton button9 = new JButton("Search Room");
        button9.setBounds(510 ,100 , 200 ,30);
        button9.setBackground(new Color(246 , 215 , 118));
        panel1.add(button9);
        button9.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });

        setSize(1950 ,1100);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args)
    {
        new Reception();
    }
}
