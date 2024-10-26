public class Main {
    
    // Interface Command
    interface Command {
        void execute();
    }

    // Classe que implementa o Command
    static class Light {
        public void turnOn() {
            System.out.println("A luz está ligada.");
        }

        public void turnOff() {
            System.out.println("A luz está desligada.");
        }
    }

    // Comando para ligar a luz
    static class TurnOnLightCommand implements Command {
        private Light light;

        public TurnOnLightCommand(Light light) {
            this.light = light;
        }

        @Override
        public void execute() {
            light.turnOn();
        }
    }

    // Comando para desligar a luz
    static class TurnOffLightCommand implements Command {
        private Light light;

        public TurnOffLightCommand(Light light) {
            this.light = light;
        }

        @Override
        public void execute() {
            light.turnOff();
        }
    }

    // Invoker que irá usar os comandos
    static class RemoteControl {
        private Command command;

        public void setCommand(Command command) {
            this.command = command;
        }

        public void pressButton() {
            command.execute();
        }
    }

    // Método principal
    public static void main(String[] args) {
        Light light = new Light();
        Command turnOn = new TurnOnLightCommand(light);
        Command turnOff = new TurnOffLightCommand(light);

        RemoteControl remote = new RemoteControl();

        // Ligando a luz
        remote.setCommand(turnOn);
        remote.pressButton();

        // Desligando a luz
        remote.setCommand(turnOff);
        remote.pressButton();
    }
}

