package nl.superconsult.playground;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ReflectionTest {

  @Test(expected=ClassNotFoundException.class)
  public void reflectionTestNonExistingClass() throws ClassNotFoundException {
      IReflection f = new Reflection("DummyClass");

      f.getClassModifiers();
      fail("Exception should be thrown");
  }

  @Test
  public void reflectionTestForDouble() throws ClassNotFoundException {
      IReflection f = new Reflection("java.lang.Double");

      assertEquals("public final", f.getClassModifiers());

      System.out.println(f);
  }

  @Test
  public void reflectionTestForString() throws ClassNotFoundException {
      IReflection f = new Reflection("java.lang.String");

      assertEquals("public final", f.getClassModifiers());
  }

  @Test
  public void reflectionTestForJavaLangClass() throws ClassNotFoundException {
      IReflection f = new Reflection("java.lang.Class");

      assertEquals("public final", f.getClassModifiers());

      System.out.println(f);
  }

  @Test
  public void reflectionTestForJavaLangObject() throws ClassNotFoundException {
      IReflection f = new Reflection("java.lang.Object");

      assertEquals("public", f.getClassModifiers());

      System.out.println(f);
  }
}
