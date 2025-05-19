package day13_work;

import java.util.ArrayList;
import java.util.List;

public class id_2397_1 {
    private List<Integer> path = new ArrayList<Integer>();

    private int sum = 0;

    public int maximumRows(int[][] matrix, int numSelect) {
        f(0,matrix,numSelect);
        return sum;
    }

    public void f(int i,int[][] matrixint, int numSelect){
        if(path.size() == numSelect){
            int n1 = 0;
            for(int m = 0; m < matrixint.length; m++){
                boolean is = true;
                for(int n = 0; n < matrixint[m].length; n++){
                    if(path.contains(n)){
                        return;
                    }else {
                        if(matrixint[m][n] == 1){
                            is = false;
                            break;
                        }
                    }
                }
                if(is) n1 += 1;
            }
            sum = Math.max(sum,n1);
            return;
        }
        for(int j = i; j < matrixint[1].length; j++){
            path.add(j);
            f(j+1,matrixint,numSelect);
            path.remove(path.size()-1);
        }
    }

}
