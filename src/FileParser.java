import java.io.*;
import java.util.*;

/**
 * A utility class for parsing food information from a text file.
 * The file should contain food items with their names and ingredients/toppings.
 */
public class FileParser {

    private String fileName;

    /**
     * Constructs a new FileParser object with the specified file path.
     *
     * @param fileName The path to the input file containing food information
     */
    public FileParser(String fileName){
        this.fileName = fileName;
    }

    //AI was used to help create this logic
    /**
     * Parses the input file and creates a list of Food objects based on the file contents.
     * The file should follow a specific format:
     * - Each food item starts with "name:" followed by the food type
     * - Ingredients/toppings are listed one per line
     * - Each food item ends with "End"
     *
     * @return ArrayList of Food objects created from the file contents
     */
    public ArrayList<Food> parseFile() {
        ArrayList<Food> foodList = new ArrayList<>();
        try{
            Scanner scanner = new Scanner(new File(fileName));
            String currentFoodName = null;
            ArrayList<String> ingredients = new ArrayList<>();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();

                //checks which "part" of the text file it's reading
                if (line.startsWith("name:")) {
                    currentFoodName = line.substring(5).trim().toLowerCase();
                    ingredients = new ArrayList<>();
                } else if (line.equalsIgnoreCase("Ingredients:")) {
                    // just skip this line
                } else if (line.equalsIgnoreCase("End")) {
                    if (currentFoodName != null) {
                        switch (currentFoodName) {
                            case "burger":
                                foodList.add(new Burger("Burger", ingredients));
                                break;
                            case "pizza":
                                foodList.add(new Pizza("Pizza", ingredients));
                                break;
                            case "salad":
                                foodList.add(new Salad("Salad", ingredients));
                                break;
                            case "smoothie":
                                foodList.add(new Smoothie("Smoothie", ingredients));
                                break;
                            default:
                                System.out.println("Unknown food: " + currentFoodName);
                                break;
                        }
                    }
                } else {
                    ingredients.add(line);
                }
            }
            scanner.close();
        } catch (Exception e){
            System.out.println("file not found");
        }

        return foodList;
    }

    /**
     * Writes content to a specified output file using Scanner.
     *
     * @param content The content to write to the file
     * @param outputFileName The name of the output file
     * @return true if writing was successful, false otherwise
     */
    public boolean writeToFile(String content, String outputFileName) {
        try {
            File outputFile = new File(outputFileName);
            Scanner scanner = new Scanner(content);
            FileWriter writer = new FileWriter(outputFile);

            while (scanner.hasNextLine()) {
                writer.write(scanner.nextLine() + "\n");
            }

            scanner.close();
            writer.close();
            return true;
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
            return false;
        }
    }
}
