package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

abstract class EncryptDecrypt {
    String text; // process data from arguments or from file
    int key; // key to encode and decode text
    String fileForReadName; // Name of file, from which program read text (if it in program args)
    String fileToWriteName; // Name of file, where program write text (if it in program args)
    String alg; // algorithm for Encrypt or Decrypt (shift or unicode)
    String processedText; // text after encryption or decryption
    boolean fromFile; // true, if args have param -in
    boolean toFile; // true, if args have param -out

    /**
     * Constructor to create an instance of class Encryption or Decryption
     * @param text - text from arguments (-data) or from file (-in)
     * @param key - key to encode and decode text
     * @param fileForReadName - Name of file, from which program read text (if -in is in the program args)
     * @param fileToWriteName - Name of file, where program write text (if -out is in the program args)
     * @param alg - algorithm to encrypt and decrypt text (shift and unicode here)
     */
    public EncryptDecrypt(String text, int key, String fileForReadName, String fileToWriteName, String alg) {
        this.text = text;
        this.key = key;
        if (!"".equals(fileForReadName)) {
            this.fileForReadName = fileForReadName;
            this.fromFile = true;
        }
        if (!"".equals(fileToWriteName)) {
            this.fileToWriteName = fileToWriteName;
            this.toFile = true;
        }
        this.alg = alg;
    }

    /**
     * Template method to process data
     */
    void workWithData() {
        getData();
        processData();
        printData();
    }

    /**
     * Get text from file, if fromFile == true
     */
    void getData() {
        if (fromFile) {
            File file = new File(fileForReadName);
            StringBuilder fileText = new StringBuilder();
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNext()) {
                    fileText.append(scanner.nextLine());
                }
            } catch (IOException e) {
                System.out.println("Error");
            }
            this.text = fileText.toString();
        }
    }

    /**
     * Override in child classes to process text
     */
    abstract void processData();

    /**
     * Print processed text to file, if toFile == true, otherwise to standard output
     */
    void printData() {
        if (toFile) {
            File file = new File(fileToWriteName);
            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write(processedText);
            } catch (IOException e) {
                System.out.println("Error");
            }
        } else {
            System.out.println(processedText);
        }
    }
}
