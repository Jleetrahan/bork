import java.util.Scanner;
import java.util.ArrayList;

/**
 * 
 */

/** NPC is the class defining non-player characters that can interact with the
 * player via combat and trade. NPC objects can move around the Dungeon and only
 * appear in the Dungeon at certain light levels according to the Daytime class.
 * @author Team Red
 *
 */
class NPC {
	static class NoNPCException extends Exception {}
	
	private String name;
	private Room currentRoom;
	private boolean isHostile;
	private int health;
	private boolean isAlive;
	private int maxLightLevelToSpawn;
	private ArrayList<Item> inventory;
	
	/** Creates a new NPC from a given Scanner connected to a .bork file
	 * 
	 * @param scan Scanner connected to the .bork file to read the NPC information from
	 * @param d The containing Dungeon object, necessary to retrieve Item objects.
	 * @param initState Whether or not the NPC should be set to its initial state, or set to a saved state from a .sav file
	 * @throws NoNPCException Thrown when a parsing line marking the end of the NPC section in the file is reached
	 */
	public NPC(Scanner scan, Dungeon d, boolean initState) throws NoNPCException
	{
		
	}
	
	/** Determines if the NPC goes by the paramater name
	 * 
	 * @param name Name to check against NPC's name
	 * @return True if this name is the same as the parameter name, false otherwise
	 */
	public boolean goesBy(String name)
	{
		
	}
	
	/** Returns the NPC's name
	 * 
	 * @return name
	 */
	public String getName()
	{
		return name;
	}
	
	/** Returns whether or not the NPC is currently alive
	 * 
	 * @return isAlive
	 */
	public boolean getIsAlive()
	{
		return isAlive;
	}
	
	/** Returns whether or not the NPC is hostile to the player
	 * 
	 * @return isHostile
	 */
	public boolean getIsHostile()
	{
		return isHostile;
	}
	
	/** Returns the Room the NPC is currently in, null if it has not spawned yet
	 * 
	 * @return currentRoom
	 */
	public Room getCurrentRoom()
	{
		return currentRoom;
	}
	
	/** A list of the names of the Item's in the NPC's inventory
	 * 
	 * @return An ArrayList<String> of all the names of the Items in inventory
	 */
	public ArrayList<String> getInventoryNames()
	{
		
	}
	
	/** Trades the parameter Item with the first Item in the NPC's inventory, will not be enacted if the NPC's inventory is empty
	 * 
	 * @param itemToTrade Item that the NPC will receive
	 * @return Item that the NPC will give in return
	 */
	public Item trade(Item itemToTrade)
	{
		
	}
	
	/** Adds an Item to the NPC's inventory
	 * 
	 * @param item Item to add to inventory
	 */
	public void addToInventory(Item item)
	{
		inventory.add(item);
	}
	
	/** Removes an Item from the NPC's inventory
	 * 
	 * @param item Item remove from inventory
	 */
	private void removeFromInventory(Item item)
	{
		inventory.remove(item);
	}
	
	/** Returns an Item from the NPC's inventory going by the parameter name
	 * 
	 * @param name Name of the Item to search for in inventory
	 * @return The Item going by the parameter name if it is in inventory
	 * @throws NoItemException If there is no Item in inventory that goes by the parameter name
	 */
	public Item getItemFromInventoryNamed(String name) throws NoItemException
	{
		
	}
	
	/** Adjusts this NPC's health by the parameter amount
     * 
     * @param change Amount to change this NPC's health by (negative to increase health)
     */
	public void changeHealth(int wound)
	{
		health -= wound;
	}
	
	/** Moves the NPC to a new Room
	 * 
	 * @return The Room the NPC moved to
	 */
	public Room move()
	{
		
	}
	
	public int getHp() {return hp;}
    
    public int getMaxHp() {return breed.getMaxHp();}
    
    public int getAttack() {return attack;}
    
    public int getBaseAttack() {return breed.getBaseAttack();}
    
    public void setHp(int newHp) {hp = newHp;}
    
    public void setAttack(int newAttack) {attack = newAttack;}
    
    public void attack(Monster target) {
        System.out.println(attack + " damage!");
        target.setHp(target.getHp()-attack);
    }
    
    public void speak(int i) {System.out.println(breed.getMessages()[i]);}
    
    
    //Stack variables/meathods
    final int MAX_STACK = 128;
    int stackSize = 0;
    int[] stack = new int[MAX_STACK];

    void push(int value) {
        assert(stackSize < MAX_STACK);
        stack[stackSize++] = value;
    }

    int pop() {
        assert(stackSize > 0);
        return stack[--stackSize];
    }
    
    public void Interpret(Monster target, boolean elite) {
        for (int i = 0; i < breed.getAi().length; i++) {
            String instruction = breed.getAi()[i];
            //System.out.println(instruction);
            switch (instruction) {
                //Next string will be a number
                case "LITERAL": {
                    int val = Integer.parseInt(breed.getAi()[++i]);
                    push(val);
                    break;
                }
                
                //Add the last two numbers on the stack, push the result
                case "ADD": {
                    int b = pop();
                    int a = pop();
                    push(a+b);
                    break;
                }
                
                //Subtract the last two numbers on the stack, push the result
                case "SUBTRACT": {
                    int b = pop();
                    int a = pop();
                    push(a-b);
                    break;
                }
                
                //Multiply the last two numbers on the stack, push the result
                case "MULTIPLY": {
                    int b = pop();
                    int a = pop();
                    push(a*b);
                    break;
                }
                
                //Divide the last two numbers on the stack, push the result
                case "DIVIDE": {
                    int b = pop();
                    int a = pop();
                    push(a/b);
                    break;
                }
                
                //Push the monsters current health
                case "GET_HP": {
                    push(getHp());
                    break;
                }
                
                //Push the monsters maximum health
                case "GET_MAX_HP": {
                    push(breed.getMaxHp());
                    break;
                }
                
                //Push the monsters current attack
                case "GET_ATTACK": {
                    push(getAttack());
                    break;
                }
                
                //Push the monsters base attack
                case "GET_BASE_ATTACK": {
                    push(breed.getBaseAttack());
                    break;
                }
                
                //Set monsters curent health
                case "SET_HP": {
                    setHp(pop());
                    break;
                }
                
                //Set monsters curent attack
                case "SET_ATTACK": {
                    setAttack(pop());
                    break;
                }
                
                //Attack opponent
                case "ATTACK": {
                    attack(target);
                    break;
                }
                
                //Print one of the messages, based off the next literal
                case "SPEAK": {
                    speak(Integer.parseInt(breed.getAi()[++i]));
                    break;
                }
                
                //Jump to the next JUMP_TO in the command stream
                //but only if the last value in the stack != 0
                case "JUMP": {
                    int val = pop();
                    if (0 != val) {
                        while (!breed.getAi()[i].equals("JUMP_TO")) {
                            i++;
                        }
                    }
                    break;
                }
                
                //Pushes 1 if the number two positions back in the stack
                //is less than the number one position back, and 0 otherwise
                case "LESS_THAN": {
                    int b = pop();
                    int a = pop();
                    if (a < b) {
                        push(1);
                    } else {
                        push(0);
                    }
                    break;
                }
                
                //Pushes 1 if the number two positions back in the stack
                //is equal to the number one position back, and 0 otherwise
                case "EQUAL_TO": {
                    int b = pop();
                    int a = pop();
                    if (a == b) {
                        push(1);
                    } else {
                        push(0);
                    }
                    break;
                }
                
                //Pushes 1 if the number two positions back in the stack
                //is greater than the number one position back, and 0 otherwise
                case "GREATER_THAN": {
                    int b = pop();
                    int a = pop();
                    if (a > b) {
                        push(1);
                    } else {
                        push(0);
                    }
                    break;
                }
                
                //If the last value in the stack is not a zero, changes to zero
                //if it is a zero, changes to 1
                case "NOT": {
                    int val = pop();
                    if (val == 0) {
                        push(1);
                    } else {
                        push(0);
                    }
                    break;
                }
                
                //Pushes either 0 or 1 to the stack, psudorandomly
                case "RANDOM": {
                    int val = new Random().nextInt(2);
                    push(val);
                    break;
                }
                
                //And gate
                case "AND": {
                    int b = pop();
                    int a = pop();
                    if (a == 1 && b == 1) {
                        push(1);
                    } else {
                        push(0);
                    }
                    break;
                }
                
                //Or gate
                case "OR": {
                    int b = pop();
                    int a = pop();
                    if (a == 1 || b == 1) {
                        push(1);
                    } else {
                        push(0);
                    }
                    break;
                }
                
                //Ends the curent run
                case "END": {
                    i = breed.getAi().length;
                    break;
                }
            }
        }
}
