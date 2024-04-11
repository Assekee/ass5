import java.util.List;
import java.util.ArrayList;

class Character {
    private String name;
    private Appearance appearance;
    private List<Ability> abilities;
    private List<Equipment> equipment;
    private Attribute attributes;


    public Character(String name, Appearance appearance, List<Ability> abilities, List<Equipment> equipment, Attribute attributes) {
        this.name = name;
        this.appearance = appearance;
        this.abilities = abilities;
        this.equipment = equipment;
        this.attributes = attributes;
    }

    public String getName() {
        return name;
    }

    public Appearance getAppearance() {
        return appearance;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public List<Equipment> getEquipment() {
        return equipment;
    }

    public Attribute getAttributes() {
        return attributes;
    }



}
abstract class CharacterFactory {
    public abstract Character createCharacter(String name);
}


class WarriorFactory extends CharacterFactory {
    @Override
    public Character createCharacter(String name) {
        Appearance appearance = new Appearance("Warrior Appearance");
        List<Ability> abilities = new ArrayList<>();
        abilities.add(new Ability("Slash"));
        abilities.add(new Ability("Block"));
        List<Equipment> equipment = new ArrayList<>();
        equipment.add(new Equipment("Sword"));
        equipment.add(new Equipment("Shield"));
        Attribute attributes = new Attribute(100, 50, 20);
        return new Character(name, appearance, abilities, equipment, attributes);
    }
}

class MageFactory extends CharacterFactory {
    @Override
    public Character createCharacter(String name) {
        Appearance appearance = new Appearance("Mage Appearance");
        List<Ability> abilities = new ArrayList<>();
        abilities.add(new Ability("Fireball"));
        abilities.add(new Ability("Teleport"));
        List<Equipment> equipment = new ArrayList<>();
        equipment.add(new Equipment("Staff"));
        equipment.add(new Equipment("Robe"));
        Attribute attributes = new Attribute(50, 80, 10);
        return new Character(name, appearance, abilities, equipment, attributes);
    }
}

class ArcherFactory extends CharacterFactory {
    @Override
    public Character createCharacter(String name) {
        Appearance appearance = new Appearance("Archer Appearance");
        List<Ability> abilities = new ArrayList<>();
        abilities.add(new Ability("Shoot"));
        abilities.add(new Ability("Dodge"));
        List<Equipment> equipment = new ArrayList<>();
        equipment.add(new Equipment("Bow"));
        equipment.add(new Equipment("Arrow"));
        Attribute attributes = new Attribute(70, 60, 30);
        return new Character(name, appearance, abilities, equipment, attributes);
    }
}

class Appearance {
    private String appearanceName;

    public Appearance(String appearanceName) {
        this.appearanceName = appearanceName;
    }
    public String getAppearanceName() {
        return appearanceName;
    }


}

class Ability {
    private String abilityName;

    public Ability(String abilityName) {
        this.abilityName = abilityName;
    }


}

class Equipment {
    private String equipmentName;

    public Equipment(String equipmentName) {
        this.equipmentName = equipmentName;
    }
}

class Attribute {
    private int health;
    private int mana;
    private int agility;

    public Attribute(int health, int mana, int agility) {
        this.health = health;
        this.mana = mana;
        this.agility = agility;
    }
}


class CharacterCreator {
    private CharacterFactory factory;

    public void setFactory(CharacterFactory factory) {
        this.factory = factory;
    }

    public Character createCharacter(String name) {
        return factory.createCharacter(name);
    }
}


public class Ex_1 {
    public static void main(String[] args) {
        CharacterCreator creator = new CharacterCreator();


        creator.setFactory(new WarriorFactory());
        Character warrior = creator.createCharacter("Warrior Bob");

       
        creator.setFactory(new MageFactory());
        Character mage = creator.createCharacter("Mage Alice");

       
        creator.setFactory(new ArcherFactory());
        Character archer = creator.createCharacter("Archer Charlie");

        
        System.out.println(warrior.getName() + " - " + warrior.getAppearance().getAppearanceName());
        System.out.println("Abilities: " + warrior.getAbilities());
        System.out.println("Equipment: " + warrior.getEquipment());
        System.out.println("Attributes: " + warrior.getAttributes());

        System.out.println(mage.getName() + " - " + mage.getAppearance().getAppearanceName());
        System.out.println("Abilities: " + mage.getAbilities());
        System.out.println("Equipment: " + mage.getEquipment());
        System.out.println("Attributes: " + mage.getAttributes());

        System.out.println(archer.getName() + " - " + archer.getAppearance().getAppearanceName());
        System.out.println("Abilities: " + archer.getAbilities());
        System.out.println("Equipment: " + archer.getEquipment());
        System.out.println("Attributes: " + archer.getAttributes());
    }
}
