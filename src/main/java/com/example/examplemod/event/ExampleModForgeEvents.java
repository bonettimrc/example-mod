package com.example.examplemod.event;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.block.GolemHeadBlock;

import net.minecraft.block.Blocks;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ExampleMod.ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ExampleModForgeEvents {
    @SubscribeEvent
    public static void onPlacePumpkin(final BlockEvent.EntityPlaceEvent event) {
        // if the block is a CARVED pumpkin... don't really know why u need to check for
        // instance world though
        if (!event.isCanceled() && event.getPlacedBlock().getBlock() == Blocks.CARVED_PUMPKIN
                && event.getWorld() instanceof World) {
            // try to spawn a golem!
            GolemHeadBlock.trySpawnGolem((World) event.getWorld(), event.getPos());
        }
    }

}
