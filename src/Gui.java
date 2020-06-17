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
        nowaGra.addActionListener(this);
        add(nowaGra);

        wczytaj = new JButton("Wczytaj");
        wczytaj.setBounds(20, 80, 120, 40);
        //wczytaj.setBorderPainted(false);
        //wczytaj.setOpaque(true);
        wczytaj.addActionListener(this);
        add(wczytaj);

        wczytajText = new JTextArea();
        wczytajText.setBounds(20, 125, 120, 20);
        add(wczytajText);

        zapisz = new JButton("Zapisz");
        zapisz.setBounds(20, 165, 120, 40);
        zapisz.addActionListener(this);
        add(zapisz);

        zapiszText = new JTextArea();
        zapiszText.setBounds(20, 210, 120, 20);
        add(zapiszText);

        podpowiedz = new JButton("Podpowiedź");
        podpowiedz.setBounds(20, 250, 120, 60);
        podpowiedz.addActionListener(this);
        add(podpowiedz);

        sprawdz = new JButton("Sprawdź");
        sprawdz.setBounds(20, 340, 120, 60);
        sprawdz.setForeground(Color.DARK_GRAY);
        sprawdz.addActionListener(this);
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

       // Plansza plansza = new Plansza(1);
       // plansza.setBounds(610, 10, 600, 600);
       // add(plansza);
        MojPanelGraf panel = new MojPanelGraf();
        //setContentPane(panel);
        panel.setBounds(150,150,349,349);
        add(panel);





        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();

        if (source == nowaGra) {
            repaint();
            //JPanel ramka = new JPanel();
            //MojPanelGraf panel = new MojPanelGraf();
            //setContentPane(panel);
            //panel.setBounds(150,150,349,349);
            //repaint();

            //setBounds(100,100,250,250);
            //setVisible(true);
        }

    }

    class MojPanelGraf extends JPanel {

        @Override
        public void paintComponent(Graphics g) {
            int ky = 0;
            int a = 0;
            if(latwy.isSelected()){
                a = 5;
            }
            if(sredni.isSelected()){
                a = 7;
            }
            if(trudny.isSelected()){
                a = 10;
            }
            g.setColor(Color.BLACK);
            g.fillRect(0,0,199,199);
            g.setColor(Color.white);
            for(int i = 0; i<a; i++){
                int kx = 0;
                for(int j = 0; j<a;j++){
                    g.fillRect(3 + kx ,3 + ky,25,25);
                    kx += 28;
                }
                ky += 28;
            }
        }


    }
}
