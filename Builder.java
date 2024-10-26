// Produto
class Computer {
    private String CPU;
    private String RAM;
    private String storage;
    private String GPU;
    private String operatingSystem;

    public void setCPU(String CPU) { this.CPU = CPU; }
    public void setRAM(String RAM) { this.RAM = RAM; }
    public void setStorage(String storage) { this.storage = storage; }
    public void setGPU(String GPU) { this.GPU = GPU; }
    public void setOperatingSystem(String operatingSystem) { this.operatingSystem = operatingSystem; }

    @Override
    public String toString() {
        return "Computer{" +
                "CPU='" + CPU + '\'' +
                ", RAM='" + RAM + '\'' +
                ", storage='" + storage + '\'' +
                ", GPU='" + GPU + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                '}';
    }
}

// Interface Builder
interface ComputerBuilder {
    void buildCPU(String CPU);
    void buildRAM(String RAM);
    void buildStorage(String storage);
    void buildGPU(String GPU);
    void buildOperatingSystem(String operatingSystem);
    Computer getResult();
}

// Concrete Builder
class DesktopComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public DesktopComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildCPU(String CPU) {
        computer.setCPU(CPU);
    }

    @Override
    public void buildRAM(String RAM) {
        computer.setRAM(RAM);
    }

    @Override
    public void buildStorage(String storage) {
        computer.setStorage(storage);
    }

    @Override
    public void buildGPU(String GPU) {
        computer.setGPU(GPU);
    }

    @Override
    public void buildOperatingSystem(String operatingSystem) {
        computer.setOperatingSystem(operatingSystem);
    }

    @Override
    public Computer getResult() {
        return computer;
    }
}

// Director
class ComputerDirector {
    private ComputerBuilder builder;

    public ComputerDirector(ComputerBuilder builder) {
        this.builder = builder;
    }

    public void constructGamingPC() {
        builder.buildCPU("Intel i9");
        builder.buildRAM("32GB DDR4");
        builder.buildStorage("1TB SSD");
        builder.buildGPU("NVIDIA RTX 3080");
        builder.buildOperatingSystem("Windows 10");
    }

    public void constructOfficePC() {
        builder.buildCPU("Intel i5");
        builder.buildRAM("16GB DDR4");
        builder.buildStorage("512GB SSD");
        builder.buildGPU("Integrated Graphics");
        builder.buildOperatingSystem("Windows 11");
    }
}

// Classe principal para demonstração
public class Main {
    public static void main(String[] args) {
        ComputerBuilder builder = new DesktopComputerBuilder();
        ComputerDirector director = new ComputerDirector(builder);

        System.out.println("Construindo um PC Gamer:");
        director.constructGamingPC();
        Computer gamingPC = builder.getResult();
        System.out.println(gamingPC);

        System.out.println("\nConstruindo um PC de Escritório:");
        director.constructOfficePC();
        Computer officePC = builder.getResult();
        System.out.println(officePC);
    }
}
