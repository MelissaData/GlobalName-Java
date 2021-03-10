@echo off
javac -classpath ".\melissadata\globalname\org.apache.sling.commons.json-2.0.20.jar;" .\melissadata\globalname\*.java .\melissadata\globalname\view\*.java ./melissadata\globalname\model\*.java
java -classpath ".\melissadata\globalname\org.apache.sling.commons.json-2.0.20.jar;"; melissadata.globalname.Main melissadata.globalname.view.GlobalNameController melissadata.globalname.view.GlobalNameTransactionController melissadata.globalname.view.RootLayoutController melissadata.globalname.model.GlobalNameOption
del .\melissadata\globalname\*.class 
del .\melissadata\globalname\view\*.class 
del .\melissadata\globalname\model\*.class
pause