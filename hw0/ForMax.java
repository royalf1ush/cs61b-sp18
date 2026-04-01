
public class ForMax {
    /** Returns the maximum value from m. */
    public static int max(int[] m) {
	int max=0;
	for(int index=0;index<m.length;index+=1)
	{
		if(m[index]>max)
		{
			max=m[index];
		}
	}
	System.out.println(max);
        return 0;
    }
    public static void main(String[] args) {
       int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6}; 
       max(numbers);  
    }
}