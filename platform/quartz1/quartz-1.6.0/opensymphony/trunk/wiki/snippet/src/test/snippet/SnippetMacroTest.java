package snippet;

import com.atlassian.renderer.RenderContext;
import com.atlassian.renderer.v2.RenderMode;
import com.atlassian.renderer.v2.SubRenderer;
import com.atlassian.renderer.v2.macro.MacroException;
import junit.framework.TestCase;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SnippetMacroTest extends TestCase
{
    static final String EOL = System.getProperty("line.separator");

    private SnippetMacro snippetMacro;
    private Map parameters;

    protected void setUp() throws Exception
    {
        snippetMacro = new SnippetMacro();
        snippetMacro.setSubRenderer(new MockSubRenderer());
        parameters = new HashMap();
    }

    public void testExecuteWritesSnippetFromParameter() throws IOException
    {
        parameters.put("id", "mySnippetId");
        parameters.put("url", snippetUrl().toExternalForm());
        assertEquals("assertEquals(2, 1 + 1);\n", executeMacro());
    }

    private URL snippetUrl()
    {
        return SnippetReaderTest.getResource("SnippetReaderTest.java");
    }

    private String executeMacro()
    {
        try
        {
            return snippetMacro.execute(parameters, "", null);
        }
        catch (MacroException e)
        {
            e.printStackTrace();
            return "";
        }
    }

    public void testIfYouPassInLangItGetsWrappedInCodeMacro() throws IOException
    {
        parameters.put("lang", "java");
        parameters.put("id", "multilineSnippet");
        parameters.put("url", snippetUrl().toExternalForm());
        assertEquals("{code:lang=java}\n" +
                "assertEquals(2, 1 + 1);\n" +
                "if(true) {\n" +
                "    assertEquals(6, 2 * 3);\n" +
                "}\n" +
                "assertEquals(2, 4 / 2);\n" +
                "{code}\n",
                executeMacro());
    }

    public void TODOtestQuotesStartCurlyBracket()
    {

    }

    public void testReturnsCachedSnippetIfSnippetIsInCache() throws IOException
    {
        URL url = new URL("file:cachedUrl");
        String id = "snippet id";
        Snippet snippet = new Snippet(Arrays.asList(new String[]{"cached content"}));
        snippetMacro.cacheSnippet(url, id, snippet);
        assertSame(snippet, snippetMacro.getSnippet(url, id, null));
    }

    public void testRemovesSnippetFromCacheWhenTimedOut() throws IOException
    {
        Snippet snippetOne = snippetMacro.getSnippet(snippetUrl(), "mySnippetId", null);
        Snippet snippetTwo = snippetMacro.getSnippet(snippetUrl(), "mySnippetId", null);
        assertSame(snippetOne, snippetTwo);

        snippetMacro.setCacheTimeout(0);
        Snippet snippetThree = snippetMacro.getSnippet(snippetUrl(), "mySnippetId", null);
        assertNotSame(snippetOne, snippetThree);
    }


    public void TODOtestCachesResults()
    {

    }

    public void testPutsInLineNumbersIfSpecified() throws IOException
    {
        parameters.put("lang", "java");
        parameters.put("id", "multilineSnippet");
        parameters.put("linenumbers", "true");
        parameters.put("url", snippetUrl().toExternalForm());
        assertEquals("{code:lang=java}\n" +
                "1. assertEquals(2, 1 + 1);\n" +
                "2. if(true) {\n" +
                "3.     assertEquals(6, 2 * 3);\n" +
                "4. }\n" +
                "5. assertEquals(2, 4 / 2);\n" +
                "{code}\n",
                executeMacro());
    }

    public void TODOtestUnindentsIfSpecified()
    {
    }

    public void TODOtestConvertsTabsToSpacesIfSpecified()
    {

    }

    public void TODOtestDisplaysRedErrorThingIfSnippetNotFound()
    {

    }

    public void TODOtestDisplaysRedErrorThingIfUrlIsInvalid()
    {

    }

    /**
     * Mock renderer that skips confluence renderering so that this test class can perform tests over raw wiki text
     */
    private class MockSubRenderer implements SubRenderer
    {
        public String render(String wiki, RenderContext renderContext, RenderMode newRenderMode)
        {
            return wiki;
        }

        public String render(String wiki, RenderContext renderContext)
        {
            return wiki;
        }

        public String renderAsText(String string, RenderContext renderContext) {
            return string;
        }

        public String getRendererType() {
            return "simple";
        }
    }
}
