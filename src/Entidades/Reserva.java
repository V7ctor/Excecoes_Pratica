package Entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import Excecoes.Dominio;

public class Reserva {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	//Colocamos o static para que não seja instânciado diferente em cada objeto, teremos apenas 1. 
	private Integer NumeroQuarto;
	private Date DataEntrada;
	private Date DataSaida;

	public Reserva(Integer numeroQuarto, Date dataEntrada, Date dataSaida) throws Dominio {
	    if (!dataSaida.after(dataEntrada)) { //Tratamos o erro no próprio construtor na primeira inserção de Datas.
		     throw new Dominio("A Data de Saida não pode ser inferior à data de Entrada.");
	    }
		NumeroQuarto = numeroQuarto;
		DataEntrada = dataEntrada;
		DataSaida = dataSaida;
	}

	public Integer getNumeroQuarto() {
		return NumeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		NumeroQuarto = numeroQuarto;
	}

	public Date getDataEntrada() {
		return DataEntrada;
	}

	public Date getDataSaida() {
		return DataSaida;
	}

	public long Duracao() {
		long CalculoMili = DataEntrada.getTime() - DataSaida.getTime();
		//Vai me retornar aqui a quantidade de milissegundos desde a data de entrada e subtrair com a diferença desde a Data de Saida
		//Com isso eu obtenho a diferença de milissegundos no intervalo dessas duas datas.
		return TimeUnit.DAYS.convert(CalculoMili, TimeUnit.MILLISECONDS);
		//Agora pegamos a classe enumerada TimeUnit que possui certas operações e convertemos para dias os milissegundos do 
		// CalculoMili, a classe TimeUnit irá fazer a operação automaticamente para nós. 
	}
	
	public void AtualizarData(Date entrada, Date saida) throws Dominio{
		Date agora = new Date();
		if (entrada.before(agora) || saida.before(agora)) { 
			throw new Dominio("As datas de reserva não podem ser datas passadas.");
			//A exceção "IllegalArgumentException" serve justamente quando os argumentos que passamos são inválidos
			//Sempre que usarmos os argumentos inválidos, cabe-se ás exceções do tipo IllegalArgumentException.
		}if (!saida.after(entrada)) { 
			throw new Dominio("A Data de Saida não pode ser inferior à data de Entrada.");
		}
		this.DataEntrada = entrada;
		this.DataSaida = saida;
	}

	@Override
	public String toString() {
		return "NumeroQuarto=" + NumeroQuarto + ", DataEntrada=" + sdf.format(DataEntrada) + ", DataSaida=" + sdf.format(DataSaida)
				+ Duracao() + "Noites.";
	}
	
	
}
