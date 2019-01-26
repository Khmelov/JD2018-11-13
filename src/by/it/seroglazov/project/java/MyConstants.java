package by.it.seroglazov.project.java;

public interface MyConstants {
    String userDirPath = System.getProperty("user.dir");
    String thisPackagePath = userDirPath + "/src/by/it/seroglazov/project/java/";
    String configFileFullName = thisPackagePath + "dao/xml/config.xml";
    String xsdSchemaFileName = thisPackagePath + "dao/xml/recipes.xsd";
    String xmlRecipesFileName = thisPackagePath + "dao/xml/recipes.xml";
}
