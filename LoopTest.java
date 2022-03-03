class LoopTest{
	static public void main(String args[]){
		int i = 32, j = 36;
		if(i < j && i > (j-10)){
			System.out.println("1.i is big");
		}
		if(i < j & i > (j-10)){
			System.out.println("2.i is big");
		}
	}
}