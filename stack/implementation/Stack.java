
public class Stack<ContentType> {
  
  // start attributes
  private Node bottom;
  private Node top;
  
  
  // end attributes
  
  
  private class Node {
    
    private ContentType content;
    private Node past;
    
    Node(ContentType pContent){
      content = pContent;
      past    = null;
      }
    
      public void setPast(Node pPast) {
      this.past = pPast;
    }

    public Node getPast() {
      return this.past;
    }
  
    public ContentType getContent() {
      return this.content;  
    }
    
  }
  
  

  // start methods
  
    
  
  public Stack(){
    this.bottom = null;
    this.top    = null;
    }
  
  public boolean isEmpty(){
    return bottom == null;
    }
  
  
  
  public void push(ContentType pContent) {
  
    if (pContent != null) {
      Node newNode = new Node(pContent);
      if (this.isEmpty()) {
        
        bottom = newNode;
        top    = newNode;
        
      } else {
        
        Node temp = top;
        top       = newNode;
        top.setPast(temp);

        } // end of if-else// end of if
        
      }
      
    }
  
  public void pop() {
    
    if (!isEmpty()) {
      
      top      = top.past;
      
      if (isEmpty()) {
        bottom = null;
        top    = null;
      } // end of if
      
      }
      
    }
  
  public ContentType getTop() {
    if (isEmpty()) {
      return null;
    } else {
      return top.getContent(); 
      } // end of if-else // end of if
    }
  
  // end methods
} // end of Stack
