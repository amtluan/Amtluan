package LAB5;
import java.text.DecimalFormat;
public class DecimalFormatDemo
{
    static public String setCodeFormat(String pattern, int value)
    {
        DecimalFormat myFormatter = new DecimalFormat(pattern);
        String output = myFormatter.format(value);
        return output;
    }
}
