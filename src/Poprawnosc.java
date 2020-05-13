public class Poprawnosc extends Gra{
    public boolean sprawdzPoprawnosc(Gra gra){
        int[][] uklad = gra.getUkladPlanszy();
        for (int i = 0; i < uklad.length-1; i++){
            for(int x = 0; x < uklad.length-1; x++){
                //sprawdzenie nieuzupełnionych pol
                if (uklad[i][x] == 10){
                    return false;
                }
                //Sprawdzenie, czy na mapie są kwadraty wody
                if(uklad[i][x] == 11 && uklad[i][x+1] == 11 && uklad[i+1][x+1] == 11 && uklad[i+1][x] == 11){
                    return false;
                }
                //sprawdzenie liczebnosci wyspy
                if (uklad[i][x] != 10 && uklad[i][x] != 11 && uklad[i][x] != 12){
                    int liczebnoscWyspy = uklad[i][x];
                    // ---1---
                    if(liczebnoscWyspy == 1 && i != 0 && x != 0) {
                        if(uklad[i-1][x] != 11 && uklad[i][x+1] != 11 && uklad[i][x-1] != 11 && uklad[i+1][x] != 11){
                            return false;
                        }
                    }
                    if(liczebnoscWyspy == 1 && i == 0){
                        if (uklad[i+1][x] != 11 && uklad[i][x-1] != 11 && uklad[i][x+1] != 11){
                            return false;
                        }
                    }
                    if(liczebnoscWyspy == 1 && x == 0){
                        if (uklad[i+1][x] != 11 && uklad[i-1][x] != 11 && uklad[i][x+1] != 11){
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args){
        Gra gra = new Gra();
        int[][] uklad = {{11, 11, 12, 11, 11},
                         {11, 12, 11, 11, 12},
                         {11, 12, 11, 12, 11},
                         {11, 12, 11, 12, 11},
                         {11, 11, 11, 11, 11}};
        gra.setUkladPlanszy(uklad);
        Poprawnosc poprawnosc = new Poprawnosc();
        System.out.println(poprawnosc.sprawdzPoprawnosc(gra));
    }
}
