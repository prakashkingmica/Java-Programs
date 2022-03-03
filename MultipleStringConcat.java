//Developed by Prakash V
import java.io.*;
class MultipleStringConcat{
	public static void main(String[] args)throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\n********* Developed by Prakash V *********");
Loop1:	for(int a=1;a<2;a++){
			System.out.print("\nHow many Strings do u want to concardinate  : ");
			String str1 = null;
			String str2 = null;
			String ct   = null;
			try{
				int c = Integer.parseInt(bf.readLine());
Loop2:			for(int j=1;j<2;j++){
					if(c>1){
						System.out.print("Enter the 1st String : ");
						str1 = bf.readLine();
						if(str1.equals("")){
							System.out.println("Please enter String\n");
							j--;
							continue Loop2;
						}else{
Loop3: 						for(int k=1;k<2;k++){
								System.out.print("Enter the 2nd String : ");
								str2 = bf.readLine();
								if(str2.equals("") ){
									System.out.println("Please enter String\n");
									k--;
									continue Loop3;
								}else{
									String Game = str1.concat(str2);
									for(int i=3;i<=c;i++){
										System.out.print("Enter the "+i+"th String : ");
										String str = bf.readLine();
										if(str.equals("")){
											System.out.println("Please enter String\n");
											i--;
										}else{
											Game = Game.concat(str);
										}
									}
									System.out.println("\nResulted String is : "+Game+"\n");
Loop4:								for(int z=1;z<2;z++){
										System.out.print("Do u want to continue (Y/N)? : ");
										ct = bf.readLine().toUpperCase();
										if(ct.equals("Y")){
											a--;
											continue Loop1;
										}else if(ct.equals("N")){
											System.out.println("Bye......");
											break Loop1;
										}else{
											z--;
											continue Loop4;
										}
									}
								}
							}
						}
					}else{
						System.out.println("Please enter more than one Strings...\n");
						a--;
						continue Loop1;
					}
				}
			}catch(Exception e){
				System.out.println("Please enter number only\n");
				a--;
				continue Loop1;
			}
		}
	}
}