package ui.button;

import mode.AssociationMode;
import mode.LineMode;
import ui.Canvas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AssociationButton extends JToggleButton {
    private final Canvas canvas;

    public AssociationButton() {
        super(new ImageIcon("icon/association.png"));
        canvas = Canvas.getInstance();
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.setMode(new AssociationMode());
            }
        });
    }
}
