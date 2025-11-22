package Hospital_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Doctor extends JFrame implements ActionListener
{
    JTextField textFieldId, textFieldNumber, textFieldName, textFieldSpeciality;
    JTextField textFieldSalary;

    JRadioButton male, female;
    ButtonGroup genderGroup;

    JButton addButton, backButton;

    Doctor()
    {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 840, 540);
        panel.setBackground(new Color(90, 156, 163));     // Same color as Patient
        panel.setLayout(null);
        add(panel);

//        // Doctor Image (you can change image path later)
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/doctor.png"));
//        Image image = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
//        ImageIcon i2 = new ImageIcon(image);
//        JLabel label = new JLabel(i2);
//        label.setBounds(550, 150, 200, 200);
//        panel.add(label);

        JLabel LabelDoctorForm = new JLabel("New Doctor Form");
        LabelDoctorForm.setBounds(118, 11, 260, 53);
        LabelDoctorForm.setFont(new Font("Tahoma", Font.BOLD, 20));
        LabelDoctorForm.setForeground(Color.white);
        panel.add(LabelDoctorForm);

        // ID
        JLabel labelId = new JLabel("ID");
        labelId.setBounds(35, 76, 200, 14);
        labelId.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelId.setForeground(Color.white);
        panel.add(labelId);

        textFieldId = new JTextField();
        textFieldId.setBounds(271, 73, 150, 20);
        panel.add(textFieldId);

        // Number
        JLabel labelNumber = new JLabel("Number :");
        labelNumber.setBounds(35, 111, 200, 14);
        labelNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelNumber.setForeground(Color.white);
        panel.add(labelNumber);

        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(271, 111, 150, 20);
        panel.add(textFieldNumber);

        // Name
        JLabel labelName = new JLabel("Name :");
        labelName.setBounds(35, 151, 200, 14);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelName.setForeground(Color.white);
        panel.add(labelName);

        textFieldName = new JTextField();
        textFieldName.setBounds(271, 151, 150, 20);
        panel.add(textFieldName);

        // Gender
        JLabel labelGender = new JLabel("Gender :");
        labelGender.setBounds(35, 191, 200, 14);
        labelGender.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelGender.setForeground(Color.white);
        panel.add(labelGender);

        male = new JRadioButton("Male");
        male.setFont(new Font("Tahoma", Font.BOLD, 14));
        male.setForeground(Color.WHITE);
        male.setBackground(new Color(109, 164, 170));
        male.setBounds(271, 191, 80, 15);
        panel.add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Tahoma", Font.BOLD, 14));
        female.setForeground(Color.WHITE);
        female.setBackground(new Color(109, 164, 170));
        female.setBounds(350, 191, 80, 15);
        panel.add(female);

        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        // Speciality
        JLabel labelSpeciality = new JLabel("Speciality :");
        labelSpeciality.setBounds(35, 231, 200, 14);
        labelSpeciality.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelSpeciality.setForeground(Color.white);
        panel.add(labelSpeciality);

        textFieldSpeciality = new JTextField();
        textFieldSpeciality.setBounds(271, 231, 150, 20);
        panel.add(textFieldSpeciality);

        JLabel labelSalary = new JLabel("Salary :");
        labelSalary.setBounds(35, 271, 200, 14);   // aligned below Speciality
        labelSalary.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelSalary.setForeground(Color.white);
        panel.add(labelSalary);

        textFieldSalary = new JTextField();
        textFieldSalary.setBounds(271, 271, 150, 20);   // aligned with other fields
        panel.add(textFieldSalary);

        // Add button
        addButton = new JButton("Add");
        addButton.setBounds(100, 430, 120, 30);
        addButton.setForeground(Color.white);
        addButton.setBackground(Color.BLACK);
        panel.add(addButton);
        addButton.addActionListener(this);

        // Back button
        backButton = new JButton("Back");
        backButton.setBounds(260, 430, 120, 30);
        backButton.setForeground(Color.white);
        backButton.setBackground(Color.BLACK);
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
        if (e.getSource() == addButton)
        {
            SQLConnection c = new SQLConnection();

            String gender = "";
            if (male.isSelected())
            {
                gender = "Male";
            }
            else if (female.isSelected())
            {
                gender = "Female";
            }

            String id = textFieldId.getText();
            String number = textFieldNumber.getText();
            String name = textFieldName.getText();
            String speciality = textFieldSpeciality.getText();
            String salary = textFieldSalary.getText();

            try
            {
                String query = "insert into doctor_info values ('" + id + "', '" + number + "', '" + name + "', '" + gender + "', '" + speciality + "' , '"+salary+"')";
                c.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Doctor Added Successfully");
                setVisible(false);
            }
            catch (Exception E)
            {
                System.out.println("Something is wrong");
            }
        }
        else
        {
            setVisible(false);
        }
    }

    public static void main(String[] args)
    {
        new Doctor();
    }
}
