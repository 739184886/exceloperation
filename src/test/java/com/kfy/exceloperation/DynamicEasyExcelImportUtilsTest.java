package com.kfy.exceloperation;

import com.alibaba.excel.util.IoUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DynamicEasyExcelImportUtilsTest {

    @Test
    public void parseExcelToView() {
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File("C:\\WORKTOOL\\easyexcel-export-user5.xlsx"));
//        FileInputStream inputStream = new FileInputStream(new File("/Users/panzhi/Documents/easyexcel-export-user5.xlsx"));
            byte[] stream = IoUtils.toByteArray(inputStream);
            List<Map<String,String>> dataList = DynamicEasyExcelImportUtils.parseExcelToView(stream, 2);
            System.out.println(JsonUtil.objectToJson(dataList));
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}