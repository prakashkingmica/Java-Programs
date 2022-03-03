import java.io.*;
class FlamesNew{
	public static void main(String[] args){
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter Ur Name                          : ");
			String name = br.readLine();
			StringBuffer s1 = new StringBuffer(name);
			System.out.print("Enter Ur Partner's Name                : ");
			String pname = br.readLine();
			StringBuffer s2 = new StringBuffer(pname);
			int l1 = s1.length();
			int l2 = s2.length();
			for(int i = 0; i < l1; i++){
				char c1 = s1.charAt(i);
		Loop2:	for(int j = 0; j < l2; j++){
					char c2 = s2.charAt(j);
					if(c1==c2){
						s1.deleteCharAt(i);
						s2.deleteCharAt(j);
						l1 = s1.length();
						l2 = s2.length();
						i--;
						j=0;
						break Loop2;
					}
				}
			}
			int l3 = l1 + l2;
			System.out.println("Balance Characters in Name           : "+s1);
			System.out.println("Balance Characters in Partner's Name : "+s2);
			System.out.println("Balance Characters                   : "+l3);
			StringBuffer s3 = new StringBuffer("flames");
			StringBuffer s4 = new StringBuffer();
			int f1 = s3.length();
			int j = 0;
			char c1;
			for(int i = 0; i<f1; i++){
				if(f1==1 || l3==0){
					break;
				}
				s4 = new StringBuffer(s3.toString().substring(j));
				if(l3>f1){
					int x = l3/f1;
					for(int z = 0; z < x; z++){
						s4 = s4.append(s3);
					}
				}
				s4 = s4.append(s3);
				if(f1<4){
					s4 = s4.append(s3);
				}
				c1 = s4.charAt(l3-1);
				int e = s3.toString().indexOf(c1);
				s3.deleteCharAt(e);
				f1 = s3.length();
				s4 = new StringBuffer("");
				j = e;
				i--;
			}
			System.out.println("Remaining Letter(s) in flames are "+s3);
			switch(s3.charAt(0)){
				case 'f': System.out.println(name +" and "+ pname +" are FRIENDS");
						  break;
				case 'l': System.out.println(name +" and "+ pname +" are LOVERS");
						  break;
				case 'a': System.out.println(name +" is having AFFECTION with "+ pname);
						  break;
				case 'm': System.out.println(name +" and "+ pname +" will going to get MARRIED");
						  break;
				case 'e': System.out.println(name +" and "+ pname +" are ENEMIES");
						  break;
				case 's': System.out.println(pname +" is SISTER of "+ name);
						  break;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}