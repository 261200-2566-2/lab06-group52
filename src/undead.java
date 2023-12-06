public class undead implements character{
    protected String name;
    protected String gender;
    public int level=1;
    public String tribe;
    public double attack;
    public double charattack;
    public double mana;
    public double charmana;
    public double defense;
    public double health;
    public double movement_speed;

    public double returnstat;

    public String weapon;
    public int countweapon=0;
    public double manafromweapon=0;
    public double attackfromweapon=0;

    /* Construct the character tribe "Undead" by setting name and gender instance variable
    * to the values provided in the parameters: String name and String gender.
    */
    @Override
    public void characterinfomation(String name,String gender){
        this.name=name;
        this.gender=gender;
    };//เป็นfunctionที่รับinputเป็นชื่อและเพศ โดยเอาไว้เซ็ทค่าnameและgenderเฉย จะไม่มีoutputออกมา

    /* Printed statistics and information about a character, including name,
    * gender, tribe, level, attack, defence, health, mana, movement speed and
    * whether they have equipped a weapon.
    */
    @Override
    public void getstat(){
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);
        System.out.println("Tribe: " + tribe);
        System.out.println("Level: " + level);
        System.out.println("Attack: " + attack);
        System.out.println("Defense: " + defense);
        System.out.println("Health: " + health);
        System.out.println("Mana: " + mana);
        System.out.println("Movement Speed: " + movement_speed);
        if (weapon != null) {
            System.out.println("Weapon: " + weapon);
        } else {
            System.out.println("Your hand is empty. Equip a weapon!");
        }
    };//เป็นfunctionที่ไม่มีinput output เอาไว้printค่าstatusตัวละคร

    /* Initializes the statistics of a character to default values for a Undead tribe.
    *
    * effects: Set default statistics for Undead tribe.
    */
    @Override
    public void defaultstat(){
        tribe="undead";
        attack = 30;
        charattack =30;
        defense = 2;
        health = 50;
        mana = 30;
        charmana=30;
        movement_speed = 15;
    };//เป็นfunctionที่ไม่มีinput output เอาไว้setค่าstatusเริ่มต้น

    /* Display skill of human tribe. */
    @Override
    public void skill(){
        System.out.println("Necrotic Touch : Inflicts a curse on enemies,causing damage over time and weakening their abilities ");
    };//เป็นfunctionที่ไม่มีinput output เอาไว้print skillของตัวละครแต่ละเผ่า

    /* Update the statistics of a character when they level up.
    *
    * effects: update new values to instance variable
    * effects: "Level up+++" printed
    */
    @Override
    public void levelup(){
        charattack +=2*level;
        attack=charattack+attackfromweapon;
        defense +=4*level;
        health +=5*level;
        charmana +=3*level;
        mana=charmana+manafromweapon;
        movement_speed += (0.1+0.03*level);
        level++;
        System.out.println("Level up +++");
    };//เป็นfunctionที่ไม่มีinput output เอาไว้เปลี่ยนstatusตอนlevel up

    /* Check if character has already equipped a weapon (allow only one weapon) by taking a sword object 'a' as a parameter.
    * If the character does not have a weapon, gets the attack stat from the sword, updates the character's attack statistics,
    * sets the weapon type to "sword," increases the weapon count, and updates the total attack.
    * If the character already has a weapon, prints "Your hand is full.".
    *
    * @param a sword to be equipped.
    *
    * effects: Updates the character statistics by adding damages of the sword.
    * effects: If the character equip weapon, print "Your hand is full."
    */
    @Override
    public void equip(sword a){
        if(countweapon<1){
            undead data= new undead();
            returnstat = a.getstat(data);
            attackfromweapon +=returnstat;
            weapon="sword";
            countweapon++;
            attack=charattack+attackfromweapon;
            System.out.println("Equip already.");
        }else{
            System.out.println("Your hand is full.");
        }
    }//เป็นfunctionที่มีinputเป็นobject sword ไม่มีoutput เอาไว้ใส่อาวุธ โดยจะใส่ได้แค่ชิ้นเดียว ซึ่งจะเปลี่ยนแปลงstatusบางส่วน statusที่เปลี่ยนจะเรียกมาจากfunction getstat ของclassอาวุธ

    /* Check if character has already equipped a weapon (allow only one weapon) by taking a ward object 'a' as a parameter.
    * If the character does not have a weapon, gets the attack stat from the ward, updates the character's mana statistics,
    * sets the weapon type to "ward," increases the weapon count by one, and updates the total attack.
    * If the character already has a weapon, prints "Your hand is full.".
    *
    * @param a ward to be equipped
    *
    * effects: Updates the character statistics by adding mana of the ward.
    * effects: If the character equip weapon, prints "Your hand is full."
    */
    @Override
    public void equip(ward a){
        if(countweapon<1){
            undead data= new undead();
            returnstat = a.getstat(data);
            manafromweapon +=returnstat;
            weapon="ward";
            countweapon++;
            mana=charmana+manafromweapon;
            System.out.println("Equip already.");
        }else{
            System.out.println("Your hand is full.");
        }
    }//เป็นfunctionที่มีinputเป็นobject ward ไม่มีoutput เอาไว้ใส่อาวุธ โดยจะใส่ได้แค่ชิ้นเดียว ซึ่งจะเปลี่ยนแปลงstatusบางส่วน statusที่เปลี่ยนจะเรียกมาจากfunction getstat ของclassอาวุธ

    /* Checks the type of weapon (ward or sword), updates the relevant statistics (mana or attack), decrease the weapon count by one,
    * and updates the total mana or attack.
    * If the character does not have a weapon, print "You don't have any weapon.".
    *
    * effects: Updates the total attack or mana.
    * effects: If the character does not have weapon, prints "You don't have any weapon.".
    */
    @Override
    public void unequip(){
        if(weapon.equals("ward")){
            manafromweapon -=returnstat;
            countweapon--;
            mana=manafromweapon+charmana;
        }else if(weapon.equals("sword")){
            attackfromweapon -=returnstat;
            countweapon--;
            attack=charattack+attackfromweapon;
        }else{
            System.out.println("you don't have any weapon.");
        }
    }//เป็นfunctionที่ไม่มีinput ไม่มีoutput แต่เอาไว้เปลี่ยนค่าstatusกลับ

    /* Initiates an attack on an undead character.
    * Prints an attack message indicating the attacker's name and the target's name.
    * Calculates the damage dealt based on the difference between the attacker's
    * attack and the target's defense. Reduces the target's health accordingly.
    * If the calculated damage is non-negative, subtracts it from the target's health.
    * If the calculated damage is negative (attacker's attack is less than target's defense),
    * sets the target's health to 0 and prints a message.
    *
    * @param an Undead character being attacked.
    *
    * effects: Prints the attacker's name and the target's name and sets the target's health by calculating damage.
    * effects: If the calculated damage is negative, prints a message.
    */
    @Override
    public void attack(undead a){
        System.out.println(name+" attack "+a.name);
        if(attack*0.5-a.defense >= 0){
            a.health-=attack*0.5-a.defense;
        }else{
            a.health = 0;
            System.out.println("Your attack is less than enemy defense.");
        }
    }//input เป็นcharacterเผ่าundeadโดยจะสร้างความเสียหายเป็น0.5เท่าของattack-ด้วยdefense outputไม่มี

    /* Initiates an attack on a human character.
    * Prints an attack message indicating the attacker's name and the target's name.
    * Calculates the damage dealt based on the difference between the attacker's
    * attack and the target's defense. Reduces the target's health accordingly.
    * If the calculated damage is non-negative, subtracts it from the target's health.
    * If the calculated damage is negative (attacker's attack is less than target's defense),
    * sets the target's health to 0 and prints a message.
    *
    * @param a Human character being attacked.
    *
    * effects: Prints the attacker's name and the target's name and sets the target's health by calculating damage.
    * effects: If the calculated damage is negative, prints a message.
    */
    @Override
    public void attack(human a){
        System.out.println(name+" attack "+a.name);
        if(attack-a.defense >= 0){
            a.health-=attack-a.defense;
        }else{
            a.health = 0;
            System.out.println("Undead attack is less than Human defense.");
        }
    }//input เป็นcharacterเผ่าhumanโดยจะสร้างความเสียหายเป็นattack-ด้วยdefense outputไม่มี

}
