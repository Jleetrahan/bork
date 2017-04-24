/**
 * 
 */

/** TradeCommand deals with any Commands relating to the player trying to trade an Item with an NPC.
 * @author Team Red
 *
 */
public class TradeCommand extends Command{
	private NPC npc;
	private boolean npcProvided;
	private Item item;
	private boolean itemProvided;
	
	/** Instantiates a TradeCommand with the parameter Item to the parameter NPC
	 * 
	 * @param npc NPC to trade with
	 * @param item Item to trade to the parameter NPC
	 */
	TradeCommand(String npc, String item)
	{
		GameState state = GameState.instance();
		if(item != null)
		{
			try{
				this.item = state.getItemFromInventoryNamed(item);
			}catch(Item.NoItemException e){
				this.item = null;
			}
			itemProvided = true;
		}
		else
		{
			itemProvided = false;
		}
		if(npc != null)
		{
			try{
				this.npc = state.getNPCInVicinityNamed(npc);
			}catch(NPC.NoNPCException e){
				this.npc = null;
			}
			npcProvided = false;
		}
		else
		{
			npcProvided = true;
		}
	}
	
	/**
	 * @override From Command
	 */
	String execute()
	{
		if(npc.getIsHostile()){
			return "Whoa buddy, they're not gonna let you do that";
		}
		
	}
}
