package view.menu;

import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import view.MyGridBagConstraints;


public class GeneralGui extends JPanel {
	
    private final int dimx = 1280;
    private final int dimy = 720;
    private final int width;
    private final int height;
    private int fichesvalue;
    final JLabel vpuntata = new JLabel("1");
    final JLabel vvincita = new JLabel("2");
    final JLabel vsaldo = new JLabel("3");
	
    private final int getFichesValue() {
        return fichesvalue;
    }
    
    public int setvpuntata(String value) {
        vpuntata.setText(value);
        return 1;
    }
    
    public int setvvincita(String value) {
        vvincita.setText(value);
        return 1;
    }
    
    public int setvsaldo(String value) {
        vsaldo.setText(value);
        return 1;
    }
	

	
    public GeneralGui(){

        setLayout(new BorderLayout());
        width = this.getPreferredSize().width;
        height = this.getPreferredSize().height;

        this.setPreferredSize(new Dimension(1024, 720)); 
        System.out.println(width);
        
        final JPanel north = new JPanel();
        final JPanel south = new JPanel();
        final JPanel center = new JPanel();

        south.setLayout(new GridBagLayout());
        south.setPreferredSize(new Dimension((int) (dimx / 12.8), (int) (dimx / 12.8)));


        north.setLayout(new GridBagLayout());
        north.setPreferredSize(new Dimension((int) (dimx / 12.8), (int) (dimx / 12.8)));
        
        //JLabel definition

        //North jpanel label

        final JLabel labelvincita = new JLabel("HAI VINTO...");
        labelvincita.setForeground(Color.BLACK);
        labelvincita.setHorizontalAlignment(SwingConstants.CENTER);
        labelvincita.setFont(new Font("Arial", Font.PLAIN | Font.ITALIC, 25));
        north.add(labelvincita, new MyGridBagConstraints(5, 0));

        final JButton backToMenu = new JButton("Torna al Menu");
        backToMenu.setHorizontalAlignment(SwingConstants.LEFT);
        
        north.add(backToMenu, new MyGridBagConstraints(0, 0));
            
        final JButton help = new JButton("?");
        help.setHorizontalAlignment(SwingConstants.RIGHT);
        //help.setPreferredSize(new Dimension(100, 50));
        north.add(help, new MyGridBagConstraints(10, 0));
        
        final List<JButton> listbutton1 = new ArrayList();
        listbutton1.add(help);
        listbutton1.add(backToMenu);
        
        for (final JButton jb : listbutton1) { 
            jb.setOpaque(false);
            jb.setFocusPainted(false);
            jb.setBorderPainted(false);
            jb.setContentAreaFilled(false);
        }
        
        
            
        
        
        
        //South Jpanel label
        //Jlabel for puntata,vincita,saldo value
        final JLabel puntata = new JLabel("PUNTATA");
        final JLabel saldo = new JLabel("SALDO");
        final JLabel vincita = new JLabel("VINCITA");
        
        //final JLabel vpuntata = new JLabel("1");
        //final JLabel vsaldo = new JLabel("2");
        //final JLabel vvincita = new JLabel("3");
        
        
        //da rimuovere tutti se non utilizzati
        //puntata.setBounds(350, 20, 150, 150);
        //vincita.setBounds(350, 20, 150, 150);
        //puntata.setBounds(350, 20, 150, 150); 
        //puntata.setBounds(350, 20, 150, 150);
        //puntata.setBounds(350, 20, 150, 150);
        
        //da rimuovere tutti se non utilizzati
        //south.add(puntata, new MyGridBagConstraints(0, 0));
        //south.add(saldo, new MyGridBagConstraints(1, 0));
        //south.add(vincita, new MyGridBagConstraints(2, 0));
        //south.add(vpuntata, new MyGridBagConstraints(0, 1));
        //south.add(vsaldo, new MyGridBagConstraints(1, 1));
        //south.add(vvincita, new MyGridBagConstraints(2, 1));
        
        final List<JLabel> listlabel = new ArrayList<>();
        
        listlabel.add(puntata);
        listlabel.add(saldo);
        listlabel.add(vincita);
        
        listlabel.add(vpuntata);
        listlabel.add(vsaldo);
        listlabel.add(vvincita);
        
        
        
        int i = 0;
        int j = 0;
        for (final JLabel jb : listlabel) {
            jb.setForeground(Color.BLACK);
            jb.setHorizontalAlignment(SwingConstants.CENTER);
            jb.setFont(new Font("Arial", Font.PLAIN | Font.ITALIC, 15));
            south.add(jb, new MyGridBagConstraints(i, j));
            if (i == 2) {
                i = 0;
                j++;
            } else {
                i++;
            }
        }
        
        //Button for confirm or cancel your bet in the south panel
            
        final JButton reset = new JButton();
        final JButton confirm = new JButton();
            
        //Button with fish image for your bet
            
        final JButton fish1 = new JButton();
        final JButton fish2 = new JButton();
        final JButton fish3 = new JButton();
        final JButton fish4 = new JButton();
        final JButton fish5 = new JButton();
            
        //Adding Listener to set fiches value
            
        fish1.addActionListener(e -> fichesvalue = 1);
        fish2.addActionListener(e -> fichesvalue = 5);
        fish3.addActionListener(e -> fichesvalue = 25);
        fish4.addActionListener(e -> fichesvalue = 100);
        fish5.addActionListener(e -> fichesvalue = 500);
            
        
        final List<JButton> list = new ArrayList<>();
        list.add(reset);
        list.add(confirm);
        list.add(fish1);
        list.add(fish2);
        list.add(fish3);
        list.add(fish4);
        list.add(fish5);
        
        final List<String> fichesList = new ArrayList<>();
        fichesList.add("1"); //da cambiare in pulsante reset
        fichesList.add("1"); //da cambiare in pulsante conferma
        fichesList.add("1");
        fichesList.add("5");
        fichesList.add("25");
        fichesList.add("100");
        fichesList.add("500");
        
            
        //Setting all the button transparent 
        //Adding fish and confirm/cancel button on the south panel
        int c1 = 4;
        for (final JButton jb : list) { 
            jb.setOpaque(false);
            jb.setFocusPainted(false);
            jb.setBorderPainted(false);
            jb.setContentAreaFilled(false);
            jb.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            //final Image img = ;
            jb.setIcon(new ImageIcon((new ImageIcon("res/img/fiches/numbers/"
                    + fichesList.get(c1 - 4) + ".png").getImage())
                    .getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
            south.add(jb, new MyGridBagConstraints(c1, 0, 1, 2));
            c1++;

        }

        //Setting images to the buttons

        /*
        final Image img = new ImageIcon("res/img/fiches/numbers/1.png").getImage();
        reset.setIcon(new ImageIcon(img.getScaledInstance(70, 70, Image.SCALE_SMOOTH)));

        final Image img1 = new ImageIcon("res/img/fiches/numbers/1.png").getImage();
        confirm.setIcon(new ImageIcon(img1.getScaledInstance(70, 70, Image.SCALE_SMOOTH)));

        final Image img2 = new ImageIcon("res/img/fiches/numbers/1.png").getImage();
        fish1.setIcon(new ImageIcon(img2.getScaledInstance(70, 70, Image.SCALE_SMOOTH)));

        final Image img3 = new ImageIcon("res/img/fiches/numbers/5.png").getImage();
        fish2.setIcon(new ImageIcon(img3.getScaledInstance(70, 70, Image.SCALE_SMOOTH)));

        final Image img4 = new ImageIcon("res/img/fiches/numbers/25.png").getImage();
        fish3.setIcon(new ImageIcon(img4.getScaledInstance(70, 70, Image.SCALE_SMOOTH)));

        final Image img5 = new ImageIcon("res/img/fiches/numbers/100.png").getImage();
        fish4.setIcon(new ImageIcon(img5.getScaledInstance(70, 70, Image.SCALE_SMOOTH)));

        final Image img6 = new ImageIcon("res/img/fiches/numbers/500.png").getImage();
        fish5.setIcon(new ImageIcon(img6.getScaledInstance(70, 70, Image.SCALE_SMOOTH)));

         */
        

        //adding the panel to the Container 
        add(north, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        add(south, BorderLayout.SOUTH);

        setVisible(true);
    }


        public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setTitle("Gui giochi");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1280, 720));
        frame.add(new GeneralGui());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

        private GridBagConstraints setDimensionObj(final int gridx, final int gridy,    
                final int spacedown, final int spaceright, final int spaceleft) {       
            final GridBagConstraints c = new GridBagConstraints();        
            c.anchor = GridBagConstraints.PAGE_END;        
            c.insets = new Insets(0, spaceleft, spacedown, spaceright); 
            // terzo parametro definisce la distanza verticale     
            //(verso il basso) tra i vari oggetti della gui      
            c.gridx = gridx;       
            c.gridy = gridy;       
            return c;    
            }
}
	
	