/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DrawingFrame extends JFrame {
    private JFrame frame;
    //private JButton saveBtn, loadBtn, clearBtn;
    public DrawingFrame() {
        this.frame = new JFrame("Drawing Frame");
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    protected void frameInit() {
        super.frameInit();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas canvas = new Canvas();
        canvas.init();
        SpringLayout frameLayout = new SpringLayout();

        this.setLayout(frameLayout);
        this.setPreferredSize(new Dimension(700, 600));

        this.add(new Toolbar(canvas), BorderLayout.NORTH);
        this.add(canvas, BorderLayout.CENTER);

        this.pack();
        this.setVisible(true);
    }
}

