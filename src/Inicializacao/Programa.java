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
		
		System.out.print("N�mero do Quarto: ");
		int quarto = sc.nextInt();
		System.out.print("Data de Entrada: ");
		Date dataE = sdf.parse(sc.next());//Com o sc.next() ele ficaria em formato texto, com o parse, a gente converte esse formato
		// para Data (sdf).
		//O m�todo parse pode gerar uma exce��o do tipo ParseException, acrescentado por recomenda��o do compilador junto a classe
		// throws ParseException 
		System.out.print("Data de Sa�da: ");
		Date dataS = sdf.parse(sc.next());
		
		if (!dataS.after(dataE)) { //Se a data de Saida n�o for depois da data de Entrada, ent�o ocasionar� no erro.
			System.out.println("A Data de Saida n�o pode ser inferior � data de Entrada.");
		}else {
			Reserva r = new Reserva(quarto, dataE, dataS);
			System.out.println("Reserva: " + r);
				
		System.out.println();
		System.out.print("Entre com a Data de Renova��o: ");
		System.out.print("Data de Entrada: ");
		dataE = sdf.parse(sc.next());
		System.out.print("Data de Sa�da: ");
		dataS = sdf.parse(sc.next());
		
		Date agora = new Date();//Gera hor�rio atual, segundo o PC
		
		if (dataE.before(agora) || dataS.before(agora)) {//Se a Data de entrada for antes da data atual, ent�o fa�a: 
			System.out.println("As datas de reserva n�o podem ser datas passadas.");
		}else if (!dataS.after(dataE)) { //Se a data de Saida n�o for depois da data de Entrada, ent�o ocasionar� no erro.
			System.out.println("A Data de Saida n�o pode ser inferior � data de Entrada.");
		}else {		
     	r.AtualizarData(dataE, dataS);
		System.out.println("Reserva: " + r);
		}
		}
		sc.close();
	}

}
