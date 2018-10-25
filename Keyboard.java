import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Keyboard extends JFrame {
    private JPasswordField jpx = new JPasswordField();
    private JButton jbtn[] = new JButton[12];
    private String[] stra = new String[10];
    private Container cp;
    private JPanel jpannorth = new JPanel(new GridLayout(1,1,3,3));
    private JPanel jpancenter = new JPanel(new GridLayout(4, 3, 3, 3));
    private Login ln;
    public Keyboard(Login ln1) {
        ln = ln1;
        init();
    }
    private void init() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(500, 100, 350, 400);
        this.cp = this.getContentPane();
        this.cp.setLayout(new BorderLayout(3, 3));
        this.cp.add(this.jpancenter,"Center");
        this.cp.add(this.jpannorth,"North");
        this.jpannorth.add(jpx);
        jpx.setFont(new Font(null,Font.BOLD,36));
        strss(stra);
        for (int i=0 ; i<10 ; i++){
            jbtn[i] = new JButton(stra[i]);
            jbtn[i].setFont(new Font(null,Font.BOLD,18));
            this.jpancenter.add(jbtn[i]);
            jbtn[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton jbtn2 = (JButton) e.getSource();
                    jpx.setText(jpx.getText()+jbtn2.getText());
                }
            });
        }
        jbtn[10] = new JButton("Submit");
        jbtn[11] = new JButton("Reflash");
        jpancenter.add(jbtn[10]);
        jpancenter.add(jbtn[11]);
        jbtn[10].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            ln.setpw(new String(jpx.getText()));
            Keyboard.this.dispose();
                }
        });
        jbtn[11].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                strss(stra);
                for(int i=0 ; i<10 ; i++){
                    jbtn[i].setText(stra[i]);
                }
            }
        });
    }
    private void strss(String str[]){
        int i=0;
        Random ran = new Random(System.currentTimeMillis());
        while (i<10){
            stra[i] = Integer.toString(ran.nextInt(10));
            int j=0;
            boolean flag = false;
            while (j<i){
                if(stra[i].equals(stra[j])){
                    flag = true;
                    j=i;
                }
                j++;
            }
            if(!flag){
                i++;
            }
        }
    }
}