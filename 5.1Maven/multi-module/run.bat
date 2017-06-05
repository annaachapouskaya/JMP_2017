call env.bat
call mvn clean
call mvn install
cd %~dp0webapp
call mvn tomcat7:run