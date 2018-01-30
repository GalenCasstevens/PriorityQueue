public class PriorityQueue {

   private PriorityCustomer[] heap;
   private int size, numServiced;
   
   
   public PriorityQueue() {
	   heap = new PriorityCustomer[60];
	   size = numServiced = 0;
   }

   public boolean isEmpty() {
	   return heap == null;
   }
   
   public void add(PriorityCustomer c) {
      int index = size + 1;         //index where we'll add the new value
      heap[index] = c;              //add value at that position
            
      while (index > 1) {                     //while our value has parents
         int parentIndex = index / 2;           //get parent index by dividing by 2
         if(heap[parentIndex].getPriority() < c.getPriority() && heap[parentIndex]) {
        	 heap[index] = heap[parentIndex];    //perform swap
        	 heap[parentIndex] = c;     
            
        	 index = parentIndex;                //update index after swap
         }else break;
      }
      size ++;                      //increase size
   }
   
   public PriorityCustomer remove() {
      PriorityCustomer rootValue = heap[1];      //store root value to return at the end
      PriorityCustomer v = heap[size];           //store last value in heap in v
      heap[1] = v;                  //take v and move to root
      heap[size] = null;               //delete node at last position (b/c we moved it to the root)
   
      int index = 1;
      
      while(index * 2 < size){      //is there at least one child at index
         int leftIndex = index * 2;
         int rightIndex = leftIndex + 1;
         
         PriorityCustomer leftValue = heap[leftIndex];
         PriorityCustomer rightValue = null;
         
         if(rightIndex < size){     //there is a right child
            rightValue = heap[rightIndex];
         }
         
         PriorityCustomer maxChild;
         int maxIndex;          //find index of and value of larger child
         if(leftValue.getPriority() >= rightValue.getPriority()) {     //put in '=' so you get FIFO (swap with left child if values are the same
            maxChild = leftValue;
            maxIndex = leftIndex;
         }else{
            maxChild = rightValue;
            maxIndex = rightIndex;         
         }
         
         if(v.getPriority() < maxChild.getPriority()){             //value is less than the larger child -> swap
            heap[index] = maxChild;    //perform swap with larger of two children
            heap[maxIndex] = v;
            index = maxIndex;
         }else{
            break;                     //value is in a valid position -> stop
         }
      }
      
      size --;                      //update size
      numServiced++;
      
      return rootValue;             //return old root
   }
   
   public int getSize() {
	   return size;
   }
   
   public int getNumServiced() {
	   return numServiced;
   }
}