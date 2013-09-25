package simpledb;

import java.io.Serializable;
import java.util.*;

/**
 * TupleDesc describes the schema of a tuple.
 */
public class TupleDesc implements Serializable {

    /**
     * A help class to facilitate organizing the information of each field

     * */

    TDItem [] myFields;
    public static class TDItem implements Serializable {

        private static final long serialVersionUID = 1L;

        /**
         * The type of the field
         * */
        Type fieldType;
        
        /**
         * The name of the field
         * */
        String fieldName;

        public TDItem(Type t, String n) {
            this.fieldName = n;
            this.fieldType = t;
        }

        public String toString() {
            return fieldName + "(" + fieldType + ")";
        }
    }

    /**
     * @return
     *        An iterator which iterates over all the field TDItems
     *        that are included in this TupleDesc
     * */
    public Iterator<TDItem> iterator() {
	return Iterator<TDItem> myIterator = Arrays.asList(myFields).iterator();

	

    }

    private static final long serialVersionUID = 1L;

    /**
     * Create a new TupleDesc with typeAr.length fields with fields of the
     * specified types, with associated named fields.
     * 
     * @param typeAr
     *            array specifying the number of and types of fields in this
     *            TupleDesc. It must contain at least one entry.
     * @param fieldAr
     *            array specifying the names of the fields. Note that names may
     *            be null.
     */
    public TupleDesc(Type[] typeAr, String[] fieldAr) {
	this.myFields = new TDItem[typeAr.length];
	for(int i =0; i < typeAr.length; i++){
		this.myFields[i] = new TDItem(typeAr[i],fieldAr[i]);	
	}        
    }

    /**
     * Constructor. Create a new tuple desc with typeAr.length fields with
     * fields of the specified types, with anonymous (unnamed) fields.
     * 
     * @param typeAr
     *            array specifying the number of and types of fields in this
     *            TupleDesc. It must contain at least one entry.
     */
    public TupleDesc(Type[] typeAr) {
        // some code goes here
	this.myFields = new TDIem[typeAr.length];
	for(int i =0; i < typeAr.length; i++){

		this.myFields[i] = new TDItem(typeAr[i],"");
		
	}    
    }

    /**
     * @return the number of fields in this TupleDesc
     */
    public int numFields() {
	return this.myFields.length;
        // some code goes here
      
    }

    /**
     * Gets the (possibly null) field name of the ith field of this TupleDesc.
     * 
     * @param i
     *            index of the field name to return. It must be a valid index.
     * @return the name of the ith field
     * @throws NoSuchElementException
     *             if i is not a valid field reference.
     */
    public String getFieldName(int i) throws NoSuchElementException {
        // some code goes here
        if(i >= this.myFields.length){
	throw new NoSuchElementException("i is not a valid index");
    }
	else{
		return this.myFields[i].fieldName;
	
}
}
    /**
     * Gets the type of the ith field of this TupleDesc.
     * 
     * @param i
     *            The index of the field to get the type of. It must be a valid
     *            index.
     * @return the type of the ith field
     * @throws NoSuchElementException
     *             if i is not a valid field reference.
     */
    public Type getFieldType(int i) throws NoSuchElementException {
        // some code goes here
       
    if(i >= this.myFields.length){
	throw new NoSuchElementException("i is not a valid index");
    }
	else{
		return this.myFields[i].fieldType;
	
}
}

    /**
     * Find the index of the field with a given name.
     * 
     * @param name
     *            name of the field.
     * @return the index of the field that is first to have the given name.
     * @throws NoSuchElementException
     *             if no field with a matching name is found.
     */
    public int fieldNameToIndex(String name) throws NoSuchElementException {
        // some code goes here 
	boolean contains = false;
	for(int i =0 ; i < this.myFields.length; i++){
	if(this.myFields[i].equals(name)){
	boolean contains = true;
	return i;
}
	}

        if(contains = false){
	throw new NoSuchElementException("no field with a matching name is found");
 	
}
    }

    /**
     * @return The size (in bytes) of tuples corresponding to this TupleDesc.
     *         Note that tuples from a given TupleDesc are of a fixed size.
     */
    public int getSize() {
        // some code goes here
        return (this.myFields[0].fieldType.getLen() * this.myFields.length);
    }

    /**
     * Merge two TupleDescs into one, with td1.numFields + td2.numFields fields,
     * with the first td1.numFields coming from td1 and the remaining from td2.
     * 
     * @param td1
     *            The TupleDesc with the first fields of the new TupleDesc
     * @param td2
     *            The TupleDesc with the last fields of the TupleDesc
     * @return the new TupleDesc
     */
    public static TupleDesc merge(TupleDesc td1, TupleDesc td2) {
        // some code goes here
        TDItem[] td3 = new TDItem[td1.myFields.length + td2.myFields.length];
	for(int i =0 ;i < td1.myFields.length; i++){
	td3[i] = td1.myFields[i]
}
	for(int x= td1.myFields.length; x < td1.myFields.length + td2.myFields.length; x++){
	td3[x] = td2.myFields[x]
}
	TupleDesc mergedTupleDesc = new TupleDesc();
	mergedTupleDesc.myFields = td3;
	return mergedTupleDesc;
    }

    /**
     * Compares the specified object with this TupleDesc for equality. Two
     * TupleDescs are considered equal if they are the same size and if the n-th
     * type in this TupleDesc is equal to the n-th type in td.
     * 
     * @param o
     *            the Object to be compared for equality with this TupleDesc.
     * @return true if the object is equal to this TupleDesc.
     */
    public boolean equals(Object o) {
        // some code goes here
     if(o instanceof TupleDesc){
       if(this.myFields.length != o.myFields.length){
	return false;
    }
	else{
		for(int n =0; n < this.myFields.length; n++){
			if (!this.myFields[n].equals(o.myFields[n]){
					return false;
	}
	else{	
		return true;	
	}
}
}
}
else{
return false;
}
}
    public int hashCode() {
        // If you want to use TupleDesc as keys for HashMap, implement this so
        // that equal objects have equals hashCode() results
        throw new UnsupportedOperationException("unimplemented");
    }

    /**
     * Returns a String describing this descriptor. It should be of the form
     * "fieldType[0](fieldName[0]), ..., fieldType[M](fieldName[M])", although
     * the exact format does not matter.
     * 
     * @return String describing this descriptor.
     */
    public String toString() {
       String returnString = "";
       for(int i = 0; i < this.myFields.length; i++){
	 returnString += this.myFields[i].fieldType + "(" + this.myFields[i].fieldName + ")" + ","
	}

        return returnString;
    }
}