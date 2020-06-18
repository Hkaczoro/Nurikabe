import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Klasa z metodami do odczytu i zapisu pliku z układem planszy
 */
public class OdczytIZapis {
    /**
     * Pole z nazwą pliku, który będzie zapisany przez użytkownika
     */
    private String nazwaZapisywanego;
    /**
     * Poziom Trudnosci planszy zapisywanej lub odczytywanej z pliku
     */
    private int poziomTrudnosci;
    /**
     * Pole z numere planszy
     */
    private int numerPlanszy;
    /**
     * Tablica dwuwymiarowa reprezentująca układ w danym pliku
     */
    private int[][] ukladPlanszy;

    /**
     * Metoda do zwracania poziomu trudności
     * @return 1, 2, 3 - poziom trudności (1 - łatwy, 2 - średni, 3 - trudny)
     */
    public int getPoziomTrudnosci() {
        return poziomTrudnosci;
    }

    /**
     * Metoda do zwracania numeru planszy
     * @return liczbę reprezentującą dany układ planszy
     */
    public int getNumerPlanszy() {
        return numerPlanszy;
    }

    /**
     * Meotda do zwracania tablicy dwuwymiarowej (rozkład planszy)
     * @return
     */
    public int[][] getUkladPlanszy() {
        return ukladPlanszy;
    }

    /**
     * Metoda do ustawiania nazwy pliku do zapisania podaną przez użytkownika
     * @param nazwaZapisywanego nazwa pliku podanan przez użytkownika
     */
    public void setNazwaZapisywanego(String nazwaZapisywanego) {
        this.nazwaZapisywanego = nazwaZapisywanego;
    }

    /**
     * Metoda do zapisywania tablicy(planszy) do pliku typu csv
     * @param uklad tablica dwuwymiarowa reprezentująca planszę
     * @param poziomTrudnosci poziom trudności planszy
     * @param numerPlanszy numer danej planszy
     */
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

    /**
     * Metoda do wczytywania planszy z pliku podanego przez użytkownika
     * @param nazwaCzytanego ścieżka do pliku do wczytania
     * @throws FileNotFoundException niepoprawna ścieżka do pliku
     */
    public void czytaj(String nazwaCzytanego) throws FileNotFoundException {

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
                    line = br.readLine();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
