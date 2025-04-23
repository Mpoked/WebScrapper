import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class Main {


    public static void main(String[] args) throws Exception {
        WebScrapper webScrapper = new WebScrapper();
        Document doc = Jsoup.connect("https://itexamanswers.net/it-essentials-version-8-0-chapter-12-exam-answers-ite-v8-0.html").get();
        webScrapper.nacteniStranky(doc);

        GUI gui = new GUI();
        gui.guiViditelne();
    }

}
