package my.test;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * User: lsamaha
 * Date: 10/25/13
 * Time: 9:36 AM
 */
public class ITRunTests {

    @Test
    public void writeAFile() throws IOException {
        File dir = new File("temp");
        FileWriter w = new FileWriter(dir);
        w.write("test");
        w.flush();
        w.close();
        System.out.println("*** " + dir.getAbsolutePath());
        dir.delete();
    }

    @Test
    public void runTests() throws IOException {
        String rscDirPath = "src/test/resources";
        File rsc = new File(rscDirPath);
        TestCase.assertTrue("resources directory should exist at " + rscDirPath, rsc.exists() && rsc.canRead());
        File regression = new File(rscDirPath, "regression");
        TestCase.assertTrue("regression directory should exist under " + rscDirPath, regression.exists() && regression.canRead());
        for(File f : regression.listFiles()) {
            System.out.println("*** " + f.getAbsolutePath());
        }
    }

}
