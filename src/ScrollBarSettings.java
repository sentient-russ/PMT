import javax.swing.*;
import java.awt.*;
public class ScrollBarSettings extends JScrollBar {
    public ScrollBarSettings() {
        setUI(new ScrollBarUI());
        setPreferredSize(new Dimension(10, 10));
        setForeground(new Color(152,155,160));
        setBackground(new Color(215, 219, 221));
        setUnitIncrement(20);
    }
}