package wkst4;

//© A+ Computer Science  -  www.apluscompsci.com
//Name - Saikiran Nakka
//Date - 11/09/15
//Class - Advanced Topics in Computer Science Honors
//Lab  - Lol



public class HistoList
{
   private HistoNode front;

	public HistoList( )
	{
		front = null;
	}

	//addLetter will add a new node to the front for let if let does not exist
	//addLetter will bump up the count if let already exists
	public void addLetter(char let)
	{
		if(front ==  null)
			front = new HistoNode(let, 1, null);
		else{
			HistoNode search = front;
			if(indexOf(let) == -1)
				front = new HistoNode(let, 1, search);
			else
				nodeAt(indexOf(let)).setLetterCount(nodeAt(indexOf(let)).getLetterCount() + 1);
		}
	}

	public void remove(char let)
	{
		if(front ==  null || indexOf(let) == -1)
			return;
		
		nodeAt(indexOf(let)).setLetterCount(nodeAt(indexOf(let)).getLetterCount() - 1);
		
		cleanUp();
	}
	
	private void cleanUp(){
		if(front == null)
			return;
		
		HistoNode search = front;
		while(search != null){
			if(search.getLetterCount() <= 0){
				HistoNode end = search.getNext();
				HistoNode start = front;
				
				if(indexOf(search.getLetter()) == 0){
						front.setLetter(end.getLetter());
						front.setLetterCount(end.getLetterCount());
						front.setNext(end.getNext());
				}
				else{
					for(int i = 0; i < indexOf(search.getLetter()) - 1; i++)
						start = start.getNext();
					
					start.setNext(end);
					
					cleanUp();		//Double Checks to make sure everything is clean
				}
			}
			
			search = search.getNext();
		}
	}
	
	//returns the index pos of let in the list if let exists
	public int indexOf(char let)
	{
		HistoNode search = front;
		int index = 0;
		while(search != null)
			if(search.getLetter() == let)
				return index;
			else{
				search = search.getNext();
				index++;
			}

		return -1;
	}

	//returns a reference to the node at spot
	private HistoNode nodeAt(int spot)
	{
		if(spot < 0)
			return null; 
		
		HistoNode search = front;

		for(int i = 0; i < spot; i++)
			search = search.getNext();

		return search;
	}

	//returns a string will all values from list
	public String toString()
	{
		String output = "";
		HistoNode search = front;
		
		while(search != null){
			output += search.getLetter() + " - " + search.getLetterCount() + "\t";
			search = search.getNext();
		}
		
		return output;
	}
}