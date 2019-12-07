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
    public void check_StateCensusDataFile_ReturnHowMuchRecord() {
        StateCensusAnalyzer stateAnalyser = new StateCensusAnalyzer();
        try {
            List<IndiaStateCensus> result = stateAnalyser.readDataFromCSV("/home/admin165/Desktop/Priya/IndianStateDataDemo/src/main/resources/StateCensus.csv", "getStates");
            Assert.assertEquals(29,result.size());
        } catch (StateCensusAnalyzerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void check_StateCensusDataFile_WhenIncorrectFileName_ThrowException()  {

        StateCensusAnalyzer stateAnalyser = new StateCensusAnalyzer();
        try {
            Assert.assertEquals(29, stateAnalyser.readDataFromCSV("/home/admin165/Desktop/Priya/IndianStateDataDemo/src/main/resources/StateCen.csv","getStates"));
        } catch (StateCensusAnalyzerException e) {
            Assert.assertEquals(StateCensusAnalyzerException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }

    @Test
    public void check_StateCensusDataFile_WhenIncorrectFileType_TrowException()  {

        StateCensusAnalyzer stateAnalyser = new StateCensusAnalyzer();
        try {
            Assert.assertEquals(29, stateAnalyser.readDataFromCSV("/home/admin165/Desktop/Priya/IndianStateDataDemo/src/main/resources/StateCensus.json","getStates"));
        } catch (StateCensusAnalyzerException e) {
            Assert.assertEquals(StateCensusAnalyzerException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }

    @Test
    public void check_StateCensusDataFile_WhenDelimiterIncorrect_ThrowException(){

        StateCensusAnalyzer stateAnalyser = new StateCensusAnalyzer();
        try {
             stateAnalyser.readDataFromCSV("/home/admin165/Desktop/Priya/IndianStateDataDemo/src/main/resources/StateCensus.csv","getStates");
        } catch (StateCensusAnalyzerException e) {
            Assert.assertEquals(StateCensusAnalyzerException.ExceptionType.SOME_OTHER_FILE_ERROR, e.type);
        }
    }

    @Test
    public void check_StateCensusDataFile_WhenHeaderIncorrect_ThrowException() {

        StateCensusAnalyzer stateAnalyser = new StateCensusAnalyzer();
        try {
            stateAnalyser.readDataFromCSV("/home/admin165/Desktop/Priya/IndianStateDataDemo/src/main/resources/StateCensus.csv","getStates");
        } catch (StateCensusAnalyzerException  e) {
            Assert.assertEquals(StateCensusAnalyzerException.ExceptionType.SOME_OTHER_FILE_ERROR, e.getMessage());
        }
    }

    @Test
    public void sortByPopulationCSVFile_toJsonFile_returnMostPopulerCity()  {
        StateCensusAnalyzer stateCensusAnalyzer=new StateCensusAnalyzer();
        List<IndiaStateCensus> result = null;
        try {
            result = stateCensusAnalyzer.readDataFromCSV("/home/admin165/Desktop/Priya/IndianStateDataDemo/src/main/resources/StateCensus.csv","getPopulation");
        } catch (StateCensusAnalyzerException e) {
            Assert.assertEquals("Arunachal Pradesh",result.get(result.size()-1).getStates());
        }
    }

    @Test
    public void sortByPopulation_toJsonFile_returnLeastPopulerCity() {
        StateCensusAnalyzer stateCensusAnalyzer=new StateCensusAnalyzer();
        try {
            List<IndiaStateCensus> result = stateCensusAnalyzer.readDataFromCSV("/home/admin165/Desktop/Priya/IndianStateDataDemo/src/main/resources/StateCensus.csv","getPopulation");
            Assert.assertEquals("sikkim",result.get(0).getStates());
        } catch (StateCensusAnalyzerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sortByDensity_tojsonFile_returnLeastDensity() {
        StateCensusAnalyzer stateCensusAnalyzer=new StateCensusAnalyzer();
        try {
            List<IndiaStateCensus>   result = stateCensusAnalyzer.readDataFromCSV("/home/admin165/Desktop/Priya/IndianStateDataDemo/src/main/resources/StateCensus.csv","getDensityPerSqKm");
            Assert.assertEquals("Bihar",result.get(0).getStates());
        } catch (StateCensusAnalyzerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sortByDensity_tojsonFile_returnMoreDensity() {
        StateCensusAnalyzer stateCensusAnalyzer=new StateCensusAnalyzer();
        try {
            List<IndiaStateCensus> result = stateCensusAnalyzer.readDataFromCSV("/home/admin165/Desktop/Priya/IndianStateDataDemo/src/main/resources/StateCensus.csv","getDensityPerSqKm");
            Assert.assertEquals("Arunachal Pradesh",result.get(result.size()-1).getStates());
        } catch (StateCensusAnalyzerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sortByArea_tojsonFile_returnMostArea() {
        StateCensusAnalyzer stateCensusAnalyzer=new StateCensusAnalyzer();
        List<IndiaStateCensus> result = null;
        try {
            result = stateCensusAnalyzer.readDataFromCSV("/home/admin165/Desktop/Priya/IndianStateDataDemo/src/main/resources/StateCensus.csv","getAreaInSqKm");
            Assert.assertEquals("Rajasthan",result.get(0).getStates());
        } catch (StateCensusAnalyzerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sortByArea_tojsonFile_returnLeastArea() {
        StateCensusAnalyzer stateCensusAnalyzer=new StateCensusAnalyzer();
        try {
            List<IndiaStateCensus>result = stateCensusAnalyzer.readDataFromCSV("/home/admin165/Desktop/Priya/IndianStateDataDemo/src/main/resources/StateCensus.csv","getAreaInSqKm");
            Assert.assertEquals("Arunachal Pradesh",result.get(result.size()-1).getStates());
        } catch (StateCensusAnalyzerException e) {
            e.printStackTrace();
        }
    }
}

















