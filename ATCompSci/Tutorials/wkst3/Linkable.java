package wkst3;

//© A+ Computer Science  -  www.apluscompsci.com
//Name - Saikiran Nakka
//Date - 11/03/15
//Class - AT Com Sci
//Lab  - Idk
@SuppressWarnings("rawtypes")

public interface Linkable
{
   Comparable getValue();
   Linkable getNext();
   void setNext(Linkable next);
   void setValue(Comparable value);
}