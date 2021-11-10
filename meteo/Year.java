/**
 * Year
 */

package meteo;

import java.util.LinkedList;

/**
 * Year
 */
public class Year {

    private String year = null;
    private LinkedList<Month> list = null;
    private SiteReader sReader = null;


    public Year(String year){
        this.year = year;
        list = new LinkedList<Month>();
        sReader = new SiteReader(year);
        initzializeMonths();
    }

    private void initzializeMonths() {
        String data[] = null;

        for (int i = 0; i <= 12; i++) {
            data = sReader.getFile(1);
            list.add(new Month(data[0],data[1]));
        }
    }

    public Month getMonth(int index) {
       return list.get(index);
    }

    public String getMonthRecord(int index) {
        return list.get(index).toString();
    }

    /**
     * Method that converts the given String array 
     * to a integer array
     * 
     * @param arr String array to convert
     * @return intgers array
     */
    public int[] convertToInt(String arr[]) {
        int[] intArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) 
            intArr [i]= Integer.parseInt(arr[i]);
        
        return intArr;
    }

    /**
     * Method that given a string return
     * the rain days of certain months
     * 
     * @param months the input string
     * 
     * String input : "1" (single number String)
     *      @return the rain days of the month  
     * String input : "7;1;8;4"
     *      @return the rain days of the 7th, 1st, 8th and 4th month
     * String input : "3-12"
     *      @return the rain days from the 3rd month to the 12th month
     */
    public String getRainDays(String months){
        
        // String : "1" single Char
        if (months.length() == 1) {
            int month = Integer.parseInt(months);
            return "The Rain days of " + month + " are: " + list.get(month).getRainPhenCount();

        // String : "7;1;8;4" (separator ";")
        }else if(months.contains(";")){
            int singleMonths []= convertToInt(months.split(";"));
            int sum = 0;

            for (int i = 0; i < singleMonths.length; i++)
                if(singleMonths[i] < 12) 
                    sum += list.get(singleMonths[i]).getRainPhenCount();

            return "The Rain days of " + months + " are: " + sum;

        // String : "3-12" (separator "-")
        }else if(months.contains("-")){
            int singleMonths []= convertToInt(months.split(";"));
            int sum = 0;

            for (int i = singleMonths[0]; i < singleMonths[1]; i++) 
                sum += list.get(singleMonths[i]).getRainPhenCount();

            return "The Rain days of " + months + " are: " + sum;
        }
        return "Month Error";
    }

    /**
     * Method that given a string return
     * the fog days of certain months
     * 
     * @param months the input string
     * 
     * String input : "1" (single number String)
     *      @return the fog days of the month  
     * String input : "7;1;8;4"
     *      @return the fog days of the 7th, 1st, 8th and 4th month
     * String input : "3-12"
     *      @return the fog days from the 3rd month to the 12th month
     */
    public String getFogDays(String months){
        
        // String : "1" single Char
        if (months.length() == 1) {
            int month = Integer.parseInt(months);
            return "The Rain days of " + month + " are: " + list.get(month).getFogPhenCount();

        // String : "7;1;8;4" (separator ";")
        }else if(months.contains(";")){
            int singleMonths []= convertToInt(months.split(";"));
            int sum = 0;

            for (int i = 0; i < singleMonths.length; i++)
                if(singleMonths[i] < 12) 
                    sum += list.get(singleMonths[i]).getFogPhenCount();

            return "The Rain days of " + months + " are: " + sum;

        // String : "3-12" (separator "-")
        }else if(months.contains("-")){
            int singleMonths []= convertToInt(months.split(";"));
            int sum = 0;

            for (int i = singleMonths[0]; i < singleMonths[1]; i++) 
                sum += list.get(singleMonths[i]).getFogPhenCount();

            return "The Rain days of " + months + " are: " + sum;
        }
        return "Month Error";
    }

    
    /**
     * Method that given a string return
     * the snow days of certain months
     * 
     * @param months the input string
     * 
     * String input : "1" (single number String)
     *      @return the snow days of the month  
     * String input : "7;1;8;4"
     *      @return the snow days of the 7th, 1st, 8th and 4th month
     * String input : "3-12"
     *      @return the snow days from the 3rd month to the 12th month
     */
    public String getSnowDays(String months){
        
        // String : "1" single Char
        if (months.length() == 1) {
            int month = Integer.parseInt(months);
            return "The Rain days of " + month + " are: " + list.get(month).getSnowPhenCount();

        // String : "7;1;8;4" (separator ";")
        }else if(months.contains(";")){
            int singleMonths []= convertToInt(months.split(";"));
            int sum = 0;

            for (int i = 0; i < singleMonths.length; i++)
                if(singleMonths[i] < 12) 
                    sum += list.get(singleMonths[i]).getSnowPhenCount();

            return "The Rain days of " + months + " are: " + sum;

        // String : "3-12" (separator "-")
        }else if(months.contains("-")){
            int singleMonths []= convertToInt(months.split(";"));
            int sum = 0;

            for (int i = singleMonths[0]; i < singleMonths[1]; i++) 
                sum += list.get(singleMonths[i]).getSnowPhenCount();

            return "The Rain days of " + months + " are: " + sum;
        }
        return "Month Error";
    }

 

}


/**
 * @author Yash Kumar
 * @since 2002
 */