import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class SlotMachine {

    //initializing

    JFrame mFrame;
    JButton reel1 ;
    JButton reel2 ;
    JButton reel3 ;

    JLabel betAreaValue;

    JLabel creditAreaValue;


    private int countBet=0;
    private int creditAmount=10;
    private int con ;
    private String imagedisplay1;
    private String imagedisplay2;
    private String imagedisplay3;
    private int symbolValue;
    private int winAmount=0;
    private int lossAmount=0;

    //constructor
    SlotMachine(){




        JFrame mFrame = new JFrame("SLOTMACHINE");

        mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mFrame.setVisible(true);

        ImageIcon img = new ImageIcon("img/lemon.png");

        JButton reel1 = new JButton(img);
        JButton reel2 = new JButton(img);
        JButton reel3 = new JButton(img);

        JButton  addCoinBtn = new JButton("Add Coin");
        JButton betOneBtn = new JButton("Bet One");
        JButton  betMaxBtn = new JButton("Bet Max");
        JButton resetBtn = new JButton("Reset");
        JButton spinBtn = new JButton("Spin");
        JLabel betArealbl = new JLabel("Bet Area");
        JLabel betAreaVal = new JLabel("  "+Integer.toString((countBet)));
        JLabel creditArealbl = new JLabel("Credit Area");
        JLabel creditAreaVal = new JLabel("  "+Integer.toString((creditAmount)));
        JButton  stat = new JButton("Statistics");
             //panel 1
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new LineBorder(Color.darkGray,5));
        mFrame.add(panel);
        panel.add(reel1,BorderLayout.WEST);
        panel.add(reel2,BorderLayout.CENTER);
        panel.add(reel3, BorderLayout.EAST);

         //panel2
        JPanel panel2 = new JPanel(new GridLayout(2,5,5,10));
        panel2.setBorder(new LineBorder(Color.darkGray,20));
        panel2.setBackground(Color.darkGray);
        mFrame.add(panel2,BorderLayout.EAST);
        panel2.add(betMaxBtn);             //adding elements
        panel2.add(betOneBtn);
        panel2.add(betArealbl);
        panel2.add(betAreaVal);
        panel2.add(spinBtn);
        panel2.add(resetBtn);
        panel2.add(addCoinBtn);
        panel2.add(creditArealbl);
        panel2.add(creditAreaVal);
        panel2.add(stat);

        betAreaVal.setFont(new Font("Tahoma", 1, 14));
        betAreaVal.setForeground(Color.white);
        betArealbl.setForeground(Color.lightGray);
        betAreaVal.setBorder(new LineBorder(Color.lightGray,1));

        creditAreaVal.setFont(new Font("Tahoma", 1, 14));
        creditAreaVal.setBorder(new LineBorder(Color.lightGray,1));
        creditArealbl.setForeground(Color.white);
        creditAreaVal.setForeground(Color.white);



        mFrame.pack();

        spinBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spinBtnActionPerformed(evt);
            }
        });


        betOneBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                betOnBtnActionPerformed(evt);
            }
        });
        betMaxBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                betMaxBtnActionPerformed(evt);
            }
        });
        addCoinBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCoinBtnActionPerformed(evt);
            }
        });
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });
        reel3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reel3ActionPerformed(evt);
            }
        });
        reel2.addActionListener(evt -> reel2ActionPerformed(evt));
        reel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reel1ActionPerformed(evt);
            }
        });
        stat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statActionPerformed(evt);
            }
        });


    }



    private void spinBtnActionPerformed(ActionEvent evt){
        //checking the initial credits
        if(creditAmount==0){

            JOptionPane.showMessageDialog(null, "please enter Credit amount");

        }
        else{

            if(countBet!=0){
                //creating  thread
                Thread thread1 = new Thread(){

                    Reel imgReel1 = new Reel();
                    Symbol[] imageList1 = imgReel1.spin();


                    public void run(){
                        con=1;
                        //create infinite loop
                        while(con>0){
                            for(int a=0; a<imageList1.length;a++){

                                System.out.println("******"+imageList1[a].getImage());

                                ImageIcon img1 = new ImageIcon(imageList1[a].getImage());
                                reel3.setIcon(img1);//set images to the reel button

                                try {
                                    Thread.sleep(100);
                                } catch (InterruptedException e) {

                                }
                                //spinning stoos when user click on a reel
                                if((reel3.getModel().isPressed()==true) || (reel2.getModel().isPressed()==true) || (reel1.getModel().isPressed()==true)){
                                    con=0;
                                    imagedisplay1=reel3.getIcon().toString();
                                    symbolValue=imageList1[a].getValue();

                                    break;
                                }else{
                                    con++;
                                }
                            }

                        }

                    }

                };

                Thread thread2 = new Thread(){


                    Reel imgReel2= new Reel();
                    Symbol[] imgList2 =imgReel2.spin();


                    public void run(){
                        con=1;
                        while(con>0){

                            for(int b=0; b<imgList2.length;b++){

                                System.out.println("##########"+imgList2[b].getImage());

                                ImageIcon img2 = new ImageIcon(imgList2[b].getImage());
                                reel2.setIcon(img2);

                                try {
                                    Thread.sleep(100);
                                } catch (InterruptedException e) {

                                }

                                if((reel3.getModel().isPressed()==true) || (reel2.getModel().isPressed()==true) || (reel1.getModel().isPressed()==true)){
                                    con=0;
                                    imagedisplay2=reel2.getIcon().toString();

                                    break;
                                }else{
                                    con++;
                                }
                            }

                        }

                    }

                };

                Thread thread3 = new Thread(){

                    Reel imgReel3 = new Reel();
                    Symbol[] imgList3 = imgReel3.spin();

                    public void run(){
                        con=1;
                        while(con>0){

                            for(int i=0; i<imgList3.length;i++){

                                System.out.println("-------"+imgList3[i].getImage());

                                ImageIcon img3 = new ImageIcon(imgList3[i].getImage());
                                reel1.setIcon(img3);

                                try {
                                    Thread.sleep(100);
                                } catch (InterruptedException e) {

                                }
                                if((reel3.getModel().isPressed()==true) || (reel2.getModel().isPressed()==true) || (reel1.getModel().isPressed()==true)){
                                    con=0;
                                    imagedisplay3=reel1.getIcon().toString();
                                    break;
                                }else{
                                   con++;
                                }
                            }

                        }


                    }

                };



                thread1.start();
               thread2.start();
                thread3.start();


            }else{
                JOptionPane.showMessageDialog(null, "please enter the amount you bet");

            }
        }

    }

    private void betOnBtnActionPerformed(ActionEvent evt){

        if(1<=creditAmount){

            countBet+=1;
            betAreaValue.setText("  "+Integer.toString(countBet));

            creditAmount = creditAmount-1;
            creditAreaValue.setText("  "+Integer.toString(creditAmount));
        }


    }

    private void betMaxBtnActionPerformed(ActionEvent evt){

        if(3<=creditAmount){

            countBet = countBet+3;
            betAreaValue.setText("  "+Integer.toString(countBet));

            creditAmount = creditAmount-3;
            creditAreaValue.setText("  "+Integer.toString(creditAmount));
        }
    }

    private void addCoinBtnActionPerformed(ActionEvent evt){

        creditAmount+=1;
        creditAreaValue.setText("  "+Integer.toString(creditAmount));
    }

    private void resetBtnActionPerformed(ActionEvent evt){

        creditAmount= creditAmount+countBet;
        countBet=0;
        betAreaValue.setText("  "+Integer.toString(countBet));
        creditAreaValue.setText("  "+Integer.toString(creditAmount));

    }

    private void reel3ActionPerformed(ActionEvent evt){

        if(imagedisplay1.equals(imagedisplay2) && imagedisplay2.equals(imagedisplay3)){

            creditAmount = creditAmount+ (countBet*symbolValue);
            countBet=0;
            betAreaValue.setText(Integer.toString(countBet));
            creditAreaValue.setText(Integer.toString(creditAmount));
            JOptionPane.showMessageDialog(null, "YOU WIN!!!");
            winAmount+=1;

        }
        else if(imagedisplay2.equals(imagedisplay1)){
            System.out.println("Machine");
            JOptionPane.showMessageDialog(null, "you got a free chance");


        }
        else if(imagedisplay1.equals(imagedisplay3)){

            JOptionPane.showMessageDialog(null, "you got a free chance");
        }
        else if(imagedisplay2.equals(imagedisplay3)){

            JOptionPane.showMessageDialog(null, "you got a free chance.");
        }
        else{
            countBet=0;
            betAreaValue.setText("  "+Integer.toString(countBet));
            JOptionPane.showMessageDialog(null, "bad luck.Try again.");
            lossAmount+=1;
        }

    }

    private void reel2ActionPerformed(ActionEvent evt){

        if(imagedisplay1.equals(imagedisplay2) && imagedisplay2.equals(imagedisplay3)){

            creditAmount = creditAmount + (countBet*symbolValue);
            countBet=0;
            betAreaValue.setText(Integer.toString(countBet));
            creditAreaValue.setText(Integer.toString(creditAmount));
            JOptionPane.showMessageDialog(null, "Congrats.you won.!!!");
            winAmount+=1;
        }
        else if(imagedisplay2.equals(imagedisplay1)){

            JOptionPane.showMessageDialog(null, "you got a free chance");


        }
        else if(imagedisplay1.equals(imagedisplay3)){

            JOptionPane.showMessageDialog(null, "you got a free chance.");
        }
        else if(imagedisplay2.equals(imagedisplay3)){

            JOptionPane.showMessageDialog(null, "you got a free chance.");
        }
        else{
            countBet=0;
            betAreaValue.setText("  "+Integer.toString(countBet));
            JOptionPane.showMessageDialog(null, "bad luck.Try again.");
            lossAmount+=1;
        }
    }
    private void reel1ActionPerformed(ActionEvent evt){

        if(imagedisplay1.equals(imagedisplay2) &&imagedisplay2.equals(imagedisplay3)){

            creditAmount = creditAmount + (countBet*symbolValue);
            countBet=0;
            betAreaValue.setText(Integer.toString(countBet));
            creditAreaValue.setText(Integer.toString(creditAmount));
            JOptionPane.showMessageDialog(null, "Congrats.you won!!!");
            winAmount+=1;
        }
        else if(imagedisplay2.equals(imagedisplay1)){

            JOptionPane.showMessageDialog(null, "you got a free chance.");

        }
        else if(imagedisplay1.equals(imagedisplay3)){

            JOptionPane.showMessageDialog(null, "you got a free chance.");
        }
        else if(imagedisplay2.equals(imagedisplay3)){

            JOptionPane.showMessageDialog(null, "you got a free chance.");
        }
        else{
            countBet=0;
            betAreaValue.setText("  "+Integer.toString(countBet));
            JOptionPane.showMessageDialog(null, "You lost.");
            lossAmount+=1;
        }

    }

    private void statActionPerformed(ActionEvent evt){

        JDialog dialog= new JDialog(mFrame,true);
        JPanel pan = new JPanel(new GridLayout(4,2,2,2));
        JLabel lblWinn = new JLabel("Wins: ");
        JLabel lblWinnNo = new JLabel("");
        JLabel lblLost= new JLabel("Losses: ");
        JLabel lblLostNo = new JLabel("");
        JLabel lblAvergCredit = new JLabel("Avg");
        JLabel lblAveragCreditValue = new JLabel("Avg");
        JButton saveBtn = new JButton("Save");

        pan.setBorder(new LineBorder(null,10));
        lblWinn.setBorder(new LineBorder(Color.BLACK,2));
        lblLost.setBorder(new LineBorder(Color.BLACK,2));
        lblWinnNo.setBorder(new LineBorder(Color.BLACK,2));
        lblAveragCreditValue.setBorder(new LineBorder(Color.BLACK,2));
        lblAvergCredit.setBorder(new LineBorder(Color.BLACK,2));
        lblLostNo.setBorder(new LineBorder(Color.BLACK,2));
        Container pane = (Container) dialog.getContentPane().add(pan);
        pan.add(lblWinn);
        pan.add(lblWinnNo);
        pan.add(lblLost);
        pan.add(lblLostNo);
        pan.add(lblAvergCredit);
        pan.add(lblAveragCreditValue);
        pan.add(saveBtn);
        dialog.setSize(450, 200);
        dialog.setVisible(true);

        lblWinnNo.setText(Integer.toString(winAmount));
        lblLostNo.setText(Integer.toString(lossAmount));

    }


    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SlotMachine();
            }
        });
    }
}

