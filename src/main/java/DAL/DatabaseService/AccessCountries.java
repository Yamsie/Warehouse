package DAL.DatabaseService;

import java.util.List;

/**
 * Created by James on 20/03/2017.
 */

public class AccessCountries  extends DatabaseService  {

    public AccessCountries() {
        super("data/COUNTRIES.txt");

    }

    public String getCountryData(String countryName) {
        List<String> fileData = super.getData();
        //Instead of returning a string array, return an Item??
        for (int i = 1; i < fileData.size(); i++) {
            String countryInfo;
            String[] info = fileData.get(i).split(",");
            if (info[0].equals(countryName)) {
                countryInfo = fileData.get(i);
                //System.out.println(itemInfo);
                return countryInfo;
            }
        }
        return null;
    }
}
