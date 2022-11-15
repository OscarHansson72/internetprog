public class T1 extends Thread{
	
	private boolean alive;
	
	public T1(){
		alive = true;
		start();
	}
	
	@Override
	public void run(){
		while(alive){
			System.out.println("Tråd 1");
			try{
				sleep(1000);
			}catch(InterruptedException e){
				System.err.println("tråd avbröts");
			}
		}
	}
	
	public static void main(String[] args){
		
	}
	
	public void setAlive(boolean bool){
		alive = bool;
	}

}