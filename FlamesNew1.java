import java.io.*;
class FlamesNew1{
	public static void main(String[] args){
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter Ur Name                          : ");
			String name = br.readLine().toLowerCase();
			StringBuffer s1 = new StringBuffer(name);
			System.out.print("Enter Ur Partner's Name                : ");
			String pname = br.readLine().toLowerCase();
			StringBuffer s2 = new StringBuffer(pname);
			int l1 = s1.length();
			int l2 = s2.length();
			for(int i = 0; i < l1; i++){
				char c1 = s1.charAt(i);
		Loop2:	for(int j = 0; j < l2; j++){
					char c2 = s2.charAt(j);
					if(c1 == c2){
						s1.deleteCharAt(i);
						s2.deleteCharAt(j);
						l1 = s1.length();
						l2 = s2.length();
						i--;
						j=0;
						//System.out.println("Deleted Character is   : "+c1);
						break Loop2;
					}
				}

			}
			int l3 = l1 + l2;
			//System.out.println("Balance Characters in Name           : "+s1);
			//System.out.println("Balance Characters in Partner's Name : "+s2);
			//System.out.println("Balance Characters                   : "+l3);
			StringBuffer s3 = new StringBuffer("flames");
			StringBuffer s4 = new StringBuffer();
			int f1 = s3.length();
			int j = 0;
			int k = 0;
			int l =0;
			char c1;
			for(int i = 0; i<f1; i++){
				//System.out.println("l3 is "+l3);
				//System.out.println("f1 is "+f1);

				if(f1==1 || l3==0){
					break;
				}
				if(l3>f1){
					k = l3/f1;
					l = l3%f1;
					s4 = new StringBuffer(s3.toString().substring(j));
					for(int x=0; x<k; x++){
						s4 = new StringBuffer(s4.toString() + s3.toString());
					}
					if(l>0){
						s4 = new StringBuffer(s4.toString() + s3.toString());
					}
					//System.out.println(s4);
					c1 = s4.charAt(l3-1);
					int e = s3.toString().indexOf(c1);
					//System.out.println("Deleted Char is            : "+s3.charAt(e));
					s3.deleteCharAt(e);
					f1 = s3.length();
					s4 = new StringBuffer("");
					j = e;
				}else{
					//System.out.println(l3);
					s4 = new StringBuffer(s3.toString().substring(j)+s3.toString());
					//System.out.println("s4===========> "+s4);
					if(l3>0){
						c1 = s4.charAt(l3-1);
						//System.out.println("1. c1 is "+c1);
					}else{
						c1 = s4.charAt(l3);
						//System.out.println("2. c1 is "+c1);
					}
					int e = s3.toString().indexOf(c1);
					//System.out.println("e is "+e);
					s3.deleteCharAt(e);
					f1 = s3.length();
					s4 = new StringBuffer("");
					j = e;
				}
				i--;
			}
			//System.out.println("Remaining Letter is "+s3);
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
				case 's': System.out.println(pname +" and "+ name + " are BROTHER and SISTER");
						  break;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}