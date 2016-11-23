package snippet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * @author Jon Tirs&eacute;n
 * @author Aslak Helles&oslash;y
 * @author Carlos Villela
 * @author Nick Sieger
 * @version $Revision: 238 $
 */
public class SnippetReader {
    private final URL source;
    private static final Pattern LEADING_WHITE = Pattern.compile("^(\\s*)\\S.*");

    public SnippetReader(URL source) {
        this.source = source;
    }

    public Snippet readSnippet(String snippetId) throws IOException {
        List lines = readLines(snippetId);
        List snippetLines = new ArrayList();
        int minIndent = minIndent(lines);
        for (Iterator iterator = lines.iterator(); iterator.hasNext();) {
            String line = (String) iterator.next();
            if (!isDemarcator(line)) {
                snippetLines.add(line.length() >= minIndent
                                 ? line.substring(minIndent) : line);
            }
        }
        return new Snippet(snippetLines);
    }

    int minIndent(List lines) {
        int minIndent = Integer.MAX_VALUE;
        for (Iterator iterator = lines.iterator(); iterator.hasNext();) {
            String line = (String) iterator.next();
            minIndent = Math.min(minIndent, indent(line));
        }
        return minIndent;
    }

    int indent(String line) {
        Matcher m = LEADING_WHITE.matcher(line);

        if (m.matches()) {
            String space = m.group(1);
            return space.length();
        }

        // lines with only whitespace don't count towards minimum
        // indentation
        return Integer.MAX_VALUE;
    }

    private List readLines(String snippetId) throws IOException {
        boolean all = "ALL".equalsIgnoreCase(snippetId);

        BufferedReader reader = new BufferedReader(new InputStreamReader(source.openStream()));
        List lines = new ArrayList();
        try {
            boolean capture = false;
            String line;
            while ((line = reader.readLine()) != null) {
                if (all) {
                    lines.add(line);
                } else if (isStart(snippetId, line)) {
                    capture = true;
                } else if (isEnd(snippetId, line)) {
                    break;
                } else if (capture) {
                    lines.add(line);
                }
            }
        } finally {
            reader.close();
        }
        return lines;
    }

    protected boolean isStart(String snippetId, String line) {
        return isDemarcator(snippetId, "START", line);
    }

    protected boolean isDemarcator(String snippetId, String what, String line) {
        String upper = line.toUpperCase();
        return isDemarcator(line) &&
                upper.indexOf(what.toUpperCase()) != -1 &&
                line.indexOf(snippetId) != -1;
    }

    protected boolean isDemarcator(String line) {
        String upper = line.toUpperCase();
        return upper.indexOf("SNIPPET") != -1;
    }

    protected boolean isEnd(String snippetId, String line) {
        return isDemarcator(snippetId, "END", line);
    }
}
