/**
 * Month
 */

package meteo;

import java.util.LinkedList;

public class Month {


    //----------------------------] ATTRIBUTES [----------------------------
    private LinkedList<Day> list = null;
    private String month = null;
    private String daysData = null;
    private Parser parser = null;

    //----------------------------] CONSTRUCTOR [----------------------------
    public Month(String month, String daysData){
        this.month = month;
        this.daysData =daysData;
        parser = new Parser();
        list = new LinkedList<Day>();
        initzializeDays();
    }

    //----------------------------] METHODS [----------------------------

    /**
     * Method that inserts all the data 
     * into new days objects
     */
    public void initzializeDays(){
        String data[] = parser.splitLines(daysData);

        for (int i = 1; i < data.length; i++) {
            String line []= data[i].split(";");
            if(line[1] != "" || line[0] != ""){
                String rain = line [13];
                String phenomena = line[14];
                line[13] = "-100";
                line[14] = "-100";
                int day[] = parser.convertToInt(data[i].split(";"));
                addDay(day[1],day[9], day[2], day[3], day[4], day[7], rain, phenomena);
            }
        }
    }

    /**
     * Method that adds a new day in the month
     * with all the informations
     */
    public void addDay( int day,int wind, int midTemp, int minTemp, int maxTemp, int  humidity, String rain, String phenomena) {
        if(list == null)
            list.add(new Day(0, wind, midTemp, minTemp, maxTemp, humidity, rain, phenomena));
        else if(list.size() != 31)
            list.add(new Day(day, wind, midTemp, minTemp, maxTemp, humidity, rain, phenomena));
        else
            System.out.println("Full Month Error!");
    }


    public String getMonth() {
        return month;
    }

    /**
     * Method that returns a given day information
     * 
     * @param index day to get
     * @return day to string 
     */
    public String getDay(int index) {
        if(index > list.size())
            return "No such day";
        return list.get(index).toString();
    }

    /**
     * Method that returns all the day
     */
    public void getAllDays() {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).toString();
        }
    }

    /**
     * Method that returns the arithmetic average of the medium
     * temperature, from all of the month days
     * 
     * @return medium Temperature of the month
    */
    public float getMediumTemp(){
        int result = 0;
        int count = 0;
        
        for (int i = 0; i < list.size(); i++) {
            result += list.get(i).getMidTemp();
            count++;
        }

        return (result/count);
    }

    /**
     * Method that returns the arithmetic average of the 
     * humidity , from all of the month days
     * 
     * @return medium Humidity of the month
    */
    public float getMediumHumidity(){
        int result = 0;
        int count = 0;
        
        for (int i = 0; i < list.size(); i++) {
            result += list.get(i).getHumidity();
            count++;
        }

        return (result/count);
    }

    /**
     * Method that returns the maximum temperature recorded
     * in the month
     * @return
    */
    public int getMaxTemp() {
        int result = 0;

        for (int i = 0; i < list.size(); i++) 
            if(list.get(i).getMaxTemp() > result)
                result = list.get(i).getMaxTemp();
        
        return result;
    }

    /**
     * Method that returns the minimum temperature recorded
     * in the month
     * @return
    */
    public int getMinTemp() {
        int result = 0;

        for (int i = 0; i < list.size(); i++) 
            if(list.get(i).getMaxTemp() < result)
                result = list.get(i).getMaxTemp();
        
        return result;
    }

    /**
     * Method that returns the occurrences of the rainy days
     * recorded in the month
     * @return
    */
    public int getRainPhenCount() {
        int result = 0;

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getPhenomena().contains("pioggia"))
            result++;
        }

        return result; 
    }

    /**
     * Method that returns the occurrences of the foggy days
     * recorded in the month
     * @return
    */
    public int getFogPhenCount() {
        int result = 0;

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getPhenomena().contains("nebbia"))
            result++;
        }

        return result; 
    }

    /**
     * Method that returns the occurrences of the snowy days
     * recorded in the month
     * @return
    */
    public int getSnowPhenCount() {
        int result = 0;

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getPhenomena().contains("neve"))
            result++;
        }

        return result; 
    }

    @Override
    public String toString() {
        return "Month [month=" + month + ", Medium Temperature=" + getMediumTemp() + ". Max Temperature=" + getMaxTemp() +
        "Min Temperature=" + getMinTemp() + ", Medium Humidity=" + getMediumHumidity() + ", Rain Days=" + getRainPhenCount() +
        ", Fog Days="+ getFogPhenCount() + ", Snow Days=" + getSnowPhenCount() + "]";
    }
}


/**
 * @author Yash Kumar
 * @since 2002
 */