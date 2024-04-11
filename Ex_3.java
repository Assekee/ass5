
class Furniture {
    private String name;
    private String style;
    private String material;
    private float price;

    public Furniture(String name, String style, String material, float price) {
        this.name = name;
        this.style = style;
        this.material = material;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getStyle() {
        return style;
    }

    public String getMaterial() {
        return material;
    }

    public float getPrice() {
        return price;
    }
}

abstract class FurnitureFactory {
    public abstract Chair createChair();
    public abstract Table createTable();
    public abstract Sofa createSofa();
}

class ModernWoodFactory extends FurnitureFactory {
    @Override
    public Chair createChair() {
        return new Chair("Modern Chair", "Modern", "Wood", 150.0f);
    }

    @Override
    public Table createTable() {
        return new Table("Modern Table", "Modern", "Wood", 250.0f);
    }

    @Override
    public Sofa createSofa() {
        return new Sofa("Modern Sofa", "Modern", "Wood", 500.0f);
    }
}

class TraditionalMetalFactory extends FurnitureFactory {
    @Override
    public Chair createChair() {
        return new Chair("Traditional Chair", "Traditional", "Metal", 100.0f);
    }

    @Override
    public Table createTable() {
        return new Table("Traditional Table", "Traditional", "Metal", 200.0f);
    }

    @Override
    public Sofa createSofa() {
        return new Sofa("Traditional Sofa", "Traditional", "Metal", 400.0f);
    }
}

class IndustrialGlassFactory extends FurnitureFactory {
    @Override
    public Chair createChair() {
        return new Chair("Industrial Chair", "Industrial", "Glass", 120.0f);
    }

    @Override
    public Table createTable() {
        return new Table("Industrial Table", "Industrial", "Glass", 220.0f);
    }

    @Override
    public Sofa createSofa() {
        return new Sofa("Industrial Sofa", "Industrial", "Glass", 450.0f);
    }
}


class Chair extends Furniture {
    public Chair(String name, String style, String material, float price) {
        super(name, style, material, price);
    }
}

class Table extends Furniture {
    public Table(String name, String style, String material, float price) {
        super(name, style, material, price);
    }
}

class Sofa extends Furniture {
    public Sofa(String name, String style, String material, float price) {
        super(name, style, material, price);
    }
}


class FurnitureCreator {
    private FurnitureFactory factory;

    public void setFactory(FurnitureFactory factory) {
        this.factory = factory;
    }

    public Chair createChair() {
        return factory.createChair();
    }

    public Table createTable() {
        return factory.createTable();
    }

    public Sofa createSofa() {
        return factory.createSofa();
    }
}

public class Ex_3 {
    public static void main(String[] args) {

        FurnitureCreator creator = new FurnitureCreator();


        creator.setFactory(new ModernWoodFactory());
        Chair modernChair = creator.createChair();
        Table modernTable = creator.createTable();
        Sofa modernSofa = creator.createSofa();

        System.out.println("Modern Wood Furniture:");
        System.out.println("Chair: " + modernChair.getName() + ", Price: $" + modernChair.getPrice());
        System.out.println("Table: " + modernTable.getName() + ", Price: $" + modernTable.getPrice());
        System.out.println("Sofa: " + modernSofa.getName() + ", Price: $" + modernSofa.getPrice());


        creator.setFactory(new TraditionalMetalFactory());
        Chair traditionalChair = creator.createChair();
        Table traditionalTable = creator.createTable();
        Sofa traditionalSofa = creator.createSofa();

        System.out.println("\nTraditional Metal Furniture:");
        System.out.println("Chair: " + traditionalChair.getName() + ", Price: $" + traditionalChair.getPrice());
        System.out.println("Table: " + traditionalTable.getName() + ", Price: $" + traditionalTable.getPrice());
        System.out.println("Sofa: " + traditionalSofa.getName() + ", Price: $" + traditionalSofa.getPrice());


        creator.setFactory(new IndustrialGlassFactory());
        Chair industrialChair = creator.createChair();
        Table industrialTable = creator.createTable();
        Sofa industrialSofa = creator.createSofa();

        System.out.println("\nIndustrial Glass Furniture:");
        System.out.println("Chair: " + industrialChair.getName() + ", Price: $" + industrialChair.getPrice());
        System.out.println("Table: " + industrialTable.getName() + ", Price: $" + industrialTable.getPrice());
        System.out.println("Sofa: " + industrialSofa.getName() + ", Price: $" + industrialSofa.getPrice());
    }
}
