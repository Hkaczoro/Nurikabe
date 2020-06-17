import java.util.Random;

public class Gra {

    private int poziomTrudnosci;
    /**
     * 1-9 liczebnosc wyspy
     * 10 - pole puste
     * 11 - woda
     * 12 - ląd
     */
    private int[][] ukladPlanszy;

    private int nrPlanszy;

    public int getNrPlanszy() {
        return nrPlanszy;
    }

    public void setNrPlanszy(int nrPlanszy) {
        this.nrPlanszy = nrPlanszy;
    }

    public int getPoziomTrudnosci() {
        return poziomTrudnosci;
    }

    public void setPoziomTrudnosci(int poziomTrudnosci) {
        this.poziomTrudnosci = poziomTrudnosci;
    }

    public int[][] getUkladPlanszy() {

        return ukladPlanszy;
    }

    public void setUkladPlanszy(int[][] ukladPlanszy){
        this.ukladPlanszy = ukladPlanszy;
    }

    public void losujUklad(int poziomTrudnosci){
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
