package com.loncoto.AnnotationProjet.principal;

import com.loncoto.AnnotationProjet.utils.CommentAnnotation;

@CommentAnnotation(comment="une classe de test", version=2)
public class TestClass {
	
	@CommentAnnotation(comment = "methode de test", version = 1)
	public void testMethod(){
		
	}

}
