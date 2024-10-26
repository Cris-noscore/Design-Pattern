class ThreadSafeSingleton {
    // Inicializa a instância como null.
    private static volatile ThreadSafeSingleton instance = null;
    
    // Construtor privado, para que não possa ser instanciada fora 
    private ThreadSafeSingleton() { }
    
    // Verifica se a instância é null dentro de um bloco synchronized.
    public static ThreadSafeSingleton getInstance() {
        if (instance == null) { // Primeiro teste (sem bloqueio)
            synchronized (ThreadSafeSingleton.class) { // Bloco sincronizado
                if (instance == null) { // Segundo teste (com bloqueio)
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance; // Retorna a instância
    }
}

public class Main {
    public static void main(String[] args) {
        ThreadSafeSingleton singleton1 = ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton singleton2 = ThreadSafeSingleton.getInstance();
        
        if (singleton1 == singleton2) {
            System.out.println("As duas variáveis referenciam a mesma instância.");
        } else {
            System.out.println("As duas variáveis referenciam instâncias diferentes.");
        }
        
        System.out.println("Endereço de memória de singleton1: " + System.identityHashCode(singleton1));
        System.out.println("Endereço de memória de singleton2: " + System.identityHashCode(singleton2));
    }
}
