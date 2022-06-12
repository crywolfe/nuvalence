package wolfe.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

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

    assertEquals(expected, intersection);
  }

  @Test
  void test_rectangle2_is_contained_in_rectangle1() {
    Rectangle r1 = new Rectangle(5, 0, 10,4);
    Rectangle r2 = new Rectangle(6, 1, 5, 2);
    Boolean expected = true;

    GeometryBO geometryBO = new GeometryBO();
    Boolean contained = geometryBO.isContained(r1, r2);

    assertEquals(expected, contained);
  }

  @Test
  void test_rectangle2_is_not_contained_in_rectangle1_horizontal_axis() {
    Rectangle r1 = new Rectangle(5, 0, 10,4);
    Rectangle r2 = new Rectangle(16, 1, 5, 2);
    Boolean expected = false;

    GeometryBO geometryBO = new GeometryBO();
    Boolean contained = geometryBO.isContained(r1, r2);

    assertEquals(expected, contained);
  }

  @Test
  void test_rectangle2_is_not_contained_in_rectangle1_vertical_axis() {
    Rectangle r1 = new Rectangle(5, 0, 10,4);
    Rectangle r2 = new Rectangle(6, 5, 5, 2);
    Boolean expected = false;

    GeometryBO geometryBO = new GeometryBO();
    Boolean contained = geometryBO.isContained(r1, r2);

    assertEquals(expected, contained);
  }

  @Test
  void test_rectangle2_is_partially_contained_in_rectangle1_thus_not_contained() {
    Rectangle r1 = new Rectangle(5, 0, 10,4);
    Rectangle r2 = new Rectangle(8, 2, 9, 3);
    Boolean expected = false;

    GeometryBO geometryBO = new GeometryBO();
    Boolean contained = geometryBO.isContained(r1, r2);

    assertEquals(expected, contained);
  }
}
