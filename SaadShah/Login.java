package SaadShah;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener
{
    JTextField UserNameField;
    JPasswordField Passwordfield;

    JButton login , cancel ;

    JLabel UserName = new JLabel("Username");
    JLabel password = new JLabel("Password");

    public Login()
    {
        UserName.setBounds(40 , 20 , 100 , 30);
        UserName.setFont(new Font("Calibri" , Font.BOLD , 20));
        UserName.setForeground(Color.BLACK);
        add(UserName);

        password.setBounds(40 , 80 , 100 , 30);
        password.setFont(new Font("Calibri" , Font.BOLD , 20));
        password.setForeground(Color.BLACK);
        add(password);

        UserNameField = new JTextField();
        UserNameField.setBounds(150,20,150,30);
        UserNameField.setFont(new Font("Calibri" , Font.PLAIN , 15));
        UserNameField.setBackground(new Color(235, 52, 152));
        add(UserNameField);

        Passwordfield = new JPasswordField();
        Passwordfield.setBounds(150,80,150,30);   // <-- CHANGED (y: 70 → 80)
        Passwordfield.setFont(new Font("Calibri" , Font.PLAIN , 15));
        Passwordfield.setBackground(new Color(235, 52, 152));
        add(Passwordfield);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Login.png"));
        Image i = imageIcon.getImage().getScaledInstance(300 ,200 , Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i);
        JLabel imagelabel = new JLabel(imageIcon1);
        imagelabel.setBounds(350 , 50 , 300 , 300);   // <-- CHANGED (better position)
        add(imagelabel);

        login = new JButton("Login");
        login.setBounds(40 , 140 , 120 ,30);
        login.setFont(new Font("serif" , Font.BOLD , 15));
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(180 , 140 , 120 ,30);
        cancel.setFont(new Font("serif" , Font.BOLD , 15));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground( new Color(28 , 138 , 129));
        setSize(900, 400);   // <-- CHANGED (window size 1000×500 → 900×400)
        setLocation(400 , 250);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==login)
        {
            try
            {
                SQLConnection s = new SQLConnection();
                
                String username = UserNameField.getText();
                String password = Passwordfield.getText();

                String query = "select * from login where Id = '" + username+"' and Password = '"+ password+"' ";
                ResultSet result = s.statement.executeQuery(query);

                if(result.next())
                {
                    new Reception();
                    setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null , "Invalid");
                }


            }
            catch (Exception ex)
            {
                throw new RuntimeException(ex);
            }
        }

        else
        {
            System.exit(10);
        }
    }

    public static void main(String[] args)
    {
        new Login();
        new SQLConnection();
    }
}

