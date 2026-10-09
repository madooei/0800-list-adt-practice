package practice;

/**
 * A runnable demo of the practice problem: SparseList, a third implementation of
 * the List ADT. It builds a mostly-zero list, reads stored and default
 * positions, writes values that add and remove nodes, and searches it.
 */
public final class SparseListDemo {

  private SparseListDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    // A mostly-zero list of length 8 with two non-default values.
    SparseList<Integer> list = new SparseList<>(0);
    int[] values = {0, 0, 0, 5, 0, 0, 0, 2};
    for (int v : values) {
      list.add(v);
    }
    System.out.println("size = " + list.size());
    System.out.print("contents: ");
    printList(list);

    System.out.println("get(3) = " + list.get(3));   // 5, stored
    System.out.println("get(4) = " + list.get(4));   // 0, default

    list.set(5, 9);   // a non-default value where no node exists: insert
    list.set(3, 0);   // the default value where a node exists: remove
    System.out.print("after set(5,9) and set(3,0): ");
    printList(list);

    System.out.println("indexOf(9) = " + list.indexOf(9));
    System.out.println("remove(9) = " + list.remove(9));
    System.out.println("contains(9) = " + list.contains(9));
    System.out.print("final contents: ");
    printList(list);
  }

  static void printList(SparseList<Integer> list) {
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
