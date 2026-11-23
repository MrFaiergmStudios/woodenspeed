package com.example;


import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayDeque;
import java.util.Queue;

public class ExampleMod implements ModInitializer {
	public static final String MOD_ID = "mrmods";


	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	private final Queue<BlockPos> blockPosSpisok = new ArrayDeque<>();

	public Timers timer = new Timers();

	public AxeFunction AxeFnction = new AxeFunction();

	int while1 = 1;

	int timeinBreakWood = 0;

	Level worldGl = null;


	@Override
	public void onInitialize() {

		PlayerBlockBreakEvents.BEFORE.register((world, player, pos, state, blockEntity) -> {
			ItemStack PlayerHalde = player.getMainHandItem();
			Item PlayerHandItem = PlayerHalde.getItem();

			worldGl = world;
			if (!world.isClientSide() && state.is(BlockTags.LOGS) && PlayerHandItem instanceof AxeItem) {
				BlockPos positionBlock = pos;
				BlockPos positionBlockInUp = positionBlock;

				int blocks = 0;

				timeinBreakWood = AxeFnction.speedAxe(PlayerHalde);

				LOGGER.info("timewood:\n {}", + timeinBreakWood);

				while1 = 1;

				if (while1 == 1) {
					LOGGER.info("Вызван цикл");
				}
				while (while1 == 1) {
					positionBlockInUp = positionBlockInUp.above();
					if (world.getBlockState(positionBlockInUp).is(BlockTags.LOGS)) {
						blockPosSpisok.add(positionBlockInUp);
					} else if (!world.getBlockState(positionBlockInUp).is(BlockTags.LOGS)) {
						while1 = 0;
						LOGGER.info("цикл был завершен бревнов насчитанно:" + blockPosSpisok.size());
						positionBlockInUp = positionBlock;
						blocks = blockPosSpisok.size();
						LOGGER.info("Таймер был запущен");
						timer.TimerStart(timeinBreakWood);
						break;
					}
				}
			}
			return true;


		});

		ServerTickEvents.END_SERVER_TICK.register(server -> {

			if (while1 == 0 && !blockPosSpisok.isEmpty()) {
				int timerEnd = timer.TimerEnd;
				if(timerEnd == 1){
					BlockPos blockisBreaks = blockPosSpisok.poll();
					LOGGER.info("Блок Был сломан");
					worldGl.destroyBlock(blockisBreaks, true);
					if(!blockPosSpisok.isEmpty()){
						timer.TimerStart(timeinBreakWood);
						LOGGER.info("новый таймер был заведен");
					}
				}
			}
		});

	}

	public static ResourceLocation id(String path) {
		return new ResourceLocation(MOD_ID, path);
	}
}
