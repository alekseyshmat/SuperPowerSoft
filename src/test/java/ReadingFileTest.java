import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadingFileTest {

    @BeforeClass
    private void before() {
        System.out.println("Checking line's converter test starting.");
    }

    @AfterClass
    public void after() {
        System.out.println("Checking line's converter test ending.");
    }

    @DataProvider
    public Object[] getValidList() {
        return new List[]{
                Arrays.<String>asList("09:20 10:35"),
        };
    }

    @Test(dataProvider = "getValidList", groups = "positive")
    public void testConvertList(List<String> list) {
        ReadingFile readingFile = new ReadingFile();
        List<Integer> arrivalTime = new ArrayList<Integer>();
        arrivalTime.add(920);
        List<Integer> careTime = new ArrayList<Integer>();
        careTime.add(1035);
        Assert.assertEquals(readingFile.convertList(list), new List[]{
                arrivalTime, careTime});
    }
}
