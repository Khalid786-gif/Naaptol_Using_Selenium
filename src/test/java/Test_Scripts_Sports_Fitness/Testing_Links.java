package Test_Scripts_Sports_Fitness;

import java.io.IOException;

import org.testng.annotations.Test;

import Base.Base1;

public class Testing_Links extends Base1  {
	
	@Test(priority = 1)
	void Test1_Testing_Links_Of_SportsFitness_SubCategory() throws InterruptedException, IOException {
	
		
		p1.Test_shopping_cat();
		
		Take_Screenshot(driver, 1);
		
		p1.Test_Fitness_Acc();
		
		p1.Test_shopping_cat();
		
		p1.Test_Hiking();
		
		p1.Test_shopping_cat();
		
		p1.Test_Fitness_Equipment();
		
		Take_Screenshot(driver, 2);
			
	}
	
	
	@Test(priority = 2)
	void Testing_Search_Functionality() throws InterruptedException, IOException {
		
		p1.Test_shopping_cat();
		
	    p1.Test_Fitness_Equipment();
	    
	    Take_Screenshot(driver, 3);
		
		S1.search_1(InputData1);
		
		S1.search2(InputData2);
		
		S1.Search3(InputData3);
		
		S1.Asserting_Err_Msg();
		
		Take_Screenshot(driver, 4);
			
	}
	
	
	@Test(priority = 3)
	void Testing_Filter_Functionality() throws InterruptedException, IOException {
		
		p1.Test_shopping_cat();
		
	    p1.Test_Fitness_Equipment();
	    
	    Take_Screenshot(driver, 5);
	    
		F1.Filter_Remove();
		
		F1.Filter_Product_Popular(Sort_InputData4);
		
		F1.Filter_Product_Cod();
		
		F1.Filter_Product_Out_Of_Stock();
		
		F1.Filter_Product_Pincode(Pincode_InputData5); 
		
		F1.Filter_Product_Brands();
		
		F1.Filter_Product_Price();
		
		F1.Filter_Product_Discount();
		
		F1.Filter_Product_Type();
		
		Take_Screenshot(driver, 6);
	}
	
	
	@Test(priority = 4)
	void Testing_Compare_Functionality() throws InterruptedException, IOException {
		
		p1.Test_shopping_cat();
		
	    p1.Test_Fitness_Equipment();
		
		C1.Add_Product1();
		
		Take_Screenshot(driver, 7);
		
		C1.Add_Product2();
		
		Take_Screenshot(driver, 8);
		
		C1.Add_Product3();
		
		Take_Screenshot(driver, 9);
		
		C1.Add_Product4();
		
		Take_Screenshot(driver, 10);
		
		C1.Add_Product5();
		
		C1.Checking_Assertion();
		
		C1.Compare_Window();
		
		Take_Screenshot(driver, 11);
		
	}
	
	
	@Test(priority = 5)
	void Testing_Quick_view_Functionality() throws InterruptedException, IOException {
		
		p1.Test_shopping_cat();
		
	    p1.Test_Fitness_Equipment();
	    
	    Q1.Quick_View();
	    
	    Take_Screenshot(driver, 12);
	    
	    Q1.View_Images();
	    
	    Q1.Pincode_check(Pincode_InputData5);
	    
	    Q1.Next_Product_Quick_View();
	    
	    Q1.Next_Product_Quick_View();
	    
	    Take_Screenshot(driver, 13);
	    
	    Q1.Previous_Product_Quick_View();
	    
	    Q1.Page_back();
	    
	    Q1.Page_Refresh();
	}
	
	
	@Test(priority = 6)
	void Testing_AddToCart_Functionality() throws InterruptedException, IOException {
		
		ATC1.Selecting_Sports_Fitness();
		
		ATC1.Product_Video();
		
		Take_Screenshot(driver, 14);
		
		ATC1.Close_Video();
		
		ATC1.Click_On_Product1();
		
		ATC1.Add_To_Cart1();
		
		ATC1.Continue_Shopping();
		
		ATC1.Click_On_Product2();
		
		ATC1.Add_To_Cart2(Add_To_Cart_Page_Title);
		
		ATC1.Add_3_Quantity();
		
		Take_Screenshot(driver, 15);
		
		ATC1.More_Than_2_Quantity_Err_Msg(Add_To_Quantity_Err_Msg);  //Assertion
		
		ATC1.Enter_Gift_Voucher();
		
		ATC1.Apply_Gift_Voucher();
		
		ATC1.Proceed_To_Checkout();
		
	}
	
	

}
