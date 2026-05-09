class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String>[] rows = new HashSet[9];
        HashSet<String>[] cols = new HashSet[9];
        HashSet<String>[] boxes = new HashSet[9];

        // We did initilize
        for(int i=0; i<9; i++){
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }


        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == '.') continue; 
                int box = (i/3) * 3 + (j/3);

                String nums = String.valueOf(board[i][j]);

                if(!rows[i].add(nums)) return false;
                if(!cols[j].add(nums)) return false;
                if(!boxes[box].add(nums)) return false;
            }
        }
        return true ;
    }
}
