class FirstThread{
	public static void main(String args[]){
		Thread ct = Thread.currentThread();
		ct.setName("MyThread");
		System.out.println(ct);
		ct.setPriority(5);
		System.out.println(ct);
		System.out.println(Thread.MIN_PRIORITY);
		System.out.println(Thread.NORM_PRIORITY);
		System.out.println(Thread.MAX_PRIORITY);
		for(int j=0;j<=10;j++){
			System.out.println("Hai");
		}
		for(int i=1;i<=10;i++){
			System.out.println("Main"+i);
			try{
				Thread.sleep(700);
			}catch(InterruptedException e){
			}
		}
	}
}