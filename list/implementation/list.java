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
    private Node pre;
    
    Node(ContentType pContent){
      content = pContent;
      past    = null;
    }
    
    public void setPre(Node pPre) {
      this.pre = pPre;
    }

    public Node getPre() {
      return this.pre;
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
    if (!isEmpty()) {
      aktuelles = top;
    } // end of if
  }
    
  public void toLast(){
    if (!isEmpty()) {
      aktuelles = bottom;
    } // end of if
  }  
    
  public Node getContent(){
    
    if (hasAccess()==true) {
      return this.aktuelles;
    } else {
      return null;
    } // end of if-else
  }
    
  public void setContent(ContentType pContent){
    Node newNode = new Node(pContent);
    if (hasAccess()==true && pContent!=null) {
      aktuelles = newNode;
    } // end of if
  }    
    
  public void append(ContentType pContent){
    Node newNode = new Node(pContent);
    if (pContent!=null) {
      if (isEmpty()) {
        bottom = newNode;
        top = newNode;
      } else {
        bottom = newNode;  
      } // end of if-else
    } // end of if
  }
  
  public void insert(ContentType pContent){
    Node newNode = new Node(pContent);
    if (pContent != null) {
      
      
      if (hasAccess()) {
        aktuelles.setPast(newNode);
        
      } else if (isEmpty() && !hasAccess()) {
        top = newNode;
        bottom = newNode;  
      }else if (!hasAccess() && !isEmpty()) {
        
      }
    } // end of if
  }
    
  public void concat(list<ContentType> pList){
    if (pList != null) {
      if (this.aktuelles != pList.aktuelles && this.bottom != pList.bottom && this.top != pList.top) {
        bottom.setPast(pList.top);
        bottom = bottom.past;
        Node zeiger = pList.top;
        while (zeiger != bottom) { 
          bottom.past = zeiger.past;
          zeiger = zeiger.past;
          bottom = bottom.past;
        } // end of while
      } // end of if
    } // end of if
  }
    
  public void remove(){
    if (!isEmpty()) {
      if (hasAccess() && aktuelles != bottom) {
        aktuelles = aktuelles.past;
      } // end of if
      if (bottom == aktuelles) {
        
        aktuelles = null;
        
        Node Zeiger = top;
        
         while (Zeiger.past != bottom){
           if (Zeiger.past == bottom) {
            bottom = Zeiger; 
           } else {
            Zeiger = Zeiger.past;   
             } // end of if-else
           } 
      } // end of if
    } // end of if
  }
      
       
  // end methods
} // end of list
