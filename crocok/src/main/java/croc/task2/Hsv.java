package croc.task2;

public class Hsv extends Color{
    private int hue;
    private double saturation;
    private double value;

    public Hsv(int hue, double saturation, double value, String model) {
        if (hue >= 0 && hue <= 359) {
            this.hue = hue;
        }
        if (saturation >= 0 && saturation <= 1) {
            this.saturation = saturation;
        }
        if (value >= 0 && value <= 1) {
            this.value = value;
        }
        this.model = model;
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

    public Rgb hsvToRgb(int h, double s, double v) {
        double r, g, b;
        if (s == 0) {
            r = v * 255; g = v * 255; b = v * 255;
        } else {
            double var_h = ((double) h / 360) * 6;
            int var_i = (int) var_h;
            double var_1 = v * (1 - s);
            double var_2 = v * (1 - s * (var_h - var_i));
            double var_3 = v * (1 - s * (1 - (var_h - var_i)));
            double var_r;
            double var_g;
            double var_b;

            if      ( var_i == 0 ) { var_r = v     ; var_g = var_3 ; var_b = var_1; }
            else if ( var_i == 1 ) { var_r = var_2 ; var_g = v     ; var_b = var_1; }
            else if ( var_i == 2 ) { var_r = var_1 ; var_g = v     ; var_b = var_3; }
            else if ( var_i == 3 ) { var_r = var_1 ; var_g = var_2 ; var_b = v;     }
            else if ( var_i == 4 ) { var_r = var_3 ; var_g = var_1 ; var_b = v;     }
            else                   { var_r = v     ; var_g = var_1 ; var_b = var_2; }

            r = var_r * 255;
            g = var_g * 255;
            b = var_b * 255;
        }
        Rgb res = new Rgb(r, g, b, "rgb");
        return res;
    }
}
