package as.heaps;

/* HEAP
Heap is a complete binary tree
Must satisfy the heap property
MAX heap: Every parent is greater than or equal to its children
MIN heap: Every parent is less than or equal to ist children
 */

/*
A binary heap must be a complete tree
Children are added at each level from left to right
Usually implemented as arrays
The max or min value will always be at the root of the tree - the advantage of using a heap
Heapify: process of converting a binary tree into a heap - this often has to be done
after an insertion or deletion
No required ordering between siblings
 */

/*
(1) This binary tree is not a heap          (2) This one is a heap

           15                                           22
         /    \                                       /    \
       22      4                                    19      18
      /       /  \                                 /  \    /  \
    19      18    3                              15    3  14   4
                   \                            /
                    14                        12

(1) It fails two requirements:
1. It's not a complete tree (14 should be a 22's child to make it complete)
2. It doesn't meet the parent-child value relationships. It's not a max heap and it's not a min heap.

(2)
1. It's a complete binary tree because every level is full except the last one
2. It's a max heap because every parent has a value that is greater than or equal to its child
(In a max heap, if we walk along every root-leaf path we get the values in descending order)
(In a min heap, it's opposite. We get the values in ascending order)
 */

/*
Heaps as Arrays

We can store binary heaps as arrays
We put the root at array[0]
We then traverse each level from left to right, and so the left child of the root
would go into array[1], it's right child would go into array[2], etc.

        { 22, .. 19, 18, .. 15, 3, 14, 4, .. 12 }

                      22
                    /    \
                  19      18
                 /  \    /  \
               15    3  14   4
              /
            12

Search for the node at array[i]:

left child = 2 * i + 1
right child = 2 * i + 2

parent = floor((i - 1) / 2)
*/

/*
INSERTION

Always add new items to the end of the array
Then we have to fix the heap (heapify)
We compare the new item against its parent
If the item is greater than its parent, we swap it with its parent
We then rinse (wash) and repeat

 (0)       22         | (1)       22         | (2)       22
         /    \       |         /    \       |         /    \
       19      18     |       19      18     |      (20)     18
      /  \    /  \    |      /  \    /  \    |      /  \    /  \
    15    3  14   4   |   (20)   3  14   4   |    19    3  14   4
   /  \               |   /  \               |   /  \
 12   (20)            | 12    15             | 12    15

*/

/*
DELETING

Must choose a replacement value
Will take the rightmost value, so that the tree remains complete
Then we must heapify the heap
When replacement value is greater than parent, fix heap above.
Otherwise, fix heap below

Fix heap above - same as insert. Swap replacement value with parent
Fix heap below - swap the replacement value with the larger of its two children
Rinse and repeat in both cases until the replacement value is in its correct position
Will only need to fix up or down, not both

 Delete: 75    |    Replacement value: 67

 (0)       80         | (1)       80         | (2)       80         |
         /    \       |         /    \       |         /    \       |
      (75)     60     |      (67)     60     |       68      60     |
      /  \    /  \    |      /  \    /  \    |      /  \    /  \    |
    68    55 40   52  |    68    55 40   52  |   (67)   55 40   52  |
   /                  |                      |                      |
 67                   |                      |                      |

 Delete: 40    |    Replacement value: 67

 (0)       80         | (1)       80         | (2)       80         |
         /    \       |         /    \       |         /    \       |
       75      60     |       75     (60)    |       75     (67)    |
      /  \    /  \    |      /  \    /  \    |      /  \    /  \    |
    68    55(40)  52  |    68    55(67)  52  |    68    55 60   52  |
   /                  |                      |                      |
 67                   |                      |                      |

*/

/*
TIME COMPLEXITY

1. Insertion takes O(log(n)) time.
   Addition takes O(1), constant time. But then we have to potentially fix the heap.
   And to do that in the worst case, we may have to swap the new item all the way up to the root.
   And that would be log(n) swaps. And so, the time complexity for insert in O(log(n)).
2. Deletion takes O(nLog(n)) time. (O(log(n)) in practice)
   If we want to delete something, we have to find it first. And the worst case is going to be linear, O(n).
   And then, once we've found the item we want to delete, once again, we're going to have to fix the heap.
   And once again, the worst case for that will be O(log(n)).
   If we want to delete some random value and we don't have the index, the time complexity is O(nLog(n)).
   However, when we're working with a heap, we really usually only interested in the root. We're only
   ever going to remove the root. And we can remove the root in O(log(n)) time.
*/

/*
PriorityQueue<E>

The highest priority item is the root of a heap. So, we can remove it in emergency, and then the next
high priority item becomes the root of the heap and become a fast removable object.

To make a PriorityQueue we build a max-heap based on the priority value
The common operations are:
1. Insert with priority
2. Remove the highest priority item (that's called Poll)
3. Peak

The PriorityQueue is not synchronized. For thread-safe operations, there is a PriorityBlockQueue instead.
PriorityQueue<E> is a min-heap. If we want to use a max-heap, we're gonna have to provide a comparator
to the class to get that behavior.
*/

/*
HEAP SORT

We know the root has the largest value
Swap root with last element in the array
Heapify the tree, but exclude the last node
After heapify, second largest element is at the root
Rinse and repeat

Time complexity is:
The worst case is O(nlog(n)). (we swap n elements)
Heap sort can be decent sort out algorithm
HeapSort is in-place algorithm
Once we've sorted a heap, it's no longer a heap!
*/

/*
    { 80, 75, 60, 68, 55, 40, 52, 67 }
    lastHeapIndex = 7                       Swap heap[0] with [lastHeapIndex]

    { (67), 75, 60, 68, 55, 40, 52, (80) }
    Now heapify by looking down the tree and reduce the size of the heap by 1

    { 75, 68, 60, 67, 55, 40, 52, 80 }
    lastHeapIndex = 6                       Swap heap[0] with [lastHeapIndex]

    { (52), 68, 60, 67, 55, 40, (75), 80 }
    Now heapify by looking down the tree and reduce the size of the heap by 1

    { 68, 67, 60, 52, 55, 40, 75, 80 }
    lastHeapIndex = 5     Now third-largest value is a root. Rinse and repeat

    ......................

*/

import java.util.PriorityQueue;

public class HeapMain {
    public static void main(String[] args) {
        Heap heap = new Heap(10);
//
        heap.insert(80);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);

        heap.printHeap();

        heap.sort();
        heap.printHeap();
//
//        System.out.println(heap.peak());
//
//        heap.delete(0);
//        heap.printHeap();
//
//        System.out.println(heap.peak());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(25);
        pq.add(-22);
        pq.add(1343);
        pq.add(54);
        pq.add(0);
        pq.add(-3492);
        pq.add(429);

//        System.out.println(pq.peek());
//        System.out.println(pq.remove()); // <--- does the same
//        System.out.println(pq.peek());
//        System.out.println(pq.poll());   // <--- does the same
//        System.out.println(pq.peek());
//        System.out.println(pq.remove(54));

//        Object[] ints = pq.toArray();
//        for (Object num: ints) {
//            System.out.println(num);
//        }

//        System.out.println(pq.peek());
//        pq.add(-1);
//        System.out.println(pq.peek());
    }
}
