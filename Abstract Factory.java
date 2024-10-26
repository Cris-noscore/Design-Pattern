// Interfaces para produtos abstratos
interface Button {
    void render();
}

interface Checkbox {
    void render();
}

// Produtos concretos para Windows
class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Renderizando um botão do Windows");
    }
}

class WindowsCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Renderizando uma checkbox do Windows");
    }
}

// Produtos concretos para macOS
class MacOSButton implements Button {
    @Override
    public void render() {
        System.out.println("Renderizando um botão do macOS");
    }
}

class MacOSCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Renderizando uma checkbox do macOS");
    }
}

// Abstract Factory
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// Fábricas concretas
class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
    
    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

class MacOSFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }
    
    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}

// Classe principal para demonstrar o uso
public class Main {
    public static GUIFactory createFactoryForOS(String os) {
        if ("Windows".equalsIgnoreCase(os)) {
            return new WindowsFactory();
        } else if ("macOS".equalsIgnoreCase(os)) {
            return new MacOSFactory();
        }
        throw new IllegalArgumentException("Sistema operacional não suportado");
    }
    
    public static void main(String[] args) {
        String os = "Windows";  // Você pode mudar para "macOS" para testar
        
        try {
            GUIFactory factory = createFactoryForOS(os);
            
            Button button = factory.createButton();
            Checkbox checkbox = factory.createCheckbox();
            
            System.out.println("Criando interface para " + os + ":");
            button.render();
            checkbox.render();
        } catch (IllegalArgumentException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}

