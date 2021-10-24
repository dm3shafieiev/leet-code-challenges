package com.company;

public class MergeSortedArrays {

  public void merge(int[] nums1, int m, int[] nums2, int n) {

    int [] nums1aux = new int [m];

    for(int i = 0; i < m; i++) {
      nums1aux[i] = nums1[i];
    }

    int i = 0;
    int j = 0;


    for (int k = 0; k < nums1.length; k++) {

      if(i >= m || (j < n && nums1aux[i] > nums2[j]) ) {
        nums1[k] = nums2[j++];
      }else {
        nums1[k] = nums1aux[i++];
      }

    }

//TC: O(m+n) SC: O(m)



  }

}
