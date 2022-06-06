package ui.button;

import mode.ClassMode;
import ui.Canvas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClassButton extends JToggleButton {
    private final Canvas canvas;

    public ClassButton() {
        super(new ImageIcon("icon/class.png"));
        canvas = Canvas.getInstance();
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.setMode(new ClassMode());
            }
        });
    }
}
