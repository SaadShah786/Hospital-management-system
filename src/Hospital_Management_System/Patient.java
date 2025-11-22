package Hospital_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Patient extends JFrame implements ActionListener
{
    JComboBox comboBox;
    JTextField textFieldId , textFieldNumber , textFieldName , textFieldDisease , textFieldDeposite;

    JRadioButton male , female;
    Choice c1;

    JLabel date;

    JButton addButton , backButton;

    Patient()
    {
        JPanel panel = new JPanel();
        panel.setBounds(5 ,5 , 840 , 540);
        panel.setBackground(new Color(90 , 156 , 163));
        panel.setLayout(null);
        add(panel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/patient.png"));
        Image image = i1.getImage().getScaledInstance(200 , 200 , Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(image);
        JLabel label = new JLabel(i2);
        label.setBounds(550 , 150 , 200 ,200);
        panel.add(label);

        JLabel LabelPatientForm = new JLabel("New Patient Form");
        LabelPatientForm.setBounds(118 , 11 , 260 ,53);
        LabelPatientForm.setFont(new Font("Tahoma" , Font.BOLD , 20));
        panel.add(LabelPatientForm);

        JLabel labelId = new JLabel("ID");
        labelId.setBounds(35 , 76 , 200 ,14);
        labelId.setFont(new Font("Tahoma" , Font.BOLD , 14));
        labelId.setForeground(Color.white);
        panel.add(labelId);
        textFieldId = new JTextField();
        textFieldId.setBounds(271 , 73 , 150 ,20);
        panel.add(textFieldId);

        JLabel labelNumber = new JLabel("Number :");
        labelNumber.setBounds(35 , 111 , 200 ,14);
        labelNumber.setFont(new Font("Tahoma" , Font.BOLD , 14));
        labelNumber.setForeground(Color.white);
        panel.add(labelNumber);
        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(271 , 111 , 150 , 20);
        panel.add(textFieldNumber);

        JLabel labelName = new JLabel("Name :");
        labelName.setBounds(35 , 151 , 200 ,14);
        labelName.setFont(new Font("Tahoma" , Font.BOLD , 14));
        labelName.setForeground(Color.white);
        panel.add(labelName);
        textFieldName = new JTextField();
        textFieldName.setBounds(271 , 151 , 150 , 20);
        panel.add(textFieldName);

        JLabel labelGender = new JLabel("Gender :");
        labelGender.setBounds(35 , 191 , 200 ,14);
        labelGender.setFont(new Font("Tahoma" , Font.BOLD , 14));
        labelGender.setForeground(Color.white);
        panel.add(labelGender);

        male = new JRadioButton("Male");
        male.setFont(new Font("Tahoma" , Font.BOLD , 14));
        male.setForeground(Color.WHITE);
        male.setBackground(new Color(109 , 164 , 170));
        male.setBounds(271 , 191 ,80 ,15);
        panel.add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Tahoma" , Font.BOLD , 14));
        female.setForeground(Color.WHITE);
        female.setBackground(new Color(109 , 164 , 170));
        female.setBounds(350 , 191 ,80 ,15);
        panel.add(female);

        JLabel labelDisease = new JLabel("Disease :");
        labelDisease.setBounds(35 , 231 , 200 ,14);
        labelDisease.setFont(new Font("Tahoma" , Font.BOLD , 14));
        labelDisease.setForeground(Color.white);
        panel.add(labelDisease);
        textFieldDisease = new JTextField();
        textFieldDisease.setBounds(271 , 231 , 150 , 20);
        panel.add(textFieldDisease);

        JLabel labelRoom = new JLabel("Room :");
        labelRoom.setBounds(35 , 274 , 200 ,14);
        labelRoom.setFont(new Font("Tahoma" , Font.BOLD , 14));
        labelRoom.setForeground(Color.white);
        panel.add(labelRoom);

        // Room choice //

        JLabel labelDate = new JLabel("Time :");
        labelDate.setBounds(35 , 316 , 200 ,14);
        labelDate.setFont(new Font("Tahoma" , Font.BOLD , 14));
        labelDate.setForeground(Color.white);
        panel.add(labelDate);

        Date Date1 = new Date();

        date = new JLabel("" + Date1);
        date.setBounds(271 , 316 ,250 ,14);
        date.setForeground(Color.white);
        date.setFont(new Font("Tahoma" , Font.BOLD , 14));
        panel.add(date);

        JLabel labelDeposite = new JLabel("Deposite :");
        labelDeposite.setBounds(35 , 359 , 200 ,14);
        labelDeposite.setFont(new Font("Tahoma" , Font.BOLD , 14));
        labelDeposite.setForeground(Color.white);
        panel.add(labelDeposite);
        textFieldDeposite = new JTextField();
        textFieldDeposite.setBounds(271 , 359 , 150 ,20);
        panel.add(textFieldDeposite);

        addButton = new JButton("Add");
        addButton.setBounds(100 ,430 , 120 ,30);
        addButton.setForeground(Color.white);
        addButton.setBackground(Color.BLACK);
        panel.add(addButton);
        addButton.addActionListener(this);

        backButton = new JButton("Back");
        backButton.setBounds(260 ,430 , 120 ,30);
        backButton.setForeground(Color.white);
        backButton.setBackground(Color.BLACK);
        panel.add(backButton);
        backButton.addActionListener(this);

        // setUndecorated(true);
        setSize(850 , 550);
        setLayout(null);
        setLocation(300 ,250);
        setVisible(true);
        // setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==addButton)
        {
            SQLConnection c = new SQLConnection();

            String radiobutton = "";

            if(male.isSelected())
            {
                radiobutton = "Male";
            }
            else if(female.isSelected())
            {
                radiobutton = "Female";
            }

            String id = textFieldId.getText();
            String number = textFieldNumber.getText();
            String name = textFieldName.getText();
            String gender = radiobutton;
            String disease = textFieldDisease.getText();
            String dates = date.getText();
            String deposite = textFieldDeposite.getText();

            try
            {
                String query = "insert into patient_info values ('"+id+"' , '"+number+"' , '"+name+"' , '"+gender+"' , '"+disease+"' , '"+dates+"' , '"+deposite+"')";
                c.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null , "Added Successfully");
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
        new Patient();
    }


}
