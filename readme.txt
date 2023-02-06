/******************************************************************************
 *  Name: Jaret Kadlec
 *
 *  Hours to complete assignment (optional):
 *  10
 ******************************************************************************/

Programming Assignment 2: Autocomplete


/******************************************************************************
 *  Describe how your firstIndexOf() method in BinarySearchDeluxe.java
 *  finds the first index of a key that equals the search key.
 firstIndexOf searches for any key that equals the search key by using a simple
 binary search algorithm (dividing the search area in half until found, return
 -1 if not). Once it gets to that key, it iterates forward through the array until the
 end of the array is found or other values are found to find the first index of the value.
 *****************************************************************************/




/******************************************************************************
 *  What is the order of growth of the number of compares (in the
 *  worst case) that each of the operations in the Autocomplete
 *  data type make, as a function of the number of terms n and the
 *  number of matching terms m?  (Big-Oh notation)
 *
 *  Recall that with order-of-growth notation, you should discard
 *  leading coefficients and lower-order terms, e.g., m^2 + m log n.
 *****************************************************************************/

constructor: O(logN)

allMatches(): O(NlogN)

numberOfMatches(): O(logN)




/******************************************************************************
 *  Known bugs / limitations.
 No known bugs or limitations
 *****************************************************************************/


/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings or lectures, but do include
 *  any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 *
 *  Also include any resources (including the web) that you may
 *  may have used in creating your design.
Explanation of binary search by khan academy: https://www.khanacademy.org/computing/computer-science/algorithms/binary-search/a/implementing-binary-search-of-an-array

 *****************************************************************************/


/******************************************************************************
 *  Describe any serious problems you encountered.
 Creating the binary search was the most challenging part of this assignment, 
 but I was able to draw it out on paper and get a better understanding of how
 to implement the search.
 *****************************************************************************/





/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback
 *  on how much you learned from doing the assignment, and whether
 *  you enjoyed doing it.
 It was a fun assignment!
 *****************************************************************************/


