package practice.jinhao;
import edu.princeton.cs.algs4.*;
import practice.jinhao.ResizingArrayStack;
public class Stack<Item> {
  private int N; //链表中元素个数;
  private Node first;
  private class Node{
	  Node next;
	  Item item;
  }
  public void push(Item item)
  { //向栈顶添加元素，栈顶为first指向的Node对象;
	  N++;
	  Node oldFirst = first;
	  first = new Node();
	  first.item = item;
	  first.next = oldFirst; //将栈顶的next指向oldFirst;
  }
  public Item pop() 
  {
	  Item temp = first.item;
	  N--;
	  first = first.next;
	  return temp;
	  
  }
  public static void main(String[] args) {
  Stack<String> stk = new Stack();
  stk.push("to");
  stk.push("be");
  stk.push("this");
  stk.push("that");
  StdOut.println(stk.pop());
  }
}
