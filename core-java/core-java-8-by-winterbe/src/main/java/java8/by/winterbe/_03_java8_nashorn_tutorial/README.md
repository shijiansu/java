
```shell
$ cd /usr/bin
$ ln -s $JAVA_HOME/bin/jjs jjs
$ jjs
jjs> print('Hello World');
```
命令行脚本

如果你对编写命令行（shell）脚本感兴趣，
来试一试Nake吧。Nake是一个Java 8 Nashron的简化构建工具。
你只需要在项目特定的Nakefile中定义任务，
之后通过在命令行键入nake -- myTask来执行这些任务。
任务编写为JavaScript，并且在Nashron的脚本模式下运行，
所以你可以使用你的终端、JDK8 API和任意Java库的全部功能。
