package encryptdecrypt;

public class Decryption extends EncryptDecrypt {

    /**
     * Constructor to create an instance of class, fields initialize in superclass
     * @param text - @see EncryptDecrypt#text
     * @param key - @see EncryptDecrypt#key
     * @param fileForReadName - @see EncryptDecrypt#fileForReadName
     * @param fileToWriteName - @see EncryptDecrypt#fileToWriteName
     * @param alg - @see EncryptDecrypt#alg
     */
    public Decryption(String text, int key, String fileForReadName, String fileToWriteName, String alg) {
        super(text, key, fileForReadName, fileToWriteName, alg);
    }

    /**
     * Override method to decrypt text from field text with algorithm from field alg
     * @see EncryptDecrypt#text
     * @see EncryptDecrypt#alg
     */
    @Override
    void processData() {
        StringBuilder outText = new StringBuilder();
        char[] chars = this.text.toCharArray(); // text to array of chars to process it
        if (this.alg.equals("unicode")) { // process text with algorithm unicode (shift every char in ASCII with key value)
            for (int i = 0; i < chars.length; i++) {
                int index = chars[i] - key % 128;
                if (index < 0) {
                    index = 128 - Math.abs(index);
                }
                outText.append(chars[i] = (char) index);
            }
            this.processedText = outText.toString(); // initialize field processedText with processedData
        } else { // process with algorithm shift (shift only letters char in ASCII with key value)
            for (int i = 0; i < chars.length; i++) { // first UpperCase letters
                if (chars[i] >= 65 && chars[i] <= 90) {
                    int index = chars[i] - key % 26;
                    if (index < 65) {
                        index = 91 - (65 - Math.abs(index));
                    }
                    chars[i] = (char) index; // change char with new char
                }
            }

            for (int i = 0; i < chars.length; i++) { // second lowerCase
                if (chars[i] >= 97 && chars[i] <= 122) {
                    int index = chars[i] - key % 26;
                    if (index < 97) {
                        index = 122 - (96 - Math.abs(index));
                    }
                    chars[i] = (char) index;
                }
            }

            for (char ch : chars) { // process to string
                outText.append(ch);
            }
        }
        this.processedText = outText.toString();
    }
}
