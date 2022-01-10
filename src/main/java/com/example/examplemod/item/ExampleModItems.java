package com.example.examplemod.item;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.block.ExampleModBlocks;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ExampleModItems {
        public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
                        ExampleMod.ID);

        public static final RegistryObject<Item> FEDERICHITE_ORE_ITEM = ITEMS.register("federichite_ore",
                        () -> new BlockItem(ExampleModBlocks.FEDERICHITE_ORE.get(),
                                        new Item.Properties().tab(ExampleMod.ITEM_GROUP)));

        public static final RegistryObject<Item> FEDERICHITE_BLOCK_ITEM = ITEMS.register("federichite_block",
                        () -> new BlockItem(ExampleModBlocks.FEDERICHITE_BLOCK.get(),
                                        new Item.Properties().tab(ExampleMod.ITEM_GROUP)));
        public static final RegistryObject<Item> FEDERICHITE = ITEMS.register("federichite",
                        () -> new Item(new Item.Properties().tab(ExampleMod.ITEM_GROUP)));

        public static void register(IEventBus eventBus) {
                ITEMS.register(eventBus);
        }
}
