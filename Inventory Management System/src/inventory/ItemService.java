package inventory;

import java.util.List;

public class ItemService {
    private ItemDAO itemDAO = new ItemDAO();

    public void addItem(Item item) {
        itemDAO.addItem(item);
    }

    public Item getItem(int id) {
        return itemDAO.getItem(id);
    }

    public List<Item> getAllItems() {
        return itemDAO.getAllItems();
    }

    public void updateItem(Item item) {
        itemDAO.updateItem(item);
    }

    public void deleteItem(int id) {
        itemDAO.deleteItem(id);
    }

    public List<Item> searchItems(String name) {
        return itemDAO.searchItems(name);
    }

    public List<Item> filterItemsByCategory(String category) {
        return itemDAO.filterItemsByCategory(category);
    }

}
