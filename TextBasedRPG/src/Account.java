import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Account implements Level_user{
    private ArrayList<Account> dataAkun;
    private String username;
    private String password;
    private Character karakter;
    private int stage = 0;
    private int Status;

    static InputStreamReader isr = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(isr);
    int baseAtk = 0;
    
    public Account (String Username, String Password, int status, String nama, int ATK, int HP, int MP, int dmgSkill, String skill, Weapon weapon, Armor armor, String gender, String job) {
        this.username = Username;
        this.password = Password;
        this.Status = status;
        this.karakter = new Character(nama, ATK, HP, MP,dmgSkill, skill, weapon, armor, gender, job);
        dataAkun = new ArrayList<Account>();
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStage() {
        return this.stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }
    
    public Character getKarakter() {
        return this.karakter;
    }

    public void setKarakter(Character Karakter) {
        this.karakter = Karakter;
    }

    public int getStatus() {
        return this.Status;
    }

    public void setStatus(int status) {
        this.Status = status;
    }

    @Override
    public void login() {
        try {
            ClearScreen();
            System.out.println("=================================================");
            System.out.println("                    L O G I N                    ");
            System.out.println("=================================================");
            System.out.print(" USERNAME : "); String username = input.readLine();
            System.out.print(" PASSWORD : "); String password = input.readLine();

            for (int i = 0; i < dataAkun.size(); i++) {
                if (dataAkun.get(i).getUsername().equals(username) && dataAkun.get(i).getPassword().equals(password)) {
                    System.out.println(" Welcome sir " + dataAkun.get(i).getUsername());
                    Main MainMenu = new Main();
                    System.out.print("\n Press [ENTER] to Continue...");
                    input.readLine();
                    ClearScreen();
                    MainMenu.Home(dataAkun.get(i).getKarakter(), dataAkun, i, baseAtk);
                }
                else {
                    System.out.println("\nUser Not Found!");
                    input.readLine();
                    ClearScreen();
                }
            }
            if (username.equals("admin") && password.equals("admin")){
                System.out.println("\n Welcome Sir Admin");
                Admin menuAdmin = new Admin();
                System.out.print("\n Press [ENTER] to Continue...");
                input.readLine();
                ClearScreen();
                menuAdmin.Home();
                }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void register() {
        try {
            boolean cek = true;
            while (cek) {
                System.out.println("=================================================");
                System.out.println("                  R E G I S T E R                 ");
                System.out.println("=================================================");
                
                System.out.print("USERNAME : "); String username = input.readLine();
                System.out.print("PASSWORD : "); String password = input.readLine();
                System.out.print("CONFIRM PASSWORD : "); String cpassword = input.readLine();
                System.out.println("=================================================");

                if (password.equals(cpassword)){
                    cek = false;
                    CreateCharacter(username, password);
                    this.login();
                }
                else {
                    System.out.println("passwords do not match!\n");
                    System.out.print("Press [ENTER] to continue"); 
                    input.readLine();
                    ClearScreen();
                    cek = true;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void CreateCharacter(String uname, String password) {
        try {
            int atk = 20;
            int health = 100;
            int mp = 30; 
            int dmg = 40;
            String mySkill = "";
            String job = "";
            String gen = "";
            Weapon createWeapon = new Weapon(null, null, 0, 0, null);
            Armor createArmor = new Armor(null, null, 0, 0);
            ClearScreen();
            System.out.println("=================================================");
            System.out.println("    C R E A T E   Y O U R   C H A R A C T E R    ");
            System.out.println("=================================================");
            System.out.println(">> Choose Gender <<");
            System.out.println("1. Male");
            System.out.println("2. Female");
            System.out.print("ENTER CHOICE >> "); int pilih = Integer.parseInt(input.readLine());
            if (pilih == 1) {
                gen = "Male";
            } else if (pilih == 2) {
                gen = "Female";
            } else {
                System.out.println("invalid choice");
            }
            System.out.println("\n>> Choose Job <<");
            System.out.println("1. Warrior");
            System.out.println("2. Archer");
            System.out.println("3. Mage");
            System.out.print("ENTER CHOICE >> "); int pilihJob = Integer.parseInt(input.readLine());
            
            if (pilihJob == 1) {
                job = "Warrior";
                atk = atk + 5;
                health = health + 25;
                mp = mp - 5;
                dmg = dmg + 5;
            } else if (pilihJob == 2) {
                job = "Archer";
                atk = atk + 15;
                health = health - 15;
                mp = mp + 5;
                dmg = dmg + 10;
            } else if (pilihJob == 3) {
                job = "Mage";
                atk = atk - 5;
                health = health - 10;
                mp = mp + 20;
                dmg = dmg + 20;
            } else {
                System.out.println("Invalid Choice");
            }
            
            if (job.equals("Warrior")) {
                mySkill = "Mana Slash";
            } else if(job.equals("Archer")){
                mySkill = "Wind Shot";
            } else if (job.equals("Mage")){
                mySkill = "Fireball";
            }
            if (job.equals("Warrior")) {
                createWeapon.setNama("Basic Sword"); createWeapon.setDamage(15); createWeapon.setType("Sword"); createWeapon.setId("W001");
            } else if(job.equals("Archer")){
                createWeapon.setNama("Basic Bow"); createWeapon.setDamage(15); createWeapon.setType("Bow"); createWeapon.setId("W002");
            } else if (job.equals("Mage")){
                createWeapon.setNama("Basic Staff"); createWeapon.setDamage(15); createWeapon.setType("Staff"); createWeapon.setId("W003");
            }
            int stat = 0;
            int atkNow = createWeapon.updateStat(atk);
            createArmor.setNama("Basic Plate"); createArmor.setAdditionalHp(10);
            int hpNow = createArmor.updateStat(health);
            baseAtk = atk;
            Account newAccount = new Account(uname, password, stat, uname, atkNow, hpNow, mp, dmg, mySkill, createWeapon, createArmor,gen, job);
            dataAkun.add(newAccount);
            dataAkun.size();
            System.out.println("\nYour character has been successfully created!"); 
            System.out.print("\nPress [ENTER] to continue..."); 
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
            System.err.println("Failed to ");
        }
    }
}
