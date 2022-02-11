import java.util.ArrayList;

public class GroceryStore
{
    /** An array of products normally stocked at the grocery store
     *  Guaranteed not to be null and to contain only non-null entries
     */
    private Product[] productsStocked;

    public GroceryStore(Product[] initialInventory)
    {
        productsStocked = initialInventory;
    }

    /** Returns an ArrayList of indices for Product elements in the
     *  productsStocked array that need to be reordered, as described in part (a)
     *  Precondition: min > 0 */
    public ArrayList<Integer> getReorderList(int min)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int index = 0; index < productsStocked.length; index ++)
        {
            if (productsStocked[index].getQuantity() <= min)
            {
                list.add(index);
            }
        }
        return list;
    }

    /** Returns true if all products named in shoppingList are available for purchase
     *  and returns false otherwise, as described in part (b)
     *  Precondition: The products named in shoppingList are found exactly once
     *  in the productsStocked array.
     */
    public boolean checkAvailability(ArrayList<String> shoppingList)
    {
        for (int index = 0; index < shoppingList.size(); index ++)
        {
            for (Product item: productsStocked)
            {
                if (item.getName().equals(shoppingList.get(index)))
                {
                    if (item.getQuantity() < 1)
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /** Returns an ArrayList containing all Products from productStocked that
     *  have a weight that exceeds the “weight” value provided in the parameter
     */
    public ArrayList<Product> oversized(double weight)
    {
        ArrayList<Product> list = new ArrayList<Product>();
        for (Product item: productsStocked)
        {
            if (item.getWeight() > weight)
            {
                list.add(item);
            }
        }
        return list;
    }

}