package com.starfish_studios.naturalist.client.model;

import com.starfish_studios.naturalist.Naturalist;
import com.starfish_studios.naturalist.entity.Elephant;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

import java.util.List;

@Environment(EnvType.CLIENT)
public class ElephantModel extends AnimatedGeoModel<Elephant> {
    @Override
    public Identifier getModelLocation(Elephant elephant) {
        return new Identifier(Naturalist.MOD_ID, "geo/elephant.geo.json");
    }

    @Override
    public Identifier getTextureLocation(Elephant elephant) {
        return new Identifier(Naturalist.MOD_ID, elephant.isDirty() ? "textures/entity/elephant_dirt.png" : "textures/entity/elephant.png");
    }

    @Override
    public Identifier getAnimationFileLocation(Elephant elephant) {
        return new Identifier(Naturalist.MOD_ID, "animations/elephant.animation.json");
    }

    @Override
    public void setLivingAnimations(Elephant elephant, Integer uniqueID, @Nullable AnimationEvent customPredicate) {
        super.setLivingAnimations(elephant, uniqueID, customPredicate);

        if (customPredicate == null) return;

        List<EntityModelData> extraDataOfType = customPredicate.getExtraDataOfType(EntityModelData.class);
        IBone head = this.getAnimationProcessor().getBone("head");
        IBone bigTusks = this.getAnimationProcessor().getBone("tusks");
        IBone smallTusks = this.getAnimationProcessor().getBone("baby_tusks");
        IBone babyTrunk = this.getAnimationProcessor().getBone("trunk4");

        if (elephant.isBaby()) {
            head.setScaleX(1.5F);
            head.setScaleY(1.5F);
            head.setScaleZ(1.5F);
        }

        bigTusks.setHidden(elephant.isBaby());
        smallTusks.setHidden(elephant.isBaby());
        smallTusks.setHidden(!elephant.isBaby());

        babyTrunk.setHidden(elephant.isBaby());

//        head.setRotationX(extraDataOfType.get(0).headPitch * Mth.DEG_TO_RAD);
        head.setRotationY(extraDataOfType.get(0).netHeadYaw * MathHelper.RADIANS_PER_DEGREE);
    }
}
