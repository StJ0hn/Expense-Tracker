import java.io.File;
import java.io.IOException;

public class ExpenseFileManager {
    private static final String filePath = "despesas.csv";
    File file = new File(filePath);

    public boolean fileExists() throws IOException {
        try {
            if (file.exists()) {
                return true;
            }
            else {
                file.createNewFile();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
