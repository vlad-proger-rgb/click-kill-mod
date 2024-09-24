package net.vlad.clickkill.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.vlad.clickkill.ClickKillMod;

public class ModCreativeModTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ClickKillMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> KILL_PLAYER_TAB = CREATIVE_MODE_TABS.register("kill_player_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.KILL_PLAYER.get()))
                    .title(Component.translatable("creativetab.kill_player_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.KILL_PLAYER.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
