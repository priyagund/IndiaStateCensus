package com.bridgelabz;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateCensusAnalyzer {

    public int openCSVBuilder(String STATE_CENSUS_DATA_CSV_FILE_PATH) throws StateCensusAnalyzerException {
        int count = 0;
        try {
            Reader reader = Files.newBufferedReader(Paths.get(STATE_CENSUS_DATA_CSV_FILE_PATH));
            CsvToBean<IndiaStateCensus> cavToBean = new CsvToBeanBuilder(reader)
                    .withType(IndiaStateCensus.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<IndiaStateCensus> csvUserIterator = cavToBean.iterator();
            while (csvUserIterator.hasNext()) {
                count++;
                IndiaStateCensus csvUser = csvUserIterator.next();
            }
        } catch (NoSuchFileException e){
            throw new StateCensusAnalyzerException(StateCensusAnalyzerException.ExceptionType.NO_SUCH_FILE, e, "please Enter proper file path or type ");
        } catch (RuntimeException e) {
            throw new StateCensusAnalyzerException(StateCensusAnalyzerException.ExceptionType.SOME_OTHER_FILE_ERROR, e, "File Delimiter is incorrect or header is incorrect");
        }catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    }
