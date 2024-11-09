import java.util.ArrayList;
import java.util.List;

// Component
interface Empregado {
    void mostrarDetalhes();
    double calcularSalario();
}

// Leaf
class Desenvolvedor implements Empregado {
    private String nome;
    private double salario;

    public Desenvolvedor(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public void mostrarDetalhes() {
        System.out.println("Desenvolvedor: " + nome + ", Salário: R$" + salario);
    }

    public double calcularSalario() {
        return salario;
    }
}

// Leaf
class Designer implements Empregado {
    private String nome;
    private double salario;

    public Designer(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public void mostrarDetalhes() {
        System.out.println("Designer: " + nome + ", Salário: R$" + salario);
    }

    public double calcularSalario() {
        return salario;
    }
}

// Composite
class Gerente implements Empregado {
    private String nome;
    private double salario;
    private List<Empregado> subordinados = new ArrayList<>();

    public Gerente(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public void adicionarSubordinado(Empregado empregado) {
        subordinados.add(empregado);
    }

    public void mostrarDetalhes() {
        System.out.println("Gerente: " + nome + ", Salário: R$" + salario);
        System.out.println("Subordinados de " + nome + ":");
        for (Empregado empregado : subordinados) {
            empregado.mostrarDetalhes();
        }
    }

    public double calcularSalario() {
        double salarioTotal = salario;
        for (Empregado empregado : subordinados) {
            salarioTotal += empregado.calcularSalario();
        }
        return salarioTotal;
    }
}

// Classe principal para testar o código
public class Main {
    public static void main(String[] args) {
        Desenvolvedor dev1 = new Desenvolvedor("João", 5000);
        Desenvolvedor dev2 = new Desenvolvedor("Maria", 5500);
        Designer designer1 = new Designer("Carlos", 4500);

        Gerente gerenteProjeto = new Gerente("Ana", 10000);
        gerenteProjeto.adicionarSubordinado(dev1);
        gerenteProjeto.adicionarSubordinado(dev2);
        gerenteProjeto.adicionarSubordinado(designer1);

        Gerente gerenteGeral = new Gerente("Pedro", 15000);
        gerenteGeral.adicionarSubordinado(gerenteProjeto);

        System.out.println("Estrutura organizacional:");
        gerenteGeral.mostrarDetalhes();

        System.out.println("\nSalário total da equipe: R$" + gerenteGeral.calcularSalario());
    }
}
