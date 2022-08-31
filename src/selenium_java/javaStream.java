package selenium_java;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class javaStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String>names=new ArrayList<String>();
		names.add("Rama");
		names.add("Avenger");
		names.add("RANA");
		names.add("Rudra");
		names.add("Rama");
		names.add("Surya");
		names.add("Kama");
		
		names.stream().filter(s-> s.equalsIgnoreCase(s) && s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		

	}

}
