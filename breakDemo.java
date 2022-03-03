package pra;
class breakDemo{
	public static void main(String args[]){
		boolean f=true;
		boolean t=true;
		first:
		{
			second:
			{
				third:
				{
					System.out.println("Before the break");
					if(t){
						if(f){
							break third;
						}
					break second;
					}
					System.out.println("This won't execute");
				}
				System.out.println("This's second execute");
			}
			System.out.println("This's after second block");
		}
	}
}