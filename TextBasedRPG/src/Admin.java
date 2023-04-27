import java.io.BufferedReader;
import java.io.InputStreamReader;
// import java.util.ArrayList;

public class Admin implements Level_admin {
    static String ID, Type;
    static int HP, ATK, MP;
    static InputStreamReader isr = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(isr);
    static Weapon dataWeapon = new Weapon(null, null, 0, 0, null);
    static Potion dataPotion = new Potion(null, null, 0, 0, 0, 0, null);
    static Armor dataArmor = new Armor(null, null, 0, 0);


    @Override
    public void Add_Weapon() {
        try {
            System.out.println("=================================================");
            System.out.println("                A D D   W E A P O N              ");
            System.out.println("=================================================");
            int rr = 0, kk = 1;
                while (rr != 1) {
                    kk = 0;
                    System.out.print("ID        : "); ID = input.readLine();
                    for (Weapon Weapon1 : dataWeapon.getWeapon()){
                        if (Weapon1.getId().equals(ID)) {
                            System.out.print("\nId Weapon Already Exist! Try Another Id.");input.readLine();
                            kk = 1;
                            ClearScreen();
                            System.out.println("=================================================");
                            System.out.println("                A D D   W E A P O N              ");
                            System.out.println("=================================================");
                        }
                    }
                    if (kk != 1){
                        rr = 1;
                    }
                }
            System.out.print("Name      : "); String name = input.readLine();
            System.out.print("Damage    : "); int damage = Integer.parseInt(input.readLine());
            System.out.println("+> Type Weapon "); 
            System.out.println("1. Warrior");
            System.out.println("2. Archer");
            System.out.println("3. Mage");
            System.out.print(" >> "); int pilihan = Integer.parseInt(input.readLine());
            if (pilihan == 1) {
                Type = "Warrior";
            } else if (pilihan == 2) {
                Type = "Archer";
            } else {
                Type = "Mage";
            }
            System.out.print("Price     : "); int harga = Integer.parseInt(input.readLine());
            
            Weapon newWeapon = new Weapon(name, ID, harga, damage, Type);
            Shop.Add_Weapon(name, ID, harga, damage, Type);
            dataWeapon.getWeapon().add(newWeapon);
            System.out.println("\nSUCCESS ADD WEAPON\n");
            System.out.print("Press [ENTER] To Continue...");
            input.readLine();
            ClearScreen();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void Display_Weapon() {
        try {
            if (dataWeapon.getWeapon().size() == 0) {
                    System.out.println("\n\nData Weapon Still Empty!!\n\n");
                    System.out.print("\nPress [ENTER] To Continue..."); input.readLine();
                } 
                else {
                    System.out.println("=================================================");
                    System.out.println("               I T E M   W E A P O N             ");
                    System.out.println("=================================================");
                    for (int i = 0; i < dataWeapon.getWeapon().size(); i += 1) {
                                System.out.println("Weapon >> No." + (i + 1) + "\n");
                                dataWeapon.getWeapon().get(i).showChar();
                                System.out.println("-------------------------------------------------\n");
                    }
                }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void Display_Potion() {
        try {
            if (dataPotion.getPotion().size() == 0) {
                    System.out.println("\n\nData Potion Still Empty!!\n\n");
                    System.out.print("\nPress [ENTER] To Continue..."); input.readLine();
                } 
                else {
                    System.out.println("=================================================");
                    System.out.println("               I T E M   P O T I O N             ");
                    System.out.println("=================================================");
                    for (int i = 0; i < dataPotion.getPotion().size(); i += 1) {
                                System.out.println("Potion >> No." + (i + 1) + "\n");
                                dataPotion.getPotion().get(i).showPotion(false);
                                System.out.println("-------------------------------------------------\n");
                    }
                }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void Display_Shop() {
        try {
            System.out.println("=================================================");
            System.out.println("         D I S P L A Y   I T E M   S H O P       ");
            System.out.println("=================================================");
            System.out.println("1. Weapon");
            System.out.println("2. Potion");
            System.out.println("3. Armor");
            System.out.println("0. Leave");
            System.out.print(" >> "); int pilih = Integer.parseInt(input.readLine());
            switch (pilih) {
                    case 1:
                        ClearScreen();
                        Display_Weapon();
                        break;
                    case 2: 
                        ClearScreen();
                        Display_Potion();
                        break;
                    case 3: 
                        ClearScreen();
                        Display_Armor();
                        break;
                    case 0: 
                        ClearScreen();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("\nOption Not Available!\n");
                        ClearScreen();
                        break;
                }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void Update_Potion() {
        try {
            int if_Find1 = 0;
                if (dataPotion.getPotion().size() == 0) {
                    System.out.println("\n\nData Potion Still Empty!!\n\n");
                    System.out.print("\nPress [ENTER] To Continue..."); input.readLine();
                } 
                else {
                        System.out.println("\n>> List of Potion <<\n");
                        System.out.println("+-----------------------------------------------+\n");
                        for (int i = 0; i < dataPotion.getPotion().size(); i += 1) {
                            System.out.println("Potion >> No." + (i + 1) + "\n");
                            dataPotion.getPotion().get(i).showPotion(true);
                            System.out.println("+-----------------------------------------------+\n");
                        }
                        System.out.println("\n>> Update Potion <<\n");
                        System.out.print("Input Id Potion -> ");  ID = input.readLine();

                        for (Potion Potion1 : dataPotion.getPotion()){
                            if (Potion1.getId().equals(ID)) {
                                System.out.print("New Name      -> "); Potion1.setNama(input.readLine());
                                System.out.println("+> New Type Potion "); 
                                System.out.println("1. Health");
                                System.out.println("2. Attack");
                                System.out.println("3. Mana");
                                System.out.print(" >> "); int pilihan = Integer.parseInt(input.readLine());
                                if (pilihan == 1) {
                                    System.out.println("If you chose type Health, value of ATK & MP will be 0 ");
                                    System.out.print("HP    : "); HP = Integer.parseInt(input.readLine());
                                    ATK = 0;
                                    MP = 0;
                                    Type = "Health";
                                } else if (pilihan == 2) {
                                    System.out.println("If you chose type Attack, value of HP & MP will be 0 ");
                                    System.out.print("ATK    : "); ATK = Integer.parseInt(input.readLine());
                                    HP = 0;
                                    MP = 0;
                                    Type = "Attack";
                                } else {
                                    System.out.println("If you chose type Mana, value of ATK & HP will be 0 ");
                                    System.out.print("MP    : "); MP = Integer.parseInt(input.readLine());
                                    ATK = 0;
                                    HP = 0;
                                    Type = "Mana";
                                }
                                Potion1.setType(Type);
                                Potion1.setATK(ATK);
                                Potion1.setHP(HP);
                                Potion1.setMP(MP);
                                System.out.print("New Price     -> "); Potion1.setHarga(Integer.parseInt(input.readLine()));
                                System.out.println("\n\nPotion Was Successfully Changed!\n\n");
                                if_Find1 = 1;
                                System.out.print("\nPress [ENTER] To Continue..."); input.readLine();
                                break;
                            }
                        }
                        if (if_Find1 == 0) {
                        System.out.println("\n\nId Potion Not Found!\n\n");
                        System.out.print("\nPress [ENTER] To Continue..."); input.readLine();
                        }
                }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void Add_Armor() {
        try {
            System.out.println("=================================================");
            System.out.println("                 A D D   A R M O R               ");
            System.out.println("=================================================");
            int rr = 0, kk = 1;
                while (rr != 1) {
                    kk = 0;
                    System.out.print("ID              : "); ID = input.readLine();
                    for (Armor Armor1 : dataArmor.getArmor()){
                        if (Armor1.getId().equals(ID)) {
                            System.out.print("\nId Armor Already Exist! Try Another Id.");input.readLine();
                            kk = 1;
                            ClearScreen();
                            System.out.println("=================================================");
                            System.out.println("                 A D D   A R M O R               ");
                            System.out.println("=================================================");
                        }
                    }
                    if (kk != 1){
                        rr = 1;
                    }
                }
            System.out.print("Armor Name      : "); String name = input.readLine();
            System.out.print("Additional HP   : "); int addHP = Integer.parseInt(input.readLine());
            System.out.print("Price           : "); int harga = Integer.parseInt(input.readLine());
            
            Armor newArmor = new Armor(name, ID, harga, addHP);
            Shop.Add_Armor(name, ID, harga, addHP); 
            dataArmor.getArmor().add(newArmor);
            System.out.println("\nSUCCESSFULLY ADD ARMOR");
            System.out.print("\nPress [ENTER] To Continue...");
            input.readLine();
            ClearScreen();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void Update_Shop() {
        try {
            System.out.println("=================================================");
            System.out.println("          U P D A T E   I T E M   S H O P        ");
            System.out.println("=================================================");
            System.out.println("1. Weapon");
            System.out.println("2. Potion");
            System.out.println("3. Armor");
            System.out.println("0. Leave");
            System.out.print(" >> "); int pilih = Integer.parseInt(input.readLine());
            switch (pilih) {
                    case 1:
                        ClearScreen();
                        Update_Weapon();
                        break;
                    case 2: 
                        ClearScreen();
                        Update_Potion();
                        break;
                    case 3: 
                        ClearScreen();
                        Update_Armor();
                        break;
                    case 0:
                        ClearScreen(); 
                        System.exit(0);
                        break;
                    default:
                        System.out.println("\nOption Not Available!\n");
                        ClearScreen();
                        break;
                }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    @Override
    public void Delete_Shop() {
        try {
            System.out.println("=================================================");
            System.out.println("          D E L E T E   I T E M   S H O P        ");
            System.out.println("=================================================");
            System.out.println("1. Weapon");
            System.out.println("2. Potion");
            System.out.println("3. Armor");
            System.out.println("0. Leave");
            System.out.print(" >> "); int pilih = Integer.parseInt(input.readLine());
            switch (pilih) {
                    case 1:
                        Delete_Weapon();
                        break;
                    case 2: 
                        Delete_Potion();
                        break;
                    case 3: 
                        Delete_Armor();
                        break;
                    case 0: 
                        System.exit(0);
                        break;
                    default:
                        System.out.println("\nOption Not Available!\n");
                        ClearScreen();
                        break;
                }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void Delete_Weapon() {
        try {
            if (dataWeapon.getWeapon().size() == 0){
                    System.out.println("\nData Weapons Still Empty!!]\n");
                    System.out.print("\nPress [ENTER] To Continue..."); input.readLine();
                }
                else {
                    System.out.println("\n>> List of Weapons <<\n");
                    System.out.println("+-----------------------------------------------+\n");
                    boolean trueId = false;
                    for (int i = 0; i < dataWeapon.getWeapon().size(); i += 1) {
                        System.out.println("Weapon >> No." + (i + 1) + "\n");
                        dataWeapon.getWeapon().get(i).showChar(true);
                        System.out.println("+-----------------------------------------------+\n");
                    }
                    System.out.println("\n>> Delete Weapons <<\n");
                    System.out.print("Input Id Weapon -> ");  ID = input.readLine();
                    for (int j = 0; j < dataWeapon.getWeapon().size(); j++) {
                        if ((dataWeapon.getWeapon().get(j).getId().equals(ID))) {
                            System.out.println("Delete Weapons With Id " + ID + " ?");
                            System.out.print("Are You Sure You Want To Delete {y/n} >> "); String action = input.readLine();
                            if (action.equals ("y")){
                                dataWeapon.getWeapon().remove(j);
                                trueId = true;
                                System.out.println("\nWeapon Has Been Successfully Deleted!\n");
                                System.out.print("\nPress [ENTER] To Continue..."); input.readLine();
                                break;
                            }
                            else {
                                System.out.println("\nFailed to Delete Weapon!\n");
                                trueId = true;
                                System.out.print("\nPress [ENTER] To Continue..."); input.readLine();
                                break;
                            }
                        }
                    }
                            
                    if (trueId == false) {
                        System.out.println("\nId Weapon Not Found!\n");
                        System.out.print("\nPress [ENTER] To Continue..."); input.readLine();
                        }
                }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void Delete_Potion() { 
        try {
            if (dataPotion.getPotion().size() == 0){
                    System.out.println("\nData Potions Still Empty!!]\n");
                    System.out.print("\nPress [ENTER] To Continue..."); input.readLine();
                }
                else {
                    System.out.println("\n>> List of Potions <<\n");
                    System.out.println("+-----------------------------------------------+\n");
                    boolean trueId = false;
                    for (int i = 0; i < dataPotion.getPotion().size(); i += 1) {
                        System.out.println("Potion >> No." + (i + 1) + "\n");
                        dataPotion.getPotion().get(i).showPotion(true);
                        System.out.println("+-----------------------------------------------+\n");
                    }
                    System.out.println("\n>> Delete Potions <<\n");
                    System.out.print("Input Id Potion -> ");  ID = input.readLine();
                    for (int j = 0; j < dataPotion.getPotion().size(); j++) {
                        if ((dataPotion.getPotion().get(j).getId().equals(ID))) {
                            System.out.println("Delete Potions With Id " + ID + " ?");
                            System.out.print("Are You Sure You Want To Delete {y/n} >> "); String action = input.readLine();
                            if (action.equals ("y")){
                                dataPotion.getPotion().remove(j);
                                trueId = true;
                                System.out.println("\nPotion Has Been Successfully Deleted!\n");
                                System.out.print("\nPress [ENTER] To Continue..."); input.readLine();
                                break;
                            }
                            else {
                                System.out.println("\nFailed to Delete Potion!\n");
                                trueId = true;
                                System.out.print("\nPress [ENTER] To Continue..."); input.readLine();
                                break;
                            }
                        }
                    }
                            
                    if (trueId == false) {
                        System.out.println("\nId Potion Not Found!\n");
                        System.out.print("\nPress [ENTER] To Continue..."); input.readLine();
                        }
                }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void Delete_Armor() {
        try {
            if (dataArmor.getArmor().size() == 0){
                    System.out.println("\nData Armors Still Empty!!]\n");
                    System.out.print("\nPress [ENTER] To Continue..."); input.readLine();
                }
                else {
                    System.out.println("\n>> List of Armors <<\n");
                    System.out.println("+-----------------------------------------------+\n");
                    boolean trueId = false;
                    for (int i = 0; i < dataArmor.getArmor().size(); i += 1) {
                        System.out.println("Armor >> No." + (i + 1) + "\n");
                        dataArmor.getArmor().get(i).showChar(true);
                        System.out.println("+-----------------------------------------------+\n");
                    }
                    System.out.println("\n>> Delete Armors <<\n");
                    System.out.print("Input Id Armor -> ");  ID = input.readLine();
                    for (int j = 0; j < dataArmor.getArmor().size(); j++) {
                        if ((dataArmor.getArmor().get(j).getId().equals(ID))) {
                            System.out.println("Delete Armors With Id " + ID + " ?");
                            System.out.print("Are You Sure You Want To Delete {y/n} >> "); String action = input.readLine();
                            if (action.equals ("y")){
                                dataArmor.getArmor().remove(j);
                                trueId = true;
                                System.out.println("\nArmor Has Been Successfully Deleted!\n");
                                System.out.print("\nPress [ENTER] To Continue..."); input.readLine();
                                break;
                            }
                            else {
                                System.out.println("\nFailed to Delete Armor!\n");
                                trueId = true;
                                System.out.print("\nPress [ENTER] To Continue..."); input.readLine();
                                break;
                            }
                        }
                    }
                            
                    if (trueId == false) {
                        System.out.println("\nId Weapon Not Found!\n");
                        System.out.print("\nPress [ENTER] To Continue..."); input.readLine();
                        }
                }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void Update_Weapon() {
        try {
            int if_Find1 = 0;
                if (dataWeapon.getWeapon().size() == 0) {
                    System.out.println("\n\nData Weapon Still Empty!!\n\n");
                    System.out.print("\nPress [ENTER] To Continue..."); input.readLine();
                } 
                else {
                        System.out.println("\n>> List of Weapon <<\n");
                        System.out.println("+-----------------------------------------------+\n");
                        for (int i = 0; i < dataWeapon.getWeapon().size(); i += 1) {
                            System.out.println("Weapon >> No." + (i + 1) + "\n");
                            dataWeapon.getWeapon().get(i).showChar(true);
                            System.out.println("+-----------------------------------------------+\n");
                        }
                        System.out.println("\n>> Update Weapon <<\n");
                        System.out.print("Input Id Weapon -> ");  ID = input.readLine();

                        for (Weapon Weapon1 : dataWeapon.getWeapon()){
                            if (Weapon1.getId().equals(ID)) {
                                System.out.print("New Name      -> "); Weapon1.setNama(input.readLine());
                                System.out.println("+> Type Weapon "); 
                                System.out.println("1. Warrior");
                                System.out.println("2. Archer");
                                System.out.println("3. Mage");
                                System.out.print(" >> "); int pilihan = Integer.parseInt(input.readLine());
                                if (pilihan == 1) {
                                    Type = "Warrior";
                                } else if (pilihan == 2) {
                                    Type = "Archer";
                                } else {
                                    Type = "Mage";
                                }
                                Weapon1.setType(Type);
                                System.out.print("New Damage  -> "); Weapon1.setDamage(Integer.parseInt(input.readLine()));
                                System.out.print("New Price     -> "); Weapon1.setHarga(Integer.parseInt(input.readLine()));
                                System.out.println("\n\nWeapon Was Successfully Changed!\n\n");
                                if_Find1 = 1;
                                System.out.print("\nPress [ENTER] To Continue..."); input.readLine();
                                break;
                            }
                        }
                        if (if_Find1 == 0) {
                        System.out.println("\n\nId Weapon Not Found!\n\n");
                        System.out.print("\nPress [ENTER] To Continue..."); input.readLine();
                        }
                }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void Update_Armor() {
        try {
            int if_Find1 = 0;
                if (dataArmor.getArmor().size() == 0) {
                    System.out.println("\n\nData Armor Still Empty!!\n\n");
                    System.out.print("\nPress [ENTER] To Continue..."); input.readLine();
                } 
                else {
                        System.out.println("\n>> List of Armor <<\n");
                        System.out.println("+-----------------------------------------------+\n");
                        for (int i = 0; i < dataArmor.getArmor().size(); i += 1) {
                            System.out.println("Armor >> No." + (i + 1) + "\n");
                            dataArmor.getArmor().get(i).showChar(true);
                            System.out.println("+-----------------------------------------------+\n");
                        }
                        System.out.println("\n>> Update Armor <<\n");
                        System.out.print("Input Id Armor -> ");  ID = input.readLine();

                        for (Armor Armor1 : dataArmor.getArmor()){
                            if (Armor1.getId().equals(ID)) {
                                System.out.print("New Name           -> "); Armor1.setNama(input.readLine());
                                System.out.print("New Additional HP  -> "); Armor1.setAdditionalHp(Integer.parseInt(input.readLine()));
                                System.out.print("New Price          -> "); Armor1.setHarga(Integer.parseInt(input.readLine()));
                                System.out.println("\n\nArmor Was Successfully Changed!\n\n");
                                if_Find1 = 1;
                                System.out.print("\nPress [ENTER] To Continue..."); input.readLine();
                                break;
                            }
                        }
                        if (if_Find1 == 0) {
                        System.out.println("\n\nId Armor Not Found!\n\n");
                        System.out.print("\nPress [ENTER] To Continue..."); input.readLine();
                        }
                }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void Display_Armor() {
        try {
            if (dataArmor.getArmor().size() == 0) {
                    System.out.println("\n\nData Armor Still Empty!!\n\n");
                    System.out.print("\nPress [ENTER] To Continue..."); input.readLine();
                } 
                else {
                    System.out.println("=================================================");
                    System.out.println("               I T E M   W E A P O N             ");
                    System.out.println("=================================================");
                    for (int i = 0; i < dataArmor.getArmor().size(); i += 1) {
                                System.out.println("Armor >> No." + (i + 1) + "\n");
                                dataArmor.getArmor().get(i).showChar();
                                System.out.println("-------------------------------------------------\n");
                    }
                }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void Add_Shop() {
        try {
            System.out.println("=================================================");
            System.out.println("              A D D   I T E M   S H O P          ");
            System.out.println("=================================================");
            System.out.println("1. Weapon");
            System.out.println("2. Potion");
            System.out.println("3. Armor");
            System.out.println("0. Leave");
            System.out.print(" >> "); int pilih = Integer.parseInt(input.readLine());
            switch (pilih) {
                    case 1:
                        ClearScreen();
                        Add_Weapon();
                        break;
                    case 2:
                        ClearScreen();
                        Add_Potion();
                        break;
                    case 3:
                        ClearScreen();
                        Add_Armor();
                        break;
                    case 0:
                        ClearScreen(); 
                        break;
                    default:
                        System.out.println("\nOption Not Available!\n");
                        ClearScreen();
                        break;
                }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void Add_Potion() {
        try {
            System.out.println("=================================================");
            System.out.println("                A D D   P O T I O N              ");
            System.out.println("=================================================");
            int rr = 0, kk = 1;
                while (rr != 1) {
                    kk = 0;
                    System.out.print("ID      : "); ID = input.readLine();
                    for (Potion Potion1 : dataPotion.getPotion()){
                        if (Potion1.getId().equals(ID)) {
                            System.out.println("Id Potion Already Exist! Try Another Id."); input.readLine();
                            kk = 1;
                            ClearScreen();
                            System.out.println("=================================================");
                            System.out.println("                A D D   P O T I O N              ");
                            System.out.println("=================================================");
                        }
                    }
                    if (kk != 1){
                        rr = 1;
                    }
                }
            System.out.print("Name    : "); String nameP = input.readLine();
            System.out.println("+> Type Potion "); 
            System.out.println("1. Health");
            System.out.println("2. Attack");
            System.out.println("3. Mana");
            System.out.print(" >> "); int pilihan = Integer.parseInt(input.readLine());
            if (pilihan == 1) {
                System.out.print("HP      : "); HP = Integer.parseInt(input.readLine());
                ATK = 0;
                MP = 0;
                Type = "Health";
            } else if (pilihan == 2) {
                System.out.print("ATK     : "); ATK = Integer.parseInt(input.readLine());
                HP = 0;
                MP = 0;
                Type = "Attack";
            } else {
                System.out.print("MP      : "); MP = Integer.parseInt(input.readLine());
                ATK = 0;
                HP = 0;
                Type = "Mana";
            }
            System.out.print("Price   : "); int harga = Integer.parseInt(input.readLine());
            
            Potion newPotion = new Potion(ID, nameP, harga, ATK, HP, MP, Type);
            dataPotion.getPotion().add(newPotion);
            Shop.Add_Potion(ID, nameP, harga, ATK, HP, MP, Type);
            System.out.println("\nSUCCES ADD POTION");
            System.out.print("\nPress [ENTER] To Continue..."); 
            input.readLine();
            ClearScreen();

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

    @Override
    public void Home(){
        int choice = -1;
        while(choice != 0){
            try {
                System.out.println("=================================================");
                System.out.println("                     H O M E                     ");
                System.out.println("=================================================");
                System.out.println("1. ADD ITEM");
                System.out.println("2. DISPLAY");
                System.out.println("3. UPDATE");
                System.out.println("4. DELETE");
                System.out.println("0. Exit");
                System.out.print("ENTER CHOICE >> ");
                choice = Integer.parseInt(input.readLine());
                switch (choice) {
                    case 0: 
                        ClearScreen();
                        //Exit();
                        break;
                    case 1:
                        ClearScreen();
                        Add_Shop();
                        break;
                    case 2:
                        ClearScreen(); 
                        Display_Shop();
                        break;
                    case 3:
                        ClearScreen(); 
                        Update_Shop();
                        break;
                    case 4:
                        ClearScreen(); 
                        Delete_Shop();
                        break;
                    default:
                        System.out.println("\nOption Not Available!\n");
                        ClearScreen();
                        break;
                }
            } catch (Exception e) {
            System.out.println(e);
        }   
        }
    }
}