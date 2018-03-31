// Java code to perform add,
// multiply and transpose on sparse matrices
import java.util.Scanner;


public class sparse_matrix {


	int MAX = 100;
	int data[][] = new int[MAX][3];
	int row, col;
	int len;
	public sparse_matrix(int r, int c)
	{
		row = r;
		col = c;
		len = 0;
	}

	public void insert(int r, int c, int val)
	{
		if (r > row || c > col) {
			System.out.println("Wrong entry");
		}

		else {
			data[len][0] = r;
			data[len][1] = c;
			data[len][2] = val;
			len++;
		}
	}

	public void Convolution(sparse_matrix b)
	{

		if (row != b.row || col != b.col) {
			System.out.println("Matrices can't be Convoluted");
		}

		else {

			int apos = 0, bpos = 0;
			sparse_matrix result = new sparse_matrix(row, col);

			while (apos < len && bpos < b.len) {

				if (data[apos][0] > b.data[bpos][0] ||
				(data[apos][0] == b.data[bpos][0] &&
				data[apos][1] > b.data[bpos][1]))

				{



					bpos++;
				}

				else if (data[apos][0] < b.data[bpos][0] ||
				(data[apos][0] == b.data[bpos][0] &&
				data[apos][1] < b.data[bpos][1]))

				{

					apos++;
				}

				else {

					int addedval = data[apos][2] * b.data[bpos][2];


					result.insert(data[apos][0],
					data[apos][1],
					addedval);
					apos++;
					bpos++;
				}
			}
			result.print();
		}
	}

	public sparse_matrix transpose()
	{

		sparse_matrix result = new sparse_matrix(col, row);
		result.len = len;
		int count[] = new int[col + 1];
		for (int i = 1; i <= col; i++)
		count[i] = 0;

		for (int i = 0; i < len; i++)
		count[data[i][1]]++;

		int[] index = new int[col + 1];
		index[1] = 0;
		for (int i = 2; i <= col; i++)

		index[i] = index[i - 1] + count[i - 1];

		for (int i = 0; i < len; i++) {

			int rpos = index[data[i][1]]++;
			result.data[rpos][0] = data[i][1];
			result.data[rpos][1] = data[i][0];
			result.data[rpos][2] = data[i][2];
		}
		return result;
	}

	public void multiply(sparse_matrix b)
	{

		if (col != b.row) {
			System.out.println("Can't multiply, "+ "Invalid dimensions");

			return;
		}
		b = b.transpose();
		int apos, bpos;
		sparse_matrix result = new sparse_matrix(row, b.row);

		for (apos = 0; apos < len;) {

			int r = data[apos][0];
			for (bpos = 0; bpos < b.len;) {

				int c = b.data[bpos][0];

				int tempa = apos;
				int tempb = bpos;

				int sum = 0;

				while (tempa < len && data[tempa][0] == r
				&& tempb < b.len && b.data[tempb][0] == c) {

					if (data[tempa][1] < b.data[tempb][1])
					tempa++;

					else if (data[tempa][1] > b.data[tempb][1])
						tempb++;
					else
					sum += data[tempa++][2] * b.data[tempb++][2];
				}
				if (sum != 0)
				result.insert(r, c, sum);

				while (bpos < b.len && b.data[bpos][0] == c)

				bpos++;
			}

			while (apos < len && data[apos][0] == r)

			apos++;
		}

		result.print();
	}

	// printing matrix
	public void print()
	{
		System.out.println("Dimension: " + row + "x" + col);
		System.out.println("Sparse Matrix: \nRow Column Value");

		for (int i = 0; i < len; i++) {

			System.out.println(data[i][0] + " "
			+ data[i][1] + " " + data[i][2]);
		}
	}

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the value of n");
		int n = sc.nextInt();
		// create two sparse matrices and insert values
		sparse_matrix a = new sparse_matrix(n, n);
		sparse_matrix b = new sparse_matrix(n, n);

		System.out.println("Enter the value of m1 ");
		int m1 = sc.nextInt();
		System.out.println("Enter the value of m2");
		int m2 = sc.nextInt();

		System.out.println("Enter data for matrix 1");
		for(int i=0;i<m1;i++)
		{
			System.out.println("Enter row,col,data");
			int r,c,v;
			r= sc.nextInt();
			c= sc.nextInt();
			v= sc.nextInt();
			a.insert(r,c,v);
		}
		System.out.println("Enter data for matrix 2");
		for(int i=0;i<m2;i++)
		{
			System.out.println("Enter row,col,data");
			int r,c,v;
			r= sc.nextInt();
			c= sc.nextInt();
			v= sc.nextInt();
			b.insert(r,c,v);
		}

		// Output result
		System.out.println("Convolution ");
		a.Convolution(b);
		System.out.println("\nMultiplication: ");
		a.multiply(b);

	}
}
