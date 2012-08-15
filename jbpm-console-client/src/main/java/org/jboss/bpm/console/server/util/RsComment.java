package org.jboss.bpm.console.server.util;

import static org.jboss.bpm.console.server.util.ProjectName.*;

@java.lang.annotation.Target(value = {java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.METHOD}) @java.lang.annotation.Retention(value = java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface RsComment {

    java.lang.String title() default "";
    java.lang.String description() default "";
    ProjectName[] project() default {RIFTSAW, JBPM};
    java.lang.String example() default  "";
}
