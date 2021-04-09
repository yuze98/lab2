
interface Addable  {

public Object ADD(Object secondTerm);

};

class Matrix implements Addable {

public Integer [][]Numbers; // 2D array
public int M,N; // M rows and N columns

public Matrix(int m,int n)
{
    M=m;
    N=n;
    Numbers = new Integer [m][n];

}

public Object ADD(Object secondMat) // not specified well enough
{
    Matrix sum = new Matrix(this.M,this.N);
    
    if(((Matrix)secondMat).N == this.N && ((Matrix)secondMat).M == this.M)
    {
        for(int i = 0;i<this.M;i++)
        {
            for(int j = 0;j<this.N;j++)
            {
                sum.Numbers[i][j] = ((Matrix)secondMat).Numbers[i][j] + this.Numbers[i][j];
            }
        }
    }
    return sum;
}
public Boolean setNumbers(Integer [] arr)
{

    int k =0;

   for(int i=0;i<this.N;i++) // columns
    {
        for(int j =0;j<this.M;j++) //rows
        {
            if(k<arr.length)
                this.Numbers[j][i] = arr[k];
                k++;
                
        }
    }

        if(arr.length == this.N*this.M)
        {
            return true;
        }
        else
        {
            return false;
        }
}

public void print()
{
    for(int k=0;k<this.N;k++) //rows
    {
        for (int i =0;i<this.M;i++) //columns
        {
                System.out.print(this.Numbers[i][k]+" ");
        }
        System.out.println(" ");
      
    }

}

public void transpose()
{
    int newM,newN; //rowsXcolumns
    newN = this.M;//2
    newM = this.N;//3
    Integer [][] NumbersT = new Integer[newM][newN];//new transposed matrix

    for(int i =0;i<this.N;i++)
    {
        for(int j =0;j<this.M;j++)
        {
            NumbersT[i][j] = Numbers[j][i];
        }
    }

    this.M=newM;
    this.N=newN;
    Numbers=NumbersT;

}

};

class IdentityMatrix extends Matrix{

public IdentityMatrix(int m,int n)
{
    super(m, n);
}

@Override

public Boolean setNumbers(Integer [] arr) //sets the numbers and checks if it is identity or not
{
    Matrix mat = new Matrix(this.M, this.N);
    mat.setNumbers(arr);
    
    //checks for identity

    if(this.N != this.M) //squared
        return false;

    //checks for identity 1's and 0's

    for(int i=0;i<this.N;i++) // columns
    {
        for(int j =0;j<this.M;j++) //rows
        {
            if((mat.Numbers[i][j]!=1 && i==j) || (mat.Numbers[i][j] != 0 && i!=j))
                return false;

        }
    }

    super.setNumbers(arr);

        return true;
}

@Override

public void transpose()
{
    int newM,newN; //rowsXcolumns
    newN = this.M;//2
    newM = this.N;//3
    Integer [][] NumbersT = new Integer[newM][newN];//new transposed matrix

    for(int i =0;i<this.N;i++)
    {
        for(int j =0;j<this.M;j++)
        {
            NumbersT[i][j] = Numbers[j][i];
        }
    }

    this.M=newM;
    this.N=newN;
    Numbers=NumbersT;

}

};


class MainApp{
 public static void main(String[] args) 
 {
     int m = 2;
     int n = 2;
 
     Integer []arr = {1,2,3,4,5,6};
     Integer []arradd = {6,5,4,3,2,1};
     //identity tests
     Integer []idtest1 = {1,2,3,4}; 
     Integer []idtest2 = {1,0,0,1};
     Integer []idtest3 = {1,2,3,4,5,6}; 
     

     Matrix matadd = new Matrix(2, 3);
 
     Matrix mat = new Matrix(2, 3);
     IdentityMatrix idmat = new IdentityMatrix(m, n);
     IdentityMatrix idmat0 = new IdentityMatrix(2, 3);

     System.out.println("setting matrix : " + mat.setNumbers(arr));
     matadd.setNumbers(arradd);
 
     mat.print();

     System.out.println("testing transpose: ");
     mat.transpose();
     mat.print();

     mat.transpose();

     System.out.println("---------------------");

     Boolean b1= idmat.setNumbers(idtest1);
     idmat.print();
     System.out.println("idtest1 " +b1);

     System.out.println("---------------------");

     Boolean b2 =idmat.setNumbers(idtest2);
     idmat.print();
     System.out.println("idtest2 " +b2);

     System.out.println("---------------------");

     Boolean b3= idmat0.setNumbers(idtest3);
     idmat0.print();
     System.out.println("idtest3 " +b3);

     System.out.println("---------------------");

     System.out.println("Testing the ADDABLE function :");
     System.out.println("mat1 ");
     mat.print();

     System.out.println("mat2 ");
     matadd.print();

     System.out.println("mat1 + mat2 ");
     ((Matrix)((Matrix)mat).ADD(matadd)).print();

 
 }
};