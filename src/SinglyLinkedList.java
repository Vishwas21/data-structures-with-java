import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SinglyLinkedList {

    /* Static input variables */
    private static final InputStreamReader reader;
    private static final BufferedReader input;

    /* Static block to initialize input variables */
    static {
        reader = new InputStreamReader(System.in);
        input = new BufferedReader(reader);
    }

    /* Head of the Singly Linked List */
    Node head;

    /* Constructor to initialize class with required default values */
    SinglyLinkedList() {
        head = null;
    }

    /* Definition of each node in the Singly Linked List */
    private static class Node {

        /* Store the information in the Linked List Node */
        int info;

        /* Store the link to the next node in the Linked List */
        Node next;

        /* Constructor to initialize node class*/
        Node(int value) {
            info = value;
            next = null;
        }
    }

    /* Create Singly Linked List */
    private static SinglyLinkedList createLinkedList(SinglyLinkedList list) throws IOException {

        /* Input to find out number of nodes to be created in the linked list */
        System.out.print("Enter the number of nodes to be created: ");
        int numberOfNodes = Integer.parseInt(SinglyLinkedList.input.readLine());

        /* Assigning null to the head of the list to identify the start of the Linked List */
        list.head = null;

        /* Checking if the nodes to be added is 0 */
        if (numberOfNodes == 0) {
            return list;
        }

        /* Adding the first node */
        System.out.print("Enter the number to be added to the Linked List : ");
        int data = Integer.parseInt(SinglyLinkedList.input.readLine());
        list = SinglyLinkedList.addNodeAtBeginning(list, data);             // TODO - Must research about this, does not expect an assignment variable

        /* Adding the rest of the nodes if needed */
        for(int index = 2; index <= numberOfNodes; index++) {
            System.out.print("Enter the number to be added to the Linked List : ");
            data = Integer.parseInt(SinglyLinkedList.input.readLine());
            list = SinglyLinkedList.addNodeAtEnd(list, data);
        }

        return list;
    }

    /* Display the Linked List */
    private static void displayLinkedList(SinglyLinkedList list) {

        /* Checking if the Linked List is Empty */
        if (list.head == null) {
            System.out.println("Singly Linked List is EMPTY!");
        }

        /* Declaring a traversal variable */
        Node traversalPointer = list.head;

        System.out.println("Printing your Linked List : ");
        while (traversalPointer != null) {
            System.out.print("\t" + traversalPointer.info);
            traversalPointer = traversalPointer.next;
        }
        System.out.println();
    }

    /* Length of the Singly Linked List */
    private static int linkedListLength(SinglyLinkedList list) {

        /* Declaring a traversal variable */
        Node traversalPointer = list.head;

        int length = 0;
        while (traversalPointer != null){
            length++;
            traversalPointer = traversalPointer.next;
        }

        return length;
    }

    /* Search Linked List */
    private static void searchLinkedList(SinglyLinkedList list, int searchItem) {

        /* Checking if the Linked List is Empty */
        if (list.head == null) {
            System.out.println("Singly Linked List is EMPTY!");
        }

        /* Declaring a traversal variable */
        Node traversalPointer = list.head;

        int nodePosition = 1;
        while (traversalPointer != null) {

            /* Checking if the current node has the searchItem */
            if (traversalPointer.info == searchItem) {
                /* Success Message */
                System.out.println("The search item is found!\nSearch Item : " + searchItem + "\nPosition : " + nodePosition);
                return;
            }

            /* Updating the loop and position variables */
            traversalPointer = traversalPointer.next;
            nodePosition++;
        }

        /* Failure Message */
        System.out.println("The search was unsuccessful!!\nSearch Item : " + searchItem + " \nPosition : N/A");
    }

    /* Add node to Empty Linked List / Add node at the beginning of the Linked List */
    private static SinglyLinkedList addNodeAtBeginning(SinglyLinkedList list, int insertionItem) {

        /* Creating a node for the insertion item */
        Node newNode = new Node(insertionItem);

        /* Adding the new node to the beginning of the Linked List*/
        newNode.next = list.head;
        list.head = newNode;

        System.out.println("Node successfully added!");

        return list;
    }

    /* Add node at the end of the Linked List */
    private static SinglyLinkedList addNodeAtEnd(SinglyLinkedList list, int insertionItem) {

        /* Creating a node for the insertion item */
        Node newNode = new Node(insertionItem);

        /* Declaring a traversal variable */
        Node traversalPointer = list.head;

        /* Traversing to the end of the Linked List */
        while (traversalPointer.next != null) {
            traversalPointer = traversalPointer.next;
        }

        /* Adding the new node at the end of the Linked List */
        traversalPointer.next = newNode;

        System.out.println("Node successfully added!");

        return list;
    }

    /* Add node after a node in Linked List */
    private static SinglyLinkedList addNodeAfter(SinglyLinkedList list, int nodeItem, int insertionItem) {

        /* Checking if the Linked List is Empty */
        if (list.head == null) {
            System.out.println("Singly Linked List is EMPTY!");
        }

        /* Creating a node for the insertion item */
        Node newNode = new Node(insertionItem);

        /* Declaring a traversal variable */
        Node traversalPointer = list.head;

        /* Traversing to the particular node in the Linked List */
        while (traversalPointer != null) {
            if (traversalPointer.info == nodeItem) {
                newNode.next = traversalPointer.next;
                traversalPointer.next = newNode;

                System.out.println("Node successfully added!");

                return list;
            }
            traversalPointer = traversalPointer.next;
        }

        System.out.println("Unable to find " + nodeItem + " in the Linked List");

        return list;
    }

    /* Add node before a node in the Linked List */
    private static SinglyLinkedList addNodeBefore(SinglyLinkedList list, int nodeItem, int insertionItem) {

        /* Checking if the Linked List is Empty */
        if (list.head == null) {
            System.out.println("Singly Linked List is EMPTY!");
        }

        /* Creating a node for the insertion item */
        Node newNode = new Node(insertionItem);

        /* Check if the first item is the nodeItem */
        if (list.head.info == nodeItem) {
            newNode.next = list.head;
            list.head = newNode;

            System.out.println("Node successfully added!");

            return list;
        }

        /* Declaring a traversal variable */
        Node traversalPointer = list.head;

        /* Traversing to the particular node in the Linked List */
        while(traversalPointer.next != null) {
            if (traversalPointer.next.info == nodeItem) {
                newNode.next = traversalPointer.next;
                traversalPointer.next = newNode;

                System.out.println("Node successfully added!");

                return list;
            }
            traversalPointer = traversalPointer.next;
        }

        System.out.println("Unable to find " + nodeItem + " in the Linked List");

        return list;
    }

    /* Add node at a position in the Linked List */
    private static SinglyLinkedList addNodeAtPosition(SinglyLinkedList list, int position, int insertionItem) {

        /* Creating a node for the insertion item */
        Node newNode = new Node(insertionItem);

        /* If the newNode must be added at the start */
        if (position == 1) {
            newNode.next = list.head;
            list.head = newNode;

            System.out.println("Node successfully added!");

            return list;
        }

        /* Creating a traversal variable */
        Node traversalPointer = list.head;

        /* Traversing to the position given */
        for (int index = 1; index < position - 1 && traversalPointer != null; index ++) {
            traversalPointer = traversalPointer.next;
        }

        if (traversalPointer == null) {
            System.out.println("Linked List does not contain " + position + " elements");
        }
        else {
            newNode.next = traversalPointer.next;
            traversalPointer.next = newNode;

            System.out.println("Node successfully added!");
        }

        return list;
    }

    /* Delete node at the beginning of the Linked List */
    private static SinglyLinkedList deleteNodeAtBeginning(SinglyLinkedList list) {

        /* Checking if the Linked List is empty */
        if (list.head == null) {
            System.out.println("Linked List is EMPTY!!");

            return list;
        }

        /* Adding the first node to a variable */
        Node deleteNode = list.head;

        list.head = list.head.next;

        System.out.println("Node to be deleted : " + deleteNode.info);

        /* Deleting the node */
        deleteNode = null;
        System.gc();

        System.out.println("Node successfully deleted from the Linked List");

        return list;
    }

    /* Delete node at the end of the Linked List */
    private static SinglyLinkedList deleteNodeAtEnd(SinglyLinkedList list) {

        /* Checking if the Linked List is empty */
        if (list.head == null) {
            System.out.println("Linked List is EMPTY!!");

            return list;
        }

        /* Declaring a traversal variable */
        Node traversalPointer = list.head;

        /* Traversing to the end */
        while (traversalPointer.next.next != null) {
            traversalPointer = traversalPointer.next;
        }

        /* Deleting the node */
        Node deleteNode = traversalPointer.next;

        System.out.println("Node to be deleted : " + deleteNode.info);

        traversalPointer.next = null;
        deleteNode = null;
        System.gc();

        System.out.println("Node successfully deleted from the Linked List");

        return list;
    }

    /* Delete node after a node in Linked List */
    private static SinglyLinkedList deleteNodeAfter(SinglyLinkedList list, int nodeItem) {

        /* Checking if the Linked List is empty */
        if (list.head == null) {
            System.out.println("Linked List is EMPTY!!");

            return list;
        }

        /* Declaring a traversal variable */
        Node traversalPointer = list.head;

        /* Traversing to the node */
        while (traversalPointer != null) {
            if (traversalPointer.info == nodeItem) {

                if (traversalPointer.next == null) {
                    System.out.println("There is no node after the last node.\nPlease try again!!");

                    return list;
                }

                /* Deleting the next node */
                Node deleteNode = traversalPointer.next;

                System.out.println("Node to be deleted : " + deleteNode.info);

                traversalPointer.next = traversalPointer.next.next;
                deleteNode = null;
                System.gc();

                System.out.println("Node successfully deleted from the Linked List");

                return list;

            }
            traversalPointer = traversalPointer.next;
        }

        System.out.println("Unable to find " + nodeItem + " in the Linked List");

        return list;
    }

    /* Delete node before a node in the Linked List */
    private static SinglyLinkedList deleteNodeBefore(SinglyLinkedList list, int nodeItem) {

        /* Checking if the Linked List is empty */
        if (list.head == null) {
            System.out.println("Linked List is EMPTY!!");

            return list;
        }

        /* Checking if the node is the first node */
        if (list.head.info == nodeItem) {
            System.out.println("There is no node before the first node.\nPlease try again!!");

            return list;
        }

        /* Checking if the node is the second node */
        if (list.head.next.info == nodeItem) {
            list = deleteNodeAtBeginning(list);

            return list;
        }

        /* Declaring a traversal variable */
        Node traversalPointer = list.head;

        /* Traversing to the node */
        while (traversalPointer.next != null) {
            if (traversalPointer.next.next.info == nodeItem) {

                /* Deleting the next node */
                Node deleteNode = traversalPointer.next;

                System.out.println("Node to be deleted : " + deleteNode.info);

                traversalPointer.next = traversalPointer.next.next;
                deleteNode = null;
                System.gc();

                System.out.println("Node successfully deleted from the Linked List");

                return list;

            }
            traversalPointer = traversalPointer.next;
        }

        System.out.println("Unable to find " + nodeItem + " in the Linked List");

        return list;
    }

    /* Delete node at a position in the Linked List */
    private static SinglyLinkedList deleteNodeAtPosition(SinglyLinkedList list, int nodePosition) {

        /* Checking if the Linked List is empty */
        if (list.head == null) {
            System.out.println("Linked List is EMPTY!!");

            return list;
        }

        /* If the node to be deleted is at the start */
        if (nodePosition == 1) {
            list = deleteNodeAtBeginning(list);

            return list;
        }

        /* Declaring a traversal pointer */
        Node traversalPointer = list.head;

        for (int index = 1; index < nodePosition - 1 && traversalPointer != null; index ++) {
            traversalPointer = traversalPointer.next;
        }

        if (traversalPointer == null) {
            System.out.println("Linked List does not contain " + nodePosition + " elements");
        }
        else {
            Node deleteNode = traversalPointer.next;

            System.out.println("Node to be deleted : " + deleteNode.info);

            traversalPointer.next = traversalPointer.next.next;
            deleteNode = null;
            System.gc();

            System.out.println("Node successfully deleted from the Linked List");
        }

        return list;
    }
    
    /* Reverse the Linked List */
    private static SinglyLinkedList reverseList(SinglyLinkedList list) {

        /* Checking if the Linked List is empty */
        if (list.head == null) {
            System.out.println("Linked List is EMPTY!!");

            return list;
        }
        
        /* Declaring required pointers */
        Node previousNode, currentNode, nextNode;
        previousNode = null;
        currentNode = list.head;
        
        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        
        list.head = previousNode;
        
        System.out.println("Successfully reversed the Linked List");
        
        return list;
    }

    /* Entry point of the program and the control center */
    public static void main(String[] args) {

        System.out.println("********************************************************************************************");
        System.out.println("Welcome to the implementation of Singly Linked List using JAVA");

        /* Creating an instance of the class SinglyLinkedList */
        SinglyLinkedList list = new SinglyLinkedList();

        int operationNumber;
        loop:
            while(true) {
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
                    operationNumber = Integer.parseInt(SinglyLinkedList.input.readLine());

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
                            int searchItem = Integer.parseInt(SinglyLinkedList.input.readLine());
                            searchLinkedList(list, searchItem);
                            break;
                        case 5:
                            System.out.println("\nAdd node to Empty Linked List / Add node at the beginning of the Linked List");
                            System.out.print("Enter the Item to be added to the beginning of the Linked List : ");
                            int insertionItem = Integer.parseInt(SinglyLinkedList.input.readLine());
                            list = addNodeAtBeginning(list, insertionItem);
                            break;
                        case 6:
                            System.out.println("Add node at the end of the Linked List");
                            System.out.print("Enter the Item to be added to the end of the Linked List : ");
                            insertionItem = Integer.parseInt(SinglyLinkedList.input.readLine());
                            list = addNodeAtEnd(list, insertionItem);
                            break;
                        case 7:
                            System.out.println("Add node after a node in Linked List");
                            System.out.print("Enter the Item to be added to the Linked List : ");
                            insertionItem = Integer.parseInt(SinglyLinkedList.input.readLine());
                            System.out.print("Enter the node after which you would like to add the above mentioned item : ");
                            int nodeItem = Integer.parseInt(SinglyLinkedList.input.readLine());
                            list = addNodeAfter(list, nodeItem, insertionItem);
                            break;
                        case 8:
                            System.out.println("Add node before a node in the Linked List");
                            System.out.print("Enter the Item to be added to the Linked List : ");
                            insertionItem = Integer.parseInt(SinglyLinkedList.input.readLine());
                            System.out.print("Enter the node before which you would like to add the above mentioned item : ");
                            nodeItem = Integer.parseInt(SinglyLinkedList.input.readLine());
                            list = addNodeBefore(list, nodeItem, insertionItem);
                            break;
                        case 9:
                            System.out.println("Add node at a position in the Linked List");
                            System.out.print("Enter the Item to be added to the Linked List : ");
                            insertionItem = Integer.parseInt(SinglyLinkedList.input.readLine());
                            System.out.print("Enter the position where you would like to add the above mentioned item : ");
                            int nodePosition = Integer.parseInt(SinglyLinkedList.input.readLine());
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
                            nodeItem = Integer.parseInt(SinglyLinkedList.input.readLine());
                            list = deleteNodeAfter(list, nodeItem);
                            break;
                        case 13:
                            System.out.println("Delete node before a node in the Linked List");
                            System.out.print("Enter the node before which you would like to delete : ");
                            nodeItem = Integer.parseInt(SinglyLinkedList.input.readLine());
                            list = deleteNodeBefore(list, nodeItem);
                            break;
                        case 14:
                            System.out.println("Delete node at a position in the Linked List");
                            System.out.print("Enter the position at which you would like to delete : ");
                            nodePosition = Integer.parseInt(SinglyLinkedList.input.readLine());
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
                    SinglyLinkedList.input.read();
                }catch (NumberFormatException error) {
                    System.out.println("Error Encountered!! \nPlease enter only from the given options ");
                }catch (Exception error) {
                    System.out.println("Unknown Error Encountered!! \nError: \n" + error);
                }
            }

            System.out.println("\nHope you enjoyed!! Goodbye :)");
    }
}