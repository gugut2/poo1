package semana03;
import java.util.Scanner;

public class MaquinaDeBebidas {
	// Atributos
	private String tipo;
	private double preco;
	private int bebidaEscolhida;
	
	//Construtor
	public MaquinaDeBebidas(String tipo, double preco, int bebidaEscolhida) {
		this.tipo = tipo;
		this.preco = preco;
		this.bebidaEscolhida = bebidaEscolhida;
	}
		
	// Método para exibir info da bebida
	public void exibirInformacoes() {
		System.out.println("Voce selecionou: " + this.tipo);
		System.out.println("Custa " + this.preco);
		System.out.println("Ate a proxima!");
	}
	
	// Método para Escolher bebida
	public void escolherBebida() {
		// Inicializando Scanner para input do usuario
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Escolha uma das bebidas abaixo");
		System.out.println("\n-------------");
		System.out.println("1. Refrigerante");
		System.out.println("2. Agua Mineral");
		System.out.println("3. Suco de Laranja");
		System.out.println("4. Cafe");
		
		this.bebidaEscolhida = scanner.nextInt();
		
		// Checagem de casos
		switch(this.bebidaEscolhida) {
			case 1: 
				this.tipo = "Refrigerante";
				this.preco = 3.50;
			break;
			
			case 2: 
				this.tipo = "Agua Mineral";
				this.preco = 2.00;
			break;
			
			case 3: 
				this.tipo = "Suco de Laranja";
				this.preco = 4.00;
			break;
			
			case 4: 
				this.tipo = "Cafe";
				this.preco = 2.50;
			break;
			
			default: System.out.println("Nao existe essa bebida, escolha outra: ");
			this.escolherBebida();
		}
	}
	
	public static void main(String[] args) {
		// Construtor de Bebida
		MaquinaDeBebidas minhaBebida = new MaquinaDeBebidas(null, 0, 0);
		
		// Bem vindo
		System.out.println("Bem vindo a maquina de vendas de bebidas!");
		
		// Escolha uma bebida
		minhaBebida.escolherBebida();
		
		// Exibição de informação
		minhaBebida.exibirInformacoes();	
	}
}

	
