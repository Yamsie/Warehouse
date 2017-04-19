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

    public void changeData(int info) {
        //updateFileRow(info);
        writeData(data);
    }

    public void testData(String[] info) {
        updateFileRow(info);
        writeData(data);
    }

    protected void updateFileRow(String[] newRow) {
        String newLine = "";
        String[] rowElements;
        for(int i = 1; i < data.size(); i++) {
            rowElements = data.get(i).split(",");
            if(Integer.parseInt(rowElements[0]) == Integer.parseInt(newRow[0])) {
                for (int j = 0; j < newRow.length; j++) {
                    newLine += newRow[j];
                    if (j != (newRow.length - 1)) {
                        newLine += ",";
                    }
                }
                data.add(newLine);
                data.remove(i);
                newLine = "";
            }
        }
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
        int index = 0;
        boolean complete = false;
        rowElements = data.get(0).split(",");

        for(int i = 0; i < rowElements.length && complete == false; i++) {
            if (rowElements[i].compareTo(column) == 0) {
                index = i;
                complete = true;
            }
        }

        return index;
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
            //System.out.println("Exception: " + e + "\n Exiting program.");
            //System.exit(0);
        }

    }

    protected String[] readFileRow(int id) {
        String[] rowElements;
        boolean complete = false;
        for(int i = 1; i < data.size() && complete == false; i++) {
            rowElements = data.get(i).split(",");
            try {
                if (Integer.parseInt(rowElements[0]) == id) {
                    return rowElements;
                }
            } catch (NumberFormatException e) {}
        }

        return null;
    }

    protected void deleteFileRow(String[] newRow) {
        System.out.println("SHANE!");
        String[] rowElements;
        boolean complete = false;
        for(int i = 1; i < data.size() && complete == false; i++) {
            rowElements = data.get(i).split(",");
            if(Integer.parseInt(rowElements[0]) == Integer.parseInt(newRow[0])) {
                //String rowToCsv = "";
                //for(int j = 1; j < newRow.length; j++) {
                //    rowToCsv += newRow[j];
                //    if(j != (newRow.length - 1)) {
                //        rowToCsv += ",";
                //        complete = true;
                //    }
                //}
                //data.set(i, rowToCsv);
                data.remove(i);
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
            //System.out.println("Exception");
            //System.exit(0);
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
            //System.out.println("Exception: " + e + "\n Exiting program.");
            //System.exit(0);
        }
    }

    public int checkData(String allItemInfo) {
        int itemFound = 0;
        List<String> fileData = getData();
        for (int i = 1; i < fileData.size(); i++) {
            String detail = fileData.get(i);
            String itemID = detail.substring(0, (allItemInfo.indexOf(",")));
            if (itemID.equals(allItemInfo.substring(0, (allItemInfo.indexOf(","))))) {
                if (detail.equals(allItemInfo))
                    itemFound++;
            }
        }
        return itemFound;
    }
}
