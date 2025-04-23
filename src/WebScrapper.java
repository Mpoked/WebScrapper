import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebScrapper {

    public void nacteniStranky(Document doc) {
        Element contentDiv = doc.selectFirst("div.thecontent.clearfix");
        if (contentDiv == null) {
            System.out.println("Div s třídou 'thecontent clearfix' nebyl nalezen.");
            return;
        }

        // Projde všechny paragraphy, které mají <strong>
        Elements paragraphs = contentDiv.select("p:has(strong)");

        for (Element paragraph : paragraphs) {
            String question = paragraph.text();
            if (question.contains("?")) {
                System.out.println("Otázka: " + question);

                // Najde následující <ul> s odpověďmi
                Element next = paragraph.nextElementSibling();
                if (next != null && next.tagName().equals("ul")) {
                    Elements correctAnswers = next.select("li.correct_answer");
                    for (Element answer : correctAnswers) {
                        System.out.println("Správná odpověď: " + answer.text());
                    }
                }

                System.out.println(); // oddělovač

            }
        }
    }

}
