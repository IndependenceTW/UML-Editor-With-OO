package ui.button;

import mode.GeneralizationMode;
import mode.UseCaseMode;
import ui.Canvas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeneralizationButton extends JToggleButton {
    private final Canvas canvas;

    public GeneralizationButton() {
        super(new ImageIcon("icon/generalization.png"));
        canvas = Canvas.getInstance();
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.setMode(new GeneralizationMode());
            }
        });
    }
}
