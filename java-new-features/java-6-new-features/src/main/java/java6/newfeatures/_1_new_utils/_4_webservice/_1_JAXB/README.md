
运行命令 xjc workcontactinfo.xsd。将会在当前目录下生成一个 generated 子目录。

```shell script
xjc -p shijian.se06.new_WebService.JAXB.generated workcontactinfo.xsd
```

运行命令 javac generated\*.java，编译所有生成的 Java 文件。

为generated.Workcontactinfo"添加@XmlRootElement注解.
