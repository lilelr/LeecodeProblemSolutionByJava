package note.matrix.NumberofIslands200;

import org.junit.Test;

/**
 * Created by yuxiao on 16/4/18.
 * Have the template of union.
 */
public class Solution {

    public int numIslands(char[][] grid) {
        if(grid.length==0) return 0;
        int lenCol = grid[0].length;
        int lenRow = grid.length;
        int sum=0;
        for(int i=0;i<lenRow;i++){
            for(int j=0;j<lenCol;j++){
                if(grid[i][j] == '1'){
                    sum++;
                    dps(grid,i,j,lenRow,lenCol);
                }
            }
        }
        return sum;
    }


    void dps(char[][] grid, int i, int j, int lenRow, int lenCol) {
        grid[i][j] = '0';
        if (i >= 1 && i < lenRow && grid[i - 1][j] == '1') {
            dps(grid, i - 1, j, lenRow, lenCol);
        }
        if (j >= 1 && j < lenCol && grid[i][j - 1] == '1') {
            dps(grid, i, j - 1, lenRow, lenCol);
        }
        if (i >= 0 && i <= lenRow - 2 && grid[i + 1][j] == '1') {
            dps(grid, i + 1, j, lenRow, lenCol);
        }
        if (j >= 0 && j <= lenCol - 2 && grid[i][j + 1] == '1') {
            dps(grid, i, j+1, lenRow, lenCol);
        }

    }

//    With union find, we don't need to check all 4 directions. For each cell in the grid it's
// sufficient to only check if current cell is connected to top or left neighbor.
//
//    Enumerate through the grid, increment the count for each found '1'. Decrement the count
// when join() results in joining two cells previously disjoined.
//
//    That's it.

    private class Node {
        public int parent;
        public int size;

        public Node (int i) {
            this.parent = i;
            this.size = 1;
        }

        public void merge (Node node) {
            if(this.size<node.size) {
                this.parent = node.parent;
            }
            else {
                node.parent = this.parent;
                if(node.size == this.size) {
                    node.size++;
                }
            }
        }
    }

    private class UnionFind {
        private Node[] nodes;
        private int height;
        public UnionFind(int size)
        {
            this.nodes = new Node[size];
            for (int i = 0; i < size; i++) {
                this.nodes[i] = new Node(i);
            }
        }

        public Node find(int x){
            Node xNode = this.nodes[x];
            while(xNode.parent !=x )
            {
                x = xNode.parent;
                xNode = this.nodes[x];
            }
            return xNode;
        }

        public boolean join(int x, int y){
            Node a = find(x);
            Node b = find(y);

            if(a.parent==b.parent) return false; //have the same parent , it is not necessary to connect.

            a.merge(b);

            return true;
        }
    }

    public int numIslandsUnion(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int count = 0;

        Index index = new Index(grid);

        UnionFind uf = new UnionFind(index.getSize());

        for(int i=0; i<index.getWidth();i++)
            for(int j=0;j<index.getHeight();j++)
            {
                if(grid[i][j] == '1')
                {
                    count++;
                    int ijValue = index.getValue(i,j);

                    if(i>0 && grid[i-1][j] == '1') //topNeighbor
                    {
                        int topNeighbor = index.getValue(i-1,j);
                        if(uf.join(ijValue,topNeighbor)) count--;
                    };
                    if(j>0 && grid[i][j-1] == '1') //leftNeighbor
                    {
                        int leftNeighbor = index.getValue(i,j-1);
                        if(uf.join(ijValue,leftNeighbor)) count--;
                    }
                }
            }

        return count;
    }

    private class Index {
        private int width;
        private int height;

        public Index(char[][] grid){
            this.width = grid.length;
            this.height = grid[0].length;
        }
        public int getWidth() { return this.width;}
        public int getHeight() { return this.height;}
        public int getSize() { return this.width*this.height;}
        public int getValue(int i, int j)
        {
            return i*this.height+j;
        }
    }

    @Test
    public void test(){

        char[][] grid = new char[2][2];
        grid[0][0] = '1';
        grid[0][1] = '0';
        grid[1][0] = '0';
        grid[1][1] = '1';
        System.out.println(numIslands(grid));
    }
}
