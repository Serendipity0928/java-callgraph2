package com.adrninistrator.javacg.extensions.code_parser;

import com.adrninistrator.javacg.dto.ClassInterfaceMethodInfo;
import com.adrninistrator.javacg.dto.ExtendsClassMethodInfo;
import com.adrninistrator.javacg.extensions.dto.ExtendedData;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.generic.InstructionHandle;
import org.apache.bcel.generic.MethodGen;
import org.apache.bcel.generic.Type;

import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @author Adrninistrator
 * @date 2021/8/10
 * @description:
 */
public interface CustomCodeParserInterface {

    /**
     * 初始化，整个执行过程中只执行一次
     */
    void init();

    /**
     * 开始处理一个jar包
     *
     * @param jarFilePath
     */
    default void handleJar(String jarFilePath) {
    }

    /**
     * 处理一个jar包中的文件
     *
     * @param jarFile
     * @param jarEntry
     */
    default void handleJarEntryFile(JarFile jarFile, JarEntry jarEntry) {
    }

    /**
     * 对一个Class进行预处理
     *
     * @param javaClass
     */
    default void preHandleClass(JavaClass javaClass) {
    }

    /**
     * 对一个Class进行处理
     *
     * @param javaClass
     */
    default void handleClass(JavaClass javaClass) {
    }

    /**
     * 对一个方法调用进行预处理
     *
     * @param callId
     * @param calleeClassName
     * @param calleeMethodName
     * @param arguments
     * @param mcIh
     * @param methodGen
     */
    default void handleMethodCall(int callId, String calleeClassName, String calleeMethodName, Type[] arguments, InstructionHandle mcIh, MethodGen methodGen) {
    }

    /**
     * 返回已获得的自定义数据，整个执行过程中只执行一次
     *
     * @return
     */
    List<ExtendedData> getExtendedDataList();

    /**
     * 返回当前的自定义数据类型
     *
     * @return
     */
    String getDataType();

    /**
     * 接收保存涉及继承类的Map信息
     *
     * @param extendsClassMethodInfoMap
     */
    default void setExtendsClassMethodInfoMap(Map<String, ExtendsClassMethodInfo> extendsClassMethodInfoMap) {
    }

    /**
     * 接收保存类实现接口的Map信息
     *
     * @param classInterfaceMethodInfoMap
     */
    default void setClassInterfaceMethodInfoMap(Map<String, ClassInterfaceMethodInfo> classInterfaceMethodInfoMap) {
    }
}
