package ui;

import javax.swing.*;

public class MenuBar extends JMenuBar {
    // Components
    private JMenu file;
    private JMenu edit;

    public MenuBar() {
        // Initial Components
        file = new JMenu("File");
        edit = new JMenu("Edit");

        // add menu item and item listener
        edit.add(new JMenuItem("Group"));
        edit.add(new JMenuItem("Ungroup"));
        edit.add(new JMenuItem("Rename"));
        file.add(new JMenuItem("Exit"));

        // add menu to menu bar
        add(file);
        add(edit);
    }
}
