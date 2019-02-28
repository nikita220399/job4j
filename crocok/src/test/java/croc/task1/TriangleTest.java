package croc.task1;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;

public class TriangleTest {
    @Test
    public void whenSetThreePointsThenTriangleSquare() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(3, 0);
        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.square();
        double answer = 3;
        assertThat(result, closeTo(answer, 0.1));
    }
}
