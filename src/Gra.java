public class Gra {

    private int poziomTrudnosci;
    /**
     * 1-9 liczebnosc wyspy
     * 10 - pole puste
     * 11 - woda
     * 12 - ląd
     */
    private int[][] ukladPlanszy;

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
        if (poziomTrudnosci == 1){
            ukladPlanszy = new int[5][5];
        }
        else if (poziomTrudnosci == 2){
            ukladPlanszy = new int[7][7];
        }
        else if (poziomTrudnosci == 3){
            ukladPlanszy = new int[9][9];
        }

        //do zrobienia!
    }
}
