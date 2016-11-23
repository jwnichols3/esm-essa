package snippet;

import com.atlassian.mail.Email;
import com.atlassian.mail.MailFactory;
import com.atlassian.mail.server.SMTPMailServer;

import java.io.IOException;
import java.io.Writer;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.List;

/**
 * @author Aslak Helles&oslash;y
 * @author Jon Tirs&eacute;n
 * @author Carlos Villela
 * @version $Revision: 269 $
 */
public class Snippet {
    private final List lines;

    public Snippet(List lines) {
        this.lines = lines;
    }

    public List getLines() {
        return lines;
    }

    public void writeContent(Writer writer, boolean withLineNumbers, boolean javaDoc) throws IOException {
        NumberFormat intFormat = new DecimalFormat(getFormat(lines.size()));

        int ws = countLeadingWhiteSpaceAndJavaDoc(lines, javaDoc);
        int counter = 1;
        for (Iterator iterator = lines.iterator(); iterator.hasNext();) {
            String line = (String) iterator.next();
            if (withLineNumbers) {
                String lineNumber = intFormat.format(counter);
                writer.write(lineNumber);
                writer.write(". ");
                counter++;
            }

            String strip = stripEOL(line);
            if (strip.length() > ws) {
                writer.write(strip.substring(ws));
            }
            writer.write("\n");
        }
    }

    public static int countLeadingWhiteSpaceAndJavaDoc(List lines, boolean javaDoc) {
        int count = Integer.MAX_VALUE;
        int offsetCount = 0;
        for (Iterator iterator = lines.iterator(); iterator.hasNext();) {
            int tempCount = 0;
            String line = (String) iterator.next();
            if (javaDoc) {
                int index = line.indexOf("* ");
                offsetCount = index + 2;
                line = line.substring(offsetCount);
            }
            while (line.startsWith(" ", tempCount)) {
                tempCount++;
            }

            if (tempCount < count) {
                count = tempCount;
            }
        }

        return count + offsetCount;
    }

    public static String stripEOL(String line) {
        line = line.replaceAll("\r", "");
        line = line.replaceAll("\n", "");
        return line;
    }

    private String getFormat(int numberOfLines) {
        int numberOfDigits = (numberOfLines / 10) + 1;
        StringBuffer format = new StringBuffer();
        for(int i = 0; i < numberOfDigits; i++) {
            format.append('0');
        }
        return format.toString();
    }
}