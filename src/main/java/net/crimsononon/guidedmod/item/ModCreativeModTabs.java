package net.crimsononon.guidedmod.item;

import net.crimsononon.guidedmod.GuidedMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GuidedMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> NEW_ITEMS_TAB = CREATIVE_MODE_TABS.register("new_items",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.LEAD.get()))
                    .title(Component.translatable("creativetab.new_items_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        for(RegistryObject<Item> item: ModItems.ITEMS.getEntries()) {
                            pOutput.accept(item.get());
                        }
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
