import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;


public class LoggingPage implements ActionListener {


    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("userID");
    JLabel userPasswordLabel = new JLabel("password");
    JLabel messageLabel = new JLabel("");

    HashMap<String, String> logging = new HashMap<String, String>();



    LoggingPage(HashMap<String, String> loggingOriginal){

            logging = loggingOriginal;

            userIDLabel.setBounds(50,100,75,25);
            userPasswordLabel.setBounds(50,150,75,25);

              messageLabel.setBounds(125,250,250,35);
              messageLabel.setFont(new Font(null, Font.ITALIC, 25));

             userIDField.setBounds(125,100,200,25);
             userPasswordField.setBounds(125,150,200,25);

             loginButton.setBounds(125,200,100,25);
             loginButton.setFocusable(false);
             loginButton.addActionListener(this);

             resetButton.setBounds(225,200,100,25);
             resetButton.setFocusable(false);
             resetButton.addActionListener(this);


        frame.add(userIDLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,450);
        frame.setLayout(null);
        frame.setVisible(true);

        }

        @Override
        public void actionPerformed (ActionEvent e){

            if(e.getSource()==resetButton){
                userIDField.setText("");
                userPasswordField.setText("");

            }
            if(e.getSource()==loginButton){

                String userID = userIDField.getText();
                String passWord = String.valueOf(userPasswordField.getPassword());

                if(logging.containsKey(userID))
                {

                    if(logging.get(userID).equals(passWord))
                    {
                        messageLabel.setForeground(Color.green);
                        messageLabel.setText("Logging successful");
                        WelcomePage welcome = new WelcomePage(userID);
                        frame.dispose();
                    }else {
                        messageLabel.setForeground(Color.red);
                        messageLabel.setText("Incorrect Password");
                    }
                }
                else {
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("Username Not Found");
                }
            }
        }
    }

