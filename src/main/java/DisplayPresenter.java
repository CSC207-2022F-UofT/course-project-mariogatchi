import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DisplayPresenter implements OutputBoundary {
    private final int START_WIDTH = 400;
    private final int START_HEIGHT = 400;
    private JFrame frame;
    private JPanel startScreen;
    private JPanel loginScreen;
    // private int usernameFX;
    // private int usernameFY;
    // private int usernameFW;
    // private int usernameFH;
    // private int usernameLX;
    // private int usernameLY;
    // private int usernameLW;
    // private int usernameLH;
    private int acceptBtnX;
    private int acceptBtnY;
    private int acceptBtnW;
    private int acceptBtnH;
    // private Boolean loginScreenB = false;
    private CardLayout crd;
    private Container con;

    public static void main(String[] args) {
        DisplayPresenter dp = new DisplayPresenter();
        dp.draw();
    }

    DisplayPresenter(){
        frame = new JFrame();
        con = new Container();
        crd = new CardLayout();
        startScreen = new JPanel();
        loginScreen = new JPanel();

        con.setLayout(crd);
        frame.add(con);
        frame.setSize(START_WIDTH, START_HEIGHT);
        //frame.add("Login", loginScreen);
        frame.setLayout(crd);
        frame.setVisible(true);
        update();
    }

    private void draw(){
        

        JButton loginBtn = new JButton("Login");
        JButton signupBtn = new JButton("Signup");

        JLabel loginT = new JLabel("Login to your account");
        JLabel enterUsernameT = new JLabel("Enter Username: ");
        JLabel enterPasswordT = new JLabel("Enter Password: ");
        JTextField usernameF = new JTextField();
        JPasswordField passwordF = new JPasswordField();
        JButton acceptBtn = new JButton("Login");

        loginBtn.setBounds(acceptBtnX - acceptBtnW, acceptBtnY - acceptBtnY / 2, acceptBtnW, acceptBtnH);
        signupBtn.setBounds(acceptBtnX, acceptBtnY - acceptBtnY / 2, acceptBtnW, acceptBtnH);
        
        loginT.setBounds(acceptBtnX - acceptBtnW / 2, acceptBtnY - acceptBtnY / 2 - 60, acceptBtnW, 20);
        usernameF.setBounds(acceptBtnX - acceptBtnW / 2, acceptBtnY - acceptBtnY / 2 - 40, acceptBtnW, 20);
        passwordF.setBounds(acceptBtnX - acceptBtnW / 2, acceptBtnY - acceptBtnY / 2 - 20, acceptBtnW, 20);
        acceptBtn.setBounds(acceptBtnX - acceptBtnW / 2, acceptBtnY - acceptBtnY / 2, acceptBtnW, 20);

        loginBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                // loginScreenB = true;
                changeToNewScreen("Login");
            }
        });

        signupBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                // loginScreenB = false;
                changeToNewScreen("Login");
            }
        });

        acceptBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String username = usernameF.getText();
                String password = new String(passwordF.getPassword());
                System.out.println(username + " " + password);
                //output the credentials
                //{command.login, username, password};
            }
        });

        startScreen.add(loginBtn);
        startScreen.add(signupBtn);

        loginScreen.add(loginT);
        loginScreen.add(usernameF);
        loginScreen.add(passwordF);
        loginScreen.add(acceptBtn);
        
        con.add(ScreenNames.START.name(), startScreen);
        con.add(ScreenNames.LOGIN.name(), loginScreen);
        crd.show(con, ScreenNames.START.name());
        // crd.show(frame, "Login");

        /*
        con.setLayout(crd);
        con.add(loginBtn);
        */        
        /*
        startScreen.setEnabled(true);
        startScreen.setLayout(null);
        startScreen.setVisible(true);
        loginScreen.setEnabled(true);
        loginScreen.setLayout(null);
        loginScreen.setVisible(true);*/
    }

    private void update(){
        // usernameFX = frame.WIDTH;
        // usernameFY = frame.HEIGHT;
        /*usernameFW = ;
        usernameFH = ;
        usernameLX = ;
        usernameLY = ;
        usernameLW = ;
        usernameLH = ;*/
        acceptBtnX = frame.getWidth() / 2;
        acceptBtnY = frame.getHeight() / 2;
        acceptBtnW = (int) (100 + frame.getWidth() * 0.1);
        acceptBtnH = (int) (60 + frame.getHeight() * 0.1);
    }

    private void changeToNewScreen(String screenName){
        crd.show(con, screenName);
    }

    @Override
    public void updateLoginState(Boolean success, String message) {
        if(success){
            //change to logged in screen
            
        }else{
            //Show message for the reason of failure
        }
    }

    private enum ScreenNames {
        START, LOGIN
    }
}
