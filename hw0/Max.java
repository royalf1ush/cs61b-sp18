
public class Max {
    /** Returns the maximum value from m. */
    public static int max(int[] m) {
	int max=0;
	int index=0;
	while(index<m.length)
	{
		if(m[index]>max)
		{
			max=m[index];
		}
		index=index+1;
	}
	System.out.println(max);
        return 0;
    }
    public static void main(String[] args) {
       int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6}; 
       max(numbers);  
    }
}