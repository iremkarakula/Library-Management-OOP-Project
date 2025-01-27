package util;

import java.util.regex.Pattern;

public class ValidatePhone {

    public static boolean isValidPhoneNumber(String phone) {
        String phoneRegex = "^[0-9]{10}$";
        Pattern pattern = Pattern.compile(phoneRegex);
        return pattern.matcher(phone).matches();
    }
}
