package editor.menuItem;

import editor.Canvas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class MenuItem extends JMenuItem {
    Canvas canvas = Canvas.getInstance();

    public MenuItem(String name) {
        super(name);
        addActionListener(new Listener());
    }
    abstract void actionPerform();

    private class Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            actionPerform();
        }
    }
}
