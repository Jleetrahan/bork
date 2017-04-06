/**
 * 
 */

/** InventoryCommand deals with any Commands relating to a player checking the contents of their inventory.
 * @author Team Red
 *
 */
import java.util.ArrayList;

class InventoryCommand extends Command {

    InventoryCommand() {
    }

    public String execute() {
        ArrayList<String> names = GameState.instance().getInventoryNames();
        if (names.size() == 0) {
            return "You are empty-handed.\n";
        }
        String retval = "You are carrying:\n";
        for (String itemName : names) {
            retval += "   A " + itemName + "\n";
        }
        return retval;
    }
}
