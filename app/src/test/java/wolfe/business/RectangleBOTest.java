package wolfe.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import wolfe.models.Adjacency;
import wolfe.models.Rectangle;

public class RectangleBOTest {


  @Test
  void test_rectangles_intersect() {

    Rectangle r1 = new Rectangle(5, 0, 10,4);
    Rectangle r2 = new Rectangle(8, 2, 9, 3);
    Rectangle expected = new Rectangle(8, 2, 7, 2);

    RectangleBO rectangleBO = new RectangleBO();
    Rectangle intersection = rectangleBO.getIntersection(r1, r2);
    System.out.println(intersection.toString());

    assertEquals(expected, intersection);

  }

  @Test
  void test_rectangles_do_not_intersect() {
    Rectangle r1 = new Rectangle(5, 0, 10,4);
    Rectangle r2 = new Rectangle(20, 10,5, 3);
    Rectangle expected = new Rectangle(0, 0, 0, 0);

    RectangleBO rectangleBO = new RectangleBO();
    Rectangle intersection = rectangleBO.getIntersection(r1, r2);

    assertEquals(expected, intersection);
  }

  @Test
  void test_rectangle2_is_contained_in_rectangle1() {
    Rectangle r1 = new Rectangle(5, 0, 10,4);
    Rectangle r2 = new Rectangle(6, 1, 5, 2);
    Boolean expected = true;

    RectangleBO rectangleBO = new RectangleBO();
    Boolean contained = rectangleBO.isContained(r1, r2);

    assertEquals(expected, contained);
  }

  @Test
  void test_rectangle2_is_not_contained_in_rectangle1_horizontal_axis() {
    Rectangle r1 = new Rectangle(5, 0, 10,4);
    Rectangle r2 = new Rectangle(16, 1, 5, 2);
    Boolean expected = false;

    RectangleBO rectangleBO = new RectangleBO();
    Boolean contained = rectangleBO.isContained(r1, r2);

    assertEquals(expected, contained);
  }

  @Test
  void test_rectangle2_is_not_contained_in_rectangle1_vertical_axis() {
    Rectangle r1 = new Rectangle(5, 0, 10,4);
    Rectangle r2 = new Rectangle(6, 5, 5, 2);
    Boolean expected = false;

    RectangleBO rectangleBO = new RectangleBO();
    Boolean contained = rectangleBO.isContained(r1, r2);

    assertEquals(expected, contained);
  }

  @Test
  void test_rectangle2_is_partially_contained_in_rectangle1_thus_not_contained() {
    Rectangle r1 = new Rectangle(5, 0, 10,4);
    Rectangle r2 = new Rectangle(8, 2, 9, 3);
    Boolean expected = false;

    RectangleBO rectangleBO = new RectangleBO();
    Boolean contained = rectangleBO.isContained(r1, r2);

    assertEquals(expected, contained);
  }

  @Test
  void test_rectangle2_is_properly_adjacent_to_rectangle1() {
    Rectangle r1 = new Rectangle(5, 0, 10,4);
    Rectangle r2 = new Rectangle(15, 0, 5, 4);
    Adjacency expected = Adjacency.PROPER;

    RectangleBO rectangleBO = new RectangleBO();
    Adjacency proper = rectangleBO.getAdjacency(r1, r2);

    assertEquals(expected, proper);

  }

  @Test
  void test_rectangle2_is_sub_line_adjacent_to_rectangle1() {
    Rectangle r1 = new Rectangle(5, 0, 10,4);
    Rectangle r2 = new Rectangle(15, 1, 5, 2);
    Adjacency expected = Adjacency.SUB_LINE;

    RectangleBO rectangleBO = new RectangleBO();
    Adjacency subline = rectangleBO.getAdjacency(r1, r2);

    assertEquals(expected, subline);
  }

  @Test
  void test_rectangle2_is_partial_adjacent_to_rectangle1_higher() {
    Rectangle r1 = new Rectangle(5, 0, 10,4);
    Rectangle r2 = new Rectangle(15, 1, 5, 6);
    Adjacency expected = Adjacency.PARTIAL;

    RectangleBO rectangleBO = new RectangleBO();
    Adjacency partial = rectangleBO.getAdjacency(r1, r2);

    assertEquals(expected, partial);
  }

  @Test
  void test_rectangle2_is_partial_adjacent_to_rectangle1_lower() {
    Rectangle r1 = new Rectangle(5, 0, 10,4);
    Rectangle r2 = new Rectangle(15, -5, 5, 6);
    Adjacency expected = Adjacency.PARTIAL;

    RectangleBO rectangleBO = new RectangleBO();
    Adjacency partial = rectangleBO.getAdjacency(r1, r2);

    assertEquals(expected, partial);
  }

  @Test
  void test_rectangle2_is_not_adjacent_to_rectangle1() {
    Rectangle r1 = new Rectangle(5, 0, 10,4);
    Rectangle r2 = new Rectangle(17, 0, 5, 6);
    Adjacency expected = Adjacency.NOT_ADJACENT;

    RectangleBO rectangleBO = new RectangleBO();
    Adjacency notAdjacent = rectangleBO.getAdjacency(r1, r2);

    assertEquals(expected, notAdjacent);
  }
}
