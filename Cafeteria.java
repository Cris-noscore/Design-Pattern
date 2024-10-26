// Classe abstrata base para bebidas 
abstract class Beverage {
    private String description;

    public Beverage(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public abstract double cost(); // Método abstrato para o custo da bebida
}

// Subclasse de bebida HouseBlend
class HouseBlend extends Beverage {
    public HouseBlend() {
        super("House blend");
    }

    @Override
    public double cost() {
        return 2.50; // Custo do House Blend
    }
}

// Subclasse de bebida DarkRoast
class DarkRoast extends Beverage {
    public DarkRoast() {
        super("Dark roast");
    }

    @Override
    public double cost() {
        return 3.00; // Custo do Dark Roast
    }
}

// Classe abstrata para complementos
abstract class AddOn extends Beverage {
    protected Beverage beverage;

    public AddOn(String description, Beverage bev) {
        super(description);
        this.beverage = bev;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", " + super.getDescription(); // Inclui a descrição da bebida original
    }
}

// Subclasse de complemento Milk
class Milk extends AddOn {
    public Milk(Beverage bev) {
        super("Milk", bev);
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.10; // Adicionando custo do leite
    }
}

// Subclasse de complemento Soy
class Soy extends AddOn {
    public Soy(Beverage bev) {
        super("Soy", bev);
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.15; // Adicionando custo da soja
    }
}

// Classe principal para executar o código
public class Main { // Renomeie aqui para Main
    public static void main(String[] args) {
        Beverage beverage = new HouseBlend();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage beverage2 = new DarkRoast();
        beverage2 = new Milk(beverage2); // Adicionando leite ao Dark Roast
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

        Beverage beverage3 = new HouseBlend();
        beverage3 = new Soy(beverage3); // Adicionando soja ao House Blend
        beverage3 = new Milk(beverage3); // Adicionando leite ao House Blend
        System.out.println(beverage3.getDescription() + " $" + beverage3.cost());
    }
}
