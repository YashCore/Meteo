/**
 * Year
 */

package meteo;
import java.util.LinkedList;

/**
 * Year
 */
public class Year {


    //----------------------------] ATTRIBUTES [----------------------------
    private String year = null;
    private LinkedList<Month> list = null;
    private SiteReader sReader = null;
    private Parser parser = null;

    //----------------------------] CONSTRUCTOR [----------------------------
    public Year(String year){
        this.year = year;
        parser = new Parser();
        list = new LinkedList<Month>();
        sReader = new SiteReader(year);
        initzializeMonths();
    }

    //----------------------------] GET & SET [----------------------------
    public Month getMonth(int index) {
       return list.get(index);
    }

    public String getMonthRecord(int index) {
        return list.get(index).toString();
    }

    public String getYear() {
        return year;
    }
    
    //----------------------------] METHODS [----------------------------
    private void initzializeMonths() {
        String data[] = null;

        for (int i = 0; i <= 12; i++) {
            data = sReader.getFile(i);
            list.add(new Month(data[0],data[1]));
        }
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
            int singleMonths []= parser.convertToInt(months.split(";"));
            int sum = 0;

            for (int i = 0; i < singleMonths.length; i++)
                if(singleMonths[i] < 12) 
                    sum += list.get(singleMonths[i]).getRainPhenCount();

            return "The Rain days of " + months + " are: " + sum;

        // String : "3-12" (separator "-")
        }else if(months.contains("-")){
            int singleMonths []= parser.convertToInt(months.split(";"));
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
            return "The Fog days of " + month + " are: " + list.get(month).getFogPhenCount();

        // String : "7;1;8;4" (separator ";")
        }else if(months.contains(";")){
            int singleMonths []= parser.convertToInt(months.split(";"));
            int sum = 0;

            for (int i = 0; i < singleMonths.length; i++)
                if(singleMonths[i] < 12) 
                    sum += list.get(singleMonths[i]).getFogPhenCount();

            return "The Fog days of " + months + " are: " + sum;

        // String : "3-12" (separator "-")
        }else if(months.contains("-")){
            int singleMonths []= parser.convertToInt(months.split(";"));
            int sum = 0;

            for (int i = singleMonths[0]; i < singleMonths[1]; i++) 
                sum += list.get(singleMonths[i]).getFogPhenCount();

            return "The Fog days of " + months + " are: " + sum;
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
            return "The Snow days of " + month + " are: " + list.get(month).getSnowPhenCount();

        // String : "7;1;8;4" (separator ";")
        }else if(months.contains(";")){
            int singleMonths []= parser.convertToInt(months.split(";"));
            int sum = 0;

            for (int i = 0; i < singleMonths.length; i++)
                if(singleMonths[i] < 12) 
                    sum += list.get(singleMonths[i]).getSnowPhenCount();

            return "The Snow days of " + months + " are: " + sum;

        // String : "3-12" (separator "-")
        }else if(months.contains("-")){
            int singleMonths []= parser.convertToInt(months.split(";"));
            int sum = 0;

            for (int i = singleMonths[0]; i < singleMonths[1]; i++) 
                sum += list.get(singleMonths[i]).getSnowPhenCount();

            return "The Snow days of " + months + " are: " + sum;
        }
        return "Month Error";
    }

    /**
     * Method that given a String(containing index) returns
     * the Medium temperature of the given months
     *  
     * String input : "1" (single number String)
     *      @return the Medium temperature of the month  
     * String input : "7;1;8;4"
     *      @return the Medium temperature of the 7th, 1st, 8th and 4th month
     * String input : "3-12"
     *      @return the Medium temperature from the 3rd month to the 12th month
     */
    public String getMediumTemp(String months){
         // String : "1" single Char
         if (months.length() == 1) {
            int month = Integer.parseInt(months);
            return "The Medium temperature of " + list.get(month)+ " is: " + list.get(month).getMediumTemp();

        // String : "7;1;8;4" (separator ";")
        }else if(months.contains(";")){
            int singleMonths []= parser.convertToInt(months.split(";"));
            float result = 0;
            int i = 0;

            for (i = 0; i < singleMonths.length; i++)
                if(singleMonths[i] < 12) 
                    result += list.get(singleMonths[i]).getMediumTemp();
            result /= i;

            return "The Medium temperature of " + months + " are: " + result;

        // String : "3-12" (separator "-")
        }else if(months.contains("-")){
            int singleMonths []= parser.convertToInt(months.split(";"));
            float result = 0;
            int i = 0;

            for (i = singleMonths[0]; i < singleMonths[1]; i++) 
                result += list.get(singleMonths[i]).getMediumTemp();
            result /= i;

            return "The Medium temperature of " + months + " is: " + result;
        }
        return "Month Error";
    }

    /**
     * Method that given a String(containing index) returns
     * the Medium humidity of the given months
     *  
     * String input : "1" (single number String)
     *      @return the Medium humidity of the month  
     * String input : "7;1;8;4"
     *      @return the Medium humidity of the 7th, 1st, 8th and 4th month
     * String input : "3-12"
     *      @return the Medium humidity from the 3rd month to the 12th month
     */
    public String getMediumHumidity(String months){
        // String : "1" single Char
        if (months.length() == 1) {
           int month = Integer.parseInt(months);
           return "The Medium humidity of " + list.get(month)+ " is: " + list.get(month).getMediumHumidity()+"%";

       // String : "7;1;8;4" (separator ";")
       }else if(months.contains(";")){
           int singleMonths []= parser.convertToInt(months.split(";"));
           float result = 0;
           int i = 0;

           for (i = 0; i < singleMonths.length; i++)
               if(singleMonths[i] < 12) 
                   result += list.get(singleMonths[i]).getMediumHumidity();
           result /= i;

           return "The Medium humidity of " + months + " are: " + result+"%";

       // String : "3-12" (separator "-")
       }else if(months.contains("-")){
           int singleMonths []= parser.convertToInt(months.split(";"));
           float result = 0;
           int i = 0;

           for (i = singleMonths[0]; i < singleMonths[1]; i++) 
               result += list.get(singleMonths[i]).getMediumHumidity();
           result /= i;

           return "The Medium humidity of " + months + " is: " + result+"%";
       }
       return "Month Error";
   }

    /**
     * Method that given a String(containing index) returns
     * the Maximum temperature of the given months
     *  
     * String input : "1" (single number String)
     *      @return the Maximum temperature of the month  
     * String input : "7;1;8;4"
     *      @return the Maximum temperature of the 7th, 1st, 8th and 4th month
     * String input : "3-12"
     *      @return the Maximum temperature from the 3rd month to the 12th month
     */
    public String getMaxTemp(String months){
         // String : "1" single Char
         if (months.length() == 1) {
            int month = Integer.parseInt(months);
            return "The Maximum temperature of " +list.get(month) + " is: " + + list.get(month).getMaxTemp();

        // String : "7;1;8;4" (separator ";")
        }else if(months.contains(";")){
            int singleMonths []= parser.convertToInt(months.split(";"));
            int result = 0;

            for (int i = 0; i <= singleMonths.length; i++)
                if(singleMonths[i] <= 12) 
                    if(list.get(singleMonths[i]).getMaxTemp() > result)
                        result = list.get(singleMonths[i]).getMaxTemp();

            return "The Maximum temperature of " + months + " is: " +  result;

        // String : "3-12" (separator "-")
        }else if(months.contains("-")){
            int singleMonths []= parser.convertToInt(months.split(";"));
            int result = 0;

            for (int i = singleMonths[0]; i < singleMonths[1]; i++) 
               if(singleMonths[0] <= 12 && singleMonths[1] <= 12)
                    if(list.get(singleMonths[i]).getMaxTemp() > result)
                        result = list.get(singleMonths[i]).getMaxTemp();

            return "The Medium temperature of " + months + " are: " + result;
        }
        return "Month Error";
    }

    /**
     * Method that given a String(containing index) returns
     * the Minimum temperature of the given months
     *  
     * String input : "1" (single number String)
     *      @return the Minimum temperature of the month  
     * String input : "7;1;8;4"
     *      @return the Minimum temperature of the 7th, 1st, 8th and 4th month
     * String input : "3-12"
     *      @return the Minimum temperature from the 3rd month to the 12th month
     */
    public String getMinTemp(String months){
        // String : "1" single Char
        if (months.length() == 1) {
           int month = Integer.parseInt(months);
           return "The Minimum temperature of " +list.get(month) + " is: " + + list.get(month).getMinTemp();

       // String : "7;1;8;4" (separator ";")
       }else if(months.contains(";")){
           int singleMonths []= parser.convertToInt(months.split(";"));
           int result = 0;

           for (int i = 0; i <= singleMonths.length; i++)
               if(singleMonths[i] <= 12) 
                   if(list.get(singleMonths[i]).getMinTemp() < result)
                       result = list.get(singleMonths[i]).getMinTemp();

           return "The Minimum temperature of " + months + " is: " +  result;

       // String : "3-12" (separator "-")
       }else if(months.contains("-")){
           int singleMonths []= parser.convertToInt(months.split(";"));
           int result = 0;

           for (int i = singleMonths[0]; i < singleMonths[1]; i++) 
              if(singleMonths[0] <= 12 && singleMonths[1] <= 12)
                   if(list.get(singleMonths[i]).getMinTemp() < result)
                       result = list.get(singleMonths[i]).getMinTemp();

           return "The Minimum temperature of " + months + " are: " + result;
       }
       return "Month Error";
   }

}


/**
 * @author Yash Kumar
 * @since 2002
 */