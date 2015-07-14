package pokerHands.interactive;

import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.Currency;

public class Numbers {

	public static String convertToCurrency(BigInteger monies){
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		nf.setCurrency(Currency.getInstance("EUR"));
		return nf.format(monies);
	}
	
	public static String toScientificNotation(BigInteger monies){
		String tmp = convertToCurrency(monies);
		String[] t = tmp.split("\\.");
		if(t.length < 2){
			return tmp;
		}
		tmp = t[0] + "," + t[1].substring(0, 2) + "*10^" + (String.valueOf(monies).length() - 1) + "€";
		return tmp;
		
	}

}
