@echo off
@echo При неободимости вам нужно подставить тут свои пути

@echo исправьте три пути 1) к JDK 2) к src 3) к xsd
@echo обратите внимание, что слеши в конце не нужны
@echo ну и конечно, на linux будет совершенно другой синтаксис

set path_xjc="C:\Program Files\Java\jdk1.8.0_111\bin\xjc.exe"
set path_to_src="D:\students\akhmelev\JD2017-02-20\src"
set file_xcd="D:\students\akhmelev\JD2017-02-20\src\by\it\_examples_\jd02_09\generate\xml_schema.xsd"

:: Пути могут быть и абсолютными, вроде таких
:: set path_xjc="H:\Program Files\Java\jdk1.8.0_101\bin\xjc.exe"
:: set path_to_src="C:\JavaProjects\JD2017-02-20\src"
:: set file_xcd="C:\JavaProjects\JD2017-02-20\src\by\it\akhmelev\jd02_09\generate\xml_schema.xsd"
:: :: - это комментарий

@echo формируем команду (все три переменные - в одну строку)
@echo Команда будет такой: %path_xjc% %file_xcd% -d %path_to_src%

@echo on
%path_xjc% %file_xcd% -d %path_to_src%