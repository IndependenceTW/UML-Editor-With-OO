package editor.menuItem;

import shape.Shape;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RenameItem extends MenuItem {
    public RenameItem() {
        super("Rename");
    }

    void actionPerform() {
        ArrayList<Shape> selectList = canvas.getAllSelect();
        if(selectList.size() != 1) {
            return;
        }

        Shape target = selectList.get(0);
        if(target.getName() == null) {
            return;
        }

        String name = JOptionPane.showInputDialog(canvas, "Please enter new name:");
        if(name != null) {
            target.setName(name);
        }

        canvas.repaint();
    }
}
