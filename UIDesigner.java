import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIDesigner extends JFrame{
    private JPanel homePage;
    private JLabel homeScreenSelectLabel;
    private JButton projectXButton;
    private JTextField homeTextField;
public UIDesigner() {
    projectXButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(projectXButton, "Sigh this a headache");
        }
    });
}

    public static void main(String[] args) {
        UIDesigner UIDesignerObject = new UIDesigner();
        UIDesignerObject.setContentPane(UIDesignerObject.homePage);
        UIDesignerObject.setTitle("PMT View");
        UIDesignerObject.setSize(500, 500);
        UIDesignerObject.setVisible(true);
        UIDesignerObject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
