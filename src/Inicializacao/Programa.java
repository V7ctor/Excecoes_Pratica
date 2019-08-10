package Inicializacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Entidades.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Número do Quarto: ");
		int quarto = sc.nextInt();
		System.out.print("Data de Entrada: ");
		Date dataE = sdf.parse(sc.next());//Com o sc.next() ele ficaria em formato texto, com o parse, a gente converte esse formato
		// para Data (sdf).
		//O método parse pode gerar uma exceção do tipo ParseException, acrescentado por recomendação do compilador junto a classe
		// throws ParseException 
		System.out.print("Data de Saída: ");
		Date dataS = sdf.parse(sc.next());
		
		if (!dataS.after(dataE)) { //Se a data de Saida não for depois da data de Entrada, então ocasionará no erro.
			System.out.println("A Data de Saida não pode ser inferior à data de Entrada.");
		}else {
			Reserva r = new Reserva(quarto, dataE, dataS);
			System.out.println("Reserva: " + r);
				
		System.out.println();
		System.out.print("Entre com a Data de Renovação: ");
		System.out.print("Data de Entrada: ");
		dataE = sdf.parse(sc.next());
		System.out.print("Data de Saída: ");
		dataS = sdf.parse(sc.next());
				
     	String erro = r.AtualizarData(dataE, dataS);
     	
     	if (erro != null) {
     	System.out.println("Erro na reserva: "+ erro);
     	}else {
		System.out.println("Reserva: " + r);
     	}
		}
		sc.close();
	}

}
