package com.example;

import net.minecraft.world.item.ItemStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.minecraft.world.item.Items;

public class AxeFunction {



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
        if (id.is(Items.WOODEN_AXE)) {
            return speed1;
        }

        if (id.is(Items.STONE_AXE)) {
            return speed1ё;
        }

        if (id.is(Items.COPPER_AXE)) {
            return speed2;
        }

        if (id.is(Items.IRON_AXE)) {
            return speed3;
        }

        if (id.is(Items.GOLDEN_AXE)) {
            return speed3;
        }

        if (id.is(Items.DIAMOND_AXE)) {
            return speed4;
        }

        if (id.is(Items.NETHERITE_AXE)) {
            return speed4;
        }

        return 10;
    }
}
