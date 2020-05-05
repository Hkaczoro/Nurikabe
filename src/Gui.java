import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame implements ActionListener {

    private JButton nowaGra, zapisz, wczytaj, podpowiedz, sprawdz;

    private JLabel levelLabel;

    private JTextArea zapiszText, wczytajText;

    private JRadioButton latwy, sredni, trudny;

    private ButtonGroup level;

    public Gui(){
        super("Nurikabe");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(760, 620);
        setResizable(false);
        setLocation(50, 50);

        nowaGra = new JButton("Nowa Gra");
        nowaGra.setBounds(20, 20, 120, 40);
        add(nowaGra);

        wczytaj = new JButton("Wczytaj");
        wczytaj.setBounds(20, 80, 120, 40);
        wczytaj.setBackground(Color.BLACK);
        //wczytaj.setBorderPainted(false);
        //wczytaj.setOpaque(true);
        add(wczytaj);

        wczytajText = new JTextArea();
        wczytajText.setBounds(20, 125, 120, 20);
        add(wczytajText);

        zapisz = new JButton("Zapisz");
        zapisz.setBounds(20, 165, 120, 40);
        add(zapisz);

        zapiszText = new JTextArea();
        zapiszText.setBounds(20, 210, 120, 20);
        add(zapiszText);

        podpowiedz = new JButton("Podpowiedź");
        podpowiedz.setBounds(20, 250, 120, 60);
        add(podpowiedz);

        sprawdz = new JButton("Sprawdź");
        sprawdz.setBounds(20, 340, 120, 60);
        sprawdz.setForeground(Color.DARK_GRAY);
        add(sprawdz);

        levelLabel = new JLabel("Poziom trudnośći: ");
        levelLabel.setBounds(20, 430, 120, 30);
        add(levelLabel);


        level = new ButtonGroup();
        latwy = new JRadioButton("Łatwy", true);
        sredni = new JRadioButton("Średni");
        trudny = new JRadioButton("Trudny");
        latwy.setBounds(20, 470, 75, 20);
        sredni.setBounds(20, 500, 75, 20);
        trudny.setBounds(20, 530, 80, 20);
        level.add(latwy);
        level.add(sredni);
        level.add(trudny);
        add(latwy);
        add(sredni);
        add(trudny);





        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
