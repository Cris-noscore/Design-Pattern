class LazySingleton {
    // Inicializa a instância como null.
    private static LazySingleton instance = null;
    
    // Construtor privado, para que não possa ser instanciada fora
    private LazySingleton() { }
    
    // Verifica se a instância é null. Se estiver, o objeto é criado.
    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton(); // Cria a instância se ainda não existir
        }
        return instance; // Retorna a instância existente
    }
}

public class Main {
    public static void main(String[] args) {
        LazySingleton singleton1 = LazySingleton.getInstance();
        LazySingleton singleton2 = LazySingleton.getInstance();
        
        if (singleton1 == singleton2) {
            System.out.println("As duas variáveis referenciam a mesma instância.");
        } else {
            System.out.println("As duas variáveis referenciam instâncias diferentes.");
        }
        
        System.out.println("Endereço de memória de singleton1: " + System.identityHashCode(singleton1));
        System.out.println("Endereço de memória de singleton2: " + System.identityHashCode(singleton2));
    }
}


