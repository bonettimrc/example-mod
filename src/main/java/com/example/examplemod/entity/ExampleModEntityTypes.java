package com.example.examplemod.entity;

import com.example.examplemod.ExampleMod;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ExampleModEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES,
            ExampleMod.ID);

    public static final RegistryObject<EntityType<FederichiteGolemEntity>> FEDERICHITE_GOLEM = ENTITY_TYPES.register(
            "federichite_golem",
            () -> EntityType.Builder.of(FederichiteGolemEntity::new,
                    EntityClassification.MISC).sized(1f, 3f)
                    .build(new ResourceLocation(ExampleMod.ID, "federichite_golem").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}