
class Character {
    private String name;
    private String characterClass;
    private Weapon weapon;
    private int health;
    private int mana;


    public Character(String name, String characterClass, Weapon weapon, int health, int mana) {
        this.name = name;
        this.characterClass = characterClass;
        this.weapon = weapon;
        this.health = health;
        this.mana = mana;
    }


    public String getName() {
        return name;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public int getHealth() {
        return health;
    }

    public int getMana() {
        return mana;
    }
}

class Weapon {
    private String type;
    private int damage;
    private int speed;
    private int range;


    public Weapon(String type, int damage, int speed, int range) {
        this.type = type;
        this.damage = damage;
        this.speed = speed;
        this.range = range;
    }

    public String getType() {
        return type;
    }

    public int getDamage() {
        return damage;
    }

    public int getSpeed() {
        return speed;
    }

    public int getRange() {
        return range;
    }
}

abstract class CharacterFactory {
    public abstract Character createCharacter();
    public abstract Weapon createWeapon();
}

class WarriorSwordFactory extends CharacterFactory {
    @Override
    public Character createCharacter() {
        return new Character("Warrior", "Warrior", createWeapon(), 100, 50);
    }

    @Override
    public Weapon createWeapon() {
        return new Weapon("Sword", 20, 10, 2);
    }
}

class MageStaffFactory extends CharacterFactory {
    @Override
    public Character createCharacter() {
        return new Character("Mage", "Mage", createWeapon(), 80, 100);
    }

    @Override
    public Weapon createWeapon() {
        return new Weapon("Staff", 15, 15, 5);
    }
}

class ArcherBowFactory extends CharacterFactory {
    @Override
    public Character createCharacter() {
        return new Character("Archer", "Archer", createWeapon(), 70, 70);
    }

    @Override
    public Weapon createWeapon() {
        return new Weapon("Bow", 18, 12, 8);
    }
}

class CharacterCreator {
    private CharacterFactory factory;

    public void setFactory(CharacterFactory factory) {
        this.factory = factory;
    }

    public Character createCharacter() {
        return factory.createCharacter();
    }
}


public class Ex_4 {
    public static void main(String[] args) {
        CharacterCreator creator = new CharacterCreator();
        
        creator.setFactory(new WarriorSwordFactory());
        Character warrior = creator.createCharacter();
        System.out.println("Warrior: " + warrior.getName() + ", Class: " + warrior.getCharacterClass() +
                ", Weapon: " + warrior.getWeapon().getType() + ", Mana: " + warrior.getMana());


        creator.setFactory(new MageStaffFactory());
        Character mage = creator.createCharacter();
        System.out.println("Mage: " + mage.getName() + ", Class: " + mage.getCharacterClass() +
                ", Weapon: " + mage.getWeapon().getType() + ", Mana: " + mage.getMana());


        creator.setFactory(new ArcherBowFactory());
        Character archer = creator.createCharacter();
        System.out.println("Archer: " + archer.getName() + ", Class: " + archer.getCharacterClass() +
                ", Weapon: " + archer.getWeapon().getType() + ", Mana: " + archer.getMana());
    }
}
