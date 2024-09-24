package net.vlad.clickkill.item.custom;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class KillPlayerItem extends Item {

    public KillPlayerItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext pContext) {
        Player player = pContext.getPlayer();
        if (player != null) {
//            player.hurt(player.level().damageSources().generic(), player.getHealth()); // Damage the player for all their health
            MinecraftServer server = pContext.getLevel().getServer();
            if (server != null) {
                server.getCommands().performPrefixedCommand(player.createCommandSourceStack(), "/kill " + player.getName().getString());
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level pLevel, @NotNull Player pPlayer, @NotNull InteractionHand pUsedHand) {
        if (!pLevel.isClientSide()) {
            MinecraftServer server = pLevel.getServer();
            if (server != null) {
                server.getCommands().performPrefixedCommand(pPlayer.createCommandSourceStack(), "/kill " + pPlayer.getName().getString());
            }
        }
        return InteractionResultHolder.success(pPlayer.getItemInHand(pUsedHand));
    }

}
