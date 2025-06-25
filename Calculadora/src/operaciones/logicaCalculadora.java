package operaciones;

public class logicaCalculadora {
    
	public static double  sumar(double num1, double num2) {
		return num1  + num2;
	}
	public static double restar(double num1, double num2) {
		return num1 - num2;
	}
	public static double multiplicar(double num1, double num2) {
		return num1 * num2;
	}
	public static double dividir(double num1, double num2) {
		return num1 / num2;
	}
	public static double potencia(double num1, double num2) {
		return Math.pow(num2, num1);
	}
	public static double raiz(double num1, double num2){
		if(num1 == 0) {
			return 0;
		}
		return Math.pow(num2, 1.0/num1);
	}
	
}
