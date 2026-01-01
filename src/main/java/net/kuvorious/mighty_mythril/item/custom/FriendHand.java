package net.kuvorious.mighty_mythril.item.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;
import java.util.Properties;

public class FriendHand extends Item {
    private static final Map<Block, Block> FRIEND_MAP =
            Map.of(
              Blocks.STONE, Blocks.STONE_BRICKS,
              Blocks.END_STONE, Blocks.END_STONE_BRICKS,
              Blocks.DEEPSLATE, Blocks.DEEPSLATE_BRICKS,
                    Blocks.SANDSTONE, Blocks.CHISELED_SANDSTONE
            );

    public FriendHand(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        if(FRIEND_MAP.containsKey(clickedBlock)) {
            if(!level.isClientSide()) {
                //ONLY ON CLIENT
                level.setBlockAndUpdate(context.getClickedPos(), FRIEND_MAP.get(clickedBlock).defaultBlockState());

                context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, context.getClickedPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS);
            }

        }


        return super.useOn(context);
    }
}
