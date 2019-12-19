package task1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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

    public static Box loadFromFile() throws IOException {
        Box box = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            box = (Box) inputStream.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return box;
    }

    /**
     * @throws EOFException - when the end of file is reached
     */
    public static List<Box> loadBoxesFromFile() throws IOException {
        List<Box> boxes = new ArrayList<>();
        Box box;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            do {
                box = (Box) inputStream.readObject();
                boxes.add(box);
            } while (box != null);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return boxes;
    }
}
