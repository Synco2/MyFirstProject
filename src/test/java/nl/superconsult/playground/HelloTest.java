package nl.superconsult.playground;

import org.junit.Test;

class HelloTest {
  
  @Test
  public final void helloTest() {
    Hello h = new Hello();
    
    assertEquals("Hello", h.sayHello());
  }
}
