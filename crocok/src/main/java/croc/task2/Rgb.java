package croc.task2;

public class Rgb extends Color{
    private double red;
    private double green;
    private double blue;

    public Rgb(double red, double green, double blue, String model) {
        if (red >= 0 && red <= 255) {
            this.red = red;
        }
        if (green >= 0 && green <= 255) {
            this.green = green;
        }
        if (blue >= 0 && blue <= 255) {
            this.blue = blue;
        }
        this.model = model;
    }

    public double distanceTo(Rgb that) {
        return Math.sqrt(
                Math.pow(this.getRed() - that.getRed(), 2) + Math.pow(this.getGreen() - that.getGreen(), 2) + Math.pow(this.getBlue() - that.getBlue(), 2)
        );
    }

    public double getBlue() {
        return blue;
    }

    public double getGreen() {
        return green;
    }

    public double getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }
}
