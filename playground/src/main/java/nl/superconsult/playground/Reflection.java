package nl.superconsult.playground;

import java.lang.reflect.*;

class Reflection implements IReflection {
   private String clazz;
   private Class cl;

   public Reflection(String aClazz) throws ClassNotFoundException {
      clazz = aClazz;
      cl = Class.forName(clazz);
   }

   public String getClassModifiers() {
      return Modifier.toString(cl.getModifiers());
   }

   public String getExtends() {
      Class superClass = cl.getSuperclass();

      return null != superClass ? " extends " + superClass.getName() : "";
   }

   private String getParameterTypes(Class[] aParameterTypes) {
      StringBuilder str = new StringBuilder();

      for (int i=0; i<aParameterTypes.length; i++) {
         if (i > 0) str.append(", ");
         str.append(aParameterTypes[i].getName());
      }

      return str.toString();
   }

   public String getConstructors() {
      StringBuilder str = new StringBuilder();

      for (Constructor c: cl.getDeclaredConstructors()) {
         str.append("  " + Modifier.toString(c.getModifiers()) + " " + c.getName() + "(");
         str.append(getParameterTypes(c.getParameterTypes()));
         str.append(");\n");
      }

      return str.toString();
   }

   public String getMethods() {
      StringBuilder str = new StringBuilder();

      for (Method m: cl.getDeclaredMethods()) {
         str.append("  " + Modifier.toString(m.getModifiers()) + " " + m.getName() + "(");
         str.append(getParameterTypes(m.getParameterTypes()));
         str.append(");\n");
      }

      return str.toString();
   }

   public String getFields() {
      StringBuilder str = new StringBuilder();

      for (Field f: cl.getDeclaredFields()) {
         str.append("  " + Modifier.toString(f.getModifiers()) + " " + f.getName() + ";\n");
      }

      return str.toString();
   }

   @Override
   public String toString() {
      StringBuilder str = new StringBuilder();

      str.append(getClassModifiers() + " class " + clazz + getExtends() + " {\n");
      str.append(getConstructors() + "\n");
      str.append(getMethods() + "\n");
      str.append(getFields());
      str.append("}\n");

      return str.toString();
   }
}
