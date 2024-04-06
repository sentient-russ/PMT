import javax.swing.*;

import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class PMTApplication extends javax.swing.JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                new PmtView("PMT Window").setVisible(true);
            }
        });
    }


}

