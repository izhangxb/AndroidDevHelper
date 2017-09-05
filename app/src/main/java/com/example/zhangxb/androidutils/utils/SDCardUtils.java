package com.example.zhangxb.androidutils.utils;

import android.os.Environment;
import android.os.StatFs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @Description: SD卡辅助工具类
 * @Author: carl
 * @Date: 2015/12/25
 */
public class SDCardUtils {

    private SDCardUtils() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 检测SD卡是否可用
     *
     * @return 是否可用
     */
    public static boolean isSDCardAvailable() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    /**
     * 获取系统SD卡路径
     *
     * @return
     */
    public static String getSDCardPath() {
        return Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator;
    }

    public static String getRootDirectoryPath() {
        return Environment.getRootDirectory().getAbsolutePath();
    }

    /**
     * 获取SD卡的剩余容量，单位：byte
     *
     * @return
     */
    public static long getSDCardUsefulSize() {
        if (isSDCardAvailable()) {
            StatFs stat = new StatFs(getSDCardPath());
            //获取空闲的数据块的数量
            long availableBlocks = stat.getAvailableBlocks();
            //获取单个数据块的大小（byte）
            int mBlocksSize = stat.getBlockSize();
            return mBlocksSize * availableBlocks;
        }
        return 0;
    }

    /**
     * 获取SD卡的容量，单位：byte
     *
     * @return
     */
    public static long getSDCardAllSize() {
        if (isSDCardAvailable()) {
            StatFs stat = new StatFs(getSDCardPath());
            //获取空闲的数据块的数量
            long allBlocks = stat.getBlockCount();
            //获取单个数据块的大小（byte）
            int mBlocksSize = stat.getBlockSize();
            return mBlocksSize * allBlocks;
        }
        return 0;
    }

    /**
     * 检测文件是否存在
     *
     * @param filePath 文件路径
     * @param fileName 文件名
     * @return 是否存在文件
     */
    public static boolean isFileExistsInSDCard(String filePath, String fileName) {
        boolean flag = false;
        if (isSDCardAvailable()) {
            File file = new File(filePath, fileName);
            if (file.exists()) {
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 将文件写入SD卡
     *
     * @param filePath：    路径名
     * @param fileName：文件名
     * @param content：写入内容
     * @return 是否写入成功
     * @throws Exception
     */
    public static boolean saveFileToSDCard(String filePath, String fileName, String content) throws Exception {
        boolean flag = false;
        if (isSDCardAvailable()) {
            File dir = new File(filePath);
            if (!dir.exists()) {
                dir.mkdir();
            }
            File file = new File(filePath, fileName);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(content.getBytes());
            fileOutputStream.close();
            flag = true;
        }
        return flag;
    }

    /**
     * 从SD卡读取文件
     *
     * @param filePath 文件路径
     * @param fileName 文件名
     * @return byte数组
     */
    public static byte[] readFileFormSDCard(String filePath, String fileName) {
        byte[] buffer = null;
        try {
            if (isSDCardAvailable()) {
                String path = filePath + File.separator + fileName;
                FileInputStream inputStream = new FileInputStream(path);
                //在读写操作前先得知数据流里有多少个字节可以读取
                int length = inputStream.available();
                buffer = new byte[length];
                inputStream.read(buffer);
                inputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer;
    }

    /**
     * 删除文件
     *
     * @param filePath 文件路径
     * @param fileName 文件名
     * @return 删除结果
     */
    public static boolean deleteSDCardFile(String filePath, String fileName) {
        File file = new File(filePath + File.separator + fileName);
        if (!file.exists() || file.isDirectory()) {
            return false;
        }
        return file.delete();
    }
}
