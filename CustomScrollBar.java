
import javax.swing.*;
import java.awt.*;
public class CustomScrollBar extends JScrollBar {
    public CustomScrollBar() {
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(10, 10));
        setForeground(new Color(215, 219, 221));
        setBackground(new Color(30, 30, 30));
    }
}