package ua.daamky.api.module;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import ua.daamky.profile.Role;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ModuleRoles {
   Role handle() default Role.DEFAULT;

   Role[] process() default {};

   String[] compute() default {};

   int[] resolve() default {};
}
