package com.company;

public class RotateImage {


  //TC O(n2) SC : O(1)
  public void rotate(int[][] matrix) {

    int length = matrix.length;


    for(int cycle = 0; cycle < (length +1 ) /  2; cycle++) {

      for(int pointer = 0; pointer < length  / 2; pointer++) {


        int leftUpCorner = matrix[cycle] [pointer];
        int rightUpCorner =  matrix [pointer] [length - cycle - 1];
        int leftDownCorner = matrix[length - pointer - 1] [cycle];
        int rightDownCorner = matrix [length - cycle - 1] [length - pointer - 1];



        matrix[cycle] [pointer] = leftDownCorner;
        matrix[length - pointer - 1] [cycle]  = rightDownCorner;
        matrix [pointer] [length - cycle - 1] = leftUpCorner;
        matrix [length - cycle - 1] [length - pointer - 1] = rightUpCorner;

      }

    }


  }

}
