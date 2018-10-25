import javax.swing.*;
import java.awt.*;

public class EncryptFile extends JFrame {
private JLabel jlb1 = new JLabel("加密法");
private JLabel jlb2 = new JLabel("原始檔");
private JLabel jlb3 = new JLabel("加密檔");
private JLabel jlb4 = new JLabel("Key");
private JButton jbtn1 = new JButton("Run");
private JButton jbtn2 = new JButton("Close");
private JButton jbtn3 = new JButton("Choose");
private JButton jbtn4 = new JButton("Choose");
private JTextField jtx1 = new JTextField();
private JTextField jtx2 = new JTextField();
private JTextField jtx3 = new JTextField();
private String str[] = {"CAESA", "AES", "DES", "XOR"};
private JComboBox jcb = new JComboBox(str);
private Container cp;
private JPanel jpanNorth = new JPanel(new GridLayout(1,6,3,3));
private JPanel jpanCenter = new JPanel(new GridLayout(2,3,3,3));
private JPanel jpanSouth = new JPanel(new GridLayout(1,1,3,3));
private int frmW = 600;
private int frmH = 200;
private Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
private int ScreenW = ds.width;
private int ScreenH = ds.height;
private JProgressBar jpb = new JProgressBar();
private JFileChooser jfc = new JFileChooser();
    public EncryptFile(){
    initc();
}
   private void initc(){
        this.setBounds(ScreenW/2-frmW/2,ScreenH/2-frmH/2,600,200);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.cp = this.getContentPane();
        this.cp.setLayout(new BorderLayout(3,3));
        this.cp.add(this.jpanNorth,"North");
        this.cp.add(this.jpanCenter,"Center");
        this.cp.add(this.jpanSouth,"South");
        this.jpanNorth.add(jlb1);
        this.jpanNorth.add(jcb);
        this.jpanNorth.add(jlb4);
        this.jpanNorth.add(jtx1);
        this.jpanNorth.add(jbtn1);
        this.jpanNorth.add(jbtn2);
        this.jpanCenter.add(jlb2);
        this.jpanCenter.add(jtx2);
        this.jpanCenter.add(jbtn3);
        this.jpanCenter.add(jlb3);
        this.jpanCenter.add(jtx3);
        this.jpanCenter.add(jbtn4);
        this.jpanSouth.add(jpb);
        this.jpb.setForeground(Color.orange);
        this.jpb.setBackground(Color.yellow);
 }
}


