package org.daamky.mixin;

import net.minecraft.client.render.entity.state.EntityRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import ua.daamky.render.EntityRenderIdAccess;

@Mixin(EntityRenderState.class)
public abstract class EntityRenderStateMixin implements EntityRenderIdAccess {
   @Unique
   private int wild$entityId = Integer.MIN_VALUE;

   @Override
   public int wild$getEntityId() {
      return this.wild$entityId;
   }

   @Override
   public void wild$setEntityId(int var1) {
      this.wild$entityId = var1;
   }
}
