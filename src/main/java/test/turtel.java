package test;
import org.junit.Test;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
/**
 * Created by Malu on 2017-09-27.
 */
public class turtel {
  @Test
        public  void main() {
            JFrame w=new JFrame("乌龟游啊游");
            w.setSize(1720, 768);
            w.setBackground(Color.LIGHT_GRAY);
            Mypan mp=new Mypan();
            w.add(mp);

            w.addMouseListener(mp);
            w.addMouseMotionListener(mp);

            w.addKeyListener(mp);
            mp.addKeyListener(mp);

            Thread ti=new Thread(mp);
            ti.start();
            w.setVisible(true);
        }
    }




