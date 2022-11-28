import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DisplayPresenter implements OutputBoundary {
    private final String TITLE = "Mariogatchi";
    private final int START_WIDTH = 400;
    private final int START_HEIGHT = 400;
    private JFrame frame;
    private JPanel startScreen;
    private JPanel loginScreen;
    private JPanel homeScreen;
    private JLabel loginT;
    private JLabel loginErrorT;
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
    private InputControllerLogin icl;
    private Boolean loginScreenB;

    // public static void main(String[] args) {
    //     DisplayPresenter dp = new DisplayPresenter();
        
    // }

    DisplayPresenter(InputControllerLogin inputControllerLogin){
        icl = inputControllerLogin;
        frame = new JFrame(TITLE);
        startScreen = new JPanel();
        loginScreen = new JPanel();
        homeScreen = new JPanel();

        update();
        draw();

        //frame.add(startScreen);
        //frame.add(loginScreen);
        frame.setSize(START_WIDTH, START_HEIGHT);
        //frame.add("Login", loginScreen);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }

    private void draw(){
        JButton loginBtn = new JButton("Login");
        JButton signupBtn = new JButton("Signup");

        loginT = new JLabel("Login to your account");
        JLabel enterUsernameT = new JLabel("Enter Username: ");
        JLabel enterPasswordT = new JLabel("Enter Password: ");
        JTextField usernameF = new JTextField();
        JPasswordField passwordF = new JPasswordField();
        JButton acceptBtn = new JButton("Login");
        loginErrorT = new JLabel();

        JLabel homeT = new JLabel("You successfully logged in");

        startScreen.setBounds(0, 0, START_WIDTH, START_HEIGHT);
        loginScreen.setBounds(0, 0, START_WIDTH, START_HEIGHT);
        homeScreen.setBounds(0, 0, START_WIDTH, START_HEIGHT);

        loginBtn.setBounds(acceptBtnX - acceptBtnW, acceptBtnY - acceptBtnY / 2, acceptBtnW, acceptBtnH);
        signupBtn.setBounds(acceptBtnX, acceptBtnY - acceptBtnY / 2, acceptBtnW, acceptBtnH);
        
        loginT.setBounds(acceptBtnX - acceptBtnW / 2, acceptBtnY - acceptBtnY / 2 - 60, acceptBtnW, 20);
        enterUsernameT.setBounds(20, acceptBtnY - acceptBtnY / 2 - 40, acceptBtnW * 2, 20);
        usernameF.setBounds(acceptBtnX - acceptBtnW / 2, acceptBtnY - acceptBtnY / 2 - 40, acceptBtnW, 20);
        enterPasswordT.setBounds(20, acceptBtnY - acceptBtnY / 2 - 20, acceptBtnW * 2, 20);
        passwordF.setBounds(acceptBtnX - acceptBtnW / 2, acceptBtnY - acceptBtnY / 2 - 20, acceptBtnW, 20);
        acceptBtn.setBounds(acceptBtnX - acceptBtnW / 2, acceptBtnY - acceptBtnY / 2, acceptBtnW, 20);
        loginErrorT.setBounds(acceptBtnX - acceptBtnW / 2, acceptBtnY - acceptBtnY / 2 + 20, acceptBtnW * 2, 20);

        homeT.setBounds(acceptBtnX - acceptBtnW / 2, acceptBtnY - acceptBtnY / 2, acceptBtnW * 2, 20);

        loginBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                loginScreenB = true;
                changeToNewScreen(ScreenNames.LOGIN);
                loginT.setText("Login to your account");
            }
        });

        signupBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                loginScreenB = false;
                changeToNewScreen(ScreenNames.LOGIN);
                loginT.setText("Signup for a account");
            }
        });

        acceptBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String username = usernameF.getText();
                String password = new String(passwordF.getPassword());
                // System.out.println(username + " " + password);
                //output the credentials
                icl.request(loginScreenB ? icl.LOGIN : icl.SIGNUP, List.of(icl.LOGIN, username, password));
            }
        });

        startScreen.add(loginBtn);
        startScreen.add(signupBtn);

        loginScreen.add(loginT);
        loginScreen.add(enterUsernameT);
        loginScreen.add(usernameF);
        loginScreen.add(enterPasswordT);
        loginScreen.add(passwordF);
        loginScreen.add(acceptBtn);
        loginScreen.add(loginErrorT);

        homeScreen.add(homeT);

        frame.add(startScreen);
        frame.add(loginScreen);
        frame.add(homeScreen);

        startScreen.setEnabled(true);
        startScreen.setLayout(null);
        startScreen.setVisible(true);
        loginScreen.setEnabled(true);
        loginScreen.setLayout(null);
        loginScreen.setVisible(true);
        homeScreen.setEnabled(true);
        homeScreen.setLayout(null);
        homeScreen.setVisible(true);
        changeToNewScreen(ScreenNames.START);  
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

    private void changeToNewScreen(ScreenNames screenName){
        // for (Component c : frame.getComponents()) {
        //     c.setVisible(false);
        // }
        startScreen.setVisible(false);
        loginScreen.setVisible(false);
        homeScreen.setVisible(false);
        // homeScreen.setVisible(true);
        switch(screenName){
            case START:
                startScreen.setVisible(true);
            case LOGIN:
                loginScreen.setVisible(true);
            case HOME:
                homeScreen.setVisible(true);
        }
    }

    @Override
    public void updateLoginState(Boolean success, String message) {
        if(success){
            //change to logged in screen
            changeToNewScreen(ScreenNames.HOME);
        }else{
            //Show message for the reason of failure
            changeToNewScreen(ScreenNames.LOGIN);
            loginErrorT.setText(message);
        }
    }

    private enum ScreenNames {
        START, LOGIN, HOME
    }
}
