import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.XPatherException;

public class Parser {

    public static String pars(String htmlContent, String xPath){

        try {
            HtmlCleaner cleaner = new HtmlCleaner();
            TagNode html = cleaner.clean(htmlContent);

            Object[] tags = html.evaluateXPath(xPath);
            System.out.println(tags.length);
            for(Object tag : tags){
                TagNode tagNode = (TagNode)tag;
                System.out.println(tagNode.getText());
            }
        } catch (XPatherException e) {
            e.printStackTrace();
        }

        return null;
    }

}
