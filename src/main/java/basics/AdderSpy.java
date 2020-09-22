package basics;

import java.util.ArrayList;
import java.util.List;

public class AdderSpy extends Adder {
  private List<String> addCalls = new ArrayList<String>();

  public int add(int a, int b) {
    addCalls.add(a+"+"+b);
    return super.add(a, b);
  }

  public List<String> addCalls() {
    return addCalls;
  }
}
