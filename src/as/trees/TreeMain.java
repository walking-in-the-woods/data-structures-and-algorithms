package as.trees;

/* A TREE in general:

 Hierarchical data structure
 root --> child/parent --> child
  |--> child/parent --> child
                |--> child
 A tree has only the one ROOT
 root ---> leaf
       ^ -- edge
 a tree contains subtrees
 A PATH is a sequence of nodes required to go from one node to another
 We can't have a path that crosses the root more than once (cycles are not allowed)
 A root path goes from a node to the root
 The DEPTH of a node is the number of edges from the node to the root
 The HEIGHT of a node is the number of edges on the longest path from the node to a leaf
 A height of the root is the height of the entire tree
 The nodes that are placed on the same level are SIBLINGS
 An ANCESTOR of the NODE is the every node on the root path of the NODE

 Every item in the tree is a node
 The node at the top of the tree is the root
 Every non-root node has one and only one parent
 A leaf node has no children
 A singleton tree has only one node - the root
*/

/*
 A BINARY TREE:

 Every node has 0, 1, or 2 children
 Children are referred to as left child and right child
 In practice, we use binary search trees
 A binary tree is COMPLETE if every level except the last level, has two children
 A FULL binary tree is complete as well.
 In a FULL binary tree every node other than the leaves has to have two children
 */

/*
A BINARY SEARCH TREE (BST)
Can perform insertions, deletions, and retrievals in O(logn) time
The left child always has a smaller value than its parent
The right child always has a larger value than its parent
This means everything to the left of the root is less than the value of the root,
and everything to the right of the root is greater than the value of the root
Because of that, we can do a binary search
A MIN value is in the leaf on the left edges
A MAX value is in the leaf on the right edges
 */

/*
Dealing with duplicated:
1. Not allow them
2. Always store duplicates either in the left subtree or the right subtree
3. Have a counter with each node
 */

/*
Insert 25(0), 20(1), 15(2), 27(3), 30(4), 29(5), 26(6), 22(7), 32(8)  (value(iteration))

             25(0)                               25
           /      \                             /
      20(1)        27(3)                      20   <---  this technically is a linked list
     /             /    \                    /           so, we're not gonna get O(logn) time,
 15(2)   22(7) 26(6)     30(4)             15            we're gonna get linear time, O(n)
                        /     \           /
                     29(5)    30(8)     10

Ideally when we're building a binary search tree we try to keep the tree as balanced as possible
and that means that the heights of the left subtree and the right subtree, don't differ by much.
And so, there are self balancing binary search trees.
After every insertion or deletion, they look at the tree and if the tree is starting to get out of whack
(in bad condition), they rebalance the tree by shifting nodes around. Two common ones are AVL trees and
red-black trees.
 */

/*
TRAVERSAL (visiting)
There are four ways to traverse a tree:
1. Level - visit nodes on each level
2. Pre-order - visit the root of every subtree first
3. Post-order - visit the root of every subtree last
4. In-order - visit left child, then root, then right child

              25
            /    \
          20      27
         /  \    /  \
       15   22  26   30
                    /  \
                  29    32

1. Level order: 25, .. 20, 27, .. 15, 22, 26, 30, .. 29, 32
2. Pre-order:   25, 20, 15, 22, .. 27, 26, 30, .. 29, 32
3. Post-order:  15, 22, .. 26, .. 29, 32, .. 30, .. 27, .. 25
4. In-order:    15, 20, 22, .. 25, .. 26, 27, .. 29, 30, 32
 */

/*
DELETE
1. Node is a leaf
2. Node has one child
3. Node has two children

              25
            /    \
          20      27
         /  \    /  \
       15   22  26   30
         \          /  \
          17      29    32

1. Let's say we wanna delete node 17. So, all we have to do is knock node 17 because it's a leaf.
2. Let's say we wanna delete node 15. In this case, all we have to do is to replace the node
   we're deleting with the child.
   And it's safe to do that because we know that everything in 20's left subtree is smaller than 20.
3. Delete node with two children
- Need to figure out what the replacement node will be
- Want minimal disruption to the existing tree structure
- Can take the replacement node from the deleted node's left subtree or right subtree
- If taking it from the left subtree, we have to take the largest value in the left subtree
- If taking it from the right subtree, we have to take the smallest value in the right subtree
- Choose one and stick to it

  Let's say we wanna delete node 20. Let's say we're gonna look for that replacement node in the left subtree.
  So, we're gonna move down to the left subtree, and then we wanna look for the largest value in the left subtree.
  We're gonna move down to 15 and then we're gonna start travelling to the right, and we find 17.
  So, we're gonna take node 17 and put it here (where the node 20 is). And obviously we would null out 15's child
  If 17 has a left child (it can't have a right child because it wouldn't be the greatest value,
  so it wouldn't be selected). So, the node we find, it'll either be a leaf or it will have only a left child.
  And so, if 17 had a left child it child would replace 17.

  Let's say we wanna delete node 27. In this case we're gonna search down the right subtree. And we want
  the smallest value (for the same reason that we wanted the largest value when we look down the left subtree.
  We want the smallest value because when we replace 27 with the value, everything in the right subtree
  still has to be greater than 27. And because we're looking for the minimum value in the subtree,
  we're gonna move along the left edges until we hit a node that doesn't have a left child. So, we'll find 29.
  We'll replace 29 and 27 and obviously we'll null out 30's left child. If 29 had a right child that child
  will replace it in the tree.

  Let's say we wanna delete the root. We're gonna look down the right subtree, and we wanna find the minimum value.
  We'll start travelling down the left edges until we hit the node that doesn't have a left child. That will be
  the minimum. ANd we're gonna find 26. We'll replace the root with this node. And we'll null out 27's child.
 */

/*
Trees and the JDK

Class TreeMap<K,V> (Red-Black tree based NavigableMap implementation)
it guarantees O(logn) time complexity for the containsKey, get, put and remove operations
This is not synchronized.

Class TreeSet<K,V> (a NavigableSet implementation based on TreeMap) "Set" means that the data structure
does not contain duplicates.
 */

public class TreeMain {
    public static void main(String[] args) {

        Tree intTree = new Tree();

        intTree.insert(25);
        intTree.insert(20);
        intTree.insert(15);
        intTree.insert(27);
        intTree.insert(30);
        intTree.insert(29);
        intTree.insert(26);
        intTree.insert(22);
        intTree.insert(32);
        intTree.insert(17);

        intTree.traverseInOrder();
        System.out.println();

        intTree.traversePreOrder();
        System.out.println();

        intTree.traversePostOrder();
        System.out.println();

//        System.out.println(intTree.get(27));
//        System.out.println(intTree.get(17));
//        System.out.println(intTree.get(8888));

//        System.out.println(intTree.min());
//        System.out.println(intTree.max());

//        intTree.delete(15);
//        intTree.traverseInOrder();
//        System.out.println();

//        intTree.delete(27);
//        intTree.traverseInOrder();
//        System.out.println();

//        intTree.delete(25);
//        intTree.traverseInOrder();
//        System.out.println();

//        intTree.delete(8888);
//        intTree.traverseInOrder();
//        System.out.println();
    }
}
