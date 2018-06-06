import AllClasses.*;
import GUI.SuperFrame;

public class Program {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try
		{
			
	//		UserData.GetMarketFromUser();
			
			Address ad1 = new Address("telAviv","Alenbi",34);
			// no need for product max after section B
			SuperMarket mega1 = new SuperMarket("Afeka_mega",ad1,30); //,100);
			
			
			//name,age isMale
			Customer[] custArr = new Customer[4];
			custArr[0] = new Customer("Momo",23,false); 
			custArr[1] = new Customer("momo",55,true);
			//name, age, is Male, idCard,years,totalbuy
			custArr[2] = new MemberCustomer("Gogo",44,true,"1234",3,0); 
			custArr[3] = new MemberCustomer("Popo",46,false,"3456",5,0);
	
			mega1.addCustomer(custArr[1]);
			mega1.addCustomer(custArr[3]);
			mega1.addCustomer(custArr[2]);
			mega1.addCustomer(custArr[0]);
			
			Date exp1 = new Date(1,1,2018);	
			Date exp2 = new Date(1,1,2017);
			Date exp3 = new Date(31,1,2017);
			Date exp4 = new Date(1,4,2018);
			
			
			
			Date d1 = new Date(2,3,2015);
			Date d2 = new Date(12,3,2015);
	
			//start date, end date, percentage
			SaleInfo info = new SaleInfo(d1,d2,15.0F);
	
			Product[]  prdArr = new Product[7];
			prdArr[0] = new FrozenProduct("Jachnon","93450",exp1,null,8.8F,12.4F,34,-14);
			prdArr[1] = new FridgeProduct("Milk","67800",exp2,null,3.8F,5.4F,100,4);
			prdArr[2] = new FruitVegProduct("Onion", "56610",null,info,2.1F,4.3F,45,false);
			prdArr[3] = new FruitVegProduct("Orange", "19809",null,info,8.1F,11.3F,12,true);
			Location l1 = new Location(2,3);
			Location l2 = new Location(1,0);
			Location l3 = new Location(3,1);
			prdArr[4] = new ShelfProduct("Bamba","12345",exp3,null,8.8F,12.4F,34,l1,ShelfProduct.packageType.Plastic);
			prdArr[5] = new ShelfProduct("Coffee","89898",exp4,info,18.8F,22.4F,55,l2,ShelfProduct.packageType.Glass);
			prdArr[6] = new ShelfProduct("CiniMini","34343",exp4,null,10.8F,16.4F,55,l3,ShelfProduct.packageType.Cardboard);
	
			for (int i = 0 ; i < prdArr.length; i++)
				mega1.addProduct(prdArr[i]);
			
			new SuperFrame(mega1);	
			
			
		} catch( Exception e){
			System.out.println(e.getMessage());
		}
			
	}

	
}
