import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Shop {
    static InputStreamReader isr = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(isr);
    static Weapon dataWeapon = new Weapon(null, null, 0, 0, null);
    static Potion dataPotion = new Potion(null, null, 0, 0, 0, 0, null);
    static Armor dataArmor = new Armor(null, null, 0, 0);

    static public void Add_Potion(String id, String nama, int harga, int ATK, int HP, int MP, String type){
        Potion newPotion = new Potion(id, nama, harga, ATK, HP, MP, type);
        dataPotion.getPotion().add(newPotion);
    }

    public void showPotion() {
        System.out.println("=== Potion ===");
        for (int i = 0; i < dataPotion.getPotion().size(); i++) {
            System.out.print((i+1) + ". ");
            System.out.print("Potion Name  : " + dataPotion.getPotion().get(i).getNama());
            System.out.println("  |  Price        : " + dataPotion.getPotion().get(i).getHarga());
        }
    }
    static public void Add_Weapon(String nama, String id, int harga, int damage, String type){
        Weapon newWeapon = new Weapon(nama, id, harga, damage, type);
        dataWeapon.getWeapon().add(newWeapon);
    }

    public void showWeapon(Character character) {
        System.out.println("=== Weapon ===");
        for (int i = 0; i < dataWeapon.getWeapon().size(); i++) {
            if (dataWeapon.getWeapon().get(i).getType().equals(character.getJob())) {
                System.out.print((i+1) + ". ");
                System.out.print("Weapon Name : " + dataWeapon.getWeapon().get(i).getNama());
                System.out.print("  |  Damage  : " + dataWeapon.getWeapon().get(i).getDamage());
                System.out.println("  |  Price  : " + dataWeapon.getWeapon().get(i).getHarga());
            }
        }
    }
    static public void Add_Armor(String nama, String id, int harga, int addHp){
        Armor newArmor = new Armor(nama, id, harga, addHp);
        dataArmor.getArmor().add(newArmor);
    }

    public void showArmor() {
        System.out.println("=== Armor ===");
        for (int i = 0; i < dataArmor.getArmor().size(); i++) {
            System.out.print((i+1) + ". ");
            System.out.print("Armor Name : " + dataArmor.getArmor().get(i).getNama());
            System.out.print("  |  HP  : " + dataArmor.getArmor().get(i).getAdditionalHp());
            System.out.println("  |  Price  : " + dataArmor.getArmor().get(i).getHarga());
        }
    }

    public void sellItemP(Character character) throws IOException{
        System.out.print(" Choose Your Potion       : "); int choose = Integer.parseInt(input.readLine());
        System.out.print(" How Many you want to buy : "); int quantity = Integer.parseInt(input.readLine());
        if (choose >= 1) {
            Potion selectedPotion = dataPotion.getPotion().get(choose-1);
            int harga = selectedPotion.getHarga() * quantity;

            if (character.getGold() >=harga) {
                character.setGold(character.getGold() - harga);
                for (int i = 0; i < quantity; i++) {
                    character.addInventory(i, selectedPotion);
                }
                System.out.println("You Have Purchased " + quantity + " " + selectedPotion.getNama() + "!!!");
            } else {
                System.out.println("You dont have enought Gold!!!");
            }
        }
    }

    public void sellWeaponP(Character character) throws IOException{
        System.out.print(" Choose Your Weapon       : "); int choose = Integer.parseInt(input.readLine());
        System.out.print(" How Many you want to buy : "); int quantity = Integer.parseInt(input.readLine());
        if (choose >= 1) {
            Weapon selectedWeapon = dataWeapon.getWeapon().get(choose-1);
            int harga = selectedWeapon.getHarga() * quantity;

            if (character.getGold() >=harga) {
                character.setGold(character.getGold() - harga);
                for (int i = 0; i < quantity; i++) {
                    character.addInventory(i, selectedWeapon);
                }
                System.out.println("You Have Purchased " + quantity + " " + selectedWeapon.getNama() + "!!!");
            } else {
                System.out.println("You dont have enought Gold!!!");
            }
        }
    }

    public void sellArmorP(Character character) throws IOException{
        System.out.print(" Choose Your Armor        : "); int choose = Integer.parseInt(input.readLine());
        System.out.print(" How Many you want to buy : "); int quantity = Integer.parseInt(input.readLine());
        if (choose >= 1) {
            Armor selectedArmor = dataArmor.getArmor().get(choose-1);
            int harga = selectedArmor.getHarga() * quantity;

            if (character.getGold() >=harga) {
                character.setGold(character.getGold() - harga);
                for (int i = 0; i < quantity; i++) {
                    character.addInventory(i, selectedArmor);
                }
                System.out.println("You Have Purchased " + quantity + " " + selectedArmor.getNama() + "!!!");
            } else {
                System.out.println("You dont have enought Gold!!!");
            }
        }
    }
}