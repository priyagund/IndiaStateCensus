package com.bridgelabz;

import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

import java.util.Iterator;
import java.util.List;

public class StateCensusAnalyzer <T extends Comparable<T>> {

      List<IndiaStateCensus> indiaStateCensuses ;
     private String filename = "/home/admin165/Desktop/Priya/IndianStateDataDemo/src/main/resources/statecensusjson.json";
    public List<IndiaStateCensus> readDataFromCSV(String STATE_CENSUS_DATA_CSV_FILE_PATH,String methodName) throws StateCensusAnalyzerException {
        int count = 0;
        try {
            Reader reader = Files.newBufferedReader(Paths.get(STATE_CENSUS_DATA_CSV_FILE_PATH));
            CsvToBean<IndiaStateCensus> cavToBean = new CsvToBeanBuilder(reader)
                    .withType(IndiaStateCensus.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSeparator(',')
                    .build();
            indiaStateCensuses=cavToBean.parse();
        } catch (NoSuchFileException e) {
            throw new StateCensusAnalyzerException(StateCensusAnalyzerException.ExceptionType.NO_SUCH_FILE, "please Enter proper file path or type ");
        } catch (RuntimeException e) {

            throw new StateCensusAnalyzerException(StateCensusAnalyzerException.ExceptionType.SOME_OTHER_FILE_ERROR, "File Delimiter is incorrect or header is incorrect");
        } catch (IOException e) {
            e.printStackTrace();
        }

            SortByField(indiaStateCensuses,methodName);
        return indiaStateCensuses;
    }

    public void SortByField(List<IndiaStateCensus> indiaStateCensuses,String methodName) {
                try {
                    for(int i=0;i<indiaStateCensuses.size()-1;i++){
                        for(int j=0;j<indiaStateCensuses.size()-i-1;j++){
                            Class cls = indiaStateCensuses.get(j).getClass();
                            Method methodcall = cls.getDeclaredMethod(methodName);
                            T value1=(T)methodcall.invoke(indiaStateCensuses.get(j));
                            Class cls1 = indiaStateCensuses.get(j+1).getClass();
                            Method methodcall1 = cls1.getDeclaredMethod(methodName);
                            T value2= null;
                    value2 = (T)methodcall1.invoke(indiaStateCensuses.get(j+1));
                    if(value1.compareTo(value2)<0){
                        IndiaStateCensus tempObj=indiaStateCensuses.get(j);
                        indiaStateCensuses.set(j,indiaStateCensuses.get(j+1));
                        indiaStateCensuses.set(j+1,tempObj);
                    }
                }
            }
        } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
        writeToJsonFile(indiaStateCensuses);
    }

    private void writeToJsonFile(List<IndiaStateCensus> list) {
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
