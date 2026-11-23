package com.example;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraft.world.item.Items;

public class AxeFunction {



    public static final String MOD_ID = "mrmods";


    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    int speed1 = 7;
    int speed1ё = 6;
    int speed3 = 5;
    int speed4 = 4;

    public AxeFunction() {
        LOGGER.info("AxeFunctionINIT");
    }

    public int speedAxe(ItemStack id) {
        Item item = id.getItem();
        if (item.equals(Items.STONE_AXE)) {
            return speed1;
        }

        if (item.equals(Items.STONE_AXE)) {
            return speed1ё;
        }

        if (item.equals(Items.IRON_AXE)) {
            return speed3;
        }

        if (item.equals(Items.GOLDEN_AXE)) {
            return speed3;
        }

        if (item.equals(Items.DIAMOND_AXE)) {
            return speed4;
        }

        if (item.equals(Items.NETHERITE_AXE)) {
            return speed4;
        }

        return 10;
    }
}
