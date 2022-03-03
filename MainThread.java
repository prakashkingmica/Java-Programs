class ChildThread implements Runnable{
	Thread t1;
	ChildThread(){
		t1 = new Thread(this);//new State
		t1.setName("Child");
		System.out.println(t1);
		t1.start();//ready state
	}
	//Running State
	public void run(){
		for(int i=1;i<=10;i++){
			System.out.println("Child");
			try{
				Thread.sleep(1000);//blocked State
			}catch(Exception e){
			}
		}
	}
}
class MainThread{
	public static void main(String args[]){
		ChildThread t1 = new ChildThread();
		for(int i=1;i<=10;i++){
			System.out.println("Main"+i);
			try{
				Thread.sleep(1000);
			}catch(Exception e){
			}
		}
	}
}