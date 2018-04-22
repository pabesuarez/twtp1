@echo off
call mvn clean install -Dmaven.test.skip=true
call mvn -Dwtpversion=2.0 eclipse:eclipse
echo.
echo "click derecho sobre el proyecto -> Maven -> Update Proyect"
echo.
pause