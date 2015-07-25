package principal;

import java.util.Arrays;

public class Programme {


	public static void main(String[] args) {

		Figure F1 = new Rectangle("rectangle1", 4, 5);
		Figure F2 = new Triangle("triangle1", 5);
		Figure F3 = new Rectangle("rectangle2", 14, 8);
		
		Figure[] Tableau = { F1, F2, F3};

		for( Figure Obj : Tableau){
			Obj.afficher();
		}


	}

}
