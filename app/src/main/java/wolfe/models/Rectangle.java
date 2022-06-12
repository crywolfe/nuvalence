package wolfe.models;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Rectangle {
  // x,y is bottom left corner
  private final Integer x;
  private final Integer y;
  private final Integer width;
  private final Integer height;
}
