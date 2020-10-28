
public class driver {

  public static void main(String[] args) {
    
    BSTNode root = new BSTNode('d');
    root.insert('b');
    root.insert('f');
    root.insert('a');
    root.insert('c');
    root.insert('e');
    root.insert('h');
    root.print();
    System.out.println("Height: " + root.height());
    System.out.print("Find: ");
    for(char i='a'-1; i<='i'; i++) {
      System.out.print(i + ":" + root.find(i) + ",");
    }
    System.out.println();
    System.out.print("Depth: ");
    for(char i='a'-1; i<='i'; i++) {
      System.out.print(i + ":" + root.depth(i) + ",");
    }
    System.out.println();
    
    System.out.println("The minimum character is " + root.findMin().value);
    System.out.println("The minimum character in right subtree is " + root.right.findMin().value);

    root.remove('a'); // test removing..... leaf
    System.out.println("After remove 'a': ");
    root.print();
    root.remove('f'); // test removing.... a node with two children
    System.out.println("After remove 'f': ");
    root.print();
    // test removing a node with *one* child
    root.remove('b');
    System.out.println("After remove 'b': ");
    root.print();
    
    // test removing root with two children
    root.remove('d');
    System.out.println("After remove 'd': ");
    root.print();
  
    // test removing the root with one child
    root.remove('h');
    root.remove('e');
    root.insert('b');
    System.out.println("After remove 'h' then 'e': ");
    root.print();
    
    // test removing root failing because its a leaf
    root.remove('b');
    root.remove('c');
    root.remove('c');
    root.remove('c');
    root.remove('c');
    root.remove('c');
    root.remove('c');
    root.remove('X');
    System.out.println("After remove 'b' then 'c': ");
    root.print();
  }
}