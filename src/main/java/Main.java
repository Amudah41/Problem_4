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
        String FileName = scanner.next();
        File MyFile = new File(FileName);
        if (!MyFile.exists()) {
            System.out.println("Данный файл не существует.");
            System.exit(0);
        }
        FileWriter writer = null;
        try {
            writer = new FileWriter(MyFile, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        AllFiles(dir, writer);
        assert writer != null;
        writer.close();
    }

    public static void AllFiles(File dir, FileWriter writer){
        File[] files = dir.listFiles();
        assert files != null;
        for (File file : files) {
            if (file.isDirectory()) {
                AllFiles(file, writer);
            }
            try {
                writer.write(file.getName() + "\n");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
