import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Gui extends JFrame implements ActionListener, MouseListener, MouseMotionListener {

    private JButton nowaGra, zapisz, wczytaj, podpowiedz, sprawdz;

    private JLabel levelLabel;

    private JTextArea zapiszText, wczytajText;

    private JRadioButton latwy, sredni, trudny;

    private ButtonGroup level;

    private Gra gra = new Gra();

    private int[][] uklad;

    private Component frame;


    private int x, y;

    ArrayList<Point> points = new ArrayList<Point>();

    public Gui(){
        super("Nurikabe");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 700);
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
        panel.setBounds(150, 5,620,620);
        add(panel);


        addMouseListener(this);
        addMouseMotionListener(this);





        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();

        if (source == nowaGra) {
            if(latwy.isSelected()) {
                gra.losujUklad(1);
                uklad = gra.getUkladPlanszy();
                gra.setPoziomTrudnosci(1);
            }
            if(sredni.isSelected()){
                gra.losujUklad(2);
                uklad = gra.getUkladPlanszy();
                gra.setPoziomTrudnosci(2);
            }
            if(trudny.isSelected()){
                gra.losujUklad(3);
                uklad = gra.getUkladPlanszy();
                gra.setPoziomTrudnosci(3);
            }
            repaint();
        }

        if(source == sprawdz){
            Poprawnosc poprawnosc = new Poprawnosc();
            int nr = gra.getNrPlanszy();
            poprawnosc.zaladujPlansze(nr);
            int poziomTr = gra.getPoziomTrudnosci();
            if(poprawnosc.sprawdzPoprawnosc(uklad, poziomTr)){
                JOptionPane.showMessageDialog(frame, "Udało ci się!");
            }
            else {
                JOptionPane.showMessageDialog(frame, "Nie udało ci się.");
            }

        }
<<<<<<< HEAD
        if (source == podpowiedz){
            Poprawnosc poprawnosc = new Poprawnosc();
            int nr = gra.getNrPlanszy();
            poprawnosc.zaladujPlansze(nr);
            int poziomTr = gra.getPoziomTrudnosci();
            poprawnosc.solwer(uklad, poziomTr);
            repaint();
        }
=======
>>>>>>> 437490af7f801f12a318e48e34e555b384061595

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        points.add(new Point(x, y));
        if(gra.getPoziomTrudnosci() == 1){
            int a = 5;
            int ky = 5;
            for(int i = 0; i<a; i++){
                int kx = 150;
                for(int j = 0; j<a; j++){
                     if ((x>kx+3) && (x<kx+123) && (y>ky+3) && (y<ky+123)) {

                         if(uklad[i][j]==11) {
                             uklad[i][j] = 12;
                         }

                         else if(uklad[i][j]==10) {
                             uklad[i][j] = 11;
                         }
                         else if(uklad[i][j]==12) {
                             uklad[i][j] = 10;
                         }

                         System.out.println("i: " +i + " " + "j: " +j);


                    }
                    kx += 120;
                }

                ky += 120;
            }
        }

        if(gra.getPoziomTrudnosci() == 2){
            int a = 7;
            int ky = 5;
            for(int i = 0; i<a; i++){
                int kx = 150;
                for(int j = 0; j<a; j++){
                    if ((x>kx+3) && (x<kx+123) && (y>ky+3) && (y<ky+123)) {

                        if(uklad[i][j]==11) {
                            uklad[i][j] = 12;
                        }

                        else if(uklad[i][j]==10) {
                            uklad[i][j] = 11;
                        }
                        else if(uklad[i][j]==12) {
                            uklad[i][j] = 10;
                        }

                        System.out.println("i: " +i + " " + "j: " +j);


                    }
                    kx += 120;
                }

                ky += 120;
            }
        }
        if(gra.getPoziomTrudnosci() == 3){
            int a = 10;
            int ky = 5;
            for(int i = 0; i<a; i++){
                int kx = 150;
                for(int j = 0; j<a; j++){
                    if ((x>kx+3) && (x<kx+60) && (y>ky+3) && (y<ky+60)) {

                        if(uklad[i][j]==11) {
                            uklad[i][j] = 12;
                        }

                        else if(uklad[i][j]==10) {
                            uklad[i][j] = 11;
                        }
                        else if(uklad[i][j]==12) {
                            uklad[i][j] = 10;
                        }

                        System.out.println("i: " +i + " " + "j: " +j);


                    }
                    kx += 60;
                }

                ky += 60;
            }
        }

        System.out.println("MousePressed");
        repaint();
<<<<<<< HEAD
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
=======
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
>>>>>>> 437490af7f801f12a318e48e34e555b384061595
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }


    class MojPanelGraf extends JPanel {

        @Override
        public void paintComponent(Graphics g) {
            int ky = 0;
            int a = 0;
            if(gra.getPoziomTrudnosci() == 1){
                a = 5;
                g.setColor(Color.BLACK);
                g.fillRect(0,0,602,602);
                g.setColor(Color.white);
                for(int i = 0; i<a; i++){
                    int kx = 0;
                    for(int j = 0; j<a; j++){
                        if(uklad[i][j] == 10){
                            g.setColor(Color.white);
                            g.fillRect(3 + kx ,3 + ky,116,116);
                        }
                        else if (uklad[i][j] == 11){
                            g.setColor(Color.BLUE);
                            g.fillRect(3 + kx ,3 + ky,116,116);
                        }
                        else if (uklad[i][j] == 12){
                            g.setColor(Color.GREEN);
                            g.fillRect(3 + kx ,3 + ky,116,116);
                        }
                        else {
                            String q;
                            q = String.valueOf(uklad[i][j]);
                            Font font = new Font(" ", Font.BOLD, 45);
                            g.setFont(font);
                            g.drawString(q, 50+kx, 77 +ky);
                        }
                        //g.fillRect(3 + kx ,3 + ky,116,116);
                        kx += 120;
                    }
                    ky += 120;
                }
            }
            if(gra.getPoziomTrudnosci() == 2){
                a = 7;
                g.setColor(Color.BLACK);
                g.fillRect(0,0,599,600);
                g.setColor(Color.white);
                for(int i = 0; i<a; i++){
                    int kx = 0;
                    for(int j = 0; j<a; j++){
                        if(uklad[i][j] == 10){
                            g.setColor(Color.white);
                            g.fillRect(3 + kx ,3 + ky,83,83);
                        }
                        else if (uklad[i][j] == 11){
                            g.setColor(Color.BLUE);
                            g.fillRect(3 + kx ,3 + ky,83,83);
                        }
                        else if (uklad[i][j] == 12){
                            g.setColor(Color.GREEN);
                            g.fillRect(3 + kx ,3 + ky,83,83);
                        }
                        else {
                            String q;
                            q = String.valueOf(uklad[i][j]);
                            Font font = new Font(" ", Font.BOLD, 35);
                            g.setFont(font);
                            g.drawString(q, 35+kx, 55 +ky);
                        }
                        //g.fillRect(3 + kx ,3 + ky,83,83);
                        kx += 85;
                    }
                    ky += 85;
                }
            }
            if(gra.getPoziomTrudnosci() == 3){
                a = 10;
                g.setColor(Color.BLACK);
                g.fillRect(0,0,603,603);
                g.setColor(Color.WHITE);
                for(int i = 0; i<a; i++){
                    int kx = 0;
                    for(int j = 0; j<a; j++){
                        if(uklad[i][j] == 10){
                            g.setColor(Color.white);
                            g.fillRect(3 + kx ,3 + ky,57,57);
                        }
                        else if (uklad[i][j] == 11){
                            g.setColor(Color.BLUE);
                            g.fillRect(3 + kx ,3 + ky,57,57);
                        }
                        else if (uklad[i][j] == 12){
                            g.setColor(Color.GREEN);
                            g.fillRect(3 + kx ,3 + ky,57,57);
                        }
                        else {
                            String q;
                            q = String.valueOf(uklad[i][j]);
                            Font font = new Font(" ", Font.BOLD, 30);
                            g.setFont(font);
                            g.drawString(q, 22+kx, 40 +ky);
                        }
                        //g.fillRect(3 + kx ,3 + ky,57,57);
                        kx += 60;
                    }
                    ky += 60;
                }
            }


        }


    }
}
