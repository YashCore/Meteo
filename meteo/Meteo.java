/**
 * Meteo
 */

package meteo;

import java.util.HashMap;


public class Meteo {

    HashMap<String,Year> map = null;
    SiteReader reader = null;

    public Meteo(){
        map = new HashMap<String,Year>();
    }

    public void addYear(String year){
        map.put(year, new Year(year));
    }

    public Year get(String index){
        return map.get(index);
    }
    
}
