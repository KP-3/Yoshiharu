import java.awt.BasicStroke;
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Searchplus extends JPanel {
    //static ArrayList<String > name=new ArrayList<String>();
    static JLabel label = new JLabel();
    static JButton assave = new JButton("save");

    public static void main(String args[]) {
        MakePanel frame4 = new MakePanel();
        frame4.setBounds(10, 10, 1000, 1000);
        Searchplus app = new Searchplus();
        frame4.getContentPane().add(app);
        frame4.add(app, BorderLayout.CENTER);
        frame4.setVisible(true);
        frame4.repaint();
    }

    private void makeStateSpace() {

    }

    public void paintComponent(Graphics g) {
        GraphFrame aaa = new GraphFrame();

        Graphics2D g2 = (Graphics2D) g;
        ArrayList tableforkstate = GraphFrame.tableforkstate;
        ArrayList rightstate = GraphFrame.rightstate;
        ArrayList leftstate = GraphFrame.leftstate;
        ArrayList eatstate = GraphFrame.eatstate;
        ArrayList<ArrayList<String>> namelist = Planner.namelist;
        Graphics2D g3 = (Graphics2D) g;
        Font font2 = new Font("Arial", Font.BOLD, 45);
        Graphics2D g4 = (Graphics2D) g;

        Font font = new Font("Arial", Font.BOLD, 30);
        g4.setFont(font);
        g3.setFont(font);
//		  g3.setFont(font);

//		System.out.println(Planner.namelist);
//		System.out.println(Planner.name);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        BasicStroke wideStroke = new BasicStroke(4.0f);
        g2.setStroke(wideStroke);
        //円の中心
        int circlet=710;
        int circley=410;
        g2.drawOval(circlet-250, circley-250, 500, 500); // テーブル
        int At = 700;
        int Ay = 100;
        int Bt = 950;
        int By = 250;
        int Ct = 850;
        int Cy = 700;
        int Dt = 550;
        int Dy = 700;
        int Et = 450;
        int Ey = 250;

        int philosopherNum = 10; // 哲学者の人数を取得
//        philosopherNum = 10;
        // 哲学者の配置
        for (int i = 0; i < philosopherNum; i++) {
            double philosopherX = circlet + 320 * Math.cos(Math.toRadians((360 * i) / philosopherNum - 90));
            double philosopherY = circley + 320 * Math.sin(Math.toRadians((360 * i) / philosopherNum - 90));
            g2.drawOval((int) philosopherX-40, (int) philosopherY-40, 80, 80);
            
            // 哲学者の名前も同様に描画
            philosopherX = circlet + 400 * Math.cos(Math.toRadians((360 * i) / philosopherNum - 90));
            philosopherY = circley + 400 * Math.sin(Math.toRadians((360 * i) / philosopherNum - 90));
            g2.drawString(Integer.toString(i),(int) philosopherX, (int) philosopherY);
        }
        
        // フォークの配置


//        g2.drawOval(At, Ay, 80, 80);
//        g2.drawOval(Bt, By, 80, 80);
//        g2.drawOval(Ct, Cy, 80, 80);
//        g2.drawOval(Dt, Dy, 80, 80);
//        g2.drawOval(Et, Ey, 80, 80);
        g2.drawString("A", At, Ay);
        g2.drawString("B", Bt, By);
        g2.drawString("C", Ct, Cy);
        g2.drawString("D", Dt, Dy);
        g2.drawString("E", Et, Ey);

        int i = 0;

        for (Object s : tableforkstate) {
            String t = (String)s;
            int tableforknumber = Integer.parseInt(t);
            
 //           g4.drawString("Ψ",(int)(20 * Math.cos(Math.toRadians(360*tableforknumber)/philosopherNum + 90) + 300 * Math.cos(Math.toRadians(360*tableforknumber)/philosopherNum)+500),(int)(20 * Math.sin(Math.toRadians(360*tableforknumber)/philosopherNum + 90) + 300 * Math.sin(Math.toRadians(360*tableforknumber)/philosopherNum)+250));

            switch (Integer.parseInt(t)) {
                case 1:
                    g4.drawString("ψ", 800, 300);

                	break;
                case 2:
                    g4.drawString("ψ", 850, 450);

                    break;
                case 3:
                    g4.drawString("ψ", 700, 600);

                	break;
                case 4:
                    g4.drawString("ψ", 600, 450);

                	break;
                case 5:
                    g4.drawString("ψ", 650, 300);

                	break;

            }
            
        }
        
        //フォーク,食事の描画テスト
       for(int j=0;j<philosopherNum;j++){
    	   //右手
    	   g3.drawString("ψ",(int)(20 * Math.cos(Math.toRadians(360*j/philosopherNum -90- 90))+circlet-10 + 265 * Math.cos(Math.toRadians((360 * j) / philosopherNum - 90))),(int)(20 * Math.sin(Math.toRadians(360*j/philosopherNum -90- 90))+circley +10+ 265 * Math.sin(Math.toRadians((360 * j) / philosopherNum - 90))));
           //左手
    	   g3.drawString("ψ",(int)(20 * Math.cos(Math.toRadians(360*j/philosopherNum -90+ 90))+circlet-10 + 265 * Math.cos(Math.toRadians((360 * j) / philosopherNum - 90))),(int)(20 * Math.sin(Math.toRadians(360*j/philosopherNum -90+ 90))+circley +10+ 265 * Math.sin(Math.toRadians((360 * j) / philosopherNum - 90))));
           //食事
    	   g3.drawString("♨",(int)(circlet -20 + 200 * Math.cos(Math.toRadians((360 * j) / philosopherNum - 90))),(int)(circley + 15 + 200 * Math.sin(Math.toRadians((360 * j) / philosopherNum - 90))));
           //テーブル
    	   g3.drawString("ψ",(int)(circlet -20 + 200 * Math.cos(Math.toRadians((360 * j) / philosopherNum - 90 - (360 / (2*philosopherNum))))),(int)(circley + 15 + 200 * Math.sin(Math.toRadians((360 * j) / philosopherNum - 90- (360 / (2*philosopherNum))))));

       }
       
       
       
        for (Object s : rightstate) {
            String t = (String) s;

            if (t.equals("A")) g3.drawString("ψ", At - 20, Ay + 100);
            if (t.equals("B")) g3.drawString("ψ", Bt - 10, By + 40);
            if (t.equals("C")) g3.drawString("ψ", Ct + 20, Cy - 10);
            if (t.equals("D")) g3.drawString("ψ", Dt + 60, Dy + 10);
            if (t.equals("E")) g3.drawString("ψ", Et + 50, Ey + 70);

            
        }

        for (Object s : leftstate) {
            String t = (String) s;

            if (t.equals("A")) g3.drawString("ψ", At + 60, Ay + 100);
            if (t.equals("B")) g3.drawString("ψ", Bt + 25, By + 70);
            if (t.equals("C")) g3.drawString("ψ", Ct - 20, Cy + 10);
            if (t.equals("D")) g3.drawString("ψ", Dt - 10, Dy - 10);
            if (t.equals("E")) g3.drawString("ψ", Et + 60, Ey + 40);
        }

        g4.setFont(font2);
        for (Object s : eatstate) {
            String t = (String) s;

            if (t.equals("A")) g3.drawString("♨", At + 20, Ay + 150);
            if (t.equals("B")) g3.drawString("♨", Bt - 80, By + 100);
            if (t.equals("C")) g3.drawString("♨", Ct - 50, Cy - 50);
            if (t.equals("D")) g3.drawString("♨", Dt + 50, Dy - 50);
            if (t.equals("E")) g3.drawString("♨", Et + 100, Ey + 100);
        }

    }


    public Dimension getPreferredSize() {

        return new Dimension(1500, 1000);
    }
}

class MakePanel extends JFrame {
    MakePanel() {
        setBounds(100, 100, 300, 300);

    }
}