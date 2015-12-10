/*  Team Red Squad  - Aleksandar Shipetich, Christopher Sherling
    APCS1 pd5
    HW41 -- In America, the Driver Sits on the Left
    2015-12-4
*/

public class  Rational implements Comparable{
	 
    private double numerator;
    private double denominator;
    private double _decNum = numerator / denominator;

    //Default Constructor
    public Rational(){
	numerator = 0;
	denominator = 1;
    }

    //Overloaded Constructor
    public Rational(double newNum, double newDen){
	numerator = newNum;
	denominator = newDen;
    }

    public int getDecNum(){
	return (int)_decNum;
    }

    //toString printing x/y form
    public String toString(){
	String num = "";
	num += numerator;
	num += "/";
	num += denominator;
	return num;
    }


    //accesors and mutatorsfor each
    public double getNumerator() {
	return numerator; 
    }

    public void setNumerator(double numerator) {
	this.numerator = numerator;
    }

    public double getDenominator() {
	return denominator;
    }

    public void setDenominator(double denominator) {
	this.denominator = denominator;
    }

    //Multiplies numerators then denominators
    public void multiply (Rational r) {
	this.numerator*=r.numerator;
	this.denominator*=r.denominator;
    }
	
    //Divides numerators then denomintors
    public void divide (Rational r) {
	this.numerator/=r.numerator;
	this.denominator/=r.denominator;
    }
	
    //Returns floating point number
    public static double floatValue(Integer s) {
	return (double)s;
    }

    public double floatValue(){
	double d;
	d = (double)(numerator) / (double)(denominator);
	return d;
    }

    public void add(Rational r) {
	this.numerator = this.numerator * r.denominator + r.numerator * this.denominator;
	this.denominator*=r.denominator;
    }	
	
    public void subtract(Rational r) {
	this.numerator = this.numerator * r.denominator - r.numerator * this.denominator;
	this.denominator*=r.denominator;
    }	

    public int gcd(){
	int a = (int)this.numerator;
	int b = (int)this.denominator;
	int c = 1;
	if (a > b){	
	    while( c != 0 ){
		c = a%b;
		a = b;
		b = c;
	    }
	    return a;
	}
	else{
	    while( c != 0 ){
		c = b%a;
		b = a;
		a = c;
	    }
	    return b;
	}
    }

    public static int gcd(double a, double b) {
	int y = (int)a;
	int z = (int)b;
	int c = y;
	if (y > z)
	    c = z;
	while ((c > 0) && 
	       ((y % c != 0) ||
		(z % c != 0))
	       ){
	    c -= 1;
	}
	return c;
    }

    public void reduce(){
	int x = this.gcd();
	this.numerator /= x;
	this.denominator /= x;
    }
	    public int compareTo(Object aleks){
	if (aleks instanceof Comparable)
	    return compareTo((Comparable)aleks);
	else
	    throw new ClassCastException( "Object is not of class Comparable.");
    }

   public int compareTo(Comparable aleks){
	if (aleks instanceof Binary)
	    return this.compareTo((Binary)aleks);
	else if (aleks instanceof Rational)
	    return compareTo((Rational)aleks);
	else if (aleks instanceof Hexadecimal)
	    return this.compareTo((Hexadecimal)aleks);
	else
	    throw new ClassCastException( "Object is not of class Binary or Hex or Rational.");
    }

    public int compareTo(Rational other){
	this.reduce();
	other.reduce();
	if((getNumerator() == other.getNumerator()) && (getDenominator() == other.getDenominator())){
	    return 0;
	}
	else if((getNumerator() > other.getNumerator()) && (getDenominator() == other.getDenominator())){
	    return 1;
	}
	else {

	    return -1;
	}
    }

    public boolean equals(Object o){
	this.reduce();
	((Rational)o).reduce();
	 
	//First, check for aliasing.
	boolean retVal = this == o;
 
	//Next, if this and input Object are different objects,
        if ( !retVal ){
 
	    //...check to see if input Object is a Rational
	    retVal = o instanceof Rational
 
		//...and that its state variables match those of this Tile
		&& this.numerator == ((Rational)o).numerator
		&& this.denominator == ((Rational)o).denominator;
	    System.out.println(o);
	    System.out.println(this);
	    System.out.println(this.numerator);
	    System.out.println(((Rational)o).numerator);
	    System.out.println(this.denominator);
	    System.out.println(((Rational)o).denominator);

	}
	return retVal;

    }
    //Main woohoooooooooooooo #testcalls
    public static void main(String[] args) {
		
	Rational r = new Rational(3,4);
	Rational j = new Rational(5,6);
	Rational a = new Rational(3,4);
	Rational b = new Rational(5,6);
	Rational c = new Rational(6,8);
	Rational d = new Rational(6,10);
	Rational e = new Rational(10,6);
	Rational f = new Rational(1,1);
	Rational g = new Rational(2,2);
	Rational h = new Rational(4,1);

	// System.out.println("numerator is:" + r.numerator + " denominator is:" + r.denominator);
	// System.out.println("we are dividing this by " + j.numerator + "/" + j.denominator);
	// r.divide(j);
	// System.out.println("Now that we divided, numerator is:" + r.numerator + " denominator is:" + r.denominator);
	// a.multiply(b);
	// System.out.println("Now that we multiplied, numerator is:" + r.numerator + " denominator is:" + r.denominator);
	// int shf = 4; 
	// System.out.println(floatValue(shf));
		
	/*
	 * output
	 * numerator is:3.0 denominator is:4.0
	 we are dividing this by 5.0/6.0
	 Now that we divided, numerator is:0.6 denominator is:0.6666666666666666
	 Now that we multiplied, numerator is:0.6 denominator is:0.6666666666666666
	 4.0
	*/
	r.add(j);
	System.out.println("Add: " + r + " Should be 38/24");
	a.subtract(b);
	System.out.println("Sub: " + a + " Should be -2/24");	
	System.out.println("*==============*");
	System.out.println("d.gcd(), Expected: 2, Result: " + d.gcd());
	System.out.println("e.gcd(), Expected: 2, Result: " + e.gcd());
	System.out.println("GCD Static");
        System.out.println("GCD OF 12 20: " + gcd(12, 20) + " Should be 4");
	c.reduce();
	System.out.println("Reduce: " + c + " Should be 3/4");
	System.out.println("*==============*");
	System.out.println();
	System.out.println("f.compareTo(g), Expected: 0, Result: " + f.compareTo(g));
	System.out.println("h.compareTo(f), Expected: 1, Result: " + h.compareTo(f));
	System.out.println("f.compareTo(h), Expected: -1, Result: " + f.compareTo(h));
	Rational aa = new Rational(3,4);
	Rational ab = new Rational(6,8);
	    
	System.out.println(aa.equals(ab));
    }

}
