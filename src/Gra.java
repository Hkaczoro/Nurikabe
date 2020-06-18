import java.util.Random;

public class Gra {
    /**
     * liczba reprezentująca poziom trudności planszy(1 - łatwy, 2 - średni, 3 - trudny)
     */
    private int poziomTrudnosci;
    /**
     * Tablica dwuwymiarowa reprezentująca danu układ planszy
     * 1-9 liczebnosc wyspy
     * 10 - pole puste
     * 11 - woda
     * 12 - ląd
     */
    private int[][] ukladPlanszy;
    /**
     * Numer identyfikacyjny planszy
     */
    private int nrPlanszy;

    /**
     * Metoda do zwracania numeru planszy
     * @return numer planszy
     */
    public int getNrPlanszy() {
        return nrPlanszy;
    }

    /**
     * Metoda do ustawiania numeru planszy
     * @param nrPlanszy numer identyfikacyjny planszy
     */
    public void setNrPlanszy(int nrPlanszy) {
        this.nrPlanszy = nrPlanszy;
    }

    /**
     * Metoda do zwracania poziomu trudności
     * @return poziom trudności gry
     */
    public int getPoziomTrudnosci() {
        return poziomTrudnosci;
    }

    /**
     * Metoda do ustawiania poziomu trudności
     * @param poziomTrudnosci poziom trudności gry
     */
    public void setPoziomTrudnosci(int poziomTrudnosci) {
        this.poziomTrudnosci = poziomTrudnosci;
    }

    /**
     * Metoda do zwracania tablicy dwuwymiarowej reprezentującej układ planszy
     * @return
     */
    public int[][] getUkladPlanszy() {
        return ukladPlanszy;
    }

    /**
     * Metoda do losowania układu planszy w zależności od poziomu trudności
     * @param poziomTrudnosci poziom trudności wybrany przez użytkownika
     */
    public void losujUklad(int poziomTrudnosci){
        this.poziomTrudnosci = poziomTrudnosci;
        Random random = new Random();
        int numer = random.nextInt(2);
        if (poziomTrudnosci == 1){
           if (numer == 0) {
               int[][] ukladPlanszy =   {{10, 10, 10, 10, 10},
                                        {10, 10, 10, 1, 10},
                                        {10, 3, 10, 10, 10},
                                        {4, 10, 10, 10, 10},
                                        {10, 10, 10, 10, 2}};
               nrPlanszy = numer;
               this.ukladPlanszy = ukladPlanszy;
           }
           else if (numer == 1) {
               int[][] ukladPlanszy = {{1, 10, 10, 3, 10},
                                        {10, 2, 10, 10, 10},
                                        {10, 10, 10, 10, 10},
                                        {10, 10, 10, 10, 10},
                                        {10, 3, 10, 10, 10}};
               nrPlanszy = numer;
               this.ukladPlanszy = ukladPlanszy;
           }
        }
        else if (poziomTrudnosci == 2){
            if (numer == 0){
                int[][] ukladPlanszy =   {{10, 10, 10, 2, 10, 10, 10},
                                          {10, 1, 10, 10, 10, 1, 10},
                                          {10, 10, 10, 10, 10, 10, 10},
                                          {5, 10, 10, 10, 10, 10, 1},
                                          {10, 10, 10, 10, 10, 10, 10},
                                          {10, 1, 10, 10, 10, 1, 10},
                                          {10, 10, 10, 2, 10, 10, 10}};
                nrPlanszy = numer+2;
                this.ukladPlanszy = ukladPlanszy;
            }
            if (numer == 1) {
                int[][] ukladPlanszy = {{10, 10, 10, 10, 10, 10, 10},
                                        {10, 1, 10, 10, 10, 10, 10},
                                        {10, 10, 10, 10, 10, 2, 10},
                                        {10, 10, 10, 10, 10, 10, 10},
                                        {10, 10, 10, 10, 10, 10, 10},
                                        {10, 4, 10, 10, 10, 7, 10},
                                        {10, 10, 2, 10, 10, 10, 10}};
                nrPlanszy = numer + 2;
                this.ukladPlanszy = ukladPlanszy;
            }
        }
        else if (poziomTrudnosci == 3){
            if (numer == 0) {
                int[][] ukladPlanszy = {{10, 10, 2, 10, 10, 10, 10, 2, 10, 10},
                                        {10, 2, 10, 10, 1, 10, 10, 10, 2, 10},
                                        {10, 10, 10, 2, 10, 10, 1, 10, 10, 10},
                                        {10, 10, 10, 10, 10, 2, 10, 10, 10, 10},
                                        {10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
                                        {10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
                                        {10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
                                        {10, 10, 10, 1, 10, 10, 6, 10, 10, 10},
                                        {10, 5, 10, 10, 10, 10, 10, 10, 6, 10},
                                        {10, 10, 2, 10, 10, 10, 10, 4, 10, 10}};
                nrPlanszy = numer + 4;
                this.ukladPlanszy = ukladPlanszy;
            }
            if (numer == 1) {
                int[][] ukladPlanszy = {{10, 10, 1, 10, 10, 10, 10, 10, 10, 10},
                                        {10, 2, 10, 1, 10, 10, 10, 10, 10, 3},
                                        {10, 10, 10, 10, 10, 10, 10, 10, 5, 10},
                                        {10, 10, 10, 10, 10, 2, 10, 10, 10, 10},
                                        {10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
                                        {10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
                                        {10, 10, 10, 10, 10, 4, 10, 10, 10, 10},
                                        {10, 10, 10, 10, 10, 10, 10, 10, 6, 10},
                                        {10, 5, 10, 6, 10, 10, 10, 10, 10, 6},
                                        {10, 10, 1, 10, 10, 10, 10, 10, 10, 10}};
                nrPlanszy = numer + 4;
                this.ukladPlanszy = ukladPlanszy;
            }
        }
    }

    /**
     * Metoda główna (do testów poprawności metod)
     * @param args argumenty klasy
     */
    public static void main(String[] args){
        Gra gra = new Gra();
        gra.losujUklad(1);
        for (int i = 0; i < 5; i++){
            System.out.println(".");
            for (int x = 0; x < 5; x++){
                System.out.println(gra.ukladPlanszy[i][x]);
            }
        }
    }
}
