package SchoolMangement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HoverButton extends JButton
{
    float alpha = 1f;

    public HoverButton(String text)
    {
        super(text);
        setHorizontalTextPosition(HoverButton.CENTER);
        setVerticalTextPosition(HoverButton.CENTER);
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        addMouseListener(new ML());
        ImageIcon buttonImage = new ImageIcon("MenuButton.png");
        setIcon(buttonImage);
        setVisible(true);
    }

    public float getAlpha()
    {
        return alpha;
    }

    public void setAlpha(float alpha)
    {
        this.alpha = alpha;
        repaint();
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        super.paintComponent(g2);
    }

    public class ML extends MouseAdapter
    {
        public void mouseExited(MouseEvent me)
        {
            new Thread(new Runnable()
            {
                public void run()
                {
                    for (float i = 1f; i >= 0.9f; i -= .03f)
                    {
                        setAlpha(i);
                        try
                        {
                            Thread.sleep(10);
                        }
                        catch (Exception e)
                        {
                        }
                    }
                }
            }).start();
        }
        public void mouseEntered(MouseEvent me)
        {
            new Thread(new Runnable()
            {
                public void run()
                {
                    for (float i = .4f; i <= 1f; i += .03f)
                    {
                        setAlpha(i);
                        try
                        {
                            Thread.sleep(10);
                        }
                        catch (Exception e)
                        {
                        }
                    }
                }
            }).start();
        }
        public void mousePressed(MouseEvent me)
        {
            new Thread(new Runnable()
            {
                public void run()
                {
                    for (float i = 1f; i >= 0.6f; i -= .1f)
                    {
                        setAlpha(i);
                        try
                        {
                            Thread.sleep(1);
                        }
                        catch (Exception e)
                        {
                        }
                    }
                }
            }).start();
        }
    }
}
