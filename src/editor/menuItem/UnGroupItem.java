package editor.menuItem;

import shape.Shape;

import java.util.ArrayList;

public class UnGroupItem extends MenuItem {
    public UnGroupItem() {
        super("ungroup");
    }

    void actionPerform() {
        ArrayList<Shape> selectList = canvas.getAllSelect();
        if(selectList.size() != 1) {
            return;
        }
        Shape target = selectList.get(0);
        if(!target.isGroup()) {
            return;
        }
        canvas.removeShape(target);
        ArrayList<Shape> recoverList = target.getElements();
        for(Shape element : recoverList) {
            canvas.addShape(element);
        }
        canvas.cleanSelect();
        canvas.repaint();
    }

}
