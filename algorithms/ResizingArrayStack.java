package practice.jinhao;
import edu.princeton.cs.algs4.*;
import java.util.Iterator;
public class ResizingArrayStack<Item> implements Iterable<Item> {
  private Item[] a = (Item[]) new Object[1];
  private int N;
  public boolean isEmpty() {return N==0;}
  public boolean isFull() {return N==a.length;}
  public void resize(int max) {
	  Item[] temp = (Item[]) new Object[max]; //创建一个栈容为max的临时容器
	  for(int i=0;i<a.length;i++) { //将a所引用的容器元素赋予给temp来引用；
		  temp[i]=a[i];
	  }
	  a = temp; // 将a来引用temp;
  }
  public void push(Item item) {
	  if(this.isFull()) 
	  { //判断推入之前，栈是否满了。如果满了，就扩容；
		  resize(2*a.length);}
	  a[N++] = item;
  }
  public Item pop()
  {   
	  Item temp = a[--N];
	  a[N] = null;
	  if(N<a.length/4)
	  {
		  resize(a.length/2);
	  }
	  return temp;
  }
  public Iterator<Item> iterator()
  {
	  return new ReverseArrayIterator();
  }
  private class ReverseArrayIterator implements Iterator<Item>
  {
	  private int i=N;//i的当前位置
	  public boolean hasNext() {return i>0;}
	  public Item next() {return a[--i];}
	  public void remove() {}
	  
  }
  public static void main(String[] args) 
  {
	  ResizingArrayStack<String> stk = new ResizingArrayStack();
	  stk.push("to");
	  stk.push("be");
	  stk.push("this");
	  stk.push("that");
	  StdOut.println(stk.pop());
	  for(String s:stk)
	  {StdOut.println(s);}
	  
  }
}
