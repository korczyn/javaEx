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
	
	public static String nameANumber(BigInteger monies){
		String tmp = convertToCurrency(monies);
		String[] t = tmp.split("\\.");
		
		switch(t.length){
		case 2:
			tmp = t[0] + "," + t[1].substring(0, 2) +  " thousand €";
			break;
		case 3:
			tmp = t[0] + "," + t[1].substring(0, 2) +  " million €";
			break;
		case 4:
			tmp = t[0] + "," + t[1].substring(0, 2) +  " billion €";
			break;
		case 5:
			tmp = t[0] + "," + t[1].substring(0, 2) +  " trillion €";
			break;
		case 6:
			tmp = t[0] + "," + t[1].substring(0, 2) +  " quadrillion €";
			break;
		case 7:
			tmp = t[0] + "," + t[1].substring(0, 2) +  " quintillion €";
			break;
		case 8:
			tmp = t[0] + "," + t[1].substring(0, 2) +  " sixtillion €";
			break;
		case 9:
			tmp = t[0] + "," + t[1].substring(0, 2) +  " septillion €";
			break;
		case 10:
			tmp = t[0] + "," + t[1].substring(0, 2) +  " octillion €";
			break;
		case 11:
			tmp = t[0] + "," + t[1].substring(0, 2) +  " nonillion €";
			break;
		case 12:
			tmp = t[0] + "," + t[1].substring(0, 2) +  " decillion €";
			break;
		case 13:
			tmp = t[0] + "," + t[1].substring(0, 2) +  " undecillion €";
			break;
		case 14:
			tmp = t[0] + "," + t[1].substring(0, 2) +  " duodecillion €";
			break;
			
		}
		
		return tmp;
	}

}
