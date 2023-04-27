import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    static InputStreamReader isr = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(isr);
    static Account akun = new Account(null, null, 0, null, 0, 0, 0, 0, null, null, null,null, null);
    static Shop shop = new Shop();
    final int maxLevel = 50;
    public static void main(String[] args) throws Exception {
        System.out.println("=================================================");
        System.out.println("  W E L C O M E   T O   T H E   N E W   W O R L D");
        System.out.println("           [ Press [ENTER] to Continue]          ");
        System.out.println("=================================================");
        input.readLine();
        ClearScreen();
        awal();
    }

    private static void awal() throws IOException {
        while (true) {
            try {
                System.out.println("===========================");
                System.out.println("       TEXT BASED RPG      ");
                System.out.println("===========================");
                System.out.println(" 1. LOGIN");
                System.out.println(" 2. REGISTER");
                System.out.println(" 0. EXIT");
                System.out.print("ENTER CHOICE >> ");
                int choice = Integer.parseInt(input.readLine());
                switch (choice) {
                    case 1:
                        ClearScreen();
                        akun.login();
                        break;
                    case 2:
                        ClearScreen(); 
                        akun.register();
                        break;
                    case 0: 
                        System.exit(0);
                        break;
                    default:
                        System.out.print("\nOption Not Available...!");
                        input.readLine();
                        ClearScreen();
                        break;
                }
            }catch (NumberFormatException e){
                System.out.println("harus angka");
                ClearScreen();
            }    
        }
    }

    public void Home(Character character, ArrayList<Account> account, int index, int baseAtk) throws IOException {
        int choice = -1;
        while(choice != 0){
            try {
                System.out.println("=================================================");
                System.out.println("                     H O M E                     ");
                System.out.println("=================================================");
                System.out.println("1. Adventure");
                System.out.println("2. Dungeon");
                System.out.println("3. Profile");
                System.out.println("4. Inventory");
                System.out.println("5. Shop");
                System.out.println("6. Setting");
                System.out.println("0. Exit");
                System.out.print("ENTER CHOICE >> ");
                choice = Integer.parseInt(input.readLine());
                switch (choice) {
                    case 0: 
                        ClearScreen();
                        break;
                    case 1:
                        //Adventure();
                        Adventure adventure = new Adventure();
                        adventure.StartGame(character);
                        break;
                    case 2: 
                        ClearScreen();
                        DungeonDive(character);
                        break;
                    case 3: 
                        ClearScreen();
                        Profile(character, baseAtk);
                        break;
                    case 4: 
                        ClearScreen();
                        Inventory(character);
                        break;
                    case 5:
                        ClearScreen(); 
                        ShopMenu(character);
                        break;
                    case 6: 
                        SettingChar(character, account, character.getNama(), index);
                        break;
                    default:
                        System.out.print("\nOption Not Available...!");
                        input.readLine();
                        ClearScreen();
                        break;
                }
            }catch (NumberFormatException e){
                System.out.println("harus angka");
                ClearScreen();
            }   
        }
    }

    private static void DungeonDive(Character character) throws IOException {
        try {
            System.out.println("=================================================");
            System.out.println("                     DUNGEON                     ");
            System.out.println("=================================================");
            System.out.println("1. SLIME DUNGEON    (Recomended Level: 1)");
            System.out.println("2. ZOMBIE DUNGEON   (Recomended Level: 5)");
            System.out.println("3. SKELETON DUNGEON (Recomended Level: 15)");
            System.out.println("4. ORC DUNGEON      (Recomended Level: 25)");
            System.out.println("0. Exit");
            System.out.print("ENTER CHOICE >> ");
            int choice = Integer.parseInt(input.readLine());
            switch (choice) {
                case 1:
                    ClearScreen();
                    Dungeon dungeonS = new Dungeon(3, 5, 3, "Slime");
                    dungeonS.enterDungeon(character);
                    break;
                case 2:
                    ClearScreen(); 
                    Dungeon dungeonZ = new Dungeon(5, 15, 3, "Zombie");
                    dungeonZ.enterDungeon(character);
                    break;
                case 3:
                    ClearScreen(); 
                    Dungeon dungeonSk = new Dungeon(10, 25, 4, "Skeleton");
                    dungeonSk.enterDungeon(character);
                    break;
                case 4:
                    ClearScreen(); 
                    Dungeon dungeonO = new Dungeon(20, 35, 4, "Orc");
                    dungeonO.enterDungeon(character);
                    break;
                case 0:
                    ClearScreen(); 
                    break;
                default:
                    System.out.print("\nOption Not Available...!");
                    input.readLine();
                    ClearScreen();
                    break;
            }
        }catch (NumberFormatException e){
            System.out.println("harus angka");
            ClearScreen();
        }   
    }

    private static void ShopMenu(Character charater) throws IOException {
        try {
            System.out.println("=================================================");
            System.out.println("                     S H O P                     ");
            System.out.println("=================================================");
            System.out.println("1. WEAPON");
            System.out.println("2. POTION");
            System.out.println("3. ARMOR");
            System.out.println("0. Exit");
            System.out.print("ENTER CHOICE >> ");
            int choice = Integer.parseInt(input.readLine());
            switch (choice) {
                case 1:
                    ClearScreen();
                    shop.showWeapon(charater);
                    shop.sellWeaponP(charater);
                    break;
                case 2:
                    ClearScreen(); 
                    shop.showPotion();
                    shop.sellItemP(charater);
                    break;
                case 3:
                    ClearScreen(); 
                    shop.showArmor();
                    shop.sellArmorP(charater);
                    break;
                case 0:
                    ClearScreen(); 
                    break;
                default:
                    System.out.print("\nOption Not Available...!");
                    input.readLine();
                    ClearScreen();
                    break;
            }
        }catch (NumberFormatException e){
            System.out.println("harus angka");
            ClearScreen();
        }    
    }

    private static void Inventory(Character character) throws IOException {
        try {
            System.out.println("=================================================");
            System.out.println("                     INVENTORY                   ");
            System.out.println("=================================================");
            System.out.println("1. WEAPON");
            System.out.println("2. POTION");
            System.out.println("3. ARMOR");
            System.out.println("0. Exit");
            System.out.print("ENTER CHOICE >> ");
            int choice = Integer.parseInt(input.readLine());
            switch (choice) {
                case 1:
                    ClearScreen();
                    character.showInventoryWeapon();
                    break;
                case 2:
                    ClearScreen(); 
                    character.showInventoryPotion();
                    break;
                case 3:
                    ClearScreen(); 
                    character.showInventoryArmor();
                    break;
                case 0:
                    ClearScreen(); 
                    break;
                default:
                    System.out.print("\nOption Not Available...!");
                    input.readLine();
                    ClearScreen();
                    break;
            }
        }catch (NumberFormatException e){
            System.out.println("harus angka");
            ClearScreen();
        }    
    }
//40
    private static void ChangeWeapon(Character character, int baseAtk) throws IOException{
        ArrayList<Weapon> dWeapon = character.getInventoryWeapons();
        System.out.println("== Which Weapon You Want to Use ==");
        for (int i = 0; i < dWeapon.size(); i++) {
            System.out.println((i+1) + ". " + dWeapon.get(i).getNama() + "  |  Damage  : " + dWeapon.get(i).getDamage());
        }
        System.out.println("Which Weapon do you want to use? \n>> "); int chooseWeapon = Integer.parseInt(input.readLine());
        Weapon changeWeapon = character.getInventoryWeapons().get(chooseWeapon-1);
        character.setWeapon(changeWeapon);
        int curAtk = character.getInventoryWeapons().get(chooseWeapon-1).updateStat(baseAtk);
        character.setATK(curAtk);
        System.out.println("Weapon Has Been Changed to " + changeWeapon.getNama());
    }

    private static void ChangeArmor(Character character) throws IOException{
        ArrayList<Armor> dArmor = character.getInventoryArmors();
        System.out.println("== Which Armor You Want to Use ==");
        for (int i = 0; i < dArmor.size(); i++) {
            System.out.println((i+1) + ". " + dArmor.get(i).getNama() + "  |  Additional HP  : " + dArmor.get(i).getAdditionalHp());
        }
        System.out.println("Which Armor do you want to use? \n>> "); int chooseArmor = Integer.parseInt(input.readLine());
        Armor changeArmor = character.getInventoryArmors().get(chooseArmor-1);
        int OriHp = character.getHP();
        int addHp = OriHp + changeArmor.getAdditionalHp();
        character.setHP(addHp);
        System.out.println("Armor Has Been Changed to " + changeArmor.getNama());
    }

    private static void Profile(Character character, int baseAtk) throws IOException{
        try {
            System.out.println("=================================================");
            System.out.println("                   P R O F I L E                 ");
            System.out.println("=================================================");
            System.out.println(" Name       : " + character.getNama());
            System.out.println(" Job        : " + character.getJob());
            System.out.println(" Gender     : " + character.getGender());
            System.out.println(" Weapon     : " + character.getWeapon().getNama());
            System.out.println(" Armor      : " + character.getArmor().getNama());
            System.out.println("=================================================");
            System.out.println(" >> Status :\n");
            System.out.println(" Level      : " + character.getLevel());
            System.out.println(" EXP        : " + character.getExp());
            System.out.println(" HP         : " + character.getHP());
            System.out.println(" MP         : " + character.getMP());
            System.out.println(" Attack     : " + character.getATK());
            System.out.println(" Gold       : " + character.getGold());
            System.out.println("=================================================\n");
            System.out.println("1 . Change Weapon");
            System.out.println("2 . Change Armor");
            System.out.println("0 . Back");
            System.out.print( ">> ");
            int pilih = Integer.parseInt(input.readLine());
            switch (pilih){
                case 1:
                    ClearScreen(); 
                    ChangeWeapon(character, baseAtk);
                    break;
                case 2:
                    ClearScreen(); 
                    ChangeArmor(character);
                    break;
                case 0:
                    ClearScreen(); 
                    break;
                default:
                    System.out.print("\nOption Not Available...!");
                    input.readLine();
                    ClearScreen();
                    break;
            }
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void SettingChar(Character character, ArrayList<Account> accounts, String nama, int index){
        try {
            System.out.println("=================================================");
            System.out.println("                   P R O F I L E                 ");
            System.out.println("=================================================");
            System.out.println(" 1. Change Username ");
            System.out.println(" 2. Change Password ");
            System.out.println(" 3. Delete This Account ");
            System.out.println(" 4. Restart Game ");
            System.out.println(" 0. Return ");
            System.out.print( ">> ");
            int pilih = Integer.parseInt(input.readLine());
            switch (pilih) {
                case 0:
                    break;
                case 1:
                    System.out.println("Current Username : " + accounts.get(index).getUsername());
                    System.out.print("New Username   : "); String newName = input.readLine();
                    accounts.get(index).setUsername(newName);
                    character.setNama(newName);
                    break;
                case 2:
                    System.out.println("Current Password : " + accounts.get(index).getPassword());
                    System.out.print("New Password     : "); String newPw = input.readLine();
                    accounts.get(index).setPassword(newPw);
                    break;
                case 3:
                    System.out.print("Are you sure to delete this account [y/n] \n >> "); String acc = input.readLine();
                    if (acc.equals("y")) {
                        accounts.remove(index);
                        System.out.println("Successfully Delete Your Account!");
                        return;
                    }
                    break;
                case 4:
                    System.out.print("Are you sure to restart this account [y/n] \n >> "); String ya = input.readLine();
                    if (ya.equals("y") || ya.equals("Y")) {
                            int stage = 1;
                            accounts.get(index).setStage(stage);
                            System.out.println("Successfully Restart Your Account!"); 
                            System.out.println("Press [ENTER] to Continue"); input.readLine();
                    }
                    else {
                        System.out.println("Failed to restart your account!");
                        System.out.println("Press [ENTER] to Continue"); input.readLine();
                    }
                    break;
                default:
                    System.out.print("\nOption Not Available...!");
                    input.readLine();
                    ClearScreen();
                    break;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
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
