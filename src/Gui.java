import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;


public class Gui extends JFrame implements ActionListener, MouseListener, MouseMotionListener {
    /**
     * Inicjalizacja zmiennych prywatnych
     */
    private JButton nowaGra, zapisz, wczytaj, podpowiedz, sprawdz;

    private JLabel levelLabel;

    private JTextArea zapiszText, wczytajText;

    private JRadioButton latwy, sredni, trudny;

    private ButtonGroup level;

    private Gra gra = new Gra();

    private int[][] uklad;

    private Component frame;
    private int proba=0;
    public int getProba(){
        return proba;
    }


    private int x, y;

    /**
     * Konstruktor Klasy Gui
     */

    public Gui(){
        /**
         * Ustawienie nazwy okienka GUI
         * Rozmiariu okna, jego położenia na ekranie oraz zablokowanie rozszerzenia okna
         */
        super("Nurikabe");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(780, 660);
        setResizable(false);
        setLocation(50, 50);

        /**
         * Dodanie przycisku do ActionListenera oraz ustawienie jego rozmiarów i położenia w oknie
         */
        nowaGra = new JButton("Nowa Gra");
        nowaGra.setBounds(20, 20, 120, 40);
        nowaGra.addActionListener(this);
        add(nowaGra);

        /**
         * Dodanie przycisku do ActionListenera oraz ustawienie jego rozmiarów i położenia w oknie
         */
        wczytaj = new JButton("Wczytaj");
        wczytaj.setBounds(20, 80, 120, 40);
        wczytaj.addActionListener(this);
        add(wczytaj);

        /**
         * Dodanie pola tekstowego oraz ustawienie jego rozmiarów i położenia w oknie
         */
        wczytajText = new JTextArea();
        wczytajText.setBounds(20, 125, 120, 20);
        add(wczytajText);

        /**
         * Dodanie przycisku do ActionListenera oraz ustawienie jego rozmiarów i położenia w oknie
         */
        zapisz = new JButton("Zapisz");
        zapisz.setBounds(20, 165, 120, 40);
        zapisz.addActionListener(this);
        add(zapisz);

        /**
         * Dodanie pola tekstowego oraz ustawienie jego rozmiarów i położenia w oknie
         */
        zapiszText = new JTextArea();
        zapiszText.setBounds(20, 210, 120, 20);
        add(zapiszText);

        /**
         * Dodanie przycisku do ActionListenera oraz ustawienie jego rozmiarów i położenia w oknie
         */
        podpowiedz = new JButton("Podpowiedź");
        podpowiedz.setBounds(20, 250, 120, 60);
        podpowiedz.addActionListener(this);
        add(podpowiedz);

        /**
         * Dodanie przycisku do ActionListenera oraz ustawienie jego rozmiarów i położenia w oknie
         */
        sprawdz = new JButton("Sprawdź");
        sprawdz.setBounds(20, 340, 120, 60);
        sprawdz.setForeground(Color.DARK_GRAY);
        sprawdz.addActionListener(this);
        add(sprawdz);

        /**
         * Utworzenie etykiety
         */
        levelLabel = new JLabel("Poziom trudnośći: ");
        levelLabel.setBounds(20, 430, 120, 30);
        add(levelLabel);

        /**
         * Utowrzenie przycisków wyboru poziomu trudności
         */
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

        /**
         * Inicjalizacja panelu
         */
        MojPanelGraf panel = new MojPanelGraf();
        panel.setBounds(150, 5,620,620);
        add(panel);

        /**
         * Dodanie do komponentu nasłuchującego odpowiedniego słuchacza
         */
        addMouseListener(this);
        addMouseMotionListener(this);


        /**
         * Ustawienie aby okienko było widoczne dla użytkownika
         */
        setLayout(null);
        setVisible(true);
    }

    /**
     * Utworzenie  metody, która jest wywoływana, kiedy zostanie wygenerowane zdarzenie na obiekcie powiązanym z danym słuchaczem
     * @param actionEvent  przechowuje wiele informacji w tym źródło
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();

        if (source == nowaGra) {
            proba = 0;
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
            proba++;
            Poprawnosc poprawnosc = new Poprawnosc();
            int nr = gra.getNrPlanszy();
            poprawnosc.zaladujPlansze(nr);
            int poziomTr = gra.getPoziomTrudnosci();
            if(poprawnosc.sprawdzPoprawnosc(uklad, poziomTr)){
                JOptionPane.showMessageDialog(frame, "Udało ci się!\n Ilość prób: " + getProba());
            }
            else {
                JOptionPane.showMessageDialog(frame, "Nie udało ci się.\nLiczba błędów: " + poprawnosc.getBledy());
            }

        }
        if(source == podpowiedz){
            Poprawnosc poprawnosc = new Poprawnosc();
            int nr = gra.getNrPlanszy();
            poprawnosc.zaladujPlansze(nr);
            int poziomTr = gra.getPoziomTrudnosci();
            poprawnosc.solwer(uklad, poziomTr);
            repaint();
        }
        if(source == zapisz){
            OdczytIZapis z = new OdczytIZapis();
            String nazwa = zapiszText.getText() + ".csv";
            z.setNazwaZapisywanego(nazwa);
            z.write(uklad, gra.getPoziomTrudnosci(), gra.getNrPlanszy(),proba);
        }
        if(source == wczytaj){
            OdczytIZapis o = new OdczytIZapis();
            String nazwa = wczytajText.getText();
            try {
                o.czytaj(nazwa+".csv");
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(frame, "Nie znaleziono pliku");
                e.printStackTrace();
            }

            gra.setPoziomTrudnosci(o.getPoziomTrudnosci());
            gra.setNrPlanszy(o.getNumerPlanszy());
            proba = o.getProba();
            if(o.getPoziomTrudnosci() == 1){
                latwy.setSelected(true);
            }
            if(o.getPoziomTrudnosci() == 2){
                sredni.setSelected(true);
            }
            if(o.getPoziomTrudnosci() == 3){
                trudny.setSelected(true);
            }
            uklad = o.getUkladPlanszy();
            repaint();
            System.out.println(gra.getPoziomTrudnosci());
            System.out.println(gra.getNrPlanszy());
            System.out.println("");
            System.out.println(uklad[0][1]);

            }

        }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    /**
     * Metoda wywoływana, gdy zostaje wciśnięty przycisk myszy
     * @param e parametr z którego odczytujemy położenie kursora względem punktu (0,0) naszego panelu
     */
    @Override
    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();

        if(gra.getPoziomTrudnosci() == 1){
            int a = 5;
            int ky = 25;
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


                    }
                    kx += 120;
                }

                ky += 120;
            }
        }

        if(gra.getPoziomTrudnosci() == 2){
            int a = 7;
            int ky = 27;
            for(int i = 0; i<a; i++){
                int kx = 150;
                for(int j = 0; j<a; j++){
                    if ((x>kx+3) && (x<kx+88) && (y>ky+3) && (y<ky+88)) {

                        if(uklad[i][j]==11) {
                            uklad[i][j] = 12;
                        }

                        else if(uklad[i][j]==10) {
                            uklad[i][j] = 11;
                        }
                        else if(uklad[i][j]==12) {
                            uklad[i][j] = 10;
                        }



                    }
                    kx += 85;
                }

                ky += 85;
            }

        }
        if(gra.getPoziomTrudnosci() == 3){
            int a = 10;
            int ky = 27;
            for(int i = 0; i<a; i++){
                int kx = 150;
                for(int j = 0; j<a; j++){
                    if ((x>kx+3) && (x<kx+63) && (y>ky+3) && (y<ky+63)) {

                        if(uklad[i][j]==11) {
                            uklad[i][j] = 12;
                        }

                        else if(uklad[i][j]==10) {
                            uklad[i][j] = 11;
                        }
                        else if(uklad[i][j]==12) {
                            uklad[i][j] = 10;
                        }



                    }
                    kx += 60;
                }

                ky += 60;
            }
            System.out.println(x + ", " + y);
        }

        repaint();
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
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    /**
     * Klasa Panelu graficznego
     */
    class MojPanelGraf extends JPanel {
        /**
         * Metoda która odpowida za rysowanie planszy w panelu naszego okna
         * @param g
         */
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

                        kx += 60;
                    }
                    ky += 60;
                }
            }


        }


    }
}
