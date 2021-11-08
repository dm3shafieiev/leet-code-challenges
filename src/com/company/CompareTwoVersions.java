package com.company;

import java.util.ArrayList;
import java.util.List;

public class CompareTwoVersions {

  //TC: O(n+m) SC: O(n)
  public int compareVersion(String version1, String version2) {

    char [] v1 = version1.toCharArray();
    char [] v2 = version2.toCharArray();

    List<Integer> revisionList1 = convertToListOfRevisions(v1);
    List<Integer> revisionList2 = convertToListOfRevisions(v2);

    int size = Math.max(revisionList1.size(), revisionList2.size());

    for(int pointer = 0; pointer < size; pointer++) {

      Integer num1 = pointer < revisionList1.size() ? revisionList1.get(pointer) : 0;
      Integer num2 = pointer < revisionList2.size() ? revisionList2.get(pointer) : 0;

      if(num1.compareTo(num2) != 0) {
        return num1.compareTo(num2);
      }
    }


    return 0;

  }

  private List<Integer> convertToListOfRevisions(char[] versionArray) {

    List<Integer> revisionList = new ArrayList<>();
    revisionList.add(0);

    int list1Pointer = 0;

    for (char c : versionArray) {

      if ('.' == c) {
        revisionList.add(0);
        list1Pointer++;
      } else {
        revisionList.set(list1Pointer, revisionList.get(list1Pointer) * 10 + (c - '0'));
      }

    }
    return revisionList;
  }

}
