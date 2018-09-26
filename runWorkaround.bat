@ECHO OFF

ECHO FetchWorkaround.java will be compiled and run...

javac -cp ".;./lib/bcprov-jdk15on-1.60.jar" FetchWorkaround.java
java -classpath ".;./lib/bcprov-jdk15on-1.60.jar" FetchWorkaround
