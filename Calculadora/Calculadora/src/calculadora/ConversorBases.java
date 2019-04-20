package calculadora;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ConversorBases {
	
	/***Conversor de bases***/
	
	//----------------Binary --> Other---------------//
	public static String converterBinToDec(String numeroBinario) {
		Integer resultado = 0;
		Integer contador = 0;
		for (int i = numeroBinario.length() - 1; i >= 0 ; i--) {
			resultado += Integer.parseInt((numeroBinario.charAt(i) + "")) * ((int)Math.pow(2, contador));
			contador++;
		}
		return resultado.toString();
	}
	
	public static String converterBinToOctal(String numeroBinario) {
		StringBuffer numeroOctal = new StringBuffer();
		String numeroValidado = validacaoNumeroOctal(numeroBinario);
		int j = 3, k = 0;

		for(int i = 0; i < numeroValidado.length() ; i++) {
			if(j <= numeroValidado.length()) {
				numeroOctal.append(trocaBinOct(numeroValidado.substring(k, j)));
			}
			k = j;
			j += 3;
		}
		
		return numeroOctal.toString();
	}
	
	public static String converterBinToHex(String numeroBinario) {
		StringBuffer numeroHexadecimal = new StringBuffer();
		String numeroValidado = validacaoNumeroHexadecimal(numeroBinario);
		int j = 4, k = 0;
		
		for (int i = 0; i < numeroValidado.length(); i++) {
			if(j <= numeroValidado.length()) {
				numeroHexadecimal.append(trocaBinHex(numeroValidado.substring(k, j)));
			}
			k=j;
			j += 4;
		}
		return numeroHexadecimal.toString();
	}
	
	private static String trocaBinOct(String numeroBinario) {
		List<String> listaBin = Arrays.asList("000", "001", "010", "011", "100", "101", "110", "111");
		List<String> listOct = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7");
		
		if(listaBin.contains(numeroBinario)) {
			return listOct.get(listaBin.indexOf(numeroBinario));
		}
		return "";
	}
	
	private static String trocaBinHex(String numeroBinario) {
		List<String> listaBin = Arrays.asList("0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111");
		List<String> listaHexa = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F");
		
		if(listaBin.contains(numeroBinario)) {
			return listaHexa.get(listaBin.indexOf(numeroBinario));
		}
		return "";
	}
	
	private static String validacaoNumeroOctal(String numeroBinario) {
		StringBuffer numeroValidado = new StringBuffer();
		
		while(numeroBinario.length() % 3 != 0) {
			numeroValidado.append("0");
			if((numeroValidado.toString().length() + numeroBinario.length()) % 3 == 0) {
				return numeroValidado.append(numeroBinario).toString();
			}
		}
		return numeroBinario;
	}
	
	private static String validacaoNumeroHexadecimal(String numeroBinario) {
		StringBuffer numeroValidado = new StringBuffer();
		
		while(numeroBinario.length() % 4 != 0) {
			numeroValidado.append("0");
			if((numeroValidado.toString().length() + numeroBinario.toString().length()) % 4 == 0) {
				return numeroValidado.append(numeroBinario).toString();
			}
		}
		return numeroBinario;
	}
	
	//----------------Decimal --> Other---------------//
	
	public static String converterDecToBin(Integer numeroDecimal) {
		Integer resto = 0;
		StringBuffer numeroBinario = new StringBuffer();
		
		while (numeroDecimal > 1) {
			resto = numeroDecimal % 2;
			numeroBinario.append(resto);
			numeroDecimal /= 2;
		}
		numeroBinario.append(numeroDecimal);
		return numeroBinario.reverse().toString();
	}
	
	public static String converterDecToOctal(Integer numeroDecimal){
		Integer resto = 0;
		StringBuffer numeroBinario = new StringBuffer();
		
		while (numeroDecimal > 8) {
			resto = numeroDecimal % 8;
			numeroBinario.append(resto);
			numeroDecimal /= 8;
		}
		
		numeroBinario.append(numeroDecimal);
		return numeroBinario.reverse().toString();
	}
	
	public static String converterDecToHex(Integer numeroDecimal) {
		Integer resto = 0;
		StringBuffer numeroBinario = new StringBuffer();
		
		if(numeroDecimal >= 16) {
			while (numeroDecimal > 16) {
				resto = numeroDecimal % 16;
				if(resto > 9) {
					numeroBinario.append(trocaLetrasDecimalHexa(resto));
				} else {
					numeroBinario.append(resto);
				}
				numeroDecimal /= 16;
			}
		} else {
			numeroBinario.append(trocaLetrasDecimalHexa(numeroDecimal));
			return numeroBinario.reverse().toString();
		}

		numeroBinario.append(numeroDecimal);
		return numeroBinario.reverse().toString();		
	}
	
	private static String trocaLetrasDecimalHexa(Integer numeroDecimal) {
		
		if(numeroDecimal == 10) {
			return "A";
		} else if (numeroDecimal == 11) {
			return "B";
		} else if (numeroDecimal == 12) {
			return "C";
		} else if (numeroDecimal == 13) {
			return "D";
		} else if (numeroDecimal == 14) {
			return "E";
		} else if (numeroDecimal == 15) {
			return "F";
		}
		return Integer.toString(numeroDecimal);
	}
	
	
	//----------------Octal --> Other---------------//
	
	public static String converterOctalToDec(String numeroOctal) {
		Integer resultado = 0;
		Integer contador = 0;
		for (int i = numeroOctal.length() - 1; i >= 0 ; i--) {
			resultado += Integer.parseInt((numeroOctal.charAt(i) + "")) * ((int)Math.pow(8, contador));
			contador++;
		}
		return resultado.toString();
	}
	
	public static String converterOctalToBin(String numeroOctal) {
		StringBuffer numeroBinario = new StringBuffer();
		
		for(int i = 0; i < numeroOctal.length(); i++) {
			if(validaNumeroOctal(Character.toString(numeroOctal.charAt(i)))) {
				numeroBinario.append(trocaOctalBin(Character.toString(numeroOctal.charAt(i))));
			}
		}
		return numeroBinario.toString();
	}
	
	public static String converterOctalToHex(String numeroOctal) {
		//Para converter de octal para hexa, devemos converter o numero  octal para binario, depois reagrupar de 4 em 4 bits e converter isso em hexa.
		return	converterBinToHex(converterOctalToBin(numeroOctal));
	}
	
	private static Boolean validaNumeroOctal(String numeroOctal) {
		
		if(Integer.parseInt(numeroOctal) > 7 || Integer.parseInt(numeroOctal) < 0) {
			return false;
		}
		return true;
	}
	
	private static String trocaOctalBin(String numeroOctal) {
		List<String> listaBin = Arrays.asList("000", "001", "010", "011", "100", "101", "110", "111");
		List<String> listOct = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7");
		
		if(listOct.contains(numeroOctal)) {
			return listaBin.get(listOct.indexOf(numeroOctal));
		}
		return "";
	}
	
	
	//----------------Hexadecimal --> Other---------------//
	
	public static String converterHexToBin(String numeroHexadecimal) {
		//Para converter hexadecimal em Binário, trocamos as letras, se houverem, por números e esses números diretamente em binário, concatenado em uma string.
		StringBuffer numeroBinario = new StringBuffer();
		
		for(int i = 0; i < numeroHexadecimal.length(); i++) {
			numeroBinario.append(trocaHexBin(Character.toString(numeroHexadecimal.charAt(i))));
		}
		
		return numeroBinario.toString();
	}
	
	public static String converterHexToOctal(String numeroHexadecimal) {
		//Para converter o numero hexadecimal em octal, devemos converter o o hexadecimal em binario e reagrupar os bits de 3 em 3, depois convertemos os bits para octal
		return converterBinToOctal(converterHexToBin(numeroHexadecimal));

	}
	
	public static String converterHexToDec(String numeroHexadecimal) {
		//Para converter hexa em decimal, devemos multiplicar o valor do hexadecimal por 16 elevado a potência de sua posição.
		Double numeroDecimal = 0.0;
		int j=0;
		for(int i=numeroHexadecimal.length(); i > 0; i--) {
			numeroDecimal += Integer.parseInt(trocaLetraHexDec(Character.toString(numeroHexadecimal.charAt(j)))) * Math.pow(16, j);
			j++;
		}
		return numeroDecimal.toString();
	}
	
	private static String trocaHexBin(String numeroHexadecimal) {
		List<String> listaBin = Arrays.asList("0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111");
		List<String> listaHex = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E");
		
		if(listaHex.contains(numeroHexadecimal.toUpperCase())) {
			return listaBin.get(listaHex.indexOf(numeroHexadecimal));
		}
		return numeroHexadecimal;
	}
	
	private static String trocaLetraHexDec(String numeroHexadecimal) {
		List<String> listaHex = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E");
		List<String> listaDec = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15");
	
		if(listaHex.contains(numeroHexadecimal.toUpperCase())) {
			return listaDec.get(listaHex.indexOf(numeroHexadecimal));
		}
		return "";
	}
}
