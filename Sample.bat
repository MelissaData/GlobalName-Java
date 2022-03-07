@echo off
mkdir target
javac -classpath "lib\gson-2.8.9.jar;" -d .\target .\src\main\java\com\melissadata\globalname\*.java .\src\main\java\com\melissadata\globalname\model\*.java .\src\main\java\com\melissadata\globalname\view\*.java
xcopy src\main\resources\ target\ /s /q
cd target
java -classpath "../lib\gson-2.8.9.jar;" com.melissadata.globalname.Main com.melissadata.globalname.view.GlobalNameController com.melissadata.globalname.view.RootLayoutController com.melissadata.globalname.model.GlobalNameOptions com.melissadata.globalname.model.GlobalNameTransaction
cd ..
rd .\target /s /q