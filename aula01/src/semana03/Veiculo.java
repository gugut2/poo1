package semana03;

public class Veiculo {
	// Atributos
	private String marca;
	private String modelo;
	private int ano;
	private String cor;
	private double preco;
	private boolean ligado;
	
	// Construtor
	public Veiculo(String marca, String modelo, int ano, String cor, double preco) {
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.cor = cor;
		this.preco = preco;
	}
	
	// Método para exibir informações sobre o veículo
	public void exibirInformacoes() {
		System.out.println("\n-------------");
		System.out.println("Marca: " + marca);
		System.out.println("Modelo: " + modelo);
		System.out.println("Ano: " + ano);
		System.out.println("Cor: " + cor);
		System.out.println("Preço: " + preco);
		System.out.println("Ligado: " + ligado);
		System.out.println("\n-------------");
	}
	
	// Ligar veículo
	public void ligar() {
		this.ligado = true;
		System.out.println("O veículo está ligado.");
	}
	
	// Desliga veículo
	public void desligar() {
		this.ligado = false;
		System.out.println("O veículo está desligado.");
	}
	
	public static void main(String[] args) {
		// Exemplo de uso de classe Veiculo
		Veiculo meuCarro = new Veiculo("Toyota", "Corolla", 2022, "Prata", 75000.0);
		meuCarro.exibirInformacoes();
		meuCarro.ligar();
		meuCarro.exibirInformacoes();
		meuCarro.desligar();
		meuCarro.exibirInformacoes();
	}
}
