import com.sun.org.apache.bcel.internal.generic.Select;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Encrypt extends JFrame {
    private JTextArea jta = new JTextArea();
    private JTextArea jta2 = new JTextArea();
    private JScrollPane jsp1 = new JScrollPane(jta);
    private JScrollPane jsp2 = new JScrollPane(jta2);
    private JTextField jtx = new JTextField();
    private JLabel jlb1 = new JLabel("Method");
    private JLabel jlb2 = new JLabel("Password");
    private JButton jbtn1 = new JButton("Clear");
    private JButton jbtn2 = new JButton("Run");
    private JButton jbtn3 = new JButton("Close");
    private String[] str = {"DES", "AES", "CAESA", "XOR"};
    private JComboBox jbx = new JComboBox(str);
    private JRadioButton jrb = new JRadioButton("Encrypt");
    private JRadioButton jrb2 = new JRadioButton("Decrypt");
    private ButtonGroup bg = new ButtonGroup();
    private Container cp;
    private JPanel jpanCenter = new JPanel(new GridLayout(9, 1, 3, 3));
    private JPanel jpanEast = new JPanel(new GridLayout(1, 1, 3, 3));
    private JPanel jpanWest = new JPanel(new GridLayout(1, 1, 3, 3));
    private JFileChooser jc = new JFileChooser();
    private Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
    private int screenW = ds.width;
    private int screenH = ds.height;
    private int frmW = 600;
    private int frmH = 600 ;
    private JMenu jmu = new JMenu("File");
    private JMenu jmu2 = new JMenu("About");
    private JMenuItem jmI1 = new JMenuItem("Open");
    private JMenuItem jmI2 = new JMenuItem("Save");
    private JMenuItem jmI3 = new JMenuItem("Exit");
    private JMenuBar jmb = new JMenuBar();
    public Encrypt() {
        inita();
    }

    private void inita() {
        setBounds(screenW/2-frmW/2,screenH/2-frmH/2, 600, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setJMenuBar(jmb);
        this.jmb.add(jmu);
        this.jmb.add(jmu2);
        this.jmu.add(jmI1);
        this.jmu.add(jmI2);
        this.jmu.add(jmI3);
        this.cp = this.getContentPane();
        this.cp.setLayout(new BorderLayout(3, 3));
        this.cp.add(this.jpanCenter, "Center");
        this.cp.add(this.jpanEast, "East");
        this.cp.add(this.jpanWest, "West");
        this.jpanWest.add(jsp1);
        this.jpanEast.add(jsp2);
        this.jpanCenter.add(jlb1);
        this.jpanCenter.add(jbx);
        this.jpanCenter.add(jlb2);
        this.jpanCenter.add(jtx);
        this.bg.add(jrb);
        this.bg.add(jrb2);
        this.jpanCenter.add(jrb);
        this.jpanCenter.add(jrb2);
        this.jpanCenter.add(jbtn1);
        this.jpanCenter.add(jbtn2);
        this.jpanCenter.add(jbtn3);
        this.jpanWest.setPreferredSize(new Dimension(220, 600));
        this.jpanEast.setPreferredSize(new Dimension(220, 600));
        jmI1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (jc.showOpenDialog(Encrypt.this) == JFileChooser.APPROVE_OPTION) {
                        jta.setText("");
                        String str = "" ;
                        File selectFile = jc.getSelectedFile();
                        FileReader fr = new FileReader(selectFile);
                        BufferedReader bfw = new BufferedReader(fr);
                        while ((str = bfw.readLine()) != null) {
                            jta.setText(str);
                        }
                        fr.close();
                    }
                }catch (IOException a){
                    JOptionPane.showMessageDialog(Encrypt.this,"File is not found!");
                }
            }
        });
        jmI2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(jta2.getText().length()>0){
                        jc.setFileFilter(new FileNameExtensionFilter(".txt .doc","txt","doc"));
                        if(jc.showSaveDialog(Encrypt.this)==JFileChooser.APPROVE_OPTION){
                            File selectFile = new File(jc.getSelectedFile().getPath()+jc.getSelectedFile().getName()+".txt");
                            FileWriter fw = new FileWriter(selectFile);
                            BufferedWriter bfw = new BufferedWriter(fw);
                            bfw.write(jta2.getText());
                            bfw.close();
                        }
                        else {
                            JOptionPane.showMessageDialog(Encrypt.this,"NO data can save!");
                        }
                    }
                }catch (IOException b){
                    JOptionPane.showMessageDialog(Encrypt.this,"NO data can save!");
                }
            }
        });
        jbtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jta.setText("");
                jta2.setText("");
            }
        });
        jbtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jrb.isSelected()){
                    int datalength = jta.getText().length();
                    if(datalength>0){
                        switch (jbx.getSelectedIndex()){
                            case 0:
                                JOptionPane.showMessageDialog(Encrypt.this,"Sorry,"+jbx.getSelectedItem()+"is not implement yet!");
                                break;
                            case 1:
                                JOptionPane.showMessageDialog(Encrypt.this,"Sorry,"+jbx.getSelectedItem()+"is not implement yet!");
                                break;
                            case 2:
                                char[] data = jta.getText().toCharArray();
                                int a = Integer.parseInt(jtx.getText());
                                try{
                                    for(int i=0 ; i<data.length ; i++){
                                        data[i] = (char)(data[i]+a);
                                    }
                                    jta2.setText(new String(data));
                                }
                                catch (NumberFormatException nfe){
                                    JOptionPane.showMessageDialog(Encrypt.this,"Key is not number");
                                }
                                catch (Exception ep){
                                    JOptionPane.showMessageDialog(Encrypt.this,"Error"+ep.toString());
                                }
                                break;
                            case 3:
                                char[] date = jta.getText().toCharArray();
                                char[] key = jtx.getText().toCharArray();
                                for(int i=0 ; i<date.length ; i++){
                                    date[i] = (char)((int)date[i]^(int)key[i%key.length]);
                                }
                                jta2.setText(new String(date));
                                break;
                        }
                    }
                }
                else if(jrb2.isSelected()){
                    switch (jbx.getSelectedIndex()){
                        case 0:
                            JOptionPane.showMessageDialog(Encrypt.this,"Sorry,"+jbx.getSelectedItem()+"is not implement yet!");
                            break;
                        case 1:
                            JOptionPane.showMessageDialog(Encrypt.this,"Sorry,"+jbx.getSelectedItem()+"is not implement yet!");
                            break;
                        case 2:
                            int a =Integer.parseInt(jtx.getText());
                            int datalength = jta2.getText().length();
                            char[] data = jta2.getText().toCharArray();
                            for(int i=0 ; i<datalength ; i++){
                                data[i] = (char)(data[i] - a);
                                }
                                jta.setText(new String(data));
                            break;
                    }
                }
            }
        });
        jbtn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
