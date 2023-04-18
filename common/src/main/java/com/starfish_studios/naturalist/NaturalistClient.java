package com.starfish_studios.naturalist;

import com.starfish_studios.naturalist.client.renderer.*;
import com.starfish_studios.naturalist.platform.ClientPlatformHelper;
import com.starfish_studios.naturalist.registry.NaturalistBlocks;
import com.starfish_studios.naturalist.registry.NaturalistEntityTypes;
import net.minecraft.client.renderer.RenderType;

public class NaturalistClient {
    public static void init() {
        ClientPlatformHelper.setRenderLayer(NaturalistBlocks.CHRYSALIS, RenderType.cutout());
        ClientPlatformHelper.setRenderLayer(NaturalistBlocks.AZURE_FROGLASS, RenderType.translucent());
        ClientPlatformHelper.setRenderLayer(NaturalistBlocks.VERDANT_FROGLASS, RenderType.translucent());
        ClientPlatformHelper.setRenderLayer(NaturalistBlocks.CRIMSON_FROGLASS, RenderType.translucent());

        ClientPlatformHelper.setRenderLayer(NaturalistBlocks.CATTAIL, RenderType.cutout());
        ClientPlatformHelper.setRenderLayer(NaturalistBlocks.DUCKWEED, RenderType.cutout());

        ClientPlatformHelper.registerEntityRenderers(NaturalistEntityTypes.SNAIL, SnailRenderer::new);
        ClientPlatformHelper.registerEntityRenderers(NaturalistEntityTypes.BEAR, BearRenderer::new);
        ClientPlatformHelper.registerEntityRenderers(NaturalistEntityTypes.BUTTERFLY, ButterflyRenderer::new);
        ClientPlatformHelper.registerEntityRenderers(NaturalistEntityTypes.FIREFLY, FireflyRenderer::new);
        ClientPlatformHelper.registerEntityRenderers(NaturalistEntityTypes.SNAKE, SnakeRenderer::new);
        ClientPlatformHelper.registerEntityRenderers(NaturalistEntityTypes.CORAL_SNAKE, SnakeRenderer::new);
        ClientPlatformHelper.registerEntityRenderers(NaturalistEntityTypes.RATTLESNAKE, SnakeRenderer::new);
        ClientPlatformHelper.registerEntityRenderers(NaturalistEntityTypes.DEER, DeerRenderer::new);
        ClientPlatformHelper.registerEntityRenderers(NaturalistEntityTypes.BLUEJAY, BirdRenderer::new);
        ClientPlatformHelper.registerEntityRenderers(NaturalistEntityTypes.CARDINAL, BirdRenderer::new);
        ClientPlatformHelper.registerEntityRenderers(NaturalistEntityTypes.CANARY, BirdRenderer::new);
        ClientPlatformHelper.registerEntityRenderers(NaturalistEntityTypes.ROBIN, BirdRenderer::new);
        ClientPlatformHelper.registerEntityRenderers(NaturalistEntityTypes.CATERPILLAR, CaterpillarRenderer::new);
        ClientPlatformHelper.registerEntityRenderers(NaturalistEntityTypes.RHINO, RhinoRenderer::new);
        ClientPlatformHelper.registerEntityRenderers(NaturalistEntityTypes.LION, LionRenderer::new);
        ClientPlatformHelper.registerEntityRenderers(NaturalistEntityTypes.ELEPHANT, ElephantRenderer::new);
        ClientPlatformHelper.registerEntityRenderers(NaturalistEntityTypes.ZEBRA, ZebraRenderer::new);
        ClientPlatformHelper.registerEntityRenderers(NaturalistEntityTypes.GIRAFFE, GiraffeRenderer::new);
        ClientPlatformHelper.registerEntityRenderers(NaturalistEntityTypes.HIPPO, HippoRenderer::new);
        ClientPlatformHelper.registerEntityRenderers(NaturalistEntityTypes.VULTURE, VultureRenderer::new);
        ClientPlatformHelper.registerEntityRenderers(NaturalistEntityTypes.BOAR, BoarRenderer::new);
        ClientPlatformHelper.registerEntityRenderers(NaturalistEntityTypes.DRAGONFLY, DragonflyRenderer::new);
        ClientPlatformHelper.registerEntityRenderers(NaturalistEntityTypes.CATFISH, CatfishRenderer::new);
        ClientPlatformHelper.registerEntityRenderers(NaturalistEntityTypes.ALLIGATOR, AlligatorRenderer::new);
        ClientPlatformHelper.registerEntityRenderers(NaturalistEntityTypes.BASS, BassRenderer::new);
        ClientPlatformHelper.registerEntityRenderers(NaturalistEntityTypes.LIZARD, LizardRenderer::new);
        ClientPlatformHelper.registerEntityRenderers(NaturalistEntityTypes.LIZARD_TAIL, LizardTailRenderer::new);
        ClientPlatformHelper.registerEntityRenderers(NaturalistEntityTypes.TORTOISE, TortoiseRenderer::new);
        ClientPlatformHelper.registerEntityRenderers(NaturalistEntityTypes.DUCK, DuckRenderer::new);
    }
}
