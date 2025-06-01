import java.util.*;

/**
 * Represents a basic food item with a name and calorie count.
 * This is the base class for different types of food items.
 */
public class Food {
    private String foodName;
    private int calorieCount;

    /**
     * Constructs a new Food object with the specified name and calorie count.
     *
     * @param foodName The name of the food item
     * @param calorieCount The number of calories in the food item
     */
    public Food(String foodName, int calorieCount){
        this.foodName = foodName;
        this.calorieCount = calorieCount;
    }

    /**
     * Gets the name of the food item.
     *
     * @return The name of the food item
     */
    public String getName(){
        return foodName;
    }

    /**
     * Gets the calorie count of the food item.
     *
     * @return The number of calories in the food item
     */
    public int getCalories(){
        return calorieCount;
    }

    /**
     * Prints information about the food item including its name and calorie count.
     */
    public void printInfo(){
        System.out.println(foodName + " has " + calorieCount + " calories.");
    }
}

/**
 * Represents a burger food item with specific ingredients.
 * Extends the base Food class.
 */
class Burger extends Food {

    private ArrayList<String> ingredients;
    
    /**
     * Constructs a new Burger object with the specified name and ingredients.
     * The calorie count is automatically calculated based on the ingredients.
     *
     * @param foodName The name of the burger
     * @param ingredients List of ingredients in the burger
     */
    public Burger(String foodName, ArrayList<String> ingredients) {
        super(foodName, calculateCalories(ingredients, 0));
        this.ingredients = ingredients;
    }

    /**
     * Recursively calculates the total calories of the burger based on its ingredients.
     *
     * @param ingredients List of ingredients in the burger
     * @param index Current index in the ingredients list
     * @return Total calorie count of the burger
     */
    public static int calculateCalories(ArrayList<String> ingredients, int index) {
        if(index == ingredients.size()){
            return 0;
        }
        int calories = 0;
        switch(ingredients.get(index)) {
            case "Tomatoes":
                calories = 50;
                break;
            case "Beef Patty":
                calories = 150;
                break;
            case "Lettuce":
                calories = 200;
                break;
            case "Cheese":
                calories = 250;
                break;
            case "Veggie Patty":
                calories = 300;
                break;
            default:
                break;
        }
        return calories + calculateCalories(ingredients, index + 1);
    }

    /**
     * Recursively generates a comma-separated string of ingredients.
     *
     * @param index Current index in the ingredients list
     * @return String containing all ingredients separated by commas
     */
    public String generateInfo(int index) {
        if (index == ingredients.size()){
            return "";
        }
        String result = ingredients.get(index);
        if(index < ingredients.size() - 1){
            result += ", " + generateInfo(index + 1);
        }
        return result;
    }

    /**
     * Prints detailed information about the burger including its ingredients and total calories.
     * Overrides the base class printInfo method.
     */
    @Override
    public void printInfo() {
        String info = "Burger with ";
        info += generateInfo(0);
        info += " has " + getCalories() + " calories.";
        System.out.println(info);
    }

}

/**
 * Represents a pizza food item with specific toppings.
 * Extends the base Food class.
 */
class Pizza extends Food {

    private ArrayList<String> toppings;

    /**
     * Constructs a new Pizza object with the specified name and toppings.
     * The calorie count is automatically calculated based on the toppings.
     *
     * @param foodName The name of the pizza
     * @param toppings List of toppings on the pizza
     */
    public Pizza(String foodName, ArrayList<String> toppings) {
        super(foodName, calculateCalories(toppings, 0));
        this.toppings = toppings;
    }

    /**
     * Recursively calculates the total calories of the pizza based on its toppings.
     * Includes a base calorie count for the pizza dough.
     *
     * @param toppings List of toppings on the pizza
     * @param index Current index in the toppings list
     * @return Total calorie count of the pizza
     */
    public static int calculateCalories(ArrayList<String> toppings, int index) {
        if(index == toppings.size()){
            return 200; //base pizza dough
        }
        int calories = 0;
        switch (toppings.get(index)) {
            case "Pepperoni":
                calories = 100;
                break;
            case "Mushrooms":
                calories = 40;
                break;
            case "Onions":
                calories = 30;
                break;
            case "Extra Cheese":
                calories = 120;
                break;
            case "Olives":
                calories = 60;
                break;
            default:
                break;
        }
        return calories + calculateCalories(toppings, index + 1);
    }

    /**
     * Recursively generates a comma-separated string of toppings.
     *
     * @param index Current index in the toppings list
     * @return String containing all toppings separated by commas
     */
    public String generateInfo(int index) {
        if (index == toppings.size()){
            return "";
        }
        String result = toppings.get(index);
        if(index < toppings.size() - 1){
            result += ", " + generateInfo(index + 1);
        }
        return result;
    }

    /**
     * Prints detailed information about the pizza including its toppings and total calories.
     * Overrides the base class printInfo method.
     */
    @Override
    public void printInfo() {
        String info = "Pizza with ";
        info += generateInfo(0);
        info += " has " + getCalories() + " calories.";
        System.out.println(info);
    }

}

/**
 * Represents a salad food item with specific ingredients.
 * Extends the base Food class.
 */
class Salad extends Food {

    private ArrayList<String> ingredients;

    /**
     * Constructs a new Salad object with the specified name and ingredients.
     * The calorie count is automatically calculated based on the ingredients.
     *
     * @param foodName The name of the salad
     * @param ingredients List of ingredients in the salad
     */
    public Salad(String foodName, ArrayList<String> ingredients) {
        super(foodName, calculateCalories(ingredients, 0));
        this.ingredients = ingredients;
    }

    /**
     * Recursively calculates the total calories of the salad based on its ingredients.
     *
     * @param ingredients List of ingredients in the salad
     * @param index Current index in the ingredients list
     * @return Total calorie count of the salad
     */
    public static int calculateCalories(ArrayList<String> ingredients, int index) {
        if(index == ingredients.size()){
            return 0;
        }
        int calories = 0;
        switch (ingredients.get(index)) {
            case "Lettuce":
                calories = 10;
                break;
            case "Croutons":
                calories = 80;
                break;
            case "Chicken":
                calories = 150;
                break;
            case "Cheese":
                calories = 100;
                break;
            case "Caesar Dressing":
                calories = 200;
                break;
            default:
                break;
        }
        return calories + calculateCalories(ingredients, index + 1);
    }

    /**
     * Recursively generates a comma-separated string of ingredients.
     *
     * @param index Current index in the ingredients list
     * @return String containing all ingredients separated by commas
     */
    public String generateInfo(int index) {
        if (index == ingredients.size()){
            return "";
        }
        String result = ingredients.get(index);
        if(index < ingredients.size() - 1){
            result += ", " + generateInfo(index + 1);
        }
        return result;
    }

    /**
     * Prints detailed information about the salad including its ingredients and total calories.
     * Overrides the base class printInfo method.
     */
    @Override
    public void printInfo() {
        String info = "Salad with ";
        info += generateInfo(0);
        info += " has " + getCalories() + " calories.";
        System.out.println(info);
    }

}

/**
 * Represents a smoothie food item with specific fruits.
 * Extends the base Food class.
 */
class Smoothie extends Food {

    private ArrayList<String> fruits;

    /**
     * Constructs a new Smoothie object with the specified name and fruits.
     * The calorie count is automatically calculated based on the fruits.
     *
     * @param foodName The name of the smoothie
     * @param fruits List of fruits in the smoothie
     */
    public Smoothie(String foodName, ArrayList<String> fruits) {
        super(foodName, calculateCalories(fruits, 0));
        this.fruits = fruits;
    }

    /**
     * Recursively calculates the total calories of the smoothie based on its fruits.
     * Includes a base calorie count for yogurt/milk.
     *
     * @param fruits List of fruits in the smoothie
     * @param index Current index in the fruits list
     * @return Total calorie count of the smoothie
     */
    public static int calculateCalories(ArrayList<String> fruits, int index) {
        if(index == fruits.size()){
            return 100; //base yogurt/milk
        }
        int calories = 0;
        switch (fruits.get(index)) {
            case "Banana":
                calories = 90;
                break;
            case "Strawberry":
                calories = 50;
                break;
            case "Blueberry":
                calories = 40;
                break;
            case "Mango":
                calories = 70;
                break;
            case "Pineapple":
                calories = 60;
                break;
            default:
                break;
        }
        return calories + calculateCalories(fruits, index + 1);
    }

    /**
     * Recursively generates a comma-separated string of fruits.
     *
     * @param index Current index in the fruits list
     * @return String containing all fruits separated by commas
     */
    public String generateInfo(int index) {
        if (index == fruits.size()){
            return "";
        }
        String result = fruits.get(index);
        if(index < fruits.size() - 1){
            result += ", " + generateInfo(index + 1);
        }
        return result;
    }

    /**
     * Prints detailed information about the smoothie including its fruits and total calories.
     * Overrides the base class printInfo method.
     */
    @Override
    public void printInfo() {
        String info = "Smoothie with ";
        info += generateInfo(0);
        info += " has " + getCalories() + " calories.";
        System.out.println(info);
    }

}
