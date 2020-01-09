import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class Tests{

    @Test
    public void testWrite() throws IOException {

        String dirName =  "/home/aleksey/IdeaProjects/Problem_4/src";
        String fileName = "/home/aleksey/IdeaProjects/Problem_4/Log.txt";
        File dir = new File(dirName);
        File myFile = new File(fileName);
        FileWriter writer = new FileWriter(myFile, false);
        Main.AllFiles(dir, writer);
        writer.close();

        FileReader fr = new FileReader("/home/aleksey/IdeaProjects/Problem_4/Log.txt");
        Scanner scan = new Scanner(fr);
        StringBuilder expected = new StringBuilder();
        while (scan.hasNextLine()) {
            String tmp = scan.nextLine();
            expected.append(tmp);
            expected.append("\n");
        }
        fr.close();

        assertEquals(expected.toString(),"resources\n" +
                "Main.java\n" +
                "java\n" +
                "main\n" +
                "resources\n" +
                "Tests.java\n" +
                "java\n" +
                "test\n");
    }

}