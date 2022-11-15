public class T2 implements Runnable{
	
	Thread t = new Thread(this);
	private boolean alive;
	
	public T2(){
		alive = true;
		t.start();
	}
	
	@Override
	public void run(){
		while(alive){
			System.out.println("Tråd 2");
			try{
				t.sleep(1000);
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