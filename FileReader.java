import java.util.*;
import java.io.*;

class FileReader extends Exception{

    private Scanner Scan;
    private HashMap<Integer, ArrayList<String> > wordfams;

    /**
     * Default constructor
     */
    public FileReader (){
        this("dictionary.txt");
    }

    /**
     * Overload constructor where the user inputs their own file of words
     * @param filename the name of the file the user is trying to input
     */
    public FileReader (String filename) {
        try {
            this.Scan = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            this.Scan = new Scanner("dictionary.txt");
        }
        this.wordfams = new HashMap<Integer, ArrayList<String>>();

        System.out.println("go");

        while (this.Scan.hasNextLine()){
            String str = Scan.nextLine();
            if (this.wordfams.containsKey(str.length())){
                ArrayList<String> temp = wordfams.get(str.length());
                temp.add(str);
                wordfams.put(str.length(), temp);
            }
            else{
                ArrayList<String> temp = new ArrayList<>();
                temp.add(str);
                this.wordfams.put(str.length(), temp);
            }
        }
        this.Scan.close();
    }

    /**
     * getter that gets the word family for specified length words and
     * returns the ArrayList of that word family
     * @return ArrayList<> returns an ArrayList that contains all the words for
     *                     the specified length
     */
    public ArrayList<String> getWordFam (int i){
        if (this.wordfams.containsKey(i)){
            return this.wordfams.get(i);
        }
        return null;
    }


}