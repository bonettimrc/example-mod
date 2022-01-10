package com.example.examplemod.block;

import com.example.examplemod.ExampleMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ExampleModBlocks {
        public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
                        ExampleMod.ID);
        public static final RegistryObject<Block> FEDERICHITE_ORE = BLOCKS.register("federichite_ore",
                        () -> new Block(Block.Properties.of(Material.STONE).harvestLevel(2)
                                        .harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(5f)));
        public static final RegistryObject<Block> FEDERICHITE_BLOCK = BLOCKS.register("federichite_block",
                        () -> new Block(Block.Properties.of(Material.STONE).harvestLevel(2)
                                        .harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(5f)));

        public static void register(IEventBus eventBus) {
                BLOCKS.register(eventBus);
        }

}
