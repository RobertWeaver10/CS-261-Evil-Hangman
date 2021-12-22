import java.util.*;

class Game {

    private FileReader f;
    private ArrayList<String> wordFamily;
    private char[] guess;
    private ArrayList<Character> guessedLetters;
    private boolean showRemainingWords;
    private boolean contains;

    public Game (){
        this.f = new FileReader();
        this.wordFamily = new ArrayList<>();
        this.guessedLetters = new ArrayList<>();
        this.showRemainingWords = false;
    }

    public void Play(){
        runGame();
    }

    /**
     * a method that manipulates the word family that the game is using and
     * manipulates it as the user gets further into the game.
     *
     * @return ArrayList<> returns an arraylist of the new word family after
     *                     any manipulations have to be made
     */
    private String editWordFamily(char c){
        ArrayList<String> hasCharacter = new ArrayList<>();
        ArrayList<String> noCharacter = new ArrayList<>();
        for (String s : this.wordFamily){
            for (int i = 0; i < s.length(); i++){
                contains = false;
                if (s.charAt(i) == c){
                    hasCharacter.add(s);
                    contains = true;
                    break;
                }
            }
            if (!contains) {
                noCharacter.add(s);
            }
        }
        if (noCharacter.size() >= hasCharacter.size()){
            contains = false;
            this.wordFamily = noCharacter;
            return null;
        }
        else{
            contains = true;
            String tempString = null;
            HashMap<String, ArrayList<String>> temp = new HashMap<>();
            for (String st: hasCharacter){
                for (int i = 0; i < st.length(); i++){
                    if(st.charAt(i) == c){
                        tempString += c;
                    }
                    else{
                        tempString += "-";
                    }
                }
                if (temp.containsKey(tempString)){
                    ArrayList<String> temporary = temp.get(tempString);
                    temporary.add(st);
                }
                else{
                    ArrayList<String> editedFam = new ArrayList<>();
                    editedFam.add(st);
                }
            }
            int largest = 0;
            String revealedLetters = "";
            for (String key: temp.keySet()){
                if(largest < temp.get(key).size()){
                    this.wordFamily = temp.get(key);
                    largest = temp.get(key).size();
                    revealedLetters = key;
                }
            }

            return revealedLetters;
        }
    }

    /**
     * method that runs a game loop prompting users for guesses to see if they can win a game of hangman.
     */
    private void runGame(){
        Scanner input = new Scanner(System.in);
        int numLetters;
        int numGuesses;
        ArrayList<
    }

}
