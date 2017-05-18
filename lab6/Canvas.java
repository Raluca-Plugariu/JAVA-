
package lab6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Canvas extends JPanel {
    private Graphics2D graphics;
    private BufferedImage image;

    public Canvas() {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(700, 600));
        this.setBackground(Color.WHITE);

        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int a = e.getX();
                int b = e.getY();
                drawShapeAt(a, b);
            }
        });
    }

    public void init() {
        image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
    }

    public BufferedImage getImage() {
        return this.image;
    }

    public void drawShapeAt(int x, int y) {
        Random rand = new Random();
        RegularPolygon poligon = new RegularPolygon(x, y, rand.nextInt(20), 3+rand.nextInt(5));
        graphics.setStroke(new BasicStroke(1));
        graphics.setColor(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
        graphics.fill(poligon);
        graphics.setColor(Color.BLACK);
        graphics.drawPolygon(poligon);

        repaint();
    }

    public void drawShapeAt(int shapesNr, int sides, int stroke) {//int number, int sides, int stroke) {
        for(int i = 0; i < shapesNr; i++) {
            Random rand = new Random();
            RegularPolygon poligon = new RegularPolygon(rand.nextInt(800),rand.nextInt(600),  rand.nextInt(50), sides);
            graphics.setStroke(new BasicStroke(stroke));
            graphics.setColor(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
            graphics.fill(poligon);
            graphics.setColor(Color.BLACK);
            graphics.drawPolygon(poligon);
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }




}
