package A_WorkingWithAbstraction.Exercises.JediGalaxy;

class Galaxy {
    private int[][] matrix;

    Galaxy(int rows, int cols) {
        this.matrix = new int[rows][cols];
    }

    void init(int startValue){
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] = startValue++;
            }
        }
    }

    int getDiagonal(int row, int col) {
        int sumPoints = 0;

        while (row >= 0 && col < this.matrix[0].length) {
            if (isValid(row, col)) {
                sumPoints += this.matrix[row][col];
            }
            row--;
            col++;
        }
        return sumPoints;
    }

    void destroyDiagonalByEvil(int row, int col) {
        while (row >= 0 && col >= 0) {
            if (isValid(row, col)) {
                matrix[row][col] = 0;
            }
            row--;
            col--;
        }
    }

    private boolean isValid(int row, int col) {
        return row >= 0 && col >= 0 && row < this.matrix.length && col < this.matrix[0].length;
    }
}
