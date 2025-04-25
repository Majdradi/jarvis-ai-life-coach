@echo off

rem -----------------------------------------------------------------------------
rem Gradle startup script for Windows
rem -----------------------------------------------------------------------------

setlocal

set DIR=%~dp0
set APP_BASE_NAME=%~n0
set APP_HOME=%DIR%

set DEFAULT_JVM_OPTS=

rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto execute

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.
exit /b 1

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%\\bin\\java.exe

if exist "%JAVA_EXE%" goto execute

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.
exit /b 1

:execute
set CLASSPATH=

set GRADLE_HOME=%APP_HOME%
set GRADLE_OPTS=%DEFAULT_JVM_OPTS% %GRADLE_OPTS%

"%JAVA_EXE%" %GRADLE_OPTS% -classpath "%APP_HOME%\\gradle\\wrapper\\gradle-wrapper.jar" org.gradle.wrapper.GradleWrapperMain %*

endlocal
