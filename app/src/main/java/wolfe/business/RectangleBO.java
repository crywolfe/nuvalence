package wolfe.business;

import wolfe.models.Adjacency;
import wolfe.models.Rectangle;

public class RectangleBO {

  /**
   * Computes the intersection of two rectangles. Returns a new rectangle.
   * If they do not intersect, the result will be a rectangle of 0s.
   *
   * @param r1 - the first rectangle
   * @param r2 - the second rectangle
   * @return a new rectangle {@link Rectangle} with x, y, width, height.
   */
  public Rectangle getIntersection(Rectangle r1, Rectangle r2) {
  
    if(!isIntersect(r1, r2)){
      return new Rectangle(0,0,0,0);
    }

    return new Rectangle(
      Math.max(r1.getX(), r2.getX()), Math.max(r1.getY(), r2.getY()),
      Math.min(r1.getX() + r1.getWidth(), r2.getX() + r2.getWidth()) - Math.max(r1.getX(), r2.getX()),
      Math.min(r1.getY() + r1.getHeight(), r2.getY() + r2.getHeight()) - Math.max(r1.getY(), r2.getY())
    );
  }

  private Boolean isIntersect(Rectangle r1, Rectangle r2) {
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
