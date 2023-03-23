package BODY.Button;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class ButtonLogin extends JButton {

    private boolean hoverBackground;
    private boolean hoverText;

    private Color color;
    private Color colorHover; //màu nền hover
    private Color colorText; //màu chữ
    private Color colorClick; //màu chọn
    private Color borderColor; //màu khung viền
    private int radius = 0;

    public ButtonLogin() {
        //  Init Color

        setBackground(Color.WHITE);
        color = Color.white;
        colorHover = new Color(12, 46, 68); //màu nền hover
        colorText = Color.white; //màu chữ
        colorClick = new Color(204, 216, 224); //màu chọn
        borderColor = new Color(38, 184, 222); //màu khung viền
        setContentAreaFilled(false);
        //  Add event mouse
        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {
                setBackground(colorHover);
                hoverBackground = true;

                setForeground(colorText);
                hoverText = true;
            }

            @Override
            public void mouseExited(MouseEvent me) {
                setBackground(color);
                //hoverBackground = false;

                setForeground(Color.black);
                hoverText = false;
            }

            @Override
            public void mousePressed(MouseEvent me) {
                setBackground(colorClick);
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                if (hoverBackground) {
                    setBackground(colorHover);
                } else {
                    setBackground(color);
                }
            }
        });
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //  Paint Border
        g2.setColor(borderColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        g2.setColor(getBackground());
        //  Border set 2 Pix
        g2.fillRoundRect(2, 2, getWidth() - 4, getHeight() - 4, radius, radius);
        super.paintComponent(grphcs);
    }
}
