import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

public class ScrollBarCustom extends JScrollBar {

    public ScrollBarCustom() {
        setUI(new ScrollBarUI());
        setPreferredSize(new Dimension(4, 10));
        setMaximumSize(new Dimension(4, 10));
        setForeground(new Color(152,155,160));
        setBackground(new Color(215, 219, 221));
        setUnitIncrement(20);
    }
}