package mode;

import components.Association;

public class AssociationMode extends LineMode{
    @Override
    protected void addLine() {
        canvas.add(new Association(begin, end));
    }
}
