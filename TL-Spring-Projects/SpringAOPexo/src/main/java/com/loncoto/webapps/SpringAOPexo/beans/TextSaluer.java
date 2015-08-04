package com.loncoto.webapps.SpringAOPexo.beans;

public class TextSaluer implements ITextSaluer {

	/* (non-Javadoc)
	 * @see com.loncoto.webapps.SpringAOPexo.beans.ITextSaluer#saluer(java.lang.String)
	 */
	@Override
	public String saluer(String chaine){
		StringBuilder sb = new StringBuilder();
		sb.append("bonjour " + chaine + " content de vous voir ");
		return sb.toString();
	}

}
