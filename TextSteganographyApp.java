import java.util.Scanner;

class TextHider {

    private final String coverText;
    private final String secretMessage;
    private String encodedText;

    // Constructor
    public TextHider(String coverText, String secretMessage) {
        this.coverText = coverText;
        this.secretMessage = secretMessage;
    }

    // Encode message
    public void encodeMessage() {
        encodedText = coverText + "<!--SECRET:" + secretMessage + "-->";
        System.out.println("\nMessage Hidden Successfully!");
    }

    // Decode message
    public void decodeMessage() {

        if (encodedText == null) {
            System.out.println("\nNo encoded text found!");
            return;
        }

        String startTag = "<!--SECRET:";
        String endTag = "-->";

        int start = encodedText.indexOf(startTag);
        int end = encodedText.indexOf(endTag);

        if (start == -1 || end == -1) {
            System.out.println("\nNo hidden message found!");
            return;
        }

        start += startTag.length();

        String hidden = encodedText.substring(start, end);

        System.out.println("\nHidden Message: " + hidden);
    }

    // Display encoded text
    public void displayEncodedText() {

        if (encodedText == null) {
            System.out.println("\nNo encoded text available!");
            return;
        }

        System.out.println("\nEncoded Text:\n" + encodedText);
    }
}

// Main Class
public class TextSteganographyApp {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            System.out.println("===== Text Steganography System =====");

            System.out.print("Enter Cover Text: ");
            String cover = sc.nextLine();

            System.out.print("Enter Secret Message: ");
            String secret = sc.nextLine();

            // Object Creation
            TextHider textHider = new TextHider(cover, secret);

            // Encode
            textHider.encodeMessage();

            // Display encoded text
            textHider.displayEncodedText();

            // Decode
            textHider.decodeMessage();
        }
    }
}