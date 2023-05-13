/**
 * @author Dylan Minchhoff
 * @version 1.0.0
 *
 * a class representing a game event
 */
class GameEvent {
    private int playerNumber;
    private String eventType;
    private String eventDetails;
    public GameEvent(int playerNumber, String eventType, String eventDetails) {
        this.playerNumber = playerNumber;
        this.eventType = eventType;
        this.eventDetails = eventDetails;
    }

    // setters

    /**
     *
     * @param playerNumber - an int representing the player number who made the action
     * sets the player number as the passed value
     */
    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    /**
     *
     * @param eventDetails - a string representing the details of a player event
     * sets the event details as the passed value
     */
    public void setEventDetails(String eventDetails) {
        this.eventDetails = eventDetails;
    }

    /**
     *
     * @param eventType - a string representing the event type
     * sets the event type to the passed value
     */
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    /**
     *
     * @return - the current player number of this game event
     */
    public int getPlayerNumber() {
        return this.playerNumber;
    }

    /**
     *
     * @return - the current event details of the current event
     */
    public String getEventDetails() {
        return this.eventDetails;
    }

    /**
     *
     * @return - a string representing the current event type
     */
    public String getEventType() {
        return this.eventType;
    }
}

/**
 * @author Dylan Minchhoff
 * @version 1.0.0
 *
 * a class representing a node for a linked list of game events
 */
class GameEventNode {
    GameEvent gameState;
    GameEventNode next;

    /**
     * constructor:
     * @param gameState - a GameEvent class representing the current state of the game
     */
    public GameEventNode(GameEvent gameState) {
        this.gameState = gameState;
        this.next = null;
    }

    /**
     *
     * @param gameState - a GameEvent representing an event in the game
     */
    public void setGameState(GameEvent gameState) {
        this.gameState = gameState;
    }

    /**
     *
     * @param next - a GameEventNode representing the next action
     * sets the passed GameEventNode as the next GameEventNode
     */
    public void setNext(GameEventNode next) {
        this.next = next;
    }

    /**
     *
     * @return - the current state of the game
     */
    public GameEvent getGameState() {
        return this.gameState;
    }

    /**
     *
     * @return - the GameEventNode currently set as next
     */
    public GameEventNode getNext() {
        return this.next;
    }
}

/**
 * @author Dylan Minchhoff
 * @version 1.2.0
 *
 * a linked list representing the events in a game
 */
public class GameEventsLinkedList {
    private GameEventNode head;
    private int size;

    /**
     * constructor - sets the head to the null value and the size to zero
     */
    public GameEventsLinkedList() {
        this.head = null;
        this.size = 0;
    }

    /**
     *
     * @param head - the new head of the linked list
     */
    public void setHead(GameEventNode head) {
        this.head = head;
        if (head == null) {
            this.size = 0;
            return;
        }

        // finding the size of the new head
        int count = 0;
        GameEventNode current = head;
        while(current != null) {
            count++;
            current = current.getNext();
        }
        this.size = count;
    }

    /**
     *
     * @param size - an int to modify the size of the linked list
     * WARNING: modifying this field incorrectly may result in an incorrect size
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     *
     * @return - the current head of the linked list
     */
    public GameEventNode getHead() {
        return this.head;
    }

    /**
     *
     * @return - an int representing the current size of the linked list
     */
    public int getSize() {
        return this.size;
    }

    /**
     *
     * @return - a boolean value to check if the linked list is empty
     * a linked list is empty if the head is null
     */
    public boolean isEmpty() {
        return this.head == null;
    }

    /**
     *
     * @param gameEventNode - a game event to add to the end of the linked list
     *
     * modifies the current linked list to add a new node to the end
     */
    public void add(GameEventNode gameEventNode) {
        if (gameEventNode == null) return;

        GameEventNode current = this.head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(gameEventNode);
        this.size++;
    }

//    // making a stack
//
//    /**
//     *
//     * @param gameEventNode - the GameEventNode to be removed
//     * modifies the list to make the passed gameEventNode as the new head of the list
//     */
//    public void push(GameEventNode gameEventNode) {
//        gameEventNode.setNext(this.head);
//        this.head = gameEventNode;
//    }
//
//    /**
//     *
//     * @return - the front of the gameEventLinkedList
//     * modifies the list to have the first element "popped"
//     */
//    public GameEventNode pop() {
//        GameEventNode removed = this.head;
//        removed.setNext(null);
//        this.head = this.head.getNext();
//        return removed;
//    }

    /**
     *
     * @param gameEventNode - the game event node to be removed from the linked list
     * @return - the gameState of the node that was removed
     *
     * loops through the game events to find the gameEventNode passed and removes it from the linked list
     * if no node is found, the null value is returned
     */
    public GameEvent remove(GameEventNode gameEventNode) {
        // if the gameEventNode is null
        if (gameEventNode == null) return null;

        // if the head is the node to be removed
        GameEventNode current = this.head;
        if (current == gameEventNode) {
            this.setHead(current.getNext());
            return current.getGameState();
        }
        // for any other node in the linked list
        while (current != null) {
            if (current.getNext() == gameEventNode) {
                this.size--;
                // creating a temp variable of the node to be removed
                GameEventNode temp = current.getNext();
                GameEventNode after = current.getNext().getNext();
                current.setNext(after);
                return temp.getGameState();
            }
            current = current.getNext();
        }
        // if the node is not found
        return null;
    }

    /**
     *
     * @param eventType - a string representing the string type
     * @return - a linked list containing all the GameEventNodes that have the same event type
     *
     * creates a new linked list of all game events with the same event type, this does not modify
     * the game events in the current linked list, but creates new game events for the linked list
     */
    public GameEventsLinkedList extract(String eventType) {

        // new linked list
        GameEventsLinkedList newList = new GameEventsLinkedList();
        GameEventNode current = this.head;

        while(current != null) {
            if (current.getGameState().getEventType().equals(eventType)) {
                // if the head is initialized
                GameEventNode equalEvent = new GameEventNode(current.getGameState());
                if (newList.getHead() != null) {
                    newList.add(equalEvent);
                }
                // initializing the head
                else {
                    newList.setHead(equalEvent);
                }
            }

            current = current.getNext();
        }
        return newList;
    }

    /**
     * loops through the gameEvents and prints each one's event details on a new line
     */
    public void display() {
        GameEventNode current = this.head;
        while (current != null) {
            System.out.println(current.getGameState().getEventDetails());
            current = current.getNext();
        }
    }

}
