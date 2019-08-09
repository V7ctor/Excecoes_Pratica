package Entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	//Colocamos o static para que n�o seja inst�nciado diferente em cada objeto, teremos apenas 1. 
	private Integer NumeroQuarto;
	private Date DataEntrada;
	private Date DataSaida;

	public Reserva(Integer numeroQuarto, Date dataEntrada, Date dataSaida) {
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
		//Vai me retornar aqui a quantidade de milissegundos desde a data de entrada e subtrair com a diferen�a desde a Data de Saida
		//Com isso eu obtenho a diferen�a de milissegundos no intervalo dessas duas datas.
		return TimeUnit.DAYS.convert(CalculoMili, TimeUnit.MILLISECONDS);
		//Agora pegamos a classe enumerada TimeUnit que possui certas opera��es e convertemos para dias os milissegundos do 
		// CalculoMili, a classe TimeUnit ir� fazer a opera��o automaticamente para n�s. 
	}
	
	public void AtualizarData(Date entrada, Date saida) {
		this.DataEntrada = entrada;
		this.DataSaida = saida;
	}

	@Override
	public String toString() {
		return "NumeroQuarto=" + NumeroQuarto + ", DataEntrada=" + sdf.format(DataEntrada) + ", DataSaida=" + sdf.format(DataSaida)
				+ Duracao() + "Noites.";
	}
	
	
}
