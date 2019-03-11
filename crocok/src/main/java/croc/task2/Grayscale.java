package croc.task2;

public class Grayscale extends Color{
    private double gray;

    public Grayscale(double gray) {
        if (gray >= 0 && gray <= 1) {
            this.gray = gray;
        }
    }

    public double getGray() {
        return gray;
    }

    public void setGray(double gray) {
        this.gray = gray;
    }
}
