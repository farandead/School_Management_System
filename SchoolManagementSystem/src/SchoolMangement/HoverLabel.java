package SchoolMangement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HoverLabel extends JLabel
{
    float alpha = 1f;

    public HoverLabel(String text)
    {
        super(text);
        setHorizontalTextPosition(HoverLabel.CENTER);
        setVerticalTextPosition(HoverLabel.CENTER);
        addMouseListener(new ML());
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
