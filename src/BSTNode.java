
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
    return null;
  }
  
  public void remove(char inVal) {
    
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
