import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Battle{
    static InputStreamReader isr = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(isr);

    private List<Enemy> enemies;
    private int level;
    private int gold;
    private int exp;

    public Battle(int total, int MonsterLvl, String monster){
        this.enemies = new ArrayList<Enemy>();
        this.gold = 100;
        GenerateEnemies(total, MonsterLvl, monster);
    }

    public List<Enemy> getEnemies() {
        return this.enemies;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getGold() {
        return this.gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getExp() {
        return this.exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void GenerateEnemies(int totalEnemy, int EnemyLevel, String Monster) {
        Random rand = new Random();
        String name = "";
        String[] enemyName = {"Goblin", "Bandit", "Frank's", "Bandit Boss"};
        for (int i = 0; i < totalEnemy; i++) {
            int minAtk = 10 + (EnemyLevel - 1) * 2;
            int maxAtk = minAtk + 10;
            int minHP = 50 + (EnemyLevel - 1) * 10;
            int maxHP = minHP + 10;
            int Attack = rand.nextInt(maxAtk - minAtk + 1) + minAtk;
            int hp = rand.nextInt(maxHP - minHP + 1) + minHP;

            if (Monster.equals("Goblin")){
                name = enemyName[0];
            } else if (Monster.equals("Bandit")) {
                name = enemyName[1];
            } else if (Monster.equals("Frank's")) {
                name = enemyName[2];
            } else if (Monster.equals("Bandit Boss")) {
                name = enemyName[3];
            }

            Enemy enemy = new Enemy(name, Attack, hp);
            enemies.add(enemy);
        }
    }

    public void Fight(Character character) throws IOException{
        int resetHp = character.getHP();
        int resetMp = character.getMP();
        //System.out.println("Entering dungeon with character " + character.getNama());

        for (Enemy enemy : enemies) {
            System.out.println("Encountering enemy " + enemy.getNama());
            while (enemy.getHp() > 0 && character.getHP() > 0) {
                System.out.println("Enemy's HP: " + enemy.getHp());
                System.out.println("Your HP: " + character.getHP());
                System.out.println("Your MP: " + character.getMP());
                System.out.println("What do you want to do?");
                System.out.println("1. Attack");
                System.out.println("2. Skill");
                System.out.println("3. Use Potion");
                System.out.println("4. Run");
                System.out.print("\nChoice :");
                int choice = Integer.parseInt(input.readLine());
                ClearScreen();

                if (choice == 1) {
                    int playerDamage = character.getATK();
                    int enemyDamage = enemy.getAtk();

                    System.out.println("You deal " + playerDamage + " damage to the enemy!");
                    int darah = enemy.getHp();
                    darah -= playerDamage;
                    enemy.setHp(darah);

                    if (enemy.getHp() <= 0) {
                        System.out.println("You defeat the enemy!");
                        this.setGold(15 + level*3);
                        gold = this.getGold();
                        gold += character.getGold();
                        this.setExp(1 + level*2);
                        exp = this.getExp();
                        exp += character.getExp();
                        System.out.println("You got " + gold + " Gold and " + exp + " EXP!");
                        character.setGold(gold);
                        character.setExp(exp);
                        boolean levelUp = character.CheckExp(resetHp, resetMp);
                        if(levelUp == true){
                            resetHp = character.getHP();
                            resetMp = character.getMP();
                        }
                        break;
                    }

                    System.out.println("The enemy deals " + enemyDamage + " damage to you!");
                    int meDarah = character.getHP();
                    meDarah -= enemyDamage;
                    character.setHP(meDarah);

                    if (character.getHP() <= 0) {
                        System.out.println("You are defeated...");
                        character.setIsAlive(false);
                        character.setHP(resetHp);
                        character.setMP(resetMp);
                        return;
                    }
                } else if (choice == 2) {
                    if (character.getMP() >= 15) {
                        System.out.println("You use " + character.getSkill() + "!! to defeat the enemy!");
                        int restMp = character.getMP();
                        restMp -= 15;
                        character.setMP(restMp);
                        int playerDamage = character.getDmgSkill();
                        int enemyDamage = enemy.getAtk();

                        System.out.println("You deal " + playerDamage + " damage to the enemy!");
                        int darah = enemy.getHp();
                        darah -= playerDamage;
                        enemy.setHp(darah);

                        if (enemy.getHp() <= 0) {
                            System.out.println("You defeat the enemy!");
                            this.setGold(15 + level*3);
                            gold = this.getGold();
                            gold += character.getGold();
                            this.setExp(1 + level*2);
                            exp = this.getExp();
                            exp += character.getExp();
                            System.out.println("You got " + gold + " Gold and " + exp + " EXP!");
                            character.setGold(gold);
                            character.setExp(exp);
                            boolean levelUp = character.CheckExp(resetHp, resetMp);
                            if(levelUp == true){
                                resetHp = character.getHP();
                                resetMp = character.getMP();
                            }
                            break;
                        }

                        System.out.println("The enemy deals " + enemyDamage + " damage to you!");
                        int meDarah = character.getHP();
                        meDarah -= enemyDamage;
                        character.setHP(meDarah);

                        if (character.getHP() <= 0) {
                            System.out.println("You are defeated...");
                            character.setIsAlive(false);
                            character.setHP(resetHp);
                            character.setMP(resetMp);
                            return;
                        }  
                    } else {
                        System.out.println("You do not have enough MP to use!");
                    }
                // }else if (choice == 3){
                //     character.showInventoryPotion();
                //     System.out.println("Which potion do you want to use? \n>> "); int choosePotion = Integer.parseInt(input.readLine());
                //     if (character.getInventoryPotions().get(choosePotion-1).getType().equals("")) {
                        
                //     }
                } else if (choice == 4) {
                    System.out.println("You run away...");
                    System.out.print("\nPress [ENTER] to back...");
                    input.readLine();
                    ClearScreen();
                    character.setIsAlive(false);
                    character.setHP(resetHp);
                    character.setMP(resetMp);
                    return;
                } else {
                    System.out.println("Invalid choice!");
                }
            }
        }
        character.setHP(resetHp);
        character.setMP(resetMp);
    }

    public static void ClearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else{
                System.out.print("\033\143");
            }
        } catch (Exception ex) {
            System.err.println("Gagal Membersihkan");
        }
    }
}