package org.firstinspires.ftc.teamcode.utility.autonomous;

public @interface AutoRoutine {
    String name();
    boolean park() default false;
    int cycles() default 0;
    int preload() default 0;
}
