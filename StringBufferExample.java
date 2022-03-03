public class StringBufferExample{
	public static void main(String[] args) {
		StringBuffer strBuffer1 = new StringBuffer("Bonjour");
		StringBuffer strBuffer2 = new StringBuffer(60);
		StringBuffer strBuffer3 = new StringBuffer();

		System.out.println("strBuffer1 : " +strBuffer1);
		System.out.println("strBuffer2 capacity : " +strBuffer2.capacity());
		System.out.println("strBuffer3 capacity : " +strBuffer3.capacity());
	}
}