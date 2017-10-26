package Lab2;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RecognizingSisi {

    public static void main(String[] args) {
    	
    	String a;
    	 Scanner s = new Scanner (System.in);
         a = s.nextLine();

        String pattern = "[0-9]{2}[bdm][12]((seas)|(sas)|(SEAS)|(SAS)|(SOB)|(sob)|(LAW)|(law))[0-9]{4}";

        boolean matches = Pattern.matches(pattern, a);

        System.out.println("matches = " + matches);
    }
}
