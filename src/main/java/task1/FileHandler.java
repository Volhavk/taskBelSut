package task1;

import java.io.*;

public class FileHandler {

    public static final String FILE_PATH = "data.bin";

    public static void saveToFile(Box box) {
        File file = new File(FILE_PATH);
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            throw new NullPointerException();
        }
    }

    public static Box loadFromFile() {
        Box box = null;
        File file = new File(FILE_PATH);
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
            box = (Box) inputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException();
        } return box;
    }
}
