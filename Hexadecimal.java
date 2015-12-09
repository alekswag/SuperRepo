/* Andy Liang, Aleksandar Shipetich == Team Advanced Liquid Aeration Company
   APCS1 pd5
   HW 43 -- This or That
   2015-12-07 */

public class Hexadecimal {
  
    private final static String HEXDIGITS = "0123456789ABCDEF"; 
    private int _decNum;
    private String _hexNum;


    public Hexadecimal() { 
        _decNum = 0;
	_hexNum = "0";
    }


    public Hexadecimal( int n ) {
        _decNum = n;
	_hexNum = decToHex(n);
    }

    
    public Hexadecimal( String s ) {
        _hexNum = s;
	_decNum = hexToDec(s);
    }
    

    public String toString() { 
        return Integer.toString(this._decNum);
    }


    public static String decToHex( int n ) {
        int remainder = 0;
	while (n != 0){
	    remainder = remainder * 16 + (n % 16);
	    n = n / 16;
	}
	return Integer.toString(remainder);	
    }
    

    public static String decToBinR( int n ) { 
	if(n == 0){
	    return "0";
	}
	else{
	    return decToBinR(n / 16) + (singleDecConversion(n % 16));
	}	
    }

    
    public static int hexToDec( String s ){
	if(s.length() == 1){
	    return singleHexConversion(s);
	}
	else{
	    return hexToDec(s.substring(0, s.length() -1)) * 16 + singleHexConversion(s.substring(s.length() - 1));
	}
    }

    public boolean equals( Object other ) { 
        if (((Hexadecimal)other)._decNum == this._decNum || other == ((Object)this)){
	    return true;
	}
	else{
	    return false;
	}
    }

    public int compareTo( Object other ) {
        if (((Hexadecimal)other)._decNum == this._decNum){
	    return 0;
	}
        if(((Hexadecimal)other)._decNum < this._decNum){
	    return 1;
	}
	else{
	    return -1;
	}
    }
    

    //Helper Function
    public static int singleHexConversion(String s){ //Can only be of length 1
	int x = 0;
	for(int y = 0; y < 17; y++){
	    if (s.equals(HEXDIGITS.substring(y, y+1))) {
		x = HEXDIGITS.indexOf(HEXDIGITS.substring(y, y+1));
	    }
	}
	return Integer.parseInt(s);
    }

    public static String singleDecConversion(int x){ //One integer that is 15 or less
	return HEXDIGITS.substring(x, x+1);
    }
  
    //main method for testing
    public static void main( String[] args ) {

	
	  System.out.println();
	  System.out.println( "Testing ..." );

	  Hexadecimal b1 = new Hexadecimal(5);
	  Hexadecimal b2 = new Hexadecimal(5);
	  Hexadecimal b3 = b1;
	  Hexadecimal b4 = new Hexadecimal(7);

	  System.out.println( b1 );
	  System.out.println( b2 );
	  System.out.println( b3 );       
	  System.out.println( b4 );       

	  System.out.println( "\n==..." );
	  System.out.println( b1 == b2 ); //should be false
	  System.out.println( b1 == b3 ); //should be true

	  System.out.println( "\n.equals()..." );
	  System.out.println( b1.equals(b2) ); //should be true
	  System.out.println( b1.equals(b3) ); //should be true
	  System.out.println( b3.equals(b1) ); //should be true
	  System.out.println( b4.equals(b2) ); //should be false
	  System.out.println( b1.equals(b4) ); //should be false

	  System.out.println( "\n.compareTo..." );
	  System.out.println( b1.compareTo(b2) ); //should be 0
	  System.out.println( b1.compareTo(b3) ); //should be 0
	  System.out.println( b1.compareTo(b4) ); //should be neg
	  System.out.println( b4.compareTo(b1) ); //should be pos
	  /*=========================================
	  =========================================*/
    }//end main()

} //end class
