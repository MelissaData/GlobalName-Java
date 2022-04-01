@echo off
cd target
java -classpath "lib\gson-2.8.9.jar;" com.melissadata.globalname.Main com.melissadata.globalname.view.GlobalNameController com.melissadata.globalname.view.RootLayoutController com.melissadata.globalname.model.GlobalNameOptions com.melissadata.globalname.model.GlobalNameTransaction
cd ..