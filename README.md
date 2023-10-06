# CS-2210-Assignment4
Repository for Assignment 4 of CS2210 (Data Structures and Algorithms)

**Binary Trees Merge and Conversion to AVL-BST**

**Overview:**

This project focuses on merging two binary trees into a new binary tree. If nodes from the input trees overlap, their values are summed up to become the value of the node in the merged tree. If nodes don't overlap, the non-null node's value is taken. After merging, the resultant binary tree is converted into a balanced AVL Binary Search Tree (BST).

**Task:**

**1. Merge Two Binary Trees:**
  Given two binary trees, they are merged based on the rule: If two nodes overlap, their values are summed. If they don't overlap, the non-null node's value is taken.

**2. Convert to AVL-BST:**
The resulting binary tree from the merge operation is then converted into a balanced AVL Binary Search Tree.

**Classes and Methods:**

**MergeBinaryTree:**

Method: **merge()**: Merges two nodes that appear at the same position in both input trees.

**BST:**

Method: **insert()**: Helps in adding values into the BST, starting from the root.

**AVL:**

Method: **check-balance()**: Evaluates the height of subtrees to determine if the BST is balanced.

**Rotation:**

Method: **singleRotation()**: Performs single rotation to balance the AVL tree.

Method: **doubleRotation()**: Performs double rotation to balance the AVL tree.
