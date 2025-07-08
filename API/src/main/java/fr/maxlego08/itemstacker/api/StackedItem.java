package fr.maxlego08.itemstacker.api;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public interface StackedItem {

    /**
     * @return the bukkit entity representing this item
     */
    org.bukkit.entity.Item toBukkitEntity();

    /**
     * Returns the unique identifier for this item.
     *
     * @return the unique id
     */
    UUID getUniqueId();

    /**
     * Gets the amount of this item.
     *
     * @return the amount
     */
    int getAmount();

    /**
     * Sets the amount of this item.
     * This value is NOT saved anywhere, you are responsible for saving it.
     * Note that setting the amount to 0 will remove the item from the world.
     *
     * @param amount the amount to set
     */
    void setAmount(int amount);

    /**
     * Compares this StackedItem with the provided ItemStack to determine if they are similar.
     * The similarity is defined by the specific implementation of this method.
     *
     * @param itemStack The ItemStack to compare against this StackedItem.
     * @return true if the provided ItemStack is considered similar to this StackedItem, false otherwise.
     */
    boolean isSimilar(ItemStack itemStack);

    /**
     * Sets the name of the item.
     * This method is used to define the name of the item as it appears to players.
     * The name is not used in any way by the plugin, it is only used for aesthetics.
     */
    void setItemName();

    /**
     * Increases the amount of this item by the provided amount.
     * This method will do nothing if the amount is 0 or negative.
     *
     * @param amount the amount to increase the item amount by
     */
    void add(int amount);

    /**
     * Decreases the amount of this item by the specified amount.
     * If the resulting amount is less than or equal to zero,
     * the item will be removed from the world.
     *
     * @param amount the amount to decrease the item amount by
     */
    void remove(int amount);

    /**
     * Checks if this StackedItem is valid.
     * A StackedItem is considered valid if it has a positive amount and has not expired.
     *
     * @return true if the StackedItem is valid, false otherwise
     */
    boolean isValid();

    /**
     * Tries to give this StackedItem to the provided inventory.
     * If the inventory has enough space, the item will be added to the inventory and this method will return true.
     * If the inventory does not have enough space, this method will return false.
     *
     * @param inventory the inventory to give the item to
     * @return true if the item was given, false otherwise
     */
    boolean give(Inventory inventory);

    /**
     * Gets the time (in milliseconds) at which the item was created.
     *
     * @return the time at which the item was created
     */
    long getCreatedAt();

    /**
     * Gets the time (in milliseconds) at which the item will expire.
     * If the item never expires, this method will return 0.
     *
     * @return the time at which the item will expire, or 0 if the item never expires
     */
    long getExpireAt();

    /**
     * Removes this StackedItem from the world.
     * If the item is in an inventory, it will be removed from the inventory.
     * If the item is on the ground, it will be removed from the ground.
     */
    void remove();

    /**
     * Gets the ItemStack object associated with this StackedItem.
     * This method will never return null.
     *
     * @return the ItemStack object associated with this StackedItem
     */
    ItemStack getItemStack();
}
