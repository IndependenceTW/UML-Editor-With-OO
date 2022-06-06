package ui.button;

import mode.CompositionMode;
import ui.Canvas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompositionButton extends JToggleButton {
    private final Canvas canvas;

    public CompositionButton() {
        super(new ImageIcon("icon/composition.png"));
        canvas = Canvas.getInstance();
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.setMode(new CompositionMode());
            }
        });
    }
}
