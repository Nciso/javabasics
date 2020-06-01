```
$ mkdir out
$ javac -d out Student.java StudentSortSearch.java
$ javac -d out -cp out:junit-platform-console-standalone-1.7.0-M1-javadoc.jar TestClass.java
$ java -jar junit-platform-console-standalone-1.3.1.jar --class-path out --scan-class-path
╷
├─ JUnit Jupiter ✔
│  └─ TestClass ✔
│     └─ test() ✔
└─ JUnit Vintage ✔

Test run finished after 67 ms
...
```


javac -cp junit-platform-console-standalone-1.7.0-M1.jar TripleStep.java

java -jar junit-platform-console-standalone-1.7.0-M1.jar -cp ./TripleStep --scan-classpath


javac -cp junit-platform-console-standalone-1.5.2.jar TripleStep.java

java -jar junit-platform-console-standalone-1.5.2.jar -cp ./TripleStep --scan-classpath


java -jar junit-platform-console-standalone-1.5.2.jar \
     --classpath TripleStep  \
     --select-class example.DisplayNameDemo \
     --include-classname '.*'
cle