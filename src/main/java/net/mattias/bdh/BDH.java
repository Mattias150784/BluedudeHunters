package net.mattias.bdh;

import net.mattias.bdh.core.block.ModBlocks;
import net.mattias.bdh.core.item.ModCreativeModeTabs;
import net.mattias.bdh.core.item.ModItems;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;


@Mod(BDH.MOD_ID)
public class BDH {

    public static final String MOD_ID = "bdh";
    public static final Logger LOGGER = LogUtils.getLogger();

    public BDH(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModCreativeModeTabs.register(modEventBus);


        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.BLUE_OLEANDER.getId(), ModBlocks.POTTED_BLUE_OLEANDER);
        });
    }


    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }
}
