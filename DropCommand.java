/**
 * 
 */

/** DropCommand deals with any Command relating to the dropping of an item from a player's inventory
 * @author Team Red
 *
 */

class DropCommand extends Command {

    private String itemName;
    
    
    /** Constructor for DropCommand class
    * 
    * 
    * */
    DropCommand(String itemName) {
        this.itemName = itemName;
    }

    /** executes DropCommand
    * 
    * 
    * */
    public String execute() {
        if (itemName == null || itemName.trim().length() == 0) {
            return "Drop what?\n";
        }
        try {
            Item theItem = GameState.instance().getItemFromInventoryNamed(
                itemName);
            GameState.instance().removeFromInventory(theItem);
            GameState.instance().getAdventurersCurrentRoom().add(theItem);
            return itemName + " dropped.\n";
        } catch (Item.NoItemException e) {
            return "You don't have a " + itemName + ".\n";
        }
    }
}
