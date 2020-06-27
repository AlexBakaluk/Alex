package encryptdecrypt;

public class Encryption extends EncryptDecrypt {

    /**
     * Constructor to create an instance of class, fields initialize in superclass
     * @param text - @see EncryptDecrypt#text
     * @param key - @see EncryptDecrypt#key
     * @param fileForReadName - @see EncryptDecrypt#fileForReadName
     * @param fileToWriteName - @see EncryptDecrypt#fileToWriteName
     * @param alg - @see EncryptDecrypt#alg
     */
    public Encryption(String text, int key, String fileForReadName, String fileToWriteName, String alg) {
        super(text, key, fileForReadName, fileToWriteName, alg);
    }

    /**
     * Override method to encrypt text from field text with algorithm from field alg
     * @see EncryptDecrypt#text
     * @see EncryptDecrypt#alg
     */
    @Override
    void processData() {
        StringBuilder outText = new StringBuilder();
        char[] chars = this.text.toCharArray();
        if (this.alg.equals("unicode")) {
            for (int i = 0; i < chars.length; i++) {
                int index = chars[i] + key % 128;
                if (index < 0) {
                    index = index - 128;
                }
                outText.append(chars[i] = (char) index);
            }
            this.processedText = outText.toString();
        } else {
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] >= 65 && chars[i] <= 90) {
                    int index = chars[i] + key % 26;
                    if (index > 90) {
                        index = 65 + index - 91;
                    }
                    chars[i] = (char) index;
                }
            }

            for (int i = 0; i < chars.length; i++) {
                if (chars[i] >= 97 && chars[i] <= 122) {
                    int index = chars[i] + key % 26;
                    if (index > 122) {
                        index = 97 + index - 123;
                    }
                    chars[i] = (char) index;
                }
            }

            for (char ch : chars) {
                outText.append(ch);
            }
        }
        this.processedText = outText.toString();
    }
}
