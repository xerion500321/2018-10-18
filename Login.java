import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int screenW = screenSize.width;
    private int screenH = screenSize.height;
    private int frmW = 600,frmH=200;
    private JPanel jpanCenter = new JPanel(new GridLayout(2, 2, 1, 1));
    private JPanel jpanSouth = new JPanel(new GridLayout(1, 3, 3, 3));
    private JLabel jlb = new JLabel("ID:", JLabel.RIGHT);
    private JLabel jlb2 = new JLabel("PW:", JLabel.RIGHT);
    private JTextField jtx = new JTextField();
    private JPasswordField jpx = new JPasswordField();
    private JButton jbtn1 = new JButton("Keyboard");
    private JButton jbtn2 = new JButton("Login");
    private JButton jbtn3 = new JButton("Exit");
    private Container cp;
    public Login() {
        initt();
    }
    private void initt() {
        this.setBounds(screenW/2-frmW/2,screenH/2-frmH/2, 600, 200);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.cp = this.getContentPane();
        this.cp.setLayout(new BorderLayout(3, 3));
        this.cp.add(this.jpanCenter, "Center");
        this.cp.add(this.jpanSouth, "South");
        jpanCenter.add(jlb);
        jpanCenter.add(jtx);
        jpanCenter.add(jlb2);
        jpanCenter.add(jpx);
        jpanSouth.add(jbtn1);
        jpanSouth.add(jbtn2);
        jpanSouth.add(jbtn3);
        jtx.setFont(new Font(null,Font.BOLD,25));
        jpx.setFont(new Font(null,Font.BOLD,25));
        jlb.setFont(new Font(null, Font.BOLD, 25));
        jlb2.setFont(new Font(null, Font.BOLD, 25));
        jbtn1.setFont(new Font(null, Font.BOLD, 25));
        jbtn2.setFont(new Font(null, Font.BOLD, 25));
        jbtn3.setFont(new Font(null, Font.BOLD, 25));
        jbtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Keyboard ky = new Keyboard(Login.this);
                ky.setVisible(true);
            }
        });
        jbtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jtx.getText().equals("h304")&&(new String(jpx.getPassword()).equals("23323456"))) {
                    Menu me = new Menu();
                    me.setVisible(true);
                    Login.this.dispose();
                }
            }
        });
       jbtn3.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               JButton jbtn1 = (JButton) e.getSource();
               if (jbtn1.getText() == "Exit") {
               System.exit(0);
               }
           }
       });
       }
    public void setpw(String ln){
        jpx.setText(ln);
    }
}