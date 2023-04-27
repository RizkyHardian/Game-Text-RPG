import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.IOException;
import java.util.List;

public class Adventure {

    static InputStreamReader isr = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(isr);
    
    private int chapter;
    private List<Enemy> enemies;
    boolean loop = true;
    public Adventure(){
        this.enemies = new ArrayList<Enemy>();
    }

    public List<Enemy> getEnemies() {
        return this.enemies;
    }

    public void setEnemies(List<Enemy> enemies) {
        this.enemies = enemies;
    }

    public int getChapter() {
        return this.chapter;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }

    private final void Continue(){
        System.out.println("=================================================");
        System.out.println("           [ Press [ENTER] to Continue]          ");
        System.out.println("=================================================");
    }
    public void StartingChapter(Character character) throws IOException{
        System.out.println("=================================================");
        System.out.println("                STARTING CHAPTER                 ");
        System.out.println("=================================================");
        input.readLine();
        System.out.println("Welcome to the Adventure");
        input.readLine();
        System.out.println("This is the starting of your Journey");
        input.readLine();
        System.out.println("Your Adventure starts in the Dark Forest");
        input.readLine();
        System.out.println("a place of mystery and danger");
        input.readLine();
        System.out.println("You have been tasked with investigating a series");
        input.readLine();
        System.out.println("of strange occurrences that have been reported");
        input.readLine();
        System.out.println("in the Dark Forest reports indicate that");
        input.readLine();
        System.out.println("there have been sightings of unusual");
        input.readLine();
        System.out.println("creatures and strange happenings in the forest");
        input.readLine();
        System.out.println("and it is your job to uncover the truth.");
        input.readLine();
        Continue();
        input.readLine();
        System.out.println("");
        character.setChapter(1);
    }
    public void Chapter1(Character character) throws IOException{
        System.out.println("=================================================");
        System.out.println("                 CHAPTER 1                       ");
        System.out.println("=================================================");
        input.readLine();
        System.out.println("As you continue your investigation into the");
        input.readLine();
        System.out.println("strange occurrences in the Dark Forest, you hear");
        input.readLine();
        System.out.println("a bloodcurdling scream in the distance.");
        input.readLine();
        System.out.println("You quickly make your way towards the sound and");
        input.readLine();
        System.out.println("come across a lone traveler who is being attacked");
        input.readLine();
        System.out.println("by three goblins. Without hesitation, you and");
        input.readLine();
        System.out.println("your companions rush to the traveler's aid.");
        input.readLine();
        System.out.println("The goblins are small, but vicious, and they");
        input.readLine();
        System.out.println("wield their crude weapons with deadly accuracy");
        input.readLine();
        Continue();
        input.readLine();
        //battle 3 Goblin
        Battle battleG = new Battle(3, 15, "Goblin");
        battleG.Fight(character);
        if (character.getIsAlive() == false) {
            loop = false;
            character.setIsAlive(true);
            return;
        }
        System.out.println("=================================================");
        input.readLine();
        System.out.println("The battle is intense, but with your skills and");
        input.readLine();
        System.out.println("teamwork, you are able to defeat the goblins and");
        input.readLine();
        System.out.println("save the traveler. After you and your companions");
        input.readLine();
        System.out.println("successfully defeat the goblin horde, the traveler");
        input.readLine();
        System.out.println("introduces themselves as Frank.Frank expresses his");
        input.readLine();
        System.out.println("gratitude for your help and explains that he is");
        input.readLine();
        System.out.println("also on a mission to investigate the strange");
        input.readLine();
        System.out.println("occurrences in the Dark Forest.");
        input.readLine();
        Continue();
        input.readLine();
        System.out.println("");
        character.setChapter(2);
    }
    public void Chapter2(Character character) throws IOException{
        System.out.println("=================================================");
        System.out.println("                 CHAPTER 2                       ");
        System.out.println("=================================================");
        input.readLine();
        System.out.println("Frank then proceeds to share some valuable");
        input.readLine();
        System.out.println("information with you about a hidden treasure that");
        input.readLine();
        System.out.println("is said to be located somewhere in the forest. ");
        input.readLine();
        System.out.println("He offers to work together with you to find the ");
        input.readLine();
        System.out.println("treasure and split the loot. Excited at the ");
        input.readLine();
        System.out.println("prospect of discovering a hidden treasure, ");
        input.readLine();
        System.out.println("you agree to join forces with Frank However, ");
        input.readLine();
        System.out.println("as you delve deeper into the forest, you start to ");
        input.readLine();
        System.out.println("notice that Frank's behavior is becoming ");
        input.readLine();
        System.out.println("increasingly suspicious. You soon realize that ");
        input.readLine();
        System.out.println("Frank has been leading you into a trap, and he is");
        input.readLine();
        System.out.println("not really who he claims to be. Frank and his ");
        input.readLine();
        System.out.println("associates suddenly turn on you, revealing ");
        input.readLine();
        System.out.println("themselves to be members of a notorious bandit gang");
        input.readLine();
        System.out.println("that has been terrorizing the Dark Forest for years.");
        input.readLine();
        Continue();
        input.readLine();
        //battle 10 bandit
        Battle battleB = new Battle(10, 20, "Bandit");
        battleB.Fight(character);
        if (character.getIsAlive() == false) {
            loop = false;
            character.setIsAlive(true);
            return;
        }
        //battle Frank's
        Battle battleF = new Battle(1, 25, "Frank's");
        battleF.Fight(character);
        if (character.getIsAlive() == false) {
            loop = false;
            character.setIsAlive(true);
            return;
        }
        System.out.println("=================================================");
        input.readLine();
        System.out.println("A fierce battle ensues, and you are forced to ");
        input.readLine();
        System.out.println("fight for your life against frank's and the ");
        input.readLine();
        System.out.println("bandits. But with your skills, you are able to ");
        input.readLine();
        System.out.println("overcome the bandits and emerge victorious.");
        input.readLine();
        Continue();
        input.readLine();
        System.out.println("");
        character.setChapter(3);
    }
    public void Chapter3(Character character) throws IOException{
        System.out.println("=================================================");
        System.out.println("                 CHAPTER 3                       ");
        System.out.println("=================================================");
        input.readLine();
        System.out.println("After defeating Frank and his gang, you stand ");
        input.readLine();
        System.out.println("alone in the forest catching your breath and taking ");
        input.readLine();
        System.out.println("stock of the situation that's when you hear the ");
        input.readLine();
        System.out.println("sound of footsteps approaching. You ready your ");
        input.readLine();
        System.out.println("weapon, expecting another attack. But it turns out ");
        input.readLine();
        System.out.println("to be the leader of the bandits. Who has come to ");
        input.readLine();
        System.out.println("investigate the commotion. He is a formidable ");
        input.readLine();
        System.out.println("opponent with a towering build and a ");
        input.readLine();
        System.out.println("deadly-looking sword at his side. Despite being ");
        input.readLine();
        System.out.println("outnumbered and outmatched. You stand your ground ");
        input.readLine();
        System.out.println("and prepare to fight");
        input.readLine();
        Continue();
        input.readLine();
        //battle bandit boss
        Battle battleBoss = new Battle(1, 100, "Bandit Boss");
        battleBoss.Fight(character);
        if (character.getIsAlive() == false) {
            loop = false;
            character.setIsAlive(true);
            return;
        }
        System.out.println("=================================================");
        input.readLine();
        System.out.println("But in the end, it is you who emerges victorious.");
        input.readLine();
        System.out.println("With the bandit leader lying at your feet");
        input.readLine();
        System.out.println("you finally have a moment to catch your breath ");
        input.readLine();
        System.out.println("and reflect on the events that have brought you ");
        input.readLine();
        System.out.println("to this point.");
        input.readLine();
        Continue();
        input.readLine();
        System.out.println("");
        character.setChapter(4);
    }
    public void EndChapter() throws IOException{
        System.out.println("=================================================");
        System.out.println("                  END CHAPTER                    ");
        System.out.println("=================================================");
        input.readLine();
        System.out.println("As you look around the forest, you realize that ");
        input.readLine();
        System.out.println("your mission is far from over. There are still ");
        input.readLine();
        System.out.println("mysteries to be uncovered and dangers to be faced. ");
        input.readLine();
        System.out.println("But with your skills and determination, you know ");
        input.readLine();
        System.out.println("that you are up to the task. And so, you set out ");
        input.readLine();
        System.out.println("once again into the Dark Forest ready to face ");
        input.readLine();
        System.out.println("whatever challenges lie ahead and uncover the ");
        input.readLine();
        System.out.println("truth behind the strange occurrences that have ");
        input.readLine();
        System.out.println("been plaguing the land.");
        input.readLine();
        Continue();
        input.readLine();
        System.out.println("");
    }
    public void StartGame(Character character) throws IOException{
        while(loop){
            chapter = character.getChapter();
            if (chapter == 0) {
                StartingChapter(character);   
            }else if (chapter == 1) {
                Chapter1(character);    
            }else if (chapter == 2) {
                Chapter2(character);  
            }else if (chapter == 3) {
                Chapter3(character); 
            }else if (chapter == 4) {
                EndChapter();   
            }
        }
    }
}