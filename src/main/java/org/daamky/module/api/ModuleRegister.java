package org.daamky.module.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import ua.daamky.api.module.ModuleCategory;
import ua.daamky.api.module.ModuleFlag;

@Retention(RetentionPolicy.RUNTIME)
public @interface ModuleRegister {
   String name();

   String description();

   ModuleCategory category();

   ModuleFlag[] flags() default {};
}
