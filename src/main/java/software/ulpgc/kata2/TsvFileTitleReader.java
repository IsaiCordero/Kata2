package software.ulpgc.kata2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TsvFileTitleReader implements TitleReader {
    private File file;
    private TitleDeserializer deserializer;

    public TsvFileTitleReader(File file, TitleDeserializer deserializer) {
        this.file = file;
        this.deserializer = deserializer;
    }

    @Override
    public List<Title> load(){
        try{
            return load(new FileReader(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Title> load(FileReader fileReader) throws IOException {
        return load(new BufferedReader(fileReader));
    }

    private List<Title> load(BufferedReader bufferedReader) throws IOException {
        bufferedReader.readLine();
        List<Title> titles = new ArrayList<Title>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            titles.add(deserializer.deserialize(line));
        }
        return titles;
    }
}
