package aula13;

public class funExept {
	public static float divisaoSegura(int a , int b) {
		float c = 0;
			try {
				c = a / b;
			}
			catch (ArithmeticException e) {
				System.out.print("Divisão por zero não é permitida!");
				return 0;
			}
		return c;
	}
	public static boolean verificar(int a) throws INE {
		if (a<0) {
			throw new INE("A idade não pode ser negativa"); 
		}
		return a > 18 ? true : false;
	}
	public static int convToint(String talk) {
		int num = 0;
		try{
            int nu = Integer.parseInt(talk);
            num = nu;
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        } 	
		return num;
	}
	
}
