package calculadora;

public class Area {

	public static Double areaQuadrado(Double base) {
		return (double) (base * base);
	}
	
	public static Double areaRetangulo(Double base, Double altura) {
		return (double) (base * altura);
	}
	 
	public static Double areaCirculo(Double raio) {
		return Math.PI * raio * raio;
	}
	
	public static Double areaCoroaCircular(Double raioMaior, Double raioMenor) {
		return Math.PI * ((raioMaior * raioMaior) - (raioMenor * raioMenor));
	}
	
	public static Double areaSetorCircular(Double raio, Double anguloEmGraus) {
		return (Math.PI * ( (raio * raio) * anguloEmGraus)) / 360;
	}
	
	public static Double areaSegmentoCircular(Double raio, Double anguloEmGraus) {
		return areaTrianguloSenX(raio, raio, anguloEmGraus) - areaSetorCircular(raio, anguloEmGraus);
	}
	
	//---------- Triangulos ----------
	
	public static Double areaTrianguloRetangulo(Double base, Double altura) {
		return (double) ((base*altura)/2);
	}
	
	public static Double areaTrianguloQualquer(Double lado1, Double lado2, Double lado3) {
		Double p = somaSemiperimetro(lado1, lado2, lado3);
		return Math.sqrt(p * ((p - lado1) * (p - lado2) * (p - lado3)));
	}
	
	public static Double areaTrianguloEquilatero(Double lado) {
		return ((lado*lado) * Math.sqrt(3)) / 4;
	}
	
	public static Double alturaTrianguloRetangulo(Double lado) {
		return (lado * Math.sqrt(3))/2;
	}

	public static Double somaSemiperimetro(Double lado1, Double lado2, Double lado3) {
		return (lado1 + lado2 + lado3)/2;
	}
	
	public static Double areaTrianguloSenX(Double cateto1, Double cateto2, Double anguloEmGraus) {
		return ((cateto1 * cateto2)*Math.sin(anguloEmGraus))/2;
	}
	
	
	//---------- x ----------

	public static Double areaParalelogramo(Double base, Double altura) {
		return base * altura;
	}
	
	public static Double areaLosango(Double diametroMaior, Double diametroMenor) {
		return (diametroMaior * diametroMenor)/2;
	}
	
	public static Double areaTrapezio(Double baseMenor, Double baseMaior, Double altura) {
		return (baseMaior + baseMenor) * altura / 2;
	}
	
	
}
