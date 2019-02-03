package by.it.seroglazov.project.java.controller;

public interface Patterns {
    String login = "[^; '`]{3,}";
    String password = "[^; '`]{3,}";
    String email="[^; '`]{3,}";
    String cocktailName = "[^;'`]+";
    String cocktailType = "[^;'`]+";
    String description = "[^;'`]*";
    String ingredientName = "[^;'`]*";
    String amount = "[^;'`]*";
    String unit = "[^;'`]*";


}
