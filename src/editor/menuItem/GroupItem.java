package editor.menuItem;

import shape.GroupObject;
import shape.Shape;

import java.util.ArrayList;

public class GroupItem extends MenuItem {
    public GroupItem() {
        super("group");
    }

    @Override
    void actionPerform() {
        ArrayList<Shape> target = canvas.getAllSelect();
        if(target.size() > 1){
            for (Shape element : target) {
                canvas.removeShape(element);
            }

            GroupObject object = new GroupObject(target);
            canvas.addShape(object);
        }

        canvas.cleanSelect();
        canvas.repaint();
    }
}
