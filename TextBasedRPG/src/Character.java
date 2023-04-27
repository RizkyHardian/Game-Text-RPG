import java.util.ArrayList;

public class Character {
//-------------------------------------------------------------------------------------------------------
    //Properties
    // private String ID;
    private String nama;
    private String gender;
    private String job;
    private int ATK;
    private int HP;
    private int MP;
    private int dmgSkill;
    private String skill;
    private Weapon Weapon;
    private Armor armor;
    private int Level;
    private int exp;
    private int gold;
    private boolean isAlive = true;


    private int chapter = 0;

    private ArrayList<Potion> inventoryPotions;
    private ArrayList<Weapon> inventoryWeapons;
    private ArrayList<Armor> inventoryArmors;

//-------------------------------------------------------------------------------------------------------
    //Get & Set
    public boolean getIsAlive() {
        return this.isAlive;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }
    public int getChapter() {
        return this.chapter;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }
    public int getDmgSkill() {
        return this.dmgSkill;
    }

    public void setDmgSkill(int dmgSkill) {
        this.dmgSkill = dmgSkill;
    }

    public String getSkill() {
        return this.skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJob() {
        return this.job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getATK() {
        return this.ATK;
    }

    public void setATK(int ATK) {
        this.ATK = ATK;
    }

    public int getHP() {
        return this.HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getMP() {
        return this.MP;
    }

    public void setMP(int MP) {
        this.MP = MP;
    }

    public Weapon getWeapon() {
        return this.Weapon;
    }

    public void setWeapon(Weapon Weapon) {
        this.Weapon = Weapon;
    }

    public Armor getArmor() {
        return this.armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }
    
    public int getLevel() {
        return this.Level;
    }

    public void setLevel(int Level) {
        this.Level = Level;
    }

    public int getExp() {
        return this.exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getGold() {
        return this.gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public ArrayList<Potion> getInventoryPotions() {
        return this.inventoryPotions;
    }

    public void setInventoryPotions(ArrayList<Potion> inventoryPotions) {
        this.inventoryPotions = inventoryPotions;
    }

    public ArrayList<Weapon> getInventoryWeapons() {
        return this.inventoryWeapons;
    }

    public void setInventoryWeapons(ArrayList<Weapon> inventoryWeapons) {
        this.inventoryWeapons = inventoryWeapons;
    }

    public ArrayList<Armor> getInventoryArmors() {
        return this.inventoryArmors;
    }

    public void setInventoryArmors(ArrayList<Armor> inventoryArmors) {
        this.inventoryArmors = inventoryArmors;
    }

    // public int getBuff() {
    //     return this.buff;
    // }

    // public void setBuff(int buff) {
    //     this.buff = buff;
    // }

    // public Inventory getInventory() {
    //     return this.inventory;
    // }

    // public void setInventory(Inventory inventory) {
    //     this.inventory = inventory;
    // }



//-------------------------------------------------------------------------------------------------------
    // Constructor
    public Character(String nama, int ATK, int HP, int MP,int dmgSkill, String skill, Weapon weapon, Armor armor, String gender, String job) {
        // this.ID = Id;
        this.nama = nama;
        this.gender = gender;
        this.ATK = ATK;
        this.HP = HP;
        this.MP = MP;
        this.dmgSkill = dmgSkill;
        this.skill = skill;
        this.Weapon = weapon;
        this.armor = armor;
        this.job = job;
        this.Level = 1;
        this.exp = 0;
        this.gold = 100;
        inventoryPotions = new ArrayList<Potion>();
        inventoryArmors = new ArrayList<Armor>();
        inventoryWeapons = new ArrayList<Weapon>();
        // this.inventory = new Inventory(20);
    }

    public final boolean CheckExp(int maxHp, int maxMp){
        while(exp >= ExpNextLevel()){
            this.setHP(maxHp);
            this.setMP(maxMp);
            this.LevelUp();
            return true;
        }
        return false;
    }
    private final int ExpNextLevel(){
        return this.Level * 25;
    }
    private void LevelUp(){
        this.exp -= ExpNextLevel();
        this.Level++;
        System.out.println("Congratulations! You have reached level " + this.getLevel() + ".");
        this.ATK += (this.Level * 2);
        this.HP += (this.Level * 2);
        this.MP += (this.Level * 2);
        this.dmgSkill += (this.Level * 2);
    }

    public void addInventory(int index, Potion potion){
        inventoryPotions.add(index, potion);;
    }
    public void addInventory(int index, Weapon weapon){
        inventoryWeapons.add(index, weapon);;
    }
    public void addInventory(int index, Armor armor){
        inventoryArmors.add(index, armor);;
    }

    public void showInventoryPotion(){
        if (inventoryPotions.size() == 0) {
            System.out.println("your inventory's still empty!");
        } else {
            System.out.println("Your Inventory : ");
            for (int i = 0; i < inventoryPotions.size() ; i++) {
                System.out.println((i+1) + ". " + inventoryPotions.get(i).getNama());
            }
        }
    }
    public void showInventoryWeapon(){
        if (inventoryWeapons.size() == 0) {
            System.out.println("your inventory's still empty!");
        } else {
            for (int i = 0; i < inventoryWeapons.size() ; i++) {
                System.out.println((i+1) + ". " + inventoryWeapons.get(i).getNama());
            }
        }
    }
    public void showInventoryArmor(){
        if (inventoryArmors.size() == 0) {
            System.out.println("your inventory's still empty!");
        } else {
            System.out.println("Your Inventory : ");
            for (int i = 0; i < inventoryArmors.size() ; i++) {
                System.out.println((i+1) + ". " + inventoryArmors.get(i).getNama());
            }
        }
    }
}
