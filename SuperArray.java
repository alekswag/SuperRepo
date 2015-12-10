/*
Aleksandar Shipetich
APCS1 Pd5
HW40 -- Array of Grade 316
2015-12-3
*/


public class SuperArray {
 
    //~~~~~INSTANCE VARS~~~~~
    //underlying container, or "core" of this data structure:
    private Comparable[] _data;

    //position of last meaningful value
    private int _lastPos;

    //size of this instance of SuperArray
    private int _size;

    //~~~~~CONSTRUCTOR~~~~~
    //default constructor â€“ initializes 10-item array
    public SuperArray() 
    { 
	_data = new Comparable[10];
	_lastPos = -1; //flag to indicate no lastpos yet
	_size = 0;	
    }
		
    //~~~~~METHODS~~~~~

    //output array in [a,b,c] format, eg
    // {1,2,3}.toString() -> "[1,2,3]"
    public String toString() 
    { 
	String foo = "[";
	for( int i = 0; i < _size; i++ ) {
	    foo += _data[i] + ",";
	}
	//shave off trailing comma
	if ( foo.length() > 1 )
	    foo = foo.substring( 0, foo.length()-1 );
	foo += "]";
	return foo;
    }

		
    //double capacity of this SuperArray
    private void expand() 
    { 
	Comparable[] temp = new Comparable[ _data.length * 2 ];
	for( int i = 0; i < _data.length; i++ )
	    temp[i] = _data[i];
	_data = temp;
    }

		
    //accessor -- return value at specified index
    public Comparable get( int index ) { return _data[index]; }

		
    //mutator -- set value at index to newVal, 
    //           return old value at index
    public Comparable set( int index, Comparable newVal ) 
    { 
 	Comparable temp = _data[index];
	_data[index] = newVal;
	return temp;
    }


    // ~~~~~~~~~~~~~~ PHASE II ~~~~~~~~~~~~~~
    //adds an item after the last item
    public void add( Comparable newVal ) {
	if (_size == _data.length)
	    expand();
	_data[_lastPos +1] = newVal;
	_size ++;
	_lastPos ++;
    }


    //inserts an item at index
    //shifts existing elements to the right
    //My implementation is recursive
    public void add( int index, Comparable newVal ) {
	if (_size == _data.length)
	    expand();
	else if (index > _size){
		_size ++;
		_lastPos ++;
	    }
	else {
	    Comparable temp = _data[index];
	    _data[index] = newVal;
	    add(index+1, temp);
	}
    }






    //removes the item at index
    //shifts elements left to fill in newly-empted slot
    public void remove( int index ) {
	for(int i = index; i< _size -1;i++)
	    _data[i] = _data[i+1];
	_size --;
	_lastPos --;
    }


    //return number of meaningful items in _data
    public int size() {
	return _lastPos + 1;
    }

    public int linSearch(Comparable aleks){
	for (int i = 0; i<=_lastPos; i++){
	    if (aleks.compareTo(_data[i]) == 0)
		return i;
	}
	return -1;
    }
			 
    public boolean isSorted(){
	for (int i = 0; i < _lastPos; i++)
	    if (!(_data[i+1].compareTo(_data[1]) == 1))
		return false;
	return true;
    }


	
    //main method for testing
    public static void main( String[] args ) {
	// Creates a SuperArray
        SuperArray shipetich = new SuperArray();
	System.out.println(shipetich);
	//Creates Comparables
	Comparable alex = new Binary(5);
	Comparable swag = new Hexadecimal(6);
	Comparable great = new Rational(2,2);
	//Adds Comparables
	shipetich.add(alex);
	shipetich.add(swag);
	shipetich.add(great);
	System.out.println("Printing new SuperArray with comparables");
	System.out.println(shipetich);
	//do some searching
	System.out.println("Should return 0: \n"+shipetich.linSearch(alex));
	//isSorted?
	System.out.println("Should return false: \n"+shipetich.isSorted());		

	
    }//end main
		
}//end class
