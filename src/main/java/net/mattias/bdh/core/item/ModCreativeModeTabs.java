package net.mattias.bdh.core.item;

import net.mattias.bdh.BDH;
import net.mattias.bdh.core.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BDH.MOD_ID);

    public static final Supplier<CreativeModeTab> BDH_TAB =
            CREATIVE_MODE_TABS.register("bdh_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.bdh"))
                    .icon(() -> new ItemStack(ModBlocks.BLUE_OLEANDER))
                    .displayItems((pParameters, pOutput) -> {

                        pOutput.accept(ModBlocks.BLUE_OLEANDER);

                    }).build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}