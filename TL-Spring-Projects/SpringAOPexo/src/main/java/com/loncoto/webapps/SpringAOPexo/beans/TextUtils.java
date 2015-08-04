package com.loncoto.webapps.SpringAOPexo.beans;

public class TextUtils implements ItextUtils {

	/* (non-Javadoc)
	 * @see com.loncoto.webapps.SpringAOPv2.beans.ItextUtils#inverse(java.lang.String)
	 */
	@Override
	public String inverse(String chaine){
		StringBuilder sb = new StringBuilder();
		for(int i = chaine.length() - 1 ; i >= 0; i--){			
			sb.append(chaine.charAt(i));			
		}
		return sb.toString();
	}
	

}
