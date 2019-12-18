package task1;

import java.io.*;

public class FileHandler {

    public static final String FILE_PATH = "/Users/volha_kumakova/Desktop/untitled folder/data";

    public static void saveToFile(Box box) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(box);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Box loadFromFile() {
        Box box = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            box = (Box) inputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return box;
    }
}
