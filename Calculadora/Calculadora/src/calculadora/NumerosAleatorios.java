package calculadora;

import java.util.Random;

public class NumerosAleatorios {
	
	//Gerador de números aleatórios
	
	public static int numeroAleatorioZeroDez() {
		Random r = new Random();
		return r.nextInt(11);
	}
	
	public static int numeroAleatorioZeroCem() {
		Random r = new Random();
		return r.nextInt(101);
	}
	
	public static int numeroAleatorioZeroMil() {
		Random r = new Random();
		return r.nextInt(1001);
	}
}
