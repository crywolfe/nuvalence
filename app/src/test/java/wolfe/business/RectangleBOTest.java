package wolfe.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import wolfe.models.Adjacency;
import wolfe.models.Coordinate;
import wolfe.models.Rectangle;

public class RectangleBOTest {


  @Test
  void test_rectangles_intersect_upperleft_lowerright() {

    Rectangle r1 = new Rectangle(5, 0, 10,4);
    Rectangle r2 = new Rectangle(8, 2, 9, 3);
    Coordinate c1 = new Coordinate(15,2);
    Coordinate c2 = new Coordinate(8,4);
    
    List<Coordinate> expected = new ArrayList<Coordinate>();
    expected.add(c1);
    expected.add(c2);

    RectangleBO rectangleBO = new RectangleBO();
    List<Coordinate> intersectionPoints = rectangleBO.getIntersections(r1, r2);

    assertEquals(expected, intersectionPoints);
  }

  @Test
  void test_rectangles_intersect_lowerleft_upperright() {

    Rectangle r1 = new Rectangle(5, 0, 10,4);
    Rectangle r2 = new Rectangle(10, -1, 6, 2);
    Coordinate c1 = new Coordinate(15,5);
    Coordinate c2 = new Coordinate(10,0);
    
    List<Coordinate> expected = new ArrayList<Coordinate>();
    expected.add(c1);
    expected.add(c2);

    RectangleBO rectangleBO = new RectangleBO();
    List<Coordinate> intersectionPoints = rectangleBO.getIntersections(r1, r2);

    assertEquals(expected, intersectionPoints);
  }

  @Test
  void test_rectangles_intersect_upperleft_lowerloft() {

    Rectangle r1 = new Rectangle(5, 0, 10,4);
    Rectangle r2 = new Rectangle(8, -2, 9, 3);
    Coordinate c1 = new Coordinate(15,7);
    Coordinate c2 = new Coordinate(8,0);
    
    List<Coordinate> expected = new ArrayList<Coordinate>();
    expected.add(c1);
    expected.add(c2);

    RectangleBO rectangleBO = new RectangleBO();
    List<Coordinate> intersectionPoints = rectangleBO.getIntersections(r1, r2);

    assertEquals(expected, intersectionPoints);
  }

  @Test
  void test_rectangles_intersect_upperright_lowerright() {

    Rectangle r1 = new Rectangle(5, 0, 10,4);
    Rectangle r2 = new Rectangle(8, 1, 8, 2);
    Coordinate c1 = new Coordinate(15,1);
    Coordinate c2 = new Coordinate(15,3);
    
    List<Coordinate> expected = new ArrayList<Coordinate>();
    expected.add(c1);
    expected.add(c2);

    RectangleBO rectangleBO = new RectangleBO();
    List<Coordinate> intersectionPoints = rectangleBO.getIntersections(r1, r2);

    assertEquals(expected, intersectionPoints);
  }
  
  @Test
  void test_rectangles_do_not_intersect() {
    Rectangle r1 = new Rectangle(5, 0, 10,4);
    Rectangle r2 = new Rectangle(20, 10,5, 3);
    List<Coordinate> expected = new ArrayList<>();

    RectangleBO rectangleBO = new RectangleBO();
    List<Coordinate> intersection = rectangleBO.getIntersections(r1, r2);

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
