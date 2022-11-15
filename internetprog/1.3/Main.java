public class Main{
	
	
	/**
	*A main class 
	*
	*The main class has a main method that runs two parallel threads
	*
	* @author [Oscar Hansson]
	*
	*
	*/
	
	public Main(){
		
	}
	

	/**
	* Main method
	*
	* @param args - command line arguments, not used in method
	* @see #waitFiveSeconds()
	* @see #T1.setAlive()
	* @see #T2.setAlive()
	*/
	public static void main(String[] args){
		
		Main m = new Main();
		
		//Skapa och starta en tråd från klass T1
		T1 t1 = new T1();
		//Vänta i 5 sekunder
		m.waitFiveSeconds();
		//Skapa och starta en tråd från klass T2
		T2 t2 = new T2();
		//Vänta i 5 sekunder
		m.waitFiveSeconds();
		//Stoppa tråden från klass T1
		t1.setAlive(false);
		//Vänta i 5 sekunder
		m.waitFiveSeconds();
		//Stoppa tråden från klass T2
		t2.setAlive(false);
	}

		
	/**
	* Method that holds the execution for five seconds
	*/
	public void waitFiveSeconds(){
		synchronized(this){
			try{
				wait(5000);
			}catch(InterruptedException e){
				System.err.println("tråd avbröts");
			}
		}
	}
	
}	