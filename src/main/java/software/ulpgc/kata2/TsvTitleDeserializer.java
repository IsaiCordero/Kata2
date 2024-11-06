package software.ulpgc.kata2;

public class TsvTitleDeserializer implements TitleDeserializer{

    @Override
    public Title deserialize(String title) {
        return deserialize(title.split("\t"));
    }

    private Title deserialize(String[] split) {
        return new Title(split[0],split[1],split[2],split[3],toBoolean(split[4]),toInt(split[5]),toInt(split[6]),toInt(split[7]),split[8]);
    }

    private int toInt(String line) {
        if(line != null && !line.equals("\\N")) return Integer.parseInt(line);
        return 0;
    }

    private boolean toBoolean(String line) {
        if(line.equals("1")) return true;
        return false;
    }
}
