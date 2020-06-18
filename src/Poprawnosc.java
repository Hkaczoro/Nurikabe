public class Poprawnosc extends Gra{

    /**
     * 1-9 liczebnosc wyspy
     * 10 - pole puste
     * 11 - woda
     * 12 - ląd
     */

    /**
     * Tablica dwuwymiarowa reprezentująca poprawny układ w danym pliku
     */
    private int[][] poprawnaPlansza;

    /**
     * Zmienna przechowująca ilość błędów
     */
    private int bledy;


    /**
     * Metoda zwracająca ilość błedów
     * @return liczbe błędów
     */
    public int getBledy(){
        return bledy;
    }


    /**
     * Metoda ładująca poprawne ułożenie planszy
     * @param nrPlanszy numer planszy
     */
    public void zaladujPlansze(int nrPlanszy){
        if(nrPlanszy == 0){
            int[][] poprawna = {{11, 11, 11, 11, 11},
                                {11, 12, 11, 1, 11},
                                {11, 3, 12, 11, 11},
                                {4, 11, 11, 11, 12},
                                {12, 12, 12, 11, 2}};
            this.poprawnaPlansza = poprawna;
        }

        if(nrPlanszy == 1){
            int[][] poprawna = {{1, 11, 11, 3, 11},
                                {11, 2, 11, 12, 11},
                                {11, 12, 11, 12, 11},
                                {11, 11, 11, 11, 11},
                                {11, 3, 12, 12, 11}};
            this.poprawnaPlansza = poprawna;
        }
        if(nrPlanszy == 2){
            int[][] poprawna = {{11, 11, 11, 2, 11, 11, 11},
                                {11, 1, 11, 12, 11, 1, 11},
                                {11, 11, 11, 11, 11, 11, 11},
                                {5, 12, 12, 12, 12, 11, 1},
                                {11, 11, 11, 11, 11, 11, 11},
                                {11, 1, 11, 12, 11, 1, 11},
                                {11, 11, 11, 2, 11, 11, 11}};
            this.poprawnaPlansza = poprawna;
        }
        if(nrPlanszy == 3){
            int[][] poprawna = {{11, 11, 11, 11, 11, 11, 11},
                                {11, 1, 11, 12, 11, 12, 11},
                                {11, 11, 11, 12, 11, 2, 11},
                                {11, 12, 11, 12, 12, 11, 11},
                                {11, 12, 12, 11, 12, 12, 11},
                                {11, 4, 11, 11, 11, 7, 11},
                                {11, 11, 2, 12, 11, 11, 11}};
            this.poprawnaPlansza = poprawna;
        }
        if(nrPlanszy == 4){
            int[][] poprawna = {{11, 11, 2, 12, 11, 11, 12, 2, 11, 11},
                                {11, 2, 11, 11, 1, 11, 11, 11, 2, 11},
                                {11, 12, 11, 2, 11, 11, 1, 11, 12, 11},
                                {11, 11, 11, 12, 11, 2, 11, 11, 11, 11},
                                {11, 12, 11, 11, 11, 12, 11, 12, 12, 11},
                                {11, 12, 11, 12, 12, 11, 11, 11, 12, 11},
                                {11, 12, 11, 11, 12, 12, 12, 11, 12, 11},
                                {11, 12, 11, 1, 11, 11, 6, 11, 12, 11},
                                {11, 5, 11, 11, 11, 12, 11, 11, 6, 11},
                                {11, 11, 2, 12, 11, 12, 12, 4, 11, 11}};
            this.poprawnaPlansza = poprawna;
        }
        if(nrPlanszy == 5){
            int[][] poprawna = {{11, 11, 1, 11, 11, 11, 11, 11, 12, 12},
                                {11, 2, 11, 1, 11, 12, 12, 11, 11, 3},
                                {11, 12, 11, 11, 11, 11, 12, 12, 5, 11},
                                {11, 11, 11, 12, 11, 2, 11, 11, 11, 11},
                                {11, 12, 11, 12, 11, 12, 11, 12, 12, 11},
                                {11, 12, 11, 12, 11, 11, 11, 12, 12, 11},
                                {11, 12, 11, 12, 11, 4, 12, 11, 12, 11},
                                {11, 12, 11, 12, 11, 12, 12, 11, 6, 11},
                                {11, 5, 11, 6, 11, 11, 11, 11, 11, 6},
                                {11, 11, 1, 11, 11, 12, 12, 12, 12, 12}};
            this.poprawnaPlansza = poprawna;
        }
    }

    /**
     * Metoda zwracająca czy plansza została rozwiązana poprawnie
     * @param planszaUzytkownika przechowujący rozwiązanie użytkownika
     * @param poziomTrudnosci określający poziom trudności
     * @return true-poprawnie albo false-nie poprawnie
     */
    public boolean sprawdzPoprawnosc(int[][] planszaUzytkownika, int poziomTrudnosci) {
        bledy = 0;
        if (poziomTrudnosci == 1){
            for (int i = 0; i < 5; i++){
                for (int x = 0; x < 5; x++){
                    if (poprawnaPlansza[i][x] != planszaUzytkownika[i][x]){
                        bledy++;

                    }
                }
            }
        }
        if (poziomTrudnosci == 2){
            for (int i = 0; i < 7; i++){
                for (int x = 0; x < 7; x++){
                    if (poprawnaPlansza[i][x] != planszaUzytkownika[i][x]){
                        bledy++;
                    }
                }
            }
        }
        if (poziomTrudnosci == 3){
            for (int i = 0; i < 10; i++){
                for (int x = 0; x < 10; x++){
                    if (poprawnaPlansza[i][x] != planszaUzytkownika[i][x]){
                        bledy++;
                    }
                }
            }
        }
        if(bledy == 0){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Metoda podpowiadająca użytkownikowu gdy ten tego zarząda
     * @param planszaUzytkownika przechowujący plansze użytkownika
     * @param poziomTrudnosci przechowujący aktualny poziom trudności
     */
    public void solwer(int[][] planszaUzytkownika, int poziomTrudnosci){
        int a;
        if (poziomTrudnosci == 1){
            a = 5;
        }
        else if (poziomTrudnosci == 2){
            a = 7;
        }
        else{
            a = 10;
        }
        outerloop:
        for(int i = 0; i < a; i++){
            for(int x = 0; x < a; x++){
                if(poprawnaPlansza[i][x] != planszaUzytkownika[i][x]){
                    planszaUzytkownika[i][x] = poprawnaPlansza[i][x];
                    break outerloop;
                }
            }
        }
    }
    /**
     * Metoda główna realizująca program (testy poprawnosci metod)
     * @param args parametru programu
     */
    public static void main(String[] args){
        Gra gra = new Gra();
        gra.losujUklad(2);
        int poziomTrudnosci = gra.getPoziomTrudnosci();
        int numer = gra.getNrPlanszy();
        Poprawnosc poprawnosc = new Poprawnosc();
        poprawnosc.zaladujPlansze(numer);
        int[][] pUzytkownika = {{11, 11, 11, 11, 11, 11, 11},
                {11, 1, 11, 12, 11, 12, 11},
                {11, 11, 11, 12, 11, 2, 11},
                {11, 12, 11, 12, 12, 11, 11},
                {11, 12, 12, 11, 12, 12, 11},
                {11, 4, 11, 11, 11, 7, 11},
                {11, 11, 2, 12, 11, 11, 11}};
        System.out.println(poprawnosc.sprawdzPoprawnosc(pUzytkownika, poziomTrudnosci));
    }
}
