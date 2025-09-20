package co.dekoderpy.tutorialmod.block.custom;

import co.dekoderpy.tutorialmod.block.ModBlocks;
import co.dekoderpy.tutorialmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MagicBlock extends Block {

    public MagicBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        world.playSound(player, pos, SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, SoundCategory.BLOCKS, 2.5f, 1f);
        return ActionResult.SUCCESS;
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof ItemEntity itemEntity) {
            if (itemEntity.getStack().getItem() == ModItems.RAW_PINK_GARNET) {
                itemEntity.setStack(new ItemStack(Items.DIAMOND, itemEntity.getStack().getCount()));
                world.playSound(entity, pos, SoundEvents.BLOCK_AMETHYST_BLOCK_RESONATE, SoundCategory.BLOCKS, 2f, 1f);
                world.setBlockState(pos, ModBlocks.PINK_GARNET_BLOCK.getDefaultState());


            }
        } else if (entity instanceof PlayerEntity playerEntity) {
            playerEntity.giveItemStack(new ItemStack(ModItems.CHISEL, 1));
            world.playSound(entity, pos, SoundEvents.BLOCK_AMETHYST_BLOCK_RESONATE, SoundCategory.BLOCKS, 2f, 1f);
            world.setBlockState(pos, ModBlocks.PINK_GARNET_BLOCK.getDefaultState());
        }

        super.onSteppedOn(world, pos, state, entity);
    }
}
