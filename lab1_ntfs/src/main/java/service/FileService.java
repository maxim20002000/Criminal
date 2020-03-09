package service;

import java.util.List;

public interface FileService {

    String FILE_PATH = "src/main/resources/";

    List<String> readAllFile(String fileName);

    byte[] readWithSpecOffset(int offset, byte[] data, String fileName);

    void writetoFile(String data, String path);
}
