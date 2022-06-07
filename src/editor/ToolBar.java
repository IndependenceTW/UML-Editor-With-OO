package editor;

import mode.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBar extends JToolBar{
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private final ImageIcon associationIcon = new ImageIcon("icon/association.png");
    private final ImageIcon classIcon = new ImageIcon("icon/class.png");
    private final ImageIcon compositionIcon = new ImageIcon("icon/composition.png");
    private final ImageIcon generalizationIcon = new ImageIcon("icon/generalization.png");
    private final ImageIcon selectIcon = new ImageIcon("icon/select.png");
    private final ImageIcon useCaseIcon = new ImageIcon("icon/useCase.png");

    Canvas canvas = Canvas.getInstance();

    public ToolBar() {

        //set ToolBar
        setLayout(new GridLayout(6, 1));
        setFloatable(false);

        //add buttons
        addButton(selectIcon, new SelectMode());
        addButton(associationIcon, new AssociationMode());
        addButton(generalizationIcon, new GeneralizationMode());
        addButton(compositionIcon, new CompositionMode());
        addButton(classIcon, new ClassMode());
        addButton(useCaseIcon, new UseCaseMode());
    }

    private void addButton(ImageIcon icon, Mode mode) {
        ModeButton newButton = new ModeButton(icon, mode);
        newButton.addActionListener(new ButtonListener());
        buttonGroup.add(newButton);
        add(newButton);
    }

    private static class ModeButton extends JToggleButton {
        // Todo mode variable
        Mode mode;
        ModeButton(ImageIcon icon, Mode mode) {
            setIcon(icon);
            this.mode = mode;
        }
        public Mode getMode() {
            return mode;
        }
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ModeButton button= (ModeButton) e.getSource();
            System.out.println("hello");
            canvas.setMode(button.getMode());
        }
    }


}
