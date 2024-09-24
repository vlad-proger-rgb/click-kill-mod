package net.vlad.clickkill.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.vlad.clickkill.ClickKillMod;
import net.vlad.clickkill.item.custom.KillPlayerItem;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ClickKillMod.MOD_ID);

    public static final RegistryObject<Item> KILL_PLAYER = ITEMS.register("kill_player",
            () -> new KillPlayerItem(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
