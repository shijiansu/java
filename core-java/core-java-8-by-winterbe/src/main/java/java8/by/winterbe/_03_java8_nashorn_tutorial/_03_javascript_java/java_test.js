// 不支持变量的定义, 只支持方法
(function main(){
    javaClass();
    dataType();
    scriptObjectMirror();
    scriptObjectMirrorCallMethod();
})()

function getClass(){
    return 'su.shijian.java8.a_guide_to_java8.nashorn_javascript.javascript_java.Java'
}

function javaClass(){
    print('[javaClass]')
    var MyJavaClass = Java.type(getClass());
    var result = MyJavaClass.fun1('John Doe');
    print(result);
    // Hi there from Java, John Doe
    // greetings from java
}

function dataType(){
    print('[dataType]')
    // JavaScript原始类型转换为合适的Java包装类，而JavaScript原生对象会使用内部的适配器类来表示。
    // 要记住jdk.nashorn.internal中的类可能会有所变化，所以不应该在客户端面向这些类来编程。
    var MyJavaClass = Java.type(getClass());
    MyJavaClass.fun2(123); // class java.lang.Integer
    MyJavaClass.fun2(49.99); // class java.lang.Double
    MyJavaClass.fun2(true); // class java.lang.Boolean
    MyJavaClass.fun2("hi there") // class java.lang.String
    MyJavaClass.fun2(new Number(23)); // class jdk.nashorn.api.scripting.ScriptObjectMirror
    MyJavaClass.fun2(new Date()); // class jdk.nashorn.api.scripting.ScriptObjectMirror
    MyJavaClass.fun2(new RegExp()); // class jdk.nashorn.api.scripting.ScriptObjectMirror
    MyJavaClass.fun2({foo: 'bar'}); // class jdk.nashorn.api.scripting.ScriptObjectMirror
}

function scriptObjectMirror(){
    print('[scriptObjectMirror]')
    var MyJavaClass = Java.type(getClass());
    MyJavaClass.fun3({foo: 'bar',bar: 'foo'}); // Object: [foo, bar]
}

function scriptObjectMirrorCallMethod(){
    print('[scriptObjectMirrorCallMethod]')
    var Person = function (firstName, lastName) {
                     this.firstName = firstName;
                     this.lastName = lastName;
                     this.getFullName = function() {
                         return this.firstName + " " + this.lastName;
                     }
                 }
    var MyJavaClass = Java.type(getClass());
    var person1 = new Person("Peter", "Parker");
    MyJavaClass.fun4(person1); // Full Name is: Peter Parker
}

