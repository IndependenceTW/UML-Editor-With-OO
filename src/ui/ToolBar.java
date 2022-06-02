package ui;

import javax.swing.*;
import java.awt.*;

public class ToolBar extends JToolBar{
    ButtonGroup buttonGroup;

    public ToolBar() {
        // Initial Color
        buttonGroup = new ButtonGroup();

        //set ToolBar
        setLayout(new GridLayout(6, 1));
        setFloatable(false);

        //add buttons
        addButton(new JToggleButton(new ImageIcon("icon/select.png")));
        addButton(new JToggleButton(new ImageIcon("icon/association.png")));
        addButton(new JToggleButton(new ImageIcon("icon/generalization.png")));
        addButton(new JToggleButton(new ImageIcon("icon/composition.png")));
        addButton(new JToggleButton(new ImageIcon("icon/class.png")));
        addButton(new JToggleButton(new ImageIcon("icon/useCase.png")));
    }

    private void addButton(JToggleButton btn) {
        buttonGroup.add(btn);
        add(btn);
    }
}
