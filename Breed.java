
import java.util.Scanner;

public class Breed {
    static class NoBreedException extends Exception {}
    
    private String name;
    private int maxHp;
    private int baseAttack;
    private int maxLightLevelToSpawn;
    private String[] ai;
    private String[] messages;
    
    public Breed(Scanner scan) throws NoBreedException 
    {
        String line = scan.nextLine();
        if (line.equals("===")) {
            throw new NoBreedException();
        }
        this.name = line;
        this.maxHp = Integer.parseInt(scan.nextLine());
        this.baseAttack = Integer.parseInt(scan.nextLine());
        this.maxLightLevelToSpawn = Integer.parseInt(scan.nextLine());
        messages = scan.nextLine().split(" : ");
        this.ai = scan.nextLine().split(", ");
        scan.nextLine();
    }
    
    public NPC newNPC() {return new NPC(this);}
    
    public String getName() {return name;}
    
    public int getMaxHp() {return maxHp;}
    
    public int getBaseAttack() {return baseAttack;}
    
    public String[] getMessages() {return messages;}
    
    public String[] getAi() {return ai;}
}

