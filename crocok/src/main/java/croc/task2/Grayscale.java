package croc.task2;

public class Grayscale extends Color{
    private double gray;

    public Grayscale(double gray, String model) {
        if (gray >= 0 && gray <= 1) {
            this.gray = gray;
        }
        this.model = model;
    }

    public double getGray() {
        return gray;
    }

    public void setGray(double gray) {
        this.gray = gray;
    }

    public Rgb grayToRgb(double x) {
        double k = x * 255;
        Rgb res = new Rgb(k, k, k, "rgb");
        return res;
    }
}
