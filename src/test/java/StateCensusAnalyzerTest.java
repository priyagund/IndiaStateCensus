import com.bridgelabz.IndiaStateCensus;
import com.bridgelabz.StateCensusAnalyzer;
import com.bridgelabz.StateCensusAnalyzerException;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class StateCensusAnalyzerTest
{


    @Test
    public void check_StateCensusDataFile_ReturnHowMuchRecord() throws StateCensusAnalyzerException, StateCensusAnalyzerException {

        StateCensusAnalyzer stateAnalyser = new StateCensusAnalyzer();
        Assert.assertEquals(29,stateAnalyser.openCSVBuilder("/home/admin165/Desktop/Priya/IndianStateDataDemo/src/main/resources/StateCensus.csv"));
    }

    @Test
    public void check_StateCensusDataFile_WhenIncorrectFileName_ThrowException() {

      StateCensusAnalyzer stateAnalyser = new StateCensusAnalyzer ();
        try {
            Assert.assertEquals(29,stateAnalyser.openCSVBuilder("/home/admin165/Desktop/Priya/IndianStateDataDemo/src/main/resources/StateCensus.csv"));
        } catch (StateCensusAnalyzerException e) {
            System.out.println("Exception is : "+ e.getMessage());
            Assert.assertEquals(StateCensusAnalyzerException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }
}
