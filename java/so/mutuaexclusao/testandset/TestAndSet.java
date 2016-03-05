package br.com.ahe.so.mutuaexclusao.testandset;

public class TestAndSet {	
	
	static int myValue = -1;
	static int  rc1 = 1;
	static int  wc1 = 1;
	static int d = 1;
	static int q = 1;
	
	public static void main(String args[]){
		for (int i=1; i<500; i++){
			int random = (int) ( 1 + Math.random() *2);


			if (random == 1){
				//Reader1 r1 = new Reader1();
				//r1.start();
				Reader1();
			}
			else if (random == 2){
				// Writer1 w1 = new Writer1();
				// w1.start();
				Writer1();
			}			
			
		}	 

	}


	public synchronized static int testAndSet (int newValue){
		int oldValue = myValue;
		myValue = newValue;
		return oldValue;
	}


	public static void Reader1(){
		switch (rc1) {
		case 1: System.out.println("Entered Reader Line 1"); rc1++; return;	
		case 2: System.out.println("Entered Reader Line 2"); rc1++; return;	
		case 3: System.out.println("Entered Reader Line 3"); rc1++; return;	   

		//guard critical section  
		case 4: int goValue = testAndSet(1);
		if (goValue == 1){
			//do nothing and keep looping
			System.out.println("Reader 1 UNABLE TO ENTER CRITICAL SECTION");				 
			rc1=4; return;					
				} 


		//START OF CRITICAL SECTION
		case 5: if (d < 10) {rc1=6;}
		else if (d > 9) {rc1=7; return; } 
		case 6: System.out.println("Reader 1 now inside Critical Section"); 
		d++;
		rc1=5; return;
		//END OF CRITICAL SECTION				 

		case 7: myValue = -1; 
		System.out.println("Reader 1 has now left the Critical Section");	
		//start of non critical section
		d=9;
		rc1=1; return;
		}		   

	}
	public static void Writer1(){
		switch (wc1) {
		case 1: System.out.println("Entered Writer Line 1"); wc1++; return;	
		case 2: System.out.println("Entered Writer Line 2"); wc1++; return;	
		case 3: System.out.println("Entered Writer Line 3"); wc1++; return;	   

		//guard critical section  
		case 4: int goValue = testAndSet(1);
		if (goValue == 1){
			//do nothing and keep looping
			System.out.println("Writer 1 UNABLE TO ENTER CRITICAL SECTION");   
			wc1=4; return; 
		} 

		//START OF CRITICAL SECTION
		case 5: if (q < 10) {wc1=6;}
		else if (q > 9) {wc1=7; return; } 
		case 6: System.out.println("Writer 1 now inside Critical Section"); 
		q++;
		wc1=5; return;
		//END OF CRITICAL SECTION
		
		case 7: myValue = -1;   
		System.out.println("Writer 1 has now left the Critical Section");
		//start of non critical section
		q=1;
		wc1=1; return;
		}



	}
}