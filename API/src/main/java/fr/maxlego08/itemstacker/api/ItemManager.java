package fr.maxlego08.itemstacker.api;

import org.bukkit.entity.Item;
import org.bukkit.event.Listener;

public interface ItemManager extends Listener {

    /**
     * Retrieves a StackedItem associated with the given Bukkit Item.
     *
     * @param item The Bukkit Item whose associated StackedItem is to be retrieved.
     * @return The StackedItem corresponding to the provided Bukkit Item.
     */
    StackedItem getItem(Item item);

    /**
     * Retrieves the amount of the given Bukkit Item.
     *
     * @param item The Bukkit Item whose amount is to be retrieved.
     * @return The amount of the provided Bukkit Item.
     */
    int getItemAmount(Item item);

    /**
     * Sets the amount of the given Bukkit Item.
     *
     * @param item   The Bukkit Item whose amount is to be set.
     * @param amount The new amount of the provided Bukkit Item.
     */
    void setAmount(Item item, int amount);

}
