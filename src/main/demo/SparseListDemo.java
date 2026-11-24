package demo;

import practice.SparseList;

/** A demo of SparseList: a mostly-zero list that stores only its non-default values. */
public final class SparseListDemo {

  private SparseListDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    // A mostly-zero list of length 8 with two non-default values.
    SparseList<Integer> list = new SparseList<>(0);
    int[] values = {0, 0, 0, 5, 0, 0, 0, 2};
    for (int value : values) {
      list.add(value);
    }
    // Expect size 8 and 0, 0, 0, 5, 0, 0, 0, 2.
    System.out.println("size = " + list.size());
    System.out.print("contents: ");
    printList(list);

    // Index 3 has a stored node, so expect 5. Index 4 has none, so expect the default, 0.
    System.out.println("get(3) = " + list.get(3));
    System.out.println("get(4) = " + list.get(4));

    // set(5, 9) writes a non-default value where no node exists, so it inserts a node.
    // set(3, 0) writes the default where a node exists, so it removes that node.
    // Expect 0, 0, 0, 0, 0, 9, 0, 2.
    list.set(5, 9);
    list.set(3, 0);
    System.out.print("after set(5,9) and set(3,0): ");
    printList(list);

    // Expect 5, then true, then false.
    System.out.println("indexOf(9) = " + list.indexOf(9));
    System.out.println("remove(9) = " + list.remove(9));
    System.out.println("contains(9) = " + list.contains(9));

    // Removing 9 shifts the later positions down. Expect 0, 0, 0, 0, 0, 0, 2.
    System.out.print("final contents: ");
    printList(list);
  }

  private static void printList(SparseList<Integer> list) {
    for (int i = 0; i < list.size(); i++) {
      if (i < list.size() - 1) {
        System.out.print(list.get(i) + ", ");
      } else {
        System.out.print(list.get(i));
      }
    }
    System.out.println();
  }
}
