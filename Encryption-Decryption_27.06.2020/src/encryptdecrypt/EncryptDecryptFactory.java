package encryptdecrypt;

/**
 * Factory class, that choose instance of classes Decryption and Encryption from program arg -mode
 */
public class EncryptDecryptFactory {

    /**
     * process program arguments to choose need class and create instance
     * @param args - program arguments
     * @return create in method createInstance() an instance of class with initialize fields (info for fields from args)
     */
    public EncryptDecrypt initializeFields(String[] args) {
        String text = "";
        int key = 0;
        String mode = "";
        String fileForReadName = "";
        String fileToWriteName = "";
        String alg = "shift";

        for (int i = 0; i < args.length; i += 2) {
            switch (args[i]) {
                case "-mode":
                    if (args[i + 1].equals("dec")) {
                        mode = "dec";
                    } else {
                        mode = "enc";
                    }
                    break;
                case "-key":
                    key = Integer.parseInt(args[i + 1]);
                    break;
                case "-data":
                    text = args[i + 1];
                    break;
                case "-in":
                    fileForReadName = args[i + 1];
                    break;
                case "-out":
                    fileToWriteName = args[i + 1];
                    break;
                case "-alg":
                    alg = args[i + 1];
            }
        }
        return createInstance(text, key, mode, fileForReadName, fileToWriteName, alg);
    }

    /**
     *
     * @param text - @see EncryptDecrypt#text
     * @param key - @see EncryptDecrypt#key
     * @param fileForReadName - @see EncryptDecrypt#fileForReadName
     * @param fileToWriteName - @see EncryptDecrypt#fileToWriteName
     * @param alg - @see EncryptDecrypt#alg
     * @return instance of class (enc - Encryption, dec - Decryption or null) with initialized fields
     * @see EncryptDecrypt#EncryptDecrypt(String, int, String, String, String)
     * @see Encryption#Encryption(String, int, String, String, String)
     * @see Decryption#Decryption(String, int, String, String, String)
     */
    public EncryptDecrypt createInstance(String text, int key, String type, String fileForReadName, String fileToWriteName, String alg) {
        if ("enc".equals(type)) {
            return new Encryption(text, key, fileForReadName, fileToWriteName, alg);
        } else if ("dec".equals(type)) {
            return new Decryption(text, key, fileForReadName, fileToWriteName, alg);
        } else {
            return null;
        }
    }

}
