package nl.superconsult.playground;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HelloTest {

  @Test
  public void helloTest() {
    Hello h = new Hello();

    assertEquals("Hello!", h.sayHello());
  }
}
