
public class BSTNode {
  // class variables
  BSTNode left;
  BSTNode right;
  char value;
  
  BSTNode(char inVal){
    value = inVal;
  }

  
  public boolean find(char inVal) {
    if(inVal == value) {
      return true;
    }
    
    if(left != null && inVal < value) {
      return left.find(inVal);
    }else if(right != null && inVal > value){
      return right.find(inVal);
    }
    return false;
  }
  
  public void insert(char inVal) {
    // refuse to insert a duplicate
    if(find(inVal)) return;
    
    // recursive calls 
    if(inVal < value) {
      // insert on the left
      if(left != null) {
        left.insert(inVal);
      }else {
        left = new BSTNode(inVal);
      }
    }else {
      //insert on the right
      if(right != null) {
        right.insert(inVal);
      }else {
        right = new BSTNode(inVal);
      }
    }
    
  }
  

  public BSTNode findMin() {
    BSTNode current = this;
    while(current.left!=null){
      current = current.left;
    }
    return current;
  }
  
  public void remove(char inVal) {
    // base case: is the value in our tree?
    if(!find(inVal)) return;
    
    BSTNode current = this;
    BSTNode parent = null;
    
    while(current.value != inVal) {
      parent = current;
      if(inVal < current.value) current = current.left;
      else current = current.right;
    }
    
    // found the node, and it's parent
    
    // if its a leaf, remove it
    if(current.left==null && current.right==null) {
      // if root is a leaf... can't remove it
      if(parent==null) return;
      
      // make the parent not point to it, don't know if its left or right
      if(current == parent.left) {
        parent.left = null;
      }else {
        parent.right = null;
      }
    }
    
    // if it has one child, re-link
    else if(current.left==null || current.right==null) {
      if(parent==null) {
        // replace the root.....
        if(current.left==null) {
          current.value = current.right.value;
          current.left = current.right.left;
          current.right = current.right.right;
        }else {
          current.value = current.left.value;
          current.right = current.left.right;
          current.left = current.left.left;
        }
      }
      
      // has a right child only
      else if(current.left==null) {
        if(current == parent.left) {
          parent.left = current.right;
        }else {
          parent.right = current.right;
        }
      }else {
        if(current == parent.left) {
          parent.left = current.left;
        }else {
          parent.right = current.left;
        }
      }
    }
    
    // now we know that it has two children
    else {
      // find the smallest on the right & remove it
      BSTNode min_right = current.right.findMin();
      remove(min_right.value);
      
      if(parent == null) {
        // replace the root....
        current.value = min_right.value;
      }else {
        // replace the current node with that minimum
        min_right.left = current.left;
        min_right.right = current.right;
        if(current == parent.left) {
          parent.left = min_right;
        }else {
          parent.right = min_right;
        }
      }
      
    }
    
  }
  
  
  public int height() {
    // base case
    if(left==null && right==null) {
      return 0;
    }
    
    int rtn = 0;
    // set rtn to max of children heights
    if(left != null && rtn < left.height()) {
      rtn = left.height();
    }
    if(right != null && rtn < right.height()) {
      rtn = right.height();
    }
    return rtn+1;
  }
  
  // if not in subtree return -1
  public int depth(char inVal) {
    if(!find(inVal)) {
      return -1;
    }
    if(inVal == value) {
      return 0;
    }
    
    if(inVal < value) {
      return 1 + left.depth(inVal);
    }else {
      return 1 + right.depth(inVal);
    }
    
  }
  
  // returns true if the subtree is balanced
  // false otherwise
  public boolean isBalanced() {
    int leftHeight = -1;
    if(left != null) {
      leftHeight = left.height();
    }
    int rightHeight = -1;
    if(right != null) {
      rightHeight = right.height();
    }
    // |leftHeight - rightHeight| > 1
    if((leftHeight - rightHeight) > 1 || (rightHeight - leftHeight) > 1) {
      return false;
    }
    
    // return true if both children return true, false if either one is false
    boolean rtn = true;
    if(left != null && !left.isBalanced()) 
      return false; //rtn = false;
    if(right != null) rtn &= right.isBalanced();
    return rtn;
  }
  
  public String inOrderTraversal() {
    String rtn = "";
    
    //base case
    //if(left==null && right==null) return String.valueOf(value);
    
    if(left!=null)
      rtn += left.inOrderTraversal();
    if(!rtn.equals(""))
      rtn += ", ";
    rtn += value;
    if(right!=null)
      rtn += ", " + right.inOrderTraversal();
    
    return rtn;
  }
  
  public String preOrderTraversal() {
    String rtn = "";
    
    rtn += value;
    if(left != null)
      rtn += ", " + left.preOrderTraversal();
    if(right != null)
      rtn += ", " + right.preOrderTraversal();
    
    return rtn;
  }
  
  public String toString() {
    return String.valueOf(value);
  }
  
  public void print() { print(""); }
  private void print(String prefix) {
    System.out.println(prefix + this);
    prefix = prefix.replace('\u251C', '\u2502');
    prefix = prefix.replace('\u2514', ' ');
    if(left != null) left.print(prefix + "\u251C ");
    else if(right != null) System.out.println(prefix + "\u251C " + "\u2400");
    if(right != null) right.print(prefix + "\u2514 ");
    else if(left != null) System.out.println(prefix + "\u2514 " + "\u2400");
  }
}
