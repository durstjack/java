
public class NombresRomains {

	public static void main(String[] args) {
		
		System.out.println("158 en chiffre romains : " + chiffreRomain(158));
		System.out.println("666 en chiffre romains : " + chiffreRomain(666));

		System.out.println("99 en chiffre romains : " + chiffreRomain(999));
		System.out.println("888 en chiffre romains : " + chiffreRomain(888));
		System.out.println("4 en chiffre romains : " + chiffreRomain(4));
		System.out.println("8 en chiffre romains : " + chiffreRomain(8));
		
		System.out.println("1982 en chiffre romains : " + chiffreRomain(1982));
		System.out.println("1980 en chiffre romains : " + chiffreRomain(1980));
		System.out.println("1958 en chiffre romains : " + chiffreRomain(1958));
		System.out.println("1955 en chiffre romains : " + chiffreRomain(1955));
		
		System.out.println("2000 en chiffre romains : " + chiffreRomain(2000));		
		

	}

	public static String chiffreRomain(int nombre) {
		
		char[] l_unit = {'I','V','X'};
		char[] l_diz = {'X','L','C'};
		char[] l_cent = {'C','D','M'};
		char[] l_mille = {'M',' ',' '};
		
			
		int unites = nombre % 10;
		nombre = nombre / 10;
		int dizaines = nombre % 10;
		nombre = nombre / 10;
		int centaines = nombre % 10;
		nombre = nombre / 10;
		int milaines = nombre % 10;
		
		
		return positionRomain(milaines, l_mille)
				+ positionRomain(centaines, l_cent)
				+ positionRomain(dizaines, l_diz)
				+ positionRomain(unites, l_unit);
	}
	
	public static String positionRomain(int nombre, char[] lettres) {
		StringBuilder result = new StringBuilder();
		switch(nombre) {
			case 3:
				result.append(lettres[0]);
			case 2:
				result.append(lettres[0]);
			case 1:
				result.append(lettres[0]);
				break;
			case 4:
				result.append(lettres[0]);
			case 5:
				result.append(lettres[1]);
				break;
			case 8:
				result.append(lettres[0]);
			case 7:
				result.append(lettres[0]);
			case 6:
				result.append(lettres[0]);
				result.insert(0, lettres[1]);
				break;
			case 9:
				result.append(lettres[0]);
				result.append(lettres[2]);
				break;			
		}
		return result.toString();
	}


}
