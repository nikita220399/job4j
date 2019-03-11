package croc.task2;

public class Hsv extends Color{
    private int hue;
    private double saturation;
    private double value;

    public Hsv(int hue, double saturation, double value) {
        if (hue >= 0 && hue <= 359) {
            this.hue = hue;
        }
        if (saturation >= 0 && saturation <= 1) {
            this.saturation = saturation;
        }
        if (value >= 0 && value <= 1) {
            this.value = value;
        }
    }

    public int getHue() {
        return this.hue;
    }

    public double getValue() {
        return this.value;
    }

    public double getSaturation() {
        return this.saturation;
    }

    public void setHue(int hue) {
        this.hue = hue;
    }

    public void setSaturation(double saturation) {
        this.saturation = saturation;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
