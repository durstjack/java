
package com.loncoto.AnnotationProjet.principal;

import com.loncoto.AnnotationProjet.utils.CommentAnnotation;

public class Program {
	
	public static void main(String[] arg){
		TestClass tc = new TestClass();
		Class cls = tc.getClass();
		
		CommentAnnotation ca = (CommentAnnotation)  cls.getAnnotation(CommentAnnotation.class);
		
		System.out.println("pour" + cls.getCanonicalName() + " : " + ca.comment() + "=>" + ca.version());
	
	}

}
