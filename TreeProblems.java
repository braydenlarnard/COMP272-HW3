/*
 * *** Brayden Larnard / COMP 272-002 ***
 *
 * This java file contains several simple tree problems that need to be
 * codified. These routines  must use the TreeMap and TreeSet library
 * classes from the Java Collection Framework.
 *
 */

import java.util.*;

public class TreeProblems {

  /**
   * Method different()
   *
   * Given two TreeSets of integers, return a TreeSet containing all elements 
   * that are NOT in both sets. In other words, return a TreeSet of all the
   * elements that are in one set but not the other.
   */
  
  public static Set<Integer> different(Set<Integer> setA, Set<Integer> setB) {

    //
    // This can be done numerous ways, but once such will only that
    // *several* lines of code. Hint: create two temporary TreeSets and utilize the
    // methods retainAll(), addAll(), and removeAll(). But in the end, get something to work.

    // Create two temporary treesets
    Set<Integer> tempA = new TreeSet<>(setA);
    Set<Integer> tempB = new TreeSet<>(setB);

    // Remove all B contents from the A copy
    tempA.removeAll(setB);
    // Remove remaining A contents from the B copy, this will leave only the unique contents
    tempB.removeAll(setA);
    // Add the unique contents of B to the unique contents of A and return that
    tempA.addAll(tempB);
    return tempA;
  }


  /**
   * Method removeEven()
   *
   * Given a treeMap with the key as an integer, and the value as a String,
   * remove all <key, value> pairs where the key is even. 
   */

  public static void removeEven(Map<Integer, String> treeMap) {

    // Create a temporary treeset to hold the keys to remove
    Set<Integer> keysToRemove = new TreeSet<>();
    // Use a for each loop to find the even keys and add them to the temporary treeset
    for (Integer key : treeMap.keySet()) {
      if (key % 2 == 0) {
        keysToRemove.add(key);
      }
    }

    // Use the removeAll() method to remove all the even keys from the original treemap
    treeMap.keySet().removeAll(keysToRemove);
    return;
  }


  /**
   * Method treesEqual()
   *
   * Given two treeMaps, each with the key as an integer, and the value as a String,
   * return a boolean value indicating if the two trees are equal or not.
   */

  public boolean treesEqual(Map<Integer, String> tree1,Map<Integer, String> tree2 ) {

    // If the sizes of the two maps are not equal, they cannot be equal
    if (tree1.size() != tree2.size()) {
      return false;
    }

    // Use a for each loop to iterate through the first map and get its key/value pairs
    for (Map.Entry<Integer, String> entry : tree1.entrySet()) {
      Integer key = entry.getKey();
      String value = entry.getValue();

      // Check if the key exists in the second map and if the values are equal. If they are not at any point return false
      if (!tree2.containsKey(key) || !tree2.get(key).equals(value)) {
        return false;
      }
    }

    return true;

  }

} // end treeProblems class
