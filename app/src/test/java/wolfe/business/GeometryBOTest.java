package wolfe.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import wolfe.models.Rectangle;

public class GeometryBOTest {


  @Test
  void test_rectangles_intersect() {

    Rectangle r1 = new Rectangle(5, 0, 10,4);
    Rectangle r2 = new Rectangle(8, 2, 9, 3);
    Rectangle expected = new Rectangle(8, 2, 7, 2);

    GeometryBO geometryBO = new GeometryBO();
    Rectangle intersection = geometryBO.getIntersection(r1, r2);
    System.out.println(intersection.toString());

    assertEquals(expected, intersection);

  }

  @Test
  void test_rectangles_do_not_intersect() {
    Rectangle r1 = new Rectangle(5, 0, 10,4);
    Rectangle r2 = new Rectangle(20, 10,5, 3);
    Rectangle expected = new Rectangle(0, 0, 0, 0);

    GeometryBO geometryBO = new GeometryBO();
    Rectangle intersection = geometryBO.getIntersection(r1, r2);
    System.out.println(intersection.toString());

    assertEquals(expected, intersection);
  }
}
