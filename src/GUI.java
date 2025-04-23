import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;

public class GUI extends JFrame {
    private JPanel pnMain;
    private JList list1;
    private JTextArea textArea1;

    public GUI() {
        initComponents();

    }

    private void initComponents(){
        setContentPane(pnMain);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("opakování menubaru");
        setSize(600, 400);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Soubor");
        JMenuItem novy = new JMenuItem("Nový");
        JMenuItem ulozit = new JMenuItem("Uložit");
        JMenuItem ulozitJako = new JMenuItem("Uložit Jako");

        setJMenuBar(menuBar);
        menuBar.add(menu);
        menu.add(novy);
        menu.add(ulozit);
        menu.add(ulozitJako);

        String[] data = {"Jablko", "Banán", "Hruška", "Pomeranč"};
        list1.setListData(data);

        list1.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                System.out.println("Vybráno: " + list1.getSelectedValue());
            }
        });

    }


    public void guiViditelne() {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Nepodařilo se nastavit FlatLaf.");
        }

        SwingUtilities.invokeLater(() -> {
            // Zde vytvoříš GUI z .form
            GUI gui = new GUI();
            gui.setVisible(true);
        });
    }
}
