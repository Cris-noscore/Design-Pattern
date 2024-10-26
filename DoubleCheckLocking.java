class DoubleCheckedLockingSingleton {
    // A instância é declarada como volatile para garantir visibilidade correta entre threads
    private static volatile DoubleCheckedLockingSingleton instance;

    // Construtor privado para evitar criação de novas instâncias
    private DoubleCheckedLockingSingleton() { }

    // Método que retorna a instância, com verificação dupla para evitar problemas de performance
    public static DoubleCheckedLockingSingleton getInstance() {
        if (instance == null) {  // Primeira verificação
            synchronized (DoubleCheckedLockingSingleton.class) {
                if (instance == null) {  // Segunda verificação dentro do bloco synchronized
                    instance = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return instance;
    }
}

public class Main {
    public static void main(String[] args) {
        // Criando múltiplas threads que vão acessar o singleton
        Runnable task = () -> {
            DoubleCheckedLockingSingleton instance = DoubleCheckedLockingSingleton.getInstance();
            System.out.println("Instância obtida: " + instance);
        };

        // Criar várias threads
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);
        Thread thread4 = new Thread(task);
        
        // Iniciar as threads
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        // Esperar todas as threads terminarem
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Todas as threads terminaram!");
    }
}
