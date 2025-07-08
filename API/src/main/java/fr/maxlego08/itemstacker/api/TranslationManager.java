package fr.maxlego08.itemstacker.api;

import org.bukkit.inventory.ItemStack;

public interface TranslationManager {

    /**
     * Translates the given item stack into a string.
     *
     * <p>This method will return a string that represents the given item stack.
     * The string will be translated based on the language file.</p>
     *
     * @param itemStack The item stack to translate.
     * @return The translated string.
     */
    String translateItemStack(ItemStack itemStack);

    /**
     * Replaces a value in the given string with the value from the language file.
     *
     * @param searchValue The value to search for in the language file.
     * @return The translated value.
     */
    String replaceValue(String searchValue);

    /**
     * Load all translations for the plugin.
     * This method will attempt to load all translations from the language file.
     */
    void loadTranslations();

}
