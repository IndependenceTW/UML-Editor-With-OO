package ui;

import ui.button.*;

import javax.swing.*;
import java.awt.*;

public class ToolBar extends JToolBar{
    private final ButtonGroup buttonGroup;

    public ToolBar() {
        // Initial Color
        buttonGroup = new ButtonGroup();
        //set ToolBar
        setLayout(new GridLayout(6, 1));
        setFloatable(false);

        //add buttons
        addButton(new JToggleButton(new ImageIcon("icon/select.png")));
        addButton(new AssociationButton());
        addButton(new GeneralizationButton());
        addButton(new CompositionButton());
        addButton(new ClassButton());
        addButton(new UseCaseButton());

    }

    private void addButton(JToggleButton btn) {
        buttonGroup.add(btn);
        add(btn);
    }
}
