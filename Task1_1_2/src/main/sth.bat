javac -d .\out .\java\org\example\Main.java .\java\org\example\Polynoms.java
javadoc -d .\javadoc .\java\org\example\Main.java .\java\org\example\Polynoms.java
cd .\out
java -classpath . org/example.Main
pause