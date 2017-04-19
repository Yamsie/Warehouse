package DAL.DatabaseService;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by James on 20/03/2017.
 */
public interface I_DatabaseService {
    public List<String> getData();
    public void changeData(int info);
    public void deleteData(String[] info);
    public void addData(String info);
    public void changeItemData(String changedRow);
}
