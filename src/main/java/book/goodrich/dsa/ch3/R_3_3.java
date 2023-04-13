package book.goodrich.dsa.ch3;

/**
 * Explain the changes that would have to be made to the program
 * of Code Fragment 3.8 so that it could perform the Caesar Cipher
 * for messages that are written in an alphabet-based language other
 * than English, such as Greek, Russian, or Hebrew.
 */

public class R_3_3 {
    protected final char[] encoder;
    protected final char[] decoder;
    private final char firstAlphabet;

    /**
     * Slight modification of {@link E3_8_CaesarCipher} to provide
     * support for any language other than English i.e. Russian, Greek,
     * or Hebrew.
     *
     * @param firstChar first character of the alphabet.
     * @param charSetLength size of character set in that language.
     * @param rotation value of char shift for encoding and decoding.
     */
    public R_3_3(char firstChar, int charSetLength, int rotation) {
        firstAlphabet = firstChar;
        encoder = new char[charSetLength];
        decoder = new char[charSetLength];

        for (int i = 0; i < charSetLength; i++) {
            encoder[i] = (char) (firstChar + ((i + rotation) % charSetLength));
            decoder[i] = (char) (firstChar + ((i - rotation + charSetLength) % charSetLength));
        }
    }
    public String encrypt(String message) {
        return transform(message, encoder);
    }

    public String decrypt(String message) {
        return transform(message, decoder);
    }

    private String transform(String original, char[] code) {
        char[] msg = original.toCharArray();
        for (int i = 0; i < msg.length; i++) {
            if (Character.isUpperCase(msg[i])) {    // we have a letter to change
                int j = msg[i] - firstAlphabet;     // will be value from 0 to 25
                msg[i] = code[j];                   // replace the character
            }
        }
        return new String(msg);
    }

    public static void main(String[] args) {
        R_3_3 russianCipher = new R_3_3('\u0410', 32, 5);
        R_3_3 greekCipher = new R_3_3('\u0391', 24, 5);
        R_3_3 hebrewCipher = new R_3_3('\u05D0', 35, 5);

        String russianDecoded = "Привет тесту энкодера";
        String russianEncoded = russianCipher.encrypt(russianDecoded);
        if (russianDecoded.equals(russianCipher.decrypt(russianEncoded))) {
            System.out.println("russian passed");
        } else {
            System.out.println("russian failed");
        }

        String greekDecoded = "Γεια στη δοκιμή κωδικοποιητή";
        String greekEncoded = greekCipher.encrypt(greekDecoded);
        if (greekDecoded.equals(greekCipher.decrypt(greekEncoded))) {
            System.out.println("greek passed");
        } else {
            System.out.println("greek failed");
        }

        String hebrewDecoded = "שלום לבדיקת המקודד";
        String hebrewEncoded = hebrewCipher.encrypt(hebrewDecoded);
        if (hebrewDecoded.equals(hebrewCipher.decrypt(hebrewEncoded))) {
            System.out.println("hebrew passed");
        } else {
            System.out.println("hebrew failed");
        }
    }
}
