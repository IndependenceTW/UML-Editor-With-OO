package mode;

import components.Composition;

public class CompositionMode extends LineMode{
    @Override
    protected void addLine() {
        canvas.add(new Composition(begin, end));
    }
}
