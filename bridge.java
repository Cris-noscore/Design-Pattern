// Implementação
interface DrawAPI {
    public void desenharCirculo(int raio, int x, int y);
}

// Implementações concretas
class DesenharVermelho implements DrawAPI {
    public void desenharCirculo(int raio, int x, int y) {
        System.out.println("Desenhando círculo[ cor: vermelho, raio: " + raio + ", x: " + x + ", y: " + y + "]");
    }
}

class DesenharVerde implements DrawAPI {
    public void desenharCirculo(int raio, int x, int y) {
        System.out.println("Desenhando círculo[ cor: verde, raio: " + raio + ", x: " + x + ", y: " + y + "]");
    }
}

// Abstração
abstract class Forma {
    protected DrawAPI drawAPI;
    
    protected Forma(DrawAPI drawAPI){
        this.drawAPI = drawAPI;
    }
    
    public abstract void desenhar();
}

// Abstração refinada
class Circulo extends Forma {
    private int x, y, raio;

    public Circulo(int x, int y, int raio, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.raio = raio;
    }

    public void desenhar() {
        drawAPI.desenharCirculo(raio, x, y);
    }
}

// Classe de demonstração
public class Main {
    public static void main(String[] args) {
        Forma circuloVermelho = new Circulo(100, 100, 10, new DesenharVermelho());
        Forma circuloVerde = new Circulo(200, 200, 20, new DesenharVerde());

        circuloVermelho.desenhar();
        circuloVerde.desenhar();
    }
}