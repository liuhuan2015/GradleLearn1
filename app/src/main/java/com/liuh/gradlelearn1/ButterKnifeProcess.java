package com.liuh.gradlelearn1;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ButterKnifeProcess {

    /**
     * 绑定Activity
     *
     * @param activity
     */
    public static void bind(final Activity activity) {
        Class annotationParent = activity.getClass();
        Field[] fields = annotationParent.getDeclaredFields();
        Method[] methods = annotationParent.getDeclaredMethods();

        for (final Field field : fields) {
            //找到添加了BindView注解的属性
            BindView bindViewClass = field.getAnnotation(BindView.class);
            if (bindViewClass != null && bindViewClass.value() != 0) {
                int id = bindViewClass.value();
                View view = activity.findViewById(id);

                try {
                    field.setAccessible(true);
                    field.set(activity, view);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
