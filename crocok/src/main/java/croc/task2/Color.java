package croc.task2;

public class Color {

    public Rgb toRgb() {
        Rgb res = null;
        if (this instanceof Rgb) {
            res = (Rgb) this;
        } else if (this instanceof Hsv) {
            double r, g, b;
            double v = ((Hsv) this).getValue();
            double s = ((Hsv) this).getSaturation();
            double h = ((Hsv) this).getHue();
            if (v == 0) {
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
            res = new Rgb(r, g, b);
        } else if (this instanceof Grayscale){
            double k = ((Grayscale) this).getGray() * 255;
            res = new Rgb(k, k, k);
        }
        return res;
    }
}