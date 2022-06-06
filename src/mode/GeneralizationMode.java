package mode;

import components.Association;
import components.Generalization;

public class GeneralizationMode extends LineMode{
    @Override
    protected void addLine() {
        canvas.add(new Generalization(begin, end));
    }
}
