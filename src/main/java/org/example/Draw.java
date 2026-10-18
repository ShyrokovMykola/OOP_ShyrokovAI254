package org.example;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;

public class Draw extends JPanel {
    private final List<Shape> shapes = List.of(
            new Circle(90, 100, 60, Color.BLUE),
            new Rectangle(210, 55, 150, 90, Color.RED)
    );

    public Draw() {
        setPreferredSize(new Dimension(420, 240));
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        shapes.forEach(shape -> shape.paint(graphics));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame window = new JFrame("Draw — абстрактні класи");
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setContentPane(new Draw());
            window.pack();
            window.setLocationRelativeTo(null);
            window.setVisible(true);
        });
    }

    private abstract static class Shape {
        private final Color color;

        private Shape(Color color) {
            this.color = color;
        }

        protected Color color() {
            return color;
        }

        abstract void paint(Graphics graphics);
    }

    private static class Circle extends Shape {
        private final int x;
        private final int y;
        private final int diameter;

        private Circle(int x, int y, int diameter, Color color) {
            super(color);
            this.x = x;
            this.y = y;
            this.diameter = diameter;
        }

        @Override
        void paint(Graphics graphics) {
            graphics.setColor(color());
            graphics.fillOval(x, y, diameter, diameter);
        }
    }

    private static class Rectangle extends Shape {
        private final int x;
        private final int y;
        private final int width;
        private final int height;

        private Rectangle(int x, int y, int width, int height, Color color) {
            super(color);
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        @Override
        void paint(Graphics graphics) {
            graphics.setColor(color());
            graphics.fillRect(x, y, width, height);
        }
    }
}
