// Command Interface
interface Command {
    void execute();
}

// Receiver
class Light {
    public void turnOn() {
        System.out.println("A luz está acesa");
    }
    
    public void turnOff() {
        System.out.println("A luz está apagada");
    }
}

// Concrete Commands
class TurnOnLightCommand implements Command {
    private Light light;
    
    public TurnOnLightCommand(Light light) {
        this.light = light;
    }
    
    @Override
    public void execute() {
        light.turnOn();
    }
}

class TurnOffLightCommand implements Command {
    private Light light;
    
    public TurnOffLightCommand(Light light) {
        this.light = light;
    }
    
    @Override
    public void execute() {
        light.turnOff();
    }
}

// Invoker
class RemoteControl {
    private Command command;
    
    public void setCommand(Command command) {
        this.command = command;
    }
    
    public void pressButton() {
        command.execute();
    }
}

// Client
public class Main {
    public static void main(String[] args) {
        Light light = new Light();
        Command turnOn = new TurnOnLightCommand(light);
        Command turnOff = new TurnOffLightCommand(light);
        
        RemoteControl remote = new RemoteControl();
        
        remote.setCommand(turnOn);
        remote.pressButton();
        
        remote.setCommand(turnOff);
        remote.pressButton();
    }
}
