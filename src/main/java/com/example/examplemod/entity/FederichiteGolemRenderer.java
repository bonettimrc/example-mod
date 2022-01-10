package com.example.examplemod.entity;

import com.example.examplemod.ExampleMod;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.IronGolemRenderer;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.util.ResourceLocation;

public class FederichiteGolemRenderer extends IronGolemRenderer {
    private static final ResourceLocation GOLEM_LOCATION = new ResourceLocation(ExampleMod.ID,
            "textures/entity/federichite_golem/federichite_golem.png");

    public FederichiteGolemRenderer(EntityRendererManager entityRendererManager) {
        super(entityRendererManager);
    }

    @Override
    public ResourceLocation getTextureLocation(IronGolemEntity ironGolemEntity) {
        return GOLEM_LOCATION;
    }
}
