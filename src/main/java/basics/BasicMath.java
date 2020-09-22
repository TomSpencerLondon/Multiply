package basics;

public class BasicMath {
  private Adder adder;

  public BasicMath() {
    adder = new Adder();
  }

  public int multiply(int a, int b) {
    boolean posA = a >= 0;
    boolean posB = b >= 0;
    boolean negP = posA != posB;

    a = posA ? a : -a;
    b = posB ? b : -b;

    int p = shiftAndAdd(a, b);

    return negP ? -p : p;
  }

  private int shiftAndAdd(int a, int b) {
    int p;
    for (p = 0; a > 0; b <<= 1,a >>= 1) {
      if ((a & 1) == 1)
        p = adder.add(p, b);
    }
    return p;
  }

  private int repetativeAdd(int a, int b) {
    int p = 0;
    while (a-- > 0)
      p = adder.add(p, b);
    return p;
  }

  public void setAdder(Adder adder) {
    this.adder = adder;
  }
}
