javac ClassPath.java
mkdir mysubclass
mv AAA.class ./mysubclass
mv BBB.class ./mysubclass
export classpath=".;./mysubclass"
java ClassPath