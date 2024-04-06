import javax.swing.*;
import java.awt.*;

public class PmtView extends JFrame {
    JButton add = new JButton("Add");

    JButton update = new JButton("Update");
    JButton delete = new JButton("Delete");
    JButton exit = new JButton("X");
    JLabel logo = new JLabel("P.M.T Logo");
    JLabel tag = new JLabel("Projects");

    public PmtView(String title){
        super(title);
//        JPanel innerPanel = new JPanel();
//        innerPanel.setSize(800, 400);

        this.setLayout(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(50,150,900,750);
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.white);

        JPanel panelView = new JPanel();
        panelView.setLayout(null);
        panelView.setSize(1000, 1000);
        panelView.setBackground(Color.decode("#EDEDED"));

        logo.setLayout(null);
        logo.setBounds(450, 10, 100, 100);

        tag.setLayout(null);
        tag.setBounds(455, 50, 100, 100);

        mainPanel.add(add);
        mainPanel.add(update);
        mainPanel.add(delete);

        panelView.add(exit);
        panelView.add(logo);
        panelView.add(tag);



        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 200);
        this.setSize(1000, 1000);

        this.add(panelView);
        panelView.add(mainPanel);
//        panelView.add(innerPanel);

    }


}