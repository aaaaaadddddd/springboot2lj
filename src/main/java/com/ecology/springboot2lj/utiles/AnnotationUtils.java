package com.ecology.springboot2lj.utiles;


import org.apache.ibatis.javassist.ClassPool;
import org.apache.ibatis.javassist.CtClass;
import org.apache.ibatis.javassist.CtMethod;
import org.apache.ibatis.javassist.NotFoundException;
import org.apache.ibatis.javassist.bytecode.AnnotationsAttribute;
import org.apache.ibatis.javassist.bytecode.ConstPool;
import org.apache.ibatis.javassist.bytecode.MethodInfo;
import org.apache.ibatis.javassist.bytecode.annotation.Annotation;
import org.apache.ibatis.javassist.bytecode.annotation.StringMemberValue;

public class AnnotationUtils {
    private static AnnotationUtils mInstance;

    public AnnotationUtils() {
    }

    public static AnnotationUtils get() {
        if (mInstance == null) {
            synchronized (AnnotationUtils.class) {
                if (mInstance == null) {
                    mInstance = new AnnotationUtils();
                }
            }
        }
        return mInstance;
    }

    /**
     * 修改注解上的属性值
     *
     * @param className  当前类名
     * @param methodName 当前方法名
     * @param annoName   方法上的注解名
     * @param fieldName  注解中的属性名
     * @param fieldValue 注解中的属性值
     */
    public void setAnnotatioinFieldValue(String className, String methodName, String annoName, String fieldName, String fieldValue) throws NotFoundException {
        ClassPool classPool = ClassPool.getDefault();
        CtClass ct = classPool.get(className);
        CtMethod ctMethod = ct.getDeclaredMethod(methodName);
        MethodInfo methodInfo = ctMethod.getMethodInfo();
        ConstPool constPool = methodInfo.getConstPool();
        AnnotationsAttribute attr = (AnnotationsAttribute) methodInfo.getAttribute(AnnotationsAttribute.visibleTag);
        Annotation annotation = attr.getAnnotation(annoName);
        if (annotation != null) {
            annotation.addMemberValue(fieldName, new StringMemberValue(fieldValue, constPool));
            attr.setAnnotation(annotation);
            methodInfo.addAttribute(attr);
        }
    }

    /**
     * 获取注解中的属性值
     *
     * @param className  当前类名
     * @param methodName 当前方法名
     * @param annoName   方法上的注解名
     * @param fieldName  注解中的属性名
     * @return
     * @throws NotFoundException
     */
    public String getAnnotatioinFieldValue(String className, String methodName, String annoName, String fieldName) throws NotFoundException {
        ClassPool classPool = ClassPool.getDefault();
        CtClass ct = classPool.get(className);
        CtMethod ctMethod = ct.getDeclaredMethod(methodName);
        MethodInfo methodInfo = ctMethod.getMethodInfo();
        AnnotationsAttribute attr = (AnnotationsAttribute) methodInfo.getAttribute(AnnotationsAttribute.visibleTag);
        String value = "";
        if (attr != null) {
            Annotation an = attr.getAnnotation(annoName);
            if (an != null)
                value = ((StringMemberValue) an.getMemberValue(fieldName)).getValue();
        }
        return value;
    }

}
