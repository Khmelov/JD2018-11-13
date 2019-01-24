package by.it.seroglazov.jd03_03;

public interface MyConstants {
    String userDirPath = System.getProperty("user.dir");
    String thisPackagePath = userDirPath + "/src/by/it/seroglazov/jd03_03/";
    String configFileFullName = thisPackagePath + "xml/config.xml";
    String xsdSchemaFileName = thisPackagePath + "xml/recipes.xsd";
    String xmlRecipesFileName = thisPackagePath + "xml/recipes.xml";
}
