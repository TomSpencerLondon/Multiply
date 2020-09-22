package basics;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BasicMathTest {
  private BasicMath basicMath;

  @Before
  public void setupBasicMath() {
    basicMath = new BasicMath();
  }

  private void assertProduct(int a, int b, int p) {
    assertThat(basicMath.multiply(a, b), is(p));
  }

  @Test
  public void spotCheck() throws Exception {
    assertProduct(0, 0, 0);
    assertProduct(1, 0, 0);
    assertProduct(1, 1, 1);
    assertProduct(1, 2, 2);
    assertProduct(2, 1, 2);
    assertProduct(1, -1, -1);
    assertProduct(-1, 1, -1);
    assertProduct(-1, -1, 1);
    assertProduct(13, 24, 312);
  }

  @Test
  public void multiplicationSpyingTest() throws Exception {
    AdderSpy adderSpy = new AdderSpy();
    basicMath.setAdder(adderSpy);
    int product = basicMath.multiply(4,3);
    assertThat(adderSpy.addCalls(),
      is(Arrays.asList("0+3","3+3","6+3", "9+3")));
    assertThat(product, is(12));
  }
}
