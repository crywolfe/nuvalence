package wolfe.business;

import java.util.ArrayList;
import java.util.List;

import wolfe.models.Adjacency;
import wolfe.models.Coordinate;
import wolfe.models.Rectangle;

public class RectangleBO {

  /**
   * Computes the intersection of two rectangles. Returns coordinates of the intersected points.
   * If they do not intersect, the result will be an empty list.
   *
   * @param r1 - the first rectangle
   * @param r2 - the second rectangle
   * @return a new rectangle {@link Rectangle} with x, y, width, height.
   */
  public List<Coordinate> getIntersections(Rectangle r1, Rectangle r2) {
    List<Coordinate> coordinates = new ArrayList<>();
  
    if(!isIntersection(r1, r2)){
      return coordinates;
    }

    // lr = lower right, ul = upper left, ur = upper right, ll = lower left, iur = inner upper right, illb = inner lower left bottom, illr = inner lower right bottom
    Coordinate lr = new Coordinate(r1.getX() + r1.getWidth(), r2.getY());
    Coordinate ul = new Coordinate(r2.getX(), r1.getY() + r1.getHeight());
    Coordinate ur = new Coordinate(r1.getX() + r1.getWidth(), r2.getY() + r2.getWidth());
    Coordinate ll = new Coordinate(r2.getX(), r1.getY());
    Coordinate iur = new Coordinate(
      Math.min(r1.getX() + r1.getWidth(), r2.getX() + r2.getWidth()), 
      Math.max(r1.getY(), r2.getY())
    );
    Coordinate ilr = new Coordinate(
      Math.min(r1.getX() + r1.getWidth(), r2.getX() + r2.getWidth()), 
      Math.min(r1.getY() + r1.getHeight(), r2.getY() + r2.getHeight())
    );
    Coordinate illb = new Coordinate(
      Math.max(r1.getX(), r2.getX()), 
      Math.max(r1.getY(), r2.getY())
    );
    Coordinate ilrb = new Coordinate(
      Math.min(r1.getX() + r1.getWidth(), r2.getX() + r2.getWidth()), 
      Math.max(r1.getY(), r2.getY())
    );
    
    if (r1.getX() <= r2.getX()) {
      if (r1.getY() < r2.getY() && r1.getY() + r1.getHeight() > r2.getY() + r2.getHeight()) {
        coordinates.add(iur);
        coordinates.add(ilr);
      } else if (
        r1.getY() > r2.getY() && 
        r1.getY() + r1.getHeight() > r2.getY() + r2.getHeight() &&
        r1.getX() + r1.getWidth() > r2.getX() + r2.getWidth()) {
          coordinates.add(illb);
          coordinates.add(ilrb);
      } else if (r1.getY() < r2.getY()) {
        coordinates.add(lr);
        coordinates.add(ul);
      } else {
        coordinates.add(ur);
        coordinates.add(ll);
      }
  } else return getIntersections(r2, r1);

  return coordinates;

  }

  private Boolean isIntersection(Rectangle r1, Rectangle r2) {
    return 
    r1.getX() <= (r2.getX() + r2.getWidth()) && 
    (r1.getX() + r1.getWidth()) >= r2.getX() &&
    r1.getY() <= (r2.getY() + r2.getHeight()) && 
    (r1.getY() + r1.getHeight()) >= r2.getY();
  }
  
    /**
   * Returns the boolean of whether r2 is fully contained in r1.
   *
   * @param r1 - the first rectangle
   * @param r2 - the second rectangle
   * @return a boolean {@link Boolean}.
   */
  public Boolean isContained(Rectangle r1, Rectangle r2) {
    if (
      r2.getX() > r1.getX() && 
      r2.getX() + r2.getWidth() < r1.getX() + r1.getWidth() &&
      r2.getY() + r2.getHeight() < r1.getY() + r1.getHeight() &&
      r2.getY() > r1.getY()) {
        return true;
      }
    return false;
  }

    /**
   * Returns the adjacency type of two rectangles.
   *
   * @param r1 - the first rectangle
   * @param r2 - the second rectangle
   * @return an adjacency type {@link Adjacency}.
   */
  public Adjacency getAdjacency(Rectangle r1, Rectangle r2) {
    if (r2.getX() != r1.getX() + r1.getWidth()) {
      return Adjacency.NOT_ADJACENT;
    }

    if (
      r2.getY() == r1.getY() &&
      r2.getHeight() == r1.getHeight()) {
        return Adjacency.PROPER;
    }

    if (
      r2.getY() > r1.getY() &&
      r2.getY() + r2.getHeight() < r1.getY() + r1.getHeight()
    ) {
      return Adjacency.SUB_LINE;
    }

    if (
      (r2.getY() > r1.getY() &&
      r2.getY() + r2.getHeight() > r1.getY() + r1.getHeight()) ||
      (r2.getY() < r1.getY() &&
      r2.getY() + r2.getHeight() < r1.getY() + r1.getHeight())
    ) {
      return Adjacency.PARTIAL;
    }
    return Adjacency.NOT_ADJACENT;

  }

}
