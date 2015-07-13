

/**
 * Created by ldrygala on 2015-01-23.
 * 0                     1
 * 1                   1   1
 * 2                 1   2   1
 * 3               1   3   3   1
 * 4             1   4   6   4   1
 * 5           1   5   10  10   5   1
 * 6         1   6   15  20  15   6   1
 * 7       1   7   21  35  35   21  7   1
 * 8     1   8   28  56  70  56   28  8   1
 * 9   1   9  36   84  126 126  84  36  9   1
 */
public class PascalRectangle {
	public static long ___(int _, int __) {
		if (__ > _ - __) {
			__ = _ - __;
		}
		long ___ = 1;
		for (int ____ = 1, _____ = _; ____ <= __; ____++, _____--) {
			___ = ___ * _____ / ____;
		}
		return ___;
	}
	
	private static void ___(int rows){
		for(int i = 0; i < rows; i++){
			String res = "";
			for(int j = 0; j <= i; j++){
				res += ___(i, j) + " ";
			}
			System.out.println();
			___(res);
		}
	}
	
	private static void ___(String str){
		int space = 501;
		int spaceLeft = space - str.length();
		int half = spaceLeft/2;
		String line = "";
		for(int i = 0; i < half; i++){
			System.out.print(" ");
		}
		System.out.print(str);
		for(int i = 0; i < half; i++){
			System.out.print(" ");
		}
	}

	public static void main(String[] args) {
		System.out.println(___(5, 3));
		___(50);
	}
}
