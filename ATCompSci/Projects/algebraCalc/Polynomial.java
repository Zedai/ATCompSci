package algebraCalc;

import java.util.LinkedList;
import java.util.ListIterator;

public class Polynomial {
	private LinkedList<Term> list = new LinkedList<Term>();
	
	public void addTerm(Term t){
		addTerm(t.getCoefficient(), t.getPower());
	}
	
	public void addTerm(double coefficient, double power){
		Term term = new Term(coefficient, power);
		ListIterator<Term> iter = list.listIterator();
		
		if(iter.hasNext() && iter.next().getPower() == power){
			Term term2 = iter.previous().add(term);
			iter.set(term2);
			return;
		}
		if(iter.hasPrevious() && iter.previous().getPower() < power){
			list.addFirst(term);
			return;
		}
		while(iter.hasNext())
			if(iter.next().getPower() == power){
				Term term2 = iter.previous().add(term);
				iter.set(term2);
				return;
			}
			else{
				iter.previous();
				
				if(iter.hasNext() && iter.next().getPower() < power){
			
				iter.previous();
				iter.add(term);
				return;
				}
			}
		
		list.addLast(term);
	}
	
	public Polynomial add(Polynomial other){
		ListIterator<Term> iter = list.listIterator();
		ListIterator<Term> oIter = other.getIterator();
		Polynomial newP = new Polynomial();
		
		while(iter.hasNext())
			newP.addTerm(iter.next());
		
		while(oIter.hasNext())
			newP.addTerm(oIter.next());
		
		return newP;
	}
	
	public Polynomial derivative(){
		ListIterator<Term> iter = list.listIterator();
		Polynomial newP = new Polynomial();
		
		while(iter.hasNext()){
			Term term = iter.next();
			newP.addTerm(term.getPower() * term.getCoefficient(), term.getPower() - 1);
		}
		
		return newP;
	}
	
	public Polynomial multiply(Polynomial other){
		ListIterator<Term> iter = list.listIterator();
		ListIterator<Term> oIter = other.getIterator();
		Polynomial newP = new Polynomial();
		
		while(iter.hasNext()){
			Term term = iter.next();
			while(oIter.hasNext())
				newP.addTerm(term.multiply(oIter.next()));
			
			oIter = other.getIterator();
		}
		
		return newP;
	}
	
	public ListIterator<Term> getIterator(){
		return list.listIterator();
	}
	
	public String toString(){
		String ret = "";
		
		ListIterator<Term> iter = list.listIterator();
		while(iter.hasNext())
			ret += iter.next();
		
		return ret;
	}
}
