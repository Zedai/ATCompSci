package doublylinkedlist;

public class Tester {
	public static void main(String[] args){
		DLinkedList list = new DLinkedList();
		System.out.println("List.removeFirst()");
		System.out.println(list.removeFirst());
		System.out.println("List:: " + list);
		System.out.println("\nList.addFirst(34)");
		list.addFirst(34);
		System.out.println("List:: " + list);
		System.out.println("\nList.removeFirst()");
		System.out.println(list.removeFirst());
		System.out.println("List:: " + list);
		System.out.println("\nList.addFirst(20)");
		list.addFirst(20);
		System.out.println("List:: " + list);
		System.out.println("\nList.addLast(50)");
		list.addLast(50);
		System.out.println("List:: " + list);
		System.out.println("\nList:: " + list);
		System.out.println("List.size():: " + list.size());
		System.out.println("\nList.removeFirst()");
		System.out.println(list.removeFirst());
		System.out.println("List:: " + list);
		System.out.println("\nList.removeLast()");
		System.out.println(list.removeLast());
		System.out.println("List:: " + list);
		System.out.println("\nList.addFirst(32)");
		list.addFirst(32);
		System.out.println("List:: " + list);
		System.out.println("\nList.addFirst(23)");
		list.addFirst(23);
		System.out.println("List:: " + list);
		System.out.println("\nList.addFirst(435)");
		list.addFirst(435);
		System.out.println("List:: " + list);
		System.out.println("\nList.removeLast()");
		System.out.println(list.removeLast());
		System.out.println("List:: " + list);
		System.out.println("\nList.removeLast()");
		System.out.println(list.removeLast());
		System.out.println("List:: " + list);
		System.out.println("\nList.removeLast()");
		System.out.println(list.removeLast());
		System.out.println("List:: " + list);
		System.out.println("\nList.removeLast()");
		System.out.println(list.removeLast());
		System.out.println("List:: " + list);
		System.out.println("\nList.removeLast()");
		System.out.println(list.removeLast());
		System.out.println("List:: " + list);		
		
		System.out.println("\n==========================DListIterator");
		list.addFirst(76);
		list.addFirst(23);
		list.addFirst(784);
		list.addFirst(5);
		list.addFirst(347);
		DListIterator iter = list.iterator();
		System.out.println("List:: " + list);
		System.out.println("Iterator:: " + iter);
		iter.add(40);
		System.out.println("\nIter.add(40)");
		System.out.println("List:: " + list);
		System.out.println("Iterator:: " + iter);
		
		System.out.println("\nIter.remove()");
		iter.remove();
		System.out.println("Iterator:: " + iter);
		System.out.println("\nIter.remove()");
		iter.remove();
		System.out.println("Iterator:: " + iter);
		System.out.println("\nIter.next()");
		System.out.println("Iterator:: " + iter);
		iter.next();
		iter.remove();
		System.out.println("\nIter.remove()");
		System.out.println("Iterator:: " + iter);
		
		System.out.println("\nIter.next()");
		System.out.println("Iter.next()");
		System.out.println("Iter.remove()");
		iter.next();
		iter.next();
		iter.remove();
		System.out.println("Iterator:: " + iter);
		
		System.out.println("\nIter.previous()");
		System.out.println("Iter.next()");
		System.out.println("Iter.next()");
		System.out.println("Iter.next()");
		System.out.println("Iter.remove()");
		iter.previous();
		iter.next();
		iter.next();
		iter.next();
		iter.remove();
		System.out.println("Iterator:: " + iter);
		
		System.out.println("\nIter.previous()");
		System.out.println("Iter.remove()");
		iter.previous();
		list.size();
		iter.remove();
		System.out.println("Iterator:: " + iter);
		
		System.out.println("\nIter.add(32)");
		System.out.println("Iter.previous()");
		System.out.println("Iter.add(23)");
		iter.add(32);
		iter.previous();
		iter.add(23);
		System.out.println("Iterator:: " + iter);
		
		System.out.println("\nIter.set(50)");
		iter.set(50);
		System.out.println("Iterator:: " + iter);

	}
}
