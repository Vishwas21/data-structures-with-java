import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DoublyLinkedList {

    /* Static Input Variables */
    private static final InputStreamReader reader;
    private static final BufferedReader input;

    /* Static block to initialize input variables */
    static {
        reader = new InputStreamReader(System.in);
        input = new BufferedReader(reader);
    }

    /* Head of the Doubly Linked List */
    Node head;

    /* Constructor to initialize class with required default values */
    DoublyLinkedList() {
        head = null;
    }

    /* Definition of each node in the Doubly Linked List */
    private static class Node {

        /* Store the link to the next node in the Linked List */
        Node previous;

        /* Store the information in the Linked List Node */
        int info;

        /* Store the link to the next node in the Linked List */
        Node next;

        /* Constructor to initialize node class */
        Node(int value) {
            previous = null;
            info = value;
            next = null;
        }
    }

    /* Entry Point and Control Point of the program */
    public static void main(String[] args) {

        System.out.println("********************************************************************************************");
        System.out.println("Welcome to the implementation of Doubly Linked List using JAVA");

        /* Creating an instance of the class DoublyLinkedList */
        DoublyLinkedList list = new DoublyLinkedList();

        int operationNumber;

        loop:
            while (true) {

                System.out.println("\n\n\nBelow are few of the operation which are supported currently and it corresponding number. \n");
                System.out.println("\t1. Create Linked List");
                System.out.println("\t2. Display the Linked List");
                System.out.println("\t3. Length of the Linked List");
                System.out.println("\t4. Search Linked List");
                System.out.println("\t5. Add node to Empty Linked List / Add node at the beginning of the Linked List");
                System.out.println("\t6. Add node at the end of the Linked List");
                System.out.println("\t7. Add node after a node in Linked List");
                System.out.println("\t8. Add node before a node in the Linked List");
                System.out.println("\t9. Add node at a position in the Linked List");
                System.out.println("\t10. Delete node at the beginning of the Linked List");
                System.out.println("\t11. Delete node at the end of the Linked List");
                System.out.println("\t12. Delete node after a node in Linked List");
                System.out.println("\t13. Delete node before a node in the Linked List");
                System.out.println("\t14. Delete node at a position in the Linked List");
                System.out.println("\t15. Reverse the Linked List");
                System.out.println("\t16. Quit the program");
                System.out.print("Please choose one operation to proceed: ");

                try {

                    operationNumber = Integer.parseInt(DoublyLinkedList.input.readLine());

                    switch (operationNumber) {
                        case 1:
                            System.out.println("\nWelcome to Creation of the Singly Linked List");
                            list = createLinkedList(list);
                            break;
                        case 2:
                            System.out.println("\nDisplay Linked List");
                            displayLinkedList(list);
                            break;
                        case 3:
                            System.out.println("\nLength of the Linked List");
                            int lengthList = linkedListLength(list);
                            System.out.println("The length of the linked list is " + lengthList);
                            break;
                        case 4:
                            System.out.println("\nSearch Linked List");
                            System.out.print("Enter the item to be searched : ");
                            int searchItem = Integer.parseInt(DoublyLinkedList.input.readLine());
                            searchLinkedList(list, searchItem);
                            break;
                        case 5:
                            System.out.println("\nAdd node to Empty Linked List / Add node at the beginning of the Linked List");
                            System.out.print("Enter the Item to be added to the beginning of the Linked List : ");
                            int insertionItem = Integer.parseInt(DoublyLinkedList.input.readLine());
                            list = addNodeAtBeginning(list, insertionItem);
                            break;
                        case 6:
                            System.out.println("Add node at the end of the Linked List");
                            System.out.print("Enter the Item to be added to the end of the Linked List : ");
                            insertionItem = Integer.parseInt(DoublyLinkedList.input.readLine());
                            list = addNodeAtEnd(list, insertionItem);
                            break;
                        case 7:
                            System.out.println("Add node after a node in Linked List");
                            System.out.print("Enter the Item to be added to the Linked List : ");
                            insertionItem = Integer.parseInt(DoublyLinkedList.input.readLine());
                            System.out.print("Enter the node after which you would like to add the above mentioned item : ");
                            int nodeItem = Integer.parseInt(DoublyLinkedList.input.readLine());
                            list = addNodeAfter(list, nodeItem, insertionItem);
                            break;
                        case 8:
                            System.out.println("Add node before a node in the Linked List");
                            System.out.print("Enter the Item to be added to the Linked List : ");
                            insertionItem = Integer.parseInt(DoublyLinkedList.input.readLine());
                            System.out.print("Enter the node before which you would like to add the above mentioned item : ");
                            nodeItem = Integer.parseInt(DoublyLinkedList.input.readLine());
                            list = addNodeBefore(list, nodeItem, insertionItem);
                            break;
                        case 9:
                            System.out.println("Add node at a position in the Linked List");
                            System.out.print("Enter the Item to be added to the Linked List : ");
                            insertionItem = Integer.parseInt(DoublyLinkedList.input.readLine());
                            System.out.print("Enter the position where you would like to add the above mentioned item : ");
                            int nodePosition = Integer.parseInt(DoublyLinkedList.input.readLine());
                            list = addNodeAtPosition(list, nodePosition, insertionItem);
                            break;
                        case 10:
                            System.out.println("Delete node at the beginning of the Linked List");
                            list = deleteNodeAtBeginning(list);
                            break;
                        case 11:
                            System.out.println("Delete node at the end of the Linked List");
                            list = deleteNodeAtEnd(list);
                            break;
                        case 12:
                            System.out.println("Delete node after a node in Linked List");
                            System.out.print("Enter the node after which you would like to delete : ");
                            nodeItem = Integer.parseInt(DoublyLinkedList.input.readLine());
                            list = deleteNodeAfter(list, nodeItem);
                            break;
                        case 13:
                            System.out.println("Delete node before a node in the Linked List");
                            System.out.print("Enter the node before which you would like to delete : ");
                            nodeItem = Integer.parseInt(DoublyLinkedList.input.readLine());
                            list = deleteNodeBefore(list, nodeItem);
                            break;
                        case 14:
                            System.out.println("Delete node at a position in the Linked List");
                            System.out.print("Enter the position at which you would like to delete : ");
                            nodePosition = Integer.parseInt(DoublyLinkedList.input.readLine());
                            list = deleteNodeAtPosition(list, nodePosition);
                            break;
                        case 15:
                            System.out.println("Reverse the Linked List");
                            list = reverseList(list);
                            break;
                        case 16:
                            break loop;
                        default:
                            System.out.println("Please enter a valid option!!");
                    }
                    System.out.print("\n\nPress enter to continue");
                    DoublyLinkedList.input.read();

                }catch (NumberFormatException error) {
                    System.out.println("Error Encountered!! \nPlease enter only from the given options ");
                }catch (Exception error) {
                    System.out.println("Unknown Error Encountered!! \nError: \n" + error);
                }
            }

            System.out.println("\nHope you enjoyed!! Goodbye :)");
    }
}
