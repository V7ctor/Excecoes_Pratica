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
		
		Date agora = new Date();//Gera horário atual, segundo o PC
		
		if (dataE.before(agora) || dataS.before(agora)) {//Se a Data de entrada for antes da data atual, então faça: 
			System.out.println("As datas de reserva não podem ser datas passadas.");
		}else if (!dataS.after(dataE)) { //Se a data de Saida não for depois da data de Entrada, então ocasionará no erro.
			System.out.println("A Data de Saida não pode ser inferior à data de Entrada.");
		}else {		
     	r.AtualizarData(dataE, dataS);
		System.out.println("Reserva: " + r);
		}
		}
		sc.close();
	}

}
