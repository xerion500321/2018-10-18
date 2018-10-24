import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private JMenuItem jmeI1 = new JMenuItem("Open");
    private JMenuItem jmeI2 = new JMenuItem("Close");
    private JMenuItem jmeI3 = new JMenuItem("Exit");
    private JMenuItem jmeI4 = new JMenuItem("Circle");
    private JMenuItem jmeI5 = new JMenuItem("Encrypt");
    private JMenuItem jmeI6 = new JMenuItem("EncryptFile");
    private JMenu jme1 = new JMenu("File");
    private JMenu jme2 = new JMenu("Set");
    private JMenu jme3 = new JMenu("Game");
    private JMenu jme4 = new JMenu("Tool");
    private JMenuBar jmb = new JMenuBar();
    private Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
    private int screenW = ds.width;
    private int screenH = ds.height;
    private int frmW = 600;
    private int frmH = 600 ;
    public Menu(){
        inittt();
    }
    private void inittt(){
    setBounds(screenW/2-frmW/2,screenH/2-frmH/2,600,600);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.setJMenuBar(jmb);
    jmb.add(jme1);
    jmb.add(jme2);
    jmb.add(jme3);
    jmb.add(jme4);
    jme1.add(jmeI1);
    jme1.add(jmeI2);
    jme1.add(jmeI3);
    jme3.add(jmeI4);
    jme4.add(jmeI5);
    jme4.add(jmeI6);
    jmeI4.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Menu.this.dispose();
            Circlee cir = new Circlee();
            cir.setVisible(true);
        }
    });
    jmeI3.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    });
    jmeI5.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Encrypt eny = new Encrypt();
            eny.setVisible(true);
            Menu.this.dispose();
        }
    });
    jmeI6.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            EncryptFile enyf = new EncryptFile();
            enyf.setVisible(true);
            Menu.this.dispose();
        }
    });
    }
}
