class Heart extends Thread{
	Thread th = new Thread();
	public void run(){
		int ti = 0;
		int tj = 0;
		int t  = 0;
		ti = 11;
		tj = 15;
		t = tj/2;
		try{
			for(int i = 0; i < ti; i++){
				//th.sleep(100);
				Thread.sleep(100);
				for(int j = 0; j < tj; j++){
					if(i==0){
						if(j==(t-t/2) || j==(t-t/3) || j==(t+t/3) || j==(t+t/2)){
							System.out.print("*");
						}else{
							System.out.print(" ");
						}
					}else if(i<(t-4)){
						if(j==(t-(t/2)-1)-i || j==(t+(t/2)+1)+i || j==(t-t/3)+i || j==(t+2)-i){
							System.out.print("*");
						}else{
							System.out.print(" ");
						}
					}else if(i>(t-5)){
						if(j==i-3 || j==(tj-i+2)){
							System.out.print("*");
						}else{
							System.out.print(" ");
						}

					}
				}
				System.out.println();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String args[]){
		Heart th = new Heart();
		th.start();

	}
}