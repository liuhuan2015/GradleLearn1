package com.liuh.plugin;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class MyPlugin1 implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        System.out.println("========================");
        System.out.println("hello gradle plugin!");
        System.out.println("========================");
    }
}
