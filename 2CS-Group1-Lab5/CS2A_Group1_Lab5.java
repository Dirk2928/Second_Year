import java.util.*;

public class CS2A_Group1_Lab5 {

    static class Node {
        int data;
        Node left, right;
        Node(int v) { data = v; }
    }

    static Node root = null;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String errorMsg = "";
        while (true) {
            MainMenu(errorMsg);
            errorMsg = "";
            String choice = sc.next().toUpperCase();
            sc.nextLine();
            switch (choice) {
                case "S":
                    if (root == null) errorMsg = "Tree is empty.";
                    else {
                        System.out.print("\u000C");
                        printTree(root);
                        System.out.print("\nPress Enter to continue...");
                        sc.nextLine();
                    }
                    break;

                case "I": {
                    boolean adding = true;
                    while (adding) {
                        System.out.print("\u000C");
                        System.out.print("Enter value to insert: ");
                        int val = 0;
                        try { val = sc.nextInt(); sc.nextLine(); } 
                        catch (Exception e) { 
                            sc.nextLine(); 
                            System.out.print("\u000C"); 
                            System.out.println("Invalid input. Please enter an integer."); 
                            System.out.print("\nPress Enter to continue..."); 
                            sc.nextLine(); 
                            continue; 
                        }

                        if (exists(root, val)) { 
                            System.out.print("\u000C"); 
                            System.out.println("Value already exists."); 
                        } else { 
                            System.out.print("\u000C"); 
                            root = insert(root, val); 
                            System.out.println("Value " + val + " is inserted!");
                        }

                        while (true) {
                            System.out.print("\nAdd another value? (Y/N): ");
                            String r = sc.next().trim().toUpperCase();
                            sc.nextLine();
                            if (r.equals("Y")) break;
                            if (r.equals("N")) { adding = false; break; }
                            System.out.print("\u000C"); 
                            System.out.println("Invalid input. Enter Y or N only.");
                        }
                    }
                    break;
                }

                case "D":
                    if (root == null) { 
                        errorMsg = "Tree is empty."; 
                        break; 
                    }
                    boolean deleting = true;
                    while (deleting) {
                        System.out.print("\u000C");
                        printTree(root);
                        System.out.print("\nEnter value to delete: ");
                        int val = 0;
                        try { 
                            val = sc.nextInt(); 
                            sc.nextLine(); 
                        } catch (Exception e) { 
                            sc.nextLine(); 
                            System.out.print("\u000C"); 
                            System.out.println("Invalid input. Please enter an integer."); 
                            System.out.print("\nPress Enter to continue..."); 
                            sc.nextLine(); 
                            continue; 
                        }

                        if (!exists(root, val)) {
                            System.out.print("\u000C"); 
                            System.out.println("Value does not exist.");
                            System.out.print("\nTry again? (Y/N): ");
                            String r = sc.next().trim().toUpperCase();
                            sc.nextLine();
                            if (r.equals("N")) deleting = false;
                        } else {
                            System.out.print("\u000C");
                            root = delete(root, val);
                            System.out.println(val + " deleted!");
                            System.out.print("\nPress Enter to continue...");
                            sc.nextLine();
                            deleting = false;
                        }
                    }
                    break;

                case "T":
                    if (root == null) errorMsg = "Tree is empty."; else TraversalMenu();
                    break;

                case "Q":
                    System.out.print("\u000C"); System.out.println("Goodbye!"); return;

                default: errorMsg = "Invalid choice.";
            }
        }
    }

    public static void MainMenu(String errorMsg) {
        System.out.print("\u000C");
        System.out.println("\n✧⋄⋆⋅⋆⋄✧⋄⋆⋅⋆⋄✧✧⋄⋆⋅⋆⋄✧⋄⋆⋅⋆⋄✧✧⋄⋆⋅⋆⋄✧⋄⋆⋅⋆");
        System.out.println("           BST OPERATIONS       ");
        System.out.println("✧⋄⋆⋅⋆⋄✧⋄⋆⋅⋆⋄✧✧⋄⋆⋅⋆⋄✧⋄⋆⋅⋆⋄✧✧⋄⋆⋅⋆⋄✧⋄⋆⋅⋆\n");
        System.out.println("[S] Show");
        System.out.println("[I] Insert");
        System.out.println("[D] Delete");
        System.out.println("[T] Traverse");
        System.out.println("[Q] Quit");
        System.out.print("\nEnter choice: ");
        if (!errorMsg.isEmpty()) System.out.print("\n" + errorMsg);
    }

    static Node insert(Node n, int v) { if (n == null) return new Node(v); if (v < n.data) n.left = insert(n.left, v); else if (v > n.data) n.right = insert(n.right, v); return n; }
    static boolean exists(Node n, int v) { if (n == null) return false; if (v == n.data) return true; else if (v < n.data) return exists(n.left, v); else return exists(n.right, v); }
    static Node delete(Node n, int v) { if (n == null) return null; if (v < n.data) n.left = delete(n.left, v); else if (v > n.data) n.right = delete(n.right, v); else { if (n.left == null && n.right == null) return null; else if (n.left == null) return n.right; else if (n.right == null) return n.left; else { int m = findMin(n.right); n.data = m; n.right = delete(n.right, m); } } return n; }
    static int findMin(Node n) { while (n.left != null) n = n.left; return n.data; }

    static void printTree(Node root) {
        int maxLevel = maxLevel(root);
        printNode(Collections.singletonList(root), 1, maxLevel);
    }

    static void printNode(List<Node> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || allNull(nodes)) return;

        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, Math.max(floor - 1, 0));
        int firstSpaces = (int) Math.pow(2, floor) - 1;
        int betweenSpaces = (int) Math.pow(2, floor + 1) - 1;

        printSpaces(firstSpaces);
        List<Node> newNodes = new ArrayList<>();
        for (Node n : nodes) {
            if (n != null) { System.out.print(n.data); newNodes.add(n.left); newNodes.add(n.right); } 
            else { System.out.print(" "); newNodes.add(null); newNodes.add(null); }
            printSpaces(betweenSpaces);
        }
        System.out.println();

        printSpaces(firstSpaces);
        for (Node n : nodes) {
            if (n != null) { for (int i = 0; i < String.valueOf(n.data).length(); i++) System.out.print("-"); } 
            else System.out.print(" ");
            printSpaces(betweenSpaces);
        }
        System.out.println();

        for (int i = 1; i <= edgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printSpaces(firstSpaces - i);
                Node n = nodes.get(j);
                if (n == null) { printSpaces(edgeLines*2 + i +1); continue; }
                if (n.left != null) System.out.print("/"); else System.out.print(" ");
                printSpaces(i*2 -1);
                if (n.right != null) System.out.print("\\"); else System.out.print(" ");
                printSpaces(edgeLines*2 - i);
            }
            System.out.println();
        }

        printNode(newNodes, level+1, maxLevel);
    }

    static void printSpaces(int count) { for (int i=0;i<count;i++) System.out.print(" "); }
    static int maxLevel(Node n) { if (n==null) return 0; return Math.max(maxLevel(n.left), maxLevel(n.right))+1; }
    static boolean allNull(List<Node> list) { for(Node n:list) if(n!=null) return false; return true; }

    public static void inOrder(Node n){ if(n==null) return; inOrder(n.left); System.out.print(n.data+" "); inOrder(n.right);}
    public static void TraversalMenu() {
        String msg=""; boolean cont=true;
        while(cont){
            printTraversalMenu(msg); msg="";
            String in=sc.nextLine().trim(); int c;
            try{c=Integer.parseInt(in);}catch(Exception e){msg="Enter valid numbers only."; continue;}
            if(c==1){System.out.print("\u000C"); System.out.print("InOrder Traversal: "); inOrder(root); System.out.println(); System.out.print("\nPress Enter to continue..."); sc.nextLine();}
            else if(c==2){System.out.print("\u000C"); System.out.print("PreOrder Traversal: "); preOrder(); System.out.println(); System.out.print("\nPress Enter to continue..."); sc.nextLine();}
            else if(c==3){System.out.print("\u000C"); System.out.print("PostOrder Traversal: "); postOrder(); System.out.println(); System.out.print("\nPress Enter to continue..."); sc.nextLine();}
            else if(c==4) cont=false; else msg="Invalid selection.";
        }
    }
    public static void printTraversalMenu(String msg){
        System.out.print("\u000C");
        System.out.println("\n✧⋄⋆⋅⋆⋄✧⋄⋆⋅⋆⋄✧✧⋄⋆⋅⋆⋄✧⋄⋆⋅⋆⋄✧✧⋄⋆⋅⋆⋄✧⋄⋆⋅⋆");
        System.out.println("         BST TRAVERSAL MENU       ");
        System.out.println("✧⋄⋆⋅⋆⋄✧⋄⋆⋅⋆⋄✧✧⋄⋆⋅⋆⋄✧⋄⋆⋅⋆⋄✧✧⋄⋆⋅⋆⋄✧⋄⋆⋅⋆\n");
        System.out.println("[1] InOrder");
        System.out.println("[2] PreOrder");
        System.out.println("[3] PostOrder");
        System.out.println("[4] Exit");
        System.out.print("\nYour choice: ");
        if(!msg.isEmpty()) System.out.print("\n" + msg);
    }

    public static void preOrder(){preOrderRecursion(root);}
    public static void preOrderRecursion(Node n){if(n==null) return; System.out.print(n.data+" "); preOrderRecursion(n.left); preOrderRecursion(n.right);}
    public static void postOrder(){postOrderRecursion(root);}
    public static void postOrderRecursion(Node n){if(n==null) return; postOrderRecursion(n.left); postOrderRecursion(n.right); System.out.print(n.data+" ");}

}
