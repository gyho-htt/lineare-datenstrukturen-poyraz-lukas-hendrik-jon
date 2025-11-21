import java.awt.Label;
public class list<ContentType> {
  
  // start attributes
  private Node aktuelles;
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
  public list(){
    this.aktuelles = null;
    this.top = null;
    this.bottom = null;
    }
    
  public boolean isEmpty(){
    return this.top == null;
    }  
    
  public boolean hasAccess(){
    return this.aktuelles != null;
    }
    
  public void next(){
    if (!isEmpty() && aktuelles!=null && aktuelles != bottom) {
      aktuelles = aktuelles.getPast();
    } // end of if
    }  
    
  public void toFirst(){
    
    }
    
  public void toLast(){
    
    }  
    
  public ContentType getContent(){
    
    }
    
  public void setContent(ContentType pContent){
    
    }    
    
  public void append(ContentType pContent){
    
    }
  
  public void insert(ContentType pContent){
    
    }
  
  public void concat(list<ContentType> pList){
    
    }
    
  public void remove(){
    
    }
      
       
  // end methods
} // end of list
