package resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FilesReading {
    static List<String[]> csvFileReader(String path) throws IOException {
        List<String[]> csvFileStore=new ArrayList<>();
        BufferedReader br= Files.newBufferedReader(Path.of(path));
        String line;
        String[] headers=br.readLine().split(",");
        Arrays.stream(headers).forEach(System.out::println);
        while((line=br.readLine())!=null){
            csvFileStore.add(line.split(","));
        }
        br.close();
        return csvFileStore;
    }
    public static void main(String[] args) throws IOException {
        String matchesPath="/Users/shavali/Documents/Java Learning/Java8/src/resources/matches.csv";
        List<String[] > matches=csvFileReader(matchesPath);
    }
}
