import java.awt.*;

/**
 * Klasa główna tworząca wątek i uruchamiająca program
 */
public class Nurikabe {
    /**
     * Metoda główna realizująca program
     * @param args parametru programu
     */
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Gui();
            }
        });
    }
}
