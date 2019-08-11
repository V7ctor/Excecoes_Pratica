package Excecoes;

public class Dominio extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public Dominio (String mensagem) {
		super(mensagem);//Com super repassamos o argumento do construtor para a SuperClasse.
		//Isso deve ser colocado pois queremos instanciar a classe dominio passando argumento para ela e consequentivamente para a
		//Superclasse
	}
}
