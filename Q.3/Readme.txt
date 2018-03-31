First we ake input from the user about the matrix and the element to be searched.Then a funtion search() is called which goes through the matrix ans searches the element.

In the search function we use the property of the given matrix that the matrix is row-wise and column-wise sorted, and we start from the end of first row.
By using this approach, we solve the problem of having to make two decisions, as from where we start, if the search element is smaller, we will only have to go to left side and if the element is greater , we will only go down.

This solves the problem in starting at 0,0 position as then if the search element is greater, we can go both in right and down directions, and also our code complexity reduces from O(n^2) to O(n).
