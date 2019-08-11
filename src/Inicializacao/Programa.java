package Inicializacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Entidades.Reserva;
import Excecoes.Dominio;

public class Programa {

	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		try{
			System.out.print("N�mero do Quarto: ");
			int quarto = sc.nextInt();
			System.out.print("Data de Entrada: ");
			Date dataE = sdf.parse(sc.next());
			System.out.print("Data de Sa�da: ");
			Date dataS = sdf.parse(sc.next());
			
		    Reserva r = new Reserva(quarto, dataE, dataS);
			System.out.println("Reserva: " + r);
					
			System.out.println();
			System.out.print("Entre com a Data de Renova��o: ");
			System.out.print("Data de Entrada: ");
			dataE = sdf.parse(sc.next());
			System.out.print("Data de Sa�da: ");
			dataS = sdf.parse(sc.next());
					
	     	r.AtualizarData(dataE, dataS);
	     
			System.out.println("Reserva: " + r);
		}catch(ParseException p) {
			System.out.println("Formato inv�lido de Data! Insira o padr�o \"DD/MM/AAAA\"");
		}catch (Dominio p){
			System.out.println("Erro ao se realizar inser��o de Datas: "+p.getMessage());
		}catch (RuntimeException p){ //Captura todas as poss�veis exce��es que n�o nos obriga a tratar.
		    System.out.println("Erro Inesperado!");
		}
			finally {	
		sc.close();
		}
	}

}
