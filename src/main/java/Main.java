import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Введите директорию: ");
        Scanner scanner = new Scanner(System.in);
        String dirName = scanner.next();
        File dir = new File(dirName);
        if (!(dir.exists() && dir.isDirectory())) {
            System.out.println("Данная директория не существует.");
            System.exit(0);
        }

        System.out.println("Введите файл: ");
        String fileName = scanner.next();
        File myFile = new File(fileName);
        if (!myFile.exists()) {
            System.out.println("Данный файл не существует");
            try {
                if(myFile.createNewFile()){
                    System.out.println("Файл успешно создан");
                }
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        }
        else {
            System.out.println("Данный файл был перезаписан");
        }

        FileWriter writer = null;
        try {
            writer = new FileWriter(myFile, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        allFiles(dir, writer);
        assert writer != null;
        writer.close();
    }

    public static void allFiles(File dir, FileWriter writer){
        File[] files = dir.listFiles();
        assert files != null;
        for (File file : files) {
            if (file.isDirectory()) {
                allFiles(file, writer);
            }
            try {
                writer.write(file.getName() + "\n");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
