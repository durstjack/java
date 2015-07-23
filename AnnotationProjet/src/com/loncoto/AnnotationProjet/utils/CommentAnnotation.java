package com.loncoto.AnnotationProjet.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface CommentAnnotation {
	
	// a la fois methode et arguments
	//c'est ce que l'on veut 
	//que notre annotation fasse
	String comment();
	int version();

}
