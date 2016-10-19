package GUI;

import main.RevisedMain;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;

/**
 * Created by gracielaquiambao on 10/11/16.
 */
public class Main extends JFrame{
    //private JButton openFile;
    private JPanel panelMain;
    private JButton openFileButton;

    public Main() {

        super("FILNEG");

        setContentPane(panelMain);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);

        //Open File Button
        openFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("COMMA SEPARATED VALUES", "csv", "CSV");
                chooser.setFileFilter(filter);
                // optionally set chooser options ...
                if (chooser.showOpenDialog(openFileButton) == JFileChooser.APPROVE_OPTION) {
                    File f = chooser.getSelectedFile();
                    // read  and/or display the file somehow. ....
                    if(f!=null){
                        dispose();
                        RevisedMain rm= new RevisedMain();
                        rm.getFile(f);
                        new RevisedMain();

                        String[] arguments = new String[] {"123"};
                        RevisedMain.main(arguments);

                        //Open FilneG Pane
                        panelMain.setVisible(false);
                        FilNeG fn=new FilNeG();
                        fn.setVisible(true);
                    }



                } else {
                    // user changed their mind
                }
            }
        });
    }

    public static void main(String[] args) {
        /*try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                //System.out.println(info.getName());
                if ("Metal".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        Main main = new Main();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
