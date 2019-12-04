package com.bridgelabz;

import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import sun.jvm.hotspot.utilities.Assert;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class StateCensusAnalyzer {


    List<IndiaStateCensus> indiaStateCensuses = new ArrayList<>();

    public List<IndiaStateCensus> openCSVBuilder(String STATE_CENSUS_DATA_CSV_FILE_PATH) throws StateCensusAnalyzerException {
        int count = 0;
        try {
            Reader reader = Files.newBufferedReader(Paths.get(STATE_CENSUS_DATA_CSV_FILE_PATH));
            CsvToBean<IndiaStateCensus> cavToBean = new CsvToBeanBuilder(reader)
                    .withType(IndiaStateCensus.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<IndiaStateCensus> csvUserIterator = cavToBean.iterator();
            while (csvUserIterator.hasNext()) {
                IndiaStateCensus csvUser = csvUserIterator.next();
                indiaStateCensuses.add(csvUser);
                count++;
            }

        } catch (NoSuchFileException e) {
            throw new StateCensusAnalyzerException(StateCensusAnalyzerException.ExceptionType.NO_SUCH_FILE, e, "please Enter proper file path or type ");
        } catch (RuntimeException e) {
            throw new StateCensusAnalyzerException(StateCensusAnalyzerException.ExceptionType.SOME_OTHER_FILE_ERROR, e, "File Delimiter is incorrect or header is incorrect");
        } catch (IOException e) {
            e.printStackTrace();
        }
//        SortStateInOrder(indiaStateCensuses,STATE_CENSUS_DATA_CSV_FILE_PATH);
        //  SortStateByPopulation(indiaStateCensuses,STATE_CENSUS_DATA_CSV_FILE_PATH);
        SortStateByDensityAndReport(indiaStateCensuses, STATE_CENSUS_DATA_CSV_FILE_PATH);
        return indiaStateCensuses;
    }

    public void SortStateInOrder(List<IndiaStateCensus> csvCensusList, String STATE_CENSUS_DATA_CSV_FILE_PATH) throws StateCensusAnalyzerException {
        for (int i = 0; i < csvCensusList.size() - 1; i++) {
            for (int j = 0; j < csvCensusList.size() - i - 1; j++) {
                if (csvCensusList.get(j).getStates().compareTo(csvCensusList.get(j + 1).getStates()) > 0) {
                    IndiaStateCensus tempObj = csvCensusList.get(j);
                    csvCensusList.set(j, csvCensusList.get(j + 1));
                    csvCensusList.set(j + 1, tempObj);
                }
            }
        }
        writeToJsonFile(indiaStateCensuses);
    }

    public void SortStateByPopulation(List<IndiaStateCensus> csvCensusList, String STATE_CENSUS_DATA_CSV_FILE_PATH) throws StateCensusAnalyzerException {
        for (int i = 0; i < csvCensusList.size() - 1; i++) {
            for (int j = 0; j < csvCensusList.size() - i - 1; j++) {
                if (csvCensusList.get(j).getPopulation() < (csvCensusList.get(j + 1).getPopulation())) {
                    IndiaStateCensus tempObj = csvCensusList.get(j);
                    csvCensusList.set(j, csvCensusList.get(j + 1));
                    csvCensusList.set(j + 1, tempObj);
                }
            }
        }
        writeToJsonFile(indiaStateCensuses);
    }

    public void SortStateByDensityAndReport(List<IndiaStateCensus> csvCensusList, String STATE_CENSUS_DATA_CSV_FILE_PATH) throws StateCensusAnalyzerException {
        for (int i = 0; i < csvCensusList.size() - 1; i++) {
            for (int j = 0; j < csvCensusList.size() - i - 1; j++) {
                if (csvCensusList.get(j).getDensityPerSqKm() < (csvCensusList.get(j + 1).getDensityPerSqKm())) {
                    IndiaStateCensus tempObj = csvCensusList.get(j);
                    csvCensusList.set(j, csvCensusList.get(j + 1));
                    csvCensusList.set(j + 1, tempObj);
                }
            }
        }
        writeToJsonFile(indiaStateCensuses);
    }

    public void writeToJsonFile(List<IndiaStateCensus> list) {
        String filename = "/home/admin165/Desktop/Priya/IndianStateDataDemo/src/main/resources/statecensusjson.json";
        Gson gson = new Gson();
        String json = gson.toJson(list);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filename);
            fileWriter.write(json);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
