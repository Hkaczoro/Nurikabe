import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class OdczytIZapis {

    private String nazwaZapisywanego;

    public String getNazwaCzytanego() {
        return nazwaCzytanego;
    }

    public void setNazwaCzytanego(String nazwaCzytanego) {
        this.nazwaCzytanego = nazwaCzytanego;
    }

    private String nazwaCzytanego;

    private int poziomTrudnosci;

    public int getPoziomTrudnosci() {
        return poziomTrudnosci;
    }

    public void setPoziomTrudnosci(int poziomTrudności) {
        this.poziomTrudnosci = poziomTrudności;
    }

    public int getNumerPlanszy() {
        return numerPlanszy;
    }

    public void setNumerPlanszy(int numerPlanszy) {
        this.numerPlanszy = numerPlanszy;
    }

    private int numerPlanszy;

    private int[][] ukladPlanszy;

    public int[][] getUkladPlanszy() {
        return ukladPlanszy;
    }

    public void setUkladPlanszy(int[][] ukladPlanszy) {
        this.ukladPlanszy = ukladPlanszy;
    }

    public void write(int[][] uklad, int poziomTrudnosci, int numerPlanszy){
        int a = 0;
        if (poziomTrudnosci == 1){
            a = 5;
        }
        else if (poziomTrudnosci == 2){
            a = 7;
        }
        else if (poziomTrudnosci == 3){
            a = 10;
        }
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new File(nazwaZapisywanego));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder builder = new StringBuilder();
        builder.append(poziomTrudnosci);
        builder.append(";");
        builder.append(numerPlanszy);
        builder.append(";");
        for(int i = 0; i < a - 2; i++){
            builder.append(0);
            builder.append(";");
        }
        builder.append("\n");
        for (int i = 0; i < a; i++){
            for (int x = 0; x < a; x++){
                builder.append(uklad[i][x]);
                builder.append(";");
            }
            builder.append("\n");
        }
        pw.write(builder.toString());
        pw.close();

    }

    public String getNazwaZapisywanego() {
        return nazwaZapisywanego;
    }

    public void setNazwaZapisywanego(String nazwaZapisywanego) {
        this.nazwaZapisywanego = nazwaZapisywanego;
    }

    public void czytaj(String nazwaCzytanego) throws FileNotFoundException {
        //Path pathToFile = Paths.get(nazwaCzytanego);
        //Scanner sc = new Scanner(new File(nazwaCzytanego));
        
        BufferedReader br = new BufferedReader(new FileReader(nazwaCzytanego));
        try{
            String line = br.readLine();
            while (line != null){
                String[] linia = line.split(";");
                this.poziomTrudnosci = Integer.valueOf(linia[0]);
                this.numerPlanszy = Integer.valueOf(linia[1]);


                int a = 0;
                if (poziomTrudnosci == 1){
                    a = 5;
                    this.ukladPlanszy = new int[5][5];
                }
                else if (poziomTrudnosci == 2){
                    a = 7;
                    this.ukladPlanszy = new int[7][7];
                }
                else if (poziomTrudnosci == 3){
                    a = 10;
                    this.ukladPlanszy = new int[10][10];
                }

                line = br.readLine();
                for(int i = 0; i < a; i++){
                    linia = line.split(";");
                    for(int x = 0; x < a; x++){
                        ukladPlanszy[i][x] = Integer.valueOf(linia[x]);
                        System.out.println(ukladPlanszy[i][x]);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
