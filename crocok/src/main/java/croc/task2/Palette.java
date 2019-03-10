package croc.task2;

public class Palette {
    private Color[] colors;

    public Palette(Color[] colors) {
        this.colors = colors;
    }

    public Rgb near(Color cp) {
        double d = 100000000;
        Rgb result = null;
        Rgb c = null;
        if (cp instanceof Hsv) {
            c = ((Hsv) cp).hsvToRgb(((Hsv) cp).getHue(), ((Hsv) cp).getSaturation(), ((Hsv) cp).getValue());
        } else if (cp instanceof Grayscale) {
            c = ((Grayscale) cp).grayToRgb(((Grayscale) cp).getGray());
        } else if (cp instanceof Rgb){
            c = (Rgb) cp;
        }
        for (Color check : this.colors) {
            if (check instanceof Rgb) {
                if (((Rgb) check).distanceTo(c) < d) {
                    d = ((Rgb) check).distanceTo(c);
                    result = (Rgb) check;
                }
            } else if (check instanceof Hsv){
                Rgb res = ((Hsv) check).hsvToRgb(((Hsv) check).getHue(), ((Hsv) check).getSaturation(), ((Hsv) check).getValue());
                if (res.distanceTo(c) < d) {
                    d = res.distanceTo(c);
                    result = res;
                }
            } else if (check instanceof Grayscale) {
                Rgb res2 = ((Grayscale) check).grayToRgb(((Grayscale) check).getGray());
                if (res2.distanceTo(c) < d) {
                    d = res2.distanceTo(c);
                    result = res2;
                }
            }
        }
        return result;
    }
}
