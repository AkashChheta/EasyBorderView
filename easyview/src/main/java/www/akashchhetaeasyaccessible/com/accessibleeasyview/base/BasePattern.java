package www.akashchhetaeasyaccessible.com.accessibleeasyview.base;

public class BasePattern {

    private static int MAX_GSTNO_LENGTH = 15;
    private static int MAX_PAN_LENGHT = 10;

    private static String BLOCK_CHAR_SYMBOL = "!@#$%^&*()_{}{}<>.?/|',+-=~`";
    private static String PAN_NO_PATTEN = "[A-Z]{5}[0-9]{4}[A-Z]{1}"; //Pan No rex format
    private static String DEMO_PAN_PATTEN = "ABCDE1234F";
    private static String GST_NO_PATTEN = "([0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[1-9A-Z]{1}Z[0-9A-Z]{1})"; //GST no rex formate

    public static String getGstPattern() {
        return GST_NO_PATTEN;
    }

    public static String getPanPattern() {
        return PAN_NO_PATTEN;
    }

    public static int getPanLength() {
        return MAX_PAN_LENGHT;
    }

    public static int getGstLength() {
        return MAX_GSTNO_LENGTH;
    }

    public static String getBlockChar() {
        return BLOCK_CHAR_SYMBOL;
    }
}
