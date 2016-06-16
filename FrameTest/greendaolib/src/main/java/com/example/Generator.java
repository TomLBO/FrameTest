package com.example;


import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;


public class Generator {
    public static void main(String[] args) throws Exception{
        //更新数据库 只需增加版本号
        int version = 5;
        String defaultPackage = "test.greenDAO.bean";
        //创建模式对象，指定版本号和自动生成的bean对象的包名
        Schema schema = new Schema(version, defaultPackage);
        //指定自动生成的dao对象的包名,不指定则都DAO类生成在"test.greenDAO.bean"包中
        schema.setDefaultJavaPackageDao("test.greenDAO.dao");

        addEntity(schema);

//        String outDir = "../greendaodemo/src/main/java-gen";
        String outDir = "E:/WorkSpace/lbo/FrameTest/greendaodemo/src/main/java-gen";

        new DaoGenerator().generateAll(schema, outDir);

    }

    private static void addEntity(Schema schema) {
        Entity note = schema.addEntity("Note");
        note.addIdProperty().primaryKey().autoincrement();
        note.addStringProperty("name").notNull();
        note.addStringProperty("age");
        note.addDateProperty("date");
    }
}
