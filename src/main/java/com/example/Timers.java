package com.example;

import com.ibm.icu.text.Transliterator;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.references.BlockIds;
import net.minecraft.resources.Identifier;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Timer;

public class Timers {


    public static final String MOD_ID = "mrmods";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


    int tick;
    int tickEnd;
    int TimerActive;
    int TimerEnd;
    int TimerStarted;


    public Timers(){
        tick = 0;
        tickEnd = 0;
        TimerActive = 0;
        TimerEnd = 0;
        TimerStarted = 0;
        LOGGER.info("Таймер Иницилизирован");

        ServerTickEvents.END_SERVER_TICK.register(server -> {
            if(TimerStarted == 1){
                if(tickEnd != 0 && TimerActive == 1){
                    tick += 1;
                    LOGGER.info("прибавлен тик тиков всего:\n {}", + tick);
                }

                if(tick >= tickEnd){
                    LOGGER.info("Таймер Окончил свою работу всего тиков:\n {}", + tick);
                    TimerActive = 0;
                    TimerEnd = 1;
                    TimerStarted = 0;
                    tick = 0;

                    LOGGER.info("TimerEnd:\n {}", + TimerEnd);


                }
            }


        });
    }


    public void TimerStart(int timerEnd){
        tickEnd = timerEnd;
        TimerActive = 1;
        TimerEnd = 0;
        TimerStarted = 1;


        LOGGER.info("Таймер создан со значением:\n {}", + tickEnd);


    }

}
