public class List_new<ContentType>{
  private Node first;
  private Node last;
  private Node active;
  
  private class Node {
    
    private ContentType content;
    private Node past;
    private Node next;
    
    
    Node(ContentType pContent){
      content = pContent;
      past    = null;
      next = null;
      
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
    
    public void setNext(Node pNext){
      this.next = pNext;
    }
    
    public Node getNext(){
      return this.next;
    }

    public void setContent(ContentType pContent){
    this.content = pContent;
    }

  }
    
  public List_new(){
    this.last = null;
    this.first= null;
    active = null;
  }

  public boolean isEmpty(){
    return last == null;
  }
  
  public boolean hasAccess(){
    return active != null;
  }
  
  public void next(){
    //if (!this.isEmpty() && this.hasAccess() && this.active != last){
      //this.active = active.getNext();
    //}
    if(hasAccess()) {
      if (active != last) {
        active = active.getNext();
      }else{
        active = null;
      }
    }

  }
  
  public void toFirst(){
    if(first != null)
      this.active = first;
  }
  
  public void toLast(){
    if(last != null)
      this.active = last;
  }

  public void append(ContentType pContent){
    //this.toLast();
    //Node newNode = new Node(pContent);
    //if(pContent != null)
    //{
    //  newNode = active.getNext();
    
    if(pContent == null) return;
    
    Node newNode = new Node(pContent);
    
    if (isEmpty()){
      first = newNode;
      last = newNode;
    } else {
      last.setNext(newNode);
      newNode.setPast(last);
      last = newNode;
    }
  }  

  public void insert(ContentType pContent){
    //if(pContent != null && active != null){
      //Node newNode = new Node(pContent);
      
      
      //if (this.isEmpty()) {
        
        //last = newNode;
        //first = newNode;
        
        
      //} else if (active == first) {
        
        //Node temp = first;
        //first.setPast(temp);
        
      //} else if(active == last){
        //Node temp = last;
        //last.setPast(temp);
      //}  //end of if-else
      
      //active = newNode;
    
    if(pContent == null) return;
    
    Node newNode = new Node(pContent);
    
    if(isEmpty()) {
      first = newNode;
      last = newNode;
      
      return;
    }
    
    if(!hasAccess())
      return;
      
    if(active == first) {
      newNode.next = first;
      first.past = newNode;
      first = newNode;
      return;
     } 
      Node previous = active.getPast();
      newNode.setPast(previous);
      newNode.setNext(active);
      previous.setNext(newNode);
      active.setPast(newNode);
     
    }
  
  public void concat(List_new<ContentType> pList){
    if(pList == null || pList.isEmpty() || pList == this) return;
    
    if(this.isEmpty()) {
      this.first = pList.first;
      this.last = pList.last;
    } else {
      this.last.setNext(pList.first);
      pList.first.setPast(this.last);
      this.last = pList.last;
    } // end of if-else
    
    pList.first = null;
    pList.last = null;
    pList.active = null;
  
//    this.append(pList);
//    this.toFirst();
//    while(!pList.isEmpty())
//    {
//      this.remove();
//      this.next();
//      }
//    
  }

  public void remove(){
    if(!hasAccess()) return;
    Node before = active.getPast();
    Node after = active.getNext();
    
    if(active == first && active == last) {
      first = null;
      last = null;
      active = null; 
      return;
        }
    if(active == first) {
      first = after;
      if (after != null){
        after.past = null;
        active = after;
      }else {
        last = null;
        active = null;
       } // end of if-else
      return;  
    }

    if (active == last){
      last = before;
      before.setNext(null);
      active = null;
      return;
    }
    
    before.next = after;
    after.past = before;
    
    active = after;
    //if (this.active == first){
      //this.first = active.getPast();
    //} else if (active == last){
      //last = active.getNext();
    //} // end of if-else
    
    
    //active = null;
  }



}