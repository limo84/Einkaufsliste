package coffee.einkaufsliste;

/**
 * Created by Tribe on 21.07.2017.
 */

public class ListOfEntrys
{
    // First Entry in the ListOfEntrys
    private ListEntry start;
    private ListEntry end;
    private int id;

    public ListOfEntrys()
    {
    }

    public void add(int number, String item)
    {
        if(start == null)
        {
            id = 1;
            start = new ListEntry (number, item, id);
            end = start;
        }else
        {
            int newid = end.getId()+1;
            end.setNext(new ListEntry(number, item, newid));
            end = end.getNext();
        }
    }

    public void delete (int id)
    {
        ListEntry currentPosition = start;
        ListEntry beforePosition = null;

        if(start.getId() == id)
        {
            start = start.getNext();
        }else
        {
           while(currentPosition.getId() != id)
           {
               if (currentPosition.equals(null)) return;
               beforePosition = currentPosition;
               currentPosition = currentPosition.getNext();
           }
           if(end.getId() == id)
           {
               beforePosition.setNext((ListEntry) null);
           }else
           {
               beforePosition.setNext(currentPosition.getNext());

               while(currentPosition != null)
               {
                   currentPosition.setId(currentPosition.getId()-1);
                   currentPosition = currentPosition.getNext();
               }
           }
        }
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


}
