package wkst5pt2;

//© A+ Computer Science  -  www.apluscompsci.com
//Name - Saikiran Nakka
//Date -  11/13/15
//Class - AT Comp Sci
//Lab  - Still spooki friday the 13th

@SuppressWarnings("rawtypes")
public interface Linkable
{
   Comparable getValue();
   Linkable getNext();
   void setNext(Linkable next);
   void setValue(Comparable value);
}