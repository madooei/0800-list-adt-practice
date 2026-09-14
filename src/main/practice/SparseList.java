package practice;

import java.util.Objects;

import listadt.List;

/**
 * An implementation of the List ADT where nearly every position holds the same default value.
 *
 * @param <T> the type of element stored in this list.
 */
public class SparseList<T> implements List<T> {

  private Node<T> head;     // front sentinel; the real nodes follow it
  private T defaultValue;   // the value assumed at any position we do not store
  private int size;         // the logical length of the list

  public SparseList(T defaultValue) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  @Override
  public int size() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  @Override
  public void add(T value) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  @Override
  public T get(int index) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  @Override
  public void set(int index, T value) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  @Override
  public int indexOf(T value) {
    // Scan logical positions 0..size-1, reading each from the node chain or the
    // default, and return the first that matches.
    Node<T> current = head.next;
    for (int i = 0; i < size; i++) {
      T atI;
      if (current != null && current.index == i) {
        atI = current.value;
        current = current.next;
      } else {
        atI = defaultValue;
      }
      if (Objects.equals(value, atI)) {
        return i;
      }
    }
    return -1;
  }

  @Override
  public boolean contains(T value) {
    return indexOf(value) != -1;
  }

  @Override
  public boolean remove(T value) {
    int index = indexOf(value);
    if (index == -1) {
      return false;
    }
    removeAt(index);
    return true;
  }

  // Return the last node whose index is below the given index (the sentinel if
  // none qualify), so its next field is the node the caller should inspect.
  // Pre: index is valid (checked by the public caller).
  private Node<T> findNodeBeforeTarget(int index) {
    Node<T> prev = head;
    while (prev.next != null && prev.next.index < index) {
      prev = prev.next;
    }
    return prev;
  }

  // Remove logical position index, closing the gap: drop the node there if one
  // exists, then shift every later node's index down by one.
  private void removeAt(int index) {
    Node<T> prev = findNodeBeforeTarget(index);
    Node<T> current = prev.next;
    if (current != null && current.index == index) {
      prev.next = current.next;   // unlink the node sitting at index
      current = current.next;
    }
    while (current != null) {
      current.index--;            // later positions all slide one earlier
      current = current.next;
    }
    size--;
  }

  private static class Node<T> {
    int index;     // the position this value occupies in the list
    T value;       // the non-default value stored at that position
    Node<T> next;

    Node(int index, T value) {
      this.index = index;
      this.value = value;
    }
  }
}
