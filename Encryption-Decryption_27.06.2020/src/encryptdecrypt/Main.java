/**
 * JetBrains Academy project Encryption-Decryption
 @author Bakaluk Alexander
 @version 1.00
 */

package encryptdecrypt;

public class Main {
    public static void main(String[] args) {
        /*
        Take program arguments to Factory class, that choose need class (from args "mode"), create and return
        instance of that class, and initialize it fields
         */
        EncryptDecryptFactory encryptDecryptFactory = new EncryptDecryptFactory();
        if (args.length != 0) {
            EncryptDecrypt encryptDecrypt = encryptDecryptFactory.initializeFields(args);
            encryptDecrypt.workWithData();
        } else {
            System.out.println("No program arguments");
        }
    }
}
