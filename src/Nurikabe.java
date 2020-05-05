import java.awt.*;

public class Nurikabe {
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Gui();
            }
        });
    }
}
