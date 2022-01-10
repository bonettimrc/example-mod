package com.example.examplemod.block;

import java.util.function.Predicate;

import com.example.examplemod.entity.ExampleModEntityTypes;
import com.example.examplemod.entity.FederichiteGolemEntity;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.pattern.BlockMaterialMatcher;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.block.pattern.BlockPatternBuilder;
import net.minecraft.block.pattern.BlockStateMatcher;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.CachedBlockInfo;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

//not really the golemHeadBlock, just need to place the logic to spawn a golem somewhere, I don't like the idea of extending the carved pumpkin. 
// Btw, i copied the idea from extra-golems mod
public class GolemHeadBlock extends HorizontalBlock {
    private static BlockPattern federichiteGolemFull;
    private static final Predicate<BlockState> PUMPKINS_PREDICATE = (blockState) -> {
        return blockState != null && (blockState.is(Blocks.CARVED_PUMPKIN) || blockState.is(Blocks.JACK_O_LANTERN));
    };

    protected GolemHeadBlock(Properties p_i48377_1_) {
        super(p_i48377_1_);
    }

    public static void trySpawnGolem(World world, BlockPos blockPos) {
        BlockPattern.PatternHelper blockpattern$patternhelper = getOrCreateFederichiteGolemFull().find(world,
                blockPos);
        if (blockpattern$patternhelper != null) {
            // puts air blocks in place of the golem block pattern
            for (int j = 0; j < getOrCreateFederichiteGolemFull().getWidth(); ++j) {
                for (int k = 0; k < getOrCreateFederichiteGolemFull().getHeight(); ++k) {
                    CachedBlockInfo cachedblockinfo2 = blockpattern$patternhelper.getBlock(j, k, 0);
                    world.setBlock(cachedblockinfo2.getPos(), Blocks.AIR.defaultBlockState(), 2);
                    // dunno what this is, probably important but anyway
                    world.levelEvent(2001, cachedblockinfo2.getPos(), Block.getId(cachedblockinfo2.getState()));
                }
            }

            BlockPos blockpos = blockpattern$patternhelper.getBlock(1, 2, 0).getPos();
            FederichiteGolemEntity federichitegolementity = (FederichiteGolemEntity) ExampleModEntityTypes.FEDERICHITE_GOLEM
                    .get().create(world);
            federichitegolementity.setPlayerCreated(true);
            // i suppose this centers it in block?
            federichitegolementity.moveTo((double) blockpos.getX() + 0.5D, (double) blockpos.getY() + 0.05D,
                    (double) blockpos.getZ() + 0.5D, 0.0F, 0.0F);
            world.addFreshEntity(federichitegolementity);
            // updates foreach player that there is a golem now?
            // why inflating it tough?
            for (ServerPlayerEntity serverplayerentity1 : world.getEntitiesOfClass(ServerPlayerEntity.class,
                    federichitegolementity.getBoundingBox().inflate(5.0D))) {
                CriteriaTriggers.SUMMONED_ENTITY.trigger(serverplayerentity1, federichitegolementity);
            }
            // what the hell why not updating automatically when setBlock is called?
            for (int i1 = 0; i1 < getOrCreateFederichiteGolemFull().getWidth(); ++i1) {
                for (int j1 = 0; j1 < getOrCreateFederichiteGolemFull().getHeight(); ++j1) {
                    CachedBlockInfo cachedblockinfo1 = blockpattern$patternhelper.getBlock(i1, j1, 0);
                    world.blockUpdated(cachedblockinfo1.getPos(), Blocks.AIR);
                }
            }

        }

    }

    // gets the blockPattern for a golem
    private static BlockPattern getOrCreateFederichiteGolemFull() {
        if (federichiteGolemFull == null) {
            federichiteGolemFull = BlockPatternBuilder.start().aisle("~^~", "###", "~#~")
                    .where('^', CachedBlockInfo.hasState(PUMPKINS_PREDICATE))
                    .where('#',
                            CachedBlockInfo
                                    .hasState(BlockStateMatcher.forBlock(ExampleModBlocks.FEDERICHITE_BLOCK.get())))
                    .where('~', CachedBlockInfo.hasState(BlockMaterialMatcher.forMaterial(Material.AIR))).build();
        }

        return federichiteGolemFull;
    }
}
