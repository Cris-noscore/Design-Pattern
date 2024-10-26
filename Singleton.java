class EagerSingleton {
    
    // Cria uma única instância da classe de forma imediata (Eager)
    private static final EagerSingleton instance = new EagerSingleton();
    
    // Construtor privado para evitar instanciamento externo
    private EagerSingleton() { }
    
    // Retorna a única instância criada do objeto
    public static EagerSingleton getInstance() {
        return instance;
    }
}

public class Main {
    public static void main(String[] args) {
        // Obtendo a instância do Singleton
        EagerSingleton singleton1 = EagerSingleton.getInstance();
        EagerSingleton singleton2 = EagerSingleton.getInstance();
        
        // Verificando se ambas as instâncias são iguais
        if (singleton1 == singleton2) {
            System.out.println("As duas variáveis referenciam a mesma instância.");
        } else {
            System.out.println("As duas variáveis referenciam instâncias diferentes.");
        }
        
        // Exibindo os endereços de memória das instâncias
        System.out.println("Endereço de memória de singleton1: " + System.identityHashCode(singleton1));
        System.out.println("Endereço de memória de singleton2: " + System.identityHashCode(singleton2));
    }
}

