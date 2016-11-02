package GUI;

import Classifier.SVM.Classifier;
import Classifier.SVM.Train;
import liblinear.Linear;
import main.RevisedMain;
import preprocess.csv.CSVPreProcess;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.io.*;
import java.nio.Buffer;


public class FilNeG extends JFrame {

    private JPanel filnegPane;
    private JButton earthquakeButton;
    private JTextArea news;
    private JTextArea svmAccu;
    private JButton button1;
    private JButton typhoonButton;
    private JButton floodButton;
    private JLabel header;
    private JScrollPane newsScrollPane;
    public int earthquakeGenerated=0,typhoonGenerated=0, floodGenerated=0;

    public FilNeG() {

        setContentPane(filnegPane);
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        pack();
        setVisible(true);

        //COUNT GENERATED TEMPLATES
        //earthquake
        File[] earthquakeFiles2=new File("EarthquakeNewsReport").listFiles(pathname -> pathname.getName().endsWith(".txt"));
        for(File textFile:earthquakeFiles2){
            try {
                BufferedReader b= new BufferedReader(new FileReader(textFile));
                if(b.readLine()!=null){
                    earthquakeGenerated++;
                }
            } catch(Exception e){

            }
        }
        //typhoon
        File[] typhoonFiles2=new File("TyphoonNewsReport").listFiles(pathname -> pathname.getName().endsWith(".txt"));
        for(File textFile:typhoonFiles2){
            try {
                BufferedReader b= new BufferedReader(new FileReader(textFile));
                if(b.readLine()!=null){
                    typhoonGenerated++;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //flood
        File[] floodFiles2=new File("FloodNewsReport").listFiles(pathname -> pathname.getName().endsWith(".txt"));
        for(File textFile:floodFiles2){
            try {
                BufferedReader b= new BufferedReader(new FileReader(textFile));
                if(b.readLine()!=null){
                    floodGenerated++;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        //SVM ACCURACY OF CLASSIFICATION
        try {

            Classifier classifier=new Classifier();
            Linear acc=new Linear();
            CSVPreProcess counter=new CSVPreProcess();
           // svmAccu.append("\n"+train.trainTime+"\n");
           // svmAccu.append(train.testTime+"\n");
            svmAccu.append("\n"+classifier.inst+"\n");
            svmAccu.append(acc.accuracy);
            svmAccu.append("\n"+"Tweets Per Category:"+"\n====================");
            svmAccu.append("\nTyphoon: "+counter.counterTyphoon);
            svmAccu.append("\nEarthquake: "+counter.counterEarthquake);
            svmAccu.append("\nFlood: "+counter.counterFlood);
            svmAccu.append("\n\n"+"Templates Generated:"+"\n====================");
            svmAccu.append("\nTyphoon: "+typhoonGenerated);
            svmAccu.append("\nEarthquake: "+ earthquakeGenerated);
            svmAccu.append("\nFlood: "+floodGenerated);
            svmAccu.setEditable(false);
        }
        catch(Exception except){
            except.printStackTrace();
        }
        //NEWS TEXT AREA, DEFAULT EARTHQUAKE
        news.setText("");
        File[] earthquakeFiles=new File("EarthquakeNewsReport").listFiles();

        //set header
        try {
            header.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("EarthquakeHeader.jpg"))));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //end of set header
        for(File textFile:earthquakeFiles){
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(textFile), "UTF8"));

                String line="";

                while((line=bufferedReader.readLine())!=null){
                    news.append("" + line + "\n\n");
                }
                bufferedReader.close();

            } catch (Exception exception) {
                exception.printStackTrace();
            }

        }
        //Earthquake Button
        earthquakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                news.setText(" ");
                //set header
                try {
                    header.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("EarthquakeHeader.jpg"))));
                } catch (IOException a) {
                    a.printStackTrace();
                }
                //end of set header
                File[] earthquakeFiles=new File("EarthquakeNewsReport").listFiles();
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
                //set header
                try {
                    header.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("TyphoonHeader.jpg"))));
                } catch (IOException a) {
                    a.printStackTrace();
                }
                //end of set header
                File[] typhoonFiles=new File("TyphoonNewsReport").listFiles();
                for(File textFile:typhoonFiles){
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new FileReader(textFile));

                        String line =" ";
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
                //set header
                try {
                    header.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("FloodHeader.jpg"))));
                } catch (IOException a) {
                    a.printStackTrace();
                }
                //end of set header
                File[] floodFiles=new File("FloodNewsReport").listFiles();
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
        filNeG.setVisible(true);
    }


}
