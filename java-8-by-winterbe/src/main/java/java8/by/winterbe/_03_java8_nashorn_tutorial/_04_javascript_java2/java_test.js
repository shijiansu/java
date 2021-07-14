// 不支持变量的定义, 只支持方法
(function main(){
    array()
    list()
    map()
    lambda()
    extend()
    call()
    javaBean()
    noBrace()
    bindAttribute()
    static()
    globalVar()
    importer()
    convertList()
    callSuper()
})()

function array(){
    print('[array]')
    // Get type of Array, 可以利用Java的类型
    var IntArray = Java.type("int[]");
    var array = new IntArray(5);
    array[0] = 5;
    array[1] = 4;
    array[2] = 3;
    array[3] = 2;
    array[4] = 1;

    try {
        array[5] = 23;
    } catch (e) {
        print(e.message); // Array index out of range: 5
    }

    array[0] = "17";
    print(array[0]); // 17

    array[0] = "wrong type";
    print(array[0]); // 0

    array[0] = "17.3";
    print(array[0]); // 17, 自动转换到整型
}

function list(){
    print('[list]')
    // Array
    var ArrayList = Java.type('java.util.ArrayList');
    var list = new ArrayList();
    list.add('a');
    list.add('b');
    list.add('c');
    for each (var el in list) print(el); // a, b, c
}

function map(){
    print('[map]')
    // Map
    var map = new java.util.HashMap();
    map.put('foo', 'val1');
    map.put('bar', 'val2');

    for each (var e in map.keySet()) print(e); // foo, bar
    for each (var e in map.values()) print(e); // val1, val2
}

function lambda(){
    print('[lambda]')
    // Lambda表达式和数据流
    var list2 = new java.util.ArrayList();
    list2.add("ddd2");
    list2.add("aaa2");
    list2.add("bbb1");
    list2.add("aaa1");
    list2.add("bbb3");
    list2.add("ccc");
    list2.add("bbb2");
    list2.add("ddd1");

    list2.stream()
        .filter(function(el) {return el.startsWith("aaa");})
        .sorted()
        .forEach(function(el) {print(el);}); // aaa1, aaa2
}

function extend(){
    print('[extend]')
    // 类的继承, Java类型可以由Java.extend轻易扩展。
    var Runnable = Java.type('java.lang.Runnable');
    var Printer = Java.extend(Runnable, {
        run: function() {
            print('printed from a separate thread');
        }
    });
    var Thread = Java.type('java.lang.Thread');
    new Thread(new Printer()).start();
    new Thread(function() {
        print('printed from another thread');
    }).start();
    // printed from a separate thread
    // printed from another thread
}

function call(){
    print('[call]')
    // 方法和函数可以通过点运算符或方括号运算符来调用
    var System = Java.type('java.lang.System');
    System.out.println(10); // 10
    System.out["println"](11.0); // 11.0
    System.out["println(double)"](12); // 12.0
}

function javaBean(){
    print('[javaBean]')
    // Java Beans
    var Date = Java.type('java.util.Date');
    var date = new Date();
    date.year += 1900;
    print(date.year);  // 2014
}

function noBrace(){
    print('[noBrace]')
    // 函数字面值, 对于简单的单行函数，我们可以去掉花括号
    function sqr(x) x * x;
    print(sqr(3)); // 9
}

function bindAttribute(){
    print('[bindAttribute]')
    // 属性绑定, 两个不同对象的属性可以绑定到一起
    var o1 = {};
    var o2 = { foo: 'bar'};
    Object.bindProperties(o1, o2);
    print(o1.foo); // bar
    o1.foo = 'BAM';
    print(o2.foo); // BAM
}

function static(){
    print('[static]')
    // 调用静态方法, 字符串去空白
    print("   hehe".trimLeft()); // hehe
    print("hehe    ".trimRight() + "he"); // hehehe
}

function globalVar(){
    print('[globalVar]')
    // 位置
    print(__FILE__, __LINE__, __DIR__);
}

function importer(){
    print('[importer]')
    // 导入多个Java包, 使用JavaImporter类，和with关键字一起使用。
    // 所有被导入包的类文件都可以在with语句的局部域中访问到。
    var imports = new JavaImporter(java.io, java.lang);
    with (imports) {
        var file = new File(__FILE__);
        System.out.println(file.getAbsolutePath()); // /path/to/my/script.js
    }
}

function convertList(){
    print('[convertList]')
    // 数组转换
    var list = new java.util.ArrayList();
    list.add("s1");
    list.add("s2");
    list.add("s3");

    // 下面的代码将Java列表转换为JavaScript原生数组
    var jsArray = Java.from(list);
    print(jsArray); // s1,s2,s3
    print(Object.prototype.toString.call(jsArray)); // [object Array]

    // 下面的代码执行相反操作
    var javaArray = Java.to([3, 5, 7, 11], "int[]");
}

function callSuper(){
    // 访问超类, 在JavaScript中访问被覆盖的成员通常比较困难，
    // 因为Java的super关键字在ECMAScript中并不存在。
    var SuperRunner = Java.type('su.shijian.java8.a_guide_to_java8.nashorn_javascript.javascript_java2.SuperRunner');
    var Runner = Java.extend(SuperRunner);
    var runner = new Runner() {
        run: function() { // override
            // Java.super() here
            Java.super(runner).run();
            print('on my run');
        }
    }
    runner.run();
    // super run
    // on my run
}