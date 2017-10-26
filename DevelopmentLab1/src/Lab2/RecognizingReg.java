package Lab2;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RecognizingReg {

    public static void main(String[] args) {
    	
    	String a;
    	 Scanner s = new Scanner (System.in);
         a = s.nextLine();

 String pattern = "([\\u0410-\\u045f\\u04af\\u04e9\\u0451]{2})([0-9]{2})(0[1-9]|1[0-9]|2[0-9]|3[0-2])([012][0-9]|3[01])([0-9]{2})";

        boolean matches = Pattern.matches(pattern, a);

        System.out.println("matches = " + matches);
    }
}
