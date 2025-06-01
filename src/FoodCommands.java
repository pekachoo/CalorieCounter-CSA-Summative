import java.util.*;

/**
 * A class that manages a collection of food items and provides various operations on them.
 * This class handles sorting, printing, and calorie counting operations for food items.
 */
public class FoodCommands {
    //goal of this class is to have commands
    private ArrayList<Food> foodList = new ArrayList<>();
    private FileParser fileParser;

    /**
     * Constructs a new FoodCommands object and initializes the food list by parsing an input file.
     * The input file should be located at the specified path.
     */
    public FoodCommands(){
        fileParser = new FileParser("/Users/jliu61/Documents/GitHub/CalorieCounter/src/input.txt");
        this.foodList = fileParser.parseFile();
    }

    /**
     * Sorts the food list in ascending order based on calorie count.
     * Uses insertion sort algorithm.
     */
    public void sortAscending(){
        for(int i = 1; i < foodList.size(); i++){
            Food compare = foodList.get(i);
            int j = i - 1;
            //comparison condition for the insertion sort
            while (j >= 0 && foodList.get(j).getCalories() > compare.getCalories()){
                foodList.set(j + 1, foodList.get(j));
                j--;
            }
            foodList.set(j + 1, compare);
        }
    }

    /**
     * Sorts the food list in descending order based on calorie count.
     * Uses insertion sort algorithm.
     */
    public void sortDescending(){
        for(int i = 1; i < foodList.size(); i++){
            Food compare = foodList.get(i);
            int j = i - 1;
            //comparison condition for the insertion sort
            while (j >= 0 && foodList.get(j).getCalories() < compare.getCalories()){
                foodList.set(j + 1, foodList.get(j));
                j--;
            }
            foodList.set(j + 1, compare);
        }
    }

    /**
     * Prints the list of food items with their names, calories, and indices.
     */
    public void printList(){
        printListRecursive(0);
        System.out.println();
    }

    /**
     * Recursively prints each food item in the list.
     *
     * @param index Current index in the food list
     */
    private void printListRecursive(int index){
        if (index == foodList.size()){
            return;
        }
        Food food = foodList.get(index);
        //the line that recursively prints
        System.out.printf("%s: calories: %d, index %d\n", food.getName(), food.getCalories(), index);
        printListRecursive(index + 1);
    }

    /**
     * Prints detailed information about each food item in the list.
     */
    public void printFoodInfo(){
        printFoodInfoRecursive(0);
        System.out.println();
    }

    /**
     * Recursively prints detailed information about each food item.
     *
     * @param index Current index in the food list
     */
    private void printFoodInfoRecursive(int index){
        if(index == foodList.size()){
            return;
        }
        Food food = foodList.get(index);
        food.printInfo();
        printFoodInfoRecursive(index + 1);

    }

    /**
     * Calculates the total calories of all food items in the list.
     *
     * @return Total calorie count of all food items
     */
    public int countCaloriesRecursive(){
        return totalCaloriesRecursiveHelper(0);
    }

    /**
     * Recursively calculates the total calories of all food items.
     *
     * @param index Current index in the food list
     * @return Total calorie count of remaining food items
     */
    private int totalCaloriesRecursiveHelper(int index){
        if(index == foodList.size()){
            return 0;
        }
        return foodList.get(index).getCalories() + totalCaloriesRecursiveHelper(index + 1);
    }

    /**
     * Removes a food item from the list at the specified index.
     *
     * @param index The index of the food item to remove
     */
    public void removeFood(int index){
        foodList.remove(index);
    }

    /**
     * Writes the current food list information to an output file.
     * Includes food names, calories, and detailed information.
     *
     * @param outputFileName The name of the output file to write to
     * @return true if writing was successful, false otherwise
     */
    public void writeResultsToFile(String outputFileName) {
        //Uses
        StringBuilder content = new StringBuilder();

        //write initial list and other detailed food info
        content.append("Initial Food List:\n");
        content.append(getListAsString());
        content.append("\nDetailed Food Information:\n");
        content.append(getDetailedInfoAsString());

        //write total calories
        content.append("\nTotal Calories: ").append(countCaloriesRecursive()).append("\n");

        //write ascending sorted list
        sortAscending();
        content.append("\nFood List (Ascending Order):\n");
        content.append(getListAsString());

        //write descending sorted list
        sortDescending();
        content.append("\nFood List (Descending Order):\n");
        content.append(getListAsString());

        fileParser.writeToFile(content.toString(), outputFileName);
    }

    /**
     * Gets the current food list as a formatted string.
     *
     * @return String representation of the food list
     */
    private String getListAsString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < foodList.size(); i++) {
            Food food = foodList.get(i);
            sb.append(String.format("%s: calories: %d, index %d\n",
                    food.getName(), food.getCalories(), i));
        }
        return sb.toString();
    }

    /**
     * Gets detailed information about all food items as a formatted string.
     *
     * @return String containing detailed information about all food items
     */
    private String getDetailedInfoAsString() {
        StringBuilder sb = new StringBuilder();
        for (Food food : foodList) {
            sb.append(food.toString()).append("\n");
        }
        return sb.toString();
    }
}
