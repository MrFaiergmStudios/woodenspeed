package com.example;

import net.minecraft.references.ItemIds;
import net.minecraft.world.item.ItemStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AxeFunction {

    ItemIds idItem = null;


    public static final String MOD_ID = "mrmods";


    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    int speed1 = 7;
    int speed1ё = 6;
    int speed2 = 5;
    int speed3 = 5;
    int speed4 = 4;

    public AxeFunction() {
        LOGGER.info("AxeFunctionINIT");
    }

    public int speedAxe(ItemStack id) {
        if (id.is(ItemIds.WOODEN_AXE)) {
            return speed1;
        }

        if (id.is(ItemIds.STONE_AXE)) {
            return speed1ё;
        }

        if (id.is(ItemIds.COPPER_AXE)) {
            return speed2;
        }

        if (id.is(ItemIds.IRON_AXE)) {
            return speed3;
        }

        if (id.is(ItemIds.GOLDEN_AXE)) {
            return speed3;
        }

        if (id.is(ItemIds.DIAMOND_AXE)) {
            return speed4;
        }

        if (id.is(ItemIds.NETHERITE_AXE)) {
            return speed4;
        }

        return 10;
    }
}
