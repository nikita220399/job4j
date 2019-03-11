package croc.task2;

public class Palette {
    private Color[] colors;

    public Palette(Color[] colors) {
        this.colors = colors;
    }

    public Rgb near(Color cp) {
        double d = 10000000;
        Rgb result = null;
        Rgb c = cp.toRgb();
        for (Color check : this.colors) {
            if (check.toRgb().distanceTo(c) < d) {
                d = check.toRgb().distanceTo(c);
                result = check.toRgb();
            }
        }
        return result;
    }
}
