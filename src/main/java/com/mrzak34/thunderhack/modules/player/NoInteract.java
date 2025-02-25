package com.mrzak34.thunderhack.modules.player;

import com.mrzak34.thunderhack.events.ClickBlockEvent;
import com.mrzak34.thunderhack.events.PacketEvent;
import com.mrzak34.thunderhack.modules.Module;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.network.play.server.SPacketOpenWindow;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class NoInteract extends Module {
    public NoInteract() {
        super("NoInteract", "не посылать пакеты-использования блоков", Category.PLAYER);
    }

    @SubscribeEvent
    public void onInteract(ClickBlockEvent.Right event) {
        Block block = mc.world.getBlockState(event.getPos()).getBlock();
        if (block == Blocks.ANVIL
                || block == Blocks.CRAFTING_TABLE
                || block == Blocks.ACACIA_FENCE_GATE
                || block == Blocks.BIRCH_FENCE_GATE
                || block == Blocks.DARK_OAK_FENCE_GATE
                || block == Blocks.JUNGLE_FENCE_GATE
                || block == Blocks.SPRUCE_FENCE_GATE
                || block == Blocks.OAK_FENCE_GATE
                || block == Blocks.CHEST
                || block == Blocks.ENDER_CHEST
                || block == Blocks.ENCHANTING_TABLE
                || block == Block.getBlockById(63)  // стойка для брони
                || block == Blocks.FURNACE
                || block == Blocks.LIT_FURNACE
        ) {
            event.setCanceled(true);
        }
    }
}
