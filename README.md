### NOTES

Due to the timeboxed nature of this exercise, rather than make this an externally facing application with exposed endpoints or UI, I wrote this using solely a TDD approach where the tests test the functionality of the application.

### RUN
1. Install gradle `brew install gradle`
2. In your terminal run `gradle clean test`

You should see output similar to this.
```
> Task :app:test
Running test: appHasAGreeting()
Running test: test_rectangle2_is_not_contained_in_rectangle1_vertical_axis()
Running test: test_rectangle2_is_partial_adjacent_to_rectangle1_lower()
Running test: test_rectangles_intersect_lowerleft_upperright()
Running test: test_rectangle2_is_properly_adjacent_to_rectangle1()
Running test: test_rectangle2_is_sub_line_adjacent_to_rectangle1()
Running test: test_rectangles_do_not_intersect()
Running test: test_rectangle2_is_partial_adjacent_to_rectangle1_higher()
Running test: test_rectangle2_is_partially_contained_in_rectangle1_thus_not_contained()
Running test: test_rectangles_intersect_lower_left_bottom_lowerright_bottom()
Running test: test_rectangles_intersect_upperleft_lowerright()
Running test: test_rectangle2_is_not_adjacent_to_rectangle1()
Running test: test_rectangles_intersect_upperright_lowerright()
Running test: test_rectangles_intersect_upperleft_lowerloft()
Running test: test_rectangle2_is_not_contained_in_rectangle1_horizontal_axis()
Running test: test_rectangle2_is_contained_in_rectangle1()
```

