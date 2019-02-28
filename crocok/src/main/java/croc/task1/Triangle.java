package croc.task1;

public class Triangle {
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    private double perim(double ab, double ac, double bc) {
        return (ab + ac + bc) / 2;
    }

    public double square() {
        double ab = this.a.distanceTo(this.b);
        double ac = this.a.distanceTo(this.c);
        double bc = this.b.distanceTo(this.c);
        double p = this.perim(ab, ac, bc);
        double rsl = Math.sqrt(p * (p - ab) * (p - bc) * (p - ac));
        return rsl;
    }
}
