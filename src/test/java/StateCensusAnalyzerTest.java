import com.bridgelabz.IndiaStateCensus;
import com.bridgelabz.StateCensusAnalyzer;
import com.bridgelabz.StateCensusAnalyzerException;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.nio.file.NoSuchFileException;
import java.util.List;

public class StateCensusAnalyzerTest {

    @Test
    public void check_StateCensusDataFile_ReturnHowMuchRecord() throws StateCensusAnalyzerException, StateCensusAnalyzerException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        StateCensusAnalyzer stateAnalyser = new StateCensusAnalyzer();
        Assert.assertEquals(29, stateAnalyser.openCSVBuilder("/home/admin165/Desktop/Priya/IndianStateDataDemo/src/main/resources/StateCensus.csv","getStates"));
    }

    @Test
    public void check_StateCensusDataFile_WhenIncorrectFileName_ThrowException() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        StateCensusAnalyzer stateAnalyser = new StateCensusAnalyzer();
        try {
            Assert.assertEquals(29, stateAnalyser.openCSVBuilder("/home/admin165/Desktop/Priya/IndianStateDataDemo/src/main/resources/StateCen.csv","getStates"));
        } catch (StateCensusAnalyzerException e) {
            System.out.println("Exception is : " + e.getMessage());
            Assert.assertEquals(StateCensusAnalyzerException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }

    @Test
    public void check_StateCensusDataFile_WhenIncorrectFileType_TrowException() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        StateCensusAnalyzer stateAnalyser = new StateCensusAnalyzer();
        try {
            Assert.assertEquals(29, stateAnalyser.openCSVBuilder("/home/admin165/Desktop/Priya/IndianStateDataDemo/src/main/resources/StateCensus.json","getStates"));
        } catch (StateCensusAnalyzerException e) {
            System.out.println("Exception is : " + e.getMessage());
            Assert.assertEquals(StateCensusAnalyzerException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }

    @Test
    public void check_StateCensusDataFile_WhenDelimiterIncorrect_ThrowException() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        StateCensusAnalyzer stateAnalyser = new StateCensusAnalyzer();
        try {
            Assert.assertEquals(29, stateAnalyser.openCSVBuilder("/home/admin165/Desktop/Priya/IndianStateDataDemo/src/main/resources/StateCensus.csv","getStates"));
        } catch (StateCensusAnalyzerException e) {
            System.out.println("Exception is : " + e.getMessage());
            Assert.assertEquals(StateCensusAnalyzerException.ExceptionType.SOME_OTHER_FILE_ERROR, e.type);
        }
    }

    @Test
    public void check_StateCensusDataFile_WhenHeaderIncorrect_ThrowException() throws NoSuchFileException, IllegalAccessException, InvocationTargetException {

        StateCensusAnalyzer stateAnalyser = new StateCensusAnalyzer();
        try {
            Assert.assertEquals(29, stateAnalyser.openCSVBuilder("/home/admin165/Desktop/Priya/IndianStateDataDemo/src/main/resources/StateCensus.csv","getStates"));
        } catch (StateCensusAnalyzerException | NoSuchMethodException e) {
            System.out.println("Exception is : " + e.getMessage());
            Assert.assertEquals(StateCensusAnalyzerException.ExceptionType.SOME_OTHER_FILE_ERROR, e.getMessage());
        }
    }

    @Test
    public void sortByPopulationCSVFile_toJsonFile_returnMostPopulerCity() throws StateCensusAnalyzerException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        StateCensusAnalyzer stateCensusAnalyzer=new StateCensusAnalyzer();
        List<IndiaStateCensus> result = stateCensusAnalyzer.openCSVBuilder("/home/admin165/Desktop/Priya/IndianStateDataDemo/src/main/resources/StateCensus.csv","getPopulation");
        Assert.assertEquals("Arunachal Pradesh",result.get(result.size()-1).getStates());
    }

    @Test
    public void sortBYPopulation_toJsonFile_returnLeastPopulerCity() throws StateCensusAnalyzerException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        StateCensusAnalyzer stateCensusAnalyzer=new StateCensusAnalyzer();
        List<IndiaStateCensus> result = stateCensusAnalyzer.openCSVBuilder("/home/admin165/Desktop/Priya/IndianStateDataDemo/src/main/resources/StateCensus.csv","getPopulation");
        Assert.assertEquals("sikkim",result.get(0).getStates());
    }

    @Test
    public void sortByDensity_tojsonFile_returnLeastDensity() throws StateCensusAnalyzerException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        StateCensusAnalyzer stateCensusAnalyzer=new StateCensusAnalyzer();
        List<IndiaStateCensus> result = stateCensusAnalyzer.openCSVBuilder("/home/admin165/Desktop/Priya/IndianStateDataDemo/src/main/resources/StateCensus.csv","getDensityPerSqKm");
        Assert.assertEquals("Bihar",result.get(0).getStates());
    }

    @Test
    public void sortByDensity_tojsonFile_returnMoreDensity() throws StateCensusAnalyzerException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        StateCensusAnalyzer stateCensusAnalyzer=new StateCensusAnalyzer();
        List<IndiaStateCensus> result = stateCensusAnalyzer.openCSVBuilder("/home/admin165/Desktop/Priya/IndianStateDataDemo/src/main/resources/StateCensus.csv","getDensityPerSqKm");
        Assert.assertEquals("Arunachal Pradesh",result.get(result.size()-1).getStates());
    }

    @Test
    public void sortByArea_tojsonFile_returnMostArea() throws StateCensusAnalyzerException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        StateCensusAnalyzer stateCensusAnalyzer=new StateCensusAnalyzer();
        List<IndiaStateCensus> result = stateCensusAnalyzer.openCSVBuilder("/home/admin165/Desktop/Priya/IndianStateDataDemo/src/main/resources/StateCensus.csv","getAreaInSqKm");
        Assert.assertEquals("Rajasthan",result.get(0).getStates());
    }

    @Test
    public void sortByArea_tojsonFile_returnLeastArea() throws StateCensusAnalyzerException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        StateCensusAnalyzer stateCensusAnalyzer=new StateCensusAnalyzer();
        List<IndiaStateCensus> result = stateCensusAnalyzer.openCSVBuilder("/home/admin165/Desktop/Priya/IndianStateDataDemo/src/main/resources/StateCensus.csv","getAreaInSqKm");
        Assert.assertEquals("Arunachal Pradesh",result.get(result.size()-1).getStates());
    }
}

















