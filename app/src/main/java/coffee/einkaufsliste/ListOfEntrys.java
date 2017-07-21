package coffee.einkaufsliste;

/**
 * Created by Tribe on 21.07.2017.
 */

public class ListOfEntrys
{
    // First Entry in the ListOfEntrys
    private ListEntry start;
    private ListEntry end;

    public ListOfEntrys(int number, String item)
    {
        start = new ListEntry(number, item, 1);
        end = start;
    }

    public void add(int number, String item)
    {
        int endId = end.getId()+1;
        end.setNext(new ListEntry(number, item, endId));
        end = end.getNext();
    }

    public String NameById (int id)
    {
        ListEntry currentPosition = start;
        while(currentPosition.getId() != id)
        {
            if(currentPosition.getNext() != null)
            {
                currentPosition = currentPosition.getNext();
            }else return "Kein Eintrag gefunden";
        }return currentPosition.getItem();
    }

    public String names() {
        if (start.getNext().equals("")) {
            return "";
        }
        else {
            ListEntry currentPosition = start.getNext();
            while (currentPosition != null) {
                
            }
        }
    }

    public void delete (int id)
    {
        ListEntry entryBefore = start;
        ListEntry currentPosition = start;

        if(id == start.getId())
        {
            start = start.getNext();
        }else
        {
            while (currentPosition.getId() != id)
            {
                entryBefore = currentPosition;
                currentPosition = currentPosition.getNext();
                if (currentPosition == null) return;
            }
            entryBefore.setNext(currentPosition.getNext());
        }
    }
}
