/** * A Java Program which allows users to create an array and insert 
      their own set of elements. With the inserted elements, the users 
      can choose between three sorting algorithms: Bubble Sort, Selection 
      Sort, and Insertion Sort. The program also lets users decide whether 
      to sort the elements in ascending or descending order. It then displays
      each stage of the sorting process for every iteration of the elements.
 * Group 1 
 * Authors: Ballesteros, Yther (Leader)
 *          Bahay, Biena Rose  (Members)
 *          Cruz, Dirk Maverick 
 * Laboratory Exercise 3
 * Date: 09/28/2025
*/

import java.util.Scanner;

public class CS2A_Group1_Lab3 {
    static Scanner sc = new Scanner(System.in);
    static int[] ourArray = null;
    static int maxWidth = 1;
    static int steps = 1;
    static int bullet = 1;
    static String decision = "Y";
    static int length = 1;

    public static void main(String[] args) {
        int choice = -1;
        
        do {
            if (decision.equalsIgnoreCase("N")) {
                break;
            }
            System.out.print("\u000C");
            ourArray = create();
            System.out.print("\u000C");
            insert(ourArray);
            for (int v : ourArray) {
                int length = String.valueOf(v).length();
                if (length > maxWidth) maxWidth = length;
            }
            boolean repeatPrint = true;
            do {
                if (repeatPrint) {
                    System.out.print("\u000C");
                    printMenu();
                }
                String input = sc.nextLine().trim();
                try {
                    choice = Integer.parseInt(input);
                } catch (Exception e) {
                    System.out.print("\u000C");
                    printMenu();
                    System.out.print("✖ Enter valid numbers only. •ᴗ•");
                    repeatPrint = false;
                    continue;
                }
                if (choice == 1) {
                    System.out.print("\u000C");
                    bubbleSort(ourArray);
                    pressAnyKey();
                } else if (choice == 2) {
                    System.out.print("\u000C");
                    selectSort(ourArray);
                    pressAnyKey();
                } else if (choice == 3) {
                    System.out.print("\u000C");
                    insertSort(ourArray);
                    pressAnyKey();
                } else if (choice == 4) {
                    System.out.print("\u000C");
                    exit();
                    if (decision.equalsIgnoreCase("Y") || decision.equalsIgnoreCase("N")) {
                        break;
                    }
                } else {
                    System.out.print("\u000C");
                    printMenu();
                    System.out.print("✖ Invalid selection. Please try again. •ᴗ•");
                    repeatPrint = false;
                    continue;
                }
                repeatPrint = true;
            } while (choice != 4);
        } while (decision.equalsIgnoreCase("Y"));
    }
    public static void printMenu() {
        System.out.println("\n✧⋄⋆⋅⋆⋄✧⋄⋆⋅⋆⋄✧✧⋄⋆⋅⋆⋄✧⋄⋆⋅⋆⋄✧✧⋄⋆⋅⋆⋄✧⋄⋆⋅⋆");
        System.out.println("         SORTING ALGORITHM MENU       ");
        System.out.println("✧⋄⋆⋅⋆⋄✧⋄⋆⋅⋆⋄✧✧⋄⋆⋅⋆⋄✧⋄⋆⋅⋆⋄✧✧⋄⋆⋅⋆⋄✧⋄⋆⋅⋆\n");
        System.out.println("⭐ [1] Bubble Sort");
        System.out.println("⭐ [2] Selection Sort");
        System.out.println("⭐ [3] Insertion Sort");
        System.out.println("⭐ [4] Exit\n");
        System.out.print("\n✧ Your choice: ");
    }
    
    public static void bubbleSort(int[]array) {
        int[] tempArray = array.clone();
        
        int choice = printOrderOpt(-1);
        System.out.print("\u000C");
        System.out.print(". ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡\n");
        System.out.print("          Bubble Sort ");
        System.out.print("\n. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ \n");
        
        printUnsort(ourArray);
        boolean anyChange = false;

        int temp, step = 1;
        for (int i = 0; i < tempArray.length; i++) {
            boolean swapped = false;
            for (int j = 0; j < tempArray.length - 1; j++) {
                boolean condition = false;
                if (choice == 0) {
                    condition = tempArray[j] < tempArray[j + 1];
                } else if (choice == 1) {
                    condition = tempArray[j] > tempArray[j + 1];
                }
                if (condition) {
                    temp = tempArray[j + 1];
                    tempArray[j + 1] = tempArray[j];
                    tempArray[j] = temp;
                    swapped = true;
                }
            }
            if (swapped) {
                anyChange = true;
                print(tempArray);
            }
        }
        if (anyChange) {
            printSort(tempArray);
        } else {
            System.out.println("✓ Array is already sorted. No sorting steps required. •ᴗ•");
        }
        bullet = 1;
    }

    public static void selectSort(int[] array) {
        int[] tempArray = array.clone();

        int choice = printOrderOpt(-1);
        System.out.print("\u000C");
        System.out.print(". ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡\n");
        System.out.print("         Selection Sort ");
        System.out.print("\n. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ \n");
        printUnsort(array);
        boolean anyChange = false;

        boolean condition = false;
        for (int i = 0; i < tempArray.length - 1; i++) {
            int num = i;
            for (int j = i + 1; j < tempArray.length; j++) {
                if (choice == 0) {
                    condition = tempArray[num] < tempArray[j];
                } else if (choice == 1) {
                    condition = tempArray[num] > tempArray[j];
                }
                
                if (condition) {
                    num = j;
                }
            } if(num != i) {
                int temp = tempArray[i];
                tempArray[i] = tempArray[num];
                tempArray[num] = temp;
                anyChange = true;
            }
            print(tempArray);
        }
        if (anyChange) {
            printSort(tempArray);
        } else {
            System.out.println("✓ Array is already sorted. No sorting steps required.");
        }
        bullet = 1;
    }
    
    public static void insertSort(int[] array) {
        int[] tempArray = array.clone();
        
        int choice = printOrderOpt(-1);
        System.out.print("\u000C");
        System.out.print(". ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡\n");
        System.out.print("         Insertion Sort ");
        System.out.print("\n. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ \n");
        printUnsort(array);
        boolean anyChange = false;
                
        for (int i=1; i<tempArray.length; i++) {
            int temp = tempArray[i];
            int j = i - 1;
                        
            while (j>=0) {
                boolean condition = false;
                if (choice == 0) {
                    condition = tempArray[j] < temp;
                } else if (choice == 1) {
                    condition = tempArray[j] > temp;
                }
                            
                if (condition){
                    tempArray[j+1] = tempArray[j];
                    j--;
                    anyChange = true;
                } else {
                    break;
                }
            }
            tempArray[j+1] = temp;
            print(tempArray);
        }
        if (anyChange) {
            printSort(tempArray);
        } else {
            System.out.print("✓ Array is already sorted. No sorting steps required. •ᴗ• ");
        }
        bullet = 1;
    }
        
    public static void orderOption() {
        System.out.print(". ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ \n");
        System.out.print("        What order? ");
        System.out.print("\n. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ \n ");
        System.out.print("\n⭐[0] Descending Order");
        System.out.print("\n⭐[1] Ascending Order\n");
        System.out.print("\nYour choice: ");
    }
    
    public static void print(int[] array) {
        System.out.printf("%-4s", bullet + ".)"); 
        
        for (int num : array) {
            System.out.printf("%" + (maxWidth+2) + "d ", num);
        }
        bullet++;
        System.out.println();
    }

    public static void printUnsort(int [] array) {
        int totalWidth = array.length * (maxWidth + 2) + 40;
        String border = "—".repeat(totalWidth);

        System.out.print(border);
        System.out.print("\nGiven Array Elements: ");
        for (int num : array) {
            System.out.printf("%" + (length) + "d  ", num);
        }
        System.out.println();
        System.out.println(border);
        System.out.println();
    }

    public static void printSort(int[] array) {
        int totalWidth = array.length * (maxWidth + 2) + 40;
        String border = "—".repeat(totalWidth);
        
        System.out.println();
        System.out.print(border);
        System.out.print("\n✧ Sorted Array Elements: ");
        for (int num : array) {
            int numLength = String.valueOf(num).length();
            System.out.printf( "%" + (length) + "d  ", num);
        }
        System.out.println();
        System.out.println(border);
    }
    
    public static int[] create() {
        int size = 0;
        boolean repeatPrint = true;
        while (true) {
            if (repeatPrint) {
                System.out.print(". ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡\n");
                System.out.print("    Enter array size (5-15): ");
                System.out.print("\n. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ \n");
            }
            String input = sc.nextLine().trim();
            try {
                size = Integer.parseInt(input); 
                if (size >= 5 && size <= 15) {
                    int[] ourArray = new int[size];
                    return ourArray;
                } else {
                    System.out.print("\u000C");
                    System.out.print(". ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡\n");
                    System.out.print("    Enter array size (5-15): ");
                    System.out.print("\n. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ \n ");
          
                    System.out.print("\n✖ Invalid. Please enter a size between 5 and 15: •ᴗ•");
                    repeatPrint = false;
                }
            } catch (Exception e) {
                System.out.print("\u000C");
                System.out.print(". ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡\n");
                System.out.print("    Enter array size (5-15): ");
                System.out.print("\n. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ \n");
          
                System.out.print("\n✖ Please input a number: •ᴗ•");
                repeatPrint = false;
            }
        }
    }
    
    public static void insert(int[] array) {
        boolean repeatPrint = true;
        while (true) {
            if (repeatPrint) {
                System.out.print(". ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁..\n");
                System.out.print("       Enter " + array.length + " Array Elements (separated by spaces):    ");
                System.out.print("\n. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁..\n");
            }
            String input = sc.nextLine().trim();
            String[] separate = input.split("\\s+");
    
            try {
                boolean hasDuplicate = false;
                for (int i = 0; i < array.length; i++) {
                    array[i] = Integer.parseInt(separate[i]);
                }
                if (separate.length != array.length) {
                    System.out.print("\u000C");
                    System.out.print(". ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁..\n");
                    System.out.print("       Enter " + array.length + " Array Elements (separated by spaces):    ");
                    System.out.print("\n. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁..\n");
                    System.out.print("\n✖ Please enter exactly " + array.length + " numbers •ᴗ• ");
                    repeatPrint = false;
                    continue;
                }
                
                for (int i = 0; i < array.length; i++) {
                    for (int j = i + 1; j < array.length; j++) {
                        if (array[i] == array[j]) {
                            hasDuplicate = true;
                            break;
                        }
                    }
                    if (hasDuplicate) break;
                }
                if (hasDuplicate) {
                    System.out.print("\u000C");
                    System.out.print(". ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁..\n");
                    System.out.print("       Enter " + array.length + " Array Elements (separated by spaces):    ");
                    System.out.print("\n. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁..\n");
                    System.out.print("\n✖ Duplicate elements are not allowed •ᴗ•");
                    repeatPrint = false;
                    continue;
                }
                break;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.print("\u000C");
                System.out.print(". ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁..\n");
                System.out.print("       Enter " + array.length + " Array Elements (separated by spaces):    ");
                System.out.print("\n. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁..\n");
                System.out.print("\n✖ Please enter exactly " + array.length + " numbers •ᴗ• ");
                repeatPrint = false;
                continue;
            } catch (Exception e) {
                System.out.print("\u000C");
                System.out.print(". ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁..\n");
                System.out.print("       Enter " + array.length + " Array Elements (separated by spaces):    ");
                System.out.print("\n. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁..\n");
                System.out.println("\n✖ Please enter valid numbers only •ᴗ•\n");
                repeatPrint = false;
            }
        }
    }
    
    public static void exit() {
        boolean repeatPrint = true;
        while (true) {
            if (repeatPrint) {
                System.out.print(". ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡\n");
                System.out.print("        Try Again (Y/N):          ");
                System.out.print("\n. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ \n");
                System.out.print("\nYour choice: ");
            
            }
            decision = sc.nextLine();
            if(decision.equalsIgnoreCase("Y")) {
                break;
            } else if (decision.equalsIgnoreCase("N")){
                System.out.println("\n . ݁˖ . ݁༉‧₊˚. Program Closed. Goodbye! . ݁˖ . ݁༉‧₊˚.");
                break;
            } else {
                System.out.print("\u000C");
                System.out.print(". ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡\n");
                System.out.print("        Try Again (Y/N):          ");
                System.out.print("\n. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ ܁ . ⊹ ₊ ܁.. ܁₊ ⊹ . ܁ ⟡ \n");
                System.out.print("\n✖ Invalid Input , Must enter 'Y' or 'N' to stop: •ᴗ•\n");
                System.out.print("\nYour choice: ");
                repeatPrint = false;
                continue;
            }
        }
    }
    
    public static int printOrderOpt(int chosen) {
        boolean repeatOrder = true;
        do {
            try {
                if (repeatOrder) {
                    orderOption();
                }
                chosen = sc.nextInt();
                sc.nextLine();
                if (chosen != 0 && chosen != 1) {
                    System.out.print("\u000C");
                    orderOption();
                    System.out.print("✖ Invalid Selection. Try again •ᴗ•");
                    repeatOrder = false;
                    continue;
                }
            } catch (Exception e) {
                System.out.print("\u000C");
                orderOption();
                System.out.print("✖ Please input a valid number •ᴗ•");
                repeatOrder = false;
                sc.nextLine();
                continue;
            }
        } while (chosen != 0 && chosen != 1);
        return chosen;
    }
    
    public static void pressAnyKey() { 
        System.out.print("\n\n✧ Enter ANY KEY to return to the main menu... •ᴗ•"); 
        String key = sc.nextLine();  
    }
}

