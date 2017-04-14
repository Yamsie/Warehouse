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

    private List<String> data = new ArrayList<String>();
    private File csv;
    private Scanner scanner;
    private String filename;

    DatabaseService(String filename) {
        this.filename = filename;
        openFile(filename);
        readFile();
    }

    public String[] getRow(int id) {
        String[] row = readFileRow(id);
        return row;
    }

    public List<String> getData() {
        return data;
    }

    public void changeItemData(String changedRow) {
    }

    public void changeData(String[] info) {
        //updateFileRow(info);
        writeData(data);
    }

    public void deleteData(String[] info) {
        deleteFileRow(info);
    }

    public String showData(int id){
        String data = "";
        return data;
    }

    public String getCountryData(String countryName) {
        String data = "";
        return data;
    }

    public void addData(String info) {
        data.add(info);
        writeData(data);
    }

    public List<String> getInfoByColumn(String column) {
        String[] rowElements;
        List<String> rows = new ArrayList<String>();
        int statusIndex = getColumnIndex(column);
        boolean complete = false;
        rowElements = data.get(0).split(",");

        for(int i = 1; i < data.size() && complete == false; i++) {
            rowElements = data.get(i).split(",");
            if(rowElements[statusIndex].compareTo(column) == 0) {
                rows.add(data.get(i));
            }
        }

        return rows;
    }

    public int getColumnIndex(String column) {
        String[] rowElements;
        int statusIndex = 0;
        boolean complete = false;
        rowElements = data.get(0).split(",");

        for(int i = 0; i < rowElements.length && complete == false; i++) {
            if (rowElements[i].compareTo(column) == 0) {
                statusIndex = i;
            }
        }

        return statusIndex;
    }

    public List<String> selectInfo(String column, String row) {
        String[] rowElements;
        List<String> rows = new ArrayList<String>();
        int statusIndex = getColumnIndex(column);
        boolean complete = false;
        rowElements = data.get(0).split(",");

        for(int i = 1; i < data.size() && complete == false; i++) {
            rowElements = data.get(i).split(",");
            if(rowElements[statusIndex].compareTo(row) == 0) {
                rows.add(data.get(i));
            }
        }

        return rows;
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

    protected String[] readFileRow(int id) {
        String[] rowElements;
        boolean complete = false;
        for(int i = 1; i < data.size() && complete == false; i++) {
            rowElements = data.get(i).split(",");
            if(Integer.parseInt(rowElements[0]) == id) {
                return rowElements;
            }
        }

        return null;
    }

    protected void deleteFileRow(String[] newRow) {
        String[] rowElements;
        boolean complete = false;
        for(int i = 0; i < data.size() && complete == false; i++) {
            rowElements = data.get(i).split(",");
            if(Integer.parseInt(rowElements[0]) == Integer.parseInt(newRow[0])) {
                String rowToCsv = "";
                for(int j = 0; j < newRow.length; j++) {
                    rowToCsv += newRow[j];
                    if(j != (newRow.length - 1)) {
                        rowToCsv += ",";
                        complete = true;
                    }
                }
                data.set(i, rowToCsv);
            }
        }
    }

    protected void readFile() {
        data = new ArrayList<>();
        try {
            while (scanner.hasNext()) {
                data.add(scanner.next());
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Excepion");
            System.exit(0);
        }
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
