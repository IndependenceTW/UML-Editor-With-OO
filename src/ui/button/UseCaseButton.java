package ui.button;

import mode.UseCaseMode;
import ui.Canvas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UseCaseButton extends JToggleButton {
    private final Canvas canvas;

    public UseCaseButton() {
        super(new ImageIcon("icon/useCase.png"));
        canvas = Canvas.getInstance();
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.setMode(new UseCaseMode());
            }
        });
    }
}
