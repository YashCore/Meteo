package meteo;

public class Parser {

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
     * Method tha extracts each line of the 
     * file content in a string array
     * 
     * @param content to be separated
     */
    public String[] splitLines(String content){
        if(content != null)
            return  content.split("\n");
        else
            return null;
    }
    
}
