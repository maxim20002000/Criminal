package service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileServiceImpl implements FileService {

    public List<String> readAllFile(String path) {
        List<String> lines = new ArrayList<String>();
        try (Scanner reader = new Scanner(new File(path))) {
            while (reader.hasNextLine()) {
                lines.add(reader.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot read file!");
        }
        return lines;
    }

    public byte[] readWithSpecOffset(int offset, byte[] data, String fileName) {
        try {
            RandomAccessFile reader = new RandomAccessFile(new File(FILE_PATH + fileName), "r");
            reader.seek(offset);
            reader.readFully(data);
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find file " + fileName);
        } catch (IOException e) {
            System.out.println("Cannot read file " + fileName);
        }
        return data;
    }

    public void writetoFile(String data, String path) {

    }
}
