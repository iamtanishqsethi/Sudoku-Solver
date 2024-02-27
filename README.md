# Sudoku Solver

This is a Java program for solving Sudoku puzzles using the backtracking algorithm.

## Introduction

Sudoku is a popular puzzle game where you need to fill a 9x9 grid with digits so that each column, each row, and each of the nine 3x3 subgrids that compose the grid contain all of the digits from 1 to 9. This program provides a solution to Sudoku puzzles using a backtracking algorithm.

## How to Use

To use the Sudoku solver, you can follow these steps:

1. Compile the Java program.
2. Create a 2D array representing the Sudoku puzzle you want to solve. Use `0` to represent empty cells.
3. Call the `solve` method, passing the Sudoku puzzle as an argument.
4. If a solution is found, the solved Sudoku puzzle will be updated in place. If no solution is found, the original puzzle will remain unchanged.

## Code Explanation

The main components of the code are:

- `solve(int[][] board)`: This method takes a 2D array representing the Sudoku board and attempts to solve the puzzle recursively using backtracking.
- `display(int[][] board)`: This method prints the Sudoku board to the console.
- `isSafe(int[][] board, int row, int col, int num)`: This method checks if it's safe to place a number in a specific cell of the Sudoku board.

## Example

Here's an example of how to use the Sudoku solver:

```java
int[][] board = {
    {5, 3, 0, 0, 7, 0, 0, 0, 0},
    {6, 0, 0, 1, 9, 5, 0, 0, 0},
    {0, 9, 8, 0, 0, 0, 0, 6, 0},
    {8, 0, 0, 0, 6, 0, 0, 0, 3},
    {4, 0, 0, 8, 0, 3, 0, 0, 1},
    {7, 0, 0, 0, 2, 0, 0, 0, 6},
    {0, 6, 0, 0, 0, 0, 2, 8, 0},
    {0, 0, 0, 4, 1, 9, 0, 0, 5},
    {0, 0, 0, 0, 8, 0, 0, 7, 9}
};

solve(board);
display(board);

//Output
5 3 4 6 7 8 9 1 2 
6 7 2 1 9 5 3 4 8 
1 9 8 3 4 2 5 6 7 
8 5 9 7 6 1 4 2 3 
4 2 6 8 5 3 7 9 1 
7 1 3 9 2 4 8 5 6 
9 6 1 5 3 7 2 8 4 
2 8 7 4 1 9 6 3 5 
3 4 5 2 8 6 1 7 9 
