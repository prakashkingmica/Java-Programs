import java.io.*;
class PolyndromeExample{
	public static void main(String[] a){
		BufferedReader br = null;
		try{
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("\nEnter The Word  : ");
			StringBuffer s1 = new StringBuffer(br.readLine());
			int l1 = s1.length();
		Loop1:for(int i = 0; i < l1; i++){
				char first = s1.charAt(i);
		Loop2:	for(int j = l1-1-i; j > 0; j--){
					char last = s1.charAt(j);
					if(first==last){
						if(i==j){
							System.out.println("\nThat Word is Polyndrome");
							break Loop1;
						}else
							continue Loop1;
					}else{
						System.out.println("\nThat Word is not Polyndrome");
						break Loop1;
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}