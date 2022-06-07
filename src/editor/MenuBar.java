package editor;

import editor.menuItem.GroupItem;
import editor.menuItem.RenameItem;
import editor.menuItem.UnGroupItem;

import javax.swing.*;

public class MenuBar extends JMenuBar {
    // Components
    private final JMenu file;
    private final JMenu edit;

    public MenuBar() {
        // Initial Components
        file = new JMenu("File");
        edit = new JMenu("Edit");

        // add menu item and item listener
        // Change to custom menu item
        edit.add(new GroupItem());
        edit.add(new UnGroupItem());
        edit.add(new RenameItem());
        file.add(new JMenuItem("Exit"));

        // add menu to menu bar
        add(file);
        add(edit);
    }
}
