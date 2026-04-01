
public class DrawTriangle
{
	public static void main(String[] args)
	{		
		DrawTriangle(10);
	}
	public static void DrawTriangle(int N)
	{
		int row = 0;
		int SIZE = N;
		while (row <SIZE)
		{
			int col = 0;
			while (col <= row) 
			{
				System.out.print('*');
				col = col + 1;
			}
			System.out.println();
			row = row + 1;
		}
	}
}