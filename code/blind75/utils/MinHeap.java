package code.blind75.utils;

import java.util.Arrays;


public class MinHeap {
  private int[] heap;
  private int size;
  private static final int DEFAULT_CAPACITY = 10;

  MinHeap() {
    heap = new int[DEFAULT_CAPACITY];
    size = 0;
  }

  public void insert(int element) {
    ensureHeapCapacity();
    heap[size++] = element;
    heapifyUp();
  }

  public int extractMin() {
    if (isEmpty()) {
      System.out.println("Heap is empty");
      return Integer.MIN_VALUE;
    }
    int min = heap[0];
    heap[0] = heap[size-1];
    size--;
    heapifyDown();
    return min;
  }

  private boolean isEmpty() {
    return size == 0;
  }

  private void heapifyDown() {
    int index = 0;
    while (hasLeftChild(index)) {
      int smallerChildIndex = getLeftChildIndex(index);

      if (hasRightChild(index) && getRightChild(index) < getLeftChild(index)) {
        smallerChildIndex = getRightChildIndex(index);
      }

      if (heap[index] < heap[smallerChildIndex]) {
        break;
      } else {
        swap(index, smallerChildIndex);
      }
      index = smallerChildIndex;
    }
  }

  private void heapifyUp() {
    int index = size - 1;
    while (hasParent(index) && heap[index] < getParent(index)) {
      swap(index, getParentIndex(index));
      index = getParentIndex(index);
    }
  }

  private void swap(int a, int b) {
    int temp = heap[a];
    heap[a] = heap[b];
    heap[b] = temp;
  }

  private boolean hasParent(int index) {
    return index > 0;
  }

  private int getParentIndex(int index) {
    return (index - 1)/2;
  }

  private int getParent(int index) {
    return heap[getParentIndex(index)];
  }

  private boolean hasLeftChild(int index) {
    return getLeftChildIndex(index) < size ;
  }

  private int getLeftChildIndex(int index) {
    return (2 * index) + 1;
  }

  private int getLeftChild(int index) {
    return heap[getLeftChildIndex(index)];
  }

  private boolean hasRightChild(int index) {
    return getRightChildIndex(index) < size;
  }

  private int getRightChildIndex(int index) {
    return (2 * index ) + 2;
  }

  private int getRightChild(int index) {
    return heap[getRightChildIndex(index)];
  }

  private void ensureHeapCapacity() {
    if (size == DEFAULT_CAPACITY) {
      this.heap = Arrays.copyOf(heap, DEFAULT_CAPACITY * 2);
    }
  }

  private int getHeapSize() {
    return this.size;
  }

  public static void main(String[] args) {
    MinHeap minHeap = new MinHeap();
    minHeap.insert(30);
    minHeap.insert(2);
    minHeap.insert(45);
    minHeap.insert(100);
    minHeap.insert(60);

    while (minHeap.getHeapSize() > 0) {
      System.out.println(minHeap.extractMin());
    }
  }
}
