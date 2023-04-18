package com.starfish_studios.naturalist.entity;

import com.starfish_studios.naturalist.registry.NaturalistRegistry;
import com.starfish_studios.naturalist.registry.NaturalistSoundEvents;
import com.starfish_studios.naturalist.registry.NaturalistTags;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class Catfish extends AbstractFish implements IAnimatable {
    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);

    public Catfish(EntityType<? extends AbstractFish> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 6.0).add(Attributes.ATTACK_DAMAGE, 1.0D);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2D, false));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, WaterAnimal.class, 10, true, false, (entity) -> entity.getType().is(NaturalistTags.EntityTypes.CATFISH_HOSTILES)));
    }

    @Override
    protected SoundEvent getFlopSound() {
        return NaturalistSoundEvents.CATFISH_FLOP.get();
    }

    @Override
    public ItemStack getBucketItemStack() {
        return new ItemStack(NaturalistRegistry.CATFISH_BUCKET.get());
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (!this.isInWater()) {
            event.getController().setAnimation(new AnimationBuilder().loop("catfish.flop"));
        } else {
            event.getController().setAnimation(new AnimationBuilder().loop("catfish.swim"));
        }
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.setResetSpeedInTicks(5);
        data.addAnimationController(new AnimationController<>(this, "controller", 5, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }
}
