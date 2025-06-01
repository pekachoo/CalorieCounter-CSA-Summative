/**
 * The main class that provides a user interface for the Calorie Counter application.
 * This class demonstrates the functionality of the FoodCommands class.
 */
public class UserInterface {
    /**
     * The main method that runs the Calorie Counter application.
     * It creates a FoodCommands object and demonstrates various operations:
     * - Printing the initial food list
     * - Printing detailed food information
     * - Calculating total calories
     * - Sorting the list in ascending and descending order
     *
     */
    public static void main(String[] args){
        FoodCommands foodCommands = new FoodCommands();
        foodCommands.printList();
        foodCommands.printFoodInfo();
        System.out.println("Calories in all food: " + foodCommands.countCaloriesRecursive());
        foodCommands.sortAscending();
        foodCommands.printList();
        foodCommands.sortDescending();
        foodCommands.printList();
    }
}
