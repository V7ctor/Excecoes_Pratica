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
			System.out.print("Número do Quarto: ");
			int quarto = sc.nextInt();
			System.out.print("Data de Entrada: ");
			Date dataE = sdf.parse(sc.next());
			System.out.print("Data de Saída: ");
			Date dataS = sdf.parse(sc.next());
			
		    Reserva r = new Reserva(quarto, dataE, dataS);
			System.out.println("Reserva: " + r);
					
			System.out.println();
			System.out.print("Entre com a Data de Renovação: ");
			System.out.print("Data de Entrada: ");
			dataE = sdf.parse(sc.next());
			System.out.print("Data de Saída: ");
			dataS = sdf.parse(sc.next());
					
	     	r.AtualizarData(dataE, dataS);
	     
			System.out.println("Reserva: " + r);
		}catch(ParseException p) {
			System.out.println("Formato inválido de Data! Insira o padrão \"DD/MM/AAAA\"");
		}catch (Dominio p){
			System.out.println("Erro ao se realizar inserção de Datas: "+p.getMessage());
		}catch (RuntimeException p){ //Captura todas as possíveis exceções que não nos obriga a tratar.
		    System.out.println("Erro Inesperado!");
		}
			finally {	
		sc.close();
		}
	}

}
