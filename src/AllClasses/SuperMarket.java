package AllClasses;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Vector;

public class SuperMarket {

	private String 	name;
	private Address storeAddress;

	//private Product[] prodArr;
	//private int prodCount;
	private Customer[] custArr;
	private Vector<Product> prodVec = new Vector<>();
	private LinkedHashMap<String, Product> prodMapByBarcode = new LinkedHashMap<>();
	private int custCount;

	public SuperMarket(String name, Address storeAddress,int maxCust) throws CloneNotSupportedException {
		this.name = name;
		this.storeAddress = storeAddress.clone();	
		custArr = new Customer[maxCust];
		//	prodArr = new Product[maxProd];
	}

	public String getName() {
		return name;
	}

	public int getProdCount() {
		return prodVec.size();
	}

	public int getCustCount() {
		return custCount;
	}

	public Customer[]  getCustomerArr(){
		return Arrays.copyOf(custArr,custCount);
	}

	public Vector<Product>  getProductVector(){
		return prodVec;
	//	return Arrays.copyOf( prodArr,prodCount);
	}

	public String  toString() {
		StringBuffer sb = new StringBuffer("SuperMarket " + name + " " + storeAddress);
		sb.append(". There are " + custCount + " customers in store\n");
		for (int i = 0; i < custCount; i++)
			sb.append(custArr[i]+"\n");
		sb.append("There are " + prodVec.size() + " products in store\n");
		sb.append(prodVec);
		return sb.toString();
	}


	public int findCustomer(Customer cust) {
		for (int i = 0; i < custCount; i++)
			if (custArr[i].equals(cust))
				return i;
		return -1;
	}

	public boolean addCustomer(Customer cust) throws CloneNotSupportedException {
		if (custCount == custArr.length)
			return false;
		if (findCustomer(cust)!= -1)	//customer already in store.
			return false;

		custArr[custCount] = cust.clone(); 
		custArr[custCount].setSuperIn(this);
		custCount++;
		return true;
	}


	public int findProduct(Product prod) {
		//This function is exactly what we need, return -1 if not found. 
		return prodVec.indexOf(prod);
	}

	public boolean addProduct(Product prod) throws Exception {
		int index = findProduct(prod);
		if (index == -1) //product new.
		{
			Product temp =  prod.clone();
			
			//add after clone so both vector and has map has the same element reference.
						
			//if the map did not return a null there was something in that key! not good!
			if (prodMapByBarcode.put(prod.getBarcode(), temp) != null)
				throw new Exception("product already in map");
			
			boolean res = prodVec.add(temp);
	
			//return what the vector returned.
			return res;	
		} else {
			prodVec.get(index).updateAmount(prod.getAmount());
		}
		return true;
	}

	public boolean removeProduct(String barcode){
		
		Product temp = prodMapByBarcode.get(barcode);
		if(temp == null)
			return false;
		
		prodMapByBarcode.remove(barcode);
		return prodVec.remove(temp);
	}
	
	public  Product getProductByBarcode(String barcode){
		return prodMapByBarcode.get(barcode);
	}

	public  Product getProductByName(String name){
		Iterator<Product> itr = prodVec.iterator();
		Product temp;
		while(itr.hasNext())
		{
			temp = itr.next();
			if ( temp.getName().equals(name))
				return temp;
		}			
		return null;
	}

	public boolean buy(String name){
		Product pr = getProductByName(name);
		if (pr == null)
			return false;
		if (pr.getAmount() == 0) //not in stock
			return false;
		return pr.updateAmount(-1);	
	}

	public Product getProduct(int index) throws Exception{
		if (index<0 || index >= prodVec.size())
			throw new Exception("Illigal index");
		return prodVec.get(index);
	}

	public Customer getCustomer(int index) throws Exception{
		if (index<0 || index >= custCount)
			throw new Exception("Illigal index");
		return custArr[index];
	}


	public int getMembersCount()
	{
		int count = 0;
		for (int i = 0; i < custCount; i++)
			if (custArr[i] instanceof MemberCustomer)
				count++;
		return count++;
	}

	public void incMembersYears()
	{
		for (int i = 0; i < custCount; i++)
			if (custArr[i] instanceof MemberCustomer)
			{
				MemberCustomer cust = (MemberCustomer) custArr[i];
				cust.incYears();
			}
	}


	public void electricIsDown(){
		Iterator<Product> itr = prodVec.iterator();
		Product temp;
		while(itr.hasNext())
		{
			temp = itr.next();
			if (temp instanceof FridgeProduct)
				((FridgeProduct) temp).electricFault();
		}

	}

	public void maintenance(){ 
		Iterator<Product> itr = prodVec.iterator();
		Product temp;
		while(itr.hasNext())
		{
			temp = itr.next();
			if (temp instanceof NonFridgeProduct)
				((NonFridgeProduct)temp).maintenance();
		}

	}

	public void checkExpDate(){ 
		Iterator<Product> itr = prodVec.iterator();
		while(itr.hasNext())
			System.out.println(itr.next().checkExpDate());
	}

	public void sortCustomers(){
		Arrays.sort(custArr,0,custCount);
	}

	
	public void sortProductsByName(){
		Collections.sort(prodVec,new CompareProductByName());
	}


	public void sortProductsByBarcode(){
		Collections.sort(prodVec,new CompareProductByBarcode());
	}


	public void sortProductsByExpDate(){
		Collections.sort(prodVec,new CompareProductByExpDate());
	}

	
//	public void sortProductsByName(){
//		Arrays.sort(prodVec,0,prodCount,new CompareProductByName());
//	}
//
//
//	public void sortProductsByBarcode(){
//		Arrays.sort(prodArr,0,prodCount,new CompareProductByBarcode());
//	}
//
//
//	public void sortProductsByExpDate(){
//		Arrays.sort(prodArr,0,prodCount,new CompareProductByExpDate());
//	}

//	public void monthDue(Object[] arr){
//		for (int i = 0; i < arr.length; i++)
//			if(arr[i] instanceof OnMonthable)
//				((OnMonthable)arr[i]).onMonth();
//	}

	public void monthDue(Vector<Object> vec){
		Iterator<Object> itr = vec.iterator();
		Object temp;
		while(itr.hasNext())
		{
			temp = itr.next();
			if(temp instanceof OnMonthable)
				((OnMonthable)temp).onMonth();
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SuperMarket other = (SuperMarket) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (storeAddress == null) {
			if (other.storeAddress != null)
				return false;
		} else if (!storeAddress.equals(other.storeAddress))
			return false;
		return true;
	}


}
