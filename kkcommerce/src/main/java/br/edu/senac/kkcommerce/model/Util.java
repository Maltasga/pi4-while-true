package br.edu.senac.kkcommerce.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author While True
 */
public class Util {

    public static java.sql.Date toSQLDate(java.util.Date data) {
        if (data == null) {
            return null;
        }
        return new java.sql.Date(data.getTime());
    }

    public static java.util.Date toUtilDate(java.sql.Date data) {
        if (data == null) {
            return null;
        }
        return new java.util.Date(data.getTime());
    }

    public static java.util.Date stringToDate(String strData) {
        Date data = null;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);
        try {
            data = format.parse(strData);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        return data;
    }

    public static boolean isNullOrEmpty(String s) {
        return s == null || "".equals(s.trim());
    }

    public static boolean isInMinLength(String s, int minLength) {
        if (!Util.isNullOrEmpty(s)) {
            return s.trim().length() >= minLength;
        }
        return false;
    }

    public static boolean isInMaxlength(String s, int maxlength) {
        if (!Util.isNullOrEmpty(s)) {
            return s.trim().length() <= maxlength;
        }
        return false;
    }

    public static boolean isEmail(String e) {
        if (Util.isNullOrEmpty(e)) {
            return false;
        }

        String emailPattern = "\\b(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";
        Pattern pattern = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(e);
        return matcher.matches();
    }
}
