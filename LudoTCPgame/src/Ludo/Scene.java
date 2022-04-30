/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ludo;

import game.Message;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Ozkan
 */
public class Scene extends javax.swing.JFrame {

    /**
     * Creates new form Scene
     */
    public String side;
    private int piyon1 = 0;
    private int piyon2 = 0;
    private int piyon3 = 0;
    private int piyon4 = 0;
    private int counterPiyon = 0;
    private int counter;
    private int temp;
    private int temp1;
    private int temp2;
    private int temp3;
    private int GreenTemp;
    private int GreenTemp1;
    private int GreenTemp2;
    private int GreenTemp3;
    private int enemyTemp = -1;
    private int enemyTemp1 = -1;
    private int enemyTemp2 = -1;
    private int enemyTemp3 = -1;
    private int enemyTemp4 = -1;
    private int enemyTemp5 = -1;
    private int enemyTemp6 = -1;
    private int enemyTemp7 = -1;
    private int PiyonSeciliMi = 0;
    private int GreenPiyonSeciliMi = 0;
    private ArrayList<JLabel> Squares;
    public static Scene game;
    private int redSquareCounter = 0;
    private int piyon5 = 0;
    private int piyon6 = 0;
    private int piyon7 = 0;
    private int piyon8 = 0;
    private int GreenEnemyTemp = -1;
    private boolean dolduMu1 = false;
    private boolean dolduMu2 = false;
    private boolean dolduMu3 = false;
    private boolean dolduMu4 = false;
    private boolean dolduMu5 = false;
    private boolean dolduMu6 = false;
    private boolean dolduMu7 = false;
    private boolean dolduMu8 = false;
    public int DiceCounter = 0;
    public Thread Slider;
    public int control = 0;

    public Scene() {

        initComponents();
        game = this;
        Scene.game.setBackground(Color.black);
        Client.Start("127.0.0.1", 2000);

        side = "green";
        // Labellarimizi ArrayLisete Ekliyoruz.

        Squares = new ArrayList();

        Squares.add(yol1);
        Squares.add(yol2);
        Squares.add(yol3);
        Squares.add(yol4);
        Squares.add(yol5);
        Squares.add(yol6);
        Squares.add(yol7);
        Squares.add(yol8);
        Squares.add(yol9);
        Squares.add(yol10);
        Squares.add(yol11);
        Squares.add(yol12);
        Squares.add(yol13);
        Squares.add(yol14);
        Squares.add(yol15);
        Squares.add(yol16);
        Squares.add(yol17);
        Squares.add(yol18);
        Squares.add(yol19);
        Squares.add(yol20);
        Squares.add(yol21);
        Squares.add(yol22);
        Squares.add(yol23);
        Squares.add(yol24);
        Squares.add(yol25);
        Squares.add(yol26);
        Squares.add(yol27);
        Squares.add(yol28);
        Squares.add(yol29);
        Squares.add(yol30);
        Squares.add(yol31);
        Squares.add(yol32);
        Squares.add(yol33);
        Squares.add(yol34);
        Squares.add(yol35);
        Squares.add(yol36);
        Squares.add(yol37);
        Squares.add(yol38);
        Squares.add(yol39);
        Squares.add(yol40);

        Squares.add(PiyonGreen1);
        Squares.add(PiyonGreen2);
        Squares.add(PiyonGreen3);
        Squares.add(PiyonGreen4);

        Squares.add(PiyonRed1);
        Squares.add(PiyonRed2);
        Squares.add(PiyonRed3);
        Squares.add(PiyonRed4);

        Squares.get(40).setBackground(Color.green);
        Squares.get(41).setBackground(Color.green);
        Squares.get(42).setBackground(Color.green);
        Squares.get(43).setBackground(Color.green);

        Squares.get(44).setBackground(Color.red);
        Squares.get(45).setBackground(Color.red);
        Squares.get(46).setBackground(Color.red);
        Squares.get(47).setBackground(Color.red);
        btnOyna.setEnabled(false);

        Slider = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {

                        // Surekli calisarak zar atildiktan sonra ki kontrolu sagliyor. 
                        Thread.sleep(300);

                        sıraKontrol();
                        kazanmaKontrol();
                        if (zar.isEnabled()) {
                            jL_Sira.setVisible(true);

                        } else {
                            jL_Sira.setVisible(false);
                        }
                        if (btnOyna.isEnabled()) {
                            jLabel1.setVisible(true);

                        } else {
                            jLabel1.setVisible(false);
                        }
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Scene.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        });

    }

    public void kazanmaKontrol() {
        if (control == 0 && RedSquare1.getBackground() == Color.red && RedSquare2.getBackground() == Color.red && RedSquare3.getBackground() == Color.red && RedSquare4.getBackground() == Color.red) {
            control++;
            JOptionPane.showMessageDialog(game, "KIRMIZI KAZANDI!.");

        }
        if (control == 0 && GreenSquare.getBackground() == Color.green && GreenSquare1.getBackground() == Color.green && GreenSquare2.getBackground() == Color.green && GreenSquare3.getBackground() == Color.green) {
            control++;
            JOptionPane.showMessageDialog(game, "YEŞİL KAZANDI!.");
        }
    }

    public void sıraKontrol() {
        if (DiceCounter % 2 == 1) {
            side = "red";
            jLSide.setText("Side = RED ");
            jLSide.setBackground(Color.red);

        } else {
            side = "green";
            jLSide.setText("Side = GREEN ");
            jLSide.setBackground(Color.green);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        yol1 = new javax.swing.JLabel();
        yol40 = new javax.swing.JLabel();
        yol39 = new javax.swing.JLabel();
        yol2 = new javax.swing.JLabel();
        yol38 = new javax.swing.JLabel();
        yol3 = new javax.swing.JLabel();
        yol37 = new javax.swing.JLabel();
        yol4 = new javax.swing.JLabel();
        yol36 = new javax.swing.JLabel();
        yol11 = new javax.swing.JLabel();
        yol10 = new javax.swing.JLabel();
        yol9 = new javax.swing.JLabel();
        yol12 = new javax.swing.JLabel();
        RedSquare4 = new javax.swing.JLabel();
        yol8 = new javax.swing.JLabel();
        yol13 = new javax.swing.JLabel();
        RedSquare3 = new javax.swing.JLabel();
        yol7 = new javax.swing.JLabel();
        yol14 = new javax.swing.JLabel();
        RedSquare2 = new javax.swing.JLabel();
        yol6 = new javax.swing.JLabel();
        yol15 = new javax.swing.JLabel();
        RedSquare1 = new javax.swing.JLabel();
        yol5 = new javax.swing.JLabel();
        yol16 = new javax.swing.JLabel();
        yol24 = new javax.swing.JLabel();
        yol17 = new javax.swing.JLabel();
        yol23 = new javax.swing.JLabel();
        yol18 = new javax.swing.JLabel();
        yol22 = new javax.swing.JLabel();
        yol19 = new javax.swing.JLabel();
        yol20 = new javax.swing.JLabel();
        yol21 = new javax.swing.JLabel();
        yol25 = new javax.swing.JLabel();
        GreenSquare = new javax.swing.JLabel();
        yol35 = new javax.swing.JLabel();
        yol26 = new javax.swing.JLabel();
        GreenSquare1 = new javax.swing.JLabel();
        yol34 = new javax.swing.JLabel();
        yol27 = new javax.swing.JLabel();
        GreenSquare2 = new javax.swing.JLabel();
        yol33 = new javax.swing.JLabel();
        yol28 = new javax.swing.JLabel();
        GreenSquare3 = new javax.swing.JLabel();
        yol32 = new javax.swing.JLabel();
        yol29 = new javax.swing.JLabel();
        yol30 = new javax.swing.JLabel();
        yol31 = new javax.swing.JLabel();
        PiyonGreen1 = new javax.swing.JLabel();
        PiyonGreen2 = new javax.swing.JLabel();
        PiyonGreen3 = new javax.swing.JLabel();
        PiyonGreen4 = new javax.swing.JLabel();
        PiyonRed1 = new javax.swing.JLabel();
        PiyonRed2 = new javax.swing.JLabel();
        PiyonRed3 = new javax.swing.JLabel();
        PiyonRed4 = new javax.swing.JLabel();
        zar = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jL_Sira = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnOyna = new javax.swing.JButton();
        jLSide = new javax.swing.JLabel();
        ZarCounter = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ludo");
        setBackground(new java.awt.Color(204, 255, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        yol1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yol1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        yol1.setOpaque(true);
        getContentPane().add(yol1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 400, 20, 18));

        yol40.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        yol40.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        yol40.setOpaque(true);
        getContentPane().add(yol40, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 400, 20, 18));

        yol39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yol39.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        yol39.setOpaque(true);
        getContentPane().add(yol39, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 400, 20, 18));

        yol2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yol2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        yol2.setOpaque(true);
        getContentPane().add(yol2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 370, 20, 18));

        yol38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yol38.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        yol38.setOpaque(true);
        getContentPane().add(yol38, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 370, 20, 18));

        yol3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yol3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        yol3.setOpaque(true);
        getContentPane().add(yol3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, 20, 18));

        yol37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yol37.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        yol37.setOpaque(true);
        getContentPane().add(yol37, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, 20, 18));

        yol4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yol4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        yol4.setOpaque(true);
        getContentPane().add(yol4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, 20, 18));

        yol36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yol36.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        yol36.setOpaque(true);
        getContentPane().add(yol36, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, 20, 18));

        yol11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yol11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        yol11.setOpaque(true);
        getContentPane().add(yol11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 20, 18));

        yol10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yol10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        yol10.setOpaque(true);
        getContentPane().add(yol10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 20, 18));

        yol9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yol9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        yol9.setOpaque(true);
        getContentPane().add(yol9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 20, 18));

        yol12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yol12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        yol12.setOpaque(true);
        getContentPane().add(yol12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 20, 18));

        RedSquare4.setBackground(new java.awt.Color(0, 0, 0));
        RedSquare4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RedSquare4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        RedSquare4.setOpaque(true);
        getContentPane().add(RedSquare4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 20, 18));

        yol8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yol8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        yol8.setOpaque(true);
        getContentPane().add(yol8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 20, 18));

        yol13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yol13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        yol13.setOpaque(true);
        getContentPane().add(yol13, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 20, 18));

        RedSquare3.setBackground(new java.awt.Color(0, 0, 0));
        RedSquare3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RedSquare3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        RedSquare3.setOpaque(true);
        getContentPane().add(RedSquare3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 20, 18));

        yol7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yol7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        yol7.setOpaque(true);
        getContentPane().add(yol7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 20, 18));

        yol14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yol14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        yol14.setOpaque(true);
        getContentPane().add(yol14, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 20, 18));

        RedSquare2.setBackground(new java.awt.Color(0, 0, 0));
        RedSquare2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RedSquare2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        RedSquare2.setOpaque(true);
        getContentPane().add(RedSquare2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 20, 18));

        yol6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yol6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        yol6.setOpaque(true);
        getContentPane().add(yol6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 20, 18));

        yol15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yol15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        yol15.setOpaque(true);
        getContentPane().add(yol15, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 20, 18));

        RedSquare1.setBackground(new java.awt.Color(0, 0, 0));
        RedSquare1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RedSquare1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        RedSquare1.setOpaque(true);
        getContentPane().add(RedSquare1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, 20, 18));

        yol5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yol5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        yol5.setOpaque(true);
        getContentPane().add(yol5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, 20, 18));

        yol16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yol16.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        yol16.setOpaque(true);
        getContentPane().add(yol16, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 20, 18));

        yol24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yol24.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        yol24.setOpaque(true);
        getContentPane().add(yol24, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 20, 18));

        yol17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yol17.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        yol17.setOpaque(true);
        getContentPane().add(yol17, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 20, 18));

        yol23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yol23.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        yol23.setOpaque(true);
        getContentPane().add(yol23, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, 20, 18));

        yol18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yol18.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        yol18.setOpaque(true);
        getContentPane().add(yol18, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 20, 18));

        yol22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yol22.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        yol22.setOpaque(true);
        getContentPane().add(yol22, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 20, 18));

        yol19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yol19.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        yol19.setOpaque(true);
        getContentPane().add(yol19, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 20, 18));

        yol20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yol20.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        yol20.setOpaque(true);
        getContentPane().add(yol20, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 20, 18));

        yol21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yol21.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        yol21.setOpaque(true);
        getContentPane().add(yol21, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, 20, 18));

        yol25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yol25.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        yol25.setOpaque(true);
        getContentPane().add(yol25, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, 20, 18));

        GreenSquare.setBackground(new java.awt.Color(0, 0, 0));
        GreenSquare.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GreenSquare.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        GreenSquare.setOpaque(true);
        getContentPane().add(GreenSquare, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 220, 20, 18));

        yol35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yol35.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        yol35.setOpaque(true);
        getContentPane().add(yol35, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 260, 20, 18));

        yol26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yol26.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        yol26.setOpaque(true);
        getContentPane().add(yol26, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 180, 20, 18));

        GreenSquare1.setBackground(new java.awt.Color(0, 0, 0));
        GreenSquare1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GreenSquare1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        GreenSquare1.setOpaque(true);
        getContentPane().add(GreenSquare1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 220, 20, 18));

        yol34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yol34.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        yol34.setOpaque(true);
        getContentPane().add(yol34, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 260, 20, 18));

        yol27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yol27.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        yol27.setOpaque(true);
        getContentPane().add(yol27, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 180, 20, 18));

        GreenSquare2.setBackground(new java.awt.Color(0, 0, 0));
        GreenSquare2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GreenSquare2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        GreenSquare2.setOpaque(true);
        getContentPane().add(GreenSquare2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 220, 20, 18));

        yol33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yol33.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        yol33.setOpaque(true);
        getContentPane().add(yol33, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 260, 20, 18));

        yol28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yol28.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        yol28.setOpaque(true);
        getContentPane().add(yol28, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 180, 20, 18));

        GreenSquare3.setBackground(new java.awt.Color(0, 0, 0));
        GreenSquare3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GreenSquare3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        GreenSquare3.setOpaque(true);
        getContentPane().add(GreenSquare3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 220, 20, 18));

        yol32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yol32.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        yol32.setOpaque(true);
        getContentPane().add(yol32, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 260, 20, 18));

        yol29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yol29.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        yol29.setOpaque(true);
        getContentPane().add(yol29, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 180, 20, 18));

        yol30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yol30.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        yol30.setOpaque(true);
        getContentPane().add(yol30, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 220, 20, 18));

        yol31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yol31.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        yol31.setOpaque(true);
        getContentPane().add(yol31, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 260, 20, 18));

        PiyonGreen1.setForeground(new java.awt.Color(255, 255, 255));
        PiyonGreen1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PiyonGreen1.setText("1");
        PiyonGreen1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(PiyonGreen1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 350, 20, 18));

        PiyonGreen2.setForeground(new java.awt.Color(255, 255, 255));
        PiyonGreen2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PiyonGreen2.setText("2");
        PiyonGreen2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(PiyonGreen2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 350, 20, 18));

        PiyonGreen3.setForeground(new java.awt.Color(255, 255, 255));
        PiyonGreen3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PiyonGreen3.setText("3");
        PiyonGreen3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(PiyonGreen3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 430, 20, 18));

        PiyonGreen4.setForeground(new java.awt.Color(255, 255, 255));
        PiyonGreen4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PiyonGreen4.setText("4");
        PiyonGreen4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(PiyonGreen4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 430, 20, 18));

        PiyonRed1.setForeground(new java.awt.Color(255, 255, 255));
        PiyonRed1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PiyonRed1.setText("1");
        PiyonRed1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(PiyonRed1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 20, 18));

        PiyonRed2.setForeground(new java.awt.Color(255, 255, 255));
        PiyonRed2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PiyonRed2.setText("2");
        PiyonRed2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(PiyonRed2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 20, 18));

        PiyonRed3.setForeground(new java.awt.Color(255, 255, 255));
        PiyonRed3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PiyonRed3.setText("3");
        PiyonRed3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(PiyonRed3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 20, 18));

        PiyonRed4.setForeground(new java.awt.Color(255, 255, 255));
        PiyonRed4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PiyonRed4.setText("4");
        PiyonRed4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(PiyonRed4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 20, 18));

        zar.setBackground(new java.awt.Color(255, 153, 255));
        zar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ozkan\\Desktop\\pngwing.com.png")); // NOI18N
        zar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        zar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zarActionPerformed(evt);
            }
        });
        getContentPane().add(zar, new org.netbeans.lib.awtextra.AbsoluteConstraints(617, 15, 120, 80));

        jRadioButton1.setBackground(new java.awt.Color(0, 255, 204));
        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("jRadioButton1");
        jRadioButton1.setOpaque(false);
        getContentPane().add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 22, 20));

        jRadioButton2.setBackground(new java.awt.Color(0, 255, 204));
        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("jRadioButton2");
        jRadioButton2.setOpaque(false);
        getContentPane().add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 21, 20));

        jRadioButton3.setBackground(new java.awt.Color(0, 255, 204));
        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("jRadioButton3");
        jRadioButton3.setOpaque(false);
        getContentPane().add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 19, -1));

        jRadioButton4.setBackground(new java.awt.Color(0, 255, 204));
        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("jRadioButton4");
        jRadioButton4.setOpaque(false);
        getContentPane().add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 20, -1));

        jRadioButton5.setBackground(new java.awt.Color(0, 255, 204));
        buttonGroup2.add(jRadioButton5);
        jRadioButton5.setText("jRadioButton5");
        jRadioButton5.setOpaque(false);
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 380, 19, -1));

        jRadioButton6.setBackground(new java.awt.Color(0, 255, 204));
        buttonGroup2.add(jRadioButton6);
        jRadioButton6.setText("jRadioButton5");
        jRadioButton6.setOpaque(false);
        getContentPane().add(jRadioButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 380, 19, -1));

        jRadioButton7.setBackground(new java.awt.Color(0, 255, 204));
        buttonGroup2.add(jRadioButton7);
        jRadioButton7.setText("jRadioButton5");
        jRadioButton7.setOpaque(false);
        jRadioButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 460, 19, -1));

        jRadioButton8.setBackground(new java.awt.Color(0, 255, 204));
        buttonGroup2.add(jRadioButton8);
        jRadioButton8.setText("jRadioButton5");
        jRadioButton8.setOpaque(false);
        getContentPane().add(jRadioButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 460, 19, -1));

        jL_Sira.setBackground(new java.awt.Color(255, 102, 102));
        jL_Sira.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jL_Sira.setText("Lütfen Zar Atınız!");
        jL_Sira.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jL_Sira.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jL_Sira.setOpaque(true);
        getContentPane().add(jL_Sira, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 110, 120, 20));

        jPanel1.setBackground(new java.awt.Color(204, 0, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnOyna.setBackground(new java.awt.Color(255, 204, 255));
        btnOyna.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnOyna.setText("OYNA");
        btnOyna.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOyna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOynaActionPerformed(evt);
            }
        });
        jPanel1.add(btnOyna, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, 30));

        jLSide.setBackground(new java.awt.Color(255, 153, 153));
        jLSide.setForeground(new java.awt.Color(255, 255, 255));
        jLSide.setText("Taraf :");
        jLSide.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLSide.setOpaque(true);
        jPanel1.add(jLSide, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 95, 20));

        ZarCounter.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ZarCounter.setForeground(new java.awt.Color(255, 255, 255));
        ZarCounter.setText("ZAR");
        jPanel1.add(ZarCounter, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, 38, 18));

        jLabel1.setBackground(new java.awt.Color(255, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lütfen Oynayınız!");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 450, 100, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ozkan\\Desktop\\a039b44f7a3a4aeeade2f5a8a2456e14.jpg")); // NOI18N
        jLabel2.setToolTipText("");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 570));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 540));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void zarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zarActionPerformed
        // TODO add your handling code here:
        Random rand = new Random();
        int n = rand.nextInt(1);
        n = n + 6;
        ZarCounter.setText(String.valueOf(n));
        DiceCounter++;

        if (DiceCounter % 2 == 1) {
            side = "red";
            jLSide.setText("Side = RED ");
            jLSide.setBackground(Color.red);

            Message msg = new Message(Message.Message_Type.ZarDurumu);
            msg.content = DiceCounter;
            Client.Send(msg);
        } else {
            side = "green";
            jLSide.setText("Side = GREEN ");
            jLSide.setBackground(Color.green);

            Message msg = new Message(Message.Message_Type.ZarDurumu);
            msg.content = DiceCounter;
            Client.Send(msg);
        }
//        Message msg = new Message(Message.Message_Type.ZarDurumu);
//        msg.content = DiceCounter;
//        Client.Send(msg);

        btnOyna.setEnabled(true);
        zar.setEnabled(false);

    }//GEN-LAST:event_zarActionPerformed
    public int TempKontrol(int n) {
        if (n > 39) {
            return n % 40;
        }
        return n;
    }

    public boolean FinishKontrol(int n) {
        if (n > 39) {
            return true;
        }
        return false;
    }

    public static void SetRedSquare() {
        RedSquare1.setBackground(Color.red);

    }

    public void ReadFromServer(Message msg) {
        // Clientler arası mesajalşma fonksiyonu
        /* array listin 0. elemanini control eder ve hangi piyon oldugunu tespit eder.
         Sonrasında 1. elemani ile tempini alarak nereye gidecegini belirler.*/

        ArrayList<Integer> content = (ArrayList<Integer>) msg.content;

        if (side == "red") {
            if (enemyTemp == -1 && content.get(0) == 0) {

                Squares.get(content.get(1)).setBackground(Color.red);
                enemyTemp = content.get(1);
                Squares.get(44 + content.get(0)).setBackground(null);
                System.out.println(content.get(1));

            } else if (enemyTemp1 == -1 && content.get(0) == 1) {

                if (Squares.get(content.get(1)).getBackground() == Color.red) {
                    System.out.println("hatalı oynadın");
                } else if (Squares.get(content.get(1)).getBackground() == Color.green) {
                    System.out.println("hata");
                } else {
                    Squares.get(content.get(1)).setBackground(Color.red);
                    enemyTemp1 = content.get(1);
                    Squares.get(44 + content.get(0)).setBackground(null);
                    System.out.println(content.get(1));
                }
            } else if (enemyTemp2 == -1 && content.get(0) == 2) {

                if (Squares.get(content.get(1)).getBackground() == Color.red) {
                    System.out.println("hatalı oynadın");
                } else if (Squares.get(content.get(1)).getBackground() == Color.green) {
                    System.out.println("hata");
                } else {

                    Squares.get(content.get(1)).setBackground(Color.red);
                    enemyTemp2 = content.get(1);
                    Squares.get(44 + content.get(0)).setBackground(null);
                    System.out.println(content.get(1));
                }
            } else if (enemyTemp3 == -1 && content.get(0) == 3) {

                if (Squares.get(content.get(1)).getBackground() == Color.red) {
                    System.out.println("hatalı oynadın");
                } else if (Squares.get(content.get(1)).getBackground() == Color.green) {
                    System.out.println("hata");
                } else {
                    Squares.get(content.get(1)).setBackground(Color.red);
                    enemyTemp3 = content.get(1);
                    Squares.get(44 + content.get(0)).setBackground(null);
                    System.out.println(content.get(1));
                }
            } else if (enemyTemp != -1 && content.get(0) == 0) {

                if (Squares.get(content.get(1)).getBackground() == Color.red) {
                    System.out.println("hatalı oynadın");
                } else if (Squares.get(content.get(1)).getBackground() == Color.green) {
                    System.out.println("hata");
                } else {
                    Squares.get(enemyTemp).setBackground(null);
                    TempKontrol(content.get(1));
                    enemyTemp = content.get(1);
                    Squares.get(content.get(1)).setBackground(Color.red);
                    int piyonKontrol = (content.get(2));
                    if (FinishKontrol(piyonKontrol)) {
                        Squares.get(content.get(1)).setBackground(null);
                        if (content.get(0) == 0) {
                            RedSquare1.setBackground(Color.red);
                        }
                    }
                }

            } else if (enemyTemp1 != -1 && content.get(0) == 1) {

                if (Squares.get(content.get(1)).getBackground() == Color.red) {
                    System.out.println("hatalı oynadın");
                } else if (Squares.get(content.get(1)).getBackground() == Color.green) {
                    System.out.println("hata");
                } else {
                    Squares.get(enemyTemp1).setBackground(null);
                    TempKontrol(content.get(1));
                    enemyTemp1 = content.get(1);
                    Squares.get(content.get(1)).setBackground(Color.red);
                    int piyonKontrol = (content.get(2));
                    if (FinishKontrol(piyonKontrol)) {
                        Squares.get(content.get(1)).setBackground(null);
                        if (content.get(0) == 1) {
                            RedSquare2.setBackground(Color.red);
                        }
                    }
                }

            } else if (enemyTemp2 != -1 && content.get(0) == 2) {

                if (Squares.get(content.get(1)).getBackground() == Color.red) {
                    System.out.println("hatalı oynadın");
                } else if (Squares.get(content.get(1)).getBackground() == Color.green) {
                    System.out.println("hata");
                } else {
                    Squares.get(enemyTemp2).setBackground(null);
                    TempKontrol(content.get(1));
                    enemyTemp2 = content.get(1);
                    Squares.get(content.get(1)).setBackground(Color.red);
                    int piyonKontrol = (content.get(2));
                    if (FinishKontrol(piyonKontrol)) {
                        Squares.get(content.get(1)).setBackground(null);
                        if (content.get(0) == 2) {
                            RedSquare3.setBackground(Color.red);
                        }
                    }
                }

            } else if (enemyTemp3 != -1 && content.get(0) == 3) {

                if (Squares.get(content.get(1)).getBackground() == Color.red) {
                    System.out.println("hatalı oynadın");
                } else if (Squares.get(content.get(1)).getBackground() == Color.green) {
                    System.out.println("hata");
                } else {
                    Squares.get(enemyTemp3).setBackground(null);
                    TempKontrol(content.get(1));
                    enemyTemp3 = content.get(1);
                    Squares.get(content.get(1)).setBackground(Color.red);
                    int piyonKontrol = (content.get(2));
                    if (FinishKontrol(piyonKontrol)) {
                        Squares.get(content.get(1)).setBackground(null);
                        if (content.get(0) == 3) {
                            RedSquare4.setBackground(Color.red);
                        }
                    }
                }

            }

        }
        if (side == "green") {

            if (enemyTemp4 == -1 && content.get(0) == 4) {
                Squares.get(content.get(1)).setBackground(Color.green);
                enemyTemp4 = content.get(1);
                Squares.get(36 + content.get(0)).setBackground(null);
                System.out.println(content.get(1));

            } else if (enemyTemp5 == -1 && content.get(0) == 5) {

                if (Squares.get(TempKontrol(content.get(1))).getBackground() == Color.red) {
                    System.out.println("hatalı oynadın");
                } else if (Squares.get((TempKontrol(content.get(1)))).getBackground() == Color.green) {
                    System.out.println("hata");
                } else {
                    Squares.get(content.get(1)).setBackground(Color.green);
                    enemyTemp5 = content.get(1);
                    Squares.get(36 + content.get(0)).setBackground(null);
                    System.out.println(content.get(1));
                }
            } else if (enemyTemp6 == -1 && content.get(0) == 6) {

                if (Squares.get((TempKontrol(content.get(1)))).getBackground() == Color.red) {
                    System.out.println("hatalı oynadın");
                } else if (Squares.get((TempKontrol(content.get(1)))).getBackground() == Color.green) {
                    System.out.println("hata");
                } else {
                    Squares.get(content.get(1)).setBackground(Color.green);
                    enemyTemp6 = content.get(1);
                    Squares.get(36 + content.get(0)).setBackground(null);
                    System.out.println(content.get(1));
                }
            } else if (enemyTemp7 == -1 && content.get(0) == 7) {

                if (Squares.get((TempKontrol(content.get(1)))).getBackground() == Color.red) {
                    System.out.println("hatalı oynadın");
                } else if (Squares.get((TempKontrol(content.get(1)))).getBackground() == Color.green) {
                    System.out.println("hata");
                } else {
                    Squares.get(content.get(1)).setBackground(Color.green);
                    enemyTemp7 = content.get(1);
                    Squares.get(36 + content.get(0)).setBackground(null);
                    System.out.println(content.get(1));
                }
            } else if (enemyTemp4 != -1 && content.get(0) == 4) {

                if (Squares.get((TempKontrol(content.get(1)))).getBackground() == Color.red) {
                    System.out.println("hatalı oynadın");
                } else if (Squares.get((TempKontrol(content.get(1)))).getBackground() == Color.green) {
                    System.out.println("hata");
                } else {
                    Squares.get(enemyTemp4).setBackground(null);
                    TempKontrol(content.get(1));
                    enemyTemp4 = content.get(1);
                    Squares.get(content.get(1)).setBackground(Color.green);
                    int piyonKontrol = (content.get(2));
                    if (FinishKontrol(piyonKontrol)) {
                        Squares.get(content.get(1)).setBackground(null);
                        if (content.get(0) == 4) {
                            GreenSquare.setBackground(Color.green);
                        }
                    }
                }

            } else if (enemyTemp5 != -1 && content.get(0) == 5) {

                if (Squares.get(content.get(1)).getBackground() == Color.red) {
                    System.out.println("hatalı oynadın");
                } else if (Squares.get(content.get(1)).getBackground() == Color.green) {
                    System.out.println("hata");
                } else {
                    Squares.get(enemyTemp5).setBackground(null);
                    TempKontrol(content.get(1));
                    enemyTemp5 = content.get(1);
                    Squares.get(content.get(1)).setBackground(Color.green);
                    int piyonKontrol = (content.get(2));
                    if (FinishKontrol(piyonKontrol)) {
                        Squares.get(content.get(1)).setBackground(null);
                        if (content.get(0) == 5) {
                            GreenSquare1.setBackground(Color.green);
                        }
                    }
                }

            } else if (enemyTemp6 != -1 && content.get(0) == 6) {

                if (Squares.get(content.get(1)).getBackground() == Color.red) {
                    System.out.println("hatalı oynadın");
                } else if (Squares.get(content.get(1)).getBackground() == Color.green) {
                    System.out.println("hata");
                } else {
                    Squares.get(enemyTemp6).setBackground(null);
                    TempKontrol(content.get(1));
                    enemyTemp6 = content.get(1);
                    Squares.get(content.get(1)).setBackground(Color.green);
                    int piyonKontrol = (content.get(2));
                    if (FinishKontrol(piyonKontrol)) {
                        Squares.get(content.get(1)).setBackground(null);
                        if (content.get(0) == 6) {
                            GreenSquare2.setBackground(Color.green);
                        }
                    }
                }

            } else if (enemyTemp7 != -1 && content.get(0) == 7) {

                if (Squares.get(content.get(1)).getBackground() == Color.red) {
                    System.out.println("hatalı oynadın");
                } else if (Squares.get(content.get(1)).getBackground() == Color.green) {
                    System.out.println("hata");
                } else {
                    Squares.get(enemyTemp7).setBackground(null);
                    TempKontrol(content.get(1));
                    enemyTemp7 = content.get(1);
                    Squares.get(content.get(1)).setBackground(Color.green);
                    int piyonKontrol = (content.get(2));
                    if (FinishKontrol(piyonKontrol)) {
                        Squares.get(content.get(1)).setBackground(null);
                        if (content.get(0) == 7) {
                            GreenSquare3.setBackground(Color.green);
                        }
                    }
                }

            }
        }
    }

    private void Gonder(int n, int temp) {
        // cliente data gonderilir 
        Message msg = new Message(Message.Message_Type.Send);
        ArrayList<Integer> Info = new ArrayList();
        Info.add(n);
        Info.add(temp);
        msg.content = Info;

        Client.Send(msg);
    }

    private void Gonder(int n, int temp, int piyon) {
        // cliente data gonderilir fonksiyon override olmustur.
        Message msg = new Message(Message.Message_Type.Send);
        ArrayList<Integer> Info = new ArrayList();
        Info.add(n);
        Info.add(temp);
        Info.add(piyon);
        msg.content = Info;

        Client.Send(msg);
    }

    /*
    private void KontrolYesil(int n) {
        if (Squares.get(n).getBackground() == Color.green) {
            Squares.get(40).setBackground(Color.green);
            dolduMu5 = false;
        }
    }

    private void KontrolKirmizi(int n) {
        if (Squares.get(n).getBackground() == Color.red) {
            Squares.get(44).setBackground(Color.red);
            dolduMu1 = false;
        }
    }

    private void KontrolCiftKirmizi(int n) {
        if (Squares.get(n).getBackground() == Color.red) {
            Squares.get(n + 1).setBackground(Color.red);

        }
    }
     */
    private void btnOynaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOynaActionPerformed
        /* side'a (Tarafa) gore islemleri gerceklestiren yerdir. 
         Red ve Green olmak uzere 2 side vardır.
         Zar 6 gelene kadar atilir ve 6 gelince piyon çıkıs yapabilir. 
         Her iki tarafın da piyonları ortadaki 4 adet belirlenmiş yerlerine ulaşmaya çalışır.
         Gerekli kontrolelr burada yapılır. 
         her piyona sayac tanımlanmıştır ve tam turu tamamlama işlemleri kontrol edilir.*/

        int zar = Integer.valueOf(ZarCounter.getText());
        if (side == "red") {

            if (zar == 6) {

                if (jRadioButton1.isSelected() && PiyonSeciliMi == 0 && dolduMu1 == false) {
                    temp = 10;
                    Squares.get(44).setBackground(null);
                    Squares.get(temp).setBackground(Color.red);
                    Squares.get(temp).setText("1");
                    PiyonSeciliMi++;
                    dolduMu1 = true;
                    Gonder(0, temp, piyon1);

                } else if (jRadioButton2.isSelected() && PiyonSeciliMi == 1 && dolduMu2 == false) {
                    temp1 = 10;
                    if (Squares.get(temp1).getBackground() == Color.red) {
                        JOptionPane.showMessageDialog(game, "Piyon Piyonun Üstüne Gelemez. Yanlış Hamle!");
                    } else if (Squares.get(temp1).getBackground() == Color.green) {
                        JOptionPane.showMessageDialog(game, "Piyon Piyonun Üstüne Gelemez. Yanlış Hamle!");
                    } else {
                        Squares.get(45).setBackground(null);
                        Squares.get(temp1).setBackground(Color.red);
                        Squares.get(temp1).setText("2");
                        PiyonSeciliMi++;
                        dolduMu2 = true;
                        Gonder(1, temp1, piyon2);
                    }
                } else if (jRadioButton3.isSelected() && PiyonSeciliMi == 2 && dolduMu3 == false) {
                    temp2 = 10;
                    if (Squares.get(temp2).getBackground() == Color.red) {
                        JOptionPane.showMessageDialog(game, "Piyon Piyonun Üstüne Gelemez. Yanlış Hamle!");
                    } else if (Squares.get(temp2).getBackground() == Color.green) {
                        JOptionPane.showMessageDialog(game, "Piyon Piyonun Üstüne Gelemez. Yanlış Hamle!");
                    } else {
                        Squares.get(46).setBackground(null);
                        Squares.get(temp2).setBackground(Color.red);
                        Squares.get(temp2).setText("3");
                        PiyonSeciliMi++;
                        dolduMu3 = true;
                        Gonder(2, temp2, piyon3);
                    }
                } else if (jRadioButton4.isSelected() && PiyonSeciliMi == 3 && dolduMu4 == false) {
                    temp3 = 10;
                    if (Squares.get(temp3).getBackground() == Color.red) {
                        JOptionPane.showMessageDialog(game, "Piyon Piyonun Üstüne Gelemez. Yanlış Hamle!");
                    } else if (Squares.get(temp3).getBackground() == Color.green) {
                        JOptionPane.showMessageDialog(game, "Piyon Piyonun Üstüne Gelemez. Yanlış Hamle!");
                    } else {

                        Squares.get(47).setBackground(null);
                        Squares.get(temp3).setBackground(Color.red);
                        Squares.get(temp3).setText("4");
                        PiyonSeciliMi++;
                        dolduMu4 = true;
                        Gonder(3, temp3, piyon4);
                    }
                } // ilk kez 6 gelip ardindan bir daha 6 ile oynamak istenilen yer 
                else {
                    if (jRadioButton1.isSelected() && dolduMu1 == true) {
                        if (Squares.get(TempKontrol(temp + zar)).getBackground() == Color.red) {
                            JOptionPane.showMessageDialog(game, "Piyon Piyonun Üstüne Gelemez. Yanlış Hamle!!");
                        } else if (Squares.get(TempKontrol(temp + zar)).getBackground() == Color.green) {
                            JOptionPane.showMessageDialog(game, "Piyon Piyonun Üstüne Gelemez. Yanlış Hamle!");
                        } else {
                            Squares.get(temp).setBackground(null);
                            Squares.get(temp).setText(null);
                            piyon1 += zar;
                            temp = temp + zar;
                            temp = TempKontrol(temp);
                            Squares.get(temp).setBackground(Color.red);
                            Squares.get(temp).setText("1");
                            if (FinishKontrol(piyon1)) {
                                Squares.get(temp).setBackground(null);
                                RedSquare1.setBackground(Color.red);
                                Squares.get(temp).setText(null);
                            }
                            Gonder(0, temp, piyon1);
                        }
                    } else if (jRadioButton2.isSelected() && dolduMu2 == true) {
                        if (Squares.get(TempKontrol(temp1 + zar)).getBackground() == Color.red) {
                            JOptionPane.showMessageDialog(game, "Piyon Piyonun Üstüne Gelemez. Yanlış Hamle!");
                        } else if (Squares.get(TempKontrol(temp1 + zar)).getBackground() == Color.green) {
                            JOptionPane.showMessageDialog(game, "Piyon Piyonun Üstüne Gelemez. Yanlış Hamle!");
                        } else {
                            Squares.get(temp1).setBackground(null);
                            Squares.get(temp1).setText(null);
                            piyon2 += zar;
                            temp1 = temp1 + zar;
                            temp1 = TempKontrol(temp1);
                            Squares.get(temp1).setBackground(Color.red);
                            Squares.get(temp1).setText("2");
                            if (FinishKontrol(piyon2)) {
                                Squares.get(temp1).setBackground(null);
                                RedSquare2.setBackground(Color.red);
                                Squares.get(temp1).setText(null);
                            }
                            Gonder(1, temp1, piyon2);
                        }
                    } else if (jRadioButton3.isSelected() && dolduMu3 == true) {
                        if (Squares.get(TempKontrol(temp2 + zar)).getBackground() == Color.red) {
                            JOptionPane.showMessageDialog(game, "Piyon Piyonun Üstüne Gelemez. Yanlış Hamle!");
                        } else if (Squares.get(TempKontrol(temp2 + zar)).getBackground() == Color.green) {
                            JOptionPane.showMessageDialog(game, "Piyon Piyonun Üstüne Gelemez. Yanlış Hamle!");
                        } else {
                            Squares.get(temp2).setBackground(null);
                            Squares.get(temp2).setText(null);
                            piyon3 += zar;
                            temp2 = temp2 + zar;
                            temp2 = TempKontrol(temp2);
                            Squares.get(temp2).setBackground(Color.red);
                            Squares.get(temp2).setText("3");

                            if (FinishKontrol(piyon3)) {
                                Squares.get(temp2).setBackground(null);
                                RedSquare3.setBackground(Color.red);
                                Squares.get(temp2).setText(null);
                            }
                            Gonder(2, temp2, piyon3);
                        }
                    } else if (jRadioButton4.isSelected() && dolduMu4 == true) {
                        if (Squares.get(TempKontrol(temp3 + zar)).getBackground() == Color.red) {
                            JOptionPane.showMessageDialog(game, "Piyon Piyonun Üstüne Gelemez. Yanlış Hamle!");
                        } else if (Squares.get(TempKontrol(temp3 + zar)).getBackground() == Color.green) {
                            JOptionPane.showMessageDialog(game, "Piyon Piyonun Üstüne Gelemez. Yanlış Hamle!");
                        } else {
                            Squares.get(temp3).setBackground(null);
                            Squares.get(temp3).setText(null);
                            piyon4 += zar;
                            temp3 = temp3 + zar;
                            temp3 = TempKontrol(temp3);
                            Squares.get(temp3).setBackground(Color.red);
                            Squares.get(temp3).setText("4");
                            if (FinishKontrol(piyon4)) {
                                Squares.get(temp3).setBackground(null);
                                Squares.get(temp3).setText(null);
                                RedSquare4.setBackground(Color.red);
                            }
                            Gonder(3, temp3, piyon4);
                        }
                    }

                }

            } // 6 dan baska zar gelirse islemin gerceklestigi yer 
            else {
                if (jRadioButton1.isSelected() && dolduMu1 == true) {
                    if (Squares.get(TempKontrol(temp + zar)).getBackground() == Color.red) { //  || Squares.get(TempKontrol(temp + zar)).getBackground() == Color.green
                        JOptionPane.showMessageDialog(game, "Piyon Piyonun Üstüne Gelemez. Yanlış Hamle!");
                    } else if (Squares.get(TempKontrol(temp + zar)).getBackground() == Color.green) {
                        JOptionPane.showMessageDialog(game, "Piyon Piyonun Üstüne Gelemez. Yanlış Hamle!");
                    } else {
                        Squares.get(temp).setBackground(null);
                        Squares.get(temp).setText(null);
                        piyon1 += zar;
                        temp = temp + zar;
                        temp = TempKontrol(temp);
                        Squares.get(temp).setBackground(Color.red);
                        Squares.get(temp).setText("1");
                        if (FinishKontrol(piyon1)) {
                            Squares.get(temp).setBackground(null);
                            Squares.get(temp).setText(null);
                            RedSquare1.setBackground(Color.red);
                        }

                        Gonder(0, temp, piyon1);
                    }
                } else if (jRadioButton2.isSelected() && dolduMu2 == true) {
                    if (Squares.get(TempKontrol(temp1 + zar)).getBackground() == Color.red) {
                        JOptionPane.showMessageDialog(game, "Piyon Piyonun Üstüne Gelemez. Yanlış Hamle!");
                    } else if (Squares.get(TempKontrol(temp1 + zar)).getBackground() == Color.green) {
                        JOptionPane.showMessageDialog(game, "Piyon Piyonun Üstüne Gelemez. Yanlış Hamle!");
                    } else {

                        Squares.get(temp1).setBackground(null);
                        Squares.get(temp1).setText(null);
                        piyon2 += zar;
                        temp1 = temp1 + zar;
                        temp1 = TempKontrol(temp1);
                        Squares.get(temp1).setBackground(Color.red);
                        Squares.get(temp1).setText("2");
                        if (FinishKontrol(piyon2)) {
                            Squares.get(temp1).setBackground(null);
                            RedSquare2.setBackground(Color.red);
                            Squares.get(temp1).setText(null);
                        }
                        Gonder(1, temp1, piyon2);
                    }
                } else if (jRadioButton3.isSelected() && dolduMu3 == true) {
                    if (Squares.get(TempKontrol(temp2 + zar)).getBackground() == Color.red) {
                        JOptionPane.showMessageDialog(game, "Piyon Piyonun Üstüne Gelemez. Yanlış Hamle!");
                    } else if (Squares.get(TempKontrol(temp2 + zar)).getBackground() == Color.green) {
                        JOptionPane.showMessageDialog(game, "Piyon Piyonun Üstüne Gelemez. Yanlış Hamle!");
                    } else {
                        Squares.get(temp2).setBackground(null);
                        Squares.get(temp2).setText(null);
                        piyon3 += zar;
                        temp2 = temp2 + zar;
                        temp2 = TempKontrol(temp2);
                        Squares.get(temp2).setBackground(Color.red);
                        Squares.get(temp2).setText("3");
                        if (FinishKontrol(piyon3)) {
                            Squares.get(temp2).setBackground(null);
                            RedSquare3.setBackground(Color.red);
                            Squares.get(temp2).setText(null);
                        }
                        Gonder(2, temp2, piyon3);
                    }
                } else if (jRadioButton4.isSelected() && dolduMu4 == true) {
                    if (Squares.get(TempKontrol(temp3 + zar)).getBackground() == Color.red) {
                        JOptionPane.showMessageDialog(game, "Piyon Piyonun Üstüne Gelemez. Yanlış Hamle!");
                    } else if (Squares.get(TempKontrol(temp3 + zar)).getBackground() == Color.green) {
                        JOptionPane.showMessageDialog(game, "Piyon Piyonun Üstüne Gelemez. Yanlış Hamle!");
                    } else {
                        Squares.get(temp3).setBackground(null);
                        Squares.get(temp3).setText(null);
                        piyon4 += zar;
                        temp3 = temp3 + zar;
                        temp3 = TempKontrol(temp3);
                        Squares.get(temp3).setBackground(Color.red);
                        Squares.get(temp3).setText("4");
                        if (FinishKontrol(piyon4)) {
                            Squares.get(temp3).setBackground(null);
                            RedSquare4.setBackground(Color.red);
                            Squares.get(temp3).setText(null);
                        }
                        Gonder(3, temp3, piyon4);
                    }
                }

            }
        } else if (side == "green") {
            // YESİL TARAF icin

            if (zar == 6) {

                if (jRadioButton5.isSelected() && GreenPiyonSeciliMi == 0 && dolduMu5 == false) {
                    GreenTemp = 30;
                    Squares.get(40).setBackground(null);
                    Squares.get(GreenTemp).setBackground(Color.green);
                    Squares.get(GreenTemp).setText("1");
                    GreenPiyonSeciliMi++;
                    dolduMu5 = true;
                    Gonder(4, GreenTemp, piyon5);
                } else if (jRadioButton6.isSelected() && GreenPiyonSeciliMi == 1 && dolduMu6 == false) {
                    GreenTemp1 = 30;
                    if (Squares.get(GreenTemp1).getBackground() == Color.red) {
                        JOptionPane.showMessageDialog(game, "Piyon Piyonun Üstüne Gelemez. Yanlış Hamle!");
                    } else if (Squares.get(GreenTemp1).getBackground() == Color.green) {
                        JOptionPane.showMessageDialog(game, "Piyon Piyonun Üstüne Gelemez. Yanlış Hamle!");
                    } else {
                        Squares.get(41).setBackground(null);
                        Squares.get(GreenTemp1).setBackground(Color.green);
                        Squares.get(GreenTemp1).setText("2");
                        GreenPiyonSeciliMi++;
                        dolduMu6 = true;
                        Gonder(5, GreenTemp1, piyon6);
                    }

                } else if (jRadioButton7.isSelected() && GreenPiyonSeciliMi == 2 && dolduMu7 == false) {
                    GreenTemp2 = 30;
                    if (Squares.get(GreenTemp2).getBackground() == Color.red) {
                        JOptionPane.showMessageDialog(game, "Piyon Piyonun Üstüne Gelemez. Yanlış Hamle!");
                    } else if (Squares.get(GreenTemp2).getBackground() == Color.green) {
                        JOptionPane.showMessageDialog(game, "Piyon Piyonun Üstüne Gelemez. Yanlış Hamle!");
                    } else {

                        Squares.get(42).setBackground(null);
                        Squares.get(GreenTemp2).setBackground(Color.green);
                        Squares.get(GreenTemp2).setText("3");
                        GreenPiyonSeciliMi++;
                        dolduMu7 = true;
                        Gonder(6, GreenTemp2, piyon7);
                    }
                } else if (jRadioButton8.isSelected() && GreenPiyonSeciliMi == 3 && dolduMu8 == false) {
                    if (Squares.get(GreenTemp3).getBackground() == Color.red) {
                        JOptionPane.showMessageDialog(game, "Piyon Piyonun Üstüne Gelemez. Yanlış Hamle!");
                    } else if (Squares.get(GreenTemp3).getBackground() == Color.green) {
                        JOptionPane.showMessageDialog(game, "Piyon Piyonun Üstüne Gelemez. Yanlış Hamle!");
                    } else {

                        GreenTemp3 = 30;
                        Squares.get(43).setBackground(null);
                        Squares.get(GreenTemp3).setBackground(Color.green);
                        Squares.get(GreenTemp3).setText("4");
                        GreenPiyonSeciliMi++;
                        dolduMu8 = true;
                        Gonder(7, GreenTemp3, piyon8);
                    }
                } // cikan piyona tekrar 6 geldiyse yapilacak islem 
                else {
                    if (jRadioButton5.isSelected() && dolduMu5 == true) {
                        if (Squares.get(TempKontrol(GreenTemp + zar)).getBackground() == Color.red) {
                            JOptionPane.showMessageDialog(game, "Piyon Piyonun Üstüne Gelemez. Yanlış Hamle!");
                        } else if (Squares.get(TempKontrol(GreenTemp + zar)).getBackground() == Color.green) {
                            JOptionPane.showMessageDialog(game, "Piyon Piyonun Üstüne Gelemez. Yanlış Hamle!");
                        } else {

                            Squares.get(GreenTemp).setBackground(null);
                            Squares.get(GreenTemp).setText(null);
                            piyon5 += zar;
                            GreenTemp = GreenTemp + zar;
                            GreenTemp = TempKontrol(GreenTemp);
                            Squares.get(GreenTemp).setBackground(Color.green);
                            Squares.get(GreenTemp).setText("1");
                            if (FinishKontrol(piyon5)) {
                                Squares.get(GreenTemp).setBackground(null);
                                GreenSquare.setBackground(Color.green);
                                Squares.get(GreenTemp).setText(null);
                            }
                            Gonder(4, GreenTemp, piyon5);
                        }

                    } else if (jRadioButton6.isSelected() && dolduMu6 == true) {

                        if (Squares.get(TempKontrol(GreenTemp1 + zar)).getBackground() == Color.red) {
                            JOptionPane.showMessageDialog(game, "Piyon Piyonun Üstüne Gelemez. Yanlış Hamle!");
                        } else if (Squares.get(TempKontrol(GreenTemp1 + zar)).getBackground() == Color.green) {
                            JOptionPane.showMessageDialog(game, "Piyon Piyonun Üstüne Gelemez. Yanlış Hamle!");
                        } else {

                            Squares.get(GreenTemp1).setBackground(null);
                            Squares.get(GreenTemp1).setText(null);
                            piyon6 += zar;
                            GreenTemp1 = GreenTemp1 + zar;
                            GreenTemp1 = TempKontrol(GreenTemp1);
                            Squares.get(GreenTemp1).setBackground(Color.green);
                            Squares.get(GreenTemp1).setText("2");
                            if (FinishKontrol(piyon6)) {
                                Squares.get(GreenTemp1).setBackground(null);
                                GreenSquare1.setBackground(Color.green);
                                Squares.get(GreenTemp1).setText(null);
                            }
                            Gonder(5, GreenTemp1, piyon6);
                        }

                    } else if (jRadioButton7.isSelected() && dolduMu7 == true) {
                        if (Squares.get(TempKontrol(GreenTemp2 + zar)).getBackground() == Color.red) {
                            JOptionPane.showMessageDialog(game, "Piyon Piyonun Üstüne Gelemez. Yanlış Hamle!");
                        } else if (Squares.get(TempKontrol(GreenTemp2 + zar)).getBackground() == Color.green) {
                            JOptionPane.showMessageDialog(game, "Piyon Piyonun Üstüne Gelemez. Yanlış Hamle!");
                        } else {

                            Squares.get(GreenTemp2).setBackground(null);
                            Squares.get(GreenTemp2).setText(null);
                            piyon7 += zar;
                            GreenTemp2 = GreenTemp2 + zar;
                            GreenTemp2 = TempKontrol(GreenTemp2);
                            Squares.get(GreenTemp2).setBackground(Color.green);
                            Squares.get(GreenTemp2).setText("3");
                            if (FinishKontrol(piyon7)) {
                                Squares.get(GreenTemp2).setBackground(null);
                                GreenSquare2.setBackground(Color.green);
                                Squares.get(GreenTemp2).setText(null);
                            }
                            Gonder(6, GreenTemp2, piyon7);
                        }

                    } else if (jRadioButton8.isSelected() && dolduMu8 == true) {
                        if (Squares.get(TempKontrol(GreenTemp3 + zar)).getBackground() == Color.red) {
                            JOptionPane.showMessageDialog(game, "Piyon Piyonun Üstüne Gelemez. Yanlış Hamle!");
                        } else if (Squares.get(TempKontrol(GreenTemp3 + zar)).getBackground() == Color.green) {
                            JOptionPane.showMessageDialog(game, "Piyon Piyonun Üstüne Gelemez. Yanlış Hamle!");
                        } else {

                            Squares.get(GreenTemp3).setBackground(null);
                            Squares.get(GreenTemp3).setText(null);
                            piyon8 += zar;
                            GreenTemp3 = GreenTemp3 + zar;
                            GreenTemp3 = TempKontrol(GreenTemp3);
                            Squares.get(GreenTemp3).setBackground(Color.green);
                            Squares.get(GreenTemp3).setText("4");
                            if (FinishKontrol(piyon8)) {
                                Squares.get(GreenTemp3).setBackground(null);
                                GreenSquare3.setBackground(Color.green);
                                Squares.get(GreenTemp3).setText(null);
                            }
                            Gonder(7, GreenTemp3, piyon8);
                        }

                    }
                }
            } // zar 6'dan baska gelirse burada gerceklesir.
            else {
                if (jRadioButton5.isSelected() && dolduMu5 == true) {
                    if (Squares.get(TempKontrol(GreenTemp + zar)).getBackground() == Color.red) {
                        JOptionPane.showMessageDialog(game, "Piyon Piyonun Üstüne Gelemez. Yanlış Hamle!");
                    } else if (Squares.get(TempKontrol(GreenTemp + zar)).getBackground() == Color.green) {
                        JOptionPane.showMessageDialog(game, "Piyon Piyonun Üstüne Gelemez. Yanlış Hamle!");
                    } else {

                        Squares.get(GreenTemp).setBackground(null);
                        Squares.get(GreenTemp).setText(null);
                        piyon5 += zar;
                        GreenTemp = GreenTemp + zar;
                        GreenTemp = TempKontrol(GreenTemp);
                        Squares.get(GreenTemp).setBackground(Color.green);
                        Squares.get(GreenTemp).setText("1");
                        if (FinishKontrol(piyon5)) {
                            Squares.get(GreenTemp).setBackground(null);
                            GreenSquare.setBackground(Color.green);
                            Squares.get(GreenTemp).setText(null);
                        }

                        Gonder(4, GreenTemp, piyon5);
                    }

                } else if (jRadioButton6.isSelected() && dolduMu6 == true) {
                    if (Squares.get(TempKontrol(GreenTemp1 + zar)).getBackground() == Color.red) {
                        JOptionPane.showMessageDialog(game, "Piyon Piyonun Üstüne Gelemez. Yanlış Hamle!");
                    } else if (Squares.get(TempKontrol(GreenTemp1 + zar)).getBackground() == Color.green) {
                        JOptionPane.showMessageDialog(game, "Piyon Piyonun Üstüne Gelemez. Yanlış Hamle!");
                    } else {

                        Squares.get(GreenTemp1).setBackground(null);
                        Squares.get(GreenTemp1).setText(null);
                        piyon6 += zar;
                        GreenTemp1 = GreenTemp1 + zar;
                        GreenTemp1 = TempKontrol(GreenTemp1);
                        Squares.get(GreenTemp1).setBackground(Color.green);
                        Squares.get(GreenTemp1).setText("2");
                        if (FinishKontrol(piyon6)) {
                            Squares.get(GreenTemp1).setBackground(null);
                            GreenSquare1.setBackground(Color.green);
                            Squares.get(GreenTemp1).setText(null);
                        }
                        Gonder(5, GreenTemp1, piyon6);
                    }

                } else if (jRadioButton7.isSelected() && dolduMu7 == true) {
                    if (Squares.get(TempKontrol(GreenTemp2 + zar)).getBackground() == Color.red) {
                        JOptionPane.showMessageDialog(game, "Piyon Piyonun Üstüne Gelemez. Yanlış Hamle!");
                    } else if (Squares.get(TempKontrol(GreenTemp2 + zar)).getBackground() == Color.green) {
                        JOptionPane.showMessageDialog(game, "Piyon Piyonun Üstüne Gelemez. Yanlış Hamle!");
                    } else {

                        Squares.get(GreenTemp2).setBackground(null);
                        Squares.get(GreenTemp2).setText(null);
                        piyon7 += zar;
                        GreenTemp2 = GreenTemp2 + zar;
                        GreenTemp2 = TempKontrol(GreenTemp2);
                        Squares.get(GreenTemp2).setBackground(Color.green);
                        Squares.get(GreenTemp2).setText("3");
                        if (FinishKontrol(piyon7)) {
                            Squares.get(GreenTemp2).setBackground(null);
                            GreenSquare2.setBackground(Color.green);
                            Squares.get(GreenTemp2).setText(null);
                        }
                        Gonder(6, GreenTemp2, piyon7);
                    }

                } else if (jRadioButton8.isSelected() && dolduMu8 == true) {
                    if (Squares.get(TempKontrol(GreenTemp3 + zar)).getBackground() == Color.red) {
                        JOptionPane.showMessageDialog(game, "Piyon Piyonun Üstüne Gelemez. Yanlış Hamle!");
                    } else if (Squares.get(TempKontrol(GreenTemp3 + zar)).getBackground() == Color.green) {
                        JOptionPane.showMessageDialog(game, "Piyon Piyonun Üstüne Gelemez. Yanlış Hamle!");
                    } else {

                        Squares.get(GreenTemp3).setBackground(null);
                        Squares.get(GreenTemp3).setText(null);
                        piyon8 += zar;
                        GreenTemp3 = GreenTemp3 + zar;
                        GreenTemp3 = TempKontrol(GreenTemp3);
                        Squares.get(GreenTemp3).setBackground(Color.green);
                        Squares.get(GreenTemp3).setText("4");
                        if (FinishKontrol(piyon8)) {
                            Squares.get(GreenTemp3).setBackground(null);
                            GreenSquare3.setBackground(Color.green);
                            Squares.get(GreenTemp3).setText(null);
                        }
                        Gonder(7, GreenTemp3, piyon8);
                    }

                }

            }
        }
        //client'a side tipinde bir mesaj gonderilir. 
        Message msg1 = new Message(Message.Message_Type.Side);
        msg1.content = side;
        jLSide.setText(side);
        Client.Send(msg1);

        btnOyna.setEnabled(false);


    }//GEN-LAST:event_btnOynaActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jRadioButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton7ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Scene.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Scene.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Scene.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Scene.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Scene().setVisible(true);
                Scene.game.Slider.start();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel GreenSquare;
    private javax.swing.JLabel GreenSquare1;
    private javax.swing.JLabel GreenSquare2;
    private javax.swing.JLabel GreenSquare3;
    private javax.swing.JLabel PiyonGreen1;
    private javax.swing.JLabel PiyonGreen2;
    private javax.swing.JLabel PiyonGreen3;
    private javax.swing.JLabel PiyonGreen4;
    private javax.swing.JLabel PiyonRed1;
    private javax.swing.JLabel PiyonRed2;
    private javax.swing.JLabel PiyonRed3;
    private javax.swing.JLabel PiyonRed4;
    public static javax.swing.JLabel RedSquare1;
    private javax.swing.JLabel RedSquare2;
    private javax.swing.JLabel RedSquare3;
    private javax.swing.JLabel RedSquare4;
    public javax.swing.JLabel ZarCounter;
    public javax.swing.JButton btnOyna;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    public javax.swing.JLabel jLSide;
    public javax.swing.JLabel jL_Sira;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JLabel yol1;
    private javax.swing.JLabel yol10;
    private javax.swing.JLabel yol11;
    private javax.swing.JLabel yol12;
    private javax.swing.JLabel yol13;
    private javax.swing.JLabel yol14;
    private javax.swing.JLabel yol15;
    private javax.swing.JLabel yol16;
    private javax.swing.JLabel yol17;
    private javax.swing.JLabel yol18;
    private javax.swing.JLabel yol19;
    private javax.swing.JLabel yol2;
    private javax.swing.JLabel yol20;
    private javax.swing.JLabel yol21;
    private javax.swing.JLabel yol22;
    private javax.swing.JLabel yol23;
    private javax.swing.JLabel yol24;
    private javax.swing.JLabel yol25;
    private javax.swing.JLabel yol26;
    private javax.swing.JLabel yol27;
    private javax.swing.JLabel yol28;
    private javax.swing.JLabel yol29;
    private javax.swing.JLabel yol3;
    private javax.swing.JLabel yol30;
    private javax.swing.JLabel yol31;
    private javax.swing.JLabel yol32;
    private javax.swing.JLabel yol33;
    private javax.swing.JLabel yol34;
    private javax.swing.JLabel yol35;
    private javax.swing.JLabel yol36;
    private javax.swing.JLabel yol37;
    private javax.swing.JLabel yol38;
    private javax.swing.JLabel yol39;
    private javax.swing.JLabel yol4;
    private javax.swing.JLabel yol40;
    private javax.swing.JLabel yol5;
    private javax.swing.JLabel yol6;
    private javax.swing.JLabel yol7;
    private javax.swing.JLabel yol8;
    private javax.swing.JLabel yol9;
    public javax.swing.JButton zar;
    // End of variables declaration//GEN-END:variables
}
