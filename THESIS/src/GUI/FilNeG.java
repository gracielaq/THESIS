package GUI;

import Classifier.SVM.Classifier;
import Classifier.SVM.Train;
import liblinear.Linear;
import main.RevisedMain;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.io.*;

/**
 * Created by gracielaquiambao on 10/12/16.
 */
public class FilNeG extends JFrame {

    private JPanel filnegPane;
    private JButton earthquakeButton;
    private JTextArea news;
    private JTextArea svmAccu;
    private JButton button1;
    private JButton typhoonButton;
    private JButton floodButton;


    public FilNeG() {

        setContentPane(filnegPane);
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        pack();
        setVisible(true);



        //SVM ACCURACY OF CLASSIFICATION
        try {
            Train train=new Train();
            Classifier classifier=new Classifier();
            Linear acc=new Linear();
            RevisedMain r= new RevisedMain();
           // svmAccu.append("\n"+train.trainTime+"\n");
           // svmAccu.append(train.testTime+"\n");
            svmAccu.append("\n"+classifier.inst+"\n");
            svmAccu.append(acc.accuracy);
            svmAccu.append("\n"+"Tweets Per Category:"+"\n======================");
            svmAccu.append("Typhoon: "+r.counterTyphoon);


        }
        catch(Exception except){
            except.printStackTrace();
        }
        //NEWS TEXT AREA, DEFAULT EARTHQUAKE

        File[] earthquakeFiles=new File("EarthquakeNewsReport").listFiles();
        news.append("\nNEWS: EARTHQUAKE" + "\n =======================");
        for(File textFile:earthquakeFiles){
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(textFile));

                String line ="";
                String exampleOut="";
                while((line=bufferedReader.readLine())!=null){

                    news.append("\n"+line+"\n");
                    exampleOut+=line+"\n";

                }
                bufferedReader.close();
                System.out.println(exampleOut);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        //Earthquake Button
        earthquakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                news.setText("");
                File[] earthquakeFiles=new File("EarthquakeNewsReport").listFiles();
                news.append("\nNEWS: EARTHQUAKE" + "\n =======================");
                for(File textFile:earthquakeFiles){
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new FileReader(textFile));

                        String line ="";
                        while((line=bufferedReader.readLine())!=null){

                            news.append("\n"+line+"\n");
                        }
                        bufferedReader.close();

                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            }
        });

        //Typhoon Button
        typhoonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                news.setText("");
                File[] typhoonFiles=new File("TyphoonNewsReport").listFiles();
                news.append("\nNEWS: TYPHOON" + "\n ====================");
                for(File textFile:typhoonFiles){
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new FileReader(textFile));

                        String line ="";
                        while((line=bufferedReader.readLine())!=null){

                            news.append("\n"+line+"\n");
                        }
                        bufferedReader.close();

                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            }
        });

        //FLOOD BUTTON
        floodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                news.setText("");
                File[] floodFiles=new File("FloodNewsReport").listFiles();
                news.append("\nNEWS: FLOOD" + "\n ========================");
                for(File textFile:floodFiles){
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new FileReader(textFile));

                        String line ="";
                        while((line=bufferedReader.readLine())!=null){

                            news.append("\n"+line+"\n");
                        }
                        bufferedReader.close();

                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            }
        });

        //Back button

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*JFileChooser chooser = new JFileChooser();
                // optionally set chooser options ...
                if (chooser.showOpenDialog(button1) == JFileChooser.APPROVE_OPTION) {
                    File f = chooser.getSelectedFile();
                    // read  and/or display the file somehow. ....
                    if(f!=null){
                        dispose();
                        RevisedMain rm= new RevisedMain();
                        rm.getFile(f);
                        new RevisedMain();

                        String[] arguments = new String[] {"123"};
                        RevisedMain.main(arguments);

                        //Reload FilneG Pane
                        filnegPane.setVisible(true);


                    }



                } else {
                    // user changed their mind
                }*/
                FilNeG.this.setVisible(false);
                Main main=new Main();
                main.setVisible(true);
            }
        });
        news.addComponentListener(new ComponentAdapter() {
        });
    }

    public static void main(String[] args) {
        FilNeG filNeG = new FilNeG();
        /*try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                System.out.println(info.getName());
                if ("Metal".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        filNeG.setVisible(true);
    }

}
