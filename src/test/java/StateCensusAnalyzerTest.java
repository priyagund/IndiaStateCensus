import com.bridgelabz.IndiaStateCensus;
import com.bridgelabz.StateCensusAnalyzer;
import com.bridgelabz.StateCensusAnalyzerException;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class StateCensusAnalyzerTest {

    @Test
    public void check_StateCensusDataFile_ReturnHowMuchRecord() throws StateCensusAnalyzerException, StateCensusAnalyzerException {

        StateCensusAnalyzer stateAnalyser = new StateCensusAnalyzer();
        Assert.assertEquals(29, stateAnalyser.openCSVBuilder("/home/admin165/Desktop/Priya/IndianStateDataDemo/src/main/resources/StateCensus.csv"));
    }

    @Test
    public void check_StateCensusDataFile_WhenIncorrectFileName_ThrowException() {

        StateCensusAnalyzer stateAnalyser = new StateCensusAnalyzer();
        try {
            Assert.assertEquals(29, stateAnalyser.openCSVBuilder("/home/admin165/Desktop/Priya/IndianStateDataDemo/src/main/resources/StateCen.csv"));
        } catch (StateCensusAnalyzerException e) {
            System.out.println("Exception is : " + e.getMessage());
            Assert.assertEquals(StateCensusAnalyzerException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }

    @Test
    public void check_StateCensusDataFile_WhenIncorrectFileType_TrowException() {

        StateCensusAnalyzer stateAnalyser = new StateCensusAnalyzer();
        try {
            Assert.assertEquals(29, stateAnalyser.openCSVBuilder("/home/admin165/Desktop/Priya/IndianStateDataDemo/src/main/resources/StateCensus.json"));
        } catch (StateCensusAnalyzerException e) {
            System.out.println("Exception is : " + e.getMessage());
            Assert.assertEquals(StateCensusAnalyzerException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }

    @Test
    public void check_StateCensusDataFile_WhenDelimiterIncorrect_ThrowException() {

        StateCensusAnalyzer stateAnalyser = new StateCensusAnalyzer();
        try {
            Assert.assertEquals(29, stateAnalyser.openCSVBuilder("/home/admin165/Desktop/Priya/IndianStateDataDemo/src/main/resources/StateCensus.csv"));
        } catch (StateCensusAnalyzerException e) {
            System.out.println("Exception is : " + e.getMessage());
            Assert.assertEquals(StateCensusAnalyzerException.ExceptionType.SOME_OTHER_FILE_ERROR, e.type);
        }
    }

    @Test
    public void check_StateCensusDataFile_WhenHeaderIncorrect_ThrowException() {

        StateCensusAnalyzer stateAnalyser = new StateCensusAnalyzer();
        try {
            Assert.assertEquals(29, stateAnalyser.openCSVBuilder("/home/admin165/Desktop/Priya/IndianStateDataDemo/src/main/resources/StateCensus.csv"));
        } catch (StateCensusAnalyzerException e) {
            System.out.println("Exception is : " + e.getMessage());
            Assert.assertEquals(StateCensusAnalyzerException.ExceptionType.SOME_OTHER_FILE_ERROR, e.type);
        }
    }
    @Test
    public void sortSCVFile_ToJsonFile_ByAlphabaticalOrder() {

        StateCensusAnalyzer stateAnalyser = new StateCensusAnalyzer();
        try {
            Assert.assertEquals(29, stateAnalyser.openCSVBuilder("/home/admin165/Desktop/Priya/IndianStateDataDemo/src/main/resources/StateCensus.csv"));

        } catch (StateCensusAnalyzerException e) {
            System.out.println("Exception is : " + e.getMessage());
            Assert.assertEquals(StateCensusAnalyzerException.ExceptionType.SOME_OTHER_FILE_ERROR, e.type);
        }

    }


    @Test
    public void sortByPopulationCSVFile_toJsonFile_returnMostPopulerCity() throws StateCensusAnalyzerException {
        StateCensusAnalyzer stateCensusAnalyzer=new StateCensusAnalyzer();
        List<IndiaStateCensus> result = stateCensusAnalyzer.openCSVBuilder("/home/admin165/Desktop/Priya/IndianStateDataDemo/src/main/resources/StateCensus.csv");

        Assert.assertEquals("Arunachal Pradesh",result.get(result.size()-1).getStates());
    }

    @Test
    public void sortBYPopulation_toJsonFile_returnLeastPopulerCity() throws StateCensusAnalyzerException {
        StateCensusAnalyzer stateCensusAnalyzer=new StateCensusAnalyzer();
        List<IndiaStateCensus> result = stateCensusAnalyzer.openCSVBuilder("/home/admin165/Desktop/Priya/IndianStateDataDemo/src/main/resources/StateCensus.csv");
        Assert.assertEquals("sikkim",result.get(0).getStates());
    }

    @Test
    public void sortByDensity_tojsonFile_returnLeastDensity() throws StateCensusAnalyzerException {
        StateCensusAnalyzer stateCensusAnalyzer=new StateCensusAnalyzer();
        List<IndiaStateCensus> result = stateCensusAnalyzer.openCSVBuilder("/home/admin165/Desktop/Priya/IndianStateDataDemo/src/main/resources/StateCensus.csv");
        Assert.assertEquals("Bihar",result.get(0).getStates());
    }

    @Test
    public void sortByDensity_tojsonFile_returnMoreDensity() throws StateCensusAnalyzerException {
        StateCensusAnalyzer stateCensusAnalyzer=new StateCensusAnalyzer();
        List<IndiaStateCensus> result = stateCensusAnalyzer.openCSVBuilder("/home/admin165/Desktop/Priya/IndianStateDataDemo/src/main/resources/StateCensus.csv");
        Assert.assertEquals("Arunachal Pradesh",result.get(result.size()-1).getStates());
    }

    @Test
    public void sortByArea_tojsonFile_returnMostArea() throws StateCensusAnalyzerException {
        StateCensusAnalyzer stateCensusAnalyzer=new StateCensusAnalyzer();
        List<IndiaStateCensus> result = stateCensusAnalyzer.openCSVBuilder("/home/admin165/Desktop/Priya/IndianStateDataDemo/src/main/resources/StateCensus.csv");
        Assert.assertEquals("Rajasthan",result.get(0).getStates());
    }

    @Test
    public void sortByArea_tojsonFile_returnLeastArea() throws StateCensusAnalyzerException {
        StateCensusAnalyzer stateCensusAnalyzer=new StateCensusAnalyzer();
        List<IndiaStateCensus> result = stateCensusAnalyzer.openCSVBuilder("/home/admin165/Desktop/Priya/IndianStateDataDemo/src/main/resources/StateCensus.csv");
        Assert.assertEquals("Arunachal Pradesh",result.get(result.size()-1).getStates());
    }
}
















