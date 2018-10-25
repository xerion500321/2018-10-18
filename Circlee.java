import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Circlee extends JFrame {
    private JButton jbn1 = new JButton("開始");
    private JButton jbn2 = new JButton("重新開始");
    private JButton jbn3 = new JButton("EXIT");
    private Container cp;
    private JPanel jpancenter = new JPanel(new GridLayout(3, 3, 3, 3));
    private JPanel jpanright = new JPanel(new GridLayout(3, 1, 3, 3));
    private JButton[][] jbn4 = new JButton[3][3];
    boolean flag = true;
    private Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
    private int screenW = ds.width;
    private int screenH = ds.height;
    private int frmW = 800;
    private int frmH = 600 ;
    public Circlee() {
        initb();
    }

    private void initb() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(screenW/2-frmW/2,screenH/2-frmH/2,800, 600);
        this.cp = this.getContentPane();
        this.cp.setLayout(new BorderLayout(3, 3));
        this.cp.add(this.jpancenter, "Center");
        this.cp.add(this.jpanright, "East");
        this.jpanright.add(this.jbn1);
        jbn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i < 3; i++) {
                    for(int j = 0; j < 3; j++) {
                        jbn4[i][j].setEnabled(true);
                    }
                }

            }
        });
        this.jpanright.add(this.jbn2);
        this.jbn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i < 3; i++) {
                    for(int j = 0; j < 3; j++) {
                        jbn4[i][j].setText("");
                        jbn4[i][j].setEnabled(false);
                        jbn4[i][j].setBackground(new Color(243,226,29));
                    }
                }

            }
        });
        this.jpanright.add(this.jbn3);
        this.jbn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 3; ++j) {
                jbn4[i][j] = new JButton();
                jpancenter.add(jbn4[i][j]);
                jbn4[i][j].setBackground(new Color(243,226,29));
                jbn4[i][j].setFont(new Font(null,Font.BOLD,100));
                jbn4[i][j].setEnabled(false);
                jbn4[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JButton jb = (JButton)e.getSource();
                        if (jb.getText().equals("")) {
                            if (flag) {
                                jb.setText("O");
                                jb.setBackground(new Color(255,255,255));
                            } else {
                                jb.setText("X");
                                jb.setBackground(new Color(255,255,255));
                            }
                            flag = !flag;
                        }
                        outcome();
                    }
                });
            }
        }
    }
    private void outcome(){
        if(jbn4[0][0].getText().equals(jbn4[0][1].getText())&&jbn4[0][1].getText().equals(jbn4[0][2].getText())
                && !jbn4[0][0].getText().equals("")){
            JOptionPane.showMessageDialog(Circlee.this,jbn4[0][0].getText()+"Win");
        }
        if(jbn4[1][0].getText().equals(jbn4[1][1].getText())&&jbn4[1][1].getText().equals(jbn4[1][2].getText())
                && !jbn4[1][0].getText().equals("")){
            JOptionPane.showMessageDialog(Circlee.this,jbn4[1][0].getText()+"Win");
        }
        if(jbn4[2][0].getText().equals(jbn4[2][1].getText())&&jbn4[2][1].getText().equals(jbn4[2][2].getText())
                && !jbn4[2][0].getText().equals("")){
            JOptionPane.showMessageDialog(Circlee.this,jbn4[2][0].getText()+"Win");
        }
        if(jbn4[0][0].getText().equals(jbn4[1][0].getText())&&jbn4[1][0].getText().equals(jbn4[2][0].getText())
                && !jbn4[0][0].getText().equals("")){
            JOptionPane.showMessageDialog(Circlee.this,jbn4[0][0].getText()+"Win");
        }
        if(jbn4[0][1].getText().equals(jbn4[1][1].getText())&&jbn4[1][1].getText().equals(jbn4[2][1].getText())
                && !jbn4[0][1].getText().equals("")){
            JOptionPane.showMessageDialog(Circlee.this,jbn4[0][1].getText()+"Win");
        }
        if(jbn4[0][2].getText().equals(jbn4[1][2].getText())&&jbn4[1][2].getText().equals(jbn4[2][2].getText())
                && !jbn4[0][2].getText().equals("")){
            JOptionPane.showMessageDialog(Circlee.this,jbn4[0][2].getText()+"Win");
        }
        if(jbn4[0][0].getText().equals(jbn4[1][1].getText())&&jbn4[1][1].getText().equals(jbn4[2][2].getText())
                && !jbn4[0][0].getText().equals("")){
            JOptionPane.showMessageDialog(Circlee.this,jbn4[0][0].getText()+"Win");
        }
        if(jbn4[0][2].getText().equals(jbn4[1][1].getText())&&jbn4[1][1].getText().equals(jbn4[2][0].getText())
                && !jbn4[0][2].getText().equals("")){
            JOptionPane.showMessageDialog(Circlee.this,jbn4[0][2].getText()+"Win");
        }


    }
}
