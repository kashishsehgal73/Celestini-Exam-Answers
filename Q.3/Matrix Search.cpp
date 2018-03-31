#include<iostream>
using namespace std;

int search(int mat[100][100],int m, int n, int x)
{
    int i=0, j=n-1;//set indexes for top right element
    while ( i < m && j >= 0 )
    {
        if ( mat[i][j] == x )
        {
            cout<<"\nElement found at "<<i<<" "<<j;
            return 1;
        }
        if ( mat[i][j] > x )
        j--;
        else //  if mat[i][j] < x
        i++;
    }
    cout<<"\n Element not found";
    return 0;// if ( i==n || j== -1 )
}


int main()
{
    int r,c,e,mat[100][100];
    cout<<"\nEnter number of rows and colomns";
    cin>>r>>c;
    for(int i=0; i<r ; i++)
    {
        for(int j=0; j<c; j++)
        {
            cin >>mat[i][j];
        }
    }
    cout<<"\nEnter element to be searched";
    cin >> e;
    search(mat,r,c,e);
    return 1;
}
