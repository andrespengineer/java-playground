import com.sun.tools.attach.VirtualMachineDescriptor;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

import java.lang.instrument.Instrumentation;
import java.util.*;

public class DataSize {

    public static void main(String[] args) {

        MyObject obj = new MyObject();
    }
}

enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

class MyObject {
    public String emptyString = "";
    public String string = "jkasdksjaasdjs";
    public String[] stringArray = { emptyString, string, "com.baeldung" };
    public String[] anotherStringArray = new String[100];
    public List<String> stringList = new ArrayList<>();
    public StringBuilder stringBuilder = new StringBuilder(100);
    public int maxIntPrimitive = Integer.MAX_VALUE;
    public int minIntPrimitive = Integer.MIN_VALUE;
    public Integer maxInteger = Integer.MAX_VALUE;
    public Integer minInteger = Integer.MIN_VALUE;
    public Long longobject = Long.MAX_VALUE;
    public long zeroLong = 0L;
    public double zeroDouble = 0.0;
    public boolean falseBoolean = false;
    public Object object = new Object();
    public EmptyClass emptyClass = new EmptyClass();
    public StringClass stringClass = new StringClass();

    public MyObject(){
        Arrays.setAll(anotherStringArray, v -> new String(""));

        System.out.println(ClassLayout.parseInstance(this).toPrintable());

        System.out.println();
        System.out.println("------------------------String Array-------------------------------");
        System.out.println(ClassLayout.parseInstance(stringArray).toPrintable());

        System.out.println();

        System.out.println("------------------------Another String Array-------------------------------");
        System.out.println(ClassLayout.parseInstance(anotherStringArray).toPrintable());

        System.out.println();
        System.out.print("------------------------String content-------------------------------");
        System.out.println(ClassLayout.parseInstance(string.toCharArray()).toPrintable());


        System.out.println();
        System.out.print("------------------------Empty String content-------------------------------");
        System.out.println(ClassLayout.parseInstance(emptyString.toCharArray()).toPrintable());
    }
}

class EmptyClass {

}

class StringClass {
    public String s;
}

