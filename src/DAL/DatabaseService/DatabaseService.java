package DAL.DatabaseService;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by James on 20/03/2017.
 */
public class DatabaseService implements I_DatabaseService {

    private List<String> output;
    private File csv;
    private Scanner scanner;
    private String filename;

    DatabaseService(String filename) {
        this.filename = filename;
    }

    public List<String> getData() {
        openFile(filename);
        return readFile();
    }

    public void changeData(String[] info) {

    }

    public void deleteData(String[] info) {

    }

    public String showData(int id){
        String data = "";
        return data;
    }

    public void addData(String info) {
        openFile(filename);
        List<String> fileData = readFile();
        fileData.add(info);
        writeData(fileData);
    }

    protected void openFile(String filename) {
        try {
            csv = new File(filename);
            scanner = new Scanner(csv);
        } catch(FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Exception: " + e + "\n Exiting program.");
            System.exit(0);
        }

    }

    protected List<String> readFile() {
        output = new ArrayList<>();
        while(scanner.hasNext()) {
            output.add(scanner.next());
        }
        return output;
    }

    protected void writeData(List<String> newData) {
        try {
            FileWriter writer = new FileWriter(filename);
            for (String str : newData) {
                writer.write(str + "\n");
            }
            writer.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Exception: " + e + "\n Exiting program.");
            System.exit(0);
        }
    }
}
