package coffee.einkaufsliste;

/**
 * Created by Tribe on 21.07.2017.
 */

public class ListEntry
{
    private int number;
    private String item;
    private int id;

    private ListEntry next;

    public ListEntry(int number, String item, int id)
    {
        this.number = number;
        this.item = item;
        this.id = id;
    }

    public String getItem()
    {
        return item;
    }

    public int getNumber()
    {
        return number;
    }

    public int getId()
    {
        return id;
    }

    public ListEntry getNext()
    {
        return next;
    }

    public void setNext(ListEntry next)
    {
        this.next = next;
    }
}
