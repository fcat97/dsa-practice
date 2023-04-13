package book.goodrich.dsa.ch3;

public class E3_8_CaesarCipher {
    protected char[] encoder = new char[26];
    protected char[] decoder = new char[26];

    /** Constructor that initializes the encryption and decryption arrays*/
    public E3_8_CaesarCipher(int rotation) {
        for (int i = 0; i < 26; i++) {
            encoder[i] = (char) ('A' + ((i + rotation) % 26));
            decoder[i] = (char) ('A' + ((i - rotation + 26) % 26));
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
                int j = msg[i] - 'A';               // will be value from 0 to 25
                msg[i] = code[j];                   // replace the character
            }
        }
        return new String(msg);
    }

    public static void main(String[] args) {
        E3_8_CaesarCipher cipher = new E3_8_CaesarCipher(3);
        System.out.println("Encrypted code = " + new String(cipher.encoder));
        System.out.println("Decrypted code = " + new String(cipher.decoder));
        String message = "THE EAGLE IS IN PLAY; MEET AT JOE'S.";
        String coded = cipher.encrypt(message);
        System.out.println("Secret: " + coded);
        String answer = cipher.decrypt(coded);
        System.out.println("Answer: " + answer);
    }
}
