package nav.twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InformationMask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        List<String> result = new ArrayList<String>();
        while(sc.hasNextLine()) {
            input = sc.nextLine();
            if (input.indexOf("E:") != -1) {
                input = input.split("E:")[1].trim();
                result.add(maskEmail(input));
            } else if (input.indexOf("P:") != -1) {
                input = input.split("P:")[1].trim();
                result.add(maskPhone(input));
            }
        }

        for(String str : result) {
            System.out.println(str);
        }
    }

    static String maskEmail(String email){
        int index = email.indexOf("@");
        email = "E:" + email.charAt(0) + "*****" + email.substring(index - 1);
        return email;
    }
    static String maskPhone(String phone) {
        phone = phone.replaceAll("[^0-9]","");
        int phoneLength = phone.length();
        String countryCode = "";
        switch(phoneLength - 10) {
                case 1 :
                    countryCode = "+*-";
                    break;
                case 2 :
                    countryCode = "+**-";
                    break;
                case 3 :
                    countryCode = "+***-";
                    break;
                default :
                    countryCode = "";
        }
        phone = "P:" + countryCode + "***-***-" + phone.substring(phoneLength - 4);
        return phone;
    }
}