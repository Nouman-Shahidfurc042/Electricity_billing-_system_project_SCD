//package electricity.billing.system2;
//
//import javax.swing.*;
//import javax.swing.border.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.sql.*;
//
//public class Signup extends JFrame implements ActionListener{
//
//    JButton create, back;
//    Choice accountType;
//    JTextField meter, username, name, password;
//    Signup(){
//        
//        setBounds(450, 150, 700, 400);
//        getContentPane().setBackground(Color.WHITE);
//        setLayout(null);
//        
//        JPanel panel = new JPanel();
//        panel.setBounds(30, 30, 650, 300);
//        panel.setBorder(new TitledBorder(new LineBorder(new Color(173, 216, 230), 2), "Create-Account", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(172, 216, 230)));
//        panel.setBackground(Color.WHITE);
//        panel.setLayout(null);
//        panel.setForeground(new Color(34, 139, 34));
//        add(panel);
//        
//        JLabel heading = new JLabel("Create Account As");
//        heading.setBounds(100, 50, 140, 20);
//        heading.setForeground(Color.GRAY);
//        heading.setFont(new Font("Tahoma", Font.BOLD, 14));
//        panel.add(heading);
//        
//        accountType = new Choice();
//        accountType.add("Admin");
//        accountType.add("Customer");
//        accountType.setBounds(260, 50, 150, 20);
//        panel.add(accountType);
//        
//        JLabel lblmeter = new JLabel("Meter Number");
//        lblmeter.setBounds(100, 90, 140, 20);
//        lblmeter.setForeground(Color.GRAY);
//        lblmeter.setFont(new Font("Tahoma", Font.BOLD, 14));
//        lblmeter.setVisible(false);
//        panel.add(lblmeter);
//        
//        meter = new JTextField();
//        meter.setBounds(260, 90, 150, 20);
//        meter.setVisible(false);
//        panel.add(meter);
//        
//        JLabel lblusername = new JLabel("Username");
//        lblusername.setBounds(100, 130, 140, 20);
//        lblusername.setForeground(Color.GRAY);
//        lblusername.setFont(new Font("Tahoma", Font.BOLD, 14));
//        panel.add(lblusername);
//        
//        username = new JTextField();
//        username.setBounds(260, 130, 150, 20);
//        panel.add(username);
//        
//        JLabel lblname = new JLabel("Name");
//        lblname.setBounds(100, 170, 140, 20);
//        lblname.setForeground(Color.GRAY);
//        lblname.setFont(new Font("Tahoma", Font.BOLD, 14));
//        panel.add(lblname);
//        
//        name = new JTextField();
//        name.setBounds(260, 170, 150, 20);
//        panel.add(name);
//        
//        meter.addFocusListener(new FocusListener() {
//            @Override
//            public void focusGained(FocusEvent fe) {}
//            
//            @Override
//            public void focusLost(FocusEvent fe) {
//                try {
//                    Conn c  = new Conn();
//                    ResultSet rs = c.s.executeQuery("select * from login where meter_no = '"+meter.getText()+"'");
//                    while(rs.next()) {
//                        name.setText(rs.getString("name"));
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        
//        
//        JLabel lblpassword = new JLabel("Password");
//        lblpassword.setBounds(100, 210, 140, 20);
//        lblpassword.setForeground(Color.GRAY);
//        lblpassword.setFont(new Font("Tahoma", Font.BOLD, 14));
//        panel.add(lblpassword);
//        
//        password = new JTextField();
//        password.setBounds(260, 210, 150, 20);
//        panel.add(password);
//        
//        accountType.addItemListener(new ItemListener() {
//            public void itemStateChanged(ItemEvent ae) {
//                String user = accountType.getSelectedItem();
//                if (user.equals("Customer")) {
//                    lblmeter.setVisible(true);
//                    meter.setVisible(true);
//                    name.setEditable(false);
//                } else {
//                    lblmeter.setVisible(false);
//                    meter.setVisible(false);
//                    name.setEditable(true);
//                }
//            }
//        });
//        
//        create = new JButton("Create");
//        create.setBackground(Color.BLACK);
//        create.setForeground(Color.WHITE);
//        create.setBounds(140, 260, 120, 25);
//        create.addActionListener(this);
//        panel.add(create);
//
//        back = new JButton("Back");
//        back.setBackground(Color.BLACK);
//        back.setForeground(Color.WHITE);
//        back.setBounds(300, 260, 120, 25);
//        back.addActionListener(this);
//        panel.add(back);
//        
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/boy.png"));
//        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel image = new JLabel(i3);
//        image.setBounds(415, 30, 250, 250);
//        panel.add(image);
//        
//        setVisible(true);
//    }
//    
//    public void actionPerformed(ActionEvent ae) {
//        if (ae.getSource() == create) {
//            String atype = accountType.getSelectedItem();
//            String susername = username.getText();
//            String sname = name.getText();
//            String spassword = password.getText();
//            String smeter = meter.getText();
//           
//            try {
//                Conn c = new Conn();
//                
//                String query = null;
//                if (atype.equals("Admin")) {
//                    query = "insert into login values('"+smeter+"', '"+susername+"', '"+sname+"', '"+spassword+"', '"+atype+"')";
//                } else {
//                    query = "update login set username = '"+susername+"', password = '"+spassword+"', user = '"+atype+"' where meter_no = '"+smeter+"'";
//                }
//                c.s.executeUpdate(query);
//                
//                JOptionPane.showMessageDialog(null, "Account Created Successfully");
//                
//                setVisible(false);
//                new Login();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } else if (ae.getSource() == back) {
//            setVisible(false);
//            
//            new Login();
//        }
//    }
//
//    public static void main(String[] args) {
//        new Signup();
//    }
//}
//
//
//
//
//

//code # 2
package electricity.billing.system2;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Signup extends JFrame implements ActionListener {

    JButton create, back;
    Choice accountType;
    JTextField meter, username, name;
    JPasswordField password;
    JLabel usernameWarning, nameWarning, passwordWarning;
      JCheckBox showPasswordCheckbox;  // Replace eye icon with a JCheckBox
    boolean passwordVisible = false;


    Signup() {

        setBounds(450, 150, 700, 400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(30, 30, 650, 300);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(173, 216, 230), 2), "Create-Account", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(172, 216, 230)));
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setForeground(new Color(34, 139, 34));
        add(panel);
        
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/boy.png"));
       Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(415, 30, 250, 250);
        panel.add(image);

        JLabel heading = new JLabel("Create Account As");
        heading.setBounds(100, 50, 140, 20);
        heading.setForeground(Color.GRAY);
        heading.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(heading);

        accountType = new Choice();
        accountType.add("Admin");
        accountType.add("Customer");
        accountType.setBounds(260, 50, 150, 20);
        panel.add(accountType);

        JLabel lblmeter = new JLabel("Meter Number");
        lblmeter.setBounds(100, 90, 140, 20);
        lblmeter.setForeground(Color.GRAY);
        lblmeter.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblmeter.setVisible(false);
        panel.add(lblmeter);

        meter = new JTextField();
        meter.setBounds(260, 90, 150, 20);
        meter.setVisible(false);
        panel.add(meter);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(100, 130, 140, 20);
        lblusername.setForeground(Color.GRAY);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lblusername);

        username = new JTextField();
        username.setBounds(260, 130, 150, 20);
        panel.add(username);

        usernameWarning = new JLabel("Username must be 3-25 characters.");
        usernameWarning.setBounds(260, 155, 250, 15);
        usernameWarning.setForeground(Color.RED);
        usernameWarning.setFont(new Font("Tahoma", Font.PLAIN, 10));
        usernameWarning.setVisible(false);
        panel.add(usernameWarning);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(100, 170, 140, 20);
        lblname.setForeground(Color.GRAY);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lblname);

        name = new JTextField();
        name.setBounds(260, 170, 150, 20);
        panel.add(name);

        nameWarning = new JLabel("Name cannot be empty.");
        nameWarning.setBounds(260, 195, 250, 15);
        nameWarning.setForeground(Color.RED);
        nameWarning.setFont(new Font("Tahoma", Font.PLAIN, 10));
        nameWarning.setVisible(false);
        panel.add(nameWarning);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(100, 210, 140, 20);
        lblpassword.setForeground(Color.GRAY);
        lblpassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lblpassword);

        password = new JPasswordField();
        password.setBounds(260, 210, 150, 20);
        panel.add(password);

        passwordWarning = new JLabel("Password must be 8+ characters with 1 upper, 1 lower, 1 digit, 1 special.");
        passwordWarning.setBounds(260, 235, 400, 15);
        passwordWarning.setForeground(Color.RED);
        passwordWarning.setFont(new Font("Tahoma", Font.PLAIN, 10));
        passwordWarning.setVisible(false);
        panel.add(passwordWarning);
        
              // Show password checkbox
        showPasswordCheckbox = new JCheckBox("Show Password");
        showPasswordCheckbox.setBounds(420, 210, 150, 20);  // Position of the checkbox
        showPasswordCheckbox.setBackground(Color.WHITE);
        showPasswordCheckbox.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(showPasswordCheckbox);
        

        create = new JButton("Create");
        create.setBackground(Color.BLACK);
        create.setForeground(Color.WHITE);
        create.setBounds(140, 260, 120, 25);
        create.addActionListener(this);
        panel.add(create);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(300, 260, 120, 25);
        back.addActionListener(this);
        panel.add(back);
        
     
        

        accountType.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ae) {
                String user = accountType.getSelectedItem();
                if (user.equals("Customer")) {
                    lblmeter.setVisible(true);
                    meter.setVisible(true);
                    name.setEditable(false);
                } else {
                    lblmeter.setVisible(false);
                    meter.setVisible(false);
                    name.setEditable(true);
                }
            }
        });
        
        

        // Add real-time validation
        addValidation();

              // Checkbox listener to toggle password visibility
        showPasswordCheckbox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (showPasswordCheckbox.isSelected()) {
                    password.setEchoChar((char) 0);  // Show password
                } else {
                    password.setEchoChar('*');  // Hide password
                }
            }
        });
        
        
        setVisible(true);
    }
    
    
    

    private void addValidation() {
        // Real-time validation for username
        username.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                validateUsername();
            }

            public void removeUpdate(DocumentEvent e) {
                validateUsername();
            }

            public void changedUpdate(DocumentEvent e) {
                validateUsername();
            }
        });

        // Real-time validation for name
        name.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                validateName();
            }

            public void removeUpdate(DocumentEvent e) {
                validateName();
            }

            public void changedUpdate(DocumentEvent e) {
                validateName();
            }
        });

        // Real-time validation for password
        password.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                validatePassword();
            }

            public void removeUpdate(DocumentEvent e) {
                validatePassword();
            }

            public void changedUpdate(DocumentEvent e) {
                validatePassword();
            }
        });
    }

    private void validateUsername() {
        String susername = username.getText();
        if (susername.length() < 3 || susername.length() > 25) {
            usernameWarning.setVisible(true);
        } else {
            usernameWarning.setVisible(false);
        }
    }

    private void validateName() {
        String sname = name.getText();
        if (sname.isEmpty()) {
            nameWarning.setVisible(true);
        } else {
            nameWarning.setVisible(false);
        }
    }

    private void validatePassword() {
        String spassword = new String(password.getPassword());
        if (!spassword.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$")) {
            passwordWarning.setVisible(true);
        } else {
            passwordWarning.setVisible(false);
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == create) {
            validateUsername();
            validateName();
            validatePassword();

            if (!usernameWarning.isVisible() && !nameWarning.isVisible() && !passwordWarning.isVisible()) {
                try {
                    Conn c = new Conn();
                    String atype = accountType.getSelectedItem();
                    String smeter = meter.getText();
                    String susername = username.getText();
                    String sname = name.getText();
                    String spassword = new String(password.getPassword());

                    String query = null;
                    if (atype.equals("Admin")) {
                        query = "insert into login values('" + smeter + "', '" + susername + "', '" + sname + "', '" + spassword + "', '" + atype + "')";
                    } else {
                        query = "update login set username = '" + susername + "', password = '" + spassword + "', user = '" + atype + "' where meter_no = '" + smeter + "'";
                    }
                    c.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Account Created Successfully");
                    setVisible(false);
                    new Login();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please fix the errors before proceeding.");
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}




